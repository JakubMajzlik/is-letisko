<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
<title>Jamnik Airport - Edit user</title>
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
<c:if test="${param.cantDemote == true }" >
<div class="alert alert-danger d-inline-flex p-2">
   	 Employee cannot be demoted 
   </div>
</c:if>
<c:if test="${param.alreadyPromoted == true }" >
<div class="alert alert-danger d-inline-flex p-2">
   	 Admin cannot be promoted
   </div>
</c:if>
<c:if test="${param.cantPromote == true }" >
<div class="alert alert-danger d-inline-flex p-2">
   	 User cannot be promoted
   </div>
</c:if>
<form:form action="${pageContext.request.contextPath}/admin/manageusers/edit/save"
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

<br/><br/>
	<c:if test="${userRoles.size() == 1}">
	Role: User
	</c:if>
	<c:if test="${userRoles.size() == 2}">
	Role: Employee
	<form:form action="${pageContext.request.contextPath}/admin/promote?id=${param.id}"
			method="POST">
	<button type="submit">Promote</button>
	</form:form>
	</c:if>
	<c:if test="${userRoles.size() == 3}">
	Role: Admin
	<form:form action="${pageContext.request.contextPath}/admin/demote?id=${param.id}"
		method="POST">
	<button type="submit">Demote</button>
	</form:form>
	</c:if>

</jsp:body>
</t:twocol>
</body>
</html>