<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Login</h2>

 <form:form method="POST"  modelAttribute= "loginbean" action ="validateLogin.htm">

	<!-- <table>
	<tr>
		<td><label>Name</label></td>
		<td><input type= "text" name="userName" /></td> 
	</tr>
	<tr>
		<td><label>Password</label></td>
		<td><input type="password" name="password" /></td>
	</tr>
	
</table>	
	<input type="submit" value="Login"/>
 -->
 Spring Form
Username: <form:input path="userName"/>
<br/>
Password: <form:input path="password"/>
<br/>
<input type="submit" value="Login">
 </form:form> 
<%-- 
<form method="post" action="validateLogin.html">

	<table>
	<tr>
		<td><label>Name</label></td>
		<td><input type= "text" name="userName" /></td> 
	</tr>
	<tr>
		<td><label>Password</label></td>
		<td><input type="password" name="password" /></td>
	</tr>
	
</table>	
	<input type="submit" value="Login"/>
</form> --%>



</center> 

</body>
</html>


