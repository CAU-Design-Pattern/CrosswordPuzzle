package views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class HomeView extends JPanel {
    // HomeView 의  Width
    private static final int WIDTH = 1400;

    // HomeView 의 Height
    private static final int HEIGHT = 700;
    
    // HomeView 의 4개의 버튼: 로그 아웃, 게임 시작, 리더보드, 단어 등록
    private JButton[] buttons;
    
    // 화면 이미지
    private final JLabel image;
    private final ImageIcon icon;

    public HomeView() {
    	Font font = new Font("Serif", Font.BOLD, 25);

        buttons = new JButton[4];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorder(new LineBorder(Color.WHITE, 2));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setFont(font);
            add(buttons[i]);
        }
        buttons[0].setText("Sign Out");
        buttons[0].setBounds(1180, 20, 200, 80);
        buttons[1].setText("Start Game");
        buttons[1].setBounds(550, 210, 300, 80);
        buttons[2].setText("Leaderboard");
        buttons[2].setBounds(550, 310, 300, 80);
        buttons[3].setText("Add New Word");
        buttons[3].setBounds(550, 410, 300, 80);
        
        image = new JLabel();
    	icon = new ImageIcon("resources/background.jpg");
    	image.setIcon(icon);
    	image.setBounds(0, 0, WIDTH, HEIGHT);
    	add(image);
        
        setLayout(null);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    public JButton getSignOutButton() {
    	return buttons[0];
    }
    
    public JButton getStartGameButton() {
    	return buttons[1];
    }
    
    public JButton getLeaderboardButton() {
    	return buttons[2];
    }
    
    public JButton getWordRegistrationButton() {
    	return buttons[3];
    }
}
