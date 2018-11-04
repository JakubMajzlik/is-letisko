<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<table>
	<c:forEach items="${flights}" var="item">
			<tr>
				<td>Id </td>
				<td><b>${item.getId()}</b></td>
				<td> on</td>
				<td> <b>${item.getTakeoffDate()}</b></td>
				<td>to </td>
				<td><b>${destinationService.getDestinationName(item.getDestination())}</b></td>
				<td> by</td><td>
				<b>${item.getPlane()}</b></td>
				<td><a href="${pageContext.request.contextPath}/employee/updateflight?id=${item.getId()}">Update</a></td>
				<td><a href="${pageContext.request.contextPath}/employee/removeflight?id=${item.getId()}">Remove</a></td>
			</tr>  	
	</c:forEach>
	</table>
</body>
</html>