package WebPackage.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import WebPackage.database.DBConnection;

public class checkPassword {
	private Connection con;
	private Statement stmt;
	
	public checkPassword(){
		DBConnection dbc = new DBConnection();
		con = dbc.getConnection();
		
	}

	public boolean isCorrect(String username, String password) {
		ResultSet user = null;
		String passw = null;
		try {
			user = stmt.executeQuery("SELECT * from users where user_name = \"" + username + "\";");
			
			if(user.next()) {
				int id = user.getInt("user_id");
				ResultSet pass = stmt.executeQuery("SELECT pass from passwords where userid = \"" + id + "\";");
				passw = pass.getString("pass");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(passw.equals(password)) {
			return true;
		}
		return false;
	}
}
