<%@ page import="WebPackage.user.userInfo"%>
<%@ page import="WebPackage.database.DBInfo"%>
<%@ page import="WebPackage.requests.requestInfo"%>
<%@ page import="WebPackage.login.LogInInfo"%>
<%@ page import="WebPackage.requests.findRequestInfo"%>
<%@ page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request List</title>
</head>

<%
	findRequestInfo req = new findRequestInfo();
	LogInInfo log = (LogInInfo) getServletContext().getAttribute(DBInfo.Attribute_Name);
	ArrayList<requestInfo> arr = req.getUserRequests(log.getId());
	if(arr.size() == 0) out.println("No requests");
	else {
		for(int i = 0; i < arr.size(); i++) {
			requestInfo cur = arr.get(i);
%>		
		<ul> <% out.println(cur.getUserName() + "sent you friend request"); %> </ul>
			<%	if(arr != null) { %> 
		
					<form name = "acceptForm" action = "acceptRequestServlet" method="get">
					<input type = "hidden" id = "requestID" name = "requestID"
						   value = "<%= cur.getRequestId() %>">
					<input type = "hidden" id = "sender" name = "sender"
						   value = "<%= cur.getSenderID() %>">
					<input type = "hidden" id = "receiver" name = "receiver"
						   value = "<%= cur.getReceiverID() %>">
					<input type = "submit" value = "accept">
					</form>
	
					<form name = "rejectForm" action = "rejectRequestServlet" method="get">
					<input type = "hidden" id = "requestID" name = "requestID"
						   value = "<%= cur.getRequestId() %>">
					<input type = "submit" value = "reject">
					</form>
			<% } } } %>


  
<body>

</body>


</html>