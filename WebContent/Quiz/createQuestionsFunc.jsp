<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<!DOCTYPE html>
<html>

<script type="text/javascript">
int counter = 0, questions = 1, answers = 1;

function addtextField() {
	
}

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

function removeQuestion(div) {
	questions--;
	document.getElementById('Questions').removeChild(div.parentNode);
}


function removeAnswer(div) {
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