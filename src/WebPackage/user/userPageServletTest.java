package WebPackage.user;

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

import WebPackage.admin.adminInfo;
import WebPackage.chat.chatServlet;
import WebPackage.database.DBInfo;
import WebPackage.login.LogInInfo;

class userPageServletTest {

	@Test
	void testPost1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("pusername")).thenReturn("otherName");
	    LogInInfo log = new LogInInfo();
	    log.setUserName("nchan17");
	    
	    when(request.getParameter("photoUrl")).thenReturn("someUrl.com");
	    
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    
        final ServletContext sContext = mock(ServletContext.class);
	    when(request.getServletContext()).thenReturn(sContext);	
	    userPageServlet chat = new userPageServlet(){
            public ServletContext getServletContext() {
                return sContext;
            }
        };
        when(sContext.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
		adminInfo adInfo= new adminInfo();
		if(adInfo.isAdmin("nchan17")) {
			when(request.getRequestDispatcher("adminPage.jsp")).thenReturn(dispatcher);
		}else {
			when(request.getRequestDispatcher("userPage.jsp")).thenReturn(dispatcher);
		}
	    chat.doPost(request, response);
		verify(dispatcher).forward(request,response);
	}
	
	@Test
	void testPost2() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("pusername")).thenReturn("otherName");
	    LogInInfo log = new LogInInfo();
	    log.setUserName("machkh17");
	    
	    when(request.getParameter("photoUrl")).thenReturn("otherUrl.com");
	    
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    
        final ServletContext sContext = mock(ServletContext.class);
	    when(request.getServletContext()).thenReturn(sContext);	
	    userPageServlet chat = new userPageServlet(){
            public ServletContext getServletContext() {
                return sContext;
            }
        };
        when(sContext.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
		adminInfo adInfo= new adminInfo();
		if(adInfo.isAdmin("machkh17")) {
			when(request.getRequestDispatcher("adminPage.jsp")).thenReturn(dispatcher);
		}else {
			when(request.getRequestDispatcher("userPage.jsp")).thenReturn(dispatcher);
		}
	    chat.doPost(request, response);
		verify(dispatcher).forward(request,response);
	}

	@Test
	void testGet1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("pusername")).thenReturn("otherName");
	    LogInInfo log = new LogInInfo();
	    log.setUserName("nchan17");
	    
	    when(request.getParameter("photoUrl")).thenReturn("someUrl.com");
	    
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    
        final ServletContext sContext = mock(ServletContext.class);
	    when(request.getServletContext()).thenReturn(sContext);	
	    userPageServlet chat = new userPageServlet(){
            public ServletContext getServletContext() {
                return sContext;
            }
        };
        when(sContext.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
		adminInfo adInfo= new adminInfo();
		if(adInfo.isAdmin("nchan17")) {
			when(request.getRequestDispatcher("adminPage.jsp")).thenReturn(dispatcher);
		}else {
			when(request.getRequestDispatcher("userPage.jsp")).thenReturn(dispatcher);
		}
	    chat.doGet(request, response);
		verify(dispatcher).forward(request,response);
	}
	
	@Test
	void testGet2() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("pusername")).thenReturn("otherName");
	    LogInInfo log = new LogInInfo();
	    log.setUserName("machkh17");
	    
	    when(request.getParameter("photoUrl")).thenReturn("otherUrl.com");
	    
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    
        final ServletContext sContext = mock(ServletContext.class);
	    when(request.getServletContext()).thenReturn(sContext);	
	    userPageServlet chat = new userPageServlet(){
            public ServletContext getServletContext() {
                return sContext;
            }
        };
        when(sContext.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
		adminInfo adInfo= new adminInfo();
		if(adInfo.isAdmin("machkh17")) {
			when(request.getRequestDispatcher("adminPage.jsp")).thenReturn(dispatcher);
		}else {
			when(request.getRequestDispatcher("userPage.jsp")).thenReturn(dispatcher);
		}
	    chat.doGet(request, response);
		verify(dispatcher).forward(request,response);
	}

}
