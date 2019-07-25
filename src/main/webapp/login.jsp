<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>

html {
	background-color: #013243;
}

big{
 color: white;
 size: 25;

}

.logout{
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

.idField {
	margin-left: 20px;
	margin-top: 20px;
	width: 230px;
	height: 25px;
	border-radius: 6px;
}

.nameField {
	margin-left: 0px;
	margin-top: 6px;
	width: 230px;
	height: 25px;
	border-radius: 6px;
}

.button {
	margin-left: 40px;
	margin-top: 15px;
	background-color: #555555;
	border-radius: 12px;
 	border: none;
  	color: white;
  	padding: 15px 32px;
  	text-align: center;
  	text-decoration: none;
  	display: inline-block;
  	font-size: 16px;
  	cursor: pointer;
}

.line {
	margin-left: 400px;
	margin-right: 350px;
}

.formClass {
	margin-top: 000px;
}

.techField{
	margin-left: 10px;
	margin-top: 6px;
	width: 230px;
	height: 25px;
	border-radius: 6px;
}
</style>

<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>Home Page</title>
</head>
<body>

	<%
	
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setHeader("Expires", "0");
	
		if (session.getAttribute("name") == null) {
			response.sendRedirect("loginPage.jsp");
		}
	%>
	
	<form action="logout">
	<input class="logout" type="submit"  value="Log Out">
	</form>

	<center />
	<form action="addAlien" class="formClass">
		<big/>ID <input type="text" name="id" class="idField"><br /> 
		Name <input type="text" name="name" class="nameField"><br />
		Tech	<input type="text" name="tech" class="techField"><br /> 
		<input	type="submit" value="Insert Student Info" class="button">
	</form>

	<br />
	<hr class="line">
	<br />

	<form action="getAlien">
		ID <input type="text" name="id" class="idField"><br /> 
		<input	type="submit" value="Get Student Info" class="button">
	</form>

	<br />
	<hr class="line">
	<br />

	<form action="updateAlien">
		ID <input type="text" name="id" class="idField"><br /> 
		Name <input type="text" name="name" class="nameField"><br /> 
		Tech	<input type="text" name="tech" class="techField"><br />
		<input type="submit" value="Update Student Info" class="button">
	</form>

	<br />
	<hr class="line">
	<br />

	<form action="deleteAlien">
		ID <input type="text" name="id" class="idField"><br />
		 <input type="submit" value="Delete Student Info" class="button">
	</form>
	
	<br />
	<hr class="line">
	<br />
	
	<form action="allAlien">
		 <input type="submit" value="All Student Info" class="button">
	</form>
	
	<br />
	<hr class="line">
	<br />

</body>
</html>