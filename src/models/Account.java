package models;

public class Account {
	private static Account instance;
	
	private String id;
	private String password;
	
	private Account() {
		id = "";
		password = "";
	}
	
	private Account(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public static Account getInstance() {
		if (instance == null) {
			instance = new Account();
		}
		return instance;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void trySignIn() {
		// TODO
	}
}
