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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>


<body  bgcolor="#0AF8D2">
<h1> <i><font color="blue"> Create New Questions </font></i></h1>


  
 <div class="gap-10"></div>
 Choose question type: <br>
 <select name="QuestionType" onchange='addField(this)'>
 <div class="gap-10"></div>
 
<option value="0">Fill In The Blank</option>
<option value="1">Multiple Choice</option>
<option value="2">Picture Response</option>
<option value="3">Question Response</option>
</select>
<br>
 <div class="gap-10"></div>
 
 Add Question:  <br>
 <textarea name="question" rows="3" cols="50" style="overflow-y:scroll"> </textarea> <br>
 
 Enter Correct Answer: <br>
 <input type='text' name = "correctAns" size=45 /> <br>
 
 <div class="gap-10"></div>
<button id="Add">add answer textbox</button> 
<button id="Remove">remove answer textbox</button>  
    <div id="textboxDiv"></div>  
    <script>  
    	var i = 0;
        $(document).ready(function() {  
            $("#Add").on("click", function() {  
                $("#textboxDiv").append("<div><br><input type='text' name = 'questions' + i size=45 /><br></div>");  
                i++;
            });  
            $("#Remove").on("click", function() {  
                $("#textboxDiv").children().last().remove();  
                i--;
            });  
        });  
    </script>
    
<br>
<input type="button" id="addQuest" onClick="addQuestion()" value="Add Question" />


<div class="gap-10"></div>
  <a href="CreateQuiz.jsp" style="text-decoration: none">Finish Quiz</a>
		
</body>
</html>