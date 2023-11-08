import controllers.Controller;
import views.*;

public class Main {
    public static void main(String[] args) {
    	TitleView titleView = new TitleView();
    	SignUpView signUpView = new SignUpView();
    	HomeView homeView = new HomeView();
    	LeaderboardView leaderboardView = new LeaderboardView();
    	WordRegistrationView wordRegistrationView = new WordRegistrationView();
    	ReviewNoteView reviewNoteView = new ReviewNoteView();
        new Controller(titleView, signUpView, homeView, leaderboardView, wordRegistrationView, reviewNoteView);
    }
}