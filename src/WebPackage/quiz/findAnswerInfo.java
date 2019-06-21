package WebPackage.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import WebPackage.database.DBConnection;

public class findAnswerInfo {	
	private Connection con;
	
	public findAnswerInfo(){
		DBConnection dbc = new DBConnection();
		con = dbc.getConnection();
	}
	
	
	public void addAnswer(int id, AnswerInfo ans) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO answers (question_id, answer, correct_ans) VALUES(?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, ans.getAnswer());
			preparedStatement.setBoolean(3, ans.getCorrectAns());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean isAnswerCorrect(int id) {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select correct_ans FROM answers where answer_id = " + id);
			if(rs.next()) return rs.getBoolean("correct_ans");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<AnswerInfo> getAnswers(int id) {
		ArrayList<AnswerInfo> arr = new ArrayList<AnswerInfo>();
		ResultSet rs;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select * from answers where qestion_id = " + id);
			while(rs.next()) {
				int quiz_id = rs.getInt("answer_id");
				String ans = rs.getString("answer");
				boolean corr = rs.getBoolean("correct_ans") ;
				AnswerInfo cur = new AnswerInfo(quiz_id, ans, corr);
				arr.add(cur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return arr;
	}

}
