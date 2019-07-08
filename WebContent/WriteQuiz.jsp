<%@page import="java.util.ArrayList"%>
<%@ page import="WebPackage.quiz.QuestionInfo"%>
<%@ page import="WebPackage.quiz.QuizInfo"%>
<%@ page import="WebPackage.writingQuiz.writeQuizInfo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	HttpSession curSession = request.getSession();
	int id = Integer.parseInt(request.getParameter("quiz_id"));
	writeQuizInfo cur = (writeQuizInfo)curSession.getAttribute("writeQuiz");
	QuizInfo quiz = cur.getQuiz();
	ArrayList<QuestionInfo> quest = cur.getQuestions();
%>

<html>
<head>
<meta charset="UTF-8">
<title>Writing Quiz</title>
</head>

<body>


</body>
</html>