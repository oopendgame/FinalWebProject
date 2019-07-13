package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import WebPackage.quiz.AnswerInfo;


public class AnswerInfoTest {	
	
	@Test
	void test1() {		
		AnswerInfo ans = new AnswerInfo(5, "1", false);
		assertEquals(5, ans.getAnswerId());
		assertEquals("1", ans.getAnswer());
		assertFalse(ans.getCorrectAns());
	}
	
	@Test
	void test2() {		
		AnswerInfo ans = new AnswerInfo(0, "", true);
		assertEquals(0, ans.getAnswerId());
		assertEquals("", ans.getAnswer());
		assertTrue(ans.getCorrectAns());
	}
	
	@Test
	void test3() {		
		AnswerInfo ans = new AnswerInfo(-5, "knkjfdn", true);
		assertEquals(-5, ans.getAnswerId());
		assertEquals("knkjfdn", ans.getAnswer());
		assertTrue(ans.getCorrectAns());
	}
	

}
