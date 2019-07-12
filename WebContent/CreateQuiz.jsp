<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="createQuestionsFunc.jsp"%> 
    
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<%@ include file="search.jsp"%>
    
<!DOCTYPE html>
<html>

<head>

<style>		
		<%@ include file="Style.css"%>
	
</style>
		
<meta charset="UTF-8">
<title>Create New Quiz</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>


<body  style="background-color:lavender; 
							padding-top: 50px; padding-right: 80px; 
							padding-bottom: 50px; padding-left: 80px;">

<div class="content">
<h3 style="font-size:200%; color:#330066; text-align:center;">Create New Quiz</h3>

<form action="CreateQuizServlet" method="post"> 
<input type="text" name="quiz_name" placeholder= "Quiz Name"> <br>
  
  <div class="gap-10"></div>
  <textarea rows="4" cols="50" placeholder="Enter Description here..." name="description"></textarea> <br>  
  <div class="gap-10"></div>
  
  Choose Category:
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
  One page<input type="radio" name="pageNum" value="one"> 
  Multiple Pages <input type="radio" name="pageNum" value="mult"><br>  
  
  <div class="gap-10"></div>
  <input type="checkbox" name="rand" value="true">
  Randomize questions
  <br>
  
  <div class="gap-10"></div>
  <input type="checkbox" name="corr" value="imm">
  Immediate Correction
  <br>
  
  
  <div class="gap-10"></div>
  <div class="gap-10"></div>
  <div class="gap-10"></div>
  

<%@ include file="CreateQuestions.jsp"%>
  
  <div class="gap-10"></div>
  <div class="gap-10"></div>
  <input type="submit" name="Add Quiz" value="Add Quiz"/>

</form>

 </div> 
 
</body>
</html>