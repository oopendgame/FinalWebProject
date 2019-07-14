package WebPackage.requests;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebPackage.database.DBInfo;
import WebPackage.login.LogInInfo;

/**
 * Servlet implementation class sendRequestServlet
 */
@WebServlet("/sendRequestServlet")
public class sendRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendRequestServlet() {
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
		Date date = new Date((new java.util.Date()).getTime());
		requestInfo req = new requestInfo(0, user1, user2, 0, date, "");
		
		findRequestInfo findReq = new findRequestInfo();
		findReq.addRequest(req);
		RequestDispatcher rd = request.getRequestDispatcher("othersPage.jsp"); //need to change
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
