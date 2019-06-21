package WebPackage.quiz;

public class QuizInfo {
	
	public int quiz_id;
	public int author_id;
	public int page_num;
	public int rand;
	public String quiz_name;
	public String correction_type;
	public String creation_date;
	public String subj;
	public String description;
	public String practice_mode;
	
	public QuizInfo(int quizId, int authorId, int pageNum, int random, String name, String corr, String date, String subject, String desc, String pract) {
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
	
	public int getAuthorId() {
		return author_id;
	}
	
	public int getPageNum() {
		return page_num;
	}
	
	public int getRandom() {
		return rand;
	}
	
	public String getQuizName() {
		return quiz_name;
	}
	
	public String getCreationDate() {
		return creation_date;
	}
	
	public String getCorrectionType() {
		return correction_type;
	}
	
	public String getSubject() {
		return subj;
	}
	
	public String getDecription() {
		return description;
	}
	
	public String getPractiseMode() {
		return practice_mode;
	}
	
}
