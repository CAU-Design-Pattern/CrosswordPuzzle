package views;

import models.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import models.CrosswordGame;

public class GameView extends JPanel {
	// GameView 의  Width
    private static final int WIDTH = 1400;

    // GameView 의 Height
    private static final int HEIGHT = 700;
    
    // 게임의 난이도
    private final JLabel levelLabel;
    
    // 게임의 남은 시간
    private final JLabel timeLabel;
    private final JLabel timeStampLabel;
    
    private CrosswordGame crosswordGame;
    
    /*
    // GameView 의 ?개의 버튼
    private JButton[] buttons;
    */

    public GameView() {
    	Font font = new Font("Default", Font.BOLD, 20);
    	
    	levelLabel = new JLabel("LEVEL ?");
    	levelLabel.setFont(font);
    	levelLabel.setHorizontalAlignment(JLabel.CENTER);
    	levelLabel.setForeground(Color.WHITE);
    	levelLabel.setBackground(Color.BLUE);
    	levelLabel.setOpaque(true);
    	levelLabel.setBounds(1260, 20, 120, 50);
    	add(levelLabel);
    	
    	timeLabel = new JLabel("남은 시간");
    	timeLabel.setFont(font);
    	timeLabel.setHorizontalAlignment(JLabel.CENTER);
    	timeLabel.setForeground(Color.WHITE);
    	timeLabel.setBackground(Color.BLUE);
    	timeLabel.setOpaque(true);
    	timeLabel.setBounds(1260, 80, 120, 35);
    	add(timeLabel);
    	
    	timeStampLabel = new JLabel("05:00");
    	timeStampLabel.setFont(font);
    	timeStampLabel.setHorizontalAlignment(JLabel.CENTER);
    	timeStampLabel.setForeground(Color.WHITE);
    	timeStampLabel.setBackground(Color.BLUE);
    	timeStampLabel.setOpaque(true);
    	timeStampLabel.setBounds(1260, 115, 120, 35);
    	add(timeStampLabel);
    	
    	JLabel verticalLine = new JLabel();
    	verticalLine.setBackground(Color.BLACK);
    	verticalLine.setOpaque(true);
    	verticalLine.setBounds(1235, 0, 5, 700);
    	add(verticalLine);
    	
    	JLabel horizontalLine = new JLabel();
    	horizontalLine.setBackground(Color.BLACK);
    	horizontalLine.setOpaque(true);
    	horizontalLine.setBounds(0, 460, 1235, 5);
    	add(horizontalLine);
    	
    	/*
        buttons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton();
            buttons[i].setContentAreaFilled(true);
            buttons[i].setBorder(new BevelBorder(BevelBorder.RAISED));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setBackground(Color.GREEN);
            buttons[i].setFont(font);
            add(buttons[i]);
        }
        buttons[0].setText("이전으로");
        buttons[0].setBounds(600, 160, 200, 80);
        buttons[1].setText("LEVEL 1");
        buttons[1].setBounds(600, 260, 200, 80);
        buttons[2].setText("LEVEL 2");
        buttons[2].setBounds(600, 360, 200, 80);
        buttons[3].setText("LEVEL 3");
        buttons[3].setBounds(600, 460, 200, 80);
        */
    	
        setLayout(null);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    public void setLevel(int level) {
    	levelLabel.setText("LEVEL: " + level);
    }
    
    public void prepareGame(CrosswordGame crosswordGame) {
    	this.crosswordGame = crosswordGame;
    	
    	// TODO
    	this.crosswordGame.play();
    	
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