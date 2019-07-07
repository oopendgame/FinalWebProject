<%@ page import="WebPackage.quiz.QuizInfo"%>
<%@ page import="java.util.ArrayList"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
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

<form name = "quiz_id<%=i%>" action = "challengeServlet" method = "get" >
<input type = "hidden" name = "quiz_id" value = "<%=id%>">
</form>

<form name = "quizId<%=i%>" action="QuizPageServlet" method="post">
<a href="#" onclick="document.forms['quizId<%=i%>'].submit()"> Take </a> or
<a href='#' onclick="document.forms['quiz_id<%=i%>'].submit()"> Challenge </a>
<%=cur.getQuizName()%>
<input type = "hidden" name = "quizID" value="<%=id%>">
</form>
		
<% } %>

</body>
</html>