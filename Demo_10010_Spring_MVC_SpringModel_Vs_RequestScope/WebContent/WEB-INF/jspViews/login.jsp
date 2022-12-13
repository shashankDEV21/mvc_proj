<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Login</h2>
<form:form method="post" modelAttribute="loginBean" action="validateLogin.html">

	<table>
	<tr>
		<td><label>Name</label></td>
		<td><form:input path="userName" type="text" /></td>  <!-- bind to loginBean.userName-->
	</tr>
	<tr>
		<td><label>Password</label></td>
		<td><form:input path="password" type="password"/></td> <!-- bind to loginBean.password-->
	</tr>
	
</table>	
	<input type="submit" value="Login"/>
</form:form>

</center>

</body>
</html>