<%@ page import="WebPackage.quiz.findQuizInfo"%> 
<%@ page import="WebPackage.quiz.QuizInfo"%> 

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

    <h3>Created By: <% out.println(cur.getAuthorId()); %></h3>



    <div>
        <h4>Top Scores of All Time</h4>
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