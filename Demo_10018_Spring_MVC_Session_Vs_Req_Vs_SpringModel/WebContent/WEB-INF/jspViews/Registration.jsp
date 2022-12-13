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
<h2>Employee Registration</h2>
<form:form method="POST" modelAttribute="employeeBean" action="registration.html">
	<table border="2">
		<tr>
			<td>Employee Name :</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Secret Key :</td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td>Gender :</td>
			<td><form:radiobutton path="gender" value="M" label="Male" /> 
				<form:radiobutton path="gender" value="F" label="Female" /></td>
		</tr>
		<tr>
			<td>Country :</td>
			<td><form:select path="country">
				<form:option value="" label="--Select--" />
				<form:option value="1" label="India" />
				<form:option value="2" label="USA" />
				<form:option value="3" label="UK" />
			</form:select></td>
		</tr>
		<tr>
			<td>About you :</td>
			<td><form:textarea path="aboutYou" /></td>
		</tr>
		<tr>
			<td>Community :</td>
			<td><form:checkbox path="community" value="SpringV"     label="SpringL" /> 
				<form:checkbox path="community" value="HibernateV"  label="HibernateL" /> 
				<form:checkbox path="community" value="StrutsV"     label="StrutsL" /></td>
		</tr>
		<tr>
			<td colspan="3"><form:checkbox path="mailingList" label="Would you like to join our mailinglist?" /></td> <!-- when used without value acts as boolean check box-->
		</tr>
		<tr align="center">
			<td colspan="3"><input type="submit" value="Register"></td>
		</tr>
	</table>
</form:form>
</center>
</body>
</html>
