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
<h1>Profile</h1>
<br/>
<c:if test="${param.profileChanged == true}">
	<div class="alert alert-success d-inline-flex p-2">
		Profile was seccessfully changed
	</div>
</c:if>
	
<form:form action="${pageContext.request.contextPath}/user/editprofile/save"
			method="POST" modelAttribute="userModel">
			
	<form:hidden path="password1"/>
	<form:hidden path="password2"/>
	<form:hidden path="id"/>
	<form:hidden path="email"/>
	<table>
	<tr>
		<td>First name:</td>
		<td><form:input path="firstName"/>
			<form:errors path="firstName"/></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><form:input path="lastName"/>
			<form:errors path="lastName"/></td>
	</tr>
	<tr>
		<td>Street:</td>
		<td><form:input path="street"/>
			<form:errors path="street"/></td>
	</tr>
	<tr>
		<td>House number:</td>
		<td><form:input path="houseNumber"/>
			<form:errors path="houseNumber"/></td>
	</tr>
	<tr>
		<td>ZIP:</td>
		<td><form:input path="zip"/>
			<form:errors path="zip"/></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><form:input path="city"/>
			<form:errors path="city"/></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><form:select path="country">
			<form:options items="${countryList}"/>
			</form:select></td>
	</tr>
	<tr>
		<td>Identification number:</td>
		<td><form:input path="identificationNumber"/>
			<form:errors path="identificationNumber"/></td>
	</tr>
	<tr>
		<td>Phone number:</td>
		<td><form:input path="phoneNumber"/>
			<form:errors path="phoneNumber"/></td>
	</tr>
	</table>
	<button type="submit">Save</button>
</form:form>

<c:if test="${param.passwordChanged == true}">
	<div class="alert alert-success d-inline-flex p-2">
		Password was seccessfully changed
	</div>
</c:if>

<form:form method="POST" action="${pageContext.request.contextPath}/user/editprofile/savepassword"
			modelAttribute="passwordModel">
			
	<form:hidden path="oldUserPassword"/>
	<form:hidden path="id"/>
	<form:errors path="newPassword"/>
	<c:if test="${passwordError == true}" >
		You entered wrong password <br/>
	</c:if>
	
	<table>
	<tr>
		<td>Old password:</td>	
		<td><form:password path="oldPassword"/></td>
	</tr>
	<tr>
		<td>New password:</td>	
		<td><form:password path="newPassword"/></td>
	</tr>
	<tr>
		<td>Repeat new password:</td>	
		<td><form:password path="newPassword2"/></td>
	</tr>
	</table>
	<button type="submit">Save</button>
</form:form>

</jsp:body>
</t:twocol>
</body>
</html>