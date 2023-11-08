package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class WordRegistrationView extends JPanel {
	// WordRegistrationView 의  Width
    private static final int WIDTH = 1400;

    // WordRegistrationView 의 Height
    private static final int HEIGHT = 700;

    // WordRegistrationView 의 3개의 버튼: 이전으로, import, 등록
    private final JButton[] buttons;

    public WordRegistrationView() {
        Font font = new Font("Default", Font.BOLD, 20);

        buttons = new JButton[3];
        for (int i = 0; i < 3; i++) {
            buttons[i] = new JButton();
            buttons[i].setContentAreaFilled(true);
            buttons[i].setBorder(new BevelBorder(BevelBorder.RAISED));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setBackground(Color.GREEN);
            buttons[i].setFont(font);
            add(buttons[i]);
        }
        buttons[0].setText("이전으로");
        buttons[0].setBounds(1180, 20, 200, 80);
        buttons[1].setText("Import");
        buttons[1].setBounds(20, 600, 200, 80);
        buttons[2].setText("등록");
        buttons[2].setBounds(1180, 600, 200, 80);
        
        setLayout(null);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
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
}
