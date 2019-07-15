package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import WebPackage.challenge.challengeInfo;

public class challengeInfoTests {
	
	@Test
	void test1() {
		int id = 1;
		int user1Id = 2;
		int user2Id = 3;
		String link = "bla.com";
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = simpleDateFormat.parse("2018-09-09");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		challengeInfo ci = new challengeInfo(id, user1Id, user2Id, link, date);
		assertEquals(ci.getId(), id);
		assertEquals(ci.getUser1Id(), user1Id);
		assertEquals(ci.getUser2Id(), user2Id);
		assertEquals(ci.getLink(), link);
		assertEquals(ci.getDate(), date);

	}
	
	@Test
	void test2() {
		int id = 10;
		int user1Id = 200;
		int user2Id = 40;
		String link = "123";
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = simpleDateFormat.parse("1111-11-11");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		challengeInfo ci = new challengeInfo(id, user1Id, user2Id, link, date);
		assertNotEquals(ci.getId(), 0);
		assertEquals(ci.getUser1Id(), user1Id);
		assertEquals(ci.getUser2Id(), user2Id);
		assertEquals(ci.getLink(), link);
		assertEquals(ci.getDate(), date);

	}
}