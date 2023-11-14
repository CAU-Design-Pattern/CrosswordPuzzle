package controllers;

import javax.swing.*;

import models.CrosswordGameLevel1;
import models.CrosswordGameLevel2;
import models.CrosswordGameLevel3;
import views.*;
import java.awt.*;

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
   		WordRegistrationView wordRegistrationView, 
    	ReviewNoteView reviewNoteView)
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
        panel.add(reviewNoteView, "reviewNoteView");
        frame.add(panel);

        cardLayout.show(panel, "titleView");

        frame.setResizable(false);
        frame.pack();
        frame.setTitle("Crossword Puzzle Game");
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
        	cardLayout.show(panel, "leaderboardView");
        });
        
        homeView.getWordRegistrationButton().addActionListener(e -> {
        	cardLayout.show(panel, "wordRegistrationView");
        });
        
        homeView.getReviewNoteButton().addActionListener(e -> {
        	cardLayout.show(panel, "reviewNoteView");
        });
        
        gameLevelView.getBackButton().addActionListener(e -> {
        	cardLayout.show(panel, "homeView");
        });
        
        gameLevelView.getLevel1Button().addActionListener(e -> {
        	gameView.setLevel(1);
        	gameView.prepareGame(new CrosswordGameLevel1());
        	cardLayout.show(panel, "gameView");
        });
        
        gameLevelView.getLevel2Button().addActionListener(e -> {
        	gameView.setLevel(2);
        	gameView.prepareGame(new CrosswordGameLevel2());
        	cardLayout.show(panel, "gameView");
        });
        
        gameLevelView.getLevel3Button().addActionListener(e -> {
        	gameView.setLevel(3);
        	gameView.prepareGame(new CrosswordGameLevel3());
        	cardLayout.show(panel, "gameView");
        });
        
        leaderboardView.getBackButton().addActionListener(e -> {
        	cardLayout.show(panel, "homeView");
        });
        
        wordRegistrationView.getBackButton().addActionListener(e -> {
        	cardLayout.show(panel, "homeView");
        });
        
        wordRegistrationView.getImportButton().addActionListener(e -> {
        	// TODO
        });
        
        wordRegistrationView.getRegistrationButton().addActionListener(e -> {
        	// TODO
        });
        
        reviewNoteView.getBackButton().addActionListener(e -> {
        	cardLayout.show(panel, "homeView");
        });
    }
}
