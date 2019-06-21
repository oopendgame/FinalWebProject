package WebPackage.quiz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import WebPackage.database.DBConnection;

public class findQuizInfo {
	
	private Connection con;
	
	public findQuizInfo(){
		DBConnection dbc = new DBConnection();
		con = dbc.getConnection();
	}
	
	public ResultSet QuizList() {
		try {
			PreparedStatement stm = con.prepareStatement("SELECT * from quizzes");
            ResultSet res = stm.executeQuery();
            return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public QuizInfo addNewQuiz(ResultSet res) {
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
				quiz = new QuizInfo(quiz_id, author_id, page_num, rand, name, correction_type, creation_date, subj, description, practice_mode);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quiz;		
	}
	
	
	public QuizInfo addQuiz(QuizInfo quiz) {
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
			PreparedStatement preparedStatement = con.prepareStatement(st);
			preparedStatement.setInt(1, quiz.getAuthorId());
			preparedStatement.setBoolean(2, quiz.getPageNum());
			preparedStatement.setBoolean(3, quiz.getRandom());
			preparedStatement.setString(4, quiz.getQuizName());
			preparedStatement.setBoolean(5, quiz.getCorrectionType());
			preparedStatement.setDate(6, quiz.getCreationDate());
			preparedStatement.setString(7, quiz.getSubject());
			preparedStatement.setString(8, quiz.getDecription());
			preparedStatement.setBoolean(9, quiz.getPractiseMode());
			
			preparedStatement.executeUpdate();
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM quizzes ORDER BY quiz_id DESC LIMIT 1;");
			if(!rs.next()) return null;
			else return addNewQuiz(rs);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
