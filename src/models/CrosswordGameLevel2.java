package models;

public class CrosswordGameLevel2 extends CrosswordGame {
	@Override
	public void createBoard() {
		this.board = new char[30][15];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				this.board[i][j] = ' ';
			}
		}
	}
}
