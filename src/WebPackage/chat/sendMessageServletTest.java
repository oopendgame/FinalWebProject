package WebPackage.chat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;

import WebPackage.database.DBInfo;
import WebPackage.login.LogInInfo;

class sendMessageServletTest {

	@Test
	void testGet1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("pusername")).thenReturn("randName");
	    LogInInfo log = new LogInInfo();
	    log.setUserName("nchan17");
	    
	    when(request.getParameter("receiver")).thenReturn("3");
	    when(request.getParameter("user")).thenReturn("1");
	    when(request.getParameter("sms")).thenReturn("randMessage");
	    
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher("messageSent.jsp")).thenReturn(dispatcher);
	    
        final ServletContext sContext = mock(ServletContext.class);
        when(sContext.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getServletContext()).thenReturn(sContext);	
	    sendMessageServlet chat = new sendMessageServlet(){
            public ServletContext getServletContext() {
                return sContext;
            }
        };
	    chat.doGet(request, response);
		verify(dispatcher).forward(request,response);
	}
	
	@Test
	void testGet2() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("pusername")).thenReturn("randName");
	    LogInInfo log = new LogInInfo();
	    log.setUserName("nchan17");
	    
	    when(request.getParameter("receiver")).thenReturn("2");
	    when(request.getParameter("user")).thenReturn("3");
	    when(request.getParameter("sms")).thenReturn("hi!");
	    
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher("messageSent.jsp")).thenReturn(dispatcher);
	    
        final ServletContext sContext = mock(ServletContext.class);
        when(sContext.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getServletContext()).thenReturn(sContext);	
	    sendMessageServlet chat = new sendMessageServlet(){
            public ServletContext getServletContext() {
                return sContext;
            }
        };
	    chat.doGet(request, response);
		verify(dispatcher).forward(request,response);
	}
	
	@Test
	void testPost1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("pusername")).thenReturn("randName");
	    LogInInfo log = new LogInInfo();
	    log.setUserName("nchan17");
	    
	    when(request.getParameter("receiver")).thenReturn("1");
	    when(request.getParameter("user")).thenReturn("1");
	    when(request.getParameter("sms")).thenReturn("hi me!");
	    
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher("messageSent.jsp")).thenReturn(dispatcher);
	    
        final ServletContext sContext = mock(ServletContext.class);
        when(sContext.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getServletContext()).thenReturn(sContext);	
	    sendMessageServlet chat = new sendMessageServlet(){
            public ServletContext getServletContext() {
                return sContext;
            }
        };
	    chat.doGet(request, response);
		verify(dispatcher).forward(request,response);
	}

}
