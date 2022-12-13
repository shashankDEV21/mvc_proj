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
<!-- method="POST" modelAttribute="customerBean" action="registration.html" -->
<form:form > <!-- Default request submission method is post, event if not mentioned -->
	
	<!-- use data given below -->
	<!-- 
	
			 Gender :
			  value="M" label="Male" 
			  value="F" label="Female" 
		
			 Customer Type :
				value="" label="--Select--"
				value="1" label="Silver" 
				value="2" label="Golden" 
				value="3" label="Platinum"

			Customer Services
			label="Mobile"     			value="MV"  
			label="Email"  				value="EV" 
			label="Special Services" value="SSV"
			
	
	 -->
	
</form:form>
</center>
</body>
</html>
