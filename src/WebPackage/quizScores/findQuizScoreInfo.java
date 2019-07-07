package WebPackage.quizScores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import WebPackage.database.DBConnection;
import WebPackage.database.DBInfo;
import WebPackage.quiz.QuizInfo;
import WebPackage.quiz.findQuizInfo;

public class findQuizScoreInfo {	
	private Connection con;
	
	public findQuizScoreInfo() {
		con = DBConnection.getConnection();
	}
	
	
	public void addUserWrittenQuiz(int quiz_id, int user_id, int score, Date start_time, int duration) {
		String st = "INSERT INTO quizScores (quiz_id, user_id, score, start_time, duration) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(st);
			preparedStatement.setInt(1, quiz_id);
			preparedStatement.setInt(2, user_id);
			preparedStatement.setInt(2, score);
			preparedStatement.setDate(3, start_time);
			preparedStatement.setInt(5, duration);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private ArrayList<QuizScoreInfo> getList(String st) {
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
	
	public ArrayList<QuizScoreInfo> getUserMaxScoreInQuiz(int user_id, int quiz_id) {
		String st = "SELECT * FROM quizScores WHERE quiz_id = " + quiz_id + " and user_id = " + user_id + " ORDER BY score DESC limit 1;";
		return getList(st);
	}
	
	public ArrayList<QuizScoreInfo> getUserAttempts(int user_id, int quiz_id) {
		String st = "SELECT * FROM quizScores WHERE quiz_id = " + quiz_id + " and user_id = " + user_id + ";";
		return getList(st);
	}
	
	
	public ArrayList<QuizScoreInfo> getMaxScoreInQuiz(int quiz_id) {
		String st = "SELECT * FROM quizScores WHERE quiz_id = " + quiz_id + " ORDER BY score DESC limit 5;";
		return getList(st);
	}

}
