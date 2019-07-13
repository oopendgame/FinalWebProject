<%@ page import="WebPackage.user.userInfo" import = "WebPackage.user.findAchievementInfo"%>
<%@ page import="WebPackage.database.DBInfo" import = "WebPackage.admin.adminInfo"%>
<%@ page import="WebPackage.login.LogInInfo"%>
<%@ page import="WebPackage.user.findUserInfo"%>
<%@ page import="WebPackage.requests.findRequestInfo" import="java.util.ArrayList"%> 
<%@ page import="WebPackage.challenge.findChallenges"%>
<%@ page import="WebPackage.requests.requestInfo"%>
<%@ page import="WebPackage.challenge.challengeInfo"%>
<%@ page import="WebPackage.chat.messageInfo"%>
<%@ page import="WebPackage.chat.findMessageInfo"%>

    
    <% findUserInfo info = new findUserInfo();
    LogInInfo currInfo = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
    userInfo currUser =  info.getMyUser(currInfo.getUserName());
    findAchievementInfo achInfo = new findAchievementInfo();
    ArrayList<String> list = achInfo.getUserAchievements(currUser.getId()); %>
    
    <% findChallenges cInfo = new findChallenges();
    ArrayList<challengeInfo> challInfo = cInfo.getChallenges(currUser.getUserName());
    int countNew = cInfo.numNewChallenges(currUser.getUserName());
    
    findRequestInfo req = new findRequestInfo();
    int id = currInfo.getId();
	ArrayList<requestInfo> arr = req.getUserRequests(id);
	
	findMessageInfo infoMsg = new findMessageInfo();
    int numMsg = infoMsg.getNumUnseenChats(currUser.getUserName());
    ArrayList<messageInfo> latestMessageInfo = infoMsg.getMessageByUsers(currUser.getUserName());
    %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<style>
#content, html, body {
    height: 98%;
}
#left {
    float: left;
    width: 70%;
    height: 100%;
    overflow: scroll;
    padding: 5px;
}
#right {
    float: left;
    width: 30%;
    height: 100%;
    overflow: scroll;
    padding: 5px;
}
</style>

<body style="background-color:lavender;">
<%@include file="header.jsp" %>
<%@include file="nav.jsp" %>

<div id="content">
	<h1 style="font-size:200%; color:#330066; text-align:center;">Home Page</h1><br>
  <div id="left">
  
  	<p style="font-size:130%; color:#330066;"> New Announcements: </p>
  	<a href="announcements.jsp"> more </a><hr>
  	<p style="font-size:130%; color:#330066;"> Popular Quizzes: </p>
  	<a href="topQuizzes.jsp"> more </a><hr>
  	<p style="font-size:130%; color:#330066;"> Recently Created Quizzes: </p>
  	<a href="lastCreatedQuizzes.jsp"> more </a><hr>
  	<p style="font-size:130%; color:#330066;"> Recently Taken Quizzes: </p>
  	<a href="lastTakenQuizzes.jsp"> more </a><hr>
  	<p style="font-size:130%; color:#330066;"> Your Created Quizzes: </p>
  	<a href="UserCreatedQuizzes.jsp"> more </a><hr>
  	<p style="font-size:130%; color:#330066;"> Friends' Activities: </p>
  	<a href="friendsActivities.jsp"> more </a><hr>
  </div>
  
  <div id="right">
  
  	<%@ include file="search.jsp"%><hr>
  	
  	<p style="font-size:130%; color:#330066;"> Your Achievements: </p>
	<% 	if(list.size() == 0) {
		%><p style="font-size:15px; text-align:center">No achievements yet</p>
	<% }else{
			int min = list.size();
			if(list.size() > 3) min = 3;
			for(int i = 0; i < min; i++){
			String str = list.get(i);%>
	    	<p style="font-size:15px; margin-left:10%">&#9679; <%=str%></p>
	<% }} %>
  	<a href="yourAchievements.jsp"> See all </a><hr>
  	
  	<p style="font-size:130%; color:#330066;"> Friend Requests: </p>
  	<%if(arr.size() == 0){ %>
  		<p style="font-size:15px; text-align:center">No friend requests</p>
	<% }else { %>
		<h2 style="font-size:20px; color:red; text-align:center;"><%=arr.size()%> New</h2>
		<% int min = 3;
		if(arr.size() < min) min = arr.size();
		for(int i = 0; i < min; i++) {
			requestInfo cur = arr.get(i);
%>		<div>
		<i class='fas fa-user-friends' style="font-size:13px; margin-left:10%;"> </i>
		<p style="font-size:15px; margin-left:1%; display:inline-block;"><%=cur.getUserName() %> sent you friend request</p> 
		</div>
		<%} } %>

  	<a href="UserRequests.jsp"> See all </a><hr>
  	
  	<p style="font-size:130%; color:#330066;"> New Challenges: </p>
  	<% if(challInfo.size() == 0){%>
		<p style="font-size:15px; text-align:center;">No Challenges</p>
	<%
	} else{
		if(countNew != 0){
		%>
		<h2 style="font-size:20px; color:red; text-align:center;"><%=countNew%> New</h2>
		<%
		}else{%>
			<p style="font-size:15px; text-align:center">No new challenges</p>
		<%}
		int min = countNew;
		if(countNew > 3) min = 3;
		for (int i = 0; i < min; i++) {
			challengeInfo  cInf = challInfo.get(i);
			userInfo sender = info.getMyUser(cInf.getUser1Id());
			String img = sender.getImg();
			String whoSent = sender.getUserName();
			String link = cInf.getLink();
	%>
	
	<div>
 		<img src=<%=img%> alt="Avatar" style="width:10%; margin-left: 10%; display:inline-block;">
		 	<p style="font-size:15px; margin-left: 1%; display:inline-block;"> 
		 	<%= whoSent%> sent you a challenge</p>
	</div>
	<br>
	<% } }%>
  	<a href="challenges.jsp"> See all </a><hr>
  	
  	<p style="font-size:130%; color:#330066;"> New Messages: </p>
  		<% if(numMsg == 0){%>
  			<p style="font-size:15px; text-align:center">No new messages</p>
  		<%}else {%>
  			<h2 style="font-size:20px; color:red; text-align:center;"><%=numMsg%> New</h2>
  			<%
  			int min = 3;
  			if(latestMessageInfo.size() < 3) min = latestMessageInfo.size();
		for (int i = 0; i < min; i++) {
			messageInfo  msgInf = latestMessageInfo.get(i);
			userInfo getter = info.getMyUser(msgInf.getUser2Id());
			userInfo sender = info.getMyUser(msgInf.getUser1Id());
			if(msgInf.getCondition().equals("sent") && getter.getUserName().equals(currUser.getUserName())){ %>
			<div>
	 		<img src=<%=sender.getImg()%> alt="Avatar" style="width:10%; margin-left: 10%; display:inline-block;">
			 	<p style="font-size:15px; margin-left: 1%; display:inline-block;"> 
			 	<%=sender.getUserName()%> sent you a message</p>
			</div>
			<br>
			
  		<%} } } %>
  	<a href="messages.jsp"> See all </a><hr>
  </div>
</div>

</body>
</html>