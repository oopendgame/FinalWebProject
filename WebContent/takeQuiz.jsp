<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title> Take Quiz </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
#myDIV {
	display: none;
}

.vertical-menu {
  width: 200px;
  height: 150px;
  overflow-y: auto;
}

.vertical-menu a {
  background-color: #eee;
  color: black;
  display: block;
  padding: 12px;
  text-decoration: none;
}

.vertical-menu a:hover {
  background-color: #ccc;
}

.button {
  background-color: indigo;
  color: white;
  padding: 8px 25px;
  text-align: center;
  text-decoration: none;
  border-radius: 4px;
}
.button:hover {
   background-color: #38045B;	
 }
</style>
</head>
<body>

<button class = "button" onclick="myFunction()">Send Challenge</button><p>

<div class="vertical-menu" id = "myDIV">
  <a href="#">Friend 1</a>
  <a href="#">Friend 2</a>
  <a href="#">Friend 3</a>
  <a href="#">Friend 4</a>
  <a href="#">Friend 5</a>
</div>

<script>
function myFunction() {
  var x = document.getElementById("myDIV");
  if (x.style.display === "block") {
    x.style.display = "none";
  } else {
    x.style.display = "block";
  }
}
</script>

</body>
</html>