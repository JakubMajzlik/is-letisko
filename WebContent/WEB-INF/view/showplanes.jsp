<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
	<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/dataTables.css"/>'>

	<script type="text/javascript" src='<c:url value="/resources/js/jquery3.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/dataTables.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/dataTablesBootstrap.js"/>'></script>

	<script type="text/javascript" class="init">
		$(document).ready(function() {
			$('#planeTable').DataTable();
		} );
	</script>
	
	<title>Jamnik Airport - All planes</title>
</head>
<body class="fill">
	
<t:twocol>
	<jsp:body>
	<h1>All planes</h1>
	<br/>
	<c:if test="${param.updateSuccess == true }" >
	<div class="alert alert-success d-inline-flex p-2">
    	 Plane was updated successfully 
    </div>
	</c:if>
	<c:if test="${param.addSuccess == true }" >
	<div class="alert alert-success d-inline-flex p-2">
    	 Plane was added successfully 
    </div>
	</c:if>
	<table id="planeTable" class="table table-striped table-bordered">
				<thead class="thead-inverse|thead-default">
						<tr>
							<th>Serial number</th>
							<th>Type</th>
							<th>Manufacturer</th>
							<th>Date of made</th>
							<th>Last revision</th>
							<th>Update</th>
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
	</c:forEach>
	</table>
</jsp:body>
</t:twocol>
</body>
</html>