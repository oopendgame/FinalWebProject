package WebPackage.quiz;

import java.sql.Connection;

import WebPackage.database.DBConnection;

public class findQuestionInfo {
private Connection con;
	
	public findQuestionInfo(){
		DBConnection dbc = new DBConnection();
		con = dbc.getConnection();
	}
	
	public void addQuestion() {
		
	}
}
