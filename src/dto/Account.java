package dto;

import java.util.Map;

public class Account {
    private String id; // 아이디
    private String password; // 비밀번호
    private Integer level; // 레벨

    public Account(String id, String password, Integer level) {
        this.id = id;
        this.password = password;
        this.level = level;
    }

    public Account(Map<String, Object> rowMap) {
        this(rowMap.get("id").toString(), rowMap.get("password").toString(), Integer.parseInt(rowMap.get("level").toString()));
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Integer getLevel() {
        return level;
    }
}
