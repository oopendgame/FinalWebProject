package WebPackage.homepage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mysql.cj.util.StringUtils;

import WebPackage.challenge.challengeInfo;
import WebPackage.database.DBInfo;
import WebPackage.quiz.QuestionInfo;
import WebPackage.quiz.QuizInfo;
import WebPackage.quiz.findQuestionInfo;
import WebPackage.quiz.findQuizInfo;
import WebPackage.requests.findRequestInfo;
import WebPackage.requests.requestInfo;
import WebPackage.user.findUserInfo;
import WebPackage.user.userInfo;

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
			res = stmt.executeQuery("SELECT * from announcements order by announce_date desc;");
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
			String st = "SELECT * FROM quizScores GROUP BY quiz_id order by count(*) desc;";
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
	
	
	public ArrayList<QuizInfo> getTakenQuizzes(int id) {        
		ArrayList<QuizInfo> arr = new ArrayList<QuizInfo>();
		findQuizInfo fquiz = new findQuizInfo();
		Statement statement;
		try {
			String st = "SELECT * FROM quizScores WHERE user_id = '" + id + "' order by start_time desc;";
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
	
	public ArrayList<Activity> getFriendsActivities(int id) {        
		
		ArrayList<Activity> arr = new ArrayList<Activity>();
		
		findQuizInfo fquiz = new findQuizInfo();
		findRequestInfo req = new findRequestInfo();
		findUserInfo u = new findUserInfo();
		ArrayList<requestInfo> friendArr = req.getUserFriends(id);
		
		List<String> strList = new ArrayList<String>();
		
		for(int i = 0; i < friendArr.size(); i++) {
			int friend_id = u.getMyUser(friendArr.get(i).getUserName()).getId();
			strList.add(Integer.toString(friend_id));
		}

		Statement statement;
		try {
			String st = "SELECT user_id as userId, achievement as actId, ach_time as acttime, 'achiev' as activity " 
					+ "FROM achievements " 
					+ "WHERE user_id in ("+String.join(", ", strList)+") " 
					+ "union all "
					+ "SELECT author_id as userId, quiz_id as actId, creation_date as acttime, 'creation' as activity "
					+ "FROM quizzes "
					+ "WHERE author_id in ("+String.join(", ", strList)+") "
					+ "union all "
					+ "SELECT user_id as userId, quiz_id as actId, start_time as acttime, 'taking' as activity " 
					+ "FROM quizScores " 
					+ "WHERE user_id in ("+String.join(", ", strList)+") " 
					+ "order by acttime desc limit 100; ";
		
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(st);
			
			while(res.next()) {
				
				int userId = res.getInt("userId");
				String activity = res.getString("activity");
				Date date = res.getDate("acttime");
				Timestamp timestamp = res.getTimestamp("acttime");
				String actid = res.getString("actId");
				if (timestamp != null)
				   date = new java.util.Date(timestamp.getTime());
				
				Activity act = new Activity(userId, activity, actid, date); 
				arr.add(act);
				
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
