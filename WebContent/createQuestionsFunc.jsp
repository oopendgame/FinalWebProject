<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<!DOCTYPE html>
<html>

<script type="text/javascript">
var questions = 1, answers = 1;

function newQuestion() {
	var cur = document.createElement('div');
	cur.setAttribute('quest', 'ans');
	cur.innerHTML = '<div class="gap-10"></div><br>'+
					 '<div style="text-align:center;border:1px solid red"> Question ' + questions + '</div>'+
					 
					 '<div id = "QuestionNum_' + questions + '">'+					 
					'Choose question type: <br>'+
					'<select name = "type_' + questions +
					'<option value="1">Multiple Choice</option>'+
					'<option value="0">Fill In The Blank</option>'+
					'<option value="2">Picture Response</option>'+
					'<option value="3">Question Response</option>'+
					'</select>'+

					'<br>'+
					'<div class="gap-10"></div>'+
					 
					 'Add Question:  <br>'+
					 '<textarea name="question_' + questions + '" rows="3" cols="50" style="overflow-y:scroll"> </textarea> <br>'+
					 '<div class="gap-10"></div>'+
					 
					 'Enter Correct Answer: <br>'+
					'<textarea name="corrAns_' + questions + '" rows="3" cols="50" style="overflow-y:scroll"> </textarea> <br> <br>'+
					'</div>'+

					'Enter Answer:<br>'+
					'<textarea name="quest_' + questions + 'ans"' + answers + 'rows="3" cols="50" style="overflow-y:scroll"> </textarea> <br> <br>'+
					'</div>'+
					
					'<input type="button" id="remove_Question" onClick="removeQuestion(this)" value="Remove Question" /><br>'
	document.getElementById('Questions').appendChild(cur);
}


function addQuestion() {
	questions++;
	answers = 1;
	newQuestion();
}


function addAnswer() {
	answers++;
	var cur = document.createElement('div');
	cur.setAttribute('quest', 'ans');
	cur.innerHTML = 'Enter Answer:<br>'+
					'<textarea name="quest_' + questions + 'ans"' + answers + 'rows="3" cols="50" style="overflow-y:scroll"> </textarea> <br>'+
					'</div>'+
	 				'<input type="button" id="remove_answer()" onClick="removeAnswer(this)" value="Remove Answer" /><br><br>';
	document.getElementById('Questions').appendChild(cur);
}


function removeQuestion(cur) {
	questions--;
	document.getElementById('Questions').removeChild(cur.parentNode);
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