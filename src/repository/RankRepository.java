package repository;

import com.holub.database.Cursor;
import com.holub.database.Database;
import com.holub.database.Table;
import com.holub.text.ParseFailure;
import dto.Rank;

import java.io.IOException;
import java.util.*;

public class RankRepository {
    private Database database;

    public RankRepository(Database database) {
        this.database = database;
    }

    public List<Rank> getAllRankList() throws IOException, ParseFailure {
        String sql = "select * from rank";
        Table table = database.execute(sql);
        Cursor cursor = table.rows();
        List<Rank> ranks = transferRankList(cursor);
        if(ranks.isEmpty()) return new ArrayList<Rank>();
        ranks.sort(Comparator.comparingInt(Rank::getScore).reversed());

        int ranking = 1;
        int preScore = ranks.get(0).getScore();
        for (Rank rank : ranks) {
            if(preScore > rank.getScore()){
                preScore = rank.getScore();
                ranking++;
            }
            rank.setRank(ranking);
        }

        return  ranks;
    }

    public Rank getRank(Rank rank) throws IOException, ParseFailure {
        String selectSql = "select * from rank where id = '" + rank.getId() + "' AND playdate = '" + rank.getPlaydate() +"'";
        Table table = database.execute(selectSql);
        Cursor cursor = table.rows();
        List<Rank> ranks = transferRankList(cursor);
        if(ranks.isEmpty()) return null;
        return ranks.get(0);
    }

    public void updateRank(Rank rank) throws IOException, ParseFailure {
        String sql = "update rank set score = " + rank.getScore() + " where id = \"" + rank.getId() + "\" AND playdate = \"" + rank.getPlaydate() + "\"";
        database.execute(sql);
        database.dump();
    }

    public void insertRank(Rank rank) throws IOException, ParseFailure {
        String sql = "insert into rank VALUES ('" + rank.getId() + "',"+rank.getScore() + ",'" + rank.getPlaydate()+ "')";
        database.execute(sql);
        database.dump();
    }

    private List<Rank> transferRankList(Cursor cursor){
        List<Rank> res = new ArrayList<>();
        int columnCnt = cursor.columnCount();
        while (cursor.advance()) {
            Map<String, Object> rowMap = new HashMap<>();
            for(int i = 0; i < columnCnt; i++){
                String columnName = cursor.columnName(i);
                Object value = cursor.column(columnName);
                rowMap.put(columnName, value);
            }
            res.add(new Rank(rowMap));
        }
        return res;
    }
}
