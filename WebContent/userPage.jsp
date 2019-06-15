<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' 
	integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' 
	crossorigin='anonymous'>

<title>Insert title here</title>
</head>
<style>
    a {
     text-decoration: none;
     font-size:30px
    }
    
</style>
<body
	
	style="background-color:beige;">
	<div style = "width:screen.width;border:1px solid #000;"> 
    <!-- photo frame -->
    
    <div style="float:right;border:1px solid #B9B9B9;width:280px;min-height:180px;height: 
    screen.height;padding:12.5px;position: relative;margin-bottom: 2em;">
        <!-- icon -->
        <div>
            <div style="min-height:180px;line-height:100px;text-align:center;">
            <i style='font-size:200px; margin:auto;vertical-align:middle;display:inline;' class='fas'>&#xf007;</i>   </div>
        </div>
        <div class="smaller" style="text-align:center;margin-top: 1em;">
            <a id="change-title-photo" href="changePhoto.html">Change photo</a>
        </div>
    </div>
	<h2> User Name</h2>
    <font size="6"> <p> Full name  </p> Email: <p> Birthday: </p> Gender: <br> </font>
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