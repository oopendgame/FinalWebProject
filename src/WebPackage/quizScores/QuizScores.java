package WebPackage.quizScores;

import java.sql.Timestamp;
import java.util.ArrayList;

import WebPackage.quiz.QuestionInfo;

public interface QuizScores {
	
	public void addUserWrittenQuiz(int quiz_id, int user_id, int score, Timestamp start_time, int duration);
	public ArrayList<QuizScoreInfo> getUserWrittenQuizzes(int id);
	public ArrayList<QuizScoreInfo> getPopularQuizzes();
	public ArrayList<QuizScoreInfo> getRecentlyTakenQuizzes();
	public ArrayList<QuizScoreInfo> getUserScoresInQuiz(int user_id, int quiz_id);
	public ArrayList<QuizScoreInfo> getUserAttempts(int user_id, int quiz_id);
	public ArrayList<QuizScoreInfo> getMaxScoreInQuiz(int quiz_id);
	public ArrayList<QuizScoreInfo> getTodaysMaxScoreInQuiz(int quiz_id);
	public ArrayList<QuizScoreInfo> getLastSubmissions(int quiz_id);
	public ArrayList<QuizScoreInfo> getFriendsSubmission(int user_id, int quiz_id);
	public ArrayList<String> getCorrectAnswers(ArrayList<QuestionInfo> arr);

}
