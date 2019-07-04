package WebPackage.chat;

public class messageInfo {
	private int id;
	private int user1Id;
	private int user2Id;
	private String sms;
	private String condition;
	private String time;
	public messageInfo(int id, int user1Id, int user2Id, String sms, String condition, String time) {
		this.id = id;
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.sms = sms;
		this.condition = condition;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	
	public int getUser1Id() {
		return user1Id;
	}
	
	public int getUser2Id() {
		return user2Id;
	}
	
	public String getSms() {
		return sms;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public String getTime() {
		return time;
	}

}
