package views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public final class TitleView extends JPanel {
    // TitleView 의  Width
    private static final int WIDTH = 1400;

    // TitleView 의 Height
    private static final int HEIGHT = 700;
    
    // 화면 이미지
    private final JLabel image;
    private final ImageIcon icon;

    // 타이틀
    private final JLabel titleLabel;
    
    // TitleView 의 2개의 버튼: 로그인, 회원가입
    private final JButton[] buttons;

    public TitleView() {
    	Font font = new Font("Serif", Font.BOLD, 25);
    	
    	titleLabel = new JLabel("Crossword Puzzle");
    	titleLabel.setFont(new Font("Serif", Font.BOLD, 100));
    	titleLabel.setHorizontalAlignment(JLabel.CENTER);
    	titleLabel.setForeground(Color.WHITE);
    	titleLabel.setBounds(0, 300, 1400, 100);
    	add(titleLabel);

        buttons = new JButton[2];
        for (int i = 0; i < 2; i++) {
            buttons[i] = new JButton();
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorder(new LineBorder(Color.WHITE, 2));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setFont(font);
            add(buttons[i]);
        }
        buttons[0].setText("Sign In");
        buttons[0].setBounds(1180, 500, 200, 80);
        buttons[1].setText("Sign Up");
        buttons[1].setBounds(1180, 600, 200, 80);

        image = new JLabel();
    	icon = new ImageIcon("resources/background.jpg");
    	image.setIcon(icon);
    	image.setBounds(0, 0, WIDTH, HEIGHT);
    	add(image);
        
        setLayout(null);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    public JButton getSignInButton() {
    	return buttons[0];
    }
    
    public JButton getSignUpButton() {
    	return buttons[1];
    }
}
