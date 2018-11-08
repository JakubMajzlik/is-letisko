<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>All planes</title>
</head>
<body>
	<table>
	<c:forEach items="${planes}" var="item">
			<tr>
				<td> Serial Number:
				<b>${item.getSerialNumber()}</b>
				, Type:
				<b>${item.getType()}</b>
				, Manufacturer:
				<b>${item.getManufacturer()}</b>
				, Date of made:
				<b>${item.getDateOfMade()}</b>
				, Last revision date:
				<b>${item.getLastRevisionDate()}</b></td>
				<td><a href="${pageContext.request.contextPath}/admin/updateplane?serialNumber=${item.getSerialNumber()}">Update</a></td>
				<td><a href="${pageContext.request.contextPath}/admin/removeplane?serialNumber=${item.getSerialNumber()}">Remove</a></td>
			</tr>
			<tr>
				<td> Number of seats in economic class:
				<b>${item.getNumberOfSeatsEconomic()}</b>
				, Number of seats in business class:
				<b>${item.getNumberOfSeatsBusiness()}</b>
				, Number of seats in first class:
				<b>${item.getNumberOfSeatsFirst()}</b></td>
				
			</tr>	
			<tr><td>&nbsp;</td></tr>
	</c:forEach>
	</table>
</body>
</html>