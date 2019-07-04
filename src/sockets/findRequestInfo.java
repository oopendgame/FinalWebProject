package sockets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	
}
