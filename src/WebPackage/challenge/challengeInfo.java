package WebPackage.challenge;

public class challengeInfo {
	
	private int id;
	private int user1Id;
	private int user2Id;
	private String link;
	public challengeInfo(int id, int user1Id, int user2Id, String link) {
		this.id = id;
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.link = link;
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
}
