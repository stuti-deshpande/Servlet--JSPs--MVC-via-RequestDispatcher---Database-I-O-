<%@ page import="Student.dataBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" type = "text/css" href = "styles/Style.css" />

    	
<title>Winner Acknowledgement</title>
</head>
<body>
	<h1>Winner Acknowledgement!!!!!</h1>
	
	<%
		dataBean db1 = (dataBean) session.getAttribute("db1");
	    String  unOrderedList= (String) session.getAttribute("unOrderedList");
	%>

	<h2>Thank you for participating in the survey.</h2>

	<h3>
		Mean:"<%=db1.getMean()%>"
	</h3>
	<h3>
		SD:"<%=db1.getSd()%>"
	</h3>
	<h3>
	Click on the Student ID's below to retrieve the saved form data.
	</h3>
	<h3>
	<% 
	    out.println(unOrderedList);
	    %>
	</h3>
</body>
</html>
