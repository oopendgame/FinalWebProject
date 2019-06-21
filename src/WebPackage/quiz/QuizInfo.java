package WebPackage.quiz;

import java.sql.Date;

public class QuizInfo {
	
	public int quiz_id;
	public int author_id;
	public boolean page_num;
	public boolean rand;
	public String quiz_name;
	public boolean correction_type;
	public Date creation_date;
	public String subj;
	public String description;
	public boolean practice_mode;
	
	public QuizInfo(int quizId, int authorId, boolean pageNum, boolean random, String name, boolean corr, Date date, String subject, String desc, boolean pract) {
		quiz_id = quizId;
		author_id = authorId;
		page_num = pageNum;
		rand = random;
		quiz_name = name;
		correction_type = corr;
		creation_date = date;
		subj = subject;
		description = desc;
		practice_mode = pract;
	}
	
	public int getQuizId() {
		return quiz_id;
	}
	
	public void setQuizId(int quizId) {
		quiz_id = quizId;
	}
	
	public int getAuthorId() {
		return author_id;
	}
	
	public void setAuthorId(int authorId) {
		author_id = authorId;;
	}
	
	public boolean getPageNum() {
		return page_num;
	}
	
	public void setPageNum(boolean pages) {
		page_num = pages;;
	}
		
	public boolean getRandom() {
		return rand;
	}
	
	public void setRandom(boolean random) {
		rand = random;
	}
	
	public String getQuizName() {
		return quiz_name;
	}
	
	public void serQuizName(String name) {
		quiz_name = name;
	}
	
	public Date getCreationDate() {
		return creation_date;
	}
	
	public void setCreationDate(Date date) {
		creation_date = date;
	}
	
	public boolean getCorrectionType() {
		return correction_type;
	}
	
	public void setCorrectionType(boolean corr) {
		correction_type = corr;
	}
	
	public String getSubject() {
		return subj;
	}
	
	public void setSubject(String subject) {
		subj = subject;
	}
	
	public String getDecription() {
		return description;
	}
	
	public void setDecription(String desc) {
		description = desc;
	}
	
	public boolean getPractiseMode() {
		return practice_mode;
	}
	
	public void setPractiseMode(boolean prac) {
		practice_mode = prac;
	}
	
}
