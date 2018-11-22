<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
<title>Jamnik Airport - Order flight</title>
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
	<h2>Summary</h2>
	Flight ID: ${id} <br> 
	Date: ${flightModel.getTakeoffDate()} <br>
	From: Jamnik, Slovakia <br>
	To: ${destinationService.getDestinationName(flightModel.getDestination())} <br>
	Flight length: <fmt:formatNumber
			  			value="${hours}"
			  			maxFractionDigits="0"/>hod
			  			<fmt:formatNumber
			  			value="${minutes}"
			  			maxFractionDigits="0"/>min <br>
	<h4><fmt:formatNumber
  		value="${flightModel.getPrice()*ticket_class}"
  		maxFractionDigits="2" 
  		minFractionDigits="2"/>€</h4>
  		
  	<br><br>
  	
  	<form:form action="${pageContext.request.contextPath}/flight/orderflight/process?class=${ticket_class}"
			method="POST" modelAttribute="flightModel">
		<form:hidden path="takeoffDate"/>
		<form:hidden path="destination"/>
		<form:hidden path="gate"/>
		<form:hidden path="plane"/>
		<form:hidden path="id"/>
		<form:hidden path="price"/>
		<button type=submit>Order</button>
	</form:form>
  	
	
</jsp:body>
</t:twocol>
</body>
</html>