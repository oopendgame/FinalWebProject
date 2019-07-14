package Tests;

import java.sql.Date;
import java.util.Calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import WebPackage.quizScores.QuizScoreInfo;

public class QuizScoreInfoTest {
	
	@Test
	void test1() {	
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		QuizScoreInfo quiz = new QuizScoreInfo(1, 3, 10, date, 15);
		
		assertEquals(1, quiz.getQuizId());
		assertEquals(3, quiz.getUserId());
		assertEquals(10, quiz.getScore());
		assertEquals(date, quiz.getStartingDate());
		assertEquals(15, quiz.getDuration());
	}
	
	
	@Test
	void test2() {	
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		QuizScoreInfo quiz = new QuizScoreInfo(8, -6, 45, date, 30);
		
		assertEquals(8, quiz.getQuizId());
		assertEquals(-6, quiz.getUserId());
		assertEquals(45, quiz.getScore());
		assertEquals(date, quiz.getStartingDate());
		assertEquals(30, quiz.getDuration());
	}

}
