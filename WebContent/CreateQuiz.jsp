<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="createQuestionsFunc.jsp"%> 
    
    
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

<form action="CreateQuizServlet" method="post"> 
  Quiz Name: <input type="text" name="quiz_name"> <br>
  
  <div class="gap-10"></div>
  Description: <textarea name="description" rows="3" cols="50" placeholder="Enter Text Here" required 
  							style="overflow-y:scroll"> </textarea> <br>  
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
  
<!--   <div class="gap-10"></div>
  <i style="font-size:24px" class="fa">&#xf059;</i>
  <a href="CreateQuestions.jsp" style="text-decoration: none">Add Questions</a> -->
  
  
  
  
  
  
  
  
  
  
  <div class="gap-10"></div>
  <div class="gap-10"></div>
  <div class="gap-10"></div>
  
  <h1> <i><font color="blue"> Create New Questions </font></i></h1>
 <div class="gap-10"></div>
 
 
 <div id = "Questions"> 
 <div style="text-align:center;border:1px solid red"> Question1 </div> 
 <div id = "QuestionNum_1">
 
Choose question type: <br> 
<select name = "type_1"> 
<option value="1">Multiple Choice</option>
<option value="0">Fill In The Blank</option>
<option value="2">Picture Response</option>
<option value="3">Question Response</option>
</select>

<br>
<div class="gap-10"></div>
 
 Add Question:  <br>
 <textarea name="question_1" rows="3" cols="50" style="overflow-y:scroll"> </textarea> <br>
 <div class="gap-10"></div>
 
 Enter Correct Answer: <br>
<textarea name="corrAns_1" rows="3" cols="50" style="overflow-y:scroll"> </textarea> <br> <br>
</div>

Enter Answer:<br>
<textarea name="quest_1ans" rows="3" cols="50" style="overflow-y:scroll"> </textarea> <br> <br>
</div>

<input type="button" id="addAns" onClick="addAnswer()" value="Add Answer" />

<br><input type="button" id="addQuest" onClick="addQuestion()" value="Add Question" />
  
  <div class="gap-10"></div>
  <div class="gap-10"></div>
  <input type="submit" name="Add Quiz" value="Add Quiz"/>

</form>

 </div> 
 
</body>
</html>