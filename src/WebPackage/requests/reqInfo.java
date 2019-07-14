package WebPackage.requests;

import java.util.ArrayList;

public interface reqInfo {
	
	public void addRequest(requestInfo req);
	public void addFriend(int user1_id, int user2_id);
	public void rejectRequest(int user1_id, int user2_id);
	public ArrayList<requestInfo> getUserFriends(int id);
	public boolean areFriends(int user1_id, int user2_id);
	public boolean requestAlreadySent(int user1_id, int user2_id);
	public void removeFriend(int user1_id, int user2_id);
	public ArrayList<requestInfo> getUserRequests(int id);
	

}
