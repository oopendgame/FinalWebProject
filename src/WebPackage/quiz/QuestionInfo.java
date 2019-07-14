package WebPackage.quiz;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionInfo {
	private int question_id;
	private String question_type;
	private String question;
	private ArrayList<AnswerInfo> ans;
	
	public QuestionInfo(int id, String type, String quest, ArrayList<AnswerInfo> arr) {
		question_id = id;
		question_type = type;
		question = quest;
		ans = arr;
	}
	
	public int getQuestionId() {
		return question_id;
	}

	public String getType() {
		return question_type;
	}

	
	public String getQuestion() {
		return question;
	}
	
	public ArrayList<AnswerInfo> getAnswers() {
		if(question_type.equals("1")) Collections.shuffle(ans);
		return ans;
	}

}
