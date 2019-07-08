<!DOCTYPE html> 
<html>
<head>
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
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>

<body style="background-color:lavender;">
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>
<h3 style="font-size:200%; color:#330066; text-align:center;">Change password</h3>

  <form action="newPassServlet" method="post" style="text-align:center">
    
    <input type="password" id="pass" name="opassword" placeholder="Old Password" required><br>
    <input type="checkbox" onclick="myFunction()">Show Password<br><br>
    
    <input type="password" id="pass" name="npassword" placeholder="New Password" required><br>
    <input type="checkbox" onclick="myFunction()">Show Password<br><br>

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
	
    <input type="submit" value="Save Changes"><br>
  </form>
</body>
</html>