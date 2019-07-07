package WebPackage.quiz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import WebPackage.database.DBConnection;
import WebPackage.database.DBInfo;

public class findQuizInfo {
	
	private Connection con;
	 
	public findQuizInfo() {
		con = DBConnection.getConnection();
	}
	
	
	public ArrayList<QuizInfo> searchQuiz(String name, String cat) {
		ArrayList<QuizInfo> arr = new ArrayList<QuizInfo>();
	
		String st = "SELECT * FROM quizzes";		
		boolean nameEntered = false;
		if(!name.contentEquals("")) {
			st += " WHERE quiz_name = " + name;
			nameEntered = true;
		}
		if(!cat.contentEquals("choose category")) {
			if(nameEntered) st += " AND subj = " + cat;
			else st += " WHERE subj = " + cat;
		}			
		st += ";";
		
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stm = con.prepareStatement(st);
			ResultSet res = stm.executeQuery();
			while(res.next()) {
				QuizInfo cur = getNewQuiz(res);
				arr.add(cur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arr;
	}
	
	public ArrayList<QuizInfo> getQuizList() {        
		ArrayList<QuizInfo> arr = new ArrayList<QuizInfo>();
		Statement statement;
		try {
			String st = "SELECT * FROM quizzes;";
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(st);
			while(res.next()) {
				QuizInfo cur = getNewQuiz(res);
				arr.add(cur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
	
	public QuizInfo getNewQuiz(ResultSet res) {
		QuizInfo quiz  = null;
		try {
			if(res.next()) {
				int quiz_id = res.getInt("quiz_id");
				int author_id = res.getInt("author_id");
				boolean page_num = res.getBoolean("page_num");
				boolean rand = res.getBoolean("random");
				String name = res.getString("quiz_name");
				boolean correction_type = res.getBoolean("correction_type");
				Date creation_date = res.getDate("creation_date");
				String subj = res.getString("subj");
				String description = res.getString("description");
				boolean practice_mode = res.getBoolean("practice_mode");
				ArrayList<QuestionInfo> arr = new findQuestionInfo().getQuizQuestions(quiz_id);
				quiz = new QuizInfo(quiz_id, author_id, page_num, rand, name, correction_type, creation_date, subj, description, practice_mode, arr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quiz;		
	}
	
	
	public QuizInfo getQuiz(int quizId) {
		PreparedStatement stm;
		try {
			stm = con.prepareStatement("SELECT * FROM quizzes WHERE quiz_id = " + quizId + ";");
	        ResultSet rs = stm.executeQuery();
	        return getNewQuiz(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	private void addQuestions(ResultSet rs, QuizInfo quiz) {
		findQuestionInfo quest = new findQuestionInfo();
		ArrayList<QuestionInfo> arr = quiz.getQuestions();
		for (int i = 0; i < arr.size(); i++) {
			try {
				quest.addQuestion((int)rs.getLong(1), arr.get(i));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void addQuiz(QuizInfo quiz, int author_id) {
		String st = "INSERT INTO quizzes"
										+ "(author_id, "
										+ "page_num, "
										+ "random, "
										+ "quiz_name,"
										+ "correction_type, "
										+ "creation_date, "
										+ "subj, "
										+ "description,"
										+ "practice_mode)"
										+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(st, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, author_id);
			preparedStatement.setBoolean(2, quiz.getPageNum());
			preparedStatement.setBoolean(3, quiz.getRandom());
			preparedStatement.setString(4, quiz.getQuizName());
			preparedStatement.setBoolean(5, quiz.getCorrectionType());
			preparedStatement.setDate(6, quiz.getCreationDate());
			preparedStatement.setString(7, quiz.getSubject());
			preparedStatement.setString(8, quiz.getDecription());
			preparedStatement.setBoolean(9, quiz.getPractiseMode());
			
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if(rs.next()) addQuestions(rs, quiz);		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
