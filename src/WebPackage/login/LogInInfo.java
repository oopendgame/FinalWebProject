package WebPackage.login;

public class LogInInfo {
	private int id;
	private String userName;
	private int search_id;
	
	public LogInInfo() {
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setSearchId(int search) {
		search_id = search;
	}
	
	public int getSearchId() {
		return search_id;
	}

}
