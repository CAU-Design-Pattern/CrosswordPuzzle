package test;

import com.holub.database.Database;
import com.holub.text.ParseFailure;
import connector.DatabaseConnector;
import dto.Word;
import exception.UnsupportedExtensionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.WordRepository;
import service.WordService;

import java.io.IOException;
import java.util.List;

public class WordServiceTest {

    private WordService wordService;

    @BeforeEach
    public void setUp() throws IOException, ParseFailure {
        DatabaseConnector instance = DatabaseConnector.getInstance();
        Database database = instance.getDatabase();
        WordRepository wordRepository = new WordRepository(database);
        wordService = new WordService(wordRepository);
    }

    @Test
    public void WordTest() throws IOException, ParseFailure {
//        List<Word> wordList = wordService.getAllWordList();
//        for (Word word : wordList) {
//            System.out.println("word = " + word);
//        }

        wordService.insertOneWord(new Word("myname", "test", 3));
        Word oneWord = wordService.getOneWord("myname");
        System.out.println("oneWord = " + oneWord);
        Assertions.assertEquals("test", oneWord.getDesc());

        // random이라 별다른 assert x
        Word word1 = wordService.getRandomWord('o', 3);
        System.out.println("word1 = " + word1);
        Word word2 = wordService.getRandomWord('r', 4);
        System.out.println("word2 = " + word2);

        Word word3 = wordService.getRandomWord('t', 5, 6);
        System.out.println("word3 = " + word3);

        Word word4 = wordService.getRandomWord('u', 2, 3);
        System.out.println("word4 = " + word4);

//        System.out.println("-------- migration.csv 에 있는 단어를 import합니다. --------");
//        try{
//            String fileName= "C:/dp2023/migration";
//            wordService.importWordList(fileName, "csv");
//        } catch (UnsupportedExtensionException e){
//            e.printStackTrace();
//        }
    }
}