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

import WebPackage.admin.adminInfo;
import WebPackage.database.DBInfo;

/**
 * Servlet implementation class newPassServlet
 */
@WebServlet("/newPassServlet")
public class newPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newPassServlet() {
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
		doGet(request, response);
		
		checkPassword checker = new checkPassword();
		String oldPass = request.getParameter("opassword");
		String newPass = request.getParameter("npassword");
		LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
		String username = log.getUserName();
		int id = log.getId();
		
		if(checker.isCorrect(username, oldPass)) {
			Connection con;
			Statement stmt;
			String account = DBInfo.MYSQL_USERNAME;
			String password = DBInfo.MYSQL_PASSWORD;
			String server = DBInfo.MYSQL_DATABASE_SERVER;
			String database = DBInfo.MYSQL_DATABASE_NAME;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection
						( "jdbc:mysql://" + server, account ,password);
				stmt = con.createStatement();
				stmt.executeQuery("USE " + database);

				hashPass hash = new hashPass(newPass);
				String hashed = hash.getHash();
				stmt.executeUpdate("update passwords set pass = '" + hashed + "' where user_id='" + id + "';");
			} catch (SQLException e) {
					e.printStackTrace();
			}catch (ClassNotFoundException e) {
					e.printStackTrace();
			}
		
			adminInfo adInfo= new adminInfo();
			if(adInfo.isAdmin(username)) {
				request.getRequestDispatcher("adminPage.jsp").forward(request,response);
			}else {
	            request.getRequestDispatcher("userPage.jsp").forward(request,response);

			}
		}else
            request.getRequestDispatcher("incorrectOldPass.jsp").forward(request,response);
	}

}
