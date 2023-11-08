import javax.swing.*;
import controllers.Controller;
import views.TitleView;
import views.HomeView;

public class Main {
    public static void main(String[] args) {
        JPanel[] views = new JPanel[] {
        		new TitleView(),
        		new HomeView()
        };
        
        new Controller(views);
    }
}