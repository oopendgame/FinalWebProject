<%@ page import="WebPackage.quiz.QuizInfo"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="WebPackage.homepage.announcement"%>
<%@page import="WebPackage.homepage.homepageInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quizzes</title>
</head>
<body  style="background-color:lavender;">
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<br>

<h1 style="font-size:200%; color:#330066; text-align:center;">Popular Quizzes</h1>
<br>

<%
	homepageInfo hpage = new homepageInfo();
	ArrayList<QuizInfo> arr = hpage.getQuizzesByPopularity();
	for(int i = 0; i < arr.size(); i++) {
		QuizInfo cur = arr.get(i);
		int id = cur.getQuizId(); 
		
%>
<h3 style = "margin-left: 40%;">
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