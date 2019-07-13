package WebPackage.quiz;

public class AnswerInfo {
	private int answer_id;
	private String answer;
	private boolean correct_ans;
	
	public AnswerInfo(int id, String ans, boolean corr) {
		answer_id = id;
		answer = ans;
		correct_ans = corr;
	}
	
	public int getAnswerId() {
		return answer_id;
	}


	public String getAnswer() {
		return answer;
	}

	
	public boolean getCorrectAns(){
		return correct_ans;
	}
	
	
}
