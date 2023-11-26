package repository;

import com.holub.database.Cursor;
import com.holub.database.Database;
import com.holub.database.Table;
import com.holub.text.ParseFailure;
import dto.Word;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

    	Cursor cursor = table.rows();
    	
    	return transferWordList(cursor);
    }
    
    public List<Word> getWordList(char character, int index) throws IOException, ParseFailure {
    	String sql = "select * from word where word like '^.{" + (index-1) + "}" + character + "%'";
    	System.out.println(sql);
    	Table table = database.execute(sql);

    	Cursor cursor = table.rows();
    	
    	return transferWordList(cursor);
    }
    
    public List<Word> getWordList(char character, int index, int length) throws IOException, ParseFailure{
    	String sql = "select * from word where word like '^.{" + (index-1) + "}" + character + "%' AND length = " + length;
    	System.out.println(sql);
    	Table table = database.execute(sql);

    	Cursor cursor = table.rows();
    	
    	return transferWordList(cursor);
    }
    
    /**
     * 특정 알파벳 포함하는 단어 목록 조회
     * @param character
     * @return
     * @throws IOException
     * @throws ParseFailure
     */
    public List<Word> getWordList(char character) throws IOException, ParseFailure{
    	String sql = "select * from word where word like " + "'%" + character + "%'";
    	Table table = database.execute(sql);

    	Cursor cursor = table.rows();
    	
    	return transferWordList(cursor);
    }

    /**
     * 특정 word를 가져옴
     * @param word
     * @return
     * @throws IOException
     * @throws ParseFailure
     */
    public Word getWord(String word) throws IOException, ParseFailure {
        String sql = "select * from word where word = '" + word + "'";
        Table table = database.execute(sql);
        Cursor cursor = table.rows();
        List<Word> words = transferWordList(cursor);
        if(words.isEmpty())
            return null;
        return words.get(0);
    }
    
    
    /**
     * word insert
     * @param word
     * @throws IOException
     * @throws ParseFailure
     */
    public void insertOneWord(Word word) throws IOException, ParseFailure {
        if(getWord(word.getWord()) != null) // 이미 같은 word가 있는 경우 (pk설정이 이미 있는 db에서 불러올때 안되는듯함)
            return;
        String insertSql = "insert into word VALUES ('"+ word.getWord() +"',  '"+ word.getDesc() +"', "+ word.getLevel() +", "+ word.getLength() +")";
    	database.execute(insertSql);
    }

    public void updateOneWord(Word word) throws IOException, ParseFailure {
        String descSql = "update word set desc = \"" + word.getDesc() +"\"  where word = \"" + word.getWord() + "\"" ;
        database.execute(descSql);
        String levelSql = "update word set level = " + word.getLevel() +"  where word = \"" + word.getWord() + "\"" ;
        database.execute(levelSql);
    }
    
    public List<Word> transferWordList(Cursor cursor) {
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
