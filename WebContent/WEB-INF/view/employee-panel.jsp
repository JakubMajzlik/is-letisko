<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee Panel</h1>
	Name: ${user.details.firstName} ${user.details.lastName } <br/><br/>
	
	<a href="${pageContext.request.contextPath }/employee/addflight" >Add Flight</a> <br/>
	<a href="${pageContext.request.contextPath }/employee/updateflight" >Update Flight</a> <br/>
</body>
</html>