<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	  		maxFractionDigits="2" /></td>
		<td><fmt:formatNumber
	  		value="${flightModel.price*2}"
	  		maxFractionDigits="2" /></td>
		<td><fmt:formatNumber
	  		value="${flightModel.price*3}"
	  		maxFractionDigits="2" /></td>
  	</tr>
  	<tr>
  		<td><a href="${pageContext.request.contextPath}/flight">Buy</a></td>
  		<td><a href="${pageContext.request.contextPath}/flight">Buy</a></td>
  		<td><a href="${pageContext.request.contextPath}/flight">Buy</a></td>
  	</tr>
	</table>
</jsp:body>
</t:twocol>
</body>
</html>