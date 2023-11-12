package repository;

import com.holub.database.Cursor;
import com.holub.database.Database;
import com.holub.database.Table;
import com.holub.text.ParseFailure;
import models.Word;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WordRepository {
    private Database database;

    public WordRepository(Database database){
        this.database = database;
    }

    /**
     * 전체 단어 조회
     * @return List<Word>
     */
    public List<Word> getWordList() throws IOException, ParseFailure {
        String sql = "select * from word";
        Table table = database.execute(sql);
        System.out.println(table.toString());
        Cursor cursor = table.rows();
        
        return transferWordList(cursor);
    }
    
    /**
     * 특정 길이의 단어 목록 조회
     * @param length
     * @return List<Word>
     * @throws ParseFailure 
     * @throws IOException 
     */
    public List<Word> getWordList(int length) throws IOException, ParseFailure{
    	String sql = "select * from word where length = " + length;
    	Table table = database.execute(sql);
    	System.out.println(table.toString());
    	Cursor cursor = table.rows();
    	
    	return transferWordList(cursor);
    }
    
    
    /**
     * word insert
     * @param word
     * @throws IOException
     * @throws ParseFailure
     */
    public void insertOneWord(Word word) throws IOException, ParseFailure {
    	String insertSql = "insert into word VALUES ('"+ word.getWord() +"',  '"+ word.getDesc() +"', "+ word.getLevel() +", "+ word.getLength() +")";
    	database.execute(insertSql);
    	database.dump();
    }
    
    private List<Word> transferWordList(Cursor cursor) {
    	List<Word> res = new ArrayList<>();
    	int columnCnt = cursor.columnCount();
        while(cursor.advance()){
        	Map<String, Object> rowMap = new HashMap<>();
        	for(int i = 0; i < columnCnt; i++) {
        		String columnName = cursor.columnName(i);
        		Object value = cursor.column(columnName);
        		rowMap.put(columnName, value);
        	}
            res.add(new Word(rowMap));
        }
        return res;
    }
}
