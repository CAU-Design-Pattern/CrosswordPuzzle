package controllers;

import javax.swing.*;
import views.HomeView;
import views.TitleView;
import java.awt.*;

public final class Controller {
    private final JFrame frame;
    private final JPanel panel;
    private final CardLayout cardLayout;

    public Controller(TitleView titleView, HomeView homeView) {
        frame = new JFrame();
        cardLayout = new CardLayout();
        panel = new JPanel(cardLayout);
        panel.add(titleView, "titleView");
        panel.add(homeView, "homeView");
        frame.add(panel);

        cardLayout.show(panel, "titleView");

        frame.setResizable(false);
        frame.pack();
        frame.setTitle("Crossword Puzzle Game");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        titleView.getSignInButton().addActionListener(e -> {
        	cardLayout.show(panel, "homeView");
        });
        
        titleView.getSignUpButton().addActionListener(e -> {
        	// TODO
        });
        
        homeView.getStartGameButton().addActionListener(e -> {
        	// TODO
        });
        
        homeView.getLeaderboardButton().addActionListener(e -> {
        	// TODO
        });
        
        homeView.getWordRegistrationButton().addActionListener(e -> {
        	// TODO
        });
        
        homeView.getReviewNoteButton().addActionListener(e -> {
        	// TODO
        });
    }
}
