package WebPackage.writingQuiz;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
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
import WebPackage.user.findAchievementInfo;

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
		//System.out.println((curInfo != null) + " t\n");
		
		Timestamp startTime = curInfo.getStartTime();
		Timestamp endTime = new java.sql.Timestamp(System.currentTimeMillis());
		int duration = (int)TimeUnit.MILLISECONDS.toSeconds(endTime.getTime() - startTime.getTime());
		 
		QuizInfo quiz = curInfo.getQuiz();
		int id = quiz.getQuizId();
		ArrayList<QuestionInfo> quest = curInfo.getQuestions();
		findAnswerInfo ansInfo = new findAnswerInfo();
		
		int userScore = 0;
		for(int i = 0; i < quest.size(); i++) {
			QuestionInfo cur = quest.get(i);
			String type = cur.getType();
			String userAns = request.getParameter(Integer.toString(cur.getQuestionId()));
			//System.out.println(userAns == null + "2\n");
			
			if(!type.equals("1")) {
				String corrAns = ansInfo.getCorrectAnswer(cur.getQuestionId());
				System.out.println(cur.getQuestionId() + " " + userAns + " " + corrAns + "\n");
				if(userAns != null && userAns.trim().equals(corrAns.trim())) {
					//System.out.println("hereeeee" + 1);
					userScore++;
				}
				if(curInfo.getQestionNum() <= i) curInfo.addUserAns(userAns); // < || <=
				
			} else if(userAns != null) {
				//System.out.println(ansInfo.getCorrectAnswer(cur.getQuestionId()));
				int ansId = Integer.parseInt(userAns);
				if(ansInfo.isAnswerCorrect(ansId)) {
					//System.out.println("hereeeee" + 2);
					userScore++;
				}
				if(curInfo.getQestionNum() <= i) curInfo.addUserAns(ansInfo.getMultiAnswer(Integer.parseInt(userAns))); // < || <=
			}
			
			
		} 
		if(!curInfo.getScoreDone()) {
			userScore += curInfo.getScore();
			curInfo.setScore(userScore);
			curInfo.setScoreDone();
			curInfo.setDuration(duration);
			
			LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
			int user_id = log.getId();		
			findQuizScoreInfo scoreInfo = new findQuizScoreInfo();
			scoreInfo.addUserWrittenQuiz(id, user_id, curInfo.getScore(), startTime, curInfo.getDuration());
			findAchievementInfo achInfo = new findAchievementInfo();
			achInfo.refreshAchQuizCreate(user_id);
		} 
		
		RequestDispatcher rd = request.getRequestDispatcher("QuizFinished.jsp");
		rd.forward(request, response);
	}

}
