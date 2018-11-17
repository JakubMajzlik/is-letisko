<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
	<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
	<script type="text/javascript"
	     src='<c:url value="/resources/js/jquery.js"/>'>
	</script> 
	<script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/css/gijgo.min.css" rel="stylesheet" type="text/css" />
	<title>Jamnik Airport - Add flight</title>
</head>
<body class="fill">

<t:twocol>
	<jsp:body>
	<h1>Add flight</h1>
	<br/>
	<form:form action="${pageContext.request.contextPath}/employee/addflight/process"
		method="POST" modelAttribute="flightModel">
		
	<form:hidden path="id"/>
	Date:
	<form:input path="takeoffDate" id="input" width="312" />
   	<script>
       	$('#input').datetimepicker({ footer: true, modal: true, format: 'dd/mm/yyyy HH:MM'});
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
</jsp:body>
</t:twocol>
</body>
</html>