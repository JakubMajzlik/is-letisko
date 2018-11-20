<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
<title>Jamnik Airport - Edit user</title>
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
<form:form action="${pageContext.request.contextPath}/admin/manageusers/edit/save"
			method="POST" modelAttribute="userModel">
			
	<form:hidden path="password1"/>
	<form:hidden path="password2"/>
	<form:hidden path="id"/>
	<form:hidden path="email"/>
	
	First name:<form:input path="firstName"/>
	<form:errors path="firstName"/><br/>
	Last name:<form:input path="lastName"/>
	<form:errors path="lastName"/><br/>
	Street:<form:input path="street"/>
	<form:errors path="street"/><br/>
	House number:<form:input path="houseNumber"/>
	<form:errors path="houseNumber"/><br/>
	ZIP:<form:input path="zip"/>
	<form:errors path="zip"/><br/>
	City:<form:input path="city"/>
	<form:errors path="city"/><br/>
	Country:<form:select path="country">
			<form:options items="${countryList}"/>
			</form:select><br/>
	Identification number:<form:input path="identificationNumber"/>
	<form:errors path="identificationNumber"/><br/>
	Phone number:<form:input path="phoneNumber"/>
	<form:errors path="phoneNumber"/><br/>
	
	<button type="submit">Save</button>
</form:form>
</jsp:body>
</t:twocol>
</body>
</html>