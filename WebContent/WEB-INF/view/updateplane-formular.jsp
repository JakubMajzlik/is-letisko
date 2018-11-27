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
	<link href='<c:url value="/resources/css/gijgo.css"/>' rel="stylesheet" />
    <script type="text/javascript"
	     src='<c:url value="/resources/js/gijgo.js"/>'>
	</script> 
	<title>Jamnik Airport - Update plane</title>
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
	<h1>Update plane</h1>
	<br/>
	<form:form action="${pageContext.request.contextPath}/admin/updateplane/process"
			method="POST" modelAttribute="planeModel">
		Serial number: <br><form:input path="serialNumber"/><br>
		Type: <br><form:input path="type"/><br>
		Manufacturer: <br><form:input path="manufacturer"/><br>
		Date of made:
		<form:input path="dateOfMade" id="datepicker1" width="276" />
    	<script>
        	$('#datepicker1').datepicker({format:'dd/mm/yyyy'});
    	</script>
	    Last revision date:
		<form:input path="lastRevisionDate" id="datepicker2" width="276" />
    	<script>
        	$('#datepicker2').datepicker({format:'dd/mm/yyyy'});
    	</script>
		Number of seats in economic class: <br><form:input path="numberOfSeatsEconomic"/><br>
		Number of seats in business class: <br><form:input path="numberOfSeatsBusiness"/><br>
		Number of seats in first class: <br><form:input path="numberOfSeatsFirst"/><br>
		<button type="submit"> Save </button>
	</form:form>
</jsp:body>
</t:twocol>
</body>
</html>