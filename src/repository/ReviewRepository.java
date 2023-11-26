package repository;

import com.holub.database.Cursor;
import com.holub.database.Database;
import com.holub.database.Table;
import com.holub.text.ParseFailure;
import dto.Review;
import dto.ReviewWord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewRepository {
    private Database database;

    public ReviewRepository(Database database) {
        this.database = database;
    }


    public List<ReviewWord> getReviewList(String id) throws IOException, ParseFailure {
        String sql = "select * from review, word where review.word = word.word";
        Table table = database.execute(sql);
        Cursor cursor = table.rows();

        return transferReviewWordList(cursor);
    }

    public void insertOneReview(Review review) throws IOException, ParseFailure {
        String getSql = "select * from review where id = '" + review.getId() + "' AND word = '" + review.getWord() + "'";
        Table table = database.execute(getSql);
        Cursor cursor = table.rows();
        if( cursor.advance() ){
            int count = Integer.parseInt(cursor.column("count").toString());
            String countPlusSql = "update review set count = " + (count+1) +" where id = \"" + review.getId() + "\" AND word = \"" + review.getWord() + "\"";
            database.execute(countPlusSql);
        } else {
            String sql = "insert into review values ('" + review.getId() + "', '" + review.getWord() + "', " + review.getCount() +")";
            database.execute(sql);
        }
    }

    private List<ReviewWord> transferReviewWordList(Cursor cursor){
        List<ReviewWord> res = new ArrayList<>();
        int columnCnt = cursor.columnCount();
        while(cursor.advance()){
            Map<String, Object> rowMap = new HashMap<>();
            for(int i=0;i<columnCnt;i++){
                String columnName = cursor.columnName(i);
                Object value = cursor.column(columnName);
                rowMap.put(columnName, value);
                System.out.println("columnName = " + columnName);
                System.out.println("value = " + value);
            }
            // System.out.println("rowMap = " + rowMap.toString());
            res.add(new ReviewWord(rowMap));
        }
        return res;
    }
}
