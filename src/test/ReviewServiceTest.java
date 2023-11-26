package test;

import com.holub.database.Database;
import com.holub.text.ParseFailure;
import connector.DatabaseConnector;
import dto.ReviewWord;
import dto.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.AccountRepository;
import repository.ReviewRepository;
import repository.WordRepository;
import service.AccountService;
import service.ReviewService;
import service.WordService;

import java.io.IOException;
import java.util.List;

public class ReviewServiceTest {
    private ReviewService reviewService;
    @BeforeEach
    public void setUp() throws IOException, ParseFailure {
        DatabaseConnector instance = DatabaseConnector.getInstance();
        Database database = instance.getDatabase();
        ReviewRepository reviewRepository = new ReviewRepository(database);
        reviewService = new ReviewService(reviewRepository);

        WordRepository wordRepository = new WordRepository(database);
        WordService wordService = new WordService(wordRepository);
        wordService.insertOneWord(new Word("school", "test school", 1));
        wordService.insertOneWord(new Word("apple", "test apple", 2));
    }

    @Test
    public void ReviewTest() throws IOException, ParseFailure {
        reviewService.insertOneReview("test99", "school");
        reviewService.insertOneReview("test99", "apple");
        reviewService.insertOneReview("test99", "school");
        List<ReviewWord> reviewList = reviewService.getAllReviewListById("test99");

        for (ReviewWord reviewWord : reviewList) {
            System.out.println("reviewWord = " + reviewWord);
        }
        Assertions.assertEquals(2, reviewList.size());


    }
}
