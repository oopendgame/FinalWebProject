package WebPackage.challenge;

import java.util.Date;

public class challengeInfo {
	
	private int id;
	private int user1Id;
	private int user2Id;
	private String link;
	private Date date;
	public challengeInfo(int id, int user1Id, int user2Id, String link, Date date) {
		this.id = id;
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.link = link;
		this.date = date;
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
	
	public String getLink() {
		return link;
	}
	
	public Date getDate() {
		System.out.println();
		return date;
	}
}
