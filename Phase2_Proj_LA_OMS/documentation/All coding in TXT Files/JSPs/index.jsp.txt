<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<%
	//get global constants
	String COMPANY_NAME = pageContext.getServletContext().getInitParameter("COMPANY_NAME");
	String PAGE_FOOTER = pageContext.getServletContext().getInitParameter("PAGE_FOOTER");
	%>
	
	<div class="navbar">
		<ul>
			<li><a href = "index.jsp">Home</a></li>
			<li><a href = "#">*About</a></li>
			<li><a href = "#">*Classes</a></li>
			<li><a href = "#">*Projects</a></li>
			<li><a href = "#">*News</a></li>
			<li><a href = "#">*Contact</a></li>
			<li><a href = "LoginPage.jsp">Admin</a></li>
		</ul>
	</div>
	
	<h3><%= COMPANY_NAME %> | Home Page</h3>
	
	<div class="container">
		<h1>HERE IS THE HOME PAGE OF THE</h1>
		<h1>"<%= COMPANY_NAME.toUpperCase() %>" WEB SITE ...</h1>
		<br>Note that links with prefix star (*) in the navigation bar are non-operational;
		<br>they are only for demonstration purposes.<br>
	</div>
	
	<div>
		<br><font size="-2"><b><%= PAGE_FOOTER %></b></font>
	</div>

</body>
</html>