<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
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
	<title>Add plane</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/admin/addplane/process"
			method="POST" modelAttribute="planeModel">
		Serial number: <br><form:input path="serialNumber"/><br>
		Type: <br><form:input path="type"/><br>
		Manufacturer: <br><form:input path="manufacturer"/><br>
		Date of made:
		<div id="datetimepicker" class="input-append date">
	      <form:input path="dateOfMade"/>
	      <span class="add-on">
	        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
	      </span>
	    </div>
	    Last revision date:
		<div id="datetimepicker2" class="input-append date">
	      <form:input path="lastRevisionDate"/>
	      <span class="add-on">
	        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
	      </span>
	    </div>
		Number of seats in economic class: <br><form:input path="numberOfSeatsEconomic"/><br>
		Number of seats in business class: <br><form:input path="numberOfSeatsBusiness"/><br>
		Number of seats in first class: <br><form:input path="numberOfSeatsFirst"/><br>
	    <script type="text/javascript">
	      $('#datetimepicker').datetimepicker({
	        format: 'dd/MM/yyyy',
	        language: 'sk',
	      });
	    </script>
	    <script type="text/javascript">
	      $('#datetimepicker2').datetimepicker({
	        format: 'dd/MM/yyyy',
	        language: 'sk',
	      });
	    </script>
		<button type="submit"> Save </button>
	</form:form>
	
</body>
</html>