package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import WebPackage.quiz.AnswerInfo;
import WebPackage.quiz.QuestionInfo;

public class QuestionInfoTest {
	
	@Test
	void test1() {		
		ArrayList<AnswerInfo> arr = new ArrayList<AnswerInfo>();
		AnswerInfo ans = new AnswerInfo(5, "1", false);
		arr.add(ans);
		ans = new AnswerInfo(0, "", true);
		arr.add(ans);
		
		QuestionInfo quest = new QuestionInfo(0, "1", "bla?", arr);
		assertEquals(0, quest.getQuestionId());
		assertEquals("1", quest.getType());
		assertEquals("bla?", quest.getQuestion());
		assertEquals(arr, quest.getAnswers());
	}
	
	
	@Test
	void test2() {		
		ArrayList<AnswerInfo> arr = new ArrayList<AnswerInfo>();
		AnswerInfo ans = new AnswerInfo(10, "fkjd", true);
		arr.add(ans);
		ans = new AnswerInfo(8, "jgvlkdjnhd", true);
		arr.add(ans);
		
		QuestionInfo quest = new QuestionInfo(-9, "8", "gdfdfhdf?", arr);
		assertEquals(-9, quest.getQuestionId());
		assertEquals("8", quest.getType());
		assertEquals("gdfdfhdf?", quest.getQuestion());
		assertEquals(arr, quest.getAnswers());
	}

}
