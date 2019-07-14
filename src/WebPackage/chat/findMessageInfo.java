package WebPackage.chat;

import WebPackage.database.DBInfo;
import WebPackage.login.LogInInfo;
import WebPackage.user.findUserInfo;
import WebPackage.user.userInfo;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

import WebPackage.database.DBConnection;
 
public class findMessageInfo {	
	private Connection con;
	private Statement stmt;
	
	static String account = DBInfo.MYSQL_USERNAME; // replace with your account
	static String  password = DBInfo.MYSQL_PASSWORD; // replace with your password
	static String  server = DBInfo.MYSQL_DATABASE_SERVER;
	static String database = DBInfo.MYSQL_DATABASE_NAME ; // replace with your db
	
	public findMessageInfo(){
		
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
	//update sms set sms_condition = 'read' where user1_id = 1 and user2_id = 3;

	public int getNumUnseenChats(String userName) {
		int res = 0;
	 	findUserInfo fuserInfo = new findUserInfo();
	    ArrayList<messageInfo> latestMessageInfo = this.getMessageByUsers(userName);
	    for(int i = 0; i < latestMessageInfo.size(); i++) {
	    	messageInfo  msgInf = latestMessageInfo.get(i);
			userInfo sender = fuserInfo.getMyUser(msgInf.getUser1Id());
			if(msgInf.getCondition().equals("sent") && !sender.getUserName().equals(userName)){
				res++;
			}
	    }
	    return res;
		
	}
	public void setSmsSeen(int senderId, int getterId) {
		try {
			stmt.executeUpdate("update sms set sms_condition = 'read' where user1_id = " 
								+ senderId + " and user2_id = " + getterId + ";");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	INSERT INTO sms(user1_id, user2_id, sms,  sent_time) VALUES
//	(2, 3, "geniosi xar!",  sysdate());
	public void putSms(int senderId, int getterId, String sms) {
		try {
			stmt.executeUpdate("INSERT INTO sms(user1_id, user2_id, sms, sent_time) VALUES (" 
								+ senderId + ", " + getterId + "," + "\"" + sms + "\"," + "sysdate());");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//SELECT * from sms where (user2_id = 3 and user1_id = 1) or (user1_id = 3 and user2_id = 1)
	//order by  sent_time desc;
	public ArrayList<messageInfo> getAllMessagesBetween(String userName, int userId2) {
		ArrayList<messageInfo> ls = new ArrayList<messageInfo>();
		ResultSet res = null;
		int userId1 = -1;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName + "\";");
			if(res.next()) {
				userId1 = res.getInt("user_id");
			}
			res = stmt.executeQuery("SELECT * from sms where (user1_id = \"" 
		+ userId1 + "\" and user2_id = \"" + userId2 + "\") or (user2_id = \""
		+ userId1 + "\" and user1_id = \"" + userId2
					+ "\") order by  sent_time desc;");
			while(res.next()) {
				 //messageInfo(int id, int user1Id, int user2Id, String sms, String condition, String time)
				int id = res.getInt("sms_id");
				int user1 = res.getInt("user1_Id");
				int user2 = res.getInt("user2_Id");
				String sms = res.getString("sms");
				String condition = res.getString("sms_condition");
				String time = res.getString("sent_time");
				messageInfo currInfo = new messageInfo(id, user1 , user2 , sms, condition, time);
				ls.add(currInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}
	public ArrayList<messageInfo> getAllMessages(String userName, String userName2) {
		ArrayList<messageInfo> ls = new ArrayList<messageInfo>();
		ResultSet res = null;
		int userId1 = -1;
		int userId2 = -1;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName + "\";");
			if(res.next()) {
				userId1 = res.getInt("user_id");
			}
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName2 + "\";");
			if(res.next()) {
				userId2 = res.getInt("user_id");
			}
			res = stmt.executeQuery("SELECT * from sms where (user1_id = \"" 
		+ userId1 + "\" and user2_id = \"" + userId2 + "\") or (user2_id = \""
		+ userId1 + "\" and user1_id = \"" + userId2
					+ "\") order by  sent_time desc;");
			while(res.next()) {
				 //messageInfo(int id, int user1Id, int user2Id, String sms, String condition, String time)
				int id = res.getInt("sms_id");
				int user1 = res.getInt("user1_Id");
				int user2 = res.getInt("user2_Id");
				String sms = res.getString("sms");
				String condition = res.getString("sms_condition");
				String time = res.getString("sent_time");
				messageInfo currInfo = new messageInfo(id, user1 , user2 , sms, condition, time);
				ls.add(currInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}
	
	public String getLatestMessage(String userName, int userId2) {
		ResultSet res = null;
		int userId1 = -1;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName + "\";");
			if(res.next()) {
				userId1 = res.getInt("user_id");
			}
			res = stmt.executeQuery("SELECT user1_id from sms where user1_id = \"" 
		+ userId1 + "\" and user2_id = \"" + userId2 + "\" order by  sent_time desc;");
			if(res.next()) {
				String message = res.getString("sms");
				return message;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}
	
	
	
	public ArrayList<messageInfo> getMessageByUsers(String userName) {
		ArrayList<messageInfo> ls = new ArrayList<messageInfo>();
		HashSet<Integer> st = new HashSet<Integer>();
		ResultSet res = null;
		int userId = 0;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName + "\";");
			if(res.next()) {
				userId = res.getInt("user_id");
			}
			//SELECT * from sms where user2_id = 3 or user1_id = 3 order by  sent_time desc;
			res = stmt.executeQuery("SELECT * from sms where user1_id = \"" + userId + "\" or user2_id = \"" + userId 
					+ "\" order by  sent_time desc;");
			boolean selfTalk = false;
			while(res.next()) {
				int user1 = res.getInt("user1_Id");
				int user2 = res.getInt("user2_Id");
				boolean bothMe = false;
				if(user1 == user2) bothMe = true;
				if(!st.contains(user1) && !st.contains(user2) && !(bothMe && selfTalk)) {
					int id = res.getInt("sms_id");
					String sms = res.getString("sms");
					String condition = res.getString("sms_condition");
					String time = res.getString("sent_time");
					messageInfo currInfo = new messageInfo(id, user1 , user2 , sms, condition, time);
					ls.add(currInfo);
					if(user1 == userId &&  user2 == userId) selfTalk = true;
					else if(user1 == userId) st.add(user2);
					else st.add(user1);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	
	}
}