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

}
