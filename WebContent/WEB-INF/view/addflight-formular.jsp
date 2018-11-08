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
<title>Add flight</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/employee/addflight/process"
			method="POST" modelAttribute="flightModel">
			
		<form:hidden path="id"/>
		
		Date:
		<div id="datetimepicker" class="input-append date">
	      <form:input path="takeoffDate" id="date"/>
	      <span class="add-on">
	        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
	      </span>
	    </div>
	
    <script type="text/javascript">
      $('#datetimepicker').datetimepicker({
        format: 'dd/MM/yyyy hh:mm',
        language: 'sk',
        startDate: new Date()
      });
    </script>
    	Gate:
    	<form:select path="gate">
    		<form:option label="--Select Gate--" value="0"/>
    		<form:options items="${gateService.getAllGates()}"/>
    	</form:select><br/>
		Destination: 
		<form:select path="destination" >
			<form:option label="--Select Destination--" value="0"/>
			<form:options items="${destinationService.getAllDestinations()}"/>
		</form:select>
		Plane:
		<form:select path="plane">
			<form:option label="--Select Plane--" value="0"/>
			<form:options items="${planeService.getPlanesMap()}"/>
		</form:select> <br/>

		<button type="submit"> Save </button>
	</form:form>
	
</body>
</html>