<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="WebPackage.requests.findRequestInfo"%>
<%@ page import="WebPackage.database.DBInfo"%>
<%@ page import="WebPackage.requests.requestInfo"%>
<%@ page import="WebPackage.login.LogInInfo"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Choose Receiver</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' 
	integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' 
	crossorigin='anonymous'>
<style>

.friend{
  width: 100%;
  height: 40px;
  overflow-y: auto;
  border: none;
  text-align: center;
}
.vertical-menu {
  width: 60%;
  height: 90%;
  overflow-y: auto;
  border-radius: 10px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

.friend:hover {
  background-color: #ccc;
}

.button {
  width: 30%;
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
.button:hover {
   background-color: #38045B;	
 
</style>
</head>
<body>
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
	
	
    <form action="challengeServlet" method="post" style="text-align:center">
    	<h3 style="font-size:200%; color:#330066; text-align:center;"> Choose Friend To Send Challenge </h3>
	  	<div class="vertical-menu">
	  <%
			findRequestInfo req = new findRequestInfo();
			LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
			int id = log.getId();
			ArrayList<requestInfo> arr = req.getUserFriends(id);
			for(int i = 0; i < arr.size(); i++) {
				requestInfo cur = arr.get(i);
		%>		
				<input type="submit" value=<%=cur.getUserName()%> class = "friend" name = "friend"><br>
		<% } %>
		</div>
	</form>
	<a href =""><i class="fa fa-caret-left" style='font-size:15px; color: #38045B; margin-left: 20%;'> Return to quiz page</i></a>
</body>
</html>