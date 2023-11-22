package factory;

public class WordInfo {
	private char letter;
	private String acrossDesc;
	private String downDesc;
	
	public WordInfo(char letter, String acrossDesc, String downDesc) {
		this.letter = letter;
		this.acrossDesc = acrossDesc;
		this.downDesc = downDesc;
	}
	
	public WordInfo() {
		this('@', " ", " ");
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
	
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	public void setAcrossDesc(String acrossDesc) {
		this.acrossDesc = acrossDesc;
	}
	
	public void setDownDesc(String downDesc) {
		this.downDesc = downDesc;
	}
}