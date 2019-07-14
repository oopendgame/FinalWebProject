<%@ page import="WebPackage.user.userInfo"%>
<%@ page import="WebPackage.database.DBInfo"%>
<%@ page import="WebPackage.login.LogInInfo"%>
<%@ page import="WebPackage.quiz.findAdditionalInfo"%>
<%@ page import="WebPackage.quiz.QuizInfo"%>
<%@ page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">

<title>Friends List</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
</head>

<style>
div {
  padding-right: 30px;
  padding-left: 100px;
  font-size: 40;
}
</style>

<body  style="background-color:lavender;">
<br><br><br>

<div>
<%@ include file="search.jsp"%>
<%
	findAdditionalInfo req = new findAdditionalInfo();
	LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
	int id = log.getId();
	ArrayList<QuizInfo> arr = req.getUserCreatedQuizzes(id);
	if(arr.size() == 0) out.println("<center><h1>You have not created any quizzes</h1></center>");
	else { 
%>
	<p> <center><h1>YOUR QUIZZES</h1></center></p>
	
<% 
		for(int i = 0; i < arr.size(); i++) {
			QuizInfo cur = arr.get(i);
%>		
		<h3>
		 <i class='fas fa-sticky-note' style='font-size:24px'></i>
		 <% out.println(cur.getQuizName()); %> 
		 </h3>
			<% } } %>
</div>

  
<body>
</body>
</body>


</html>