package WebPackage.quiz;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	
	private ArrayList<AnswerInfo> getAnswers(HttpServletRequest request) {
		int counter = 0;
		ArrayList<AnswerInfo> answers = new ArrayList<AnswerInfo>();
		
		return answers;
	}
	
	
	private ArrayList<QuestionInfo> getQuestions(HttpServletRequest request) {
		int counter = 0;
		ArrayList<QuestionInfo> questions = new ArrayList<QuestionInfo>();
		String type = request.getParameter("type" + (++counter));
		while(type != null) {
			String quest = request.getParameter("question" + counter);
			if(type.equals("1")) {
				String st = "#$%$#";
				String blank = request.getParameter("fillBlank" + counter);
				st += blank;
				quest += st;
			}
			ArrayList<AnswerInfo> answers = getAnswers(request);
			
			
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
		Date createDate = new Date((new java.util.Date()).getTime());
		String desc = request.getParameter("description");
		String subj = request.getParameter("subject");
		boolean pageNum = request.getParameter("pageNum") != null && request.getParameter("pageNum").equals("one");
		boolean rand = request.getParameter("rand")!=null && request.getParameter("rand").equals("true");
		boolean corr = request.getParameter("corr")!=null && request.getParameter("corr").equals("imm");
		boolean pract = request.getParameter("pract")!=null && request.getParameter("pract").equals("true");
		ArrayList<QuestionInfo> questions = getQuestions(request);
		
		
	}

}
