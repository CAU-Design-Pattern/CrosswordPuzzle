package views;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JPanel {
    // HomeView 의  Width
    private static final int WIDTH = 1400;

    // TitleView 의 Height
    private static final int HEIGHT = 700;

    public HomeView() {
        setLayout(null);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
}
