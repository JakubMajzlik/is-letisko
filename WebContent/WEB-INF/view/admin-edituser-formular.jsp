<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Edit user</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/admin/manageusers/edit/save"
			method="POST" modelAttribute="userModel">
			
	<form:hidden path="password1"/>
	<form:hidden path="password2"/>
	<form:hidden path="id"/>
	<form:hidden path="email"/>
	
	First name:<form:input path="firstName"/><br/>
	Last name:<form:input path="lastName"/><br/>
	Street:<form:input path="street"/><br/>
	House number:<form:input path="houseNumber"/><br/>
	ZIP:<form:input path="zip"/><br/>
	City:<form:input path="city"/><br/>
	Country:<form:input path="country"/><br/>
	Identification number:<form:input path="identificationNumber"/><br/>
	Phone number:<form:input path="phoneNumber"/><br/>
	
	<button type="submit">Save</button>
</form:form>

</body>
</html>