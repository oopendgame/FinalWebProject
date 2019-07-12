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
	
	
	input[type=bla] {
		  width: 50%;
		  padding: 12px 15px;
		  margin: 8px 0;
		  display: inline-block;
		  border-radius: 4px;
		  box-sizing: border-box;
		}

		input[type=Crsubmit] {
		  width: 50%;
		  background-color: indigo;
		  color: white;
		  padding: 14px 20px;
		  margin: 8px 0;
		  border: none;
		  border-radius: 4px;
		  cursor: pointer;
		  font-size: 16px;
		  text-align: center;
		}
		
		input[type=Crsubmit]:hover {
		  background-color: #38045B;
		}
	
</style>
		
<meta charset="UTF-8">
<title>Create New Quiz</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>


<body  style="background-color:lavender; 
							padding-top: 50px; padding-right: 80px; 
							padding-bottom: 50px; padding-left: 80px;">

<div class="content">
<h1> <i><font color="blue"> Create New Quiz </font></i></h1>

<form action="CreateQuizServlet" method="post"> 
  Quiz Name: <input type="text" name="quiz_name"> <br>
  
  <div class="gap-10"></div>
  Description: <textarea name="description" rows="3" cols="50" placeholder="Enter Text Here" required 
  							style="overflow-y:scroll"> </textarea> <br>  
  <div class="gap-10"></div>
  
  Category: 
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
  <input type="checkbox" name="pract" value="true"> 
  Practice Mode Option
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