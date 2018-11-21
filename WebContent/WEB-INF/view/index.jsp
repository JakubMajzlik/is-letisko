<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
      /* Set the size of the div element that contains the map */
      #map {
        height: 400px;  /* The height is 400 pixels */
        width: 100%;  /* The width is the width of the web page */
       }
    </style>

<title>Jamnik Airport</title>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
		<h1>Jamnik Airport</h1><br>
		<h3>Today's flights:</h3>
		<c:if test="${!flights.isEmpty()}">
		<table class="table table-{1:striped|sm|bordered|hover|inverse} table-inverse table-responsive">
				<thead class="thead-inverse|thead-default">
						<tr>
							<th>Takeoff date</th>
							<th>Destination</th>
							<th>Distance</th>
							<th>Flight length</th>
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