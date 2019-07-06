package WebPackage.search;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebPackage.database.DBConnection;
import WebPackage.user.findUserInfo;
import WebPackage.user.userInfo;

/**
 * Servlet implementation class searchUserServlet
 */ 
@WebServlet("/searchUserServlet")
public class searchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchUserServlet() {
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
		//doGet(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int id = 0;
		String name = request.getParameter("user_name");
		findUserInfo cur = new findUserInfo();
		userInfo user = cur.getMyUser(name);
		if(user != null) id = user.getId();
		
		String st = "UserNotFound.jsp";
		if(id != 0) st = "othersPage.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(st); 
		rd.forward(request, response); 
	}

}
