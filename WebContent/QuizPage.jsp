<%@page import="java.util.ArrayList"%>
<%@ page import="WebPackage.quizScores.QuizScoreInfo"%> 
<%@ page import="WebPackage.quizScores.findQuizScoreInfo"%> 
<%@ page import="WebPackage.quiz.QuizInfo"%> 
<%@ page import="WebPackage.quiz.findQuizInfo"%> 
<%@ page import="WebPackage.user.findUserInfo"%> 
<%@ page import="WebPackage.user.userInfo"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz Page</title>
</head>

<%
	int id = (int)request.getAttribute("quiz_id");
	findQuizInfo q = new findQuizInfo();
	QuizInfo cur = q.getQuiz(id);
%>

<body>

<h1>Quiz Name: <% out.println(cur.getQuizName()); %> </h1>

<h3>Subject: <% out.println(cur.getSubject()); %> </h3>
<h3>Description: <% out.println(cur.getDecription()); %> </h3>

<h3>Created By: 
	<% 
		findUserInfo user = new findUserInfo();
		userInfo curUser = user.getMyUser(cur.getAuthorId());
		out.println(curUser.getUserName()); 
	%></h3>



<div>
    <h4>Top Scores of All Time</h4>
    <table border = "2">
            <tr>
              <th>Name</th>
              <th>Time</th> 
              <th>Score</th>
            </tr>
            
           	<%
         		findQuizScoreInfo addInf = new findQuizScoreInfo();
           		ArrayList<QuizScoreInfo> arr = addInf.getMaxScoreInQuiz(id);
           		for(int i = 0; i < arr.size(); i++) {
           			QuizScoreInfo curQuiz = arr.get(i);
           			double perc = (double)curQuiz.getScore() / cur.getQuestions().size() * 100;
           
           			out.println("<tr>");
           			
           			out.print("<td>");
        			out.print(curQuiz.getUserName());
        			out.print("</td>\n");
        			
        			out.print("<td>");
        			out.print(curQuiz.getDuration());
        			out.print("</td>\n");
        			
        			out.print("<td>");
        			out.print(curQuiz.getScore() + " (" + perc + ")%");
        			out.print("</td>\n");
        			
        			out.println("</tr>");
           		}
         	
         
         
           %>
                
                
              </table> 

    </div>










    <div>
            <h4>Top Scores of the Day</h4>
            <table>
                    <tr>
                      <th>Name</th>
                      <th>Time</th> 
                      <th>Score</th>
                    </tr>
                    <tr>
                      <td>Jill</td>
                      <td>Smith</td> 
                      <td>50</td>
                    </tr>
                    <tr>
                      <td>Eve</td>
                      <td>Jackson</td> 
                      <td>94</td>
                    </tr>
                    <tr>
                        <td>Eve</td>
                        <td>Jackson</td> 
                        <td>94</td>
                    </tr>
    
                    <tr>
                        <td>Eve</td>
                        <td>Jackson</td> 
                        <td>94</td>
                    </tr>
    
                    <tr>
                        <td>Eve</td>
                        <td>Jackson</td> 
                        <td>94</td>
                    </tr>
                  </table> 
    
        </div>






        <div>
                <h4>Your Submissions</h4>
                <table>
                        <tr>
                          <th>Date</th>
                          <th>Time</th> 
                          <th>Score</th>
                        </tr>
                        <tr>
                          <td>Jill</td>
                          <td>Smith</td> 
                          <td>50</td>
                        </tr>
                        <tr>
                          <td>Eve</td>
                          <td>Jackson</td> 
                          <td>94</td>
                        </tr>
                        <tr>
                            <td>Eve</td>
                            <td>Jackson</td> 
                            <td>94</td>
                        </tr>
        
                        <tr>
                            <td>Eve</td>
                            <td>Jackson</td> 
                            <td>94</td>
                        </tr>
        
                        <tr>
                            <td>Eve</td>
                            <td>Jackson</td> 
                            <td>94</td>
                        </tr>
                      </table> 
        
            </div>







            <div>
                    <h4>Friends' Submissions</h4>
                    <table>
                            <tr>
                              <th>Dates</th>
                              <th>Time</th> 
                              <th>Score</th>
                            </tr>
                            <tr>
                              <td>Jill</td>
                              <td>Smith</td> 
                              <td>50</td>
                            </tr>
                            <tr>
                              <td>Eve</td>
                              <td>Jackson</td> 
                              <td>94</td>
                            </tr>
                            <tr>
                                <td>Eve</td>
                                <td>Jackson</td> 
                                <td>94</td>
                            </tr>
            
                            <tr>
                                <td>Eve</td>
                                <td>Jackson</td> 
                                <td>94</td>
                            </tr>
            
                            <tr>
                                <td>Eve</td>
                                <td>Jackson</td> 
                                <td>94</td>
                            </tr>
                          </table> 
            
                </div>






                <div>
                        <h4>Last Submissions</h4>
                        <table>
                                <tr>
                                  <th>Dates</th>
                                  <th>Time</th> 
                                  <th>Score</th>
                                </tr>
                                <tr>
                                  <td>Jill</td>
                                  <td>Smith</td> 
                                  <td>50</td>
                                </tr>
                                <tr>
                                  <td>Eve</td>
                                  <td>Jackson</td> 
                                  <td>94</td>
                                </tr>
                                <tr>
                                    <td>Eve</td>
                                    <td>Jackson</td> 
                                    <td>94</td>
                                </tr>
                
                                <tr>
                                    <td>Eve</td>
                                    <td>Jackson</td> 
                                    <td>94</td>
                                </tr> 
                
                                <tr>
                                    <td>Eve</td>
                                    <td>Jackson</td> 
                                    <td>94</td>
                                </tr>
                              </table> 
                
                    </div>
                    
	<form name = "addFriend" action = "writeQuizServlet" method = "get">
        	<input type="hidden" name="user2" value=""/>
            <input type="submit" name="Add Friend" value="Start Quiz"/>
    </form>

</body>
</html>