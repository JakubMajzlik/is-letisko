<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/dataTables.css"/>'>

	<script type="text/javascript" src='<c:url value="/resources/js/jquery3.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/dataTables.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/dataTablesBootstrap.js"/>'></script>

	<script type="text/javascript" class="init">
		$(document).ready(function() {
			$('#destinationTable').DataTable();
		} );
	</script>
	
	<title>Jamnik Airport - All destinations</title>
</head>
<body class="fill">
	
<t:twocol>
	<jsp:body>
		<h1> All destinations</h1>
		<br/>
	<c:if test="${param.updateSuccess == true }" >
	<div class="alert alert-success d-inline-flex p-2">
    	 Destination was updated successfully 
    </div>
	</c:if>
	<c:if test="${param.addSuccess == true }" >
	<div class="alert alert-success d-inline-flex p-2">
    	 Destination was added successfully 
    </div>
	</c:if>
		<table id="destinationTable" class="table table-striped table-bordered">
				<thead >
						<tr>
							<th>Destination ID</th>
							<th>Airport</th>
							<th>City</th>
							<th>Country</th>
							<th>Update</th>
						</tr>
				</thead>
				<tbody>
		<c:forEach items="${destinations}" var="item">
				<tr>
					<td><b>${item.getId()}</b></td>
					<td><b>${item.getAirport()}</b></td>
					<td> <b>${item.getCity()}</b></td>
					<td><b>${item.getCountry()}</b></td>
					<td><a href="${pageContext.request.contextPath}/admin/updatedestination?id=${item.getId()}">Update</a></td>
				</tr>  	
		</c:forEach>
		</tbody>
		</table>
	</jsp:body>
</t:twocol>
</html>