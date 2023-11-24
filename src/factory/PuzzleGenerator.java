package factory;

import java.io.IOException;
import com.holub.database.Database;
import com.holub.text.ParseFailure;
import connector.DatabaseConnector;
import dto.Word;
import repository.WordRepository;
import service.WordService;

public class PuzzleGenerator {
	public static void placeWords(WordInfo[][] board) {
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
		
		WordPlacementStrategy wordPlacementStrategy = WordPlacementStrategy.ACROSS;
		if (db != null) {
			WordService wordService = new WordService(new WordRepository(db));
			
			try {
				Word word = wordService.getRandomWordIncludingAlphabet('a');
				String str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i][0].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i][0].setAcrossDesc(word.getDesc());
					} else {
						board[i][0].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[1][0].getLetter(), 1, 5);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[1][i].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[1][i].setAcrossDesc(word.getDesc());
					} else {
						board[1][i].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[1][3].getLetter(), 1, 6);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 1][3].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 1][3].setAcrossDesc(word.getDesc());
					} else {
						board[i + 1][3].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[4][3].getLetter(), 1, 7);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[4][i + 3].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[4][i + 3].setAcrossDesc(word.getDesc());
					} else {
						board[4][i + 3].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[4][6].getLetter(), 4, 6);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 1][6].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 1][6].setAcrossDesc(word.getDesc());
					} else {
						board[i + 1][6].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[4][8].getLetter(), 1, 4);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 4][8].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 4][8].setAcrossDesc(word.getDesc());
					} else {
						board[i + 4][8].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[2][6].getLetter(), 1, 6);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[2][i + 6].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[2][i + 6].setAcrossDesc(word.getDesc());
					} else {
						board[2][i + 6].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[6][8].getLetter(), 1, 5);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[6][i + 8].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[6][i + 8].setAcrossDesc(word.getDesc());
					} else {
						board[6][i + 8].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[6][12].getLetter(), 1, 5);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 6][12].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 6][12].setAcrossDesc(word.getDesc());
					} else {
						board[i + 6][12].setDownDesc(word.getDesc());
					}
				}

				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[10][12].getLetter(), 8, 8);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[10][i + 5].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[10][i + 5].setAcrossDesc(word.getDesc());
					} else {
						board[10][i + 5].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[10][10].getLetter(), 1, 7);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 10][10].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 10][10].setAcrossDesc(word.getDesc());
					} else {
						board[i + 10][10].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[15][10].getLetter(), 7, 8);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[15][i + 4].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[15][i + 4].setAcrossDesc(word.getDesc());
					} else {
						board[15][i + 4].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[15][5].getLetter(), 4, 4);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 12][5].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 12][5].setAcrossDesc(word.getDesc());
					} else {
						board[i + 12][5].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[15][5].getLetter(), 1, 5);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 15][4].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 15][4].setAcrossDesc(word.getDesc());
					} else {
						board[i + 15][4].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[12][5].getLetter(), 4, 4);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[12][i + 2].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[12][i + 2].setAcrossDesc(word.getDesc());
					} else {
						board[12][i + 2].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[13][5].getLetter(), 1, 4);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[13][i + 5].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[13][i + 5].setAcrossDesc(word.getDesc());
					} else {
						board[13][i + 5].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[12][2].getLetter(), 3, 8);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 10][2].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 10][2].setAcrossDesc(word.getDesc());
					} else {
						board[i + 10][2].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[19][4].getLetter(), 1, 6);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[19][i + 4].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[19][i + 4].setAcrossDesc(word.getDesc());
					} else {
						board[19][i + 4].setDownDesc(word.getDesc());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				placeWords(board);
			}
		}
		
		/*
		for (int i = 0; i < board[0].length; i++) {
			System.out.println();
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] == null){
					System.out.print(" *");
				} else {
					System.out.print(" " + board[j][i].getLetter());
				}
			}
		}
		*/
	}
	
	public static void placeWordsLevel2(WordInfo[][] board) {
		placeWords(board);
		
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
		
		WordPlacementStrategy wordPlacementStrategy = WordPlacementStrategy.ACROSS;
		if (db != null) {
			WordService wordService = new WordService(new WordRepository(db));
			
			try {
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				Word word = wordService.getRandomWord(board[19][7].getLetter(), 1, 8);
				String str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 19][7].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 19][7].setAcrossDesc(word.getDesc());
					} else {
						board[i + 19][7].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[21][7].getLetter(), 1, 6);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[21][i + 7].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[21][i + 7].setAcrossDesc(word.getDesc());
					} else {
						board[21][i + 7].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[21][12].getLetter(), 2, 4);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 20][12].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 20][12].setAcrossDesc(word.getDesc());
					} else {
						board[i + 20][12].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[24][7].getLetter(), 5, 8);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[24][i + 3].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[24][i + 3].setAcrossDesc(word.getDesc());
					} else {
						board[24][i + 3].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[24][4].getLetter(), 4, 4);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 21][4].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 21][4].setAcrossDesc(word.getDesc());
					} else {
						board[i + 21][4].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[22][4].getLetter(), 4, 5);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[22][i + 1].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[22][i + 1].setAcrossDesc(word.getDesc());
					} else {
						board[22][i + 1].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[22][1].getLetter(), 1, 8);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 22][1].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 22][1].setAcrossDesc(word.getDesc());
					} else {
						board[i + 22][1].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[24][10].getLetter(), 1, 4);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 24][10].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 24][10].setAcrossDesc(word.getDesc());
					} else {
						board[i + 24][10].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[27][1].getLetter(), 1, 6);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[27][i + 1].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[27][i + 1].setAcrossDesc(word.getDesc());
					} else {
						board[27][i + 1].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[29][1].getLetter(), 1, 12);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[29][i + 1].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[29][i + 1].setAcrossDesc(word.getDesc());
					} else {
						board[29][i + 1].setDownDesc(word.getDesc());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				placeWordsLevel2(board);
			}
		}
			
		/*
		for (int i = 0; i < board[0].length; i++) {
			System.out.println();
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] == null){
					System.out.print(" *");
				} else {
					System.out.print(" " + board[j][i].getLetter());
				}
			}
		}
		*/
	}
	
	public static void placeWordsLevel3(WordInfo[][] board) {
		placeWordsLevel2(board);
		
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
		
		WordPlacementStrategy wordPlacementStrategy = WordPlacementStrategy.ACROSS;
		if (db != null) {
			WordService wordService = new WordService(new WordRepository(db));
			
			try {			
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				Word word = wordService.getRandomWord(board[29][4].getLetter(), 1, 10);
				String str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 29][4].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 29][4].setAcrossDesc(word.getDesc());
					} else {
						board[i + 29][4].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[35][4].getLetter(), 1, 8);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[35][i + 4].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[35][i + 4].setAcrossDesc(word.getDesc());
					} else {
						board[35][i + 4].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[35][11].getLetter(), 1, 5);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 35][11].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 35][11].setAcrossDesc(word.getDesc());
					} else {
						board[i + 35][11].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[37][4].getLetter(), 1, 6);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[37][i + 4].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[37][i + 4].setAcrossDesc(word.getDesc());
					} else {
						board[37][i + 4].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[29][2].getLetter(), 1, 9);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 29][2].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 29][2].setAcrossDesc(word.getDesc());
					} else {
						board[i + 29][2].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[29][6].getLetter(), 1, 5);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 29][6].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 29][6].setAcrossDesc(word.getDesc());
					} else {
						board[i + 29][6].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[29][8].getLetter(), 1, 5);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 29][8].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 29][8].setAcrossDesc(word.getDesc());
					} else {
						board[i + 29][8].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[29][10].getLetter(), 1, 5);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 29][10].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 29][10].setAcrossDesc(word.getDesc());
					} else {
						board[i + 29][10].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[29][12].getLetter(), 1, 6);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 29][12].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 29][12].setAcrossDesc(word.getDesc());
					} else {
						board[i + 29][12].setDownDesc(word.getDesc());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				placeWordsLevel3(board);
			}
		}
			
		for (int i = 0; i < board[0].length; i++) {
			System.out.println();
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] == null){
					System.out.print(" *");
				} else {
					System.out.print(" " + board[j][i].getLetter());
				}
			}
		}
		
	}
}
