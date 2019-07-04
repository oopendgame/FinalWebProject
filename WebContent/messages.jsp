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
  width: 100%;
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

</style>
</head>
<body  style="background-color:lavender;">

<center><h2> Messages </h2> </center>
<p id="demo"></p>
<div class="messagesDisp">
	<%
		for (int i = 0; i < latestMessageInfo.size(); i++) {
			String sms = latestMessageInfo.get(i).getSms();
			String time = latestMessageInfo.get(i).getTime();
			String img = "";
			userInfo getter = fuserInfo.getMyUser(latestMessageInfo.get(i).getUser2Id());
			userInfo sender = fuserInfo.getMyUser(latestMessageInfo.get(i).getUser1Id());
			if(sender.getUserName() == currUser.getUserName()){
				img = getter.getImg();
			}else{
				img = sender.getImg();
			}
			
	%>
	<div class="container">
  <img src=<%=img%> alt="Avatar" style="width:100%;">
  <p>
		 <% out.println(sms); %>
		 &nbsp;&nbsp;&nbsp;&nbsp;
	</p>
  <span class="time-right"><%=time%></span>
</div>
<%
		}
	%>
<div class="container">
  <img src="https://ptetutorials.com/images/user-profile.png" alt="Avatar" style="width:100%;">
  <p>Hello. How are you today?</p>
  <span class="time-right">11:00</span>
</div>

<div class="container darker">
  <img src="https://cdn2.iconfinder.com/data/icons/person-gender-hairstyle-clothes-variations/48/Female-Side-comb-O-neck-512.png" alt="Avatar" class="right" style="width:100%;">
  <p>Hey! I'm fine. Thanks for asking!</p>
  <span class="time-left">11:01</span>
</div>

<div class="container">
  <img src="https://ptetutorials.com/images/user-profile.png" alt="Avatar" style="width:100%;">
  <p>Sweet! So, what do you wanna do today?</p>
  <span class="time-right">11:02</span>
</div>

<div class="container darker">
  <img src="https://cdn2.iconfinder.com/data/icons/person-gender-hairstyle-clothes-variations/48/Female-Side-comb-O-neck-512.png" alt="Avatar" class="right" style="width:100%;">
  <p>Nah, I dunno. Play soccer.. or learn more coding perhaps?</p>
  <span class="time-left">11:05</span>
</div>


</body>
</html>
