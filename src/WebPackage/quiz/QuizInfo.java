package WebPackage.quiz;

public class QuizInfo {
	
	public int quiz_id;
	public int author_id;
	public int page_num;
	public String correction_type;
	public String creation_date;
	public String subj;
	public String description;
	public String practice_mode;
	
	public QuizInfo(int quizId, int authorId, int pageNum, String corr, String date, String subject, String desc, String pract) {
		quiz_id = quizId;
		author_id = authorId;
		page_num = pageNum;
		correction_type = corr;
		creation_date = date;
		subj = subject;
		description = desc;
		practice_mode = pract;
	}
	
	public int getQuizId(QuizInfo q) {
		return q.quiz_id;
	}
	
	public int getAuthorId(QuizInfo q) {
		return q.author_id;
	}
	
	public int getPageNum(QuizInfo q) {
		return q.page_num;
	}
	
	public String getCreationDate(QuizInfo q) {
		return q.creation_date;
	}
	
	public String getCorrectionType(QuizInfo q) {
		return q.correction_type;
	}
	
	public String getSubject(QuizInfo q) {
		return q.subj;
	}
	
	public String getDecription(QuizInfo q) {
		return q.description;
	}
	
	public String getPractiseMode(QuizInfo q) {
		return q.practice_mode;
	}
	
}
