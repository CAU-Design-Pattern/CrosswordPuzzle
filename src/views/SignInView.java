package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SignInView extends JPanel {
	// SignUpView 의  Width
    private static final int WIDTH = 1400;

    // SignUpView 의 Height
    private static final int HEIGHT = 700;

    // SignUpView 의 2개의 버튼: 이전으로, 로그인
    private final JButton[] buttons;
    
    // 화면 이미지
    private final JLabel image;
    private final ImageIcon icon;
    
    // 로그인 테이블
    private final JLabel signInTable;
    private final JLabel[] accountColumns;
    private final JTextField[] accountInfos;

    public SignInView() {
        Font font = new Font("Serif", Font.BOLD, 25);

        buttons = new JButton[2];
        for (int i = 0; i < 2; i++) {
            buttons[i] = new JButton();
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorder(new LineBorder(Color.WHITE, 2));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setFont(font);
            add(buttons[i]);
        }
        buttons[0].setText("Go Back");
        buttons[0].setBounds(1180, 20, 200, 80);
        buttons[1].setText("Sign In");
        buttons[1].setBounds(1180, 600, 200, 80);
        
        // 로그인 테이블
        signInTable = new JLabel();
        signInTable.setBackground(new Color(255, 255, 255, 100));
        signInTable.setOpaque(true);
        signInTable.setBounds(20, 250, 1140, 165);
        add(signInTable);
        
        accountColumns = new JLabel[2];
        for (int i = 0; i < accountColumns.length; i++) {
        	accountColumns[i] = new JLabel();
        	accountColumns[i].setFont(font);
        	accountColumns[i].setHorizontalAlignment(JLabel.CENTER);
        	accountColumns[i].setForeground(Color.BLACK);
        	accountColumns[i].setBackground(Color.WHITE);
        	accountColumns[i].setOpaque(true);
        	add(accountColumns[i]);
        }
        accountColumns[0].setText("ID");
        accountColumns[0].setBounds(40, 270, 530, 60);
        accountColumns[1].setText("Password");
        accountColumns[1].setBounds(590, 270, 530, 60);
        
        accountInfos = new JTextField[2];
        for (int i = 0; i < accountInfos.length; i++) {
        	accountInfos[i] = new JTextField();
        	accountInfos[i].setFont(new Font("Serif", Font.PLAIN, 20));
        	accountInfos[i].setHorizontalAlignment(JLabel.CENTER);
        	accountInfos[i].setForeground(Color.BLACK);
        	accountInfos[i].setBackground(Color.WHITE);
        	accountInfos[i].setOpaque(true);
        	accountInfos[i].setBounds(i * 550 + 40, 350, 530, 45);
        	add(accountInfos[i]);
        }

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
    
    public JButton getSignInButton() {
    	return buttons[1];
    }
    
    public String[] getAccountData() {
    	return new String[] { accountInfos[0].getText(), accountInfos[1].getText() };
    }
    
    public void clear() {
    	for (int i = 0; i < accountInfos.length; i++) {
    		accountInfos[i].setText("");
    	}
    }
}