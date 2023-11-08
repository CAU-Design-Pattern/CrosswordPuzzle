package views;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public final class TitleView extends JPanel {
    // TitleView 의  Width
    private static final int WIDTH = 1400;

    // TitleView 의 Height
    private static final int HEIGHT = 700;

    // TitleView 의 2개의 버튼: 로그인, 회원가입
    final JButton[] buttons;

    public TitleView() {
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
        buttons[0].setText("로그인");
        buttons[0].setBounds(600, 400, 200, 80);
        buttons[1].setText("회원가입");
        buttons[1].setBounds(600, 500, 200, 80);

        setLayout(null);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
}
