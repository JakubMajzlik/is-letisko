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
<title>Jamnik Airport - Update flight</title>
<style>
	span[id*="errors"]{color:Red;}
	
</style>
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
	<h1>Update flight</h1>
	<br/>
	<form:form action="${pageContext.request.contextPath}/employee/updateflight/process"
			method="POST" modelAttribute="flightModel">
				
	<form:hidden path="id"/>
	Date:<form:errors path="takeoffDate" />
	<form:input path="takeoffDate" id="input" width="312" readonly="true" />
   	<script>
    	var date = new Date();
    	date.setDate(date.getDate()-1);
        	$('#input').datetimepicker({format:'yyyy/mm/dd HH:MM', 
        	datepicker:{minDate:date}});
    </script>
   	
   	Gate:
   	<form:select path="gate">
   		<form:options items="${gateService.getAllGates()}"/>
   	</form:select><form:errors path="gate" /><br/>
	Destination: 
	<form:select path="destination" >
		<form:options items="${destinationService.getAllDestinations()}"/>
	</form:select><form:errors path="destination" /><br/>
	Plane:
	<form:select path="plane">
		<form:options items="${planeService.getPlanesMap()}"/>
	</form:select><form:errors path="plane" /> <br/>
	Price:
	<form:input path="price"/>€<form:errors path="price" /><br>

	<button type="submit"> Save </button>

	</form:form>
</jsp:body>	
</t:twocol>
</body>
</html>