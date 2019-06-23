package WebPackage.quiz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import WebPackage.database.DBConnection;

public class findAdditionalInfo {
	
	private Connection con;
	
	public findAdditionalInfo() {
		DBConnection dbc = new DBConnection();
		con = dbc.getConnection();
	}
	
	public ArrayList<QuizInfo> userCreatedQuizes(int id) {
		String st = "SELECT quiz_id FROM quizzes WHERE author_id = " + id;
		ResultSet rs;
		ArrayList<QuizInfo> arr = new ArrayList<QuizInfo>();
		findQuizInfo q = new findQuizInfo();
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(st);
			while (rs.next()) {
				int quiz_id = rs.getInt("quiz_id");
				QuizInfo qz = q.getQuiz(quiz_id);
				arr.add(qz);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return arr;
	}

}
