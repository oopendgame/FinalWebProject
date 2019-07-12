<%@ page import="WebPackage.user.findUserInfo"%>
<%@ page import="WebPackage.requests.findRequestInfo" import="java.util.ArrayList"%> 
<%@ page import="WebPackage.user.userInfo" import = "WebPackage.user.findAchievementInfo"%>
<%@ page import="WebPackage.database.DBInfo" import = "WebPackage.admin.adminInfo"%>
<%@ page import="WebPackage.login.LogInInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <% findUserInfo info = new findUserInfo();
    LogInInfo currInfo = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
    userInfo currUser =  info.getMyUser(currInfo.getUserName());
    findAchievementInfo achInfo = new findAchievementInfo();
    ArrayList<String> list = achInfo.getUserAchievements(currUser.getId()); %>
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<%@ include file="search.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Achievements</title>
<center>
</head>
	<h2 style="font-size:28px; color: black">  <%=currUser.getUserName()%>'s Achievements </h2>
<body>
	<body  style="background-color:lavender;">
	<% for(int i = 0; i < list.size(); i++){
		String str = list.get(i);%>
    	<p style="font-size:20px; color: red; font-weight: bolder"><%=str%></p>
	<%} %>
	
	
	</body>
</body>
</html>