<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="WebPackage.chat.findMessageInfo"%>
<%@ page import="WebPackage.user.findUserInfo"%>
<%@ page import="WebPackage.user.userInfo"%>
<%@ page import="WebPackage.database.DBInfo" import="WebPackage.chat.messageInfo"%>
<%@ page import="WebPackage.login.LogInInfo" import="java.util.ArrayList" %>

 <% findMessageInfo info = new findMessageInfo();
 	findUserInfo fuserInfo = new findUserInfo();
    LogInInfo fcurrInfo = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
    userInfo currUser =  fuserInfo.getMyUser(fcurrInfo.getUserName());
    ArrayList<messageInfo> latestMessageInfo = info.getMessageByUsers(currUser.getUserName());
    %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0 auto;
  max-width: 800px;
  padding: 0 20px;
}

.container {
  border: 2px solid #dedede;
  background-color: #f1f1f1;
  border-radius: 5px;
  padding: 10px;
  margin: 10px 0;
}

.darker {
  border-color: #ccc;
  background-color: #ddd;
}

.container::after {
  content: "";
  clear: both;
  display: table;
}

.container img {
  float: left;
  max-width: 60px;
  width: 60px;
  height: 60px;
  margin-right: 20px;
  border-radius: 50%;
}

.container img.right {
  float: right;
  margin-left: 20px;
  margin-right:0;
}

.time-right {
  float: right;
  color: #aaa;
}

.time-left {
  float: left;
  color: #999;
}
	
.oleo {
  font:'Berkshire Swash', Helvetica, sans-serif;
  color:blue;
  text-shadow: 1px 1px 0px #ededed, 4px 4px 0px rgba(0,0,0,0.15);
}

</style>
</head>
<title>Your Messages</title>
<body  style="background-color:lavender;">

<center><h2> Messages </h2> </center>
<p id="demo"></p>
<div class="messagesDisp">
	<%
		for (int i = 0; i < latestMessageInfo.size(); i++) {
			String sms = latestMessageInfo.get(i).getSms();
			String time = latestMessageInfo.get(i).getTime();
			String img = "";
			String whoTexted = "";
			String user = "";
			userInfo getter = fuserInfo.getMyUser(latestMessageInfo.get(i).getUser2Id());
			userInfo sender = fuserInfo.getMyUser(latestMessageInfo.get(i).getUser1Id());
			if(sender.getUserName().equals(currUser.getUserName())){
				whoTexted = "You: ";
				user = getter.getUserName();
				img = getter.getImg();
			}else{
				img = sender.getImg();
				user = sender.getUserName();
				whoTexted = sender.getUserName() + ": ";
			}
			
			
	%>
	<p class = "oleo" ><% out.println(user); %> </p>
	<div class="container">
  <img src=<%=img%> alt="Avatar" style="width:100%;">
  <p class = "oleo"><% out.println(whoTexted); %> </p>
  <p>  <% out.println(sms); %> </p>
  
  <span class="time-right"><%=time%></span>
</div>
	<%
		}
		if(latestMessageInfo.size() == 0){
	%>
	<p>
		 <% out.println("MailBox empty"); %>
		 &nbsp;&nbsp;&nbsp;&nbsp;
	</p>
	<%
		}
	%>


</body>
</html>
