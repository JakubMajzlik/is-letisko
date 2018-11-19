<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
	<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
	<link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/css/bootstrap-datetimepicker.css"/>'/>
	<script type="text/javascript"
	     src='<c:url value="/resources/js/jquery.js"/>'>
	</script> 
	<script type="text/javascript"
	     src='<c:url value="/resources/js/bootstrap2.js"/>'>
	</script>
	<script type="text/javascript"
	     src='<c:url value="/resources/js/bootstrap-datetimepicker.js"/>'>
	</script>
	<script type="text/javascript"
	     src='<c:url value="/resources/locales/bootstrap-datetimepicker.sk.js"/>'>
	</script>
	<script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/css/gijgo.min.css" rel="stylesheet" type="text/css" />
	<title>Jamnik Airport - Find flights</title>
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
	<h1>Find flights</h1>
	<br/>
	<form:form action="${pageContext.request.contextPath}/flight/findflight"
			method="POST" modelAttribute="filterModel">
			
			Date:
		<form:input path="takeoffDate" id="datepicker" width="312" />
    	<script>
        	$('#datepicker').datepicker({format:'dd/mm/yyyy'});
    	</script>
	    
	    Destination: <br> 
		<form:select path="destination" >
			<form:option label="--Select Destination--" value="0"/>
			<form:options items="${destinationService.getAllDestinations()}"/>
		</form:select>
	    <br>
		<button type="submit"> Find flights </button>
	</form:form>

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
</jsp:body>
</t:twocol>
</body>
</html>