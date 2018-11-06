<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href='<c:url value="/resources/css/bootstrap-combined.css"/>' rel="stylesheet" />
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
	<title>Insert title here</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/user/orderflight"
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

	<table>
	<c:forEach items="${flights}" var="item">
			<tr>
				<td> <b>${item.getTakeoffDate()}</b></td>
				<td>&nbsp;&nbsp;&nbsp;to&nbsp; </td>
				<td><b>${destinationService.getDestinationName(item.getDestination())}</b></td>
			</tr>  	
	</c:forEach>
	</table>
</body>
</html>