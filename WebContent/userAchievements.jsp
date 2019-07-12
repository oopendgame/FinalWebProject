<%@ page import="WebPackage.user.findUserInfo"%>
<%@ page import="WebPackage.requests.findRequestInfo" import="java.util.ArrayList"%> 
<%@ page import="WebPackage.user.userInfo" import = "WebPackage.user.findAchievementInfo"%>
<%@ page import="WebPackage.database.DBInfo" import = "WebPackage.admin.adminInfo"%>
<%@ page import="WebPackage.login.LogInInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <% findUserInfo info = new findUserInfo();
    LogInInfo currInfo = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
    int id = currInfo.getSearchId();
    userInfo currUser =  info.getMyUser(id);
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
</head>
<body>
	<body  style="background-color:lavender;">
	<br><br><br>
	
	
	
	</body>
</body>
</html>