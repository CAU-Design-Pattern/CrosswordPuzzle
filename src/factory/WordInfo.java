package factory;

public class WordInfo {
	private char letter;
	private String desc;
	private WordPlacementStrategy wordPlacementStrategy;
	
	public WordInfo(char letter, String desc, WordPlacementStrategy wordPlacementStrategy) {
		this.letter = letter;
		this.desc = desc;
		this.wordPlacementStrategy = wordPlacementStrategy;
	}
	
	public WordInfo() {
		this('@', " ", WordPlacementStrategy.HORIZONTAL);
	}
	
	public char getLetter() {
		return letter;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public WordPlacementStrategy getWordPlacementStrategy() {
		return wordPlacementStrategy;
	}
	
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void setWordPlacementStrategy(WordPlacementStrategy wordPlacementStrategy) {
		this.wordPlacementStrategy = wordPlacementStrategy;
	}
}