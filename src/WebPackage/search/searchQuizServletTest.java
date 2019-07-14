package WebPackage.search;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;

import WebPackage.database.DBInfo;
import WebPackage.login.LogInInfo;
import WebPackage.quiz.CreateQuizServlet;

public class searchQuizServletTest {
	
	@Test
	void test1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);	
	    
	    when(request.getParameter("quiz_name")).thenReturn("newQuiz");
	    when(request.getParameter("category")).thenReturn("Math");
	    
	    final ServletContext context = mock(ServletContext .class);
	    when(request.getServletContext()).thenReturn(context);	

	    
	    LogInInfo log = new LogInInfo();
	    log.setId(2);
	    
	    StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
	    
	    when(context.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getRequestDispatcher("QuizzesFound.jsp")).thenReturn(dispatcher);

	    searchQuizServlet cr = new searchQuizServlet() {
	    	public ServletContext getServletContext() {
                return context;
            }
        };
	    
	    cr.doPost(request, response);
		verify(dispatcher).forward(request,response); 
	}
	
	
	@Test
	void test2() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);	
	    
	    when(request.getParameter("quiz_name")).thenReturn("newQuiz");
	    when(request.getParameter("category")).thenReturn("kjnkjbnktgnktjn");
	    
	    final ServletContext context = mock(ServletContext .class);
	    when(request.getServletContext()).thenReturn(context);	

	    
	    LogInInfo log = new LogInInfo();
	    log.setId(2);
	    
	    StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
	    
	    when(context.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getRequestDispatcher("QuizNotFound.jsp")).thenReturn(dispatcher);

	    searchQuizServlet cr = new searchQuizServlet() {
	    	public ServletContext getServletContext() {
                return context;
            }
        };
	    
	    cr.doPost(request, response);
		verify(dispatcher).forward(request,response); 
	}
	
	
	@Test
	void test3() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);	
	    
	    when(request.getParameter("quiz_name")).thenReturn("newQuiz");
	    when(request.getParameter("category")).thenReturn("choose category");
	    
	    final ServletContext context = mock(ServletContext .class);
	    when(request.getServletContext()).thenReturn(context);	

	    
	    LogInInfo log = new LogInInfo();
	    log.setId(2);
	    
	    StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
	    
	    when(context.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getRequestDispatcher("QuizzesFound.jsp")).thenReturn(dispatcher);

	    searchQuizServlet cr = new searchQuizServlet() {
	    	public ServletContext getServletContext() {
                return context;
            }
        };
	    
	    cr.doPost(request, response);
		verify(dispatcher).forward(request,response); 
	}
	
	
	@Test
	void test4() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);	
	    
	    when(request.getParameter("quiz_name")).thenReturn("");
	    when(request.getParameter("category")).thenReturn("choose category");
	    
	    final ServletContext context = mock(ServletContext .class);
	    when(request.getServletContext()).thenReturn(context);	

	    
	    LogInInfo log = new LogInInfo();
	    log.setId(2);
	    
	    StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
	    
	    when(context.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getRequestDispatcher("QuizNotFound.jsp")).thenReturn(dispatcher);

	    searchQuizServlet cr = new searchQuizServlet() {
	    	public ServletContext getServletContext() {
                return context;
            }
        };
	    
	    cr.doPost(request, response);
		verify(dispatcher).forward(request,response); 
	}
	
	
	@Test
	void test5() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);	
	    
	    when(request.getParameter("quiz_name")).thenReturn("");
	    when(request.getParameter("category")).thenReturn("Math");
	    
	    final ServletContext context = mock(ServletContext .class);
	    when(request.getServletContext()).thenReturn(context);	

	    
	    LogInInfo log = new LogInInfo();
	    log.setId(2);
	    
	    StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
	    
	    when(context.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getRequestDispatcher("QuizzesFound.jsp")).thenReturn(dispatcher);

	    searchQuizServlet cr = new searchQuizServlet() {
	    	public ServletContext getServletContext() {
                return context;
            }
        };
	    
	    cr.doPost(request, response);
		verify(dispatcher).forward(request,response); 
	}

}
