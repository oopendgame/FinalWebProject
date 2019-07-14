package WebPackage.user;
import WebPackage.database.DBInfo;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import WebPackage.database.DBConnection;

public class findUserInfo {	
	private Connection con;
	private Statement stmt;
	
	static String account = DBInfo.MYSQL_USERNAME; // replace with your account
	static String  password = DBInfo.MYSQL_PASSWORD; // replace with your password
	static String  server = DBInfo.MYSQL_DATABASE_SERVER;
	static String database = DBInfo.MYSQL_DATABASE_NAME ; // replace with your db
	 
	public findUserInfo(){
		
		con = DBConnection.getConnection();

		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeQuery("USE " + database);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean isUser(String userName) {
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName + "\";");
			if(res.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public userInfo getMyUser(String userName) {
		//userName = "nchan17";
		ResultSet res = null;
		userInfo myUser  = null;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName + "\";");
			if(res.next()) {
				int myId = res.getInt("user_id");
				String myUserName = res.getString("user_name");
				String name = res.getString("first_name");
				String lastName = res.getString("last_name");
				String email = res.getString("email");
				String birthday = res.getString("date_of_birth");
				String gender = res.getString("gender");
				String img = res.getString("img");
				myUser = new userInfo(myId, myUserName, name, lastName, img, email, birthday, gender);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myUser;
		
	}
	public userInfo getMyUser(int userId) {
		//userName = "nchan17";
		ResultSet res = null;
		userInfo myUser  = null;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_id = \"" + userId + "\";");
			if(res.next()) {
				int myId = res.getInt("user_id");
				String myUserName = res.getString("user_name");
				String name = res.getString("first_name");
				String lastName = res.getString("last_name");
				String email = res.getString("email");
				String birthday = res.getString("date_of_birth");
				String gender = res.getString("gender");
				String img = res.getString("img");
				myUser = new userInfo(myId, myUserName, name, lastName, img, email, birthday, gender);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myUser;
		
	}
	public void insertUrl(String userName, String setUrl) {
		//userName = "nchan17";
		try {
			stmt.executeUpdate("update userInfo set img = '" + setUrl + 
									"' where user_name='" + userName + "';");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getFriendStatus(String userName1, String userName2) {
		ResultSet res = null;
		int userId1 = 0;
		int userId2 = 0;
		String status = "";
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName1 + "\";");
			if(res.next()) {
				userId1 = res.getInt("user_id");
			}
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName2 + "\";");
			if(res.next()) {
				userId2 = res.getInt("user_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			res = stmt.executeQuery("SELECT * from friends where user1_id = \'" + userId1 
					+ "\' and user2_id = \'" + userId2 + "\';");
			if(!res.first()|| userId1 == 0 || userId2 == 0) {
				return "not friends";
			}
			status = res.getString("friends_status");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	public int getNumFriends(String userName) {
		ResultSet res = null;
		int num = 0;
		int userId = 0;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName + "\";");
			if(res.next()) {
				userId = res.getInt("user_id");
			}
			res = stmt.executeQuery("SELECT count(*) from friends where (user1_id = " 
		+ userId + " or user2_id = "  + userId + ") and friends_status = 1;");
			if(res.next()) {
				num = res.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public int getNumFriendRequests(String userName) {
		ResultSet res = null;
		int num = 0;
		int userId = 0;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName + "\";");
			if(res.next()) {
				userId = res.getInt("user_id");
			}
			res = stmt.executeQuery("SELECT count(*) from friends where user2_id = \"" 
		+ userId + "\" and friends_status = \"0\";");
			if(res.next()) {
				num = res.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	
}