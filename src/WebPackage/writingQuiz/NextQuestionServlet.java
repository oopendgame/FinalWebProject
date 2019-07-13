package WebPackage.writingQuiz;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WebPackage.quiz.QuestionInfo;
import WebPackage.quiz.QuizInfo;
import WebPackage.quiz.findAnswerInfo;

/**
 * Servlet implementation class NextQuestionServlet
 */
@WebServlet("/NextQuestionServlet")
public class NextQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextQuestionServlet() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		HttpSession curSession = request.getSession();
		writeQuizInfo curInfo = (writeQuizInfo)curSession.getAttribute("writeQuiz");
		QuizInfo quiz = curInfo.getQuiz();
		int id = quiz.getQuizId();
		ArrayList<QuestionInfo> quest = curInfo.getQuestions();
		findAnswerInfo ansInfo = new findAnswerInfo();
		
		int i = curInfo.getQestionNum();
		QuestionInfo cur = quest.get(i);
		String type = cur.getType();
		String userAns = request.getParameter(Integer.toString(cur.getQuestionId()));
		System.out.println(userAns == null + "8\n");
		
		String corrAns = ansInfo.getCorrectAnswer(cur.getQuestionId());
		boolean corr = false;
		
		if(!type.equals("1")) {
			System.out.println(cur.getQuestionId() + " " + userAns + " " + corrAns + "\n");
			if(userAns != null && userAns.trim().equals(corrAns.trim())) {
				System.out.println("hereeeeeNext" + 1);
				curInfo.setScore(1 + curInfo.getScore());
				corr = true;
			}
			curInfo.addUserAns(userAns);
			
		} else if(userAns != null) {
			System.out.println(ansInfo.getCorrectAnswer(cur.getQuestionId()));
			corrAns = ansInfo.getCorrectAnswer(cur.getQuestionId());
			
			int ansId = Integer.parseInt(userAns);
			if(ansInfo.isAnswerCorrect(ansId)) {
				System.out.println("hereeeeeNext" + 2);
				curInfo.setScore(1 + curInfo.getScore());
				corr = true;
			}
			curInfo.addUserAns(ansInfo.getMultiAnswer(Integer.parseInt(userAns)));
		}
		curInfo.increaseQuestionNum();
		
		if(quiz.getCorrectionType()) {
			if(corr) {
				response.getWriter().println("Good Job! Your answers correct!");
			} else {
				response.getWriter().println("Sorry, you are incorrect. Correct answer was: " + corrAns);
			}
		}
		
		String st = "WriteQuizMult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(st);
		rd.forward(request, response);
	}

}
