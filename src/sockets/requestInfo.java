package sockets;

import java.sql.Date;

public class requestInfo {
	private int req_id;
	private int user1;
	private int user2;
	private boolean status;
	private Date sent_date;
	
	public requestInfo(int req, int user1_id, int user2_id, boolean stat, Date date) {
		req_id = req;
		user1 = user1_id;
		user2 = user2_id;
		status = stat;
		sent_date = date;
	}
	
	public int getRequestId() {
		return req_id;
	}
	
	public int getSenderID() {
		return user1;
	}
	
	public int getReceiverID() {
		return user2;
	}
	
	public boolean getSatus() {
		return status;
	}
	
	public void setStatus(boolean fr) {
		status = fr;
	}
	
	public Date getSentDate() {
		return sent_date;
	}
}
