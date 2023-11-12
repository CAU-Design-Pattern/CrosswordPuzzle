package repository;

import com.holub.database.Cursor;
import com.holub.database.Database;
import com.holub.database.Table;
import com.holub.text.ParseFailure;
import models.Word;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class WordRepository {
    private Database database;

    public WordRepository(Database database){
        this.database = database;
    }

    /**
     * 전체 단어 조회
     * @return
     */
    public List<Word> getWordList() throws IOException, ParseFailure {

        database.execute("insert into word VALUES ('Test1',  'TestTest1', 1, 5)");

        String sql = "select * from word";
        Table table = database.execute(sql);

//        System.out.println("table = \n" + table.toString());
        Cursor cursor = table.rows();
        while(cursor.advance()){
            Iterator columns = cursor.columns();
            while(columns.hasNext()){
                Object next = columns.next();
                System.out.println("next = " + next);
            }
        }
        System.out.println(table.toString());
        return null;
    }
}
