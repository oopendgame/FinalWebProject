package WebPackage.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import WebPackage.database.DBInfo;

public class adminInfo {
		private Connection con;
		private Statement stmt;
		static String account = DBInfo.MYSQL_USERNAME; // replace with your account
		static String  password = DBInfo.MYSQL_PASSWORD; // replace with your password
		static String  server = DBInfo.MYSQL_DATABASE_SERVER;
		static String database = DBInfo.MYSQL_DATABASE_NAME ; // replace with your db
		public adminInfo(){
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
		public boolean isAdmin(int userId) {
			ResultSet res = null;
			try {
				res = stmt.executeQuery("SELECT * from admins where user_id = " + userId + ";");
				if(res.next()) {
					return true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
	


}
