package WebPackage.quiz;

import java.util.ArrayList;

public interface AnsInfo {
	
	public void addAnswer(int id, AnswerInfo ans);
	public String getMultiAnswer(int id);
	public boolean isAnswerCorrect(int id);
	public ArrayList<AnswerInfo> getAnswers(int id);
	public String getCorrectAnswer(int id);

}
