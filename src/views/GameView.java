package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.*;
import models.*;

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
    private final JLabel horizontalWord;
    private final JLabel verticalWord;
    
    private final JButton submitButton;

    public GameView() {
    	Font font = new Font("Default", Font.BOLD, 20);
    	
    	// 게임의 난이도 표시
    	levelLabel = new JLabel("LEVEL ?");
    	levelLabel.setFont(font);
    	levelLabel.setHorizontalAlignment(JLabel.CENTER);
    	levelLabel.setForeground(Color.WHITE);
    	levelLabel.setBackground(Color.GREEN);
    	levelLabel.setOpaque(true);
    	levelLabel.setBounds(1260, 20, 120, 50);
    	add(levelLabel);
    	
    	// 게임의 남은 시간 표시
    	timeLabel = new JLabel("남은 시간");
    	timeLabel.setFont(font);
    	timeLabel.setHorizontalAlignment(JLabel.CENTER);
    	timeLabel.setForeground(Color.WHITE);
    	timeLabel.setBackground(Color.GREEN);
    	timeLabel.setOpaque(true);
    	timeLabel.setBounds(1260, 80, 120, 35);
    	add(timeLabel);
    	
    	timeStampLabel = new JLabel("05:00");
    	timeStampLabel.setFont(font);
    	timeStampLabel.setHorizontalAlignment(JLabel.CENTER);
    	timeStampLabel.setForeground(Color.WHITE);
    	timeStampLabel.setBackground(Color.GREEN);
    	timeStampLabel.setOpaque(true);
    	timeStampLabel.setBounds(1260, 115, 120, 35);
    	add(timeStampLabel);
    	
    	// 제출 버튼
    	submitButton = new JButton("제출");
    	submitButton.setFont(font);
    	submitButton.setContentAreaFilled(true);
    	submitButton.setBorder(new BevelBorder(BevelBorder.RAISED));
    	submitButton.setForeground(Color.WHITE);
    	submitButton.setBackground(Color.GREEN);
    	submitButton.setBounds(1260, 640, 120, 40);
    	add(submitButton);
    	
    	// 세로 구분선
    	JLabel verticalLine = new JLabel();
    	verticalLine.setBackground(Color.BLACK);
    	verticalLine.setOpaque(true);
    	verticalLine.setBounds(1235, 0, 3, 700);
    	add(verticalLine);
    	
    	// 게임과 설명란 사이의 구분선
    	JLabel horizontalLine = new JLabel();
    	horizontalLine.setBackground(Color.BLACK);
    	horizontalLine.setOpaque(true);
    	horizontalLine.setBounds(0, 460, 1235, 3);
    	add(horizontalLine);
    	
    	// 설명란 내부의 구분선
    	JLabel innerHorizontalLine = new JLabel();
    	innerHorizontalLine.setBackground(Color.BLACK);
    	innerHorizontalLine.setOpaque(true);
    	innerHorizontalLine.setBounds(0, 580, 1235, 3);
    	add(innerHorizontalLine);
    	
    	// 가로 설명란
    	JLabel horizontalLabel = new JLabel("가로");
    	horizontalLabel.setFont(font);
    	horizontalLabel.setForeground(Color.BLACK);
    	horizontalLabel.setBackground(Color.WHITE);
    	horizontalLabel.setOpaque(true);
    	horizontalLabel.setBounds(0, 465, 1235, 20);
    	add(horizontalLabel);
    	
    	// 세로 설명란
    	JLabel verticalLabel = new JLabel("세로");
    	verticalLabel.setFont(font);
    	verticalLabel.setForeground(Color.BLACK);
    	verticalLabel.setBackground(Color.WHITE);
    	verticalLabel.setOpaque(true);
    	verticalLabel.setBounds(0, 585, 1235, 20);
    	add(verticalLabel);
    	
    	// 가로 설명란
    	horizontalWord = new JLabel("");
    	horizontalWord.setFont(font);
    	horizontalWord.setVerticalAlignment(JLabel.NORTH);
    	horizontalWord.setForeground(Color.BLACK);
    	horizontalWord.setBackground(Color.WHITE);
    	horizontalWord.setOpaque(true);
    	horizontalWord.setBounds(0, 485, 1235, 95);
    	add(horizontalWord);
    	
    	// 세로 설명란
    	verticalWord = new JLabel();
    	verticalWord.setFont(font);
    	verticalWord.setVerticalAlignment(JLabel.NORTH);
    	verticalWord.setForeground(Color.BLACK);
    	verticalWord.setBackground(Color.WHITE);
    	verticalWord.setOpaque(true);
    	verticalWord.setBounds(0, 605, 1235, 95);
    	add(verticalWord);
    	
    	// 게임의 timer
    	gameTimer = GameTimer.getInstance();
    	gameTimer.addObserver(this);
    	
        setLayout(null);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    public void startGame(CrosswordGame crosswordGame) {
    	this.crosswordGame = crosswordGame;
    	this.crosswordGame.play();
    	this.levelLabel.setText(crosswordGame.getLevel());
    	this.timeStampLabel.setText(gameTimer.getTimeStamp());
    	
    	char[][] board = this.crosswordGame.getBoard();
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			if (board[i][j] != ' ') {
    				JTextField textField = new JTextField(" ");
    				textField.setDocument(new LengthRestrictedDocument(1));
    				textField.setHorizontalAlignment(JTextField.CENTER);
    				textField.setBackground(Color.WHITE);
    				textField.setOpaque(true);
    				textField.setBounds(i * 30 + 5, j * 30 + 5, 25, 25);
    				textField.addMouseListener(new MouseAdapter() {
    					@Override
    					public void mouseClicked(MouseEvent e) {
    						// TODO
    						int x = e.getComponent().getX() / 30;
    						int y = e.getComponent().getY() / 30;
    						horizontalWord.setText("i: " + x + ", j: " + y);
    						verticalWord.setText("i: " + x + ", j: " + y);
    					}
    				});
    				add(textField);
    			} else {
    				JLabel label = new JLabel();
    				label.setBackground(Color.GRAY);
    				label.setOpaque(true);
    				label.setBounds(i * 30 + 5, j * 30 + 5, 25, 25);
    				add(label);
    			}
    		}
    	}
    }
    
    public void stopGame() {
    	this.crosswordGame.stopGame();
    }
    
    public JButton getSubmitButton() {
    	return submitButton;
    }
    
    // 게임의 남은 시간을 실시간으로 표시
    @Override
	public void update(Observable obs, Object arg) {
		timeStampLabel.setText(gameTimer.getTimeStamp());
	}
    
    final class LengthRestrictedDocument extends PlainDocument {
    	private final int limit;
    	
    	public LengthRestrictedDocument(int limit) {
    		this.limit = limit;
    	}
    	
    	@Override
    	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
    		if (str == null) return;
    		if ((getLength() + str.length()) <= limit) {
    			super.insertString(offs, str, a);
    		}
    	}
    	
    	
    }
}