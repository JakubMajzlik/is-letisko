<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Jamnik Airport - Login</title>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" /> 
</head>
<body class="fill">
<t:onecol>
	<jsp:body>
	<h1>Login</h1>
	<br/>
	<c:if test="${param.successfullyRegistred == true }">
		<h3>Registration was successfull, now you can login</h3>
	</c:if>
	<c:if test="${param.logout != null }" >
		<h3>You have been logged out </h3>
	</c:if>
	<form action="${pageContext.request.contextPath}/user/login/process" method="POST">
		Email: <input type="text" name="username" />
		<c:if test="${param.error != null}">
				Invalid Username or password 
			</c:if><br/>
		Password: <input type="password" name="password"/><form:errors path="password"/> <br/>
		<button type="submit" >Login</button>
		<input type="hidden"
								   name="${_csrf.parameterName}"
								   value="${_csrf.token}" />
	</form>
	</jsp:body>
</t:onecol>
</body>
</html>