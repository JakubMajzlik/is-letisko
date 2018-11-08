<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Letisko Jamnik - Admin panel</title>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
</head>
<body class="fill">
<t:onecol>
	<jsp:body>
		<h1>Admin Panel</h1>
		<br/>
		<a href="${pageContext.request.contextPath}/admin/manageusers">Manage users</a> <br/>
		<a href="${pageContext.request.contextPath}/admin/addplane">Add plane</a> <br/>
		<a href="${pageContext.request.contextPath}/admin/updateplane">Show planes</a> <br/>
		<br/>
	</jsp:body>
</t:onecol>
</body>
</html>