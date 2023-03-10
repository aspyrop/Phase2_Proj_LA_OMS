<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entity.Student" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students For Class</title>
<link rel="stylesheet" href="style.css">

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>

</head>
<body>

	<%
	//set a "no-cache" filter on this current (ToBe secured) JSP page
	response.addHeader("Pragma", "no-cache"); //HTTP 1.0.
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", 0); //Proxies	
	
	//get global constants
	String COMPANY_NAME = pageContext.getServletContext().getInitParameter("COMPANY_NAME");
	String PAGE_FOOTER = pageContext.getServletContext().getInitParameter("PAGE_FOOTER");
	
	//get any parameters passed
	String error = request.getParameter("error");
	String username = (String) session.getAttribute("username");
	List<Student> students = (List<Student>) request.getAttribute("students");
	%>
	
	
	<%	if (username != null) {%>

			<div class="navbar">
				<ul>
					<li><a href = "AdminPage.jsp">Console</a></li>
					<li><a href = "AdminSubjectsForClassPage.jsp">Subjects_4C</a></li>
					<li><a href = "AdminTeachersForClassPage.jsp">Teachers_4C</a></li>
					<li><a href = "#">Students_4C</a></li>
					<li><a href = "AdminReportForClassPage.jsp">Report_4C</a></li>
					<li><a href = "LogoutPage.jsp">Logout</a></li>
				</ul>
			</div>	

			<h3><%= COMPANY_NAME %> | OnLine Management System</h3>
			<h1>Administrator's Console > Students for a Class</h1>
			
			<%	if (error != null) {%>
					<div class="error">
						<p style="color:red">Error! <%= error %></p>
					</div>
			<%	}%>			
			
			Assign one of the Classes (A1, A2, A3) to each student and press button "Assign".<br><br>
								 
			<table style="width:100%">
				<tr>
			    	<th>Student ID</th>
			    	<th>Student Surname</th>
			    	<th>Student Name</th>
			    	<th>Student Middle Name</th>
			    	<th>A1|A2|A3 (Class)</th>			    			    	
				</tr>
			  
		<%	for (Student student: students) { %>
				<tr>
				    <td><%= student.getId() %></td>
				    <td><%= student.getSurname() %></td>
				    <td><%= student.getName() %></td>
				    <td><%= student.getMiddlename() %></td>
				    <td>
					    <form action="AdminStudentsForClassPage" method="post">
						    <input type="radio" name="classID" value="1" <% if (student.getClassID() == 1) %> checked> <% else %> >
						    <input type="radio" name="classID" value="2" <% if (student.getClassID() == 2) %> checked> <% else %> >
						    <input type="radio" name="classID" value="3" <% if (student.getClassID() == 3) %> checked> <% else %> >
							<input type="hidden" name="studentID" value=<%= student.getId() %> >
							<input type="submit" value="Assign">
						</form>
					</td>
				</tr>
		<%	} %>
			</table>
	<%	}
		else {
			response.sendRedirect("LoginPage.jsp");
		} %>
	
	<div>
		<br><font size="-2"><b><%= PAGE_FOOTER %></b></font>
	</div>
	
</body>
</html>