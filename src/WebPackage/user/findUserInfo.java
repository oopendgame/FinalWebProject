package WebPackage.user;
import WebPackage.database.DBInfo;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import WebPackage.database.DBConnection;

public class findUserInfo {	
	private Connection con;
	private Statement stmt;
	//თავიდან დავაქონექთე და მარტო მაშინ ამოიღო ინფორმაცია. შესაცვლელია...
	
	static String account = DBInfo.MYSQL_USERNAME; // replace with your account
	static String  password = DBInfo.MYSQL_PASSWORD; // replace with your password
	static String  server = DBInfo.MYSQL_DATABASE_SERVER;
	static String database = DBInfo.MYSQL_DATABASE_NAME ; // replace with your db
	
	public findUserInfo(){
		
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

	public userInfo getMyUser(String userName) {
		// რადგან login თან არ დამიკავშირებია სატესტოდ nchan17ს გავუტოლე
		// mysqlში რაღაც მონაცემები შევცვალე ცალკე ჩემს ბაზაში
		// ბაზაში რამე დეფოლტ სურათი ჩავამატოთ 
		userName = "nchan17";
		ResultSet res = null;
		userInfo myUser  = null;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName + "\";");
			if(res.next()) {
				int myId = res.getInt("user_id");
				String myUserName = res.getString("user_name");
				String name = res.getString("first_name");
				String lastName = res.getString("last_name");
				String email = res.getString("email");
				String birthday = res.getString("date_of_birth");
				String gender = res.getString("gender");
				String img = res.getString("img");
				String rank = res.getString("rank");
				myUser = new userInfo(myId, myUserName, name, lastName, img, email, birthday, gender, rank);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myUser;
		
	}
	
	
}