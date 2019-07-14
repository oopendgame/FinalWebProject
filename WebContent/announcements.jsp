<%@page import="WebPackage.homepage.announcement"%>
<%@page import="WebPackage.homepage.homepageInfo"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="WebPackage.user.userInfo"%>
<%@ page import="WebPackage.user.findUserInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Announcements</title>

<% 	homepageInfo hpage = new homepageInfo();
    ArrayList<announcement> arr = hpage.getAnnouncements();
    findUserInfo info = new findUserInfo();
%>
    
</head>
<body  style="background-color:lavender;">
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<br>

<h1 style="font-size:200%; color:#330066; text-align:center;">Announcements</h1>
<br>
<p id="demo"></p>
<%
if(arr.size() == 0){
	%>
	<h3 style="font-size:100%; color:#330066; text-align:center;">No Announcements</h3>
	<%
} else{
		for (int i = 0; i < arr.size(); i++) {
			announcement ann = arr.get(i);
			int admin = ann.getAdmin();
			String announc = ann.getAnn();
			String titel = ann.getTitel();
			Date date = ann.getDate();
			hpage.userIdbyAdmin(admin);
			int userid = hpage.userIdbyAdmin(admin);
			userInfo adm = info.getMyUser(userid);
			String user = adm.getUserName();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	%>
	
	<div>
		 <h3 style="font-size:120%; color:#330066; text-align:center;"><%=titel%></h3>
		<p style = "margin-left: 2%"><%=announc %></p>
		<%
			LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
			log.setSearchId(userid);
			adminInfo ad = new adminInfo();
			if(!log.getUserName().equals(user)) { %> <a href = "othersPage.jsp" style="margin-left: 1%; float:right"><%=user%></a> 
			<% }else if(ad.isAdmin(user)) {%> <a href = "adminPage.jsp" style="margin-left: 1%; float:right"><%=user%></a> 
			<% }else {%> <a href = "userPage.jsp" style="margin-left: 1%; float:right"><%=user%></a> 
			<%} %>
	<p style="text-align:right"><%=dateFormat.format(date)%></p>
	</div>
	<hr>
	<%} } %>

</body>
</html>