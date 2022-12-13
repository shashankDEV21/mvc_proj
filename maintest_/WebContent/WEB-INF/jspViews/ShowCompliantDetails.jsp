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
<h2>Show Compliant Details</h2>
<form:form>
<c:if test="${not empty list}">
<table border="2">
<tr>
<th>Compliant Id</th><th>Customer Name</th><th>Compliant Type</th><th>Description</th><th>Date Of Incidence</th><th>Loss of Amount</th>
</tr>
<c:forEach var="var" items="${list}">
<tr>
<th>${var.compliantId}</th><th>${var.customerName}</th><th>${var.compliantTypeId}</th><th>${var.description}</th><th>${var.dateOfIncidence}</th><th>${var.amount}</th>
</tr>
</c:forEach>
</table>
</c:if>
<c:if test="${empty list}"> NO records Found...</c:if>
</form:form>
<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
</body>
</html>