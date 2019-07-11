package WebPackage.writingQuiz;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import WebPackage.quiz.AnswerInfo;
import WebPackage.quiz.QuestionInfo;
import WebPackage.quiz.QuizInfo;

public class writeQuizInfo {
	private QuizInfo quiz;
	private ArrayList<QuestionInfo> quest;
	private ArrayList<String> userAnswers;
	private Timestamp startTime;
	private int userScore;
	private int questionNum;
	private boolean scoreDone;
	private int duration;
	
	public writeQuizInfo(QuizInfo quiz, ArrayList<QuestionInfo> quest, Timestamp startTime) {
		questionNum = 0;
		this.quiz = quiz;
		this.quest = quest;
		this.startTime = startTime;
		userAnswers = new ArrayList<String>();
		scoreDone = false;
		duration = 0;
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
	
	public void addUserAns(String ans) {
		userAnswers.add(ans);
	}
	
	public ArrayList<String> getUserAns() {
		return userAnswers;
	}
	
	public void setScoreDone() {
		scoreDone = true;
	}
	
	public boolean getScoreDone() {
		return scoreDone;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
