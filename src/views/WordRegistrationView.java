package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.LineBorder;

import util.LengthRestrictedDocument;

public class WordRegistrationView extends JPanel {
	// WordRegistrationView 의  Width
    private static final int WIDTH = 1400;

    // WordRegistrationView 의 Height
    private static final int HEIGHT = 700;

    // WordRegistrationView 의 3개의 버튼: 이전으로, import, 등록
    private final JButton[] buttons;
    
    // 화면 이미지
    private final JLabel image;
    private final ImageIcon icon;
    
    // 단어 등록 테이블
    private final JLabel wordTable;
    private final JLabel[] wordColumns;
    private final JTextField[] words;

    public WordRegistrationView() {
        Font font = new Font("Serif", Font.BOLD, 25);

        buttons = new JButton[3];
        for (int i = 0; i < 3; i++) {
            buttons[i] = new JButton();
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorder(new LineBorder(Color.WHITE, 2));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setFont(font);
            add(buttons[i]);
        }
        buttons[0].setText("Go Back");
        buttons[0].setBounds(1180, 20, 200, 80);
        buttons[1].setText("Import");
        buttons[1].setBounds(1180, 500, 200, 80);
        buttons[2].setText("Register");
        buttons[2].setBounds(1180, 600, 200, 80);
        
        // 단어 테이블
        wordTable = new JLabel();
    	wordTable.setBackground(new Color(255, 255, 255, 100));
    	wordTable.setOpaque(true);
    	wordTable.setBounds(20, 250, 1140, 165);
    	add(wordTable);
    	
    	wordColumns = new JLabel[3];
    	for (int i = 0; i < wordColumns.length; i++) {
    		wordColumns[i] = new JLabel();
    		wordColumns[i].setFont(font);
    		wordColumns[i].setHorizontalAlignment(JLabel.CENTER);
    		wordColumns[i].setForeground(Color.BLACK);
    		wordColumns[i].setBackground(new Color(255, 255, 255, 255));
    		wordColumns[i].setOpaque(true);
    		add(wordColumns[i]);
    	}
		wordColumns[0].setText("Word");
		wordColumns[0].setBounds(50, 270, 180, 60);
		wordColumns[1].setText("Level");
		wordColumns[1].setBounds(250, 270, 130, 60);
		wordColumns[2].setText("Discription");
		wordColumns[2].setBounds(400, 270, 730, 60);
		
		words = new JTextField[3];
		for (int i = 0; i < words.length; i++) {
			words[i] = new JTextField();
			words[i].setFont(new Font("Serif", Font.PLAIN, 20));
			words[i].setHorizontalAlignment(JLabel.CENTER);
			words[i].setForeground(Color.BLACK);
			words[i].setBackground(Color.WHITE);
			words[i].setOpaque(true);
			add(words[i]);
		}
		words[0].setBounds(50, 350, 180, 45);
		words[1].setBounds(250, 350, 130, 45);
		words[2].setBounds(400, 350, 730, 45);
		words[0].setDocument(new LengthRestrictedDocument(15));
		words[1].setDocument(new LengthRestrictedDocument(1));
		
        image = new JLabel();
    	icon = new ImageIcon("resources/background.jpg");
    	image.setIcon(icon);
    	image.setBounds(0, 0, WIDTH, HEIGHT);
    	add(image);
        
        setLayout(null);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    public void clear() {
    	for (int i = 0; i < words.length; i++) {
    		words[i].setText("");
    	}
    }
    
    public JButton getBackButton() {
    	return buttons[0];
    }
    
    public JButton getImportButton() {
    	return buttons[1];
    }
    
    public JButton getRegistrationButton() {
    	return buttons[2];
    }
    
    public String[] getWord() {
    	String[] result = new String[wordColumns.length];
    	for (int i = 0; i < wordColumns.length; i++) {
    		result[i] = words[i].getText();
    	}
    	return result;
    }
}
