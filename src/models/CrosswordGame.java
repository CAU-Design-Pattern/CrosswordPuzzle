package models;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class CrosswordGame extends Observable {
	protected char[][] board;
	protected ArrayList<String> wordList;
	protected Timer timer = Timer.getInstance();
	
	public void play() {
		// TODO
		createBoard();
		placeWords();
		startGame();
	}
	
	public abstract void createBoard();
	
	public void placeWords() {
		// TODO: 수정 필요
		board[0][0] = 'a';
		board[0][1] = 'p';
		board[0][2] = 'p';
		board[0][3] = 'l';
		board[0][4] = 'e';
	}
	
	public void startGame() {
		// TODO
		timer.setTime(300);
		timer.start();
	}
	
	public void printResult() {
		// TODO
	}
	
	public char[][] getBoard() {
		return board;
	}
	
	public ArrayList<String> getWordList() {
		return wordList;
	}
}