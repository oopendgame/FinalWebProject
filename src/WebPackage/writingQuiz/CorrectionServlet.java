package WebPackage.writingQuiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WebPackage.quiz.AnswerInfo;
import WebPackage.quiz.QuestionInfo;
import WebPackage.quiz.QuizInfo;
import WebPackage.quiz.findAnswerInfo;

/**
 * Servlet implementation class CorrectionServlet
 */
@WebServlet("/CorrectionServlet")
public class CorrectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorrectionServlet() {
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
		//doGet(request, response);
		
		HttpSession curSession = request.getSession();
		writeQuizInfo curInfo = (writeQuizInfo)curSession.getAttribute("writeQuiz");
		QuizInfo quiz = curInfo.getQuiz();
		int id = quiz.getQuizId();
		ArrayList<QuestionInfo> quest = curInfo.getQuestions();
		findAnswerInfo ansInfo = new findAnswerInfo();
		
		int userScore = 0;
		for(int i = 0; i < quest.size(); i++) {
			QuestionInfo cur = quest.get(i);
			String type = cur.getType();
			String userAns = request.getParameter(Integer.toString(cur.getQuestionId()));
		//	if(!type.equals("Multiple Choice")) {
				String corrAns = ansInfo.getCorrectAnswer(i);
				if(userAns.equals(corrAns)) userScore++;
		//	}	
		}
		
		Date startTime = curInfo.getStartTime();
		Date endTime = new Date((new java.util.Date()).getTime());
		long time = TimeUnit.MILLISECONDS.toMinutes(startTime.getTime() - endTime.getTime());
	}

}
