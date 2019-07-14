package WebPackage.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import WebPackage.database.DBConnection;
import WebPackage.database.DBInfo;

public class findAnswerInfo implements AnsInfo {	
	private Connection con;
	
	public findAnswerInfo(){
		con = DBConnection.getConnection();
	}
	
	
	public void addAnswer(int id, AnswerInfo ans) {
		String st = "INSERT INTO answers (question_id, answer, correct_ans) VALUES(?, ?, ?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(st);
			preparedStatement.setInt(1, id);
			System.out.println(1 + ans.getAnswer() + "\n");
			preparedStatement.setString(2, ans.getAnswer());
			preparedStatement.setBoolean(3, ans.getCorrectAns());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getMultiAnswer(int id) {
		String st = "SELECT answer FROM answers where answer_id = " + id;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(st);
			if(rs.next()) return rs.getString("answer");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	public boolean isAnswerCorrect(int id) {
		String st = "SELECT correct_ans FROM answers where answer_id = " + id;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(st);
			if(rs.next()) return rs.getBoolean("correct_ans");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} 
	
	public ArrayList<AnswerInfo> getAnswers(int id) {
		ArrayList<AnswerInfo> arr = new ArrayList<AnswerInfo>();
		String st = "SELECT * FROM answers WHERE question_id = " + id;
		ResultSet rs;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(st);
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
	
	public String getCorrectAnswer(int id) {
		String st = "SELECT answer FROM answers WHERE question_id = " + id + " AND correct_ans = true";
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(st);
			if(rs.next()) return rs.getString("answer");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
