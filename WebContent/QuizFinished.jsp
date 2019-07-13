<%@page import="java.util.ArrayList"%>
<%@ page import="WebPackage.quizScores.QuizScoreInfo"%> 
<%@ page import="WebPackage.quizScores.findQuizScoreInfo"%> 
<%@ page import="WebPackage.quiz.QuizInfo"%> 
<%@ page import="WebPackage.quiz.findQuizInfo"%> 
<%@ page import="WebPackage.user.findUserInfo"%> 
<%@ page import="WebPackage.user.userInfo"%> 
<%@ page import="WebPackage.login.LogInInfo"%> 
<%@ page import="WebPackage.database.DBInfo"%> 
<%@ page import="WebPackage.quiz.QuestionInfo"%>
<%@ page import="WebPackage.quiz.QuizInfo"%>
<%@ page import="WebPackage.quiz.findAnswerInfo"%>
<%@ page import="WebPackage.quiz.AnswerInfo"%>
<%@ page import="WebPackage.writingQuiz.writeQuizInfo"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<title>Quiz Result Page</title>
</head>


<style>
div {
  padding-right: 30px;
  padding-left: 100px;
  font-size: 40;
}


h2 {
	font-size:25px; 
	font-weight: bolder
}

input[type=submit] {
  width: 20%;
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

p.c {
  font-style: oblique;
}


table {
  border-collapse: collapse;
  width: 80%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: darkmagenta;
  color: white;
}


h2 {
	color: midnightblue;
	font-style: bold;
}


h1 {
	color: midnightblue;
	font-style: bold;
}

h3 {
	color:purple;
}

</style>

<div>
<%	
	HttpSession curSession = request.getSession();
	writeQuizInfo curInfo = (writeQuizInfo)curSession.getAttribute("writeQuiz");
	QuizInfo quiz = curInfo.getQuiz();
	ArrayList<QuestionInfo> quest = curInfo.getQuestions();
	findAnswerInfo ans = new findAnswerInfo();
	int id = quiz.getQuizId();
	
	findQuizInfo q = new findQuizInfo();
	QuizInfo cur = q.getQuiz(id);
	
	LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
	int user_id = log.getId();
%>

<body style="background-color:lavender;">

<h1>
<i class="material-icons" style="font-size:36px">school</i>
Quiz Name: <% out.println(cur.getQuizName()); %> 
</h1>

<h1>
<i class="fa fa-trophy" style="font-size:24px"></i>
Your score: <% out.println(curInfo.getScore()); %> 
</h1>

<h1>
<i class="material-icons" style="font-size:36px">access_time</i>
Taken Time: 
<% 
	findQuizScoreInfo addInf = new findQuizScoreInfo();
	ArrayList<QuizScoreInfo> questSc = addInf.getUserAttempts(user_id, id);
	if(questSc.size() != 0) {
		long time = questSc.get(0).getDuration();
		if(time / 60 > 0) out.print(time / 60 + " minu and " + time % 60 + " sec");
		else out.print(time + " sec");	
	}
%>
 </h1>
 </div>
 <br><br>
 
 
 <div>
            <h3>Correct Answers</h3>
                   
                         
         	<%
       			ArrayList<QuestionInfo> questions = curInfo.getQuestions();
         		if(questions.size() == 0) out.println("<p class=\"c\">There are no quetions </p>");
         		else {
         			ArrayList<String> userAns = curInfo.getUserAns();
         			ArrayList<String> corrAns = addInf.getCorrectAnswers(questions);
         	%>
         		<table border = "2">
                 <tr>
                   <th>Question Num</th>
                   <th>Question</th>
                   <th>Your Answer</th> 
                   <th>Correct Answer</th> 
                 </tr>
         	
         	<%
           		for(int i = 0; i < questions.size(); i++) {
           			QuestionInfo curQuest = questions.get(i);
           
           			out.println("<tr>");
           			 
           			out.print("<td>");
        			out.print(i + 1);
        			out.print("</td>\n");
           			
           			out.print("<td>");
        			if(!curQuest.getType().equals("2")) out.print(curQuest.getQuestion());
        			else out.print("Picture Question");
        			out.print("</td>\n");
        			
           			out.print("<td>");
        			if(!curQuest.getType().equals("1")) out.print(userAns.get(i));
        			else out.print(userAns.get(i));
        			out.print("</td>\n");
        			
        			out.print("<td>");
        			out.print(corrAns.get(i));
        			out.print("</td>\n");
        			
        			out.println("</tr>");
           		} }
           %>             
              </table>
            
</div>
 <br><br>




 <div>
                    <h3>Friends' Submissions</h3>
                   
                         
         	<%
       			ArrayList<QuizScoreInfo> arr = addInf.getFriendsSubmission(user_id, id);
         		if(arr.size() == 0) out.println("<p class=\"c\">Your friends have no submissions</p>");
         		else {
         	%>
         		<table border = "2">
                 <tr>
                   <th>Friend's Name</th>
                   <th>Date</th>
                   <th>Time</th> 
                   <th>Score</th>
                 </tr>
         	
         	<%
           		for(int i = 0; i < arr.size(); i++) {
           			QuizScoreInfo curQuiz = arr.get(i);
           			double perc = (double)curQuiz.getScore() / cur.getQuestions().size() * 100;
           			perc = Math.round(perc * 100.0) / 100.0;
           
           			out.println("<tr>");
           			
           			out.print("<td>");
        			out.print(curQuiz.getUserName());
        			out.print("</td>\n");
        			
           			out.print("<td>");
        			out.print(curQuiz.getStartingDate().toString());
        			out.print("</td>\n");
        			
        			out.print("<td>");
        			long time = curQuiz.getDuration();
        			if(time / 60 > 0) out.print(time / 60 + " minu and " + time % 60 + " sec");
        			else out.print(time + " sec");
        			out.print("</td>\n");
        			
        			out.print("<td>");
        			out.print(curQuiz.getScore() + " (" + perc + "%)");
        			out.print("</td>\n");
        			
        			out.println("</tr>");
           		} }
           %>             
              </table>
            
</div>
 <br><br>


<div>
                <h3>Your Submissions</h3>
                
                        
         	<%
           		arr = addInf.getUserAttempts(user_id, id);
         		if(arr.size() == 0) out.println("<p class=\"c\">You have no submissions</p>");
         		else {
         	%>
         	
         	<table border = "2">
             <tr>
               <th>Date</th>
               <th>Time</th> 
               <th>Score</th>
             </tr>
         	
         	
         	<%
           		for(int i = 0; i < arr.size(); i++) {
           			QuizScoreInfo curQuiz = arr.get(i);
           			double perc = (double)curQuiz.getScore() / cur.getQuestions().size() * 100;
           			perc = Math.round(perc * 100.0) / 100.0;
           
           			out.println("<tr>");
           			
           			out.print("<td>");
        			out.print(curQuiz.getStartingDate().toString());
        			out.print("</td>\n");
        			
        			out.print("<td>");
        			long time = curQuiz.getDuration();
        			if(time / 60 > 0) out.print(time / 60 + " minu and " + time % 60 + " sec");
        			else out.print(time + " sec");
        			out.print("</td>\n");
        			
        			out.print("<td>");
        			out.print(curQuiz.getScore() + " (" + perc + "%)");
        			out.print("</td>\n");
        			
        			out.println("</tr>");
           		} }
           %>             
              </table> 
        
            </div>

 <br><br>

<div>
</body>
</html>

