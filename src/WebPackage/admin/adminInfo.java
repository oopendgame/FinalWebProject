package WebPackage.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import WebPackage.database.DBInfo;
import WebPackage.user.findUserInfo;

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
		public boolean isAdmin(String username) {
			ResultSet res = null;
			int userId = -1;
			try {
				res = stmt.executeQuery("SELECT * from userInfo where user_name = '" + username + "';");
				if(res.next()) {
					userId = res.getInt("user_id");
				}
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
		
		public void deleteUser(String username) {
			
		}
	
		public boolean deleteQuiz(String quizName) {
			ResultSet res = null;
			int quizId = -1;
			try {
				res = stmt.executeQuery("SELECT * from quizzes where quiz_name = '" + quizName + "';");
				if(res.next()) {
					quizId = res.getInt("quiz_id");
				}
				/* select * from quizScores;
				delete from popularity where quis_id;*/
				if(quizId == -1) return false;
				stmt.executeUpdate("delete from popularity where quiz_id = " + quizId + ";");
				stmt.executeUpdate("delete from quizScores where quiz_id = " + quizId + ";");
				res = stmt.executeQuery("SELECT quietion_id from quiestions where quiz_id = " + quizId + ";");
				while(res.next()) {
					int quietionId = res.getInt("quietion_id");
					stmt.executeUpdate("delete from answers where quietion_id = " + quietionId + ";");
				}
				stmt.executeUpdate("delete from questions where quiz_id = " + quizId + ";");
				stmt.executeUpdate("delete from quizzes where quiz_id = " + quizId + ";");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		
		public boolean clearQuizHistory(String quizName) {
			ResultSet res = null;
			int quizId = -1;
			try {
				res = stmt.executeQuery("SELECT * from quizzes where quiz_name = '" + quizName + "';");
				if(res.next()) {
					quizId = res.getInt("quiz_id");
				}
				/* select * from quizScores;
				delete from popularity where quis_id;*/
				if(quizId == -1) return false;
				stmt.executeUpdate("delete from popularity where quiz_id = " + quizId + ";");
				stmt.executeUpdate("delete from quizScores where quiz_id = " + quizId + ";");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
			
		}
		
		public boolean promoteToAdmin(String username) {
			ResultSet res = null;
			int userId = -1;
			try {
				res = stmt.executeQuery("SELECT * from userInfo where user_name = '" + username + "';");
				if(res.next()) {
					userId = res.getInt("user_id");
				}
				//INSERT INTO admins (user_id) VALUES
				//(3);
				if(userId == -1) return false;
				stmt.executeUpdate("INSERT INTO admins (user_id) VALUES(" + userId + ");");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(userId == -1) return false;
			return true;
		}

}
