<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
	<title>Jamnik Airport - All flights</title>
</head>
<body class="fill">
	
<t:twocol>
	<jsp:body>
		<h1> All flights</h1>
		<br/>
		<table class="table table-{1:striped|sm|bordered|hover|inverse} table-inverse table-responsive">
				<thead class="thead-inverse|thead-default">
						<tr>
							<th>Flight ID</th>
							<th>Takeoff date</th>
							<th>Destination</th>
							<th>Plane</th>
						</tr>
				</thead>
				<tbody>
		<c:forEach items="${flights}" var="item">
				<tr>
					<td><b>${item.getId()}</b></td>
					<td> <b>${item.getTakeoffDate()}</b></td>
					<td><b>${destinationService.getDestinationName(item.getDestination())}</b></td>
					<td><b>${item.getPlane()}</b></td>
					<td><a href="${pageContext.request.contextPath}/employee/showflights?id=${item.getId()}">Update</a></td>
					<td><button onclick="if (confirm('Are you sure you want to delete this user from the database?')) {
						window.location.href = '${pageContext.request.contextPath}/employee/removeflight?id=${item.getId()}';}" >Delete</button></td>
				</tr>  	
		</c:forEach>
		</tbody>
		</table>
	</jsp:body>
</t:twocol>
</html>