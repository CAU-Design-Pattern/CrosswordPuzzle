package service;

import com.holub.database.Database;
import com.holub.text.ParseFailure;
import connector.DatabaseConnector;
import org.junit.Before;
import org.junit.Test;
import repository.WordRepository;

import java.io.IOException;

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
    public void test(){
        // transaction ??? - > 현재 repo 계층에서 dump를 진행중이라 불가?

    }
}