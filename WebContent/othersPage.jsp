<%@ page import="WebPackage.user.findUserInfo"%>
<%@ page import="WebPackage.requests.findRequestInfo"%> 
<%@ page import="WebPackage.user.userInfo"%>
<%@ page import="WebPackage.database.DBInfo"%>
<%@ page import="WebPackage.login.LogInInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% findUserInfo info = new findUserInfo();
    LogInInfo currInfo = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
    int id = currInfo.getSearchId();
    userInfo currUser =  info.getMyUser(id);%>
    
<!DOCTYPE html>
<html>
<head>
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
      			min-height:200px;padding:20px;position: relative; margin-bottom: 2em;">
      <div>
          <div style="min-height:200px;line-height:200px;text-align:center;">
  <img style="margin:auto;vertical-align:middle;display:inline; 
  				width:300px;height:300px; object-fit: cover;"
  src=<%=currUser.getImg()%> />
        </div>
        <div class="smaller" style="text-align:center;margin-top: 1em;">
        
        
        
        <% int user1_id = currInfo.getId(); 
           findRequestInfo req = new findRequestInfo();
           if(user1_id != id && !req.requestAlreadySent(user1_id, id)) {
         
        %> 
        <form name = "addFriend" action = "sendRequestServlet" method="get">
        	<input type="hidden" name="user2" value=""/>
            <input type="submit" name="Add Friend" value="Add Friend"/>
        </form>
        
        <% } %>
        
            
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
    <p><br><a href="messages.jsp" style=a><i class='fas fa-envelope-open-text' style='font-size:30px'> Send Message </i></a></p>
    <p><a href="challenges.jsp" style=a><i class='fas fa-gamepad' style='font-size:30px'> Send Challenge </i></a></p>
    <p><a href="yourAchievements.jsp" style=a><i class='fas fa-trophy' style='font-size:30px'> Achievements</i></a></p>
    <p><a href="UserCreatedQuizzes.jsp" style=a><i class='fas fa-address-card' style='font-size:30px'> Created Quizzes</i></a></p>
    </div>
</body>
</html>