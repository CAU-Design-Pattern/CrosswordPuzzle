package models;

import java.io.IOException;
import java.util.*;

import com.holub.database.Database;
import com.holub.text.ParseFailure;

import main.DatabaseConnector;
import repository.WordRepository;

public abstract class CrosswordGame extends Observable {
	protected String level;
	protected int hintCount;
	protected char[][] board;
	protected HashMap<String, String> wordList;
	protected GameTimer gameTimer = GameTimer.getInstance();
	protected Thread timerThread;
	
	public void play() {
		initalize();
		createBoard();
		placeWords();
		startGame();
	}
	
	public void initalize() {
		hintCount = 3;
		wordList = new HashMap<String, String>();
	}
	
	public abstract void createBoard();
	
	public void placeWords() {
		// TODO: 수정 필요, DB와 연동 필요
		
		Database db;
		try {
			DatabaseConnector dbConnector = DatabaseConnector.getInstance();
			db = dbConnector.getDatabase();
			db.dump();
		} catch (IOException e) {
			System.out.println("[DB Connection Error]");
			e.printStackTrace();
			db = null;
		} catch (ParseFailure e) {
			e.printStackTrace();
			db = null;
		}
		
		if (db != null) {
			WordRepository wordRepository = new WordRepository(db);
			try {
				wordRepository.getWordList();
			} catch (IOException | ParseFailure e) {
				e.printStackTrace();
			}
		} else {
			
		}
		
		wordList.put("apple", "Red");
		board[2][0] = 'a';
		board[2][1] = 'p';
		board[2][2] = 'p';
		board[2][3] = 'l';
		board[2][4] = 'e';
		
		wordList.put("hello", "hi");
		board[0][3] = 'h';
		board[1][3] = 'e';
		board[2][3] = 'l';
		board[3][3] = 'l';
		board[4][3] = 'o';
	}
	
	public void startGame() {
		gameTimer.setTime(300); // 300 seconds = 5 minutes
		timerThread = new Thread(gameTimer);
		timerThread.start();
	}
	
	public void printResult() {
		// TODO
	}
	
	public void stopGame() {
		timerThread.interrupt();
	}
	
	public String getLevel() {
		return level;
	}
	
	public int getHintCount() {
		return hintCount;
	}
	
	public char[][] getBoard() {
		return board;
	}
	
	public HashMap<String, String> getWordList() {
		return wordList;
	}
	
	public void setHintCount(int hintCount) {
		this.hintCount = hintCount;
	}
}