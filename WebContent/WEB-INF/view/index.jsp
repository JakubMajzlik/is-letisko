<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello world!</h1>
	
	<security:authorize access="!isAuthenticated()">
		<a href="${pageContext.request.contextPath }/user/login" >Login</a> <br/>
		<a href="${pageContext.request.contextPath }/user/register" >Register</a> <br/>
		<br/><br/>
		<a href="${pageContext.request.contextPath }/admin/addflight" >Add Flight</a> <br/>
		<a href="${pageContext.request.contextPath }/admin/updateflight?id=1" >Update Flight</a> <br/>
	</security:authorize>
	
	<security:authorize access="isAuthenticated()">
		<form:form method="POST" action="logout">
			<input type="submit" value="Logout"/>
		</form:form>
	</security:authorize>
	
</body>
</html>