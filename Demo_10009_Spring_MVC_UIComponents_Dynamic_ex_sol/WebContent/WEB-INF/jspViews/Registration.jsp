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
			<td>Customer Name :</td>
			<td><form:input path="customerName" /></td>
		</tr>
		<tr>
			<td>Secret Key :</td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td>Gender :</td>
			<td><form:radiobuttons path="gender"  items="${gender}"/></td>
		</tr>
		<tr>
			<td>Country :</td>
			<td><form:select path="customerType">
				<form:option value="" label="--Select--" />
				<form:options items="${customerTypeList}"/> <!-- 1st check this out for dynamic drop down  change to customerTypeListSameNameAndValue and observe-->
			</form:select></td>
		</tr>
		<tr>
			<td>Addtional Steps :</td>
			<td><form:textarea path="addtionalSteps" /></td>
		</tr>
		<tr>
			<td>Customer Services :</td>
			<td><form:checkboxes items="${customerServicesList}" path="customerServices"  /></td> <!--2 we use check boxes for dynamic  -->
		</tr>
		<tr>
			<td colspan="3"><form:checkbox path="homeDelivery" label="Home Delivery?" /></td> <!-- acts as boolean if value is not given -->
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="Register"></td>
		</tr>
	</table>
</form:form>
</center>
</body>
</html>