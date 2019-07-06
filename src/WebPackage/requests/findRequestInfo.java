package WebPackage.requests;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import WebPackage.database.DBConnection;

public class findRequestInfo {

	private Connection con;
	
	public findRequestInfo() {
		con = DBConnection.getConnection();
	}
	
	private String getUserName(int id) {
		String name = "";
		try {
			Statement nameStm = con.createStatement();
			ResultSet set = nameStm.executeQuery("Select user_name from userInfo where user_id = " + id);
			if(set.next()) name = set.getString("user_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public void addRequest(requestInfo req) {
		String st = "INSERT INTO friends (user1_id, "
										+ "user2_id, "
										+ "friends_status, "
										+ "sending_date) "
										+ "VALUES(?, ?, ?, ?);";
		try {
			PreparedStatement stm = con.prepareStatement(st);
			stm.setInt(1, req.getSenderID());
			stm.setInt(2, req.getReceiverID());
			stm.setInt(3, req.getSatus());
			stm.setDate(4, req.getSentDate());
			stm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void addFriend(int user1_id, int user2_id) {
		String st = "UPDATE friends SET friends_status = 1 "
				+ "WHERE user1_id = " + user1_id
				+ " AND user2_id = " + user2_id + ";";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(st);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void rejectRequest(int user1_id, int user2_id) {
		String st = "UPDATE friends SET friends_status = -1 "
				+ "WHERE user1_id = " + user1_id
				+ " AND user2_id = " + user2_id + ";";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(st);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<requestInfo> getUserFriends(int id) {
		ArrayList<requestInfo> req = new ArrayList<requestInfo>();
		String st = "SELECT friends_id, user1_id, user2_id, friends_status, sending_date "
					+ "FROM friends "
					+ "WHERE user2_id = " + id 
					+ " OR user1_id = " + id
					+ " AND friends_status = true;";
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(st);	
			
			while(res.next()) {
				int req_id = res.getInt("friends_id");
				int user1_id = res.getInt("user1_id");
				int user2_id = res.getInt("user2_id");
				Date date = res.getDate("sending_date"); 
				String name = getUserName(user1_id);			
				requestInfo cur = new requestInfo(req_id, user1_id, user2_id, 1, date, name);
				req.add(cur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return req;
	}
	
	
	public ArrayList<requestInfo> getUserRequests(int id) {
		ArrayList<requestInfo> req = new ArrayList<requestInfo>();
		String st = "SELECT friends_id, user1_id, user2_id, friends_status, sending_date "
					+ "FROM friends "
					+ "WHERE user2_id = " + id 
					+ " AND friends_status = 0;";
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(st);	
			
			while(res.next()) {
				int user1_id = res.getInt("user1_id"); 
				int user2_id = res.getInt("user2_id");
				int req_id = res.getInt("friends_id");
				Date date = res.getDate("sending_date"); 
				String name = getUserName(user1_id);
				requestInfo cur = new requestInfo(req_id, user1_id, user2_id, 0, date, name);
				req.add(cur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return req;
	}
	
	
}
