<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Jamnik Airport</title>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/dataTables.css"/>'>

	<script type="text/javascript" src='<c:url value="/resources/js/jquery3.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/dataTables.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/dataTablesBootstrap.js"/>'></script>

	<script type="text/javascript" class="init">
		$(document).ready(function() {
			$('#flightTable').DataTable();
		} );
	</script>
	
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
		<h1>Welcome on Jamnik Airport website</h1><br><br><br>
		<h3>Today's flights:</h3>
		<c:if test="${!flights.isEmpty()}">
		<table id="flightTable" class="table table-striped table-bordered">
				<thead>
						<tr>
							<th>Takeoff date</th>
							<th>Destination</th>
							<th>Distance</th>
							<th>Flight length</th>
							<th>Order</th>
						</tr>
				</thead>
				<tbody>
		<c:forEach items="${flights}" var="item">
				<tr>
					<td> <b>${item.getTakeoffDate()}</b></td>
					<td><b>${destinationService.getDestinationName(item.getDestination())}</b></td>
					<td><b>${destinationService.getDestinationDistance(item.getDestination())}km</b></td>
					<td><b><fmt:formatNumber
			  			value="${destinationService.getDestinationDistance(item.getDestination())/650}"
			  			maxFractionDigits="0"/>hod
			  			<fmt:formatNumber
			  			value="${destinationService.getDestinationDistance(item.getDestination())%650/650*60}"
			  			maxFractionDigits="0"/>min</b></td>
					<td><a href="${pageContext.request.contextPath}/flight/findflight?id=${item.getId()}">Order flight ticket</a></td>
				</tr>  	
		</c:forEach>
		</tbody>
		</table>
	</c:if>
	<c:if test="${flights.isEmpty()}">
		<b>No flights found for this date</b><br>
	</c:if>
	
	</jsp:body>
</t:twocol>
	

</body>
</html>