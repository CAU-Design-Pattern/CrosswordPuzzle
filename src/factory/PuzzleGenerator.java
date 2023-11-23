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
				word = wordService.getRandomWord(board[1][3].getLetter(), 2, 6);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i][3].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i][3].setAcrossDesc(word.getDesc());
					} else {
						board[i][3].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[4][3].getLetter(), 2, 7);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[4][i + 2].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[4][i + 2].setAcrossDesc(word.getDesc());
					} else {
						board[4][i + 2].setDownDesc(word.getDesc());
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
				word = wordService.getRandomWord(board[10][12].getLetter(), 6, 8);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[10][i + 7].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[10][i + 7].setAcrossDesc(word.getDesc());
					} else {
						board[10][i + 7].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.ACROSS;
				word = wordService.getRandomWord(board[10][10].getLetter(), 2, 7);
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
				word = wordService.getRandomWord(board[15][10].getLetter(), 7, 9);
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
				word = wordService.getRandomWord(board[15][5].getLetter(), 4, 8);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[i + 12][5].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[i + 12][5].setAcrossDesc(word.getDesc());
					} else {
						board[i + 12][5].setDownDesc(word.getDesc());
					}
				}
				
				wordPlacementStrategy = WordPlacementStrategy.DOWN;
				word = wordService.getRandomWord(board[12][5].getLetter(), 5, 7);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[12][i + 1].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[12][i + 1].setAcrossDesc(word.getDesc());
					} else {
						board[12][i + 1].setDownDesc(word.getDesc());
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
				word = wordService.getRandomWord(board[19][5].getLetter(), 2, 5);
				str = word.getWord();
				for (int i = 0; i < word.getLength(); i++) {
					board[19][i + 4].setLetter(str.charAt(i));
					if (wordPlacementStrategy == WordPlacementStrategy.ACROSS) {
						board[19][i + 4].setAcrossDesc(word.getDesc());
					} else {
						board[19][i + 4].setDownDesc(word.getDesc());
					}
				}
			} catch (IOException | ParseFailure e) {
				e.printStackTrace();
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
