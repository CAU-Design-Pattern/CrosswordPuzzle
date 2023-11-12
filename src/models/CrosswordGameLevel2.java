package models;

public class CrosswordGameLevel2 extends CrosswordGame {
	@Override
	public void createBoard() {
		this.board = new char[40][40];
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 40; j++) {
				this.board[i][j] = ' ';
			}
		}
	}
}
