package WebPackage.challenge;
 
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import WebPackage.database.DBInfo;

public class findChallenges {
	private Connection con;
	private Statement stmt;
	
	static String account = DBInfo.MYSQL_USERNAME; 
	static String password = DBInfo.MYSQL_PASSWORD;
	static String server = DBInfo.MYSQL_DATABASE_SERVER;
	static String database = DBInfo.MYSQL_DATABASE_NAME ; 
	
	public findChallenges(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection
						( "jdbc:mysql://" + server, account ,password);
			stmt = con.createStatement();
			stmt.executeQuery("USE " + database);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<challengeInfo> getChallenges(String userName) {
		ArrayList<challengeInfo> ls = new ArrayList<challengeInfo>();
		ResultSet res = null;
		int userId = -1;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName + "\";");
			if(res.next()) {
				userId = res.getInt("user_id");
			}
			res = stmt.executeQuery("SELECT * from challenges where user2_id = \"" + userId + "\" order by sending_time desc;");
			while(res.next()) {
				 
				int id = res.getInt("challenge_id");
				int user1 = res.getInt("user1_Id");
				int user2 = res.getInt("user2_Id");
				String link = res.getString("link");
				Date date = res.getDate("sending_time");
				Timestamp timestamp = res.getTimestamp("sending_time");
				if (timestamp != null)
				   date = new java.util.Date(timestamp.getTime());
				challengeInfo currInfo = new challengeInfo(id, user1 , user2 , link, date);
				ls.add(currInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}
	
	public void updateChallengeInfo(String username) {
		ResultSet res = null;
		int userId = -1;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + username + "\";");
			if(res.next()) {
				userId = res.getInt("user_id");
			}
			stmt.executeUpdate("UPDATE challenges SET seen = true where user2_id =\"" + userId + "\";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int OldChallengesNum(String username) {
		ResultSet res = null;
		int count = 0;
		int userId = -1;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + username + "\";");
			if(res.next()) {
				userId = res.getInt("user_id");
			}
			res = stmt.executeQuery("SELECT COUNT(*) AS total from challenges where user2_id =\"" + userId + "\" and seen = true;");
			if(res.next()) count = res.getInt("total");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int numNewChallenges(String username) {
		ResultSet res = null;
		int count = 0;
		int userId = -1;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + username + "\";");
			if(res.next()) {
				userId = res.getInt("user_id");
			}
			res = stmt.executeQuery("SELECT COUNT(*) AS total from challenges where user2_id =\"" + userId + "\" and seen = false;");
			if(res.next()) count = res.getInt("total");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
