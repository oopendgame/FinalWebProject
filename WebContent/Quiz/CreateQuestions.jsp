<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<style>
	.gap-10 {
		width:100%;
		height:10px; 
	}
	
	.content {
	  max-width: 500px;
	  margin: auto;
	}
	
	.button {   	  
	    width: 120px;
	    text-align: center;
	    margin:0 auto;
	    border-radius: 10px;
	    border: none;
	    padding: 10px 20px;
	    color: #31E436;
	    background-color: #313FE4;
	}
	
	a {
     text-decoration: none;
    }
	
</style>


<meta charset="UTF-8">
<title>Create New Questions</title>
</head>


<body  bgcolor="#0AF8D2">
<h1> <i><font color="blue"> Create New Questions </font></i></h1>


  
 <div class="gap-10"></div>
 Choose question type: <br>
 <div class="gap-10"></div>
 
 &#9658; <a href="QuestionResponse.jsp">Question-Response</a><br>
 &#9658; <a href="FillBlank.jsp">Fill in the Blank</a><br>
 &#9658; <a href="MultipleChoice.jsp">Multiple Choice</a><br>
 &#9658; <a href="PictureResponseQuestions.jsp">Picture-Response Questions</a><br>

 <div class="gap-10"></div>
 <a href="AllQuestions.jsp">View or Edit Already Created Questions</a><br>
  
</body>
</html>