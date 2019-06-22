package WebPackage.quiz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebPackage.database.DBConnection;

/**
 * Servlet implementation class CreateQuizServlet
 */
@WebServlet("/CreateQuizServlet")
public class CreateQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateQuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	private int getUserId() {
		int id = (int) getServletContext().getAttribute("...");
		return id;
	}
	
	
	private ArrayList<AnswerInfo> getAnswers(HttpServletRequest request, int quest) {
		ArrayList<String> ans = new ArrayList<String>(Arrays.asList(request.getParameterValues("question" + quest + "ans")));
		ArrayList<AnswerInfo> answers = new ArrayList<AnswerInfo>();
		
		String corrAns = request.getParameter("corrAns");
		AnswerInfo corr = new AnswerInfo(0, corrAns, true); //need to change id
		answers.add(corr);
		
		for(int i = 0; i < ans.size(); i++) {
			AnswerInfo cur = new AnswerInfo(0, ans.get(i), false); //need to change id
			answers.add(cur);
		}		
		return answers;
	}
	
	
	private ArrayList<QuestionInfo> getQuestions(HttpServletRequest request) {
		int counter = 0;
		ArrayList<QuestionInfo> questions = new ArrayList<QuestionInfo>();
		String type = request.getParameter("type" + (++counter));
		while(type != null) {
			String quest = request.getParameter("question" + counter);
			if(type.equals("1")) {
				String blank = request.getParameter("fillBlank" + counter);
				quest += blank;
			}
			ArrayList<AnswerInfo> answers = getAnswers(request, counter);
			QuestionInfo cur = new QuestionInfo(0, type, quest, answers); //need to change id
			questions.add(cur);			
			type = request.getParameter("type" + (++counter));
		}		
		return questions;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int quiz_id = 0; //need to change 
		String quiz_name = request.getParameter("quiz_name");
		int author_id = getUserId();
		Date crDate = new Date((new java.util.Date()).getTime());
		String desc = request.getParameter("description");
		String subj = request.getParameter("subject");
		boolean pageNum = request.getParameter("pageNum") != null && request.getParameter("pageNum").equals("one");
		boolean rand = request.getParameter("rand") != null && request.getParameter("rand").equals("true");
		boolean corr = request.getParameter("corr") != null && request.getParameter("corr").equals("imm");
		boolean pract = request.getParameter("pract") != null && request.getParameter("pract").equals("true");
		ArrayList<QuestionInfo> questions = getQuestions(request);
		
		QuizInfo quiz = new QuizInfo(quiz_id, author_id, pageNum, rand, quiz_name, corr, crDate, subj, desc, pract, questions);
		findQuizInfo newQuiz = new findQuizInfo();
		newQuiz.addQuiz(quiz, author_id);			
		request.getRequestDispatcher("quizDone.jsp").forward(request, response);
	}
}
