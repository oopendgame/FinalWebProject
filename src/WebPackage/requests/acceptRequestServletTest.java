package WebPackage.requests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;

import WebPackage.database.DBConnection;
import WebPackage.database.DBInfo;
import WebPackage.login.LogInInfo;

public class acceptRequestServletTest {
	
	@Test
	void test1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);	
	    
	    when(request.getParameter("user1_id")).thenReturn("1");
	    when(request.getParameter("user2_id")).thenReturn("2");
	    
	    Connection con = DBConnection.getConnection();
	    Statement nameStm;
		try {
			nameStm = con.createStatement();
			nameStm.execute("TRUNCATE friends;");
			nameStm.execute("INSERT INTO friends(user1_id, user2_id, friends_status, sending_date) VALUES (1, 2, 0, sysdate()), (1, 3, 0, sysdate());");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   /* findRequestInfo findReq = new findRequestInfo();
		findReq.addFriend(1, 2); */
	    
	    StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        acceptRequestServlet cr = new acceptRequestServlet();
        
        when(request.getRequestDispatcher("friendAdded.jsp")).thenReturn(dispatcher);
	    
	    cr.doGet(request, response);
		verify(dispatcher).forward(request,response); 
		
		try {
			nameStm = con.createStatement();
			nameStm.execute("TRUNCATE friends;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	void test2() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);	
	    
	    when(request.getParameter("user1_id")).thenReturn("1");
	    when(request.getParameter("user2_id")).thenReturn("3");
	    
	    Connection con = DBConnection.getConnection();
		try {
			Statement nameStm = con.createStatement();
			nameStm.execute("TRUNCATE friends;");
			nameStm.execute("INSERT INTO friends(user1_id, user2_id, friends_status, sending_date) VALUES (1, 2, 0, sysdate()), (1, 3, 0, sysdate());");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   /* findRequestInfo findReq = new findRequestInfo();
		findReq.addFriend(1, 3); */
	    
	    StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        acceptRequestServlet cr = new acceptRequestServlet();
        
        when(request.getRequestDispatcher("friendAdded.jsp")).thenReturn(dispatcher);
	    
	    cr.doGet(request, response);
		verify(dispatcher).forward(request,response); 
		
		try {
			Statement nameStm = con.createStatement();
			nameStm.execute("TRUNCATE friends;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
