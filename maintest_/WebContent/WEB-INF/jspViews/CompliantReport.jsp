<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="daterange" method="POST" action="showdetails.html">
<table>
<tr>
<td>
From Date [dd-MMM-yyyy] </td> <td><form:input path="fromDate"/></td>
</tr>
<tr>
<td>
To Date [dd-MMM-yyyy] </td> <td><form:input path="toDate"/></td>
</tr>

</table>
<input type="submit" value="Fetch">
</form:form>
<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
</body>
</html>