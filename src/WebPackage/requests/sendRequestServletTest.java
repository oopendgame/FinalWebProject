package WebPackage.requests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
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

public class sendRequestServletTest {
	
	@Test
	void test1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);	

	    final ServletContext context = mock(ServletContext .class);
	    when(request.getServletContext()).thenReturn(context);	
	    
	    LogInInfo log = new LogInInfo();
	    log.setId(2);
	    log.setSearchId(1);
	    
	    Connection con = DBConnection.getConnection();
		try {
			Statement nameStm = con.createStatement();
			nameStm.execute("TRUNCATE friends;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    when(context.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getRequestDispatcher("othersPage.jsp")).thenReturn(dispatcher);
	    
	    StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

	    sendRequestServlet cr = new sendRequestServlet() {
	    	public ServletContext getServletContext() {
                return context;
            }
        };
	    
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
	
	
	@Test
	void test2() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);	

	    final ServletContext context = mock(ServletContext .class);
	    when(request.getServletContext()).thenReturn(context);	
	    
	    LogInInfo log = new LogInInfo();
	    log.setId(1);
	    log.setSearchId(3);
	    
	    Connection con = DBConnection.getConnection();
		try {
			Statement nameStm = con.createStatement();
			nameStm.execute("TRUNCATE friends;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    when(context.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getRequestDispatcher("othersPage.jsp")).thenReturn(dispatcher);
	    
	    StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

	    sendRequestServlet cr = new sendRequestServlet() {
	    	public ServletContext getServletContext() {
                return context;
            }
        };
	    
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
