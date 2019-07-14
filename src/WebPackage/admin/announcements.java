package WebPackage.admin;
import WebPackage.database.DBInfo;
import WebPackage.user.userInfo;
import WebPackage.database.DBConnection;


import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.DriverManager;
import java.sql.SQLException;

public class announcements {
	private Connection con;
	private Statement stmt;
	static String account = DBInfo.MYSQL_USERNAME; // replace with your account
	static String  password = DBInfo.MYSQL_PASSWORD; // replace with your password
	static String  server = DBInfo.MYSQL_DATABASE_SERVER;
	static String database = DBInfo.MYSQL_DATABASE_NAME ; // replace with your db
	public announcements(){
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
	//INSERT INTO announcement(title, announcement, announce_date, admin_id) VALUES
	//("title", "announcement", sysdate(), 1);
	public void makeAnnouncement(int id, String title, String ann) {
		ResultSet res = null;
		int userId = -1;
		try {
			res = stmt.executeQuery("SELECT * from admins where user_id = " + id + ";");
			if(res.next()) {
				userId = res.getInt("admin_id");
			}
			stmt.executeUpdate("INSERT INTO announcements(title, announcement, announce_date, admin_id) VALUES ('" 
		+ title + "', '" + ann + "', sysdate(), " + userId + ");");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
