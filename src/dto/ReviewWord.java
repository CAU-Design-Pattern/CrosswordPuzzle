package dto;

import java.util.Map;

public class ReviewWord extends Review {
    private String desc; // 설명

    public ReviewWord(String id, String word, Integer count, String desc) {
        super(id, word, count);
        this.desc = desc;
    }

    public ReviewWord(Map<String, Object> rowMap) {
        super(rowMap);
        this.desc = rowMap.get("desc").toString();
    }

    public String getDesc() {
        return desc;
    }
}
