package WebPackage.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import WebPackage.database.DBInfo;

public class findAchievementInfo {
	private Connection con;
	private Statement stmt;
	static String account = DBInfo.MYSQL_USERNAME; // replace with your account
	static String  password = DBInfo.MYSQL_PASSWORD; // replace with your password
	static String  server = DBInfo.MYSQL_DATABASE_SERVER;
	static String database = DBInfo.MYSQL_DATABASE_NAME ; // replace with your db
	public findAchievementInfo(){
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
	public ArrayList<String> getUserAchievements(int userId){
		ArrayList<String> list = new ArrayList<String>();
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT achievement FROM achievements where user_id = " 
					+ userId + " order by ach_time desc;");
			while(res.next()) {
				list.add(res.getString("achievement"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void refreshAchQuizTaken(int userId, int quizId) {
		try {
			if(this.getNumQuizTaken(userId) == 10) {
				stmt.executeUpdate("INSERT INTO achievements (user_id, achievement, ach_time) VALUES(" 
						+ userId + ", 'Quiz Machine', sysdate());");
			}
			if(this.gotHighestScore(userId, quizId)) {
				stmt.executeUpdate("INSERT INTO achievements (user_id, achievement, ach_time) VALUES(" 
						+ userId + ", 'I am the Greatest', sysdate());");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void refreshAchQuizCreate(int userId) {
		try {
			if(this.getNumQuizCreated(userId) == 1) {
				stmt.executeUpdate("INSERT INTO achievements (user_id, achievement, ach_time) VALUES(" 
			+ userId + ", 'Amateur Author', sysdate();)");
			}else if (this.getNumQuizCreated(userId) == 5) {
				stmt.executeUpdate("INSERT INTO achievements (user_id, achievement, ach_time) VALUES(" 
						+ userId + ", 'Prolific Author', sysdate());");
			}else if (this.getNumQuizCreated(userId) == 10) {
				stmt.executeUpdate("INSERT INTO achievements (user_id, achievement, ach_time) VALUES(" 
						+ userId + ", 'Prodigious Author', sysdate());");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getNumQuizCreated(int userId) {
		ResultSet res = null;
		try {
			res = stmt.executeQuery("select count(*) from quizzes where author_id = " + userId + ";");
			if(res.next()) {
				return res.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getNumQuizTaken(int userId) {
		ResultSet res = null;
		try {
			res = stmt.executeQuery("select count(*) from quizScores where user_id = " + userId + ";");
			if(res.next()) {
				return res.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//select * from quizScores order by score desc;
	public boolean gotHighestScore(int userId, int quizId) {
		ResultSet res = null;
		try {
			res = stmt.executeQuery("select * from quizScores where quiz_id = " + quizId + " order by score desc;");
			if(res.next()) {
				 if(res.getInt("user_id") == userId) return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
