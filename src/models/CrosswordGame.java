package models;

import java.io.IOException;
import java.util.*;

import com.holub.database.Database;
import com.holub.text.ParseFailure;

import connector.DatabaseConnector;
import dto.Word;
import factory.PuzzleGenerator;
import factory.WordInfo;
import repository.WordRepository;

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
	
	public void placeWords() {
		/**
		 * TODO: DB로부터 단어를 받아서 보드 생성하기
		 */
		
		PuzzleGenerator.placeWords(board);
	}
	
	public void startGame() {
		gameTimer.setTime(180); // 180 seconds = 3 minutes
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