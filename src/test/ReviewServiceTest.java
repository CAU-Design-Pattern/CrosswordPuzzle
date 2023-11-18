package test;

import com.holub.database.Database;
import com.holub.text.ParseFailure;
import connector.DatabaseConnector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.AccountRepository;
import repository.ReviewRepository;
import service.AccountService;
import service.ReviewService;

import java.io.IOException;

public class ReviewServiceTest {
    private ReviewService reviewService;
    @BeforeEach
    public void setUp() throws IOException, ParseFailure {
        DatabaseConnector instance = DatabaseConnector.getInstance();
        Database database = instance.getDatabase();
        ReviewRepository reviewRepository = new ReviewRepository(database);
        reviewService = new ReviewService(reviewRepository);
    }

    @Test
    public void test() throws IOException, ParseFailure {
        reviewService.insertOneReview("test", "school");
        reviewService.insertOneReview("test", "apple");
        reviewService.insertOneReview("test", "school");
        reviewService.getAllReviewListById("test");
    }
}
