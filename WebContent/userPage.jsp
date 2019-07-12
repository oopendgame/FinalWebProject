<%@ page import="WebPackage.user.findUserInfo"%>
<%@ page import="WebPackage.user.userInfo"%>
<%@ page import="WebPackage.database.DBInfo" import="WebPackage.challenge.findChallenges"%>
<%@ page import="WebPackage.login.LogInInfo" import="WebPackage.chat.findMessageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    findMessageInfo infoMsg = new findMessageInfo();
    findUserInfo info = new findUserInfo();
    LogInInfo currInfo = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
    userInfo currUser =  info.getMyUser(currInfo.getUserName());
    int numMsg = infoMsg.getNumUnseenChats(currUser.getUserName());
    findChallenges chal = new findChallenges(); 
    int numChall = chal.numNewChallenges(currUser.getUserName());
    %>
    
    
<!DOCTYPE html>
<html>
<head>

<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<%@ include file="search.jsp"%>

<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' 
	integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' 
	crossorigin='anonymous'>

<title><%=currUser.getUserName()%></title>
</head>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}
/* Button used to open the contact form - fixed at the bottom of the page */
.open-button {
  background-color: #555;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  right: 9px;
  margin-bottom:10px;
  width: 300px;
}
/* The popup form - hidden by default */
.form-popup {
  display: none;
  right: 9px;
  border: 3px solid #f1f1f1;
  z-index: 9;
  width: 300px;
}
/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}
/* Full-width input fields */
.form-container input[type=text], .form-container input[type=url] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}
/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}
/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #116466;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}
/* Add a  background color to the cancel button */
.form-container .cancel {
  background-color: #e27d60;
}
/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}
.new_msg {
  font:'Berkshire Swash', Helvetica, sans-serif;
  color:red;
}
</style>
<style>
    a {
     text-decoration: none;
     font-size:30px
    }
    .info{
    	font size: "5";
    	left : 20px;
    }
    .infoDef{
    	style="font-size:25px; 
    	color: black; 
    	font-weight: bolder
    }
    infoUser{
    	style="font-size:25px; 
    	color: #116466; 
    	font-weight: bolder
    }
    
</style>

<body style="background-color:lavender; 
							padding-top: 50px; padding-right: 80px; 
							padding-bottom: 50px; padding-left: 80px;">


	<div style = "background-color:lightblue; padding-top: 50px; padding-right: 100px; 
							padding-bottom: 50px; padding-left: 100px;
							swidth:screen.width;border:2px solid #000;"> 
    <!-- photo frame -->
    <div class="title-photo">
      <div style="float:right;border:2px solid #B9B9B9;min-width:400px;
      			min-height:200px;padding:20px;position: relative;margin-bottom: 2em;">
      <div>
          <div style="min-height:200px;line-height:200px;text-align:center;">
  <img style="margin:auto;vertical-align:middle;display:inline; 
  				width:300px;height:300px; object-fit: cover;"
  src=<%=currUser.getImg()%> />
  			</div>
          <div class="smaller" style="text-align:center;margin-top: 1em;">
            <button class="open-button" onclick="openForm()">Change Photo</button>
            <center>
            <div class="form-popup" id="myForm">
              <form action="userPageServlet" class="form-container" method="POST">

                <label for="pho"><b>Photo URL</b></label>

                <input type="url" placeholder="Enter Photo URL" name="photoUrl" required>

                <button type="submit" class="btn" onclick="callServlet()">Submit</button>
                <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
              </form>
              
            </div>
            <script>
              
              function openForm() {
                document.getElementById("myForm").style.display = "block";
              }
              function closeForm() {
                document.getElementById("myForm").style.display = "none";
              }
              function callServlet() {
            	  document.location.action = "userPageServlet"; 
              }
            </script>
        </div>
      </div>
  </div>
    </div>
	<h2 style="font-size:28px; color: black">  <%=currUser.getUserName()%> </h2>
    <p style="font-size:25px; color: #1f2833; font-weight: bolder"> 
    		Full Name: <%=currUser.getName()%>  <%=currUser.getLastName()%><br><br>
    		Email: <%=currUser.getEmail()%><br><br>
   			Birthday: <%=currUser.getBirthday()%><br><br>
    		Gender: <%=currUser.getGender()%><br><br>
   			Rank : <%=currUser.getRank() %> <br><br>
   			Friend of <%=info.getNumFriends(currUser.getUserName())%> users
    </p> 
    </div>
    <div>
    <p><br><a href="changePass.jsp" style=a><i class='fas fa-exchange-alt' style='font-size:30px'>  Change Password </i></a></p>
    <p><a href="messages.jsp" style=a><i class='fas fa-envelope-open-text' style='font-size:30px'> 
    	Messages  <span  class = "new_msg"><%=numMsg%> New </span></i></a></p>
    <p><a href="challenges.jsp" style=a><i class='fas fa-gamepad' style='font-size:30px'> 
    	<span  class = "new_msg"><%=numChall%> New </span> Challenges </i></a></p>
    <p><a href="UserRequests.jsp" style=a><i class='fas fa-user-friends' style='font-size:30px'> 
    	<%=info.getNumFriendRequests(currUser.getUserName())%> Friend Requests</i></a></p>
    <p><a href="UserFriends.jsp" style=a><i class='fas fa-smile-beam' style='font-size:30px'> Your Friends </i></a></p>
    <p><a href="yourAchievements.jsp" style=a><i class='fas fa-trophy' style='font-size:30px'> Your Achievements</i></a></p>
    <p><a href="UserCreatedQuizzes.jsp" style=a><i class='fas fa-address-card' style='font-size:30px'> Your Created Quizzes</i></a></p>
    <p><a href="friendsActivities.jsp" style=a><i class='fas fa-running' style='font-size:30px'> Friends' Activities</i></a></p>
    <p><a href="CreateQuiz.jsp" style="text-decoration: none"><i class='fas fa-question-circle' style='font-size:30px'> Create Quiz</i></a></p>
    </div>
</body>
</html>