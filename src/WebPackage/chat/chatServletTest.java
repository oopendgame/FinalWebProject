package WebPackage.chat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;

import WebPackage.admin.makeAnnouncementServlet;
import WebPackage.database.DBInfo;
import WebPackage.login.LogInInfo;
import WebPackage.user.findUserInfo;
import WebPackage.user.userInfo;

class chatServletTest {

	@Test
	void test1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("pusername")).thenReturn("randName");
	    LogInInfo log = new LogInInfo();
	    log.setUserName("nchan17");
	    
	    when(request.getParameter("messageID")).thenReturn("1");
	    when(request.getParameter("userId")).thenReturn("3");
	    when(request.getParameter("user")).thenReturn("achkh17");
	    when(request.getParameter("sms")).thenReturn("randMessage");
	    
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher("individualMessage.jsp")).thenReturn(dispatcher);
	    
        final ServletContext sContext = mock(ServletContext.class);
	    when(request.getServletContext()).thenReturn(sContext);	
	    chatServlet chat = new chatServlet(){
            public ServletContext getServletContext() {
                return sContext;
            }
        };
        when(sContext.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getRequestDispatcher("QuizDone.jsp")).thenReturn(dispatcher);
	    chat.doGet(request, response);
		verify(dispatcher).forward(request,response);

	}

	
	@Test
	void test2() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("pusername")).thenReturn("otherName");
	    LogInInfo log = new LogInInfo();
	    log.setUserName("nchan17");
	    
	    when(request.getParameter("messageID")).thenReturn("2");
	    when(request.getParameter("userId")).thenReturn("1");
	    when(request.getParameter("user")).thenReturn("nchan17");
	    when(request.getParameter("sms")).thenReturn("hi!");
	    
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher("individualMessage.jsp")).thenReturn(dispatcher);
	    
        final ServletContext sContext = mock(ServletContext.class);
	    when(request.getServletContext()).thenReturn(sContext);	
	    chatServlet chat = new chatServlet(){
            public ServletContext getServletContext() {
                return sContext;
            }
        };
        when(sContext.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getRequestDispatcher("QuizDone.jsp")).thenReturn(dispatcher);
	    chat.doGet(request, response);
		verify(dispatcher).forward(request,response);

	}
	
	@Test
	void test3() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("pusername")).thenReturn("otherName");
	    LogInInfo log = new LogInInfo();
	    log.setUserName("achkh17");
	    
	    when(request.getParameter("messageID")).thenReturn("1");
	    when(request.getParameter("userId")).thenReturn("1");
	    when(request.getParameter("user")).thenReturn("achkh17");
	    when(request.getParameter("sms")).thenReturn("it's me");
	    
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher("individualMessage.jsp")).thenReturn(dispatcher);
	    
        final ServletContext sContext = mock(ServletContext.class);
	    when(request.getServletContext()).thenReturn(sContext);	
	    chatServlet chat = new chatServlet(){
            public ServletContext getServletContext() {
                return sContext;
            }
        };
        when(sContext.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getRequestDispatcher("QuizDone.jsp")).thenReturn(dispatcher);
	    chat.doGet(request, response);
		verify(dispatcher).forward(request,response);

	}

}
