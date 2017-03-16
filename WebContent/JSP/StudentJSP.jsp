
<%@page import="Student.studentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/Style.css" />

     
<title>Data Entered</title>
</head>
<body>
   <h1> Saved Form Data</h1>
	<%
		studentBean sb2 = (studentBean) session.getAttribute("sb2");
	%>
	<form>
		<table align="center">
			<tr>
				<td><label>StudentID</label><br /> <input type="text"
					id="StudentID" name="StudentID" value="<%=sb2.getStudentID()%>"
					readonly="readonly" /></td>
			
				<td><label>First Name</label><br /> <input type="text"
					id="FirstName" name="FirstName" value="<%=sb2.getFirstName()%>"
					readonly="readonly" /></td>

				

				<td><label>Street Address 1</label><br /> <input type="text"
					name="street1" value="<%=sb2.getStreet1()%>" readonly="readonly" /></td>


			</tr>
			<tr>
				<td><label>Street Address 2</label><br /> <input type="text"
					name="Street2" id="street2" value="<%=sb2.getStreet2()%>"
					readonly="readonly" /></td>

				<td><label>Zipcode</label><br /> <input type="text" name="zip"
					id="zip" value="<%=sb2.getZip()%>" readonly="readonly" /></td>

				<td><label>City</label><br /> <input type="text" name="City"
					id="City" value="<%=sb2.getCity()%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td><label>State</label><br /> <input type="text" name="State"
					id="State" value=<%=sb2.getState()%>/></td>
				<td><label>Telephone Number</label><br /> <input
					name="TelephoneNumber" id="TelephoneNumber" type="text"
					value="<%=sb2.getTelephonenum()%>" readonly="readonly" /></td>
				<td><label>Email</label><br /> <input type="text"
					name="Email" id="email" value="<%=sb2.getEmail()%>"
					readonly="readonly" /></td>

			</tr>
			<tr>
				<td><label>URL</label><br /> <input name="url" type="text"
					value="<%=sb2.getURL()%>" readonly="readonly" /></td>
				<td><label>Date of Survey:</label><br /> <input type="text"
					name="date" id="DateOfSurvey" value="<%=sb2.getDate()%>"
					readonly="readonly" /></td>
				<td><label>Data entered </label><br /> <input type="text"
					name="data" value="<%=sb2.getData()%>" readonly="readonly" /></td>
			<tr>
				<td><label>LikeMost</label><br /> <input name="LikeMost"
					type="text" value="<%=sb2.getLikeMost()%>" readonly="readonly" /></td>
				<td><label>HowToSite</label><br /> <input name="HowToSite"
					type="text" value="<%=sb2.getHowToSite()%>" readonly="readonly" />
				</td>
				<td><label>Likelihood</label><br /> <input name="Likelihood"
					type="text" value="<%=sb2.getLikelihood()%>" readonly="readonly" /></td>

			</tr>
			
			<tr>
				<td><label>GradMonth</label><br /> <input type="text"
					name="GradMonth" value="<%=sb2.getGradMonth()%>" readonly="readonly" /></td>
				<td><label>Year</label><br /> <input type="text" name="Year"
					value="<%=sb2.getYear()%>" readonly="readonly" /></td>
					
					<td><label>Comments</label><br /> <input type="text" name="comments"
					value="<%=sb2.getComments()%>" readonly="readonly" /></td>
			</tr>
		</table>
	</form>



</body>
</html>