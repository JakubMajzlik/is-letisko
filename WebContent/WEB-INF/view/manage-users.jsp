<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
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
</body>
</html>