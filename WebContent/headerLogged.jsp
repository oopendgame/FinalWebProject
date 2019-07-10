<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.header {
  overflow: hidden;
  background-color: lavender;
  padding: 20px 10px;
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 35px;
  font-weight: bold;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.ac {
  background-color: #6D696F;
  color: white;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  
  .header-right {
    float: none;
  }
}
</style>
</head>
<body>

<% 
	LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
	log.setUserName(name);
	log.setId(id);
	adminInfo adInfo= new adminInfo();
	if(adInfo.isAdmin(username)) {
		request.getRequestDispatcher("admin/adminPage.jsp").forward(request,response);
	}else {
        request.getRequestDispatcher("userPage.jsp").forward(request,response);

	}
    %>

<div id="myDiv">
<div class="header">
  <a href="home.jsp" class="logo">Logo</a>
  <div class="header-right">
    <a href="userPage.jsp" class = "c">Profile <i class="fas fa-user"></i></a>
    <a href="login.jsp" class = "c">Log out <i class="fa fa-sign-out-alt"></i></a>
  </div>
</div>
</div>

<script>
// Add active class to the current button (highlight it)
var header = document.getElementById("myDiv");
var btns = header.getElementsByClassName("c");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function() {
  var current = document.getElementsByClassName("ac");
  if (current.length > 0) { 
    current[0].className = current[0].className.replace(" ac", "");
  }
  this.className += " ac";
  });
}
</script>

</body>
</html>
