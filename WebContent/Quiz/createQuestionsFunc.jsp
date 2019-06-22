<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<!DOCTYPE html>
<html>

<script type="text/javascript">
var counter = 0, questions = 1, answers = 1;

function addAnswer() {
	answers++;
	var newQuest = document.createElement('newQuest');
	newDiv.innerHTML = "newAns";
	newDiv.setAttribute('src', 'newQuest');
	document.getElementById('Questions').appendChild(newDiv);
}

function createQuestion() {
	var newQuest = document.createElement('newQuest');
	newDiv.innerHTML = "newQuest";
	newDiv.setAttribute('src', 'newQuest');
	document.getElementById('Questions').appendChild(newDiv);
}

function addQuestion() {
	createQuestion();
	questions++;
	answers = 1;
}

function removeQuestion(x) {
	questions--;
	document.getElementById('Questions').removeChild(x.parentNode);
}


function removeAnswer(x) {
	document.getElementById('Questions').removeChild(x.parentNode);
}

</script>


<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>