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
		boolean[][] visited = new boolean[board.length][board[0].length];
		
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
					}else {
						board[i][0].setDownDesc(word.getDesc());
					}
					board[i][0].setWordPlacementStrategy(wordPlacementStrategy);
					visited[i][0] = true;
				}	
			} catch (IOException | ParseFailure e) {
				e.printStackTrace();
			}
		}
			
		for (int i = 0; i < board[0].length; i++) {
			System.out.println();
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] == null){
					System.out.print(" @");
				} else {
					System.out.print(" " + board[j][i].getLetter());
				}
			}
		}	
	}
}
