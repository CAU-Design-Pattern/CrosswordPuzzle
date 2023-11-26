package models;

import factory.PuzzleGenerator;
import factory.WordInfo;

public class CrosswordGameLevel1 extends CrosswordGame {
	@Override
	public void createBoard() {
		this.level = "LEVEL 1";
		this.board = new WordInfo[20][15];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = new WordInfo();
			}
		}
	}
	
	@Override
	public void placeWords() {
		PuzzleGenerator.placeWordsLevel1(board);
	}
}
