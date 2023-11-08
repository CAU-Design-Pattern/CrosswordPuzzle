package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

public class GameView extends JPanel {
	// GameView 의  Width
    private static final int WIDTH = 1400;

    // GameView 의 Height
    private static final int HEIGHT = 700;
    
    // 게임의 난이도
    private final JLabel levelLabel;
    
    /*
    // GameView 의 ?개의 버튼
    private JButton[] buttons;
    */

    public GameView() {
    	Font font = new Font("Default", Font.BOLD, 20);
    	
    	levelLabel = new JLabel("LEVEL ?");
    	levelLabel.setFont(font);
    	levelLabel.setForeground(Color.BLACK);
    	levelLabel.setBounds(1280, 0, 100, 80);
    	add(levelLabel);
    	
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
}