<%@ page import="WebPackage.quiz.QuizInfo"%>
<%@ page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<%@ include file="search.jsp"%>

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

<body style="background-color:lavender;">
<center><h1> Quizzes Found </h1></center>

<%
	ArrayList<QuizInfo> arr = (ArrayList<QuizInfo>)request.getAttribute("matchingQuizzes");
	for(int i = 0; i < arr.size(); i++) {
		QuizInfo cur = arr.get(i);
		int id = cur.getQuizId(); 
		
%>

<span style='font-size:20px;'>&#9673;</span>
<%=cur.getQuizName()%>

<form name = "startForm<%=i%>" action = "QuizPageServlet" method="get">
<input type = "hidden" name = "quiz_id" value = "<%=id%>">
<input type = "submit" value = "view quiz">
</form>
	
<form name = "challengeForm<%=i%>" action = "challengeServlet" method="get">
<input type = "hidden" name = "quiz_id" value = "<%=id%>">
<input type = "submit" value = "challenge friends">
</form>
		
<% } %>

</body>
</html>