package WebPackage.quiz;

import java.util.ArrayList;

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

	public void setQuestionId(int id) {
		question_id = id;
	}
	
	public String getType() {
		return question_type;
	}

	public void setType(String type) {
		question_type = type;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String quest) {
		question = quest;
	}
	
	public ArrayList<AnswerInfo> getAnswers() {
		return ans;
	}

	public void setAnswers(ArrayList<AnswerInfo> answers) {
		ans = answers;
	}
}
