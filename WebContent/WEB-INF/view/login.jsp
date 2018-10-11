<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login</h1>
<form:form action="/user/login/process" method="POST" modelAttribute="userLoginModel">
	Email: <form:input path="email"/> <br/>
	Password: <form:password path="password"/> <br/>
	<input type="submit" value="register"/>
</form:form>
</body>
</html>