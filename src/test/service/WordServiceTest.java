package test.service;

import com.holub.database.Database;
import com.holub.text.ParseFailure;
import connector.DatabaseConnector;
import dto.Word;
import org.junit.Before;
import org.junit.Test;
import repository.WordRepository;
import service.WordService;

import java.io.IOException;
import java.util.List;

public class WordServiceTest {

    private WordRepository wordRepository;
    private WordService wordService;

    @Before
    public void setUp() throws IOException, ParseFailure {
        DatabaseConnector instance = DatabaseConnector.getInstance();
        Database database = instance.getDatabase();
        wordRepository = new WordRepository(database);
    }

    @Test
    public void test() throws IOException, ParseFailure {
        // transaction ??? - > 현재 repo 계층에서 dump를 진행중이라 불가?
        List<Word> wordList = wordRepository.getWordList();
        for (Word word : wordList) {
            System.out.println("word = " + word);
        }
    }
}