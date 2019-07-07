package WebPackage.challenge;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import WebPackage.database.DBInfo;

public class findChallenges {
	private Connection con;
	private Statement stmt;
	
	static String account = DBInfo.MYSQL_USERNAME; 
	static String password = DBInfo.MYSQL_PASSWORD;
	static String server = DBInfo.MYSQL_DATABASE_SERVER;
	static String database = DBInfo.MYSQL_DATABASE_NAME ; 
	
	public findChallenges(){
		
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
	
	public ArrayList<challengeInfo> getChallenges(String userName) {
		ArrayList<challengeInfo> ls = new ArrayList<challengeInfo>();
		ResultSet res = null;
		int userId = -1;
		try {
			res = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + userName + "\";");
			if(res.next()) {
				userId = res.getInt("user_id");
			}
			res = stmt.executeQuery("SELECT * from challenges where user2_id = \"" + userId + "\";");
			while(res.next()) {
				 
				int id = res.getInt("challenge_id");
				int user1 = res.getInt("user1_Id");
				int user2 = res.getInt("user2_Id");
				String link = res.getString("link");
				challengeInfo currInfo = new challengeInfo(id, user1 , user2 , link);
				ls.add(currInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}
}
