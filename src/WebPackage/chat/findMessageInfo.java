package WebPackage.chat;

import WebPackage.database.DBInfo;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	
	
	public Vector<Integer> getMessageUsers(String userName) {
		Vector<Integer> vc = new Vector<Integer>();
		HashSet<Integer> st = new HashSet<Integer>();
		ResultSet res = null;
		int userId = 0;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName + "\";");
			if(res.next()) {
				userId = res.getInt("user_id");
			}
			//SELECT user1_id from sms where user2_id = 3 order by  sent_time desc;
			res = stmt.executeQuery("SELECT user1_id from sms where user2_id = \"" 
		+ userId + " order by  sent_time desc;");
			while(res.next()) {
				int user1Id = res.getInt("user1_id");
				if(!st.contains(user1Id)) {
					vc.addElement(user1Id);
					st.add(user1Id);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vc;
	
	}
}