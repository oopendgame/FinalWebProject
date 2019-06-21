package WebPackage.quiz;

public class QuetionInfo {
	private int question_id;
	private String question_type;
	private String question;
	
	public QuetionInfo(int id, String type, String quest) {
		question_id = id;
		question_type = type;
		question = quest;
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
}
