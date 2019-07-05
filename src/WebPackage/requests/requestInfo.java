package WebPackage.requests;

import java.sql.Date;

public class requestInfo {
	private int req_id;
	private int user1;
	private int user2;
	private int status;
	private Date sent_date;
	private String userName;
	
	public requestInfo(int req, int user1_id, int user2_id, int stat, Date date, String name) {
		req_id = req;
		user1 = user1_id;
		user2 = user2_id;
		status = stat;
		sent_date = date;
		userName = name;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String name) {
		userName = name;
	}
	
	public int getRequestId() {
		return req_id;
	}
	
	public int getSenderID() {
		return user1;
	}
	
	public void setSenderID(int id) {
		user1 = id;
	}
	
	public int getReceiverID() {
		return user2;
	}
	
	public void setReceiverID(int id) {
		user2 = id;
	}
	
	public int getSatus() {
		return status;
	}
	
	public void setStatus(int fr) {
		status = fr;
	}
	
	public Date getSentDate() {
		return sent_date;
	}
	
	public void setDate(Date date) {
		sent_date = date;
	}
}
