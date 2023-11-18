package dto;

import java.util.Map;

// 오답노트
public class Review {
    private String id; // 사용자 아이디
    private String word; // 단어
    private Integer count; // 틀린 횟수

    public Review(String id, String word, Integer count) {
        this.id = id;
        this.word = word;
        this.count = count;
    }

    public Review(Map<String, Object> rowMap){
        this(rowMap.get("id").toString(), rowMap.get("word").toString(), Integer.parseInt(rowMap.get("count").toString()));
    }

    public String getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}
