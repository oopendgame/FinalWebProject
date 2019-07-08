<%@page import="java.util.ArrayList"%>
<%@ page import="WebPackage.quiz.QuestionInfo"%>
<%@ page import="WebPackage.quiz.QuizInfo"%>
<%@ page import="WebPackage.quiz.findAnswerInfo"%>
<%@ page import="WebPackage.quiz.AnswerInfo"%>
<%@ page import="WebPackage.writingQuiz.writeQuizInfo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<form action = "CorrectionServlet" method = "post">
	
<%
	HttpSession curSession = request.getSession();
	writeQuizInfo curInfo = (writeQuizInfo)curSession.getAttribute("writeQuiz");
	QuizInfo quiz = curInfo.getQuiz();
	ArrayList<QuestionInfo> quest = curInfo.getQuestions();
	findAnswerInfo ans = new findAnswerInfo();
	int id = quiz.getQuizId();
	
	for(int i = 1; i <= quest.size(); i++) {
		QuestionInfo cur = quest.get(i - 1);
		String type = cur.getType();
		ArrayList<AnswerInfo> arr = cur.getAnswers();
		
		out.println("Question " + i + ": ");
		out.println("<br>");
		out.println(cur.getQuestion());
		out.println("<br>");
		
		if(type.equals("Multiple Choice")) {
			for(int j = 0; j < arr.size(); j++) {
				AnswerInfo curAns = arr.get(j);
				out.println("<input type = \"radio\" "
								  + "name = \"" + cur.getQuestionId() + "\" "
								  + "value = \"" + curAns.getAnswerId() + "\">");
				out.println(curAns.getAnswer());
				out.println("<br>");
			}	
			
		} else if(type.equals("Fill In The Blank")) {
			
		}
	}


%>
	
	</form>

<html>
<head>
<meta charset="UTF-8">
<title>Writing Quiz</title>
</head>

<body>


</body>
</html>