package WebPackage.challenge;


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
import WebPackage.requests.acceptRequestServlet;

public class challangeServletTests {
	@Test
	void test1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);	
	    
	    when(request.getParameter("quiz_id")).thenReturn("50");
	    
	   
	    StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        challengeServlet cr = new challengeServlet();
        
        when(request.getRequestDispatcher("ChooseReceivers.jsp")).thenReturn(dispatcher);
	    
	    cr.doGet(request, response);
		verify(dispatcher).forward(request,response); 
		
	}
	
	@Test
	void test2() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);	
	    
	    when(request.getParameter("quiz_id")).thenReturn("0");
	    
	   
	    StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        challengeServlet cr = new challengeServlet();
        
        when(request.getRequestDispatcher("ChooseReceivers.jsp")).thenReturn(dispatcher);
	    
	    cr.doGet(request, response);
		verify(dispatcher).forward(request,response); 
		
	}
}
