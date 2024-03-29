<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="WebPackage.challenge.currQuizInfo"%>
<%@ page import="WebPackage.challenge.findChallenges"%>
<%@ page import="WebPackage.user.findUserInfo"%>
<%@ page import="WebPackage.user.userInfo"%>
<%@ page import="WebPackage.database.DBInfo" import="WebPackage.challenge.challengeInfo"%>
<%@ page import="WebPackage.login.LogInInfo" import="java.util.ArrayList" %>

<% findChallenges info = new findChallenges();
 	
	findUserInfo fuserInfo = new findUserInfo();
    LogInInfo fcurrInfo = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
    userInfo currUser =  fuserInfo.getMyUser(fcurrInfo.getUserName());
    ArrayList<challengeInfo> challInfo = info.getChallenges(currUser.getUserName());
    int countOld = info.OldChallengesNum(currUser.getUserName());
  
    info.updateChallengeInfo(currUser.getUserName());%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Challenges</title>
</head>
<body  style="background-color:lavender;">
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<br>

<h1 style="font-size:200%; color:#330066; text-align:center;">Challenges</h1>
<p id="demo"></p>
<%
if(challInfo.size() == 0){
	%>
	<h3 style="font-size:100%; color:#330066; text-align:center;">No Challenges</h3>
	<%
} else{
		if(challInfo.size()-countOld != 0){
		%>
		<h2 style="font-size:160%; color:red; text-align:center;">New</h2>
		<%
		}
	
		for (int i = 0; i < challInfo.size()-countOld; i++) {
	
			challengeInfo  cInf = challInfo.get(i);
			userInfo sender = fuserInfo.getMyUser(cInf.getUser1Id());
			String img = sender.getImg();
			String whoSent = sender.getUserName();
			int senderid = sender.getId();
			String link = cInf.getLink();
			Date date = cInf.getDate();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	%>
	
	<div>
	<br>
 		<img src=<%=img%> alt="Avatar" style="width:5%; margin-left: 1%; border-radius: 50%;">
				 
 		<form action="searchUserServlet" method="post">
			
				<input type = "hidden" name = "user_name" value = "<%=whoSent%>">
				
				<h3 style="font-size:120%; color:#330066;margin-left: 1%; display:inline-block;">
				<%=dateFormat.format(date)%></h3>
				
				<input type = "submit" style="background-color: lavender; font-size: 120%; display:inline-block;
				border: none; color:#0000EE; cursor:pointer; text-decoration: underline;" value="<%=" "+whoSent%>">
				<h3 style="font-size:120%; color:#330066;margin-left: 1%; display:inline-block;">sent you a</h3>
					
		</form>
		
		<form action="QuizPageServlet" method="get">
		
			<input type = "hidden" name = "quiz_id" value = "<%=link%>">
		
			<input type = "submit" style="background-color: lavender; font-size: 120%; display:inline-block;
			 border: none; color:#0000EE; cursor:pointer; text-decoration: underline;" value="Challenge">
		</form>
		
		<% 
			findChallenges fchal = new findChallenges();
			int score = fchal.usersBestScore(senderid, Integer.parseInt(link));
			System.out.println(senderid);
			System.out.println(link);
			System.out.println(score);
			if(score == -1) {
		%>
		<h3 style="font-size:120%; color:#330066;margin-left: 1%; display:inline-block;"><%=whoSent%> never wrote that quiz</h3>
		<%}else{ %>
		<h3 style="font-size:120%; color:#330066;margin-left: 1%; display:inline-block;"><%=whoSent+"\'s"%> 
		highest score is  <%=" " + score %></h3>
		<%} %>
	</div>
	<hr>
	<% 
		 }

		if(countOld != 0){
			%>
			<h4 style="font-size:160%; color:black; text-align:center;">Older Challenges</h4>
		<%
		}
		for (int i = 0; i < countOld; i++) {
			challengeInfo  cInf = challInfo.get(i);
			userInfo sender = fuserInfo.getMyUser(cInf.getUser1Id());
			String img = sender.getImg();
			String whoSent = sender.getUserName();
			int senderid = sender.getId();
			String link = cInf.getLink();
			Date date = cInf.getDate();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	%>
	
	<div>
	<br>
 		<img src=<%=img%> alt="Avatar" style="width:5%; margin-left: 1%; border-radius: 50%;">
				 
 		<form action="searchUserServlet" method="post">
			
				<input type = "hidden" name = "user_name" value = "<%=whoSent%>">
				
				<h3 style="font-size:120%; color:#330066;margin-left: 1%; display:inline-block;">
				<%=dateFormat.format(date)%></h3>
				
				<input type = "submit" style="background-color: lavender; font-size: 120%; display:inline-block;
				border: none; color:#0000EE; cursor:pointer; text-decoration: underline;" value="<%=" "+whoSent%>">
				<h3 style="font-size:120%; color:#330066;margin-left: 1%; display:inline-block;">sent you a</h3>
					
		</form>
		
		<form action="QuizPageServlet" method="get">
		
			<input type = "hidden" name = "quiz_id" value = "<%=link%>">
		
			<input type = "submit" style="background-color: lavender; font-size: 120%; display:inline-block;
			 border: none; color:#0000EE; cursor:pointer; text-decoration: underline;" value="Challenge">
		</form>
		
		<% 
			findChallenges fchal = new findChallenges();
			int score = fchal.usersBestScore(senderid, Integer.parseInt(link));
			if(score == -1) {
		%>
		<h3 style="font-size:120%; color:#330066;margin-left: 1%; display:inline-block;"><%=whoSent%> never wrote that quiz</h3>
		<%}else{ %>
		<h3 style="font-size:120%; color:#330066;margin-left: 1%; display:inline-block;"><%=whoSent+"\'s"%> 
		highest score is  <%=" " + score %></h3>
		<%} %>
	</div>
	<hr>
	<%
		} } 
	%>
	

</body>
</html>