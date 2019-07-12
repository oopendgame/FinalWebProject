<%@page import="WebPackage.challenge.currQuizInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Challenge Sent</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<style>
		
.friend{
  width: 100%;
  height: 40px;
  overflow-y: auto;
  border: none;
  text-align: center;
}

#submitButton {
  font-family: FontAwesome;
}
</style>
</head>
<body style="background-color:lavender;">

<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<h1 style="font-size:200%; color:#330066; text-align:center;">Challenge Sent Successfully</h1>
<form action="QuizPageServlet" method="post">
		<%
		currQuizInfo currQuiz = (currQuizInfo)request.getAttribute("currquiz");
		String quizid = currQuiz.getId();
	%>
		<input type = "hidden" name = "quiz_id" value = "<%=quizid%>">
		<br>
		<input type = "submit" style="background-color: lavender; font-size: 17px; border: none; color:#330066; margin-left: 40%; cursor:pointer;"
			value="&#xf0a8 Return to quiz page" id="submitButton">
		</form>
</body>
</html>