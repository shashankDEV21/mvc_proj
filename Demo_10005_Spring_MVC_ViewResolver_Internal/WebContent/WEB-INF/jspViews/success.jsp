<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<h2>Login Successful</h2>
	<c:out value="${message}"></c:out><br>
	<a href="${pageContext.request.contextPath}/loadLogin.html">Home</a>
	<!-- way of giving the relative path properly so as to stop unnecessary url portion getting appended in URL-->
</center>
</body>
</html>