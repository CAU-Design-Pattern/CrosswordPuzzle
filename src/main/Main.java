package main;
import java.io.IOException;

import com.holub.database.Database;
import com.holub.database.Table;
import com.holub.database.TableFactory;
import com.holub.text.ParseFailure;

import controllers.Controller;
import models.Word;
import repository.WordRepository;
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
    	
    	// 오답 노트 화면
    	ReviewNoteView reviewNoteView = new ReviewNoteView();
        
    	new Controller(
        	titleView,
        	signUpView,
        	homeView,
        	gameLevelView,
        	gameView,
        	leaderboardView,
        	wordRegistrationView,
        	reviewNoteView
        );
    	
    	/*
    	Database db;
    	try {
			DatabaseConnector instance = DatabaseConnector.getInstance();
			db = instance.getDatabase();
			db.dump();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[DB Connection Error]");
			e.printStackTrace();
			db = null;
		} catch (ParseFailure e) {
            e.printStackTrace();
			db = null;
        }

        if (db != null) {
//			System.out.println("test");
			WordRepository wordRepository = new WordRepository(db);
			try {
				wordRepository.getWordList();
//				wordRepository.insertOneWord(new Word("Apple", "Red", 1));
//				wordRepository.insertOneWord(new Word("Hello", "hi", 1));
//				wordRepository.insertOneWord(new Word("lol", "lol", 3));
//				wordRepository.insertOneWord(new Word("school", "student", 2));
				wordRepository.getWordList();
				wordRepository.getWordList(5);
				wordRepository.getWordList('p');
			} catch (IOException | ParseFailure e){
				e.printStackTrace();
			}
////    		String sql = "insert into name VALUES ('Test',  'TestTest', '99')";
//    		//sql = "select * from name";
////    		String sql = "select * from name where first like '%Te%'";
//    		try {
//    			Table table = db.execute(sql);
////				Table result = db.execute(sql);
//				db.execute("insert into word VALUES ('Test',  'TestTest', 1, 4)");
//				Table table1 = db.execute("select * from word");
//				if (table != null) {
//					System.out.println(table.toString());
//				}
//				System.out.println("table1 = " + table1);
//				db.dump();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
    	}
    	*/
    }
}