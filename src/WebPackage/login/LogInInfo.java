package WebPackage.login;

public class LogInInfo {
	private int id;
	private String userName;
	
	public LogInInfo(int id, String userName, String password) {
		this.id = id;
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}

}
