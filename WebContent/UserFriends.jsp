<%@ page import="WebPackage.user.userInfo"%>
<%@ page import="WebPackage.database.DBInfo"%>
<%@ page import="WebPackage.requests.requestInfo"%>
<%@ page import="WebPackage.login.LogInInfo"%>
<%@ page import="WebPackage.requests.findRequestInfo"%>
<%@ page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Friends List</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
</head>

<style>
div {
  padding-right: 30px;
  padding-left: 100px;
  font-size: 40;
}

</style>

<body  style="background-color:lavender;">
<br><br><br>

<%
	findRequestInfo req = new findRequestInfo();
	LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
	int id = log.getId();
	ArrayList<requestInfo> arr = req.getUserFriends(id);
	if(arr.size() == 0) out.println("<center><h1>You have no friends</h1></center>");
	else { 
%>

<div>
<%@ include file="search.jsp"%>
	<p> <center><h1>YOUR FRIENDS</h1></center></p>
	
<%
		for(int i = 0; i < arr.size(); i++) {
			requestInfo cur = arr.get(i);
%>		
		 <h3>
		 
		 <form action = "searchUserServlet" method = "Post">
		 <i class='fas fa-smile-wink' style='font-size:24px'></i>
			<input type = "hidden" name = "user_name" value = <%=cur.getUserName()%>>
			<input type = "submit" style="background-color: lavender; font-size: 120%; display:inline-block;
				border: none; color:#0000EE; cursor:pointer; text-decoration: underline;" value="<%=cur.getUserName()%>">
		</form>
		 <br>
		 </h3>
			<% } } %>

</div>
  
<body>
</body>
</body>


</html>