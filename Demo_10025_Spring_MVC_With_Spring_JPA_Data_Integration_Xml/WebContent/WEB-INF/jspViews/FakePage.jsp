<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error{
color:#ff0000;
font-style:italic;
}
</style>
</head>
<body>
<center>
<h2>emp details</h2>
<form:form method="POST" modelAttribute="empObj" action="/loadUpdateEmployee2">
<br>
<table border="2">
<tr>
<td>Em id</td><td><form:input path="id" onchange="submit()"/></td>
</tr>
</table>
</form:form>

<c:if test="${not empty empobj2 message==null}">

</c:if>

</center>
</body>
</html>