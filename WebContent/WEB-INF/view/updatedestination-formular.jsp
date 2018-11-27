<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" /> 
<script type="text/javascript"
     src='<c:url value="/resources/js/jquery.js"/>'>
</script> 
<script type="text/javascript"
     src='<c:url value="/resources/js/bootstrap2.js"/>'>
</script>
<title>Jamnik Airport - Update destination</title>
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
	<form:form action="${pageContext.request.contextPath}/admin/updatedestination/process"
			method="POST" modelAttribute="destinationModel">
			
		<form:hidden path="id"/>
		
		City:
		<form:input path="City"/>
		<br>
		
		Country:
		<form:select path="country">
				<form:options items="${countryList}"/>
				</form:select>
		<br>
		
		Distance:
		<form:input path="Distance"/>
		<br>
		<button type="submit"> Save </button>
	</form:form>
</jsp:body>	
</t:twocol>
</body>
</html>