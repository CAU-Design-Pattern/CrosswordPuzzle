package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;
import com.holub.database.Database;
import com.holub.text.ParseFailure;
import connector.DatabaseConnector;
import dto.*;
import repository.*;

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
    
    // 리더보드 테이블
    private final JLabel leaderboardTable;
    private final JLabel[] leaderboardColumns;
    private final JLabel[][] ranks;
    
    public LeaderboardView() {
        Font font = new Font("Serif", Font.BOLD, 25);

        // 뒤로가기 버튼
        backButton = new JButton();
        backButton.setContentAreaFilled(false);
        backButton.setBorder(new LineBorder(Color.WHITE, 2));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(font);
        backButton.setText("Go Back");
        backButton.setBounds(1180, 20, 200, 80);
        add(backButton);
        
        // 리더보드 테이블
        leaderboardTable = new JLabel();
    	leaderboardTable.setBackground(new Color(255, 255, 255, 100));
    	leaderboardTable.setOpaque(true);
    	leaderboardTable.setBounds(20, 20, 1140, 660);
    	add(leaderboardTable);
    	
    	// 리더보드 컬럼
    	leaderboardColumns = new JLabel[4];
    	for (int i = 0; i < leaderboardColumns.length; i++) {
    		leaderboardColumns[i] = new JLabel();
    		leaderboardColumns[i].setFont(font);
    		leaderboardColumns[i].setHorizontalAlignment(JLabel.CENTER);
    		leaderboardColumns[i].setForeground(Color.BLACK);
    		leaderboardColumns[i].setBackground(Color.WHITE);
    		leaderboardColumns[i].setOpaque(true);
    		leaderboardColumns[i].setBounds(40 + i * 275, 40, 275, 60);
    		add(leaderboardColumns[i]);
    	}
		leaderboardColumns[0].setText("Rank");
		leaderboardColumns[1].setText("ID");
		leaderboardColumns[2].setText("Score");
		leaderboardColumns[3].setText("Date");
    	
    	ranks = new JLabel[10][4];
    	for (int i = 0; i < ranks.length; i++) {
    		for (int j = 0; j < ranks[0].length; j++) {
    			ranks[i][j] = new JLabel("");
    			ranks[i][j].setFont(font);
    			ranks[i][j].setHorizontalAlignment(JLabel.CENTER);
    			ranks[i][j].setForeground(Color.BLACK);
    			ranks[i][j].setOpaque(false);
    			ranks[i][j].setBounds(40 + j * 275, 120 + i * 55, 275, 45);
    			add(ranks[i][j]);
    		}
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
    
    public void init() {
    	Database db;
		try {
			DatabaseConnector dbConnector = DatabaseConnector.getInstance();
			db = dbConnector.getDatabase();
			db.dump();
		} catch (IOException e) {
			System.out.println("[DB Connection Error]");
			e.printStackTrace();
			db = null;
		} catch (ParseFailure e) {
			e.printStackTrace();
			db = null;
		}
		
		List<Rank> rankList;
		if (db != null) {
			RankRepository rankRepository = new RankRepository(db);
			try {
				rankList = rankRepository.getAllRankList();
			} catch (IOException | ParseFailure e) {
				e.printStackTrace();
				rankList = null;
			}
		} else {
			rankList = null;
		}
    	
		if (rankList != null) {
			int size;
			if (rankList.size() > 10) {
				size = 10;
			} else {
				size = rankList.size();
			} 
			
			for (int i = 0; i < size; i++) {
				Rank rank = rankList.get(i);
				ranks[i][0].setText("" + rank.getRank());
				ranks[i][1].setText(rank.getId());
				ranks[i][2].setText("" + rank.getScore());
				ranks[i][3].setText(rank.getPlaydate());
			}
			for (; size < 10; size++) {
				for (int j = 0; j < ranks[0].length; j++) {
					ranks[size][j].setText("");
				}
			}
		}
    }
    
    public JButton getBackButton() {
    	return backButton;
    }
}
