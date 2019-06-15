package WebPackage.user;
<<<<<<< HEAD
=======

>>>>>>> 90ca52cad9616705d752aac805a0aef4574ddcbe

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import WebPackage.database.DBConnection;

public class findUserInfo {	
	static String account = "root"; // replace with your account
	static String  password = "sudopllp"; // replace with your password
	static String  server = "localhost";
	static String database = "mydb"; // replace with your db
	private Connection con;
	private Statement stmt;
	
	public findUserInfo(){
		DBConnection dbc = new DBConnection();
		con = dbc.getConnection();
		
	}
	public ResultSet ProductsList() {
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT * from products");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public userInfo getMyUser(String id) {
		ResultSet res = null;
		userInfo myUser  = null;
		try {
			res = stmt.executeQuery("SELECT * from products where productid = \"" + id + "\";");
			if(res.next()) {
				int myId = res.getInt("user_id");
				String userName = res.getString("user_name");
				String name = res.getString("first_name");
				String lastName = res.getString("last_name");
				String email = res.getString("email");
				String birthday = res.getString("date_of_birth");
				String gender = res.getString("gender");
				String img = res.getString("img");
				String rank = res.getString("rank");
				myUser = new userInfo(myId, userName, name, lastName, img, email, birthday, gender, rank);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myUser;
		
	}
	
	
}
