package WebPackage.writingQuiz;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WebPackage.database.DBInfo;
import WebPackage.login.LogInInfo;
import WebPackage.quiz.AnswerInfo;
import WebPackage.quiz.QuestionInfo;
import WebPackage.quiz.QuizInfo;
import WebPackage.quiz.findAnswerInfo;
import WebPackage.quizScores.findQuizScoreInfo;

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
		
		Date startTime = curInfo.getStartTime();
		Date endTime = new Date((new java.util.Date()).getTime());
		int duration = (int)TimeUnit.MILLISECONDS.toMinutes(startTime.getTime() - endTime.getTime());
		 
		QuizInfo quiz = curInfo.getQuiz();
		int id = quiz.getQuizId();
		ArrayList<QuestionInfo> quest = curInfo.getQuestions();
		findAnswerInfo ansInfo = new findAnswerInfo();
		
		int userScore = 0;
		for(int i = 0; i < quest.size(); i++) {
			QuestionInfo cur = quest.get(i); 
			//String type = cur.getType();
			String userAns = request.getParameter(Integer.toString(cur.getQuestionId()));
		//	if(!type.equals("Multiple Choice")) {
				String corrAns = ansInfo.getCorrectAnswer(cur.getQuestionId());
				System.out.println(cur.getQuestionId() + " " + userAns + " " + corrAns + "\n");
				if(userAns.equals(corrAns)) {
					userScore++;
					System.out.println(userAns + 7);
				}
		//	}	
		} 
		curInfo.setScore(userScore);
		
		LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
		int user_id = log.getId();		
		findQuizScoreInfo scoreInfo = new findQuizScoreInfo();
		scoreInfo.addUserWrittenQuiz(id, user_id, userScore, startTime, duration);
		
		RequestDispatcher rd = request.getRequestDispatcher("requestDone.jsp"); //need to change to "QuizFinished"
		rd.forward(request, response);
	}

}
