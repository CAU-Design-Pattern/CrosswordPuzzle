package controllers;

import javax.swing.*;
import java.awt.*;

public final class Controller {
    private final JFrame frame;
    private final JPanel panel;
    private final CardLayout cardLayout;

    public Controller(JPanel[] views) {
        frame = new JFrame();
        cardLayout = new CardLayout();
        panel = new JPanel(cardLayout);
        panel.add(views[0], "TitleView");
        panel.add(views[1], "HomeView");
        frame.add(panel);

        cardLayout.show(panel, "TitleView");

        frame.setResizable(false);
        frame.pack();
        frame.setTitle("Crossword Puzzle");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
