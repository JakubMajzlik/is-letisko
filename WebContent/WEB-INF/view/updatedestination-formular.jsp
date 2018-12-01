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
<title>Jamnik Airport - Update destination</title>
<style>
		span[id*="errors"]{color:Red;}
	
	</style>
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
	<h1>Update destination</h1>
	<br/>
	<form:form action="${pageContext.request.contextPath}/admin/updatedestination/process"
			method="POST" modelAttribute="destinationModel">
			
		<form:hidden path="id"/>
	<form:hidden path="distance"/>
	<table>
	<tr>
		<td>Airport name:</td>
		<td><form:input path="airport"/><form:errors path="airport"/></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><form:input path="city"/><form:errors path="city"/></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td>
			<form:select path="country">
				<form:options items="${countryList}"/>
				</form:select>
		</td>
	</tr>
	<tr>
		<td>Latitude:</td>
		<td><form:input path="latitude"/><form:errors path="latitude"/></td>
	</tr>
	<tr>
		<td>Longitude:</td>
		<td><form:input path="longitude"/><form:errors path="longitude"/></td>
	</tr>
	</table>
	<button type="submit"> Save </button>
	</form:form>
</jsp:body>	
</t:twocol>
</body>
</html>