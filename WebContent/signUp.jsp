<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<style>

input[type=text], select {
  width: 50%;
  padding: 12px 15px;
  margin: 8px 0;
  display: inline-block;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=password], select {
  width: 50%;
  padding: 12px 15px;
  margin: 8px 0;
  display: inline-block;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=date], select {
  width: 50%;
  padding: 12px 15px;
  margin: 8px 0;
  display: inline-block;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
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

input[type=submit]:hover {
  background-color: #38045B;
}

</style>
</head>
<body style="background-color:lavender;">
<h3 style="font-size:200%; color:#330066; text-align:center">Create New Account</h3>

  <form action="accountServlet" method="post" style="text-align:center">
    <input type="text" id="fname" name="firstname"
    placeholder="First Name">
    
    <input type="text" id="lname" name="lastname" placeholder="Last Name">
    <input type="text" id="email" name="email" placeholder="Email"><br>
    
    <input type="text" id="uname" name="username" placeholder="Username">
    
    <input type="password" id="pass" name="password" placeholder="Password"><br>
    <input type="checkbox" onclick="myFunction()">Show Password<br><br><br>

	<script>
	function myFunction() {
	  var x = document.getElementById("pass");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}
	</script>
	

	<label for="bday" style="font-size:130%;">Birthday:</label><br>
	
    <input type="date" name="bday"><br><br>
    <label for="gender" style="font-size:130%;">Gender:</label><br>
    
    <input type="radio" name="gender" value="male" checked> Male
    <input type="radio" name="gender" value="female"> Female
    <input type="radio" name="gender" value="other"> Other<br><br>
    
  
    <input type="submit" value="Sing Up"><br>
    <a href="login.jsp">Have An Account?</a>
  </form>
</body>
</html>