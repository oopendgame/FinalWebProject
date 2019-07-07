<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="WebPackage.challenge.findChallenges"%>
<%@ page import="WebPackage.user.findUserInfo"%>
<%@ page import="WebPackage.user.userInfo"%>
<%@ page import="WebPackage.database.DBInfo" import="WebPackage.challenge.challengeInfo"%>
<%@ page import="WebPackage.login.LogInInfo" import="java.util.ArrayList" %>

<% findChallenges info = new findChallenges();
 	findUserInfo fuserInfo = new findUserInfo();
    LogInInfo fcurrInfo = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
    userInfo currUser =  fuserInfo.getMyUser(fcurrInfo.getUserName());
    ArrayList<challengeInfo> challInfo = info.getChallenges(currUser.getUserName());%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Challenges</title>
</head>
<body  style="background-color:lavender;">
<br>

<h1 style="font-size:200%; color:#330066; text-align:center;">Challenges</h1>
<p id="demo"></p>
	<%
		for (int i = 0; i < challInfo.size(); i++) {
			challengeInfo  cInf = challInfo.get(i);
			String link = cInf.getLink();
			userInfo sender = fuserInfo.getMyUser(cInf.getUser1Id());
			String img = sender.getImg();
			String user = sender.getUserName();
			String whoTexted = sender.getUserName() + ": ";
					
	%>
	
	<div id="myForm">
 		<img src=<%=img%> alt="Avatar" style="width:5%;">
  		<% out.println(whoTexted); %>
  		<a href=link>New Challenge</a>
	</div>
	<hr>
	
	<%
		}
		if(challInfo.size() == 0){
	%>
	<h3 style="font-size:100%; color:#330066; text-align:center;">No Challenges</h3>
	<%
		}
	%>

</body>
</html>