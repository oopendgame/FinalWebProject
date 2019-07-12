<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Promotion</title>
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
		.text_promote[type=text]{
		  width: 50%;
		  padding: 12px 15px;
		  margin: 8px 0;
		  display: inline-block;
		  border-radius: 4px;
		  box-sizing: border-box;
		}
		
		.button_promote[type=submit] {
		  width: 50%;
		  background-color: indigo;
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
	
	<form action="PromoteServlet" method="post" style="text-align:center">
		<h1 style="text-align:center">Promote Following User To Admin </h1>
		<input class = "text_promote" type="text" id="pusername" name="pusername" placeholder="Enter username">
		<input class = "button_promote" type="submit" value="Promote"><br>
	</form>
</body>
</html>