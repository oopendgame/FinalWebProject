package WebPackage.requests;

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

public class acceptRequestServletTest {
	
	@Test
	void test1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    RequestDispatcher dispatcher = mock(RequestDispatcher.class);	
	    
	    when(request.getParameter("quiz_name")).thenReturn("1");
	    when(request.getParameter("description")).thenReturn("3");
	    
	    findRequestInfo findReq = new findRequestInfo();
		findReq.addFriend(1, 2);
	    
	    StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        acceptRequestServlet cr = new acceptRequestServlet();
        
        when(request.getRequestDispatcher("requestDone.jsp")).thenReturn(dispatcher);
	    
	    cr.doGet(request, response);
		verify(dispatcher).forward(request,response); 
	}

}
