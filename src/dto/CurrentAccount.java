package dto;

public class CurrentAccount {
	private static CurrentAccount instance;
	private String id;
	private String password;
	
	private CurrentAccount(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public static CurrentAccount getInstance() {
		if (instance == null) {
			instance = new CurrentAccount("", "");
		}
		return instance;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
