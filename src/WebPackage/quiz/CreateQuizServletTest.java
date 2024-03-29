package WebPackage.quiz;

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

import WebPackage.admin.makeAnnouncementServlet;
import WebPackage.database.DBInfo;
import WebPackage.login.LogInInfo;

public class CreateQuizServletTest {
	
	@Test
	void test1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);	
	    
	    when(request.getParameter("quiz_name")).thenReturn("quizName");
	    when(request.getParameter("description")).thenReturn("desc");
	    when(request.getParameter("subject")).thenReturn("subj");
	    when(request.getParameter("pageNum")).thenReturn("1");
	    when(request.getParameter("rand")).thenReturn("0");
	    when(request.getParameter("corr")).thenReturn("0");
	    
	    final ServletContext context = mock(ServletContext .class);
	    when(request.getServletContext()).thenReturn(context);	

	    
	    LogInInfo log = new LogInInfo();
	    log.setId(2);
	    
	    when(context.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getRequestDispatcher("QuizDone.jsp")).thenReturn(dispatcher);

	    CreateQuizServlet cr = new CreateQuizServlet() {
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
	    when(request.getParameter("description")).thenReturn("skjbdfnbkfjb");
	    when(request.getParameter("subject")).thenReturn("Math");
	    when(request.getParameter("pageNum")).thenReturn("0");
	    when(request.getParameter("rand")).thenReturn("1");
	    when(request.getParameter("corr")).thenReturn("0");
	    
	    final ServletContext context = mock(ServletContext .class);
	    when(request.getServletContext()).thenReturn(context);	

	    
	    LogInInfo log = new LogInInfo();
	    log.setId(1);
	    
	    when(context.getAttribute(DBInfo.Attribute_Name)).thenReturn(log);	    
	    when(request.getRequestDispatcher("QuizDone.jsp")).thenReturn(dispatcher);

	    CreateQuizServlet cr = new CreateQuizServlet() {
	    	public ServletContext getServletContext() {
                return context;
            }
        };
	    
	    cr.doPost(request, response);
		verify(dispatcher).forward(request,response); 
	}

}
