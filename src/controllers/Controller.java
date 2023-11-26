package controllers;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import com.holub.database.Database;
import com.holub.text.ParseFailure;

import connector.DatabaseConnector;
import dto.Word;
import exception.UnsupportedExtensionException;
import factory.WordPlacementStrategy;
import models.*;
import repository.WordRepository;
import service.WordService;
import views.*;
import java.awt.*;
import java.io.IOException;

public final class Controller {
    private final JFrame frame;
    private final JPanel panel;
    private final CardLayout cardLayout;

    public Controller(
    	TitleView titleView, 
    	SignUpView signUpView,
    	HomeView homeView,
    	GameLevelView gameLevelView,
    	GameView gameView,
   		LeaderboardView leaderboardView,
   		WordRegistrationView wordRegistrationView)
    {
        frame = new JFrame();
        cardLayout = new CardLayout();
        panel = new JPanel(cardLayout);
        panel.add(titleView, "titleView");
        panel.add(signUpView, "signUpView");
        panel.add(homeView, "homeView");
        panel.add(gameLevelView, "gameLevelView");
        panel.add(gameView, "gameView");
        panel.add(leaderboardView, "leaderboardView");
        panel.add(wordRegistrationView, "wordRegistrationView");
        frame.add(panel);

        cardLayout.show(panel, "titleView");

        frame.setResizable(false);
        frame.pack();
        frame.setTitle("Crossword Puzzle");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        titleView.getSignInButton().addActionListener(e -> {
        	// TODO: 로그인 logic
        	cardLayout.show(panel, "homeView");
        });
        
        titleView.getSignUpButton().addActionListener(e -> {
        	cardLayout.show(panel,  "signUpView");
        });
        
        signUpView.getBackButton().addActionListener(e -> {
        	cardLayout.show(panel,  "titleView");
        });
        
        signUpView.getSignUpButton().addActionListener(e -> {
        	// TODO
        });
        
        homeView.getSignOutButton().addActionListener(e -> {
        	cardLayout.show(panel, "titleView");
        });
        
        homeView.getStartGameButton().addActionListener(e -> {
        	cardLayout.show(panel, "gameLevelView");
        });
        
        homeView.getLeaderboardButton().addActionListener(e -> {
        	leaderboardView.init();
        	cardLayout.show(panel, "leaderboardView");
        });
        
        homeView.getWordRegistrationButton().addActionListener(e -> {
        	wordRegistrationView.clear();
        	cardLayout.show(panel, "wordRegistrationView");
        });
        
        gameLevelView.getBackButton().addActionListener(e -> {
        	cardLayout.show(panel, "homeView");
        });
        
        gameLevelView.getLevel1Button().addActionListener(e -> {
        	gameView.startGame(new CrosswordGameLevel1());
        	cardLayout.show(panel, "gameView");
        });
        
        gameLevelView.getLevel2Button().addActionListener(e -> {
        	gameView.startGame(new CrosswordGameLevel2());
        	cardLayout.show(panel, "gameView");
        });
        
        gameLevelView.getLevel3Button().addActionListener(e -> {
        	gameView.startGame(new CrosswordGameLevel3());
        	cardLayout.show(panel, "gameView");
        });
        
        gameView.getHintButton().addActionListener(e -> {
        	gameView.useHint();
        });
        
        gameView.getSubmitButton().addActionListener(e -> {
        	// TODO
        	gameView.stopGame();
        	cardLayout.show(panel, "homeView");
        });
        
        leaderboardView.getBackButton().addActionListener(e -> {
        	cardLayout.show(panel, "homeView");
        });
        
        wordRegistrationView.getBackButton().addActionListener(e -> {
        	cardLayout.show(panel, "homeView");
        });
        
        wordRegistrationView.getImportButton().addActionListener(actionEvent -> {
        	// 확장자가 csv 인 파일만 로드할 수 있도록 함.
        	JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        	jfc.setDialogTitle("Select a .csv file you want to import");
        	jfc.setAcceptAllFileFilterUsed(false);
        	FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", "csv");
        	jfc.addChoosableFileFilter(filter);
        	
        	int resultValue = jfc.showOpenDialog(null);
        	if (resultValue == JFileChooser.APPROVE_OPTION) {
        		String absolutePath = jfc.getSelectedFile().getAbsolutePath();
        		String filename = absolutePath.substring(0, absolutePath.length() - 4);
        		String extension = absolutePath.substring(absolutePath.length() - 3);
        		
        		try {
					DatabaseConnector dbConnector = DatabaseConnector.getInstance();
					Database db = dbConnector.getDatabase();
					db.dump();
					if (db != null) {
						WordService wordService = new WordService(new WordRepository(db));
						wordService.importWordList(filename, extension);
					}
					JOptionPane.showMessageDialog(new JFrame(), "Successfully imported");
					cardLayout.show(panel, "homeView");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(new JFrame(), "Failed to import");
				}
        	}
        });
        
        wordRegistrationView.getRegistrationButton().addActionListener(actionEvent -> {
        	String[] temp = wordRegistrationView.getWord();
        	Word word;
        	try {
        		word = new Word(temp[0], temp[2], Integer.parseInt(temp[1]));
        	} catch (NumberFormatException e) {
        		JOptionPane.showMessageDialog(new JFrame(), "The value of Level must be Integer value.");
        		return;
        	}
        	
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
    		
    		if (db != null) {
    			WordService wordService = new WordService(new WordRepository(db));
    			try {
    				wordService.insertOneWord(word);
    				JOptionPane.showMessageDialog(new JFrame(), "Successfully added");
    				wordRegistrationView.clear();
    				cardLayout.show(panel, "homeView");
    			} catch (Exception e) {
    				e.printStackTrace();
    				JOptionPane.showMessageDialog(new JFrame(), "Failed to add words");
    			}
    		} else {
    			JOptionPane.showMessageDialog(new JFrame(), "Failed to add words");
    		}
        });
    }
}
