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
	<script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/css/gijgo.min.css" rel="stylesheet" type="text/css" />
	<title>Jamnik Airport - Add Destination</title>
</head>
<body class="fill">

<t:twocol>
	<jsp:body>
	<h1>Add destination</h1>
	<br/>
	<form:form action="${pageContext.request.contextPath}/admin/adddestination/process"
		method="POST" modelAttribute="destinationModel">
		
	<form:hidden path="id"/>
	Country:<form:select path="country">
			<form:options items="${countryList}"/>
			</form:select><br>
	City:<form:input path="city"/><form:errors path="city"/><br>
	Distance:<form:input path="distance"/>km &nbsp;<form:errors path="distance"/><br>
	<button type="submit"> Save </button>
	</form:form>
</jsp:body>
</t:twocol>
</body>
</html>