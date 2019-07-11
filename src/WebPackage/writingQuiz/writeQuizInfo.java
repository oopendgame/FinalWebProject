package WebPackage.writingQuiz;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import WebPackage.quiz.QuestionInfo;
import WebPackage.quiz.QuizInfo;

public class writeQuizInfo {
	private QuizInfo quiz;
	private ArrayList<QuestionInfo> quest;
	private Timestamp startTime;
	private int userScore;
	private int questionNum;
	
	public writeQuizInfo(QuizInfo quiz, ArrayList<QuestionInfo> quest, Timestamp startTime) {
		questionNum = 0;
		this.quiz = quiz;
		this.quest = quest;
		this.startTime = startTime;
	}
	
	public void increaseQuestionNum() {
		questionNum++;
	}
	
	public int getQestionNum() {
		return questionNum;
	}
	
	public QuizInfo getQuiz() {
		return quiz;
	}
	
	public ArrayList<QuestionInfo> getQuestions() {
		return quest;
	}
	
	public Timestamp getStartTime() {
		return startTime;
	}
	
	public void setScore(int score) {
		userScore = score;
	}
	
	public int getScore() {
		return userScore;
	}
}
