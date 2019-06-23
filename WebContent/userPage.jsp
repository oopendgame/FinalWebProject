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
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
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
    
</style>
<body
	
	style="background-color:lavender;">
	<div style = "width:screen.width;border:1px solid #000;"> 
    <!-- photo frame -->
    <div class="title-photo">
      <div style="float:right;border:1px solid #B9B9B9;width:300px;min-height:150px;padding:12.5px;position: relative;margin-bottom: 2em;">
      <div>
          <div style="min-height:200px;line-height:200px;text-align:center;">
  <img style="margin:auto;vertical-align:middle;display:inline; width:300px;height:200px;"src=<%=currUser.getImg()%>/>        </div>
          <div class="smaller" style="text-align:center;margin-top: 1em;">
            <button class="open-button" onclick="openForm()">Change Photo</button>
            <div class="form-popup" id="myForm">
              <form action="userPageServlet" class="form-container">

                <label for="pho"><b>Photo URL</b><p></label>

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
                  document.forms[0].action = "userPageServlet";
                  document.forms[0].submit();
              }
            </script>
        </div>
      </div>
  </div>
    </div>
	<h2>  <%=currUser.getUserName()%> </h2>
    <font size="5"; left = 20px> <p>  Full Name: <%=currUser.getName()%>   <%=currUser.getLastName()%></p> 
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
    <p><a href="./Quiz/CreateQuiz.jsp" style="text-decoration: none"><i class='fas fa-question-circle' style='font-size:30px'> Create Quiz</i></a></p>
    
</body>
</html>