package sockets;

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
	
	public void addRequest(requestInfo req) {
		String st = "INSERT INTO friends (user1_id, "
										+ "user2_id, "
										+ "friends_satus "
										+ "sending_date) "
										+ "VALUES(?, ?, ?, ?);";
		try {
			PreparedStatement stm = con.prepareStatement(st);
			stm.setInt(1, req.getSenderID());
			stm.setInt(2, req.getReceiverID());
			stm.setBoolean(3, req.getSatus());
			stm.setDate(4, req.getSentDate());
			stm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<requestInfo> getUserFriends(int id) {
		ArrayList<requestInfo> req = new ArrayList<requestInfo>();
		String st = "SELECT user1_id, user2_id, friends_satus, sending_date "
					+ "FROM friends "
					+ "WHERE user2_id = " + id 
					+ " AND friends_satus = true";
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(st);			
			int req_id = res.getInt("friends_id");
			int user1_id = res.getInt("user1_id");
			int user2_id = res.getInt("user2_id");
			Date date = res.getDate("sending_date"); 
			
			while(res.next()) {
				requestInfo cur = new requestInfo(req_id, user1_id, user2_id, true, date);
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
		String st = "SELECT user1_id, user2_id, friends_satus, sending_date "
					+ "FROM friends "
					+ "WHERE user2_id = " + id 
					+ " AND friends_satus = false";
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(st);			
			int req_id = res.getInt("friends_id");
			int user1_id = res.getInt("user1_id");
			int user2_id = res.getInt("user2_id");
			Date date = res.getDate("sending_date"); 
			
			while(res.next()) {
				requestInfo cur = new requestInfo(req_id, user1_id, user2_id, false, date);
				req.add(cur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return req;
	}
	
	
}
