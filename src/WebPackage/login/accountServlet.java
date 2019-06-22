package WebPackage.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("00000000000");
//		String fname = request.getParameter("firstname");
//		String lname = request.getParameter("lastname");
//		String email = request.getParameter("email");
//		String uname = request.getParameter("username");
//		String pass = request.getParameter("password");
//		String bday = request.getParameter("bday");
//		String gender = request.getParameter("gender");
		Connection con;
		Statement stmt;
		String account = DBInfo.MYSQL_USERNAME;
		String password = DBInfo.MYSQL_PASSWORD;
		String server = DBInfo.MYSQL_DATABASE_SERVER;
		String database = DBInfo.MYSQL_DATABASE_NAME;
//		System.out.println(fname);
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection
//					( "jdbc:mysql://" + server, account ,password);
//			stmt = con.createStatement();
//			stmt.executeUpdate("insert into userInfo values(uname, fname, lname, email, bday, gender)");
//		} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//		}catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//		}
//			
	}
}