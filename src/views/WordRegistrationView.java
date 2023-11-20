package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.LineBorder;

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
        buttons[1].setBounds(20, 600, 200, 80);
        buttons[2].setText("Register");
        buttons[2].setBounds(1180, 600, 200, 80);
        
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
    
    public JButton getImportButton() {
    	return buttons[1];
    }
    
    public JButton getRegistrationButton() {
    	return buttons[2];
    }
}
