package WebPackage.writingQuiz;

import java.util.ArrayList;

import WebPackage.quiz.QuestionInfo;
import WebPackage.quiz.findAnswerInfo;
import WebPackage.quiz.findQuestionInfo;

public class findQuizResults {
	
	public ArrayList<String> getCorrectAnswers(ArrayList<QuestionInfo> arr) {
		ArrayList<String> corr = new ArrayList<String>();
		for(int i = 0; i < arr.size(); i++) {
			int quest_id = arr.get(i).getQuestionId();
			findAnswerInfo findAns = new findAnswerInfo();
			String ans = findAns.getCorrectAnswer(quest_id);
			corr.add(ans);
		}		
		return corr;
	}

}
