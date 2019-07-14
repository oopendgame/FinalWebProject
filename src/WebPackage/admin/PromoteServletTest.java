package WebPackage.admin;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import WebPackage.user.findUserInfo;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




class PromoteServletTest {
	
	
	@Test
	void testWrong1() throws IOException, ServletException {
		//System.out.println("first");

		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("pusername")).thenReturn("nchan17"); 

	    //adminInfo adInfo = mock(adminInfo.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    findUserInfo info = new findUserInfo();
	    
	    //when(adInfo.promoteToAdmin("nchan17")).thenCallRealMethod();
	    //System.out.println(adInfo.promoteToAdmin("nchan17"));
	    if(info.isUser("nchan17")) {
	    	when(request.getRequestDispatcher("success.jsp")).thenReturn(dispatcher);
	    }else when(request.getRequestDispatcher("incorrectUserPromote.jsp")).thenReturn(dispatcher);
	    PromoteServlet serv = new PromoteServlet();
	    serv.doPost(request, response);
		verify(dispatcher).forward(request,response);


	}
	
	
	@Test
	void testWrong2() throws IOException, ServletException {
		//System.out.println("second");
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("pusername")).thenReturn("randName");
	    
	    //adminInfo adInfo = mock(adminInfo.class);
	    //when(adInfo.promoteToAdmin("randName")).thenCallRealMethod();
	    findUserInfo info = new findUserInfo();
	    //System.out.println(adInfo.promoteToAdmin("randName"));
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    if(info.isUser("randName")) {
	    	when(request.getRequestDispatcher("success.jsp")).thenReturn(dispatcher);
	    }else when(request.getRequestDispatcher("incorrectUserPromote.jsp")).thenReturn(dispatcher);
        new PromoteServlet().doPost(request, response);

		verify(dispatcher).forward(request,response);



	}

}
