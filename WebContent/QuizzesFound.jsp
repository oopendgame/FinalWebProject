<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz List</title>
</head>

<body>
<p> Quizzes Found: </p>

<%
	ArrayList<QuizInfo> arr = request.getAttribute("quizzes");

%>

</body>
</html>