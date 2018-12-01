<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Jamnik Airport - Manage users</title>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/dataTables.css"/>'>

	<script type="text/javascript" src='<c:url value="/resources/js/jquery3.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/dataTables.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/dataTablesBootstrap.js"/>'></script>

	<script type="text/javascript" class="init">
		$(document).ready(function() {
			$('#userTable').DataTable();
		} );
	</script>
	
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
	<h1>Manage users</h1>
	<br/>
	<c:if test="${param.updateSuccess == true }" >
	<div class="alert alert-success d-inline-flex p-2">
    	 User profile was updated successfully 
    </div>
	</c:if>
	<c:if test="${param.deleteSuccess == true }" >
	<div class="alert alert-success d-inline-flex p-2">
    	 User profile was deleted successfully 
    </div>
	</c:if>
	<c:if test="${param.enableSuccess == true }" >
	<div class="alert alert-success d-inline-flex p-2">
    	 User profile was enabled successfully 
    </div>
	</c:if>
	<c:if test="${param.disableSuccess == true }" >
	<div class="alert alert-success d-inline-flex p-2">
    	 User profile was disabled successfully 
    </div>
	</c:if>
	<c:if test="${param.registeredSuccess == true }" >
	<div class="alert alert-success d-inline-flex p-2">
    	 New employee was registered successfully 
    </div>
	</c:if>
<table id="userTable" class="table table-striped table-bordered">
	<thead >
			<tr>
				<th>First name</th>
				<th>Last name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
	</thead>
	<tbody>
	<c:forEach items="${usersList}" var="user" >
	
		<tr>
			<td>${user.getDetails().firstName} </td>
			<td>${user.getDetails().lastName} </td>
			<td>${user.getDetails().email} </td>
			<td><button onclick="window.location.href = '${pageContext.request.contextPath}/admin/manageusers/edituser?id=${user.id}';">Edit</button>
			<button onclick="if (confirm('Are you sure you want to delete this user from the database?')) {
						window.location.href = '${pageContext.request.contextPath}/admin/manageusers/deleteuser?id=${user.id}';}" >Delete</button>
			<c:if test="${user.isEnabled() == true}">
				<button onclick="window.location.href = '${pageContext.request.contextPath}/admin/manageusers/disableuser?id=${user.id}';">Disable</button>
			</c:if>
			<c:if test="${user.isEnabled() == false}">
				<button onclick="window.location.href = '${pageContext.request.contextPath}/admin/manageusers/enableuser?id=${user.id}';">Enable</button>
			</c:if>
			</td>
		</tr>

	</c:forEach>
	</tbody>
</table>
</jsp:body>
</t:twocol>
</body>
</html>