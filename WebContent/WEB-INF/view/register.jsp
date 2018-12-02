<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<style>
	span[id*="errors"]{color:Red;}
	
</style>
<meta charset="UTF-8">
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" /> 
<title>Jamnik Airport - Register</title>
</head>
<body class="fill">
<t:onecol>
	<jsp:body>
<h1>Register</h1>
<br/>
<b class="text-danger">*</b> - Required field
<br><br>
<form:form action="${pageContext.request.contextPath}/user/register/process"
			method="POST" modelAttribute="userRegisterModel">
	<table>
		<tr>
		<td>First name:<b class="text-danger">*</b></td>
		<td><form:input path="firstName"/>
		<form:errors path="firstName"/></td>
		</tr>
		<tr>
		<td>Last name:<b class="text-danger">*</b></td>
		<td><form:input path="lastName"/>
		<form:errors path="lastName"/></td>
		</tr>
		<tr>
		<td>Email:<b class="text-danger">*</b></td>
		<td><form:input path="email"/>
		<form:errors path="email"/>
		<c:if test="${errorUserAlreadyExists == true }">
			<span id="errors_accexists">Account with this email already exists</span>
		</c:if>
		</td>
		</tr>
		<tr>
		<td>Password:<b class="text-danger">*</b></td>
		<td><form:password path="password1"/>
		<form:errors path="password1"/></td>
		</tr>
		<tr>
		<td>Confirm password:<b class="text-danger">*</b></td>
		<td><form:password path="password2"/>
		<form:errors path="password2"/></td>
		</tr>
		<tr>
		<td>Street:<b class="text-danger">*</b></td>
		<td><form:input path="street"/>
		<form:errors path="street"/></td>
		</tr>
		<tr>
		<td>House number:<b class="text-danger">*</b></td>
		<td><form:input path="houseNumber"/>
		<form:errors path="houseNumber"/></td>
		</tr>
		<tr>
		<td>ZIP:<b class="text-danger">*</b></td>
		<td><form:input path="zip"/>
		<form:errors path="zip"/></td>
		</tr>
		<tr>
		<td>City:<b class="text-danger">*</b></td>
		<td><form:input path="city"/>
		<form:errors path="city"/></td>
		</tr>
		<tr>
		<td>Country:<b class="text-danger">*</b></td>
		<td><form:select path="country">
				<form:options items="${countryList}"/>
				</form:select>
			<form:errors path="country"/></td>
		</tr>
		<tr>
		<td>Identification number:<b class="text-danger">*</b></td>
		<td><form:input path="identificationNumber"/>
		<form:errors path="identificationNumber"/></td>
		</tr>
		<tr>
		<td>Phone number:<b class="text-danger">*</b></td>
		<td><form:input path="phoneNumber"/>
		<form:errors path="phoneNumber"/></td>
		</tr>
	</table>
	<button type="submit">Register</button>
</form:form>
<a href="${pageContext.request.contextPath}/user/login">Already have an account? Log in</a>

</jsp:body>
</t:onecol>
</body>
</html>