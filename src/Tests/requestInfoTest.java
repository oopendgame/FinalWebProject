package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

import WebPackage.requests.requestInfo;

public class requestInfoTest {
	
	@Test
	void test1() {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		requestInfo req = new requestInfo(2, 4, 6, 0, date, "userName");
		
		assertEquals(2, req.getRequestId());
		assertEquals(4, req.getSenderID());
		assertEquals(6, req.getReceiverID());
		assertEquals(0, req.getSatus());
		assertEquals(date, req.getSentDate());
		assertEquals("userName", req.getUserName());
	}
	
	
	@Test
	void test2() {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		requestInfo req = new requestInfo(0, 0, 0, 0, date, "");
		
		assertEquals(0, req.getRequestId());
		assertEquals(0, req.getSenderID());
		assertEquals(0, req.getReceiverID());
		assertEquals(0, req.getSatus());
		assertEquals(date, req.getSentDate());
		assertEquals("", req.getUserName());
	}
}
