<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entity.Teacher" %>
<%@ page import="database.TeacherDatabase" %>
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
					<li><a href = "AdminPage.jsp">Console</a></li>
					<li>
						<form action="AdminSubjectsForClassPage" method="get">
							<a href = "AdminSubjectsForClassPage">Subjects_4C</a>
						</form>
					</li>
					<li>
						<form action="AdminTeachersForClassPage" method="get">
							<a href = "AdminTeachersForClassPage">Teachers_4C</a>
						</form>
					</li>
					<li>
						<form action="AdminStudentsForClassPage" method="get">
							<a href = "AdminStudentsForClassPage">Students_4C</a>
						</form>
					</li>
					<li>
						<form action="AdminReportForClassPage" method="get">
							<a href = "AdminReportForClassPage">Report_4C</a>
						</form>
					</li>
					<li><a href = "LogoutPage.jsp">Logout</a></li>
				</ul>
			</div>

			<h3><%= COMPANY_NAME %> | OnLine Management System</h3>
			<h1>Teachers Administration</h1>
			
			<%	if (error != null) {%>
					<div class="error">
						<p style="color:red"><%= error %></p>
					</div>
			<%	}%>			
			
			Assign one or more of the Classes (A1, A2, A3) to each teacher and press button "Assign".<br><br>
								 
			<table style="width:100%">
				<tr>
			    	<th>Teacher ID</th>
			    	<th>Teacher Surname</th>
			    	<th>Teacher Name</th>
			    	<th>Teaching Subject (TS)</th>
			    	<th>TS ID</th>
			    	<th>A1|A2|A3 (Class)</th>			    			    	
				</tr>
			  
		<%	for (Teacher teacher: teachers) { %>
				<tr>
				    <td><%= teacher.getId() %></td>
				    <td style="color:blue;"><b><%= teacher.getSurname() %></b></td>
				    <td style="color:blue;"><b><%= teacher.getName() %></b></td>
				    <td><%= teacher.specializationSubjectName() %></td>
				    <td><%= teacher.getSpecSubjectID() %></td>
				    
				    <%
				    int classID = teacher.getClassID();
				    boolean class_a1 = false, class_a2 = false, class_a3 = false;
				    switch (classID)
				    {
			    	case 1: class_a1 = false; class_a2 = false; class_a3 = true; break;
			    	case 10: class_a1 = false; class_a2 = true; class_a3 = false; break;
			    	case 11: class_a1 = false; class_a2 = true; class_a3 = true; break;
			    	case 100: class_a1 = true; class_a2 = false; class_a3 = false; break;
			    	case 101: class_a1 = true; class_a2 = false; class_a3 = true; break;
			    	case 110: class_a1 = true; class_a2 = true; class_a3 = false; break;
			    	case 111: class_a1 = true; class_a2 = true; class_a3 = true; break;
				    }
				    %>

				    <td>
					    <form action="AdminTeachersForClassPage" method="post">
						    <input type="checkbox" name="classID_a1" value="1" <% if (class_a1) %> checked> <% else %> >
						    <input type="checkbox" name="classID_a2" value="1" <% if (class_a2) %> checked> <% else %> >
						    <input type="checkbox" name="classID_a3" value="1" <% if (class_a3) %> checked> <% else %> >
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