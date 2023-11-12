package models;

public class CrosswordGameLevel3 extends CrosswordGame {
	@Override
	public void createBoard() {
		this.board = new char[60][60];
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < 60; j++) {
				this.board[i][j] = ' ';
			}
		}
	}
}
