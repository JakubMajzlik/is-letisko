<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
	<title>Jamnik Airport - All destinations</title>
</head>
<body class="fill">
	
<t:twocol>
	<jsp:body>
		<h1> All destinations</h1>
		<br/>
		<table class="table table-{1:striped|sm|bordered|hover|inverse} table-inverse table-responsive">
				<thead class="thead-inverse|thead-default">
						<tr>
							<th>Destination ID</th>
							<th>City</th>
							<th>Country</th>
							<th>Distance</th>
						</tr>
				</thead>
				<tbody>
		<c:forEach items="${destinations}" var="item">
				<tr>
					<td><b>${item.getId()}</b></td>
					<td> <b>${item.getCity()}</b></td>
					<td><b>${item.getCountry()}</b></td>
					<td><b>${item.getDistance()}</b></td>
					<td><a href="${pageContext.request.contextPath}/admin/updatedestination?id=${item.getId()}">Update</a></td>
				</tr>  	
		</c:forEach>
		</tbody>
		</table>
	</jsp:body>
</t:twocol>
</html>