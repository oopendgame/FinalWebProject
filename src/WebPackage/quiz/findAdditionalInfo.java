package WebPackage.quiz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import WebPackage.database.DBConnection;
import WebPackage.database.DBInfo;

public class findAdditionalInfo {
	
	private Connection con;
	
	public findAdditionalInfo() {
		DBConnection dbc = new DBConnection();
		con = dbc.getConnection();
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
	
	
	private ArrayList<QuizInfo> getList(String st) {
		ResultSet rs;
		ArrayList<QuizInfo> arr = new ArrayList<QuizInfo>();
		findQuizInfo q = new findQuizInfo();
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(st);
			while (rs.next()) {
				int quiz_id = rs.getInt("quiz_id");
				QuizInfo quiz = q.getQuiz(quiz_id);
				arr.add(quiz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	
	public ArrayList<QuizInfo> getUserWrittenQuizzes(int id) {
		String st = "SELECT quiz_id FROM quizScores where user_id = " + id;
		return getList(st);
	}
	
	
	public ArrayList<QuizInfo> getUserCreatedQuizzes(int id) {
		String st = "SELECT quiz_id FROM quizzes WHERE author_id = " + id;
		return getList(st);
	}
	
	
	public ArrayList<QuizInfo> getPopularQuizzes() {
		String st = "SELECT quiz_id FROM quizScores GROUP BY quiz_id DESC limit 5";
		return getList(st);
	}
	
	public ArrayList<QuizInfo> getRecentlyTakenQuizzes() {
		String st = "SELECT quiz_id FROM quizScores ORDER BY start_time DESC limit 5";
		return getList(st);
	}
	
	public ArrayList<QuizInfo> getRecentlyCreatedQuizzes() {
		String st = "SELECT quiz_id FROM quizzes ORDER BY creation_date DESC limit 5";
		return getList(st);
	}

}
