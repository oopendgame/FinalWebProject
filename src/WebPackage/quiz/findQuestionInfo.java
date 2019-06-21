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
	
	
	private void addAnswers(QuestionInfo question, ResultSet rs) {
		findAnswerInfo ans = new findAnswerInfo();
		ArrayList<AnswerInfo> arr = question.getAnswers();
		for (int i = 0; i < arr.size(); i++) {
			try {
				ans.addAnswer((int)rs.getLong(1), arr.get(i));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void addQuestion(int quiz_id, QuestionInfo question) {
		String st = "INSERT INTO questions "
										+ "(quiz_id, "
										+ "question_type, "
										+ "question)"
										+ " VALUES(?, ?, ?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(st, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, quiz_id);
			preparedStatement.setString(2, question.getType());
			preparedStatement.setString(3, question.getQuestion());
			preparedStatement.executeUpdate();			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if(rs.next()) addAnswers(question, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<QuestionInfo> getQuizQuestions(int id) {
		String st = "SELECT * FROM questions where quiz_id = " + id;
		ArrayList<QuestionInfo> questions = new ArrayList<QuestionInfo>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(st);
			while(rs.next()) {
				findAnswerInfo ans = new findAnswerInfo();
				int quest_id = rs.getInt("question_id");
				String type = rs.getString("question_type");
				String question = rs.getString("question");
				ArrayList<AnswerInfo> arr = ans.getAnswers(quest_id);
				QuestionInfo q = new QuestionInfo(quest_id, type, question, arr);
				questions.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questions;
	}
}
