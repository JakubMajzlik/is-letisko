<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Jamnik Airport - Order history</title>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
</head>
<body>
	<t:twocol>
		<jsp:body>
			<h1> Order history</h1>
			<br/>
			<table class="table table-{1:striped|sm|bordered|hover|inverse} table-inverse table-responsive">
			<c:forEach items="${flightTickets}" var="item">
				<tr>
					<td><b>${item.getId()}</b></td>
					<td> ${flightService.getFlight(item.getFlight()).getTakeoffDate()}</td>
					<td> ${destinationService.getDestinationName(flightService.getFlight(item.getFlight()).getDestination())}</td>
					<td> <a href="${pageContext.request.contextPath}/user/history/downloadticket?id=${item.getId()}">Download ticket</a></td>
					<c:if test="${stornoMap.get(item.getId())}">
						<td><button onclick="if (confirm('Are you sure you want to storno this ticket?')) {
						window.location.href = '${pageContext.request.contextPath}/user/history/storno?id=${item.getId()}';}" >Storno</button></td>
					</c:if>
				</tr>  	
			</c:forEach>
			</table>
		</jsp:body>
	</t:twocol>
</body>
</html>