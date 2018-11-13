<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
<title>Jamnik Airport - Order flight</title>
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
	Plane: ${flightModel.plane} <br>
	Economic: ${economic} <br>
	Business: ${business} <br>
	First: ${first} <br>
</jsp:body>
</t:twocol>
</body>
</html>