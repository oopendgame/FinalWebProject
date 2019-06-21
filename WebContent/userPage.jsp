<%@ page import="WebPackage.user.findUserInfo"%>
<%@ page import="WebPackage.user.userInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% findUserInfo info = new findUserInfo();
    userInfo currUser =  info.getMyUser(request.getParameter("userName"));%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' 
	integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' 
	crossorigin='anonymous'>

<title>userPage</title>
</head>
<style>
    a {
     text-decoration: none;
     font-size:30px
    }
    
</style>
<body
	
	style="background-color:lavender;">
	<div style = "width:screen.width;border:1px solid #000;"> 
    <!-- photo frame -->
    <div class="title-photo">
      <div style="float:right;border:1px solid #B9B9B9;width:300px;min-height:150px;padding:12.5px;position: relative;margin-bottom: 2em;">
      <div>
          <div style="min-height:200px;line-height:200px;text-align:center;">
  <img style="margin:auto;vertical-align:middle;display:inline; width:300px;height:200px;"src='https://picsum.photos/id/1025/4951/3301'/>        </div>
          <div class="smaller" style="text-align:center;margin-top: 1em;">
              <a id="change-title-photo" href="changePhoto.html">Change photo</a>
          </div>
      </div>
  </div>
  
    
    </div>
	<h2>  <%=currUser.getUserName()%> </h2>
    <font size="5"> <p>  Full Name: <%=currUser.getName()%>   <%=currUser.getLastName()%></p> 
    				Email: <%=currUser.getEmail()%>
    				<p> Birthday: <%=currUser.getBirthday()%></p> Gender: <%=currUser.getGender()%>
    				<p> Rank : <%=currUser.getRank() %> </font>
    <!-- <p><a href="editInfo.html">edit info</a> </p> -->
    </div>
    <p><a href="messages.jsp" style= a><i class='fas fa-envelope-open-text'> Messages </i></a></p>
    <p><a href="challenges.jsp" style=a><i class='fas fa-gamepad'>  Challenges </i></a></p>
    <p><a href="friendRequests.jsp" style=a><i class='fas fa-user-friends' > Friend Requests</i></a></p>
    <p><a href="yourFriends.jsp" style=a><i class='fas fa-smile-beam'> Your Friends</i></a></p>
    <p><a href="yourAchievements.jsp" style=a><i class='fas fa-trophy' > Your Achievements</i></a></p>
    <p><a href="yourCreatedQuizzes.jsp" style=a><i class='fas fa-address-card' style='font-size:30px'> Your Created Quizzes</i></a></p>
    <p><a href="friendsActivities.jsp" style=a><i class='fas fa-running' style='font-size:30px'> Friends' Activities</i></a></p>
    <p><a href="CreateQuiz.jsp" style="text-decoration: none"><i class='fas fa-question-circle' style='font-size:30px'> Create Quiz</i></a></p>
    
</body>
</html>