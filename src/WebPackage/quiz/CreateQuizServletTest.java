package WebPackage.quiz;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;

import WebPackage.admin.makeAnnouncementServlet;

public class CreateQuizServletTest {
	
	@Test
	void test1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    
	    when(request.getParameter("quiz_name")).thenReturn("quizName");
	    when(request.getParameter("title")).thenReturn("randTitle");
	    when(request.getParameter("user")).thenReturn("1");
	    when(request.getRequestDispatcher("announcementMade.jsp")).thenReturn(dispatcher);

	    makeAnnouncementServlet ann = new makeAnnouncementServlet();
	    
	    ann.doGet(request, response);
		verify(dispatcher).forward(request,response); 
	}

}
