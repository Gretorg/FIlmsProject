package model;

public class Users {
	
	protected int user_id;
	protected String login;
	protected String password;
	protected String status;
	
	public Users(int user_id,String login,String password,String status) {
		super();
		this.user_id=user_id;
		this.login=login;
		this.password=password;
		this.status=status;
	}
	
	public Users(String login,String status) {
		super();
		this.login=login;
		this.status=status;
	}
	public Users(String login) {
		super();
		this.login=login;
	}


	public int getUserId() {
		return user_id;
	}
	public void setUserId(int user_id) {
		this.user_id = user_id;
	}
	
	public String getUserLogin() {
		return login;
	}
	public void setUserLogin(String login) {
		this.login=login;
	}
	
	public String getUserPassword() {
		return password;
	}
	public void setUserPassword(String password) {
		this.password=password;
	}
	
	public String getUserStatus() {
		return status;
	}
	public void setUserStatus(String status) {
		this.status=status;
	}
}
