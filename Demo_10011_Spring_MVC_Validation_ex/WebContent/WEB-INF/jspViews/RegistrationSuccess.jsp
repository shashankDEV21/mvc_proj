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
		<h2>Registration Successful !!</h2>
		<hr>
		<h3 style="color: blue">${message}</h3>
		<table border="2">
			<tr>
				<td>Customer Name :</td>
				<td>${customerBean.customerName}</td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td>${customerBean.gender}</td>
			</tr>
			<tr>
				<td>Customer Type :</td>
				<td>${customerBean.customerType}</td>
			</tr>
			<tr>
				<td>Addtional Steps :</td>
				<td>${customerBean.addtionalSteps}</td>
			</tr>
			<tr>
				<td>CustomerServices :</td>
				<td>${customerBean.customerServices[0]}${customerBean.customerServices[1]}
					${customerBean.customerServices[2]}</td>
			</tr>
			<tr>
				<td>Home Delivery:</td>
				<td>${customerBean.homeDelivery}</td>
			</tr>
		</table>
	</center>
</body>
</html>