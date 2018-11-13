<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
	<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
<%-- 	<link href='<c:url value="/resources/css/bootstrap-combined.css"/>' rel="stylesheet" /> --%>
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
		<div id="datetimepicker" class="input-append date">
	      <form:input path="takeoffDate" id="date"/>
	      <span class="add-on">
	        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
	      </span>
	    </div>
			
		<script type="text/javascript">
	      $('#datetimepicker').datetimepicker({
	        format: 'dd/MM/yyyy',
	        language: 'sk',
	        startDate: new Date()
	      });
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
						</tr>
				</thead>
				<tbody>
	<c:forEach items="${flights}" var="item">
			<tr>
				<td> <b>${item.getTakeoffDate()}</b></td>
				<td><b>${destinationService.getDestinationName(item.getDestination())}</b></td>
				<td><a href="${pageContext.request.contextPath}/flight/findflight?id=${item.getId()}">Order flight ticket</a></td>
			</tr>  	
	</c:forEach>
	</tbody>
	</table>
</jsp:body>
</t:twocol>
</body>
</html>