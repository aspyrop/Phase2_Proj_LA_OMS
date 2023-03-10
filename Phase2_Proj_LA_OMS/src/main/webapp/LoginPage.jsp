<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<%
	//get global constants
	String COMPANY_NAME = pageContext.getServletContext().getInitParameter("COMPANY_NAME");
	String PAGE_FOOTER = pageContext.getServletContext().getInitParameter("PAGE_FOOTER");
	
	//get any parameters passed
	String error = request.getParameter("error");
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

	<h3><%= COMPANY_NAME %> | OnLine Management System</h3>
	<h1>Administrator's Login</h1>

	<%	if (error != null) {%>
			<div class="error">
				<p style="color:red">Error! <%= error %></p>
			</div>
	<%	}%>
		
	<div class="loginform">
		<form action = "LoginPage" method = "post">
			<input type="text" class="az" id="username" size=30 name="username" placeholder="Enter user name"/><br><br>
			<input type="password" class="az" id="password" size=30 name="password" placeholder="Enter password"/><br><br>
			<input type="submit" class="submitLoginButton" value="Login"/><br><br>
		</form>
	</div>

	<p>For educational/testing purposes use:<br>
		Username = <b>agis</b> | Password = <b>123</b></p>

	<div>
		<br><font size="-2"><b><%= PAGE_FOOTER %></b></font>
	</div>
	
</body>
</html>