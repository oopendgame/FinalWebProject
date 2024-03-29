package WebPackage.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import WebPackage.database.DBInfo;
public class checkPassword {
	
	private Connection con;
	private Statement stmt;
	private String account = DBInfo.MYSQL_USERNAME;
	private String password = DBInfo.MYSQL_PASSWORD;
	private String server = DBInfo.MYSQL_DATABASE_SERVER;
	private String database = DBInfo.MYSQL_DATABASE_NAME;
	
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

	public boolean isCorrect(String input, String password) {
		ResultSet usern = null;
		String passw = null;
		try {
			usern = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + input + "\" || email = \"" + input + "\";");
			if(usern.next()) {
				int id = usern.getInt("user_id");
				ResultSet pass = stmt.executeQuery("SELECT * from passwords where user_id = \"" + id + "\";");
				if(pass.next()) {
					passw = pass.getString("pass");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hashPass hash = new hashPass(password);
		String hashed = hash.getHash();
		if(passw != null && passw.equals(hashed)) {
			return true;
		}
		return false;
	}
}
