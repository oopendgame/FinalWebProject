package WebPackage.writingQuiz;

import java.sql.Date;
import java.util.ArrayList;

import WebPackage.quiz.QuestionInfo;
import WebPackage.quiz.QuizInfo;

public class writeQuizInfo {
	private QuizInfo quiz;
	private ArrayList<QuestionInfo> quest;
	private Date startTime;
	private int userScore;
	
	public writeQuizInfo(QuizInfo quiz, ArrayList<QuestionInfo> quest, Date startTime) {
		this.quiz = quiz;
		this.quest = quest;
		this.startTime = startTime;
	}
	
	public QuizInfo getQuiz() {
		return quiz;
	}
	
	public ArrayList<QuestionInfo> getQuestions() {
		return quest;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public void setScore(int score) {
		userScore = score;
	}
	
	public int getScore() {
		return userScore;
	}
}
