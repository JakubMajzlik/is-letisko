<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Jamnik Airport - Order history</title>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/dataTables.css"/>'>

	<script type="text/javascript" src='<c:url value="/resources/js/jquery3.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/dataTables.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/dataTablesBootstrap.js"/>'></script>

	<script type="text/javascript" class="init">
		$(document).ready(function() {
			$('#ticketTable').DataTable();
		} );
	</script>
	
</head>
<body>
	<t:twocol>
		<jsp:body>
			<h1> Order history</h1>
			<br/>
			<table id="ticketTable" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Ticket ID</th>
					<th>Takeoff Date</th>
					<th>Destination</th>
					<th>Action</th>
				</tr>				
			</thead>
			<c:forEach items="${flightTickets}" var="item">
				<tr>
					<td><b>${item.getId()}</b></td>
					<td> ${flightService.getFlight(item.getFlight()).getTakeoffDate()}</td>
					<td> ${destinationService.getDestinationName(flightService.getFlight(item.getFlight()).getDestination())}</td>
					<td> <a href="${pageContext.request.contextPath}/user/history/downloadticket?id=${item.getId()}">Download ticket</a>
					<c:if test="${stornoMap.get(item.getId())}">
						<button onclick="if (confirm('Are you sure you want to storno this ticket?')) {
						window.location.href = '${pageContext.request.contextPath}/user/history/storno?id=${item.getId()}';}" >Storno</button>
					</c:if>
					</td>
				</tr>  	
			</c:forEach>
			</table>
		</jsp:body>
	</t:twocol>
</body>
</html>