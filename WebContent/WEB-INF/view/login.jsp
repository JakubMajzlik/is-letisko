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
		<div class="alert alert-success d-inline-flex p-2">
			Registration was successful, now you can login
		</div>
	</c:if>
	<c:if test="${param.logout != null }" >
	<div class="alert alert-success d-inline-flex p-2">
    	 You have been successfully logged out.
 	</div>
	</c:if>
	<c:if test="${param.error != null}">
		<div class="alert alert-danger d-inline-flex p-2">
		Invalid email or password
		</div>
	</c:if><br/>
	<form action="${pageContext.request.contextPath}/user/login/process" method="POST">
		<table>
			<tr>
			<td>Email: </td>
			<td><input type="text" name="username" /></td>
			</tr>
			<tr>
			<td>Password:</td> 
			<td><input type="password" name="password"/><form:errors path="password"/></td>
			</tr>
		</table>
		<button type="submit" >Login</button>
		<input type="hidden"
								   name="${_csrf.parameterName}"
								   value="${_csrf.token}" />	
	
	</form>
	<a href="${pageContext.request.contextPath}/user/register">Don't have an account? Register for free</a>
	</jsp:body>
</t:onecol>
</body>
</html>