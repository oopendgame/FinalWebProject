package WebPackage.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public QuizInfo getMyQuiz(int id) {
		ResultSet res = null;
		QuizInfo myQuiz  = null;
		try {
			PreparedStatement stm = con.prepareStatement("SELECT * from quizzes where quiz_id = \"" + id + "\";");
			res = stm.executeQuery();
			if(res.next()) {
				int quiz_id = res.getInt("quiz_id");
				int author_id = res.getInt("author_id");
				int page_num = res.getInt("page_num");
				String correction_type = res.getString("correction_type");
				String creation_date = res.getString("creation_date");
				String subj = res.getString("subj");
				String description = res.getString("description");
				String practice_mode = res.getString("practice_mode");
				myQuiz = new QuizInfo(quiz_id, author_id, page_num, correction_type, creation_date, subj, description, practice_mode);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myQuiz;		
	}
	
	
	public void addQuiz(Quiz quiz) {
		
	}
}
