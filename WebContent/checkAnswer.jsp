<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList"%>
<%@ page import="WebPackage.quiz.QuestionInfo"%>
<%@ page import="WebPackage.quiz.QuizInfo"%>
<%@ page import="WebPackage.quiz.findAnswerInfo"%>
<%@ page import="WebPackage.quiz.AnswerInfo"%>
<%@ page import="WebPackage.writingQuiz.writeQuizInfo"%>
<%@ page import="WebPackage.quizScores.QuizScoreInfo"%> 
<%@ page import="WebPackage.quizScores.findQuizScoreInfo"%> 

<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>

<!DOCTYPE html>
<html>

<style>
div {
  padding-right: 30px;
  padding-left: 100px;
  font-size: 40;
}


<%@include file="Style.css" %>

</style>

<head>
<meta charset="UTF-8">
<title>Check Answer</title>
</head>

<body style="background-color:lavender;">

<div>

<%
	HttpSession curSession = request.getSession();
	writeQuizInfo curInfo = (writeQuizInfo)curSession.getAttribute("writeQuiz");
	QuizInfo quiz = curInfo.getQuiz();
	ArrayList<QuestionInfo> quest = curInfo.getQuestions();
	findAnswerInfo ans = new findAnswerInfo();
	int id = quiz.getQuizId();
	int i = curInfo.getQestionNum() + 1;
	if(quest.size() <= 0) { %>
		<center><h1> No Questions </h1></center>
	<%	return;
	}
	
		QuestionInfo cur = quest.get(i - 1);
		String type = cur.getType();
		ArrayList<AnswerInfo> arr = cur.getAnswers();
		%>
		
		<h3 style="font-size:200%; color:#330066; text-align:center;">
		<% 
		out.println("Question " + i + ":    ");
		
		ArrayList<QuestionInfo> questions = curInfo.getQuestions();
		findQuizScoreInfo addInf = new findQuizScoreInfo();
		ArrayList<String> userAns = curInfo.getUserAns();
		ArrayList<String> corrAns = addInf.getCorrectAnswers(questions);
		%>
		</h3>
		
		<%
		if(quest.size() != curInfo.getQestionNum() + 1) {
%>
	

<form id = "form" action = "ImmCheckServlet" method = "post">

	<h3>
	<%		
		if(!type.equals("2")) out.println(cur.getQuestion()); 
		else out.println("<img src = \"" + cur.getQuestion() + "\" alt = \"Anonymos Question. Just guess the answer and hope it's right\">");
		out.println("<br>");
		out.println("Your Answer: " + userAns.get(i - 1) + "<br>");
		out.println("Correct Answer: " + corrAns.get(i - 1) + "<br>");
		if(userAns.get(i - 1).equals(corrAns.get(i - 1))) out.println("Great! You are correct!<br>");
		else out.println("Soory, you are incorrect :(<br>");
	%>
	</h3>
	
	<input type = "submit" value = "Next Question">	
	
</form>

<% } else { %>

<form action = "CorrectionServlet" method = "post">

<h3>
	<%		
		if(!type.equals("2")) out.println(cur.getQuestion()); 
		else out.println("<img src = \"" + cur.getQuestion() + "\" alt = \"Anonymos Question. Just guess the answer and hope it's right\">");
		out.println("<br>");
		out.println("<br>");
		out.println("Your Answer: " + userAns.get(i - 1) + "<br>");
		out.println("Correct Answer: " + corrAns.get(i - 1) + "<br>");
		if(userAns.get(i - 1).equals(corrAns.get(i - 1))) out.println("Great! You are correct!<br>");
		else out.println("Soory, you are incorrect :(<br>");
	%>
	</h3>
	
	<input type = "submit" value = "Finish">	
	
	</form>

<%  } %>

</div>


</body>
</html>