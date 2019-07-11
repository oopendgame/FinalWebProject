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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz Result Page</title>
</head>

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

<body>

<h1>Quiz Name: <% out.println(cur.getQuizName()); %> </h1>
<h1>Your score: <% out.println(curInfo.getScore()); %> </h1>
<h1>Taken Time: 
<% 
	findQuizScoreInfo addInf = new findQuizScoreInfo();
	ArrayList<QuizScoreInfo> questSc = addInf.getUserAttempts(user_id, id);
	out.println(questSc.get(0).getDuration());
%>
 </h1>
 
 
 
 <div>
            <h4>Correct Answers</h4>
                   
                         
         	<%
       			ArrayList<QuestionInfo> questions = curInfo.getQuestions();
         		if(questions.size() == 0) out.println("Your friends no submissions");
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





 <div>
                    <h4>Friends' Submissions</h4>
                   
                         
         	<%
       			ArrayList<QuizScoreInfo> arr = addInf.getFriendsSubmission(user_id, id);
         		if(arr.size() == 0) out.println("Your friends no submissions");
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



<div>
                <h4>Your Submissions</h4>
                
                        
         	<%
           		arr = addInf.getUserAttempts(user_id, id);
         		if(arr.size() == 0) out.println("You have no submissions");
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



 
</body>
</html>

