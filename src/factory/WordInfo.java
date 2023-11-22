package factory;

public class WordInfo {
	private char letter;
	private String acrossDesc;
	private String downDesc;
	private WordPlacementStrategy wordPlacementStrategy;
	
	public WordInfo(char letter, String acrossDesc, String downDesc, WordPlacementStrategy wordPlacementStrategy) {
		this.letter = letter;
		this.acrossDesc = acrossDesc;
		this.downDesc = downDesc;
		this.wordPlacementStrategy = wordPlacementStrategy;
	}
	
	public WordInfo() {
		this('@', " ", " ", WordPlacementStrategy.NONE);
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
	
	public WordPlacementStrategy getWordPlacementStrategy() {
		return wordPlacementStrategy;
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
	
	public void setWordPlacementStrategy(WordPlacementStrategy wordPlacementStrategy) {
		this.wordPlacementStrategy = wordPlacementStrategy;
	}
}