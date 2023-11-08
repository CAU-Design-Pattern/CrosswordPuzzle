package views;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class HomeView extends JPanel {
    // HomeView 의  Width
    private static final int WIDTH = 1400;

    // HomeView 의 Height
    private static final int HEIGHT = 700;
    
    // HomeView 의 5개의 버튼: 로그 아웃, 게임 시작, 리더보드, 단어 등록, 오답 노트
    private JButton[] buttons;

    public HomeView() {
    	Font font = new Font("Default", Font.BOLD, 20);

        buttons = new JButton[5];
        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton();
            buttons[i].setContentAreaFilled(true);
            buttons[i].setBorder(new BevelBorder(BevelBorder.RAISED));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setBackground(Color.GREEN);
            buttons[i].setFont(font);
            add(buttons[i]);
        }
        buttons[0].setText("로그 아웃");
        buttons[0].setBounds(1180, 20, 200, 80);
        buttons[1].setText("게임 시작");
        buttons[1].setBounds(600, 300, 200, 80);
        buttons[2].setText("리더보드");
        buttons[2].setBounds(600, 400, 200, 80);
        buttons[3].setText("단어 등록");
        buttons[3].setBounds(600, 500, 200, 80);
        buttons[4].setText("오답 노트");
        buttons[4].setBounds(600, 600, 200, 80);
        
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
    
    public JButton getReviewNoteButton() {
    	return buttons[4];
    }
}
