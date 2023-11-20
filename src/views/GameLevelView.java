package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class GameLevelView extends JPanel {
	// GameLevelView 의  Width
    private static final int WIDTH = 1400;

    // GameLevelView 의 Height
    private static final int HEIGHT = 700;
    
    // GameLevelView 의 4개의 버튼: 이전으로, LEVEL 1, LEVEL 2, LEVEL 3
    private JButton[] buttons;
    
    // 화면 이미지
    private final JLabel image;
    private final ImageIcon icon;

    public GameLevelView() {
    	Font font = new Font("Serif", Font.BOLD, 25);

        buttons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton();
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorder(new LineBorder(Color.WHITE, 2));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setFont(font);
            add(buttons[i]);
        }
        buttons[0].setText("Go Back");
        buttons[0].setBounds(550, 160, 300, 80);
        buttons[1].setText("LEVEL 1");
        buttons[1].setBounds(550, 260, 300, 80);
        buttons[2].setText("LEVEL 2");
        buttons[2].setBounds(550, 360, 300, 80);
        buttons[3].setText("LEVEL 3");
        buttons[3].setBounds(550, 460, 300, 80);
        
        image = new JLabel();
    	icon = new ImageIcon("resources/background.jpg");
    	image.setIcon(icon);
    	image.setBounds(0, 0, WIDTH, HEIGHT);
    	add(image);
        
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
