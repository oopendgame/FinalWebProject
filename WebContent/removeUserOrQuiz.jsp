<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>

<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<%@ include file="search.jsp"%>
<style>
body{
	background-color:lavender; 
	padding-top: 50px; 
	padding-right: 80px; 
	padding-bottom: 50px; 
	padding-left: 80px;
}
		.text_search[type=text]{
		  width: 50%;
		  padding: 12px 15px;
		  margin: 8px 0;
		  display: inline-block;
		  border-radius: 4px;
		  box-sizing: border-box;
		}
		
		.button_search[type=submit] {
		  width: 50%;
		  background-color: #e27d60;
		  color: white;
		  padding: 14px 20px;
		  margin: 8px 0;
		  border: none;
		  border-radius: 4px;
		  cursor: pointer;
		  font-size: 16px;
		  text-align: center;
		}
		
		
	</style>
<body>
	<body style="background-color:lavender;">
	<br><br>
	
	<form action="deleteUserQuizServlet" method="post" style="text-align:center">
		<h1 style="text-align:center"> Delete User  </h1>
		<input class = "text_search" type="text" id="username" name="username" placeholder="Enter username">
		<input class = "button_search" type="submit" value="Delete"><br>
	</form>
	
	<form action="deleteUserQuizServlet" method="get" style="text-align:center">
		<h1 style="text-align:center"> Delete Quiz </h1>
		<input class = "text_search" type="text" id="quizName" name="quizName" placeholder="Enter quiz name">
		<input class = "button_search" type="submit" value="Delete"><br>
	</form>
	<br><br><br><br>
</body>
</html>