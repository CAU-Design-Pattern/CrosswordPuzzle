package factory;

public class WordInfo {
	private char letter;
	private String acrossDesc;
	private String downDesc;
	private int level;
	
	public WordInfo(char letter, String acrossDesc, String downDesc, int level) {
		this.letter = letter;
		this.acrossDesc = acrossDesc;
		this.downDesc = downDesc;
		this.level = level;
	}
	
	public WordInfo() {
		this('*', " ", " ", 0);
	}
	
	public char getLetter() {
		return letter;
	}
	
	public String getAcrossDesc() {
		return acrossDesc;
	}
	
	public String getDownDesc() {
		return downDesc;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	public void setAcrossDesc(String acrossDesc) {
		this.acrossDesc = acrossDesc;
	}
	
	public void setDownDesc(String downDesc) {
		this.downDesc = downDesc;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
}