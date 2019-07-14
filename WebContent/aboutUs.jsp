<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About</title>
</head>

<style>

img {
  border-radius: 50%;
  margin-left:auto;
  margin-right:auto;
  margin-top:20%;
  display:block;
}

* {
  box-sizing: border-box;
}

/* Create four equal columns that floats next to each other */
.column {
  float: left;
  width: 33.3%;
  padding: 10px;
  height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

</style>
<body>
<body  style="background-color:lavender;">
<br>
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<h1 style="font-size:200%; color:#330066; text-align:center;">About Us</h1><br>

<h3 style="font-size:130%; color:#330066; margin-left:10%; margin-right:10%">Our goal was to create a website where people could 
show off their intellectual prowess by taking quizzes on a wide range of subjects. 
However, not only can they take quizzes here, they
can compare their quiz scores to friends, 
challenge friends to beat their score, or write
quizzes that other people can take.</h3>


<div class="row">
  <div class="column">
    
    <img src="https://scontent.ftbs5-1.fna.fbcdn.net/v/t1.0-9/51785982_2118103464931868_3119
	750972641902592_n.jpg?_nc_cat=107&_nc_oc=AQlnG3fnULQVzT_JVePHDQwXhnNOpBlcO1Goio3BBvhxU-Hz
	7us-13z5WoB3_hBgGs4&_nc_ht=scontent.ftbs5-1.fna&oh=b8e922a5e12232712068fdd9474c7633&oe=5DACCD36"
	alt="achkh17" width="100" height="100">
	
	<h2 style = "text-align:center; font-size:18px">Anamaria Chkhaidze</h2> 
	<p style = "text-align:center;">Email: achkh17@freeuni.edu.ge</p>

  </div>
  <div class="column">
  
	<img src="https://scontent.ftbs5-1.fna.fbcdn.net/v/t1.0-9/19424401_784494171675882
	_8786767691181003760_n.jpg?_nc_cat=107&_nc_oc=AQnkUI2LvOnOZzh5a_wZL8BQBIuXBY6p
	_FdwcjBr8kjmixh3hNd4wkio7DnN7akkQ4g&_nc_ht=scontent.ftbs5-1.fna&oh=
	6c82b0e7027ed0eb5380f1104cb46038&oe=5DAEEB25" alt="nchan17" width="100" height="100">
	
	<h2 style = "text-align:center; font-size:18px">Nino Chanturia</h2>
	<p style = "text-align:center;">Email: nchan17@freeuni.edu.ge</p>

  </div>
  <div class="column">
    
	<img src="https://scontent.ftbs5-2.fna.fbcdn.net/v/t1.0-9/19366221_1510029115708562_3940055
	48772054778_n.jpg?_nc_cat=109&_nc_oc=AQm-UefM97v5g__4duxbjH0kyxCg9Ruy1flwMsoKdlOLULISzuphsK9Oc
	NMBV8i5tbg&_nc_ht=scontent.ftbs5-2.fna&oh=f4c3279c4d1b77dd8da62879f61f0e52&oe=5DC1170D"
	alt="machkh17" width="100" height="100">
	
	<h2 style = "text-align:center; font-size:18px">Mariam Chkhaidze</h2>
	<p style = "text-align:center;">Email: mackh17@freeuni.edu.ge</p>
	
  </div>
</div>

</body>
</html>