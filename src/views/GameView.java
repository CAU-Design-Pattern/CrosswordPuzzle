package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.*;

import com.holub.database.Database;
import com.holub.text.ParseFailure;

import connector.DatabaseConnector;
import factory.WordInfo;
import models.*;
import repository.RankRepository;
import repository.WordRepository;
import service.RankService;
import service.WordService;
import util.LengthRestrictedDocument;

public class GameView extends JPanel implements Observer {
	// GameView 의  Width
    private static final int WIDTH = 1400;

    // GameView 의 Height
    private static final int HEIGHT = 700;
    
    // 게임의 난이도
    private final JLabel levelLabel;
    
    // 게임의 남은 시간
    private final JLabel timeLabel;
    private final JLabel timeStampLabel;
    
    // 게임 화면의 삽자말풀이 게임
    private CrosswordGame crosswordGame;
    
    // 게임 화면의 남은 시간
    private GameTimer gameTimer;
    
    // 십자말풀이 게임의 설명란
    private final JLabel acrossWord;
    private final JLabel downWord;
    
    // 게임의 남은 힌트
    private final JLabel hintLabel;
    private final JButton hintButton;
    
    // 제출 버튼
    private final JButton submitButton;
    
    // 게임의 보드 화면
    private final JPanel boardPanel;
    
    // 보드의 입력칸
    private JTextField[][] boardField;
    
    // 보드의 좌표
    private int x;
    private int y;
    
    // 화면 이미지
    private final JLabel image;
    private final ImageIcon icon;

    public GameView() {
    	Font font = new Font("Serif", Font.BOLD, 20);
    	
    	// 게임의 난이도 표시
    	levelLabel = new JLabel("LEVEL ?");
    	levelLabel.setFont(font);
    	levelLabel.setHorizontalAlignment(JLabel.CENTER);
    	levelLabel.setForeground(Color.BLACK);
    	levelLabel.setBackground(Color.WHITE);
    	levelLabel.setOpaque(true);
    	levelLabel.setBounds(1218, 20, 172, 50);
    	add(levelLabel);
    	
    	// 게임의 남은 시간 표시
    	timeLabel = new JLabel("Time Remaining");
    	timeLabel.setFont(font);
    	timeLabel.setHorizontalAlignment(JLabel.CENTER);
    	timeLabel.setForeground(Color.BLACK);
    	timeLabel.setBackground(Color.WHITE);
    	timeLabel.setOpaque(true);
    	timeLabel.setBounds(1218, 80, 172, 35);
    	add(timeLabel);
    	
    	timeStampLabel = new JLabel();
    	timeStampLabel.setFont(font);
    	timeStampLabel.setHorizontalAlignment(JLabel.CENTER);
    	timeStampLabel.setForeground(Color.BLACK);
    	timeStampLabel.setBackground(Color.WHITE);
    	timeStampLabel.setOpaque(true);
    	timeStampLabel.setBounds(1218, 116, 172, 35);
    	add(timeStampLabel);
    	
    	hintLabel = new JLabel("Hint Remaining");
    	hintLabel.setFont(font);
    	hintLabel.setHorizontalAlignment(JLabel.CENTER);
    	hintLabel.setForeground(Color.BLACK);
    	hintLabel.setBackground(Color.WHITE);
    	hintLabel.setOpaque(true);
    	hintLabel.setBounds(1218, 161, 172, 35);
    	add(hintLabel);
    	
    	hintButton = new JButton("3");
    	hintButton.setFont(font);
    	hintButton.setContentAreaFilled(true);
    	hintButton.setBorder(new LineBorder(Color.WHITE, 1));
    	hintButton.setForeground(Color.BLACK);
    	hintButton.setBackground(new Color(200, 200, 200, 255));
    	hintButton.setBounds(1218, 197, 172, 35);
    	hintButton.setEnabled(false);
    	add(hintButton);
    	
    	// 제출 버튼
    	submitButton = new JButton("Submit");
    	submitButton.setFont(font);
    	submitButton.setContentAreaFilled(false);
    	submitButton.setBorder(new LineBorder(Color.WHITE, 2));
    	submitButton.setForeground(Color.WHITE);
    	submitButton.setBounds(1218, 600, 172, 80);
    	add(submitButton);
    	
    	// 세로 구분선
    	JLabel verticalLine = new JLabel();
    	verticalLine.setBackground(Color.WHITE);
    	verticalLine.setOpaque(true);
    	verticalLine.setBounds(1205, 0, 3, 700);
    	add(verticalLine);
    	
    	// 게임과 설명란 사이의 구분선
    	JLabel horizontalLine = new JLabel();
    	horizontalLine.setBackground(Color.WHITE);
    	horizontalLine.setOpaque(true);
    	horizontalLine.setBounds(0, 460, 1205, 3);
    	add(horizontalLine);
    	
    	// 설명란 내부의 구분선
    	JLabel innerHorizontalLine = new JLabel();
    	innerHorizontalLine.setBackground(Color.WHITE);
    	innerHorizontalLine.setOpaque(true);
    	innerHorizontalLine.setBounds(0, 580, 1205, 3);
    	add(innerHorizontalLine);
    	
    	// 가로 설명란
    	JLabel horizontalLabel = new JLabel("Across");
    	horizontalLabel.setFont(font);
    	horizontalLabel.setForeground(Color.BLACK);
    	horizontalLabel.setBackground(Color.WHITE);
    	horizontalLabel.setOpaque(true);
    	horizontalLabel.setBounds(5, 470, 1195, 20);
    	add(horizontalLabel);
    	
    	// 세로 설명란
    	JLabel verticalLabel = new JLabel("Down");
    	verticalLabel.setFont(font);
    	verticalLabel.setForeground(Color.BLACK);
    	verticalLabel.setBackground(Color.WHITE);
    	verticalLabel.setOpaque(true);
    	verticalLabel.setBounds(5, 590, 1195, 20);
    	add(verticalLabel);
    	
    	// 가로 설명란
    	acrossWord = new JLabel("");
    	acrossWord.setFont(font);
    	acrossWord.setVerticalAlignment(JLabel.NORTH);
    	acrossWord.setForeground(Color.BLACK);
    	acrossWord.setBackground(Color.WHITE);
    	acrossWord.setOpaque(true);
    	acrossWord.setBounds(5, 490, 1195, 85);
    	add(acrossWord);
    	
    	// 세로 설명란
    	downWord = new JLabel();
    	downWord.setFont(font);
    	downWord.setVerticalAlignment(JLabel.NORTH);
    	downWord.setForeground(Color.BLACK);
    	downWord.setBackground(Color.WHITE);
    	downWord.setOpaque(true);
    	downWord.setBounds(5, 610, 1195, 85);
    	add(downWord);
    	
    	// 게임의 timer
    	gameTimer = GameTimer.getInstance();
    	gameTimer.addObserver(this);
    	
    	// 게임의 보드 화면
    	boardPanel = new JPanel();
    	boardPanel.setOpaque(false);
    	boardPanel.setBounds(0, 0, 1235, 460);
    	boardPanel.setLayout(null);
    	boardPanel.setFocusable(true);
    	add(boardPanel);
    	
    	image = new JLabel();
    	icon = new ImageIcon("resources/background.jpg");
    	image.setIcon(icon);
    	image.setBounds(0, 0, WIDTH, HEIGHT);
    	add(image);
    	
        setLayout(null);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    public void startGame(CrosswordGame crosswordGame) {
    	// 게임 시작 전 이미 있던 보드 삭제
    	boardPanel.removeAll();
    	
    	this.crosswordGame = crosswordGame;
    	this.crosswordGame.play();
    	levelLabel.setText(crosswordGame.getLevel());
    	timeStampLabel.setText(gameTimer.getTimeStamp());
    	hintButton.setText("" + crosswordGame.getHintCount());
    	acrossWord.setText("");
    	downWord.setText("");
    	
    	WordInfo[][] board = this.crosswordGame.getBoard();
    	boardField = new JTextField[board.length][board[0].length];
    	int offset = 0;
    	if (crosswordGame.getLevel().equals("LEVEL 1")) {
    		offset = 300;
    	} else if (crosswordGame.getLevel().equals("LEVEL 2")) {
    		offset = 150;
    	}
    	
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			if (board[i][j].getLetter() != '*') {
    				JTextField textField = new JTextField(" ");
    				textField.setDocument(new LengthRestrictedDocument(1));
    				textField.setHorizontalAlignment(JTextField.CENTER);
    				textField.setBackground(Color.WHITE);
    				textField.setOpaque(true);
    				textField.setBounds(offset + i * 30 + 5, j * 30 + 5, 25, 25);
    				textField.addMouseListener(new MouseAdapter() {
    					@Override
    					public void mousePressed(MouseEvent e) {
    						// TODO
    						int temp = 0;
    						if (crosswordGame.getLevel().equals("LEVEL 1")) {
    							temp = 300;
    						} else if (crosswordGame.getLevel().equals("LEVEL 2")) {
    							temp = 150;
    						}
    						x = (e.getComponent().getX() - temp) / 30;
    						y = e.getComponent().getY() / 30;
    						acrossWord.setText(crosswordGame.getBoard()[x][y].getAcrossDesc());
    						downWord.setText(crosswordGame.getBoard()[x][y].getDownDesc());
    						
    						if (crosswordGame.getHintCount() > 0) {
    							hintButton.setBackground(Color.WHITE);
    							hintButton.setEnabled(true);
    						}
    					}
    				});
    				boardPanel.add(textField);
    				boardField[i][j] = textField;
    			} else {
    				JTextField nullField = new JTextField();
    				nullField.setBackground(Color.GRAY);
    				nullField.setOpaque(true);
    				nullField.setBounds(offset + i * 30 + 5, j * 30 + 5, 25, 25);
    				nullField.setEnabled(false);
    				boardPanel.add(nullField);
    				boardField[i][j] = nullField;
    			}
    		}
    	}
    }
    
    public void useHint() {
    	int hintCount = crosswordGame.getHintCount();
    	if (hintCount > 0) {
    		hintCount--;
    		crosswordGame.setHintCount(hintCount);
    		hintButton.setBackground(new Color(200, 200, 200, 255));
    		hintButton.setText("" + hintCount);
    		boardField[x][y].setText("" + crosswordGame.getBoard()[x][y].getLetter());
    		boardField[x][y].setEnabled(false);
    	}
    	
    	hintButton.setEnabled(false);
    }
    
    public void stopGame() {
    	this.crosswordGame.stopGame();
    	
    	char[][] answer = new char[boardField.length][boardField[0].length];
    	for (int i = 0; i < answer.length; i++) {
    		for (int j = 0; j < answer[0].length; j++) {
    			if (!boardField[i][j].getText().isEmpty()) {
    				answer[i][j] = boardField[i][j].getText().charAt(0);
    			}
    		}
    	}
    	int score = crosswordGame.getResult(answer);
    	
    	Database db;
		try {
			DatabaseConnector dbConnector = DatabaseConnector.getInstance();
			db = dbConnector.getDatabase();
			db.dump();
		} catch (IOException e) {
			System.out.println("[DB Connection Error]");
			e.printStackTrace();
			db = null;
		} catch (ParseFailure e) {
			e.printStackTrace();
			db = null;
		}
		
		if (db != null) {
			RankService rankService = new RankService(new RankRepository(db));
			try {
				//rankService.saveRank("TEST20231126", score);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
    	JOptionPane.showMessageDialog(new JFrame(), "Your Score: " + score);
    }
    
    public JButton getHintButton() {
    	return hintButton;
    }
    
    public JButton getSubmitButton() {
    	return submitButton;
    }
    
    // 게임의 남은 시간을 실시간으로 표시
    @Override
	public void update(Observable obs, Object arg) {
    	timeStampLabel.setText(gameTimer.getTimeStamp());
		if (gameTimer.getTime() <= 0) {
			for (int i = 0; i < boardField.length; i++) {
				for (int j = 0; j < boardField[0].length; j++) {
					boardField[i][j].setEnabled(false);
				}
			}
			crosswordGame.setHintCount(0);
			hintButton.setText("0");
			hintButton.setEnabled(false);
			JOptionPane.showMessageDialog(new JFrame(), "Time Over!");
		}
	}
}