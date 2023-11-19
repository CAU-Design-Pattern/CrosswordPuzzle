package dto;

import java.util.Map;

// 랭킹 테이블
public class Rank {
    private String id; // 사용자 아이디
    private Integer score; // 점수
    private String playdate; // 플레이 날짜
    private Integer rank; // 랭킹

    public Rank(String id, Integer score, String playdate) {
        this.id = id;
        this.score = score;
        this.playdate = playdate;
    }

    public Rank(String id, Integer score, String playdate, Integer rank) {
        this.id = id;
        this.score = score;
        this.playdate = playdate;
        this.rank = rank;
    }

    public Rank(Map<String, Object> rowMap) {
        this(rowMap.get("id").toString(), Integer.parseInt(rowMap.get("score").toString()), rowMap.get("playdate").toString());
    }

    public String getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

    public String getPlaydate() {
        return playdate;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "id='" + id + '\'' +
                ", score=" + score +
                ", playdate='" + playdate + '\'' +
                ", rank=" + rank +
                '}';
    }
}
