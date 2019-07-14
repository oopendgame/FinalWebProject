package WebPackage.admin;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;

import WebPackage.user.findUserInfo;

class ClearHistoryServletTest {

	@Test
	void test1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("quizName")).thenReturn("randQuiz");

	    //adminInfo adInfo = mock(adminInfo.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    adminInfo info = new adminInfo();
	    

	    if(info.isQuiz("randQuiz")) {
	    	when(request.getRequestDispatcher("success.jsp")).thenReturn(dispatcher);
	    }else when(request.getRequestDispatcher("incorrectQuizNameClear.jsp")).thenReturn(dispatcher);
	    ClearHistoryServlet serv = new ClearHistoryServlet();
	    serv.doPost(request, response);
		verify(dispatcher).forward(request,response);
	}
	
	@Test
	void test2() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("quizName")).thenReturn("someOtherQuiz");

	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    adminInfo info = new adminInfo();
	    
	    if(info.isQuiz("someOtherQuiz")) {
	    	when(request.getRequestDispatcher("success.jsp")).thenReturn(dispatcher);
	    }else when(request.getRequestDispatcher("incorrectQuizNameClear.jsp")).thenReturn(dispatcher);
	    ClearHistoryServlet serv = new ClearHistoryServlet();
	    serv.doPost(request, response);
		verify(dispatcher).forward(request,response);
	}

}
