package WebPackage.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import WebPackage.database.DBConnection;
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
		public boolean isQuiz(String quizName) {
			ResultSet res = null;
			try {
				res = stmt.executeQuery("SELECT * from quizzes where quiz_name = '" + quizName + "';");
				if(res.next()) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		public int getNumWebUsers() {
			ResultSet res = null;
			int num = 0;
			try {
				res = stmt.executeQuery("SELECT count(*) from userInfo;");
				if(res.next()) {
					num = res.getInt("count(*)");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return num;
		}
		
		public int getNumWebQuizzes() {
			ResultSet res = null;
			int num = 0;
			try {
				res = stmt.executeQuery("SELECT count(*) from quizzes;");
				if(res.next()) {
					num = res.getInt("count(*)");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return num;
		}
		
		public boolean deleteUser(String username) {
			ResultSet res = null;
			int userId = -1;
			try {
				res = stmt.executeQuery("SELECT * from userInfo where user_name = '" + username + "';");
				if(res.next()) {
					userId = res.getInt("user_id");
				}
				if(userId == -1 || this.isAdmin(username)) return false;
				this.deleteChallanges(userId);
				this.deleteFriends(userId);
				this.deletePass(userId);
				this.deleteSms(userId);
				res = stmt.executeQuery("SELECT * from quizzes where author_id = " + userId + ";");
				while(!res.isClosed() && res.next()) {
					this.deleteQuiz(res.getString("quiz_name"));
				}
				stmt.executeUpdate("delete from userInfo where user_id = " + userId + ";");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		private void deletePass(int userId) {
			try {
				stmt.executeUpdate("delete from passwords where user_id = " + userId + ";");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private void deleteSms(int userId) {
			try {
				stmt.executeUpdate("delete from sms where user1_id = " + userId + " or user2_id = " + userId + ";");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private void deleteChallanges(int userId) {
			try {
				stmt.executeUpdate("delete from challenges where user1_id = " + userId + " or user2_id = " + userId + ";");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	
		private void deleteFriends(int userId) {
			try {
				stmt.executeUpdate("delete from friends where user1_id = " + userId + " or user2_id = " + userId + ";");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
				this.clearQuizHistory(quizName);
				res = stmt.executeQuery("SELECT question_id from questions where quiz_id = " + quizId + ";");
				while(!res.isClosed() && res.next()) {
					int questionId = res.getInt("question_id");
					stmt.executeUpdate("delete from answers where question_id = " + questionId + ";");
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
