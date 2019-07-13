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

<h1 style="font-size:200%; color:#330066; text-align:center;">My Taken Quizzes</h1>
<br>

<%
	homepageInfo hpage = new homepageInfo();
	LogInInfo currInfo = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
	int usid = currInfo.getId();
	ArrayList<QuizInfo> tarr = hpage.getTakenQuizzes(usid);
	if(tarr.size() == 0) {%>
		<h3 style="font-size:100%; color:#330066; text-align:center;">No Quizzes</h3>
	<%} for(int i = 0; i < tarr.size(); i++) {
	QuizInfo cur = tarr.get(i);
	int tqid = cur.getQuizId(); 
	
		
%>
<h3 style = "margin-left: 40%;">
<span style='font-size:20px;'>&#9673;</span>
<%=cur.getQuizName()%>

<form name = "startForm<%=i%>" action = "QuizPageServlet" method="get">
<input type = "hidden" name = "quiz_id" value = "<%=tqid%>">
<input type = "submit" value = "view quiz">
</form>
	
<form name = "challengeForm<%=i%>" action = "challengeServlet" method="get">
<input type = "hidden" name = "quiz_id" value = "<%=tqid%>">
<input type = "submit" value = "challenge friends">
</form>

</h3>		
<% } %>

</body>
</html>