package WebPackage.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebPackage.database.DBInfo;

/**
 * Servlet implementation class accountServlet
 */
@WebServlet("/accountServlet")
public class accountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String uname = request.getParameter("username");
		String passw = request.getParameter("password");
		String bday = "1999-01-01";
		String gender = request.getParameter("gender");
		Connection con;
		Statement stmt;
		String account = "root";
		String password = "Archili_archili";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection
					( "jdbc:mysql://localhost:3306/finalProject", account ,password);
			stmt = con.createStatement();
			stmt.executeUpdate("insert into userInfo (user_name, first_name, last_name, email, date_of_birth, gender, img) "
					+ "values ('"+uname+"', '"+fname+"', '"+lname+"',"
					+ " '"+email+"', '"+bday+"', '"+gender+"', null)");
			
			ResultSet user = null;
			String id = "";
			user = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + uname + "\";");
			if(user.next()) {
				id = user.getString("user_id");
			}
			
			stmt.executeUpdate("insert into passwords (user_id, pass) "
					+ "values ('"+id+"', '"+passw+"')");
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		request.getRequestDispatcher("userPage.jsp").forward(request,response);
			
	}
}