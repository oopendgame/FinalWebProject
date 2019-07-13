package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import WebPackage.quiz.AnswerInfo;
import WebPackage.quiz.QuestionInfo;

public class QuestionInfoTest {
	
	@Test
	void test1() {		
		ArrayList<AnswerInfo> arr = new ArrayList<AnswerInfo>();
		QuestionInfo quest = new QuestionInfo(0, "1", "bla?", arr);
	}

}
