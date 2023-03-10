<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entity.Teacher" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teachers For Class</title>
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
	List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
	%>
	
	
	<%	if (username != null) {%>

			<div class="navbar">
				<ul>
					<li><a href = "AdminPage.jsp">Admin_Console</a></li>
					<li><a href = "AdminSubjectsForClassPage.jsp">Subjects_4C</a></li>
					<li><a href = "#">Teachers_4C</a></li>
					<li><a href = "AdminStudentsForClassPage.jsp">Students_4C</a></li>
					<li><a href = "AdminReportForClassPage.jsp">Report_4C</a></li>
					<li><a href = "LogoutPage.jsp">Logout</a></li>
				</ul>
			</div>	

			<h3><%= COMPANY_NAME %> | OnLine Management System</h3>
			<h1>Administrator's Console > Teachers for a Class</h1>
			
			<%	if (error != null) {%>
					<div class="error">
						<p style="color:red">Error! <%= error %></p>
					</div>
			<%	}%>			
			
			Assign one or more of the Classes (A1, A2, A3) to each teacher and press button "Assign".<br><br>
								 
			<table style="width:100%">
				<tr>
			    	<th>Teacher ID</th>
			    	<th>Teacher Surname</th>
			    	<th>Teacher Name</th>
			    	<th>Teacher Subject ID</th>
			    	<th>A1|A2|A3 (Class)</th>			    			    	
				</tr>
			  
		<%	for (Teacher teacher: teachers) { %>
				<tr>
				    <td><%= teacher.getId() %></td>
				    <td><%= teacher.getSurname() %></td>
				    <td><%= teacher.getName() %></td>
				    <td><%= teacher.getSubjectID() %></td>

				    <td>
					    <form action="AdminTeacherssForClassPage" method="post">
						    <input type="radio" name="classID" value="1" <% if (teacher.getClassID() == 1) %> checked> <% else %> >
						    <input type="radio" name="classID" value="2" <% if (teacher.getClassID() == 2) %> checked> <% else %> >
						    <input type="radio" name="classID" value="3" <% if (teacher.getClassID() == 3) %> checked> <% else %> >
							<input type="hidden" name="teacherID" value=<%= teacher.getId() %> >
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