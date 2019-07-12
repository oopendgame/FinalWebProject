package WebPackage.user;

public class userInfo {
	private int myId;
	private String myUserName;
	private String myName;
	private String myLastName;
	private String myImg;
	private String myEmail;
	private String myBirthday;
	private String myGender;
	private String myRank;
	
	public userInfo(int id, String userName, String name, String lastName, String img, 
			String email, String birthday, String gender) {
		myId = id;
		myUserName = userName;
		myName = name;
		myLastName = lastName;
		myImg = img;
		myEmail = email;
		myBirthday = birthday;
		myGender = gender;
	}
	public int getId() {
		return myId;
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
	public String getImg() {
		return myImg;
	}
	public String getEmail() {
		return myEmail;
	}
	public String getBirthday() {
		return myBirthday;
	}
	public String getGender() {
		return myGender;
	}
	public String getRank() {
		return myRank;
	}
	
	

}
