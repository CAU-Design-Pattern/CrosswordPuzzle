package models;

import java.util.*;
import dto.Word;
import factory.WordInfo;

public abstract class CrosswordGame extends Observable {
	protected String level;
	protected int hintCount;
	protected WordInfo[][] board;
	protected List<Word> wordList;
	protected GameTimer gameTimer = GameTimer.getInstance();
	protected Thread timerThread;
	
	public void play() {
		initalize();
		createBoard();
		placeWords();
		startGame();
	}
	
	public void initalize() {
		hintCount = 5;
	}
	
	public abstract void createBoard();
	
	public abstract void placeWords();
	
	public void startGame() {
		gameTimer.setTime(300); // 300 seconds = 5 minutes
		timerThread = new Thread(gameTimer);
		timerThread.start();
	}
	
	public int getResult(char[][] answer) {
		int score = 0;
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[0].length; j++) {
				char letter = board[i][j].getLetter();
				if (letter != '*' && letter == answer[i][j]) {
					score += board[i][j].getLevel();
				}
			}
		}
		
		return score;
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
	
	public WordInfo[][] getBoard() {
		return board;
	}
	
	public List<Word> getWordList() {
		return wordList;
	}
	
	public void setHintCount(int hintCount) {
		this.hintCount = hintCount;
	}
}