<%@page import="WebPackage.homepage.homepageInfo"%>
<%@page import="WebPackage.homepage.Activity"%>
<%@page import="com.sun.prism.Image"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="WebPackage.user.userInfo"%>
<%@page import="WebPackage.database.DBInfo"%>
<%@page import="WebPackage.requests.requestInfo"%>
<%@page import="WebPackage.login.LogInInfo"%>
<%@page import="WebPackage.requests.findRequestInfo"%>
<%@page import="java.util.ArrayList"%>
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
<%
	findRequestInfo requ = new findRequestInfo();
	LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
	int curr_id = log.getId();
	ArrayList<requestInfo> array = requ.getUserFriends(curr_id);
	homepageInfo home = new homepageInfo();
	if(array.size() == 0) {
		%>
		<h3 style="font-size:100%; color:#330066; text-align:center;">No Friends</h3>
		<%
	}else { 
%>
	<div style = "text-align:center">
<%
		findUserInfo uinfo = new findUserInfo();
		ArrayList<Activity> acts = home.getFriendsActivities(curr_id);
		
		if(acts.size() == 0) {
			%>
			<h3 style="font-size:100%; color:#330066; text-align:center;">No Activities</h3>
			<%
		}else{
			for(int i = 0; i < acts.size(); i++) {
				
				Activity act = acts.get(i);
				
				int friend_id = act.getUserId();
				String activity = act.getActivity();
				String actId = act.getActId();
				Date date = act.getDate();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				userInfo friend = uinfo.getMyUser(friend_id);
				String user = friend.getUserName();
				String img = friend.getImg();
				
				String result = "";
				
				if(activity.contentEquals("creation")) {
					
					result = " created "; 
			
				}else if(activity.contentEquals("achiev")) {
				
					result = " got achievement: " + actId;
					
				}else {
				
					result = " took ";
			
				}
				
				
				%>
				
				<img src=<%=img%> alt="Avatar" style="width:5%; margin-left: 1%; border-radius: 50%; margin-left:auto;
				 margin-right:auto; display:block;">
				 
				
				<form action="searchUserServlet" method="post">
					<input type = "hidden" name = "user_name" value = "<%=user%>">
					<p style="font-size: 120%; display:inline-block"><%=(dateFormat.format(date) + "   ")%></p>
					<input type = "submit" style="background-color: lavender; font-size: 120%; display:inline-block;
					 border: none; color:#0000EE; cursor:pointer; text-decoration: underline;" value="<%=user%>">
					 <p style="font-size: 120%; display:inline-block"><%=result %></p>
				</form>
				<%
				if(!activity.equals("achiev")){%>
				<form action="QuizPageServlet" method="get">
					<input type = "hidden" name = "quiz_id" value = "<%=Integer.parseInt(actId)%>">
					<input type = "submit" style="background-color: lavender; font-size: 120%; display:inline-block;
					 border: none; color:#0000EE; cursor:pointer; text-decoration: underline;" value="Quiz">
				</form>
				<%} %>
				<br><br><hr>
			<% } }  }%>

</div>

</body>
</html>