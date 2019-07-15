package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import WebPackage.homepage.Activity;

public class activityTests {
	
	@Test 
	void test1() {
		int userid = 0;
		String activity = "bla";
		String actid = "12";
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = simpleDateFormat.parse("000-00-00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Activity a = new Activity(userid, activity, actid, date);
		
		assertEquals(userid, a.getUserId());
		assertEquals(activity, a.getActivity());
		assertEquals(actid, a.getActId());
		assertEquals(date, a.getDate());
	}
}
