import controllers.Controller;
import views.TitleView;
import views.HomeView;

public class Main {
    public static void main(String[] args) {
    	TitleView titleView = new TitleView();
    	HomeView homeView = new HomeView();
        new Controller(titleView, homeView);
    }
}