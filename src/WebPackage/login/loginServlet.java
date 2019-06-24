package WebPackage.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebPackage.database.DBInfo;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		checkPassword checker = new checkPassword();
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		
		if(checker.isCorrect(username, pass)) {
			int id = 0;
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
				ResultSet user = null;
				user = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + username + "\";");
				if(user.next()) {
					id = user.getInt("user_id");
				}
			} catch (SQLException e) {
					e.printStackTrace();
			}catch (ClassNotFoundException e) {
					e.printStackTrace();
			}
			
			LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
			log.setUserName(username);
			log.setId(id);
			
            request.getRequestDispatcher("userPage.jsp").forward(request,response);
		}else
            request.getRequestDispatcher("incorrectPass.jsp").forward(request,response);
	}

}