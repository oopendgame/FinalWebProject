package WebPackage.quizScores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import WebPackage.database.DBConnection;
import WebPackage.database.DBInfo;
import WebPackage.quiz.QuestionInfo;
import WebPackage.quiz.QuizInfo;
import WebPackage.quiz.findAnswerInfo;
import WebPackage.quiz.findQuizInfo;
import WebPackage.requests.findRequestInfo;
import WebPackage.requests.requestInfo;

public class findQuizScoreInfo {	
	private Connection con;
	
	public findQuizScoreInfo() {
		con = DBConnection.getConnection();
	}
	
	
	public void addUserWrittenQuiz(int quiz_id, int user_id, int score, Timestamp start_time, int duration) {
		String st = "INSERT INTO quizScores (quiz_id, user_id, score, start_time, duration) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(st);
			preparedStatement.setInt(1, quiz_id);
			preparedStatement.setInt(2, user_id);
			preparedStatement.setInt(3, score);
			preparedStatement.setTimestamp(4, start_time);
			preparedStatement.setInt(5, duration);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private ArrayList<QuizScoreInfo> getList(String st) {
		//System.out.println(st + "\n");
		ResultSet rs;
		ArrayList<QuizScoreInfo> arr = new ArrayList<QuizScoreInfo>();
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(st);
			while (rs.next()) {
				int quiz_id = rs.getInt("quiz_id");
				int user_id = rs.getInt("user_id");
				int score = rs.getInt("score");
				Date start_time = rs.getDate("start_time");
				int duration = rs.getInt("duration");				
				
				QuizScoreInfo quiz = new QuizScoreInfo(quiz_id, user_id, score, start_time, duration);
				arr.add(quiz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	
	public ArrayList<QuizScoreInfo> getUserWrittenQuizzes(int id) {
		String st = "SELECT quiz_id FROM quizScores where user_id = " + id + ";";
		
		return getList(st);
	}
	
	
	public ArrayList<QuizScoreInfo> getPopularQuizzes() {
		String st = "SELECT quiz_id FROM quizScores GROUP BY quiz_id DESC limit 5;";
		return getList(st);
	}
	
	public ArrayList<QuizScoreInfo> getRecentlyTakenQuizzes() {
		String st = "SELECT quiz_id FROM quizScores ORDER BY start_time DESC limit 5;";
		return getList(st);
	}
	
	public ArrayList<QuizScoreInfo> getUserScoresInQuiz(int user_id, int quiz_id) {
		String st = "SELECT * FROM quizScores WHERE quiz_id = " + quiz_id + " and user_id = " + user_id + " ORDER BY score DESC limit 1;";
		return getList(st);
	}
	
	public ArrayList<QuizScoreInfo> getUserAttempts(int user_id, int quiz_id) {
		String st = "SELECT * FROM quizScores WHERE quiz_id = " + quiz_id + " and user_id = " + user_id + " ORDER BY start_time DESC;";
		return getList(st);
	}
	
	
	public ArrayList<QuizScoreInfo> getMaxScoreInQuiz(int quiz_id) {
		String st = "SELECT * FROM quizScores WHERE quiz_id = " + quiz_id + " ORDER BY score DESC, duration DESC limit 5;";
		return getList(st);
	}
	
	public ArrayList<QuizScoreInfo> getTodaysMaxScoreInQuiz(int quiz_id) {
		String st = "SELECT * FROM quizScores WHERE (quiz_id = " + quiz_id + " AND start_time >= curdate() - INTERVAL 1 DAY) ORDER BY score DESC limit 5;";
		return getList(st);
	}
	
	public ArrayList<QuizScoreInfo> getLastSubmissions(int quiz_id) {
		String st = "SELECT * FROM quizScores WHERE quiz_id = " + quiz_id + " ORDER BY start_time DESC limit 5;";
		return getList(st);
	} 
	 
	public ArrayList<QuizScoreInfo> getFriendsSubmission(int user_id, int quiz_id) {
		findRequestInfo req = new findRequestInfo();
		ArrayList<requestInfo> arr = req.getUserFriends(user_id);
		if(arr.size() == 0) {
			ArrayList<QuizScoreInfo> q = new ArrayList<QuizScoreInfo>();
			return q;
		} 
		String ids = "";
		for(int i = 0; i < arr.size(); i++) {
			requestInfo cur = arr.get(i);
			if(cur.getSenderID() == user_id) ids += cur.getReceiverID();
			else ids += cur.getSenderID();
			if(i != arr.size() - 1) ids += ", ";
		}
		
		String st = "SELECT * FROM quizScores WHERE quiz_id = " + quiz_id + " AND user_id in (" + ids + ") ORDER BY score, duration DESC DESC limit 10;";
		return getList(st);
	}
	
	
	public ArrayList<String> getCorrectAnswers(ArrayList<QuestionInfo> arr) {
		ArrayList<String> corr = new ArrayList<String>();
		for(int i = 0; i < arr.size(); i++) {
			int quest_id = arr.get(i).getQuestionId();
			findAnswerInfo findAns = new findAnswerInfo();
			String ans = findAns.getCorrectAnswer(quest_id);
			corr.add(ans);
		}		
		return corr;
	}

}
