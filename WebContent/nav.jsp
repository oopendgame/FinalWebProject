<!DOCTYPE html>
<html>
<head>
<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' 
	integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' 
	crossorigin='anonymous'>
<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #D7D7D7;
  padding:5px 5px;
}


.topnav a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
  text-align:center;
  width: 25%;
}

.topnav a:hover {
  background-color: #EBEBEB;
  color: black;
}

.topnav a.act {
  background-color: #6D696F;
  color: white;
}

.topnav-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .topnav a {
    float: none;
    display: block;
    text-align: left;
  }
  
  .topnav-right {
    float: none;
  }
}
</style>
</head>
<body>

<div id="DIV">
<div class="topnav">
	<a class="b" href="homePage.jsp"><i class="fa fa-home"></i> Home</a>
    <a href="allQuizzes.jsp" class= "b"><i class="fas fa-question-circle"></i> Quizzes</a>
    <a href="rating.jsp" class = "b"><i class="fas fa-trophy"></i> Rating</a>
    <a href="about.jsp" class = "b"><i class="fas fa-exclamation-circle"></i> About</a>
  </div>
</div>
<br>
<script>
// Add active class to the current button (highlight it)
var header = document.getElementById("DIV");
var btns = header.getElementsByClassName("b");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function() {
  var current = document.getElementsByClassName("act");
  if (current.length > 0) { 
    current[0].className = current[0].className.replace(" act", "");
  }
  this.className += " act";
  });
}
</script>

</body>
</html>
