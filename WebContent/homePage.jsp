<%@page import="WebPackage.user.userInfo" import = "WebPackage.user.findAchievementInfo"%>
<%@page import="WebPackage.database.DBInfo" import = "WebPackage.admin.adminInfo"%>
<%@page import="WebPackage.login.LogInInfo"%>
<%@page import="WebPackage.user.findUserInfo"%>
<%@page import="WebPackage.requests.findRequestInfo" import="java.util.ArrayList"%> 
<%@page import="WebPackage.challenge.findChallenges"%>
<%@page import="WebPackage.requests.requestInfo"%>
<%@page import="WebPackage.challenge.challengeInfo"%>
<%@page import="WebPackage.chat.messageInfo"%>
<%@page import="WebPackage.chat.findMessageInfo"%>
<%@page import="WebPackage.homepage.announcement"%> 
<%@page import="WebPackage.homepage.homepageInfo"%>
<%@page import="java.util.Date"%>
<%@page import="WebPackage.quiz.QuizInfo"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

    
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
    
<% 	homepageInfo hpage = new homepageInfo();
    ArrayList<announcement> annarr = hpage.getAnnouncements();
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
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>

<div id="content">

	<h1 style="font-size:200%; color:#330066; text-align:center;">Home Page</h1><br>
  <div id="left">
  
  
  
  	<p style="font-size:130%; color:#330066;"> New Announcements: </p>
  	
  	<%
if(annarr.size() == 0){
	%>
	<h3 style="font-size:100%; color:#330066; text-align:center;">No Announcements</h3>
	<%
} else{
		
	int min = 3;
		if (annarr.size() < 3) min = annarr.size();
		for (int i = 0; i < min; i++) {
			
			announcement ann = annarr.get(i);
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
		 <h3 style="font-size:120%; color:#330066; text-align:center; margin-top:8%"><%=titel%></h3>
		<p style = "margin-left: 2%"><%=announc %></p>
		<p style="margin-left: 1%; float:right"><%=user%> <%=dateFormat.format(date)%></p> 
		<br><br><br>
	</div>
	
	<%} } %>
  	
  	<a href="announcements.jsp"> more </a><hr>
  	
  	
  	
  
  	<p style="font-size:130%; color:#330066;"> Popular Quizzes: </p>
  
  
		 <%
		 	ArrayList<QuizInfo> poparr = hpage.getQuizzesByPopularity();
		 	if(poparr.size() == 0) {%>
			<h3 style="font-size:100%; color:#330066; text-align:center;">No Announcements</h3>
			<%}else{
			 	int miiin = 3;
				if(poparr.size() < 3) miiin = poparr.size();
				for(int i = 0; i < miiin; i++) {
					QuizInfo cur = poparr.get(i);
					int quizid = cur.getQuizId(); 
					
			%>
				<h3 style = "margin-left: 40%;">
				<span style='font-size:20px;'>&#9673;</span>
		<%=cur.getQuizName()%>
		
		<form name = "startForm<%=i%>" action = "QuizPageServlet" method="get">
		<input type = "hidden" name = "quiz_id" value = "<%=quizid%>">
		<input type = "submit" value = "view quiz">
		</form>
			
		<form name = "challengeForm<%=i%>" action = "challengeServlet" method="get">
		<input type = "hidden" name = "quiz_id" value = "<%=quizid%>">
		<input type = "submit" value = "challenge friends">
		</form>
		
		</h3>		
		<% } }%>
  	
  	
  	<a href="popularQuizzes.jsp"> more </a><hr>
  	
  	
  	
  
  	<p style="font-size:130%; color:#330066;"> Recently Created Quizzes: </p>
  	
  	
  	
  	<% ArrayList<QuizInfo> narr = hpage.getQuizzesByDate();
	if(narr.size() == 0) {%>
		<h3 style="font-size:100%; color:#330066; text-align:center;">No Quizzes</h3>
	<%} 
	int nmi = 3;
	if(narr.size() < 3) nmi = narr.size();
	for(int i = 0; i < nmi; i++) {
	QuizInfo cur = narr.get(i);
	int nqid = cur.getQuizId(); 
	
		
	%>
	<h3 style = "margin-left: 40%;">
	<span style='font-size:20px;'>&#9673;</span>
	<%=cur.getQuizName()%>
	
	<form name = "startForm<%=i%>" action = "QuizPageServlet" method="get">
	<input type = "hidden" name = "quiz_id" value = "<%=nqid%>">
	<input type = "submit" value = "view quiz">
	</form>
		
	<form name = "challengeForm<%=i%>" action = "challengeServlet" method="get">
	<input type = "hidden" name = "quiz_id" value = "<%=nqid%>">
	<input type = "submit" value = "challenge friends">
	</form>
	
	</h3>		
<% } %>
  	
  
  	<a href="newestQuizzes.jsp"> more </a><hr>
  
  	<p style="font-size:130%; color:#330066;"> Recently Taken Quizzes: </p>
  	
  	
  	<%
	int usid = currInfo.getId();
	ArrayList<QuizInfo> tarr = hpage.getTakenQuizzes(usid);
	
	if(tarr.size() == 0) {%>
		<h3 style="font-size:100%; color:#330066; text-align:center;">No Quizzes</h3>
	<%} 
	int tmin = 3;
	if(tmin > tarr.size()) tmin = tarr.size();
	for(int i = 0; i < tarr.size(); i++) {
	QuizInfo cur = tarr.get(i);
	int tqid = cur.getQuizId(); 
	
		
	%>
	<h3 style = "margin-left: 40%;">
	<span style='font-size:20px;'>&#9673;</span>
	<%=cur.getQuizName()%>
	
	<form name = "startForm<%=i%>" action = "QuizPageServlet" method="get">
	<input type = "hidden" name = "quiz_id" value = "<%=tqid%>">
	<input type = "submit" value = "view quiz">
	</form>
		
	<form name = "challengeForm<%=i%>" action = "challengeServlet" method="get">
	<input type = "hidden" name = "quiz_id" value = "<%=tqid%>">
	<input type = "submit" value = "challenge friends">
	</form>
	
	</h3>		
	<% } %>
  	
  	
  
  	<a href="myTakenQuizzes.jsp"> more </a><hr>
  
  	<p style="font-size:130%; color:#330066;"> Your Created Quizzes: </p>
  
  	
  	<% int myid = currInfo.getId();
	ArrayList<QuizInfo> myarr = hpage.getMyQuizzes(myid);
	if(myarr.size() == 0) {%>
		<h3 style="font-size:100%; color:#330066; text-align:center;">No quizzes</h3>
	<%} 
	int mym = 3;
	if(myarr.size() < 3) mym = myarr.size();
	for(int i = 0; i < mym; i++) {
	QuizInfo cur = myarr.get(i);
	int myqid = cur.getQuizId(); 
	
		
	%>
	<h3 style = "margin-left: 40%;">
	<span style='font-size:20px;'>&#9673;</span>
	<%=cur.getQuizName()%>
	
	<form name = "startForm<%=i%>" action = "QuizPageServlet" method="get">
	<input type = "hidden" name = "quiz_id" value = "<%=myqid%>">
	<input type = "submit" value = "view quiz">
	</form>
		
	<form name = "challengeForm<%=i%>" action = "challengeServlet" method="get">
	<input type = "hidden" name = "quiz_id" value = "<%=myqid%>">
	<input type = "submit" value = "challenge friends">
	</form>
	
	</h3>		
	<% } %>

  	
  	
  	<a href="quizzesByMe.jsp"> more </a><hr>
  
  	<p style="font-size:130%; color:#330066;"> Friends' Activities: </p>
  	
  	<%@include file="friendsActivities.jsp" %>
  
  	<a href="friendsActivities.jsp"> more </a><hr>
  
  </div>
  
  
  
  
  
  <div id="right">
  
  	<%@ include file="search.jsp"%><hr>
  	
  	
  	
  	<p style="font-size:130%; color:#330066;"> Your Achievements: </p>
	<% 	if(list.size() == 0) {
		%><p style="font-size:15px; text-align:center">No achievements yet</p>
	
	<% }else{

		int m = list.size();
			if(list.size() > 3) m = 3;
			for(int i = 0; i < m; i++){
			String str = list.get(i);%>
	    	<p style="font-size:15px; margin-left:10%">&#9679; <%=str%></p>
	<% }} %>

  	<a href="yourAchievements.jsp"> See all </a><hr>
  	
  	
  	
  	
  	<p style="font-size:130%; color:#330066;"> Friend Requests: </p>

  	<%if(arr.size() == 0){ %>
  		<p style="font-size:15px; text-align:center">No friend requests</p>

	<% }else { %>
		
		<h2 style="font-size:20px; color:red; text-align:center;"><%=arr.size()%> New</h2>
		<% int mini = 3;
		
		if(arr.size() < mini) mini = arr.size();
		
		for(int i = 0; i < mini; i++) {
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
		
		int mi = countNew;
		if(countNew > 3) mi = 3;
		
		for (int i = 0; i < mi; i++) {
			
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
  			
  			int minim = 3;
  			if(latestMessageInfo.size() < 3) minim = latestMessageInfo.size();
  			
		for (int i = 0; i < minim; i++) {
			
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