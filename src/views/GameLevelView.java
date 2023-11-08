package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class GameLevelView extends JPanel {
	// GameLevelView 의  Width
    private static final int WIDTH = 1400;

    // GameLevelView 의 Height
    private static final int HEIGHT = 700;
    
    // GameLevelView 의 4개의 버튼: 이전으로, LEVEL 1, LEVEL 2, LEVEL 3
    private JButton[] buttons;

    public GameLevelView() {
    	Font font = new Font("Default", Font.BOLD, 20);

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
        
        setLayout(null);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    public JButton getBackButton() {
    	return buttons[0];
    }
    
    public JButton getLevel1Button() {
    	return buttons[1];
    }
    
    public JButton getLevel2Button() {
    	return buttons[2];
    }
    
    public JButton getLevel3Button() {
    	return buttons[3];
    }
}
