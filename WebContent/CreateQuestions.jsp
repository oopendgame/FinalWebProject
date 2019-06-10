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
<title>Create New Questions</title>
</head>


<body  bgcolor="#0AF8D2">
<h1> <i><font color="blue"> Create New Questions </font></i></h1>

<div class="gap-10"></div>
  Choose question type: 
  <select name="subject">
    <option value="Question-Response">Question-Response</option>
    <option value="Fill in the Blank">Fill in the Blank</option>
    <option value="Multiple Choice" selected>Multiple Choice</option>
    <option value="Picture-Response Questions">Picture-Response Questions</option>
  </select>
  <br>
</body>
</html>