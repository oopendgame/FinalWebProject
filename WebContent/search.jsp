<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action = "searchUserServlet" method = "post"> 
Search User: 
<input type = "text" name = "user_name" placeholder = "enter username">
<input type = "submit" value = "searchUser">
</form>


<form action = "searchQUizServlet" method = "post"> 
Search Quiz: 
<input type = "text" name = "quiz_name" placeholder = "enter quiz name">

<select name="category">
<option value="choose category" selected>Choose category</option>
    <option value="history">History</option>
    <option value="geography">Geography</option>
    <option value="math">Math</option>
    <option value="biology">Biology</option>
    <option value="english">English</option>
    <option value="art">Art</option>
    <option value="georgian">Georgian</option>
    <option value="chemistry">Chemistry</option>
    <option value="physics">Physics</option>
    <option value="other">Other</option>
</select>

<input type = "submit" value = "searchQuiz">
</form>

</body> 
</html>