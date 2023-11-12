package models;

public class Word {
    private String word; // 단어
    private String desc; // 단어 설명
    private int level; // 단어 난이도
    private int length; // 단어 길이

    public Word(String word, String desc, int level, int length) {
        this.word = word;
        this.desc = desc;
        this.level = level;
        this.length = length;
    }

    public String getWord() {
        return word;
    }

    public String getDesc() {
        return desc;
    }

    public int getLevel() {
        return level;
    }

    public int getLength() {
        return length;
    }
}
