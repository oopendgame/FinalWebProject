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
    String chatterName = request.getParameter("user");
	ArrayList<messageInfo> allChat = info.getAllMessages(currUser.getUserName(), chatterName);
	int userId = -1;
    %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

</style>
</head>
<title><%=chatterName%> Chat</title>
<body  style="background-color:lavender;">
<br>
<center><h1> Your Chat With <br><%=chatterName%></h1> </center>
<p id="demo"></p>
<body onLoad="window.scroll(0, document.body.scrollHeight)">
	<%
	
		for (int i = allChat.size() - 1; i >= 0; i--) {
			messageInfo  msgInf = allChat.get(i);
			String sms = msgInf.getSms();
			String time = msgInf.getTime();
			String img = "";
			String whoTexted = "";
			String user = "";
			userInfo getter = fuserInfo.getMyUser(msgInf.getUser2Id());
			userInfo sender = fuserInfo.getMyUser(msgInf.getUser1Id());
			if(sender.getUserName().equals(currUser.getUserName())){
				whoTexted = "You: ";
				userId = getter.getId();
				user = getter.getUserName();
				img = getter.getImg();
	%>
	<p class = "oleo" align="right"><% out.println("You"); %> </p>
	<div class="container darker" align="right">
	  <img src=<%=sender.getImg()%> alt="Avatar" class="right" style="width:100%;">
	  <p>  <% out.println(sms); %> </p>	  
	  <span class="time-left"><%=time%></span>
	</div>
	<% 
			}else{
				userId = sender.getId();
				img = sender.getImg();
				user = sender.getUserName();
				whoTexted = sender.getUserName() + ": ";
			
			
			
	%>
  	<p class = "oleo"><% out.println(sender.getUserName()); %> </p>
	<div class="container">
		<img src=<%=sender.getImg()%> alt="Avatar"  style="width:100%;">
	  	 <p>  <% out.println(sms); %> </p>	  
	  	<span class="time-right"><%=time%></span>
	</div>
	<%
			}
		}
		if(allChat.size() == 0){
	%>
	<p>
		 <% out.println("MailBox empty"); %>
		
	</p>
	
	<%
		}
	%>
	<p>&nbsp;&nbsp;&nbsp;&nbsp; </p>
	
    <form name="readForm" action="chatServlet" method="POST">
		<input type="hidden" id="user" name="user" value="<%=userId%>"> 
		<div class="type_msg">
        <div class="input_msg_write">
           <input type="text" class="write_msg" name = "sms" id = "sms" placeholder="Type a message" />
           <button class="msg_send_btn" type="submit" ><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
        	<p id="demo"></p>
		
        </div>
    </div>
	</form>
     <p>&nbsp;&nbsp;&nbsp;&nbsp; </p>


</body>
</html>
