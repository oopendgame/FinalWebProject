package WebPackage.quiz;

import java.util.ArrayList;

public interface QuestInfo {
	
	public void addQuestion(int quiz_id, QuestionInfo question);
	public ArrayList<QuestionInfo> getQuizQuestions(int id);
	

}
