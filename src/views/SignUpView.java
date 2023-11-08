package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class SignUpView extends JPanel {
	// SignUpView 의  Width
    private static final int WIDTH = 1400;

    // SignUpView 의 Height
    private static final int HEIGHT = 700;

    // SignUpView 의 2개의 버튼: 이전으로, 회원가입
    private final JButton[] buttons;

    public SignUpView() {
        Font font = new Font("Default", Font.BOLD, 20);

        buttons = new JButton[2];
        for (int i = 0; i < 2; i++) {
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
        buttons[1].setText("회원가입");
        buttons[1].setBounds(600, 500, 200, 80);

        setLayout(null);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    public JButton getBackButton() {
    	return buttons[0];
    }
    
    public JButton getSignUpButton() {
    	return buttons[1];
    }
}
