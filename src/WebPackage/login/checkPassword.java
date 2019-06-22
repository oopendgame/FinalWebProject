package WebPackage.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class checkPassword {
	
	private Connection con;
	private Statement stmt;
	static String account = "root"; // replace with your account
	static String password = "Archili_archili"; // replace with your password
	static String server = "localhost";
	static String database = "finalProject"; // replace with your db
	
	public checkPassword(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection
						( "jdbc:mysql://" + server, account ,password);
			stmt = con.createStatement();
			stmt.executeQuery("USE " + database);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean isCorrect(String username, String password) {
		ResultSet user = null;
		String passw = null;
		try {
			user = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + username + "\";");
			if(user.next()) {
				int id = user.getInt("user_id");
				ResultSet pass = stmt.executeQuery("SELECT * from passwords where user_id = \"" + id + "\";");
				if(pass.next()) {
					passw = pass.getString("pass");
				}
				
			}else {
				System.out.println("incorrect");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(passw != null && passw.equals(password)) {
			return true;
		}
		return false;
	}
}
