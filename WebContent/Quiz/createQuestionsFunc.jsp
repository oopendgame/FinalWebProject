<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<!DOCTYPE html>
<html>

<script type="text/javascript">
int counter = 0, questions = 1, answers = 1;


function createQuestion() {
	var newDiv = document.createElement('div');
	newDiv.innerHTML="Stuff";
	newDiv.setAttribute('src', 'newDiv');
	
}

function addQuestion() {
	questions++;
	answers = 1;
	createQuestion();
}


function removeQuestion(div) {
	questions--;
	document.getElementById('Questions').removeChild(div.parentNode);
}

</script>


<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>