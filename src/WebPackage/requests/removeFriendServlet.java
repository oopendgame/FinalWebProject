package WebPackage.requests;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebPackage.database.DBInfo;
import WebPackage.login.LogInInfo;

/**
 * Servlet implementation class removeFriendServlet
 */
@WebServlet("/removeFriendServlet")
public class removeFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeFriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
		int user1 = log.getId();
		int user2 = log.getSearchId();
		
		findRequestInfo findReq = new findRequestInfo();
		findReq.removeFriend(user1, user2);
		RequestDispatcher rd = request.getRequestDispatcher("friendRemoved.jsp"); //need to change
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
