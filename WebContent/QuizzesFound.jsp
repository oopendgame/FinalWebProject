<%@ page import="WebPackage.quiz.QuizInfo"%>
<%@ page import="java.util.ArrayList"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 

<style>
body {
  font-size: 10;
}
</style>


<head>
<meta charset="UTF-8">
<title>Quiz List</title>
</head>

<body>
<p> Quizzes Found: </p>

<%
	ArrayList<QuizInfo> arr = (ArrayList<QuizInfo>)request.getAttribute("matchingQuizzes");
	for(int i = 0; i < arr.size(); i++) {
		QuizInfo cur = arr.get(i);
		int id = cur.getQuizId();
		
%>

<span style='font-size:20px;'>&#9673;</span>
<%=cur.getQuizName()%>

<form name = "startForm" action = "WriteQuizServlet" method="get">
<input type = "hidden" id = "write_id" name = "quiz_id" value = "<%=id%>">
<input type = "submit" value = "start">
</form>
	
<form name = "challengeForm" action = "challengeServlet" method="get">
<input type = "hidden" id = "challenge_id" name = "quiz_id" value = "<%=id%>">
<input type = "submit" value = "challenge">
</form>
		
<% } %>

</body>
</html>