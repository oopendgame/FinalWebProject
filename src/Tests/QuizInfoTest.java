package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

import WebPackage.quiz.AnswerInfo;
import WebPackage.quiz.QuestionInfo;
import WebPackage.quiz.QuizInfo;

public class QuizInfoTest {
	
	@Test
	void test1() {	
		ArrayList<AnswerInfo> arr = new ArrayList<AnswerInfo>();
		AnswerInfo ans = new AnswerInfo(5, "1", false);
		arr.add(ans);
		ans = new AnswerInfo(0, "", true);
		arr.add(ans);
		
		ArrayList<QuestionInfo> brr = new ArrayList<QuestionInfo>();
		QuestionInfo quest = new QuestionInfo(0, "1", "bla?", arr);
		brr.add(quest);
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		QuizInfo quiz = new QuizInfo(0, 2, true, false, "testQuiz", false, date, "subj", "jnljfnblsbnfkjdl", brr);	
		
		assertEquals(0, quiz.getQuizId());
		assertEquals(2, quiz.getAuthorId());
		assertTrue(quiz.getPageNum());
		assertFalse(quiz.getRandom());
		assertEquals("testQuiz", quiz.getQuizName());
		assertFalse(quiz.getCorrectionType());
		assertEquals(date, quiz.getCreationDate());
		assertEquals("subj", quiz.getSubject());
		assertEquals("jnljfnblsbnfkjdl", quiz.getDecription());
		assertEquals(brr, quiz.getQuestions());
		
	}
	
	
	@Test
	void test2() {	
		ArrayList<AnswerInfo> arr = new ArrayList<AnswerInfo>();
		AnswerInfo ans = new AnswerInfo(20, "3", true);
		arr.add(ans);
		ans = new AnswerInfo(3, "fgf", false);
		arr.add(ans);
		
		ArrayList<QuestionInfo> brr = new ArrayList<QuestionInfo>();
		QuestionInfo quest = new QuestionInfo(5, "nksdn", "fkdsnvsklbvj?", arr);
		brr.add(quest);
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		QuizInfo quiz = new QuizInfo(-4, 5, true, true, "gsdgsv", false, date, "qwer", "d", brr);	
		
		assertEquals(-4, quiz.getQuizId());
		assertEquals(5, quiz.getAuthorId());
		assertTrue(quiz.getPageNum());
		assertTrue(quiz.getRandom());
		assertEquals("gsdgsv", quiz.getQuizName());
		assertFalse(quiz.getCorrectionType());
		assertEquals(date, quiz.getCreationDate());
		assertEquals("qwer", quiz.getSubject());
		assertEquals("d", quiz.getDecription());
		assertEquals(brr, quiz.getQuestions());
		
	}
	
	

}
