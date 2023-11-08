package controllers;

import javax.swing.*;
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
        	// TODO
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
