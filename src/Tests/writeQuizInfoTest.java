package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

import WebPackage.quiz.AnswerInfo;
import WebPackage.quiz.QuestionInfo;
import WebPackage.quiz.QuizInfo;
import WebPackage.writingQuiz.writeQuizInfo;

public class writeQuizInfoTest {
	
	
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
		
		Timestamp startTime = new java.sql.Timestamp(System.currentTimeMillis());
		
		writeQuizInfo writeQuiz = new writeQuizInfo(quiz, brr, startTime);
		assertEquals(quiz,  writeQuiz.getQuiz());
		assertEquals(brr, writeQuiz.getQuestions());
		assertEquals(startTime, writeQuiz.getStartTime());
	}
	
	
	@Test
	void test2() {
		ArrayList<AnswerInfo> arr = new ArrayList<AnswerInfo>();
		AnswerInfo ans = new AnswerInfo(10, "14", true);
		arr.add(ans);
		ans = new AnswerInfo(7, "bdb", true);
		arr.add(ans);
		
		ArrayList<QuestionInfo> brr = new ArrayList<QuestionInfo>();
		QuestionInfo quest = new QuestionInfo(5, "1", "oooo?", arr);
		brr.add(quest);
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		QuizInfo quiz = new QuizInfo(0, 2, true, false, "quiiiz", false, date, "category", "smth", brr);
		
		Timestamp startTime = new java.sql.Timestamp(System.currentTimeMillis());
		
		writeQuizInfo writeQuiz = new writeQuizInfo(quiz, brr, startTime);
		assertEquals(quiz,  writeQuiz.getQuiz());
		assertEquals(brr, writeQuiz.getQuestions());
		assertEquals(startTime, writeQuiz.getStartTime());
	}
	
	
	@Test
	void test3() {
		ArrayList<AnswerInfo> arr = new ArrayList<AnswerInfo>();
		AnswerInfo ans = new AnswerInfo(8, "17", false);
		arr.add(ans);
		ans = new AnswerInfo(20, "klg", true);
		arr.add(ans);
		
		ArrayList<QuestionInfo> brr = new ArrayList<QuestionInfo>();
		QuestionInfo quest = new QuestionInfo(0, "12", "fksdnjksn?", arr);
		brr.add(quest);
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		QuizInfo quiz = new QuizInfo(0, 2, true, false, "gfdbf", false, date, "gsgs", "jnljvgdbsfnblsbnfkjdl", brr);
		
		Timestamp startTime = new java.sql.Timestamp(System.currentTimeMillis());
		
		writeQuizInfo writeQuiz = new writeQuizInfo(quiz, brr, startTime);
		assertEquals(quiz,  writeQuiz.getQuiz());
		assertEquals(brr, writeQuiz.getQuestions());
		assertEquals(startTime, writeQuiz.getStartTime());
		
		writeQuiz.setDuration(10);
		assertEquals(10, writeQuiz.getDuration());
		
		writeQuiz.setScore(45);
		assertEquals(45, writeQuiz.getScore());
		
		assertFalse(writeQuiz.getScoreDone());
		writeQuiz.setScoreDone();
		assertTrue(writeQuiz.getScoreDone());
	}
	
	
	@Test
	void test4() {
		ArrayList<AnswerInfo> arr = new ArrayList<AnswerInfo>();
		AnswerInfo ans = new AnswerInfo(10, "14", true);
		arr.add(ans);
		ans = new AnswerInfo(7, "bdb", true);
		arr.add(ans);
		
		ArrayList<QuestionInfo> brr = new ArrayList<QuestionInfo>();
		QuestionInfo quest = new QuestionInfo(5, "1", "oooo?", arr);
		brr.add(quest);
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		QuizInfo quiz = new QuizInfo(0, 2, true, false, "quiiiz", false, date, "category", "smth", brr);
		
		Timestamp startTime = new java.sql.Timestamp(System.currentTimeMillis());
		
		writeQuizInfo writeQuiz = new writeQuizInfo(quiz, brr, startTime);		
		
		writeQuiz.setDuration(-9);
		assertEquals(-9, writeQuiz.getDuration());
		
		writeQuiz.setScore(0);
		assertEquals(0, writeQuiz.getScore());
		
		assertFalse(writeQuiz.getScoreDone());
		writeQuiz.setScoreDone();
		writeQuiz.setScoreDone();
		writeQuiz.setScoreDone();
		assertTrue(writeQuiz.getScoreDone());
	}

}
