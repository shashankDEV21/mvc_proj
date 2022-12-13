<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dummy Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
<h2>File Compliant</h2>

<form:form modelAttribute="cbean" method="POST" action="processform.html">
<table>
<tr>
<td>Customer Name: </td><td><form:input path ="customerName"/></td>
<td><form:errors cssClass="error" path="customerName" /></td>
</tr>
<tr>
<td>Compliant Type: </td><td><form:select path ="compliantTypeId">
         <form:option value="" label="--select--"/>
         <form:options items="${types}"/>
         </form:select>
</td>
<td><form:errors cssClass="error" path="compliantTypeId" /></td>
</tr>
<tr>
<td>Description : </td><td><form:input path ="description"/></td>
<td><form:errors cssClass="error" path="description" /></td>
</tr>
<tr>
<td>Date Of Incidence <br>[dd-MMM-yyyy]: </td><td><form:input path ="dateOfIncidence"/></td>
<td><form:errors cssClass="error" path="dateOfIncidence" /></td>
</tr>
<tr>
<td>Total loss of amount <br> from this incidence : </td><td><form:input path ="damount"/></td>
<td><form:errors cssClass="error" path="amount" /></td>
</tr>
</table>
<input type="submit" value="Submit"/>
</form:form>
<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
	</center>
</body>
</html>