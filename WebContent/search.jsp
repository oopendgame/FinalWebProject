<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
@media screen and (max-width: 600px) {
  .topnav .search-container {
    float: none;
  }
  .topnav a, .topnav input[type=text], .topnav .search-container button {
    float: right;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }

	.header-right {
	  float: right;
	}
}

</style>


<body>
<form action = "searchUserServlet" method = "post"> 

<input type="searchText" name = "user_name" placeholder="Search user...">
<button type="searchSubmit"><i class="fa fa-search"></i></button>
      
</form>


<form action = "searchQuizServlet" method = "post"> 

<input type="searchText" name = "quiz_name" placeholder="Search quiz...">

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

<button type="searchSubmit"><i class="fa fa-search"></i></button>
</form>
</body> 
</html>