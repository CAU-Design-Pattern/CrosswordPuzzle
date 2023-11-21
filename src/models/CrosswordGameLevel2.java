package models;

import factory.WordInfo;

public class CrosswordGameLevel2 extends CrosswordGame {
	@Override
	public void createBoard() {
		this.level = "LEVEL 2";
		this.board = new WordInfo[30][15];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = new WordInfo();
			}
		}
	}
}
