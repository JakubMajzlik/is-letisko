<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Jamnik Airport - Manage users</title>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
<table>
	<c:forEach items="${usersList}" var="user" >
	
		<tr>
			<td>${user.getDetails().firstName} </td>
			<td>${user.getDetails().lastName} </td>
			<td>${user.getDetails().email} </td>
			<td><button onclick="window.location.href = '${pageContext.request.contextPath}/admin/manageusers/edituser?id=${user.id}';">Edit</button></td>
			<td><button onclick="if (confirm('Are you sure you want to delete this thing into the database?')) {
						window.location.href = '${pageContext.request.contextPath}/admin/manageusers/deleteuser?id=${user.id}';}" >Delete</button></td>
		</tr>

	</c:forEach>
</table>
</jsp:body>
</t:twocol>
</body>
</html>