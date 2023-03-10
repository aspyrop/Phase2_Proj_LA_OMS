<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="database.TeacherDatabase" %>
<%@ page import="database.SubjectDatabase" %>
<%@ page import="database.StudentDatabase" %>
<%@ page import="entity.Teacher" %>
<%@ page import="entity.Student" %>
<%@ page import="entity.Subject" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classes Report</title>
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
	
	List<Student> students1 = (List<Student>) request.getAttribute("students1");
	List<Student> students2 = (List<Student>) request.getAttribute("students2");
	List<Student> students3 = (List<Student>) request.getAttribute("students3");
	
	List<Subject> subjects1 = (List<Subject>) request.getAttribute("subjects1");
	List<Subject> subjects2 = (List<Subject>) request.getAttribute("subjects2");
	List<Subject> subjects3 = (List<Subject>) request.getAttribute("subjects3");
	
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
			<h1>Classes Report</h1>
			
			<%	if (error != null) {%>
					<div class="error">
						<p style="color:red"><%= error %></p>
					</div>
			<%	}%>			
			
			Full report of the Subjects, Teachers and Students, that are linked to
			each one of the classes A1, A2 and A3.<br>
			Note also that time table data have not been deployed in the DB
			since this was not required from the Project Specifications.<br><br>
			
			<table style="width:100%">
				<tr>
			    	<th>Class Name</th>
			    	<th>Timetable</th>	    			    	
			    	<th>Subject | Teacher</th>	    			    	
			    	<th>Students</th>
				</tr>
				
			<% for (int i=0;i<3;i++) {%>
				
					<tr>
				    	<td><b>Class - A<%= i+1 %></b></td>
				    	<td>Here timetable data<br>is displayed<br>per each subject</td>
				    	<td>
<!-- 				    	HERE WILL BE SUBJECTS & TEACHERS -->
							<% 
							List<Subject> theSubjects = subjects1;
							if (i == 1) theSubjects = subjects2;
							if (i == 2) theSubjects = subjects3;
							
							for (Subject subject: theSubjects) {
								out.println(subject.getSubjectName() + "<br>");
							} %>
				    	</td>	   
			    			    	
				    	<td>
<!-- 				    	HERE WILL BE ALL STUDENTS -->
							<% 
							List<Student> theStudents = students1;
							if (i == 1) theStudents = students2;
							if (i == 2) theStudents = students3;
							for (Student student: theStudents) {
								if (student.getMiddlename() == null)
									out.println(student.getSurname() + " " + student.getName() + " " + "<br>");
								else
									out.println(student.getSurname() + " " + student.getName() + " " + student.getMiddlename() + "<br>");
							} %>
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