package WebPackage.quiz;

import java.sql.Date;
import java.util.ArrayList;

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
	private ArrayList<QuestionInfo> questions;
	
	public QuizInfo(int quizId, int authorId, boolean pageNum, boolean random, String name, boolean corr, Date date, String subject, String desc, ArrayList<QuestionInfo> arr) {
		quiz_id = quizId;
		author_id = authorId;
		page_num = pageNum;
		rand = random;
		quiz_name = name;
		correction_type = corr;
		creation_date = date;
		subj = subject;
		description = desc;
		questions = arr;
	}
	
	public int getQuizId() {
		return quiz_id;
	}
	
	
	public int getAuthorId() {
		return author_id;
	}
	
	public boolean getPageNum() {
		return page_num;
	}
	
		
	public boolean getRandom() {
		return rand;
	}

	
	public String getQuizName() {
		return quiz_name;
	}

	
	public Date getCreationDate() {
		return creation_date;
	}

	
	public boolean getCorrectionType() {
		return correction_type;
	}

	
	public ArrayList<QuestionInfo> getQuestions() {
		return questions;
	}

	public String getSubject() {
		return subj;
	}
	
	
	public String getDecription() {
		return description;
	}
	
}
