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
	void test() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("pusername")).thenReturn("randName");
		findMessageInfo info = mock(findMessageInfo.class);
	 	findUserInfo fuserInfo = mock(findUserInfo.class);
	    LogInInfo fcurrInfo = mock(LogInInfo.class);
	    when(request.getParameter("messageID")).thenReturn("1");
	    when(request.getParameter("userId")).thenReturn("3");
	    when(request.getParameter("user")).thenReturn("2");
	    when(request.getParameter("sms")).thenReturn("randMessage");
	    
        final ServletContext sContext = mock(ServletContext.class);
	    chatServlet chat = new chatServlet() {
            public ServletContext getServletContext() {
                return sContext;
            }
        };
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	    when(request.getRequestDispatcher("individualMessage.jsp")).thenReturn(dispatcher);

	    chat.doGet(request, response);
		verify(dispatcher).forward(request,response);
		
//	    userInfo currUser =  fuserInfo.getMyUser(fcurrInfo.getUserName());
//	    int messageID = Integer.parseInt(request.getParameter("messageID"));
//		int userId = Integer.parseInt(request.getParameter("userId"));
//		String chatterName = request.getParameter("user");
//		String sms = request.getParameter("sms");
//		info.putSms(currUser.getId(), userId, sms);
//		ArrayList<messageInfo> allChat = info.getAllMessages(currUser.getUserName(), chatterName);
//		RequestDispatcher rd = request.getRequestDispatcher("individualMessage.jsp");
//		rd.forward(request, response);
	}

}
