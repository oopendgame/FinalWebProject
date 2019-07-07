
<!DOCTYPE html>
<html>
<head>
<title> Take Quiz </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
#myDIV {
	display: none;
}
.friend{
	width: 183px;
  height: 40px;
  overflow-y: auto;
  border: none;
}
.vertical-menu {
  width: 200px;
  height: 120px;
  overflow-y: auto;
}

.friend:hover {
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

<form action="loginServlet" method="post">

	<button class = "button" onclick="myFunction()">Send Challenge</button><p>
    
  	<div class="vertical-menu" id = "myDIV">
    <input type="submit" value="Friend 1" class = "friend"><br>
    <input type="submit" value="Friend 2" class = "friend"><br>
    <input type="submit" value="Friend 3" class = "friend"><br>
    <input type="submit" value="Friend 4" class = "friend"><br>
    <input type="submit" value="Friend 5" class = "friend"><br>
	</div>

<script>
function myFunction() {
  var x = document.getElementById("myDIV");
  if (x.style.display === "none") {
    
  } else {
    x.style.display = "block";
  }
}
</script>
</form>

</body>
</html>