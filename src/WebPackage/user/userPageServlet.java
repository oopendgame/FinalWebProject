package WebPackage.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebPackage.admin.adminInfo;
import WebPackage.database.DBInfo;
import WebPackage.login.LogInInfo;

/**
 * Servlet implementation class userPageServlet
 */
@WebServlet("/userPageServlet")
public class userPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public userPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		findUserInfo us = new findUserInfo();
		String newUrl = request.getParameter("photoUrl");
		LogInInfo currInfo = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
		String name = currInfo.getUserName();
		us.insertUrl(name, newUrl);
		adminInfo adInfo= new adminInfo();
		if(adInfo.isAdmin(name)) {
			request.getRequestDispatcher("adminPage.jsp").forward(request,response);
		}else {
            request.getRequestDispatcher("userPage.jsp").forward(request,response);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		findUserInfo us = new findUserInfo();
		String newUrl = request.getParameter("photoUrl");
		LogInInfo currInfo = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
		String name = currInfo.getUserName();
		us.insertUrl(name, newUrl);
		adminInfo adInfo= new adminInfo();
		if(adInfo.isAdmin(name)) {
			request.getRequestDispatcher("adminPage.jsp").forward(request,response);
		}else {
            request.getRequestDispatcher("userPage.jsp").forward(request,response);
		}
	}

}
