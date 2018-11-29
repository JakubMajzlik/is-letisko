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
	<title>Jamnik Airport - Add plane</title>
</head>
<body class="fill">
	
<t:twocol>
	<jsp:body>
	<h1>Add plane</h1>
	<br/>
	<form:form action="${pageContext.request.contextPath}/admin/addplane/process"
			method="POST" modelAttribute="planeModel">
		Serial number: <br><form:input path="serialNumber"/><br>
		Type: <br><form:input path="type"/><br>
		Manufacturer: <br><form:input path="manufacturer"/><br>
		Date of made:
		<form:input path="dateOfMade" id="datepicker1" width="276" readonly="true" />
    	<script>
    	var date = new Date();
        	$('#datepicker1').datepicker({
        		format:'yyyy/mm/dd',
        		maxDate:date,
        		});
    	</script>
	    Last revision date:
		<form:input path="lastRevisionDate" id="datepicker2" width="276" readonly="true" />
    	<script>
    	var date = new Date();
        	$('#datepicker2').datepicker({
        		format:'yyyy/mm/dd',
        		maxDate:date,
        		});
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