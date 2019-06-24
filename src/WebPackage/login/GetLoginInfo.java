package WebPackage.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import WebPackage.database.DBConnection;
import WebPackage.user.userInfo;

public class GetLoginInfo {
	private Connection con;
	private Statement stmt;
	
	public GetLoginInfo(){
		DBConnection dbc = new DBConnection();
		con = dbc.getConnection();
		
	}
	public ResultSet UsersList() {
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT * from users");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public LogInInfo getMyUser(String username) {
		ResultSet res = null;
		LogInInfo myUser  = null;
		try {
			res = stmt.executeQuery("SELECT * from users where user_name = \"" + username + "\";");
			if(res.next()) {
				int myId = res.getInt("user_id");
				String userName = res.getString("user_name");
				String name = res.getString("first_name");
				myUser = new LogInInfo(myId, userName, name);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myUser;
		
	}
	
}
