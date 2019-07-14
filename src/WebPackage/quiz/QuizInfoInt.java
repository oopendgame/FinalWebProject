package WebPackage.quiz;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface QuizInfoInt {

	public ArrayList<QuizInfo> searchQuiz(String name, String cat);
	public ArrayList<QuizInfo> getQuizList();
	public QuizInfo getNewQuiz(ResultSet res);
	public QuizInfo getQuiz(int quizId);
	public void addQuiz(QuizInfo quiz, int author_id);

}
