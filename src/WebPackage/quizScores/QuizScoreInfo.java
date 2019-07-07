package WebPackage.quizScores;

import java.sql.Date;

import WebPackage.user.findUserInfo;
import WebPackage.user.userInfo;

public class QuizScoreInfo {
	private int quiz_id;
	private int user_id;
	private int score;
	private Date start_time;
	private int duration;
	
	
	public QuizScoreInfo(int quiz_id, int user_id, int score, Date start_time, int duration) {
		this.quiz_id = quiz_id;
		this.user_id = user_id;
		this.score = score;
		this.start_time = start_time;
		this.duration = duration;
	}
	
	public int getQuizId() {
		return quiz_id;
	}
    
	
	public int getUserId() {
		return user_id;
	}
	
	public String getUserName() {
		findUserInfo user = new findUserInfo();
		userInfo curUser = user.getMyUser(user_id);
		return curUser.getUserName(); 
	}
	
	public int getScore() {
		return score;
	}
	
	public Date getStartingDate() {
		return start_time;
	}
	
	public int getDuration() {
		return duration;
	}
}
