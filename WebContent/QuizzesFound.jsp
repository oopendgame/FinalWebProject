<%@ page import="WebPackage.quiz.QuizInfo"%>
<%@ page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>

<!DOCTYPE html>
<html> 

<style>
body {
  font-size: 10;
}

div {
  padding-right: 30px;
  padding-left: 100px;
  font-size: 40;
}
</style>


<head>
<meta charset="UTF-8">
<title>Quiz List</title>
</head>

<body style="background-color:lavender;">

<div>
<%@ include file="search.jsp"%>
<center><h1> Quizzes Found </h1></center>


<%
	ArrayList<QuizInfo> arr = (ArrayList<QuizInfo>)request.getAttribute("matchingQuizzes");
	for(int i = 0; i < arr.size(); i++) {
		QuizInfo cur = arr.get(i);
		int id = cur.getQuizId(); 
		
%>
<h3>
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

</h3>		
<% } %>

</div>

</body>
</html>