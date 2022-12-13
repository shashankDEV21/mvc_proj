<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
</head>
<body>
<center>
<h2>Customer Registration</h2>
<form:form method="POST" commandName="customerBean" action="registration.html">
	<table border="2">
		<tr>
		<td>Customer Name:</td>
		<td><form:input path="customerName"/></td>
		</tr>
		<tr>
		<td>Password:</td>
		<td><from:password path="password"/></td>
		</tr>
		<tr>
		<td>Gender:</td>
		<td><form:radiobuttons path="gender" /></td>
		</tr>
	</table>
</form:form>
</center>
</body>
</html>