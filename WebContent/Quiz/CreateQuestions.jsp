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
	
	a {
     text-decoration: none;
    }
	
</style>


<meta charset="UTF-8">
<title>Create New Questions</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>

<body  bgcolor="#0AF8D2">
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
  <a href="CreateQuiz.jsp" style="text-decoration: none">Finish Quiz</a>
  
  <!--
 <div class="gap-10"></div>
<button id="Add">add answer textbox</button> 
<button id="Remove">remove answer textbox</button>  
    <div id="textboxDiv"></div>  
    <script>  
    
    
   	var i = 0;
        $(document).ready(function() {  
            $("#Add").on("click", function() {  
                $("#textboxDiv").append("<div><br><input type='text' name = 'questions' size=45 /><br></div>");  
                i++;
            });  
            $("#Remove").on("click", function() {  
                $("#textboxDiv").children().last().remove();  
                i--;
            });  
        });  
        
        
    </script>
    
</div> -->
		
</body>
</html>