<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">

	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.css"/>'>
	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/dataTables.css"/>'>

	<script type="text/javascript" language="javascript" src='<c:url value="/resources/js/jquery3.js"/>'></script>
	<script type="text/javascript" language="javascript" src='<c:url value="/resources/js/dataTables.js"/>'></script>
	<script type="text/javascript" language="javascript" src='<c:url value="/resources/js/dataTablesBootstrap.js"/>'></script>

	<script type="text/javascript" class="init">
		$(document).ready(function() {
			$('#flightTable').DataTable();
		} );
	</script>
	
	<title>Jamnik Airport - All flights</title>
</head>
<body class="fill">
	
<t:twocol>
	<jsp:body>
		<h1> All flights</h1>
		<br/>
		<c:if test="${param.addSuccess == true }" >
		<div class="alert alert-success d-inline-flex p-2">
	    	 Flight was added successfully 
	    </div>
		</c:if>
		<c:if test="${param.updateSuccess == true }" >
		<div class="alert alert-success d-inline-flex p-2">
	    	 Flight was updated successfully 
	    </div>
		</c:if>
		
		<table id="flightTable" class="table table-striped table-bordered">
				<thead>
						<tr>
							<th>Flight ID</th>
							<th>Takeoff date</th>
							<th>Destination</th>
							<th>Plane</th>
							<th>Actions</th>
						</tr>
				</thead>
				<tbody>
		<c:forEach items="${flights}" var="item" >
				<tr>
					<td><b>${item.getId()}</b></td>
					<td> <b>${item.getTakeoffDate()}</b></td>
					<td><b>${destinationService.getDestinationName(item.getDestination())}</b></td>
					<td><b>${item.getPlane()}</b></td>
					<td><a href="${pageContext.request.contextPath}/employee/showflights?id=${item.getId()}">Update</a>
					<button onclick="if (confirm('Are you sure you want to delete this user from the database?')) {
						window.location.href = '${pageContext.request.contextPath}/employee/removeflight?id=${item.getId()}';}" >Delete</button></td>
					
				</tr>  	
		</c:forEach>
		</tbody>
		</table>
		

	</jsp:body>
</t:twocol>
</html>