<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>

	<%
	//set a "no-cache" filter on this current (ToBe secured) JSP page
	response.addHeader("Pragma", "no-cache"); //HTTP 1.0.
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", 0); //Proxies		
	
	//get any parameters passed
	String username = (String) session.getAttribute("username");	

	if (username != null) {

		session.removeAttribute("username");
		session.invalidate();
		response.sendRedirect("LoginPage.jsp?error=Thanks for using our Online Managament System!");
	
	}
	else {
		response.sendRedirect("LoginPage.jsp");
	} %>
</body>
</html>