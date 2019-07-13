<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<style>
#content, html, body {
    height: 98%;
}
#left {
    float: left;
    width: 70%;
    height: 100%;
    overflow: scroll;
    padding: 5px;
}
#right {
    float: left;
    width: 30%;
    height: 100%;
    overflow: scroll;
    padding: 5px;
}
</style>

<body style="background-color:lavender;">
<%@include file="header.jsp" %>
<%@include file="nav.jsp" %>

<div id="content">
	<h1 style="font-size:200%; color:#330066; text-align:center;">Home Page</h1><br>
  <div id="left">
  
  	<p style="font-size:130%; color:#330066;"> New Announcements: </p>
  	<a href="announcements.jsp"> more </a><hr>
  	<p style="font-size:130%; color:#330066;"> Popular Quizzes: </p>
  	<a href="topQuizzes.jsp"> more </a><hr>
  	<p style="font-size:130%; color:#330066;"> Recently Created Quizzes: </p>
  	<a href="lastCreatedQuizzes.jsp"> more </a><hr>
  	<p style="font-size:130%; color:#330066;"> Recently Taken Quizzes: </p>
  	<a href="lastTakenQuizzes.jsp"> more </a><hr>
  	<p style="font-size:130%; color:#330066;"> Your Created Quizzes: </p>
  	<a href="UserCreatedQuizzes.jsp"> more </a><hr>
  	<p style="font-size:130%; color:#330066;"> Friends' Activities: </p>
  	<a href="friendsActivities.jsp"> more </a><hr>
  </div>
  <div id="right">
  
  	<%@ include file="search.jsp"%><hr>
  	
  	<p style="font-size:130%; color:#330066;"> Your Achievements: </p>
  	<a href="yourAchievements.jsp"> more </a><hr>
  	<p style="font-size:130%; color:#330066;"> Friend Requests: </p>
  	<a href="UserRequests.jsp"> more </a><hr>
  	<p style="font-size:130%; color:#330066;"> New Challenges: </p>
  	<a href="challenges.jsp"> more </a><hr>
  	<p style="font-size:130%; color:#330066;"> New Messages: </p>
  	<a href="messages.jsp"> more </a><hr>
  </div>
</div>

</body>
</html>