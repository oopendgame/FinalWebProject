package WebPackage.chat;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebPackage.database.DBInfo;
import WebPackage.login.LogInInfo;
import WebPackage.user.findUserInfo;
import WebPackage.user.userInfo;

/**
 * Servlet implementation class sendMessageServlet
 */
@WebServlet("/sendMessageServlet")
public class sendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		findMessageInfo info = new findMessageInfo();
		int userId = Integer.parseInt(request.getParameter("user"));
		int recieverId = Integer.parseInt(request.getParameter("receiver"));
		String sms = request.getParameter("sms");
		info.putSms(userId, recieverId, sms);
		RequestDispatcher rd = request.getRequestDispatcher("messageSent.jsp");
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
