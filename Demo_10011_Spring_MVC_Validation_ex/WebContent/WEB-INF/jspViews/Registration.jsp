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
<form:form modelAttribute="customerBean" action="registration.html"> <!-- Default request submission method is post, event if not mentioned -->
	<table border="2">
		<tr>
			<td>Customer Name :</td>
			<td><form:input path="customerName" /></td>
			<td> <!-- error disp --></td> 
		</tr>
		<tr>
			<td>Secret Key :</td>
			<td><form:password path="password" /></td>
			<td> <!-- error disp --></td> 
		</tr>
		<tr>
			<td>Gender :</td>
			<td><form:radiobutton path="gender" value="M" label="Male" /> 
				<form:radiobutton path="gender" value="F" label="Female" /></td>
			<td> <!-- error disp --></td> 
		</tr>
		<tr>
			<td>Customer Type :</td>
			<td><form:select path="customerType">
				<form:option value="" label="--Select--"/>
				<form:option value="1" label="Silver" />
				<form:option value="2" label="Golden" />
				<form:option value="3" label="Platinum" />
			</form:select></td>
			<td> <!-- error disp --></td>
		</tr>
		<tr>
			<td>Additional Steps :</td>
			<td><form:textarea path="addtionalSteps" /></td>
			<td> <!-- error disp --></td> 
		</tr>
		<tr>
			<td>Customer Services :</td>
			<td><form:checkbox path="customerServices" label="Mobile"     			value="MV" /> 
				<form:checkbox path="customerServices" label="Email"  				value="EV" /> 
				<form:checkbox path="customerServices" label="Special Services"     value="SSV" /></td>
			<td> <!-- error disp --></td> 
				
		</tr>
		<tr>
			<td>Joining Date :</td>
			<td><form:input path="joiningDate"  /></td> 
			<td> <!-- error disp --></td>	
		</tr>
		<tr>
			<td>Age :</td>
			<td><form:input path="age"  /></td>
			<td> <!-- error disp --></td>
		</tr>
		<tr>
			<td>Bill :</td>
			<td><form:input path="bill" /></td>
			<td><form:errors path="bill"  cssClass="error"/></td>
		</tr>
		
		<tr>
			<td colspan="2"><form:checkbox path="homeDelivery" label="Home Delivery?" /></td>
			<td><form:errors path="homeDelivery"  cssClass="error"/></td> 
		</tr>
		
		<tr align="center">
			<td colspan="3"><input type="submit" value="Register"></td>
		</tr>
	</table>
	<!--  display all errors -->
</form:form>
</center>
</body>
</html>
