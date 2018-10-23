<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<h1>Register</h1>

<form:form action="${pageContext.request.contextPath}/user/register/process"
			method="POST" modelAttribute="userRegisterModel">
	First name:<form:input path="firstName"/><br/>
	Last name:<form:input path="lastName"/><br/>
	Email:<form:input path="email"/><br/>
	Password:<form:password path="password1"/><br/>
	Confirm password:<form:password path="password2"/><br/>
	Street:<form:input path="street"/><br/>
	House number:<form:input path="houseNumber"/><br/>
	ZIP:<form:input path="zip"/><br/>
	City:<form:input path="city"/><br/>
	Country:<form:input path="country"/><br/>
	Identification number:<form:input path="identificationNumber"/><br/>
	Phone number:<form:input path="phoneNumber"/><br/>
	
	<button type="submit">Register</button>
</form:form>

</body>
</html>