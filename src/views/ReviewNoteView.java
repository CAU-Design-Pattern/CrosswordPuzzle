package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class ReviewNoteView extends JPanel {
	// ReviewNoteView 의  Width
    private static final int WIDTH = 1400;

    // ReviewNoteView 의 Height
    private static final int HEIGHT = 700;

    // ReviewNoteView 의 BackButton
    private final JButton backButton;

    public ReviewNoteView() {
        Font font = new Font("Default", Font.BOLD, 20);

        backButton = new JButton();
        backButton.setContentAreaFilled(true);
        backButton.setBorder(new BevelBorder(BevelBorder.RAISED));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.GREEN);
        backButton.setFont(font);
        backButton.setText("이전으로");
        backButton.setBounds(1180, 20, 200, 80);
        add(backButton);
        
        setLayout(null);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    public JButton getBackButton() {
    	return backButton;
    }
}
