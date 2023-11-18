package service;

import com.holub.text.ParseFailure;
import dto.Review;
import dto.ReviewWord;
import repository.ReviewRepository;

import java.io.IOException;
import java.util.List;

public class ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    /**
     * 해당 User의 오답노트 목록 조회
     * @param id
     * @return
     * @throws IOException
     * @throws ParseFailure
     */
    public List<ReviewWord> getAllReviewListById(String id) throws IOException, ParseFailure {
        return reviewRepository.getReviewList(id);
    }

    /**
     * 해당 User의 오답노트에 word추가 (만약 존재할 경우 Count ++ )
     * @param id
     * @param word
     * @throws IOException
     * @throws ParseFailure
     */
    public void insertOneReview(String id, String word) throws IOException, ParseFailure {
        reviewRepository.insertOneReview(new Review(id, word, 0));
    }
}
