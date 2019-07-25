<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
html {
	background-color: #013243;
}

big {
	color: white;
	size: 25;
}

.logout {
	margin-left: 1200px;
	margin-top: 10px;
	width: 100px;
	height: 35px;
	border-radius: 10px;
	font-size: 17px;
	cursor: pointer;
	background-color: #555555;
	color: white;
}

h1 {
	size: 25px;
	color: white;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="logout">
		<input class="logout" type="submit" value="Log Out">
	</form>
	<center>
		<h1 class="logFont">${log}</h1>

		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			response.setHeader("Expires", "0");

			if (session.getAttribute("name") == null) {
				response.sendRedirect("loginPage.jsp");
			}
		%>
	</center>



</body>
</html>