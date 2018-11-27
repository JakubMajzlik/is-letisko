<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
	<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
	<title>Jamnik Airport - All planes</title>
</head>
<body class="fill">
	
<t:twocol>
	<jsp:body>
	<h1>All planes</h1>
	<br/>
	<table class="table table-{1:striped|sm|bordered|hover|inverse} table-inverse table-responsive">
				<thead class="thead-inverse|thead-default">
						<tr>
							<th>Serial number</th>
							<th>Type</th>
							<th>Manufacturer</th>
							<th>Date of made</th>
							<th>Last revision</th>
						</tr>
				</thead>
				<tbody>
	<c:forEach items="${planes}" var="item">
			<tr>
				<td>${item.getSerialNumber()}</td>
				<td>${item.getType()} </td>
				<td>${item.getManufacturer()}</td>
				<td>${item.getDateOfMade()}</td>
				<td>${item.getLastRevisionDate()}</td>
				<td><a href="${pageContext.request.contextPath}/admin/updateplane?serialNumber=${item.getSerialNumber()}">Update</a></td>
			</tr>
			<tr>
				<td colspan="1"> Economic class:
				<i>${item.getNumberOfSeatsEconomic()}</i></td>
				<td></td>
				<td colspan="1"> Business class:
				<i>${item.getNumberOfSeatsBusiness()}</i></td>
				<td></td>
				<td colspan="1"> First class:
				<i>${item.getNumberOfSeatsFirst()}</i></td>
				<td></td>
				
			</tr>	
			<tr><td>&nbsp;</td></tr>
	</c:forEach>
	</table>
</jsp:body>
</t:twocol>
</body>
</html>