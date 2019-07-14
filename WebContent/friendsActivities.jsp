<%@page import="com.sun.prism.Image"%>
<%@ page import="WebPackage.user.userInfo"%>
<%@ page import="WebPackage.database.DBInfo"%>
<%@ page import="WebPackage.requests.requestInfo"%>
<%@ page import="WebPackage.login.LogInInfo"%>
<%@ page import="WebPackage.requests.findRequestInfo"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="WebPackage.user.findUserInfo"%>
<%@page import = "WebPackage.admin.adminInfo"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Friends' Activities</title>
</head>

<body  style="background-color:lavender;">
<br>
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<h1 style="font-size:200%; color:#330066; text-align:center;">Friends Activities</h1><br>
<%
	findRequestInfo req = new findRequestInfo();
	LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
	int id = log.getId();
	ArrayList<requestInfo> arr = req.getUserFriends(id);
	if(arr.size() == 0) {
		%>
		<h3 style="font-size:100%; color:#330066; text-align:center;">No Friends</h3>
		<%
	}else { 
%>
	<div style = "text-align:center">
<%
		findUserInfo info = new findUserInfo();
		adminInfo ad = new adminInfo();
		
		for(int i = 0; i <arr.size(); i++) {
			
			log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
			requestInfo cur = arr.get(i);
			int friendid = cur.getReceiverID();
			userInfo adm = info.getMyUser(friendid);
			String user = adm.getUserName();
			log.setSearchId(friendid);
			System.out.println(log.getSearchId());
			
		 if(!log.getUserName().equals(user)) { %> 
			<a href = "othersPage.jsp" style="float:center; font-size:20px"><%=user%></a> 
			<% }else if(ad.isAdmin(user)) {%> 
			<a href = "adminPage.jsp" style="float:center; font-size:20px"><%=user%></a> 
			<% }else {%> 
			<a href = "userPage.jsp" style="float:center; font-size:20px"><%=user%></a> 
	
			<%} %>
			<br><br>
			
			<a href = "userAchievements.jsp" style="float:center; font-size:20px">Achievements</a> 
			<a href = "UserCreatedQuizzes.jsp" style="float:center; font-size:20px">Created quizzes</a> 
			<a href = "myTakenQuizzes.jsp" style="float:center; font-size:20px">Taken quizzes</a> 
			<br><br><hr>
			<% } } %>

</div>

</body>
</html>