package WebPackage.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import WebPackage.database.DBConnection;

public class findQuestionInfo {
	private Connection con;
	
	public findQuestionInfo(){
		DBConnection dbc = new DBConnection();
		con = dbc.getConnection();
	}
	
	
	private void addAnswers(QuestionInfo question, int c) {
		findAnswerInfo ans = new findAnswerInfo();
		ArrayList<AnswerInfo> arr = question.getAnswers();
		for (int i = 0; i < arr.size(); i++) {
			ans.addAnswer(c, arr.get(i));
		}
	}
	
	public void addQuestion(int quiz_id, QuestionInfo question) {
		String st = "INSERT INTO questions "
										+ "(quiz_id, "
										+ "question_type, "
										+ "question)"
										+ " VALUES(?, ?, ?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(st);
			preparedStatement.setInt(1, quiz_id);
			preparedStatement.setString(2, question.getType());
			preparedStatement.setString(3, question.getQuestion());
			preparedStatement.executeUpdate();			
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM questions ORDER BY quiz_id DESC LIMIT 1;");     
	        addAnswers(question, (int)rs.getLong(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
