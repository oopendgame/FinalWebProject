<%@page import="java.util.ArrayList"%>
<%@ page import="WebPackage.quizScores.QuizScoreInfo"%> 
<%@ page import="WebPackage.quizScores.findQuizScoreInfo"%> 
<%@ page import="WebPackage.quiz.QuizInfo"%> 
<%@ page import="WebPackage.quiz.findQuizInfo"%> 
<%@ page import="WebPackage.user.findUserInfo"%> 
<%@ page import="WebPackage.user.userInfo"%> 
<%@ page import="WebPackage.login.LogInInfo"%> 
<%@ page import="WebPackage.database.DBInfo"%> 

<%@include file="headerLogged.jsp" %>
<%@include file="nav.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz Page</title>
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

</style>


<div>
<%
	int id = (int)request.getAttribute("quiz_id");
	findQuizInfo q = new findQuizInfo();
	QuizInfo cur = q.getQuiz(id);
	
	LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
	int user_id = log.getId();
%>

<body style="background-color:lavender;">


<h1>Quiz Name: <% out.println(cur.getQuizName()); %> </h1>

<h2>Subject: <% out.println(cur.getSubject()); %> </h2>
<h2>Description: <% out.println(cur.getDecription()); %> </h2>

<h2>Created By: 
	<% 
		findUserInfo user = new findUserInfo();
		userInfo curUser = user.getMyUser(cur.getAuthorId());
		
		log.setSearchId(cur.getAuthorId());		
		out.print("<a href = \"othersPage.jsp\">");
		out.println(curUser.getUserName()); 
		out.print("</a>");
	%></h2>
</div>
<br>

<div>
    <h3 style= "color:purple">Top Scores of All Time</h3>            
           	<%
         		findQuizScoreInfo addInf = new findQuizScoreInfo();
           		ArrayList<QuizScoreInfo> arr = addInf.getMaxScoreInQuiz(id);
           		if(arr.size() == 0) out.println("<p class=\"c\">Nobody has ever written this quiz</p>");
           		else {
           		%>
           		
           		<table border = "2">
            <tr>
              <th>Name</th>
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
        			long time = curQuiz.getDuration();
        			if(time / 60 > 0) out.print(time / 60 + " minutes and " + time % 60 + " seconds");
        			else out.print(time + " seconds");
        			out.print("</td>\n");
        			
        			out.print("<td>");
        			out.print(curQuiz.getScore() + " (" + perc + "%)");
        			out.print("</td>\n");
        			
        			out.println("</tr>");
           		}   }
           %>             
              </table> 
    </div>
	<br><br>




    <div>
            <h3 style= "color:purple">Top Scores of the Day</h3>

            
           	<%
           		arr = addInf.getTodaysMaxScoreInQuiz(id);
           	if(arr.size() == 0) out.println("<p class=\"c\">Nobody has written his quiz today</p>");
           	else {
           	%>
           	
           	 <table border = "2">
            <tr>
              <th>Name</th>
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
                <h3 style= "color:purple">Your Submissions</h3>
                
                        
         	<%
           		arr = addInf.getUserAttempts(user_id, id);
         		if(arr.size() == 0) out.println("<p class=\"c\">You have no submisssions</p>");
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
                    <h3 style= "color:purple">Friends' Submissions</h3>
                   
                         
         	<%
           		arr = addInf.getFriendsSubmission(user_id, id);
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
                        <h3 style= "color:purple">Last Submissions</h3>
                        
         	<%
           		arr = addInf.getLastSubmissions(id);
         		if(arr.size() == 0) out.println("<p class=\"c\">Nobody has ever written this quiz</p>");
         		else { %>
         		
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
           		}  }
           %>              
              </table>
                
                    <br><br>
    
    <form name = "startQuiz" action = "writeQuizServlet" method = "post">
	<input type = "hidden" name = "quiz_id" value = <%=id%>> 
<%--	<input type = "hidden" name = "mult" value = "<%=cur.getPageNum()%>">
	<input type = "hidden" name = "rand" value = "<%=cur.getRandom()%>">
	<input type = "hidden" name = "imm" value = "<%=cur.getCorrectionType()%>">  --%>
	<input type = "submit" value = "Start Quiz">
</form>

</div> 
</body>
</html>