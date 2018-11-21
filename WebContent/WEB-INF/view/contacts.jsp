<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Jamnik Airport - Contacts</title>
<link href='<c:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
</head>
<body class="fill">
<t:twocol>
	<jsp:body>
		<h1>Contact</h1>
		<br/>
		<table>
			<tr>
				<td>Email:</td>
				<td>info@jamnik-airport.sk</td>
			</tr>
			<tr>
				<td>Phone number:</td>
				<td>+421 000 000 000</td>
			</tr>
		</table>
		<br><br>
		<div class="mapouter">
			<div class="gmap_canvas">
				<iframe width="600" height="300" id="gmap_canvas" src="https://maps.google.com/maps?q=49.096689%2C%2019.733178&t=k&z=15&ie=UTF8&iwloc=&output=embed"></iframe>
			</div>
		</div>
	
		
	</jsp:body>
</t:twocol>
	

</body>
</html>