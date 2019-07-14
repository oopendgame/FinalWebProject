package WebPackage.admin;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;

class makeAnnouncementServletTest {

	@Test
	void testGet1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    
	    when(request.getParameter("announcement")).thenReturn("randAnnouncement");
	    when(request.getParameter("title")).thenReturn("randTitle");
	    when(request.getParameter("user")).thenReturn("1");
	    when(request.getRequestDispatcher("announcementMade.jsp")).thenReturn(dispatcher);

	    makeAnnouncementServlet ann = new makeAnnouncementServlet();
	    
	    ann.doGet(request, response);
		verify(dispatcher).forward(request,response); 
	}
	@Test
	void testGet2() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    announcements info = mock(announcements.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    
	    when(request.getParameter("announcement")).thenReturn("");
	    when(request.getParameter("title")).thenReturn("");
	    when(request.getParameter("user")).thenReturn("3");
	    when(request.getRequestDispatcher("announcementMade.jsp")).thenReturn(dispatcher);

	    makeAnnouncementServlet ann = new makeAnnouncementServlet();
	    ann.doGet(request, response);
	    //verify(info, atLeast(1)).makeAnnouncement(3, "", "");
		verify(dispatcher).forward(request,response);
	}
	
	@Test
	void testPost1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    
	    when(request.getParameter("announcement")).thenReturn("randAnnouncement");
	    when(request.getParameter("title")).thenReturn("randTitle");
	    when(request.getParameter("user")).thenReturn("1");
	    when(request.getRequestDispatcher("announcementMade.jsp")).thenReturn(dispatcher);

	    makeAnnouncementServlet ann = new makeAnnouncementServlet();
	    
	    ann.doPost(request, response);
		verify(dispatcher).forward(request,response); 
	}
	@Test
	void testPost2() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    
	    when(request.getParameter("announcement")).thenReturn("");
	    when(request.getParameter("title")).thenReturn("");
	    when(request.getParameter("user")).thenReturn("3");
	    when(request.getRequestDispatcher("announcementMade.jsp")).thenReturn(dispatcher);

	    makeAnnouncementServlet ann = new makeAnnouncementServlet();
	    ann.doPost(request, response);
	    //verify(info, atLeast(1)).makeAnnouncement(3, "", "");
		verify(dispatcher).forward(request,response);
	}
}
