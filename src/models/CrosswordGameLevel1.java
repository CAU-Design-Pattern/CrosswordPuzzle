package models;

public class CrosswordGameLevel1 extends CrosswordGame {
	@Override
	public void createBoard() {
		this.board = new char[20][20];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				this.board[i][j] = ' ';
			}
		}
	}
}
