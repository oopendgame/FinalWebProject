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

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<style>
div {
  padding-right: 30px;
  padding-left: 100px;
  font-size: 40;
}

h2 {
	color: midnightblue;
	font-style: bold;
}

h1 {
	color: green;
	font-style: italic;
}

h3 {
	color: red;
	font-style: italic;
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

	<h2>
	<i class='fas fa-question-circle' style='font-size:24px'></i>
	<%		
		
		if(!type.equals("2")) out.println(cur.getQuestion()); 
		else out.println("<img src = \"" + cur.getQuestion() + "\" alt = \"Anonymos Question. Just guess the answer and hope it's right\">");
		out.println("<br><br>");
		
		%>
		<i class="material-icons" style="font-size:36px">question_answer</i>
		<%
		out.println("Your Answer: " + userAns.get(i - 1) + "<br><br>");
		
		%>
		<i class='fas fa-check' style='font-size:36px'></i>
		<%
		out.println("Correct Answer: " + corrAns.get(i - 1) + "<br><br>");
		%>
		
		</h2>
		<center>
		
		<%
		
		if(userAns.get(i - 1).trim().equals(corrAns.get(i - 1).trim())) {
			%>
			<h1>
			<i class='far fa-grin-beam' style='font-size:24px'></i>
			<%			
			out.println("Great! You are correct!<br><br>");
			%>
			</h1>
			<%
		}
		else {
			%>
			<h3>
			<i class='fas fa-sad-cry' style='font-size:24px'></i>
			<%			
			out.println("Sorry, You are incorrect :(<br><br>");
			%>
			</h3>
			<%
		}
	%>
	</center>
	
	
	<input type = "submit" value = "Next Question">	
	
</form>

<% } else { %>

<form action = "CorrectionServlet" method = "post">

<h2>
	<i class='fas fa-question-circle' style='font-size:24px'></i>
	<%		
		
		if(!type.equals("2")) out.println(cur.getQuestion()); 
		else out.println("<img src = \"" + cur.getQuestion() + "\" alt = \"Anonymos Question. Just guess the answer and hope it's right\">");
		out.println("<br><br>");
		
		%>
		<i class="material-icons" style="font-size:36px">question_answer</i>
		<%
		out.println("Your Answer: " + userAns.get(i - 1) + "<br><br>");
		
		%>
		<i class='fas fa-check' style='font-size:36px'></i>
		<%
		out.println("Correct Answer: " + corrAns.get(i - 1) + "<br><br>");
		%>
		
		</h2>
		<center>
		
		<%
		
		if(userAns.get(i - 1).trim().equals(corrAns.get(i - 1).trim())) {
			%>
			<h1>
			<i class='far fa-grin-beam' style='font-size:24px'></i>
			<%			
			out.println("Great! You are correct!<br><br>");
			%>
			</h1>
			<%
		}
		else {
			%>
			<h3>
			<i class='fas fa-sad-cry' style='font-size:24px'></i>
			<%			
			out.println("Sorry, You are incorrect :(<br><br>");
			%>
			</h3>
			<%
		}
	%>
	</center>
	
	<input type = "submit" value = "Finish">	
	
	</form>

<%  } %>

</div>


</body>
</html>