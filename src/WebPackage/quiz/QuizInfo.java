package WebPackage.quiz;

import java.sql.Date;

public class QuizInfo {
	
	public int quiz_id;
	public int author_id;
	public int page_num;
	public int rand;
	public String quiz_name;
	public String correction_type;
	public Date creation_date;
	public String subj;
	public String description;
	public String practice_mode;
	
	public QuizInfo(int quizId, int authorId, int pageNum, int random, String name, String corr, Date date, String subject, String desc, String pract) {
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
	
	public int getPageNum() {
		return page_num;
	}
	
	public void setPageNum(int pages) {
		page_num = pages;;
	}
		
	public int getRandom() {
		return rand;
	}
	
	public void setRandom(int random) {
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
	
	public String getCorrectionType() {
		return correction_type;
	}
	
	public void setCorrectionType(String corr) {
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
	
	public String getPractiseMode() {
		return practice_mode;
	}
	
	public void setPractiseMode(String prac) {
		practice_mode = prac;
	}
	
}
