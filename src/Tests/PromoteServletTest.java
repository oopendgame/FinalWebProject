package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.*;
import javax.servlet.http.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class PromoteServletTest {

	@Test
	void test() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    when(request.getParameter("username")).thenReturn("nchan17");
        when(request.getParameter("password")).thenReturn("bla");
        final ServletContext servletContext = mock(ServletContext.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        verify(request, atLeast(1)).getParameter("username"); // only if you want to verify username was called...
        writer.flush(); // it may not have been flushed yet...
        boolean b = stringWriter.toString().contains("My expected string");
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        HttpServletResponse responseMock = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class);

        when(requestMock.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute("User")).thenReturn(null);
        when(requestMock.getRequestDispatcher("/User/login.jsp")).thenReturn(null);

	}

}
