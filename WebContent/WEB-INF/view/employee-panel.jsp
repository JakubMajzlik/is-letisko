<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
<title>Jamnik Airport - Employee panel</title>
</head>
<body class="fill">
<t:onecol>
	<jsp:body>
	<h1>Employee Panel</h1>
	Name: ${user.details.firstName} ${user.details.lastName } <br/><br/>
	
	<a href="${pageContext.request.contextPath }/employee/addflight" >Add Flight</a> <br/>
	<a href="${pageContext.request.contextPath }/employee/updateflight" >Update Flight</a> <br/>
</jsp:body>
</t:onecol>
</body>
</html>