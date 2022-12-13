<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<body>
	<center>
		<h2>Confirm Details Successful !!</h2>
		<hr>
		<h3 style="color: blue">${message}</h3>
		<table border="2">
			<tr>
				<td>User Name :</td>
				<td>${employeeBean.name}</td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td>${employeeBean.gender}</td>
			</tr>
			<tr>
				<td>Country :</td>
				<td>${employeeBean.country}</td>
			</tr>
			<tr>
				<td>About You :</td>
				<td>${employeeBean.aboutYou}</td>
			</tr>
		</table>
	</center>
</body>
</html>