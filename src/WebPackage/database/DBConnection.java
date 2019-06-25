package WebPackage.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	
	private static Connection con;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection( "jdbc:mysql://" + DBInfo.MYSQL_DATABASE_SERVER,
												DBInfo.MYSQL_USERNAME, DBInfo.MYSQL_PASSWORD);
			Statement stmt = con.createStatement();
	        stmt.executeQuery("USE " + DBInfo.MYSQL_DATABASE_NAME);

		} catch(Exception e) {
			System.out.println("can't connect to database");
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
}

