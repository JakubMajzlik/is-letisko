<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Jamnik Airport - Order confirmation</title>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
		<h1>Thank you for your purchase</h1>
		<h4>Your ticket id is <b>${id}</b></h4>
		You can 
		<a href="${pageContext.request.contextPath}/user/history/downloadticket?id=${id}">download your ticket here </a>
		or later in your order history.
	</jsp:body>
</t:twocol>
	

</body>
</html>