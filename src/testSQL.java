import java.sql.*; 
 
public class testSQL {  
 
static String account = "root"; // replace with your account
static String  password = "sudopllp"; // replace with your password
static String  server = "localhost";
static String database = "finalProject"; // replace with your db

int main() {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection
					( "jdbc:mysql://" + server, account ,password);
		Statement stmt = con.createStatement();
		stmt.executeQuery("USE " + database);
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM userInfo");    
		while(rs.next()) {  
			String name = rs.getString("first_name");   
			String pop = rs.getString("last_name");   
			System.out.println(name + "\t" + pop);    }   
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return 0;	
}
}