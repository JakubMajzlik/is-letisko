<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" /> 
<title>Jamnik Airport - Register</title>
</head>
<body class="fill">
<t:onecol>
	<jsp:body>
<h1>Register</h1>
<br/>
<form:form action="${pageContext.request.contextPath}/user/register/process"
			method="POST" modelAttribute="userRegisterModel">
	First name:<form:input path="firstName"/>
	<form:errors path="firstName"/><br/>
	Last name:<form:input path="lastName"/>
	<form:errors path="lastName"/><br/>
	Email:<form:input path="email"/>
	<form:errors path="email"/><br/>
	Password:<form:password path="password1"/>
	<form:errors path="password1"/><br/>
	Confirm password:<form:password path="password2"/>
	<form:errors path="password2"/><br/>
	Street:<form:input path="street"/>
	<form:errors path="street"/><br/>
	House number:<form:input path="houseNumber"/>
	<form:errors path="houseNumber"/><br/>
	ZIP:<form:input path="zip"/>
	<form:errors path="zip"/><br/>
	City:<form:input path="city"/>
	<form:errors path="city"/><br/>
	Country:<form:input path="country"/>
	<form:errors path="country"/><br/>
	Identification number:<form:input path="identificationNumber"/>
	<form:errors path="identificationNumber"/><br/>
	Phone number:<form:input path="phoneNumber"/>
	<form:errors path="phoneNumber"/><br/>
	
	<button type="submit">Register</button>
</form:form>
<a href="">aaa</a>
</jsp:body>
</t:onecol>
</body>
</html>