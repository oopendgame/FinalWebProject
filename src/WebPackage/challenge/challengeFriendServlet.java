package WebPackage.challenge;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import WebPackage.database.DBInfo;
import WebPackage.login.LogInInfo;

/**
 * Servlet implementation class challengeFriendServlet
 */
@WebServlet("/challengeFriendServlet")
public class challengeFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public challengeFriendServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		String username = request.getParameter("friend");
		int receiverid = 0;
		LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
		int curr = log.getId();
		Connection con;
		Statement stmt;
		String account = DBInfo.MYSQL_USERNAME;
		String password = DBInfo.MYSQL_PASSWORD;
		String server = DBInfo.MYSQL_DATABASE_SERVER;
		String database = DBInfo.MYSQL_DATABASE_NAME;
		String quizid = request.getParameter("quiz_id");
		currQuizInfo currq = new currQuizInfo();
		currq.setId(quizid);
		request.setAttribute("currquiz", currq);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection
					( "jdbc:mysql://" + server, account ,password);
			stmt = con.createStatement();
			stmt.executeQuery("USE " + database);
			ResultSet user = null;
			user = stmt.executeQuery("SELECT * from userInfo where user_name = \"" + username + "\";");
			if(user.next()) {
				receiverid = user.getInt("user_id");
			}
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			stmt.executeUpdate("insert into challenges (user1_id, user2_id, link, sending_time) "
					+ "values ('"+curr+"', '"+receiverid+"', '"+quizid+"', '"+(dateFormat.format(date))+"')");
		} catch (SQLException e) {
				e.printStackTrace();
		}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		
		request.getRequestDispatcher("ChooseReceivers.jsp").forward(request,response);
	}

}
