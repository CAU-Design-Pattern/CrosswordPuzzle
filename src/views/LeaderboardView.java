package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class LeaderboardView extends JPanel {
	// LeaderboardView 의  Width
    private static final int WIDTH = 1400;

    // LeaderboardView 의 Height
    private static final int HEIGHT = 700;

    // LeaderboardView 의 BackButton
    private final JButton backButton;
    
    // 화면 이미지
    private final JLabel image;
    private final ImageIcon icon;

    public LeaderboardView() {
        Font font = new Font("Serif", Font.BOLD, 25);

        backButton = new JButton();
        backButton.setContentAreaFilled(false);
        backButton.setBorder(new LineBorder(Color.WHITE, 2));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(font);
        backButton.setText("Go Back");
        backButton.setBounds(1180, 20, 200, 80);
        add(backButton);
        
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
    	return backButton;
    }
}
