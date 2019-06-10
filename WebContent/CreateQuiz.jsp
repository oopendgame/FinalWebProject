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
	
</style>
		
<meta charset="UTF-8">
<title>Create New Quiz</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body  bgcolor="#0AF8D2">
<div class="content">
<h1> <i><font color="blue"> Create New Quiz </font></i></h1>

<form action="QuizServlet" method="post">  <!--need to create QuizServlet   -->
  Quiz Name: <input type="text" name="quiz_name"> <br>
  
  <div class="gap-10"></div>
  Description: <input type="text" name="description"> <br>
  
  <div class="gap-10"></div>
  Subject: 
  <select name="subject">
    <option value="history">History</option>
    <option value="geography">Geography</option>
    <option value="math" selected>Math</option>
    <option value="biology">Biology</option>
    <option value="english">English</option>
    <option value="art">Art</option>
    <option value="georgian">Georgian</option>
    <option value="chemistry">Chemistry</option>
    <option value="physics">Physics</option>
    <option value="other">Other</option>
  </select>
  <br>
  
  <div class="gap-10"></div>
  Randomize questions:
  <input type="checkbox" name="check1" value="rand"><br>
  
  <div class="gap-10"></div>
  One page<input type="radio" name="rad" value="one"> 
  Multiple Pages <input type="radio" name="rad" value="mult"><br>
  
  <div class="gap-10"></div>
  Immediate Correction:
  <input type="checkbox" name="check2" value="corr"><br>
  
  <div class="gap-10"></div>
  Practice Mode Option:
  <input type="checkbox" name="check3" value="practice"><br>
  
  <div class="gap-10"></div>
  <i style="font-size:24px" class="fa">&#xf059;</i>
  <a href="questions" style="text-decoration: none">Add Questions</a>
  
  <div class="gap-10"></div>
  <div class="gap-10"></div>
  <button class="button"><i class="fa fa-plus"></i>  Add Quiz</button>
  
</form>

</div>
</body>
</html>