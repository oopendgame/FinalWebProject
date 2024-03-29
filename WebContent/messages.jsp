<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="WebPackage.chat.findMessageInfo"%>
<%@ page import="WebPackage.user.findUserInfo"%>
<%@ page import="WebPackage.user.userInfo"%>
<%@ page import="WebPackage.database.DBInfo" import="WebPackage.chat.messageInfo"%>
<%@ page import="WebPackage.login.LogInInfo" import="java.util.ArrayList" %>
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<%@ include file="search.jsp"%>
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
body{
	background-color:lavender; 
	padding-top: 50px; 
	padding-right: 80px; 
	padding-bottom: 50px; 
	padding-left: 80px;
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
.new_msg {
  font:'Berkshire Swash', Helvetica, sans-serif;
  color:red;
}
button {
     background:none;
     color:blue;
     border:none; 
     padding:0!important;
     font: inherit;
     border-bottom:1px solid #444; 
     cursor: pointer;
     
}

</style>
</head>
<title>Your Messages</title>
<body  style="background-color:lavender;">
<br>
<center><h1> Messages </h1> </center>
<p id="demo"></p>
	<%
		for (int i = 0; i < latestMessageInfo.size(); i++) {
			messageInfo  msgInf = latestMessageInfo.get(i);
			String sms = msgInf.getSms();
			String time = msgInf.getTime();
			String img = "";
			String whoTexted = "";
			String user = "";
			String seen = "";
			int uId = -1;
			userInfo getter = fuserInfo.getMyUser(msgInf.getUser2Id());
			userInfo sender = fuserInfo.getMyUser(msgInf.getUser1Id());
			if(msgInf.getCondition().equals("sent")){
				seen = "NEW";
			}
			if(sender.getUserName().equals(currUser.getUserName())){
				whoTexted = "You: ";
				user = getter.getUserName();
				uId = getter.getId();
				img = getter.getImg();
				seen = "";
			}else{
				img = sender.getImg();
				uId = sender.getId();
				user = sender.getUserName();
				whoTexted = sender.getUserName() + ": ";
			}
			
			
	%>
<div style = " margin: 0 auto; max-width: 800px; padding: 0 20px;">
<form action = "searchUserServlet" method = "Post">
	<input type = "hidden" name = "user_name" value = <%=user%>>
	<input type = "submit" class = "oleo" value = "<%=user%>">
	<span  class = "new_msg"><% out.println(seen); %> </span>
</form>

<div class="container" id="myForm">
  		<img src=<%=img%> alt="Avatar" style="width:100%;">
  		<p class = "oleo" ><% out.println(whoTexted); %> </p>
  		<p>  <%= sms %> </p>
  
  	<span class="time-right"><%=time%></span>
	</div>
	<form name="readForm" action="chatServlet" method="GET">
	
		<input type="hidden" id="message" name="message" value="<%=msgInf.getSms()%>"> 
		<input type="hidden" id="user" name="user" value="<%=user%>"> 
		<input type="hidden" id="receiver" name="receiver" value="<%=getter.getUserName()%>">
		<input type="hidden" id="messageID" name="messageID" value="<%=msgInf.getId()%>">
		<div align="right">
			<input type="submit"  value=" see more ">
		</div>
	</form>
	<hr>
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
