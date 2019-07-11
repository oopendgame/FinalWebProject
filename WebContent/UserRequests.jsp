<%@ page import="WebPackage.user.userInfo"%>
<%@ page import="WebPackage.database.DBInfo"%>
<%@ page import="WebPackage.requests.requestInfo"%>
<%@ page import="WebPackage.login.LogInInfo"%>
<%@ page import="WebPackage.requests.findRequestInfo"%>
<%@ page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<%@ include file="search.jsp"%>
<head>
<meta charset="UTF-8">

<title>Request List</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
</head>
<body  style="background-color:lavender;">
<br><br><br>

<%
	findRequestInfo req = new findRequestInfo();
	LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
	int id = log.getId();
	ArrayList<requestInfo> arr = req.getUserRequests(id);
	if(arr.size() == 0) out.println("No requests");
	else {
%>
		<p> <center>YOUR REQUESTS</center></p>
<%
		for(int i = 0; i < arr.size(); i++) {
			requestInfo cur = arr.get(i);
%>		
		 <i class='fas fa-user-friends' style='font-size:24px'> </i>
		 <% out.println(cur.getUserName() + " sent you friend request"); %> 
		
					<form name = "acceptForm" action = "acceptRequestServlet" method="get">
					<input type = "hidden" id = "friends_id" name = "friends_id"
						   value = "<%= cur.getRequestId() %>">
					<input type = "hidden" id = "user1_id" name = "user1_id"
						   value = "<%= cur.getSenderID() %>">
					<input type = "hidden" id = "user2_id" name = "user2_id"
						   value = "<%= cur.getReceiverID() %>">
					<input type = "submit" value = "accept">
					</form>
	
					<form name = "rejectForm" action = "rejectRequestServlet" method="get">
					<input type = "hidden" id = "friends_id" name = "friends_id"
						   value = "<%= cur.getRequestId() %>">
					<input type = "hidden" id = "user1_id" name = "user1_id"
						   value = "<%= cur.getSenderID() %>">
					<input type = "hidden" id = "user2_id" name = "user2_id"
						   value = "<%= cur.getReceiverID() %>">
					<input type = "submit" value = "reject">
					</form>
			<% } } %>


  
<body>
</body>
</body>


</html>