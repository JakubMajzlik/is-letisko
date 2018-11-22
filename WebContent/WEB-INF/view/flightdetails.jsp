<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
<title>Jamnik Airport -Flight details</title>
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
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
	
	<table border=1>
	<tr>
		<td>Economic: &nbsp;&nbsp;&nbsp;</td>
		<td>Business: &nbsp;&nbsp;&nbsp;</td>
		<td>First: &nbsp;&nbsp;&nbsp;</td>
	</tr>
	<tr>
		<td>${economic} </td>
		<td>${business} </td>
		<td> ${first}</td>
	</tr>
	<tr>
		<td><fmt:formatNumber
	  		value="${flightModel.price}"
	  		maxFractionDigits="2" 
	  		minFractionDigits="2"/>€</td>
		<td><fmt:formatNumber
	  		value="${flightModel.price*2}"
	  		maxFractionDigits="2"
			minFractionDigits="2"/>€</td>	
		<td><fmt:formatNumber
	  		value="${flightModel.price*3}"
	  		maxFractionDigits="2"
  			minFractionDigits="2"/>€</td>
  	</tr>
  	<tr>
  		
  		<td>
  			<c:if test="${economic>0}">
  				<form:form action="${pageContext.request.contextPath}/flight/orderflight?class=1"
				method="POST" modelAttribute="flightModel">
					<form:hidden path="takeoffDate"/>
					<form:hidden path="destination"/>
					<form:hidden path="gate"/>
					<form:hidden path="plane"/>
					<form:hidden path="id"/>
					<form:hidden path="price"/>
					<button type=submit>Order</button>
				</form:form>
  			</c:if>
  			<c:if test="${economic<=0}">
  				Sold out		
  			</c:if>
  		</td>
  		<td><c:if test="${business>0}">
  				<form:form action="${pageContext.request.contextPath}/flight/orderflight?class=2"
				method="POST" modelAttribute="flightModel">
					<form:hidden path="takeoffDate"/>
					<form:hidden path="destination"/>
					<form:hidden path="gate"/>
					<form:hidden path="plane"/>
					<form:hidden path="id"/>
					<form:hidden path="price"/>
					<button type=submit>Order</button>
				</form:form>
  			</c:if>
  			<c:if test="${business<=0}">
  				Sold out		
  			</c:if>
  		</td>
  		<td><c:if test="${first>0}">
  				<form:form action="${pageContext.request.contextPath}/flight/orderflight?class=3"
				method="POST" modelAttribute="flightModel">
					<form:hidden path="takeoffDate"/>
					<form:hidden path="destination"/>
					<form:hidden path="gate"/>
					<form:hidden path="plane"/>
					<form:hidden path="id"/>
					<form:hidden path="price"/>
					<button type=submit>Order</button>
				</form:form>
  			</c:if>
  			<c:if test="${first<=0}">
  				Sold out		
  			</c:if>
  		</td>
  	</tr>
	</table>
</jsp:body>
</t:twocol>
</body>
</html>