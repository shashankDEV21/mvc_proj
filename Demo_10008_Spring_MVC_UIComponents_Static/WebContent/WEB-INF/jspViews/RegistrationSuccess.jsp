<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<body>
${employeeBean.name}
	<center>
		<h2>Registration Successful !!</h2>
		<hr>
		<h3 style="color: blue">${message}</h3>
		<table border="2">
			<tr>
				<td>User Name :</td>
				<td>${employeeBean2.name}</td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td>${employeeBean2.gender}</td>
			</tr>
			<tr>
				<td>Country :</td>
				<td>${employeeBean2.country}</td>
			</tr>
			<tr>
				<td>About You :</td>
				<td>${employeeBean2.aboutYou}</td>
			</tr>
			<tr>
				<td>Community :</td>
				<td>${employeeBean2.community[0]}${employeeBean2.community[1]}
					${employeeBean2.community[2]}</td>
			</tr>
			<tr>
				<td>Mailing List:</td>
				<td>${employeeBean2.mailingList}</td>
			</tr>
		</table>
	</center>
</body>
</html>