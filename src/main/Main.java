package main;

import controllers.Controller;
import views.*;

public class Main {
    public static void main(String[] args) {
    	// 게임 시작 화면
    	TitleView titleView = new TitleView();
    	
    	// 회원가입 화면
    	SignUpView signUpView = new SignUpView();
    	
    	// 홈 화면
    	HomeView homeView = new HomeView();
    	
    	// 게임 난이도 선택 화면
    	GameLevelView gameLevelView = new GameLevelView();
    	
    	// 십자말풀이 게임 화면
    	GameView gameView = new GameView();
    	
    	// 리더보드 화면
    	LeaderboardView leaderboardView = new LeaderboardView();
    	
    	// 단어 등록 화면
    	WordRegistrationView wordRegistrationView = new WordRegistrationView();
    	
    	new Controller(
        	titleView,
        	signUpView,
        	homeView,
        	gameLevelView,
        	gameView,
        	leaderboardView,
        	wordRegistrationView
        );
    }
}