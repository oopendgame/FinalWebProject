package WebPackage.homepage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import WebPackage.challenge.challengeInfo;
import WebPackage.database.DBInfo;
import WebPackage.quiz.QuestionInfo;
import WebPackage.quiz.QuizInfo;
import WebPackage.quiz.findQuestionInfo;
import WebPackage.quiz.findQuizInfo;

public class homepageInfo {
	
	private Connection con;
	private Statement stmt;
	
	static String account = DBInfo.MYSQL_USERNAME; 
	static String password = DBInfo.MYSQL_PASSWORD;
	static String server = DBInfo.MYSQL_DATABASE_SERVER;
	static String database = DBInfo.MYSQL_DATABASE_NAME ; 
	
	public homepageInfo(){
		
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
	
	
	
	public ArrayList<announcement> getAnnouncements() {
		ArrayList<announcement> ls = new ArrayList<announcement>();
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT * from announcement order by announce_date desc;");
			while(res.next()) {
				 
				int id = res.getInt("ann_id");
				String title = res.getString("title");
				String ann = res.getString("announcement");
				int admin = res.getInt("admin_id");
				Date date = res.getDate("announce_date");
				Timestamp timestamp = res.getTimestamp("announce_date");
				if (timestamp != null)
				   date = new java.util.Date(timestamp.getTime());
				announcement announc = new announcement(id, title , ann , date, admin);
				ls.add(announc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}
	
	
	public ArrayList<QuizInfo> getQuizzesByDate() {        
		ArrayList<QuizInfo> arr = new ArrayList<QuizInfo>();
		findQuizInfo fquiz = new findQuizInfo();
		Statement statement;
		try {
			String st = "SELECT * FROM quizzes order by creation_date desc;";
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(st);
			while(res.next()) {
				int id = res.getInt("quiz_id");
				arr.add(fquiz.getQuiz(id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
	
	public ArrayList<QuizInfo> getQuizzesByPopularity() {        
		ArrayList<QuizInfo> arr = new ArrayList<QuizInfo>();
		findQuizInfo fquiz = new findQuizInfo();
		Statement statement;
		try {
			String st = "SELECT * FROM popularity order by user_num desc;";
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(st);
			while(res.next()) {
				int id = res.getInt("quiz_id");
				arr.add(fquiz.getQuiz(id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
	
	
	public ArrayList<QuizInfo> getMyQuizzes(int id) {        
		ArrayList<QuizInfo> arr = new ArrayList<QuizInfo>();
		findQuizInfo fquiz = new findQuizInfo();
		Statement statement;
		try {
			String st = "SELECT * FROM quizzes WHERE author_id = '" + id + "' order by creation_date desc;";
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(st);
			while(res.next()) {
				int qid = res.getInt("quiz_id");
				arr.add(fquiz.getQuiz(qid));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
	public int userIdbyAdmin(int id) {
		
		int s = 0;
		Statement statement;
		try {
			String st = "SELECT * FROM admins WHERE admin_id = " + id + ";";
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(st);
			while(res.next()) {
				s = res.getInt("user_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	
	
	
}
