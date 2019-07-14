<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quizzes</title>

<script>

   	function changeFunc() {
		var selectBox = document.getElementById("selectBox");
	    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    	location.replace(selectedValue)
   	}

  </script>
  
</head>
<body>

<p style="display:inline-block">sort by:</p>
	<select id="selectBox" onchange="changeFunc();">  
		<option onclick="myFunction()" value="newestQuizzes.jsp">date</option>
		<option onclick="myFunction()" value="popularQuizzes.jsp">popularity</option>
		<option onclick="myFunction()" value="quizzesByMe.jsp">created by me</option>
	  	<option onclick="myFunction()" value="myTakenQuizzes.jsp">taken by me</option>
	 </select>

<%@include file="newestQuizzes.jsp" %>
</body>
</html>