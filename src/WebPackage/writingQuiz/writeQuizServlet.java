package WebPackage.writingQuiz;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WebPackage.quiz.QuestionInfo;
import WebPackage.quiz.QuizInfo;
import WebPackage.quiz.findQuestionInfo;
import WebPackage.quiz.findQuizInfo;

/**
 * Servlet implementation class writeQuizServlet
 */
@WebServlet("/writeQuizServlet")
public class writeQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public writeQuizServlet() {
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
		
		int id = Integer.parseInt(request.getParameter("quiz_id"));
		findQuizInfo quizInfo = new findQuizInfo();
		QuizInfo curQuiz = quizInfo.getQuiz(id);
		
		findQuestionInfo questInfo = new findQuestionInfo();
		ArrayList<QuestionInfo> quest = questInfo.getQuizQuestions(id);
		if(curQuiz.getRandom()) Collections.shuffle(quest);
		
		Date startTime = new Date((new java.util.Date()).getTime());
		writeQuizInfo cur = new writeQuizInfo(curQuiz, quest, startTime);
		
		HttpSession session = request.getSession();
		session.setAttribute("writeQuiz", cur);
	}

}
