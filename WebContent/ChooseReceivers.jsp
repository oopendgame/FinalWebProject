<%@page import="WebPackage.challenge.currQuizInfo"%>
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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<style>
		
.friend{
  width: 100%;
  height: 40px;
  overflow-y: auto;
  border: none;
  text-align: center;
}

#submitButton {
  font-family: FontAwesome;
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
	

    <form action="challengeFriendServlet" method="post" style="text-align:center">
    	<h3 style="font-size:200%; color:#330066; text-align:center;"> Choose Friend To Send Challenge </h3>
	  	<div class="vertical-menu">
	  <%
			findRequestInfo req = new findRequestInfo();
			LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
			int id = log.getId();
			ArrayList<requestInfo> arr = req.getUserFriends(id);
			if(arr.isEmpty()) out.print("No Friends");
			else{
				currQuizInfo currQuiz = (currQuizInfo)request.getAttribute("currquiz");
				String quizid = currQuiz.getId();
				for(int i = 0; i < arr.size(); i++) {
					requestInfo cur = arr.get(i);
			%>		
					<input type = "hidden" name = "quiz_id" value = "<%=quizid%>">
					<input type="submit" value=<%=cur.getUserName()%> class = "friend" name = "friend"><br>
			<% } } %>
		</div>
	</form>
	


	<form action="QuizPageServlet" method="post">
		<%
		currQuizInfo currQuiz = (currQuizInfo)request.getAttribute("currquiz");
		String quizid = currQuiz.getId();
	%>
		<input type = "hidden" name = "quiz_id" value = "<%=quizid%>">
		<br>
		<input type = "submit" style="background-color: white; font-size: 17px; border: none; color:#330066; margin-left: 20%; cursor:pointer;"
			value="&#xf0a8 Return to quiz page" id="submitButton">
		</form>
</body>
</html>