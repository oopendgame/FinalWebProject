<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="WebPackage.chat.findMessageInfo" import = "WebPackage.admin.announcements"%>
<%@ page import="WebPackage.user.findUserInfo"%>
<%@ page import="WebPackage.user.userInfo"%>
<%@ page import="WebPackage.database.DBInfo" import="WebPackage.chat.messageInfo"%>
<%@ page import="WebPackage.login.LogInInfo" import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Announcement</title>
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<%@ include file="search.jsp"%>
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
button {
     background:none;
     color:blue;
     border:none; 
     padding:0!important;
     font: inherit;
     border-bottom:1px solid #444; 
     cursor: pointer;
     
}
.sent_msg p {
  background: #05728f none repeat scroll 0 0;
  border-radius: 3px;
  font-size: 14px;
  margin: 0; color:#fff;
  padding: 5px 10px 5px 12px;
  width:100%;
}
.outgoing_msg{ overflow:hidden; margin:26px 0 26px;}
.sent_msg {
  float: right;
  width: 46%;
}
.input_msg_write input {
  background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
  border: medium none;
  color: #4c4c4c;
  font-size: 15px;
  min-height: 48px;
  width: 100%;
}

.type_msg {border-top: 1px solid #c4c4c4;position: relative;}
.msg_send_btn {
  background: #05728f none repeat scroll 0 0;
  border: medium none;
  border-radius: 50%;
  color: #fff;
  cursor: pointer;
  font-size: 17px;
  height: 33px;
  position: absolute;
  right: 0;
  top: 11px;
  width: 33px;
}
.messaging { padding: 0 0 50px 0;}
.form-textbox {
	height: 300px !important;
	width: 500px !important;
	font-size: 14px !important;
}

</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<% 
 	findMessageInfo info = new findMessageInfo();
 	findUserInfo fuserInfo = new findUserInfo();
 	
    LogInInfo fcurrInfo = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
    userInfo currUser =  fuserInfo.getMyUser(fcurrInfo.getUserName());
	int userId = -1;
	userInfo getter = null;
	userInfo sender;
	String user = "";
	//public messageInfo(int id, int user1Id, int user2Id, String sms, String condition, String time) {

    %>
<body  style="background-color:lavender;">
<br>
<center><h1> Make an Announcement </h1> </center>
    	
<div class="container" id="myForm"> 
	<form name="announcementForm" action="makeAnnouncementServlet" method="GET">
			<div class="type_msg">
		        <div class="input_msg_write"> 
				<input type="hidden" id="user" name="user" value="<%=currUser.getId()%>">
				<p> title </p>
				<textarea name = "title" id = "title" rows="2" cols="90" style="overflow-y:scroll"> </textarea> <br>  
				<p> announcement </p>
				<textarea name="announcement" id="announcement" rows="12" cols="90" style="overflow-y:scroll"> </textarea> <br> 
		        <button class="msg_send_btn" type="submit" ><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
		        <p id="demo"></p>
		        </div>
	    	</div>
	</form>
</div>
</body>
</html>