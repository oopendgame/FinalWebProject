package WebPackage;

public class userInfo {
	private int myId;
	private String myUserName;
	private String myName;
	private String myLastName;
	private String myImg;
	private String myEmail;
	private String myBirthday;
	private String myGender;
	
	public userInfo(String username) {
		myUserName = username;
		
	}
	public String getUserName() {
		return myUserName;
	}
	public String getName() {
		return myName;
	}
	public String getLastName() {
		return myLastName;
	}
	public String getMyEmail() {
		return myEmail;
	}
	public String getMyBirthday() {
		return myBirthday;
	}
	public String getMyGender() {
		return myGender;
	}
	
	

}
