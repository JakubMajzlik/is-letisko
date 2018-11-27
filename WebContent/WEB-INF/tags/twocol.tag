<%@tag description="Page with two columns" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
<link rel="icon" type="image/png" href='<c:url value="/resources/img/favicon.png"/>'>
</head>
  <body>
    <div class="container fill pb-5" style="min-height:85vh;">
    	<div class="row bg-info mb-5">
			<div class="col">
				<t:nav/>
			</div>
    	</div>
		<div class="row">
			<div id="body" class="col-9">
			
				<jsp:doBody/>
				
			</div>
			<div class="col">
				<!-- Pravy stlpec -->
				<security:authorize access="!isAuthenticated()">
					<form action="${pageContext.request.contextPath}/user/login/process" method="POST">
						Email:<br/>
						 <input type="text" name="username" />
						<c:if test="${param.error != null}">
								Invalid Username or password 
							</c:if><br/>
						Password:<br/>
						 <input type="password" name="password"/><form:errors path="password"/> <br/>
						<button type="submit" >Login</button>
						<input type="hidden"
												   name="${_csrf.parameterName}"
												   value="${_csrf.token}" />
					</form>
					<a href="${pageContext.request.contextPath}/user/register">Don't have an account? Register for free</a>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<security:authentication var="user" property="principal"/>
					You are logged with email <b>${user.username}</b>
					<hr/>
					<a href="${pageContext.request.contextPath}/user/editprofile">Edit profile</a> <br/>
					<a href="${pageContext.request.contextPath }/user/history">Order history</a>  <br/>
					<hr/>
					<security:authorize access="hasRole('EMPLOYEE')">
						<a href="${pageContext.request.contextPath }/employee/addflight" >Add Flight</a> <br/>
						<a href="${pageContext.request.contextPath }/employee/updateflight" >Update Flight</a> <br/>
						<br/>
					</security:authorize>
					
					<security:authorize access="hasRole('ADMIN')">
						<a href="${pageContext.request.contextPath}/admin/manageusers">Manage users</a> <br/>
						<a href="${pageContext.request.contextPath}/admin/registeremployee">Register employee</a> <br/>
						<a href="${pageContext.request.contextPath}/admin/addplane">Add plane</a> <br/>
						<a href="${pageContext.request.contextPath}/admin/updateplane">Show planes</a> <br/>
						<a href="${pageContext.request.contextPath}/admin/adddestination">Add destination</a><br/>
						<a href="${pageContext.request.contextPath}/admin/destinations">Show destinations</a><br/>
						<br/>
					</security:authorize>
					
					<security:authorize access="isAuthenticated()">
						<br/>
						<form:form method="POST" action="${pageContext.request.contextPath }/logout">
							<input type="submit" value="Logout"/>
						</form:form>
					</security:authorize>
				</security:authorize>
			</div>
		</div>
		<br/><br/><br/><br/>
	</div>
	<div class="page-footer bg-info row" >
		<div class="col-5">
		<a class="weatherwidget-io" href="https://forecast7.com/en/49d0719d71/jamnik/" data-label_1="CURRENT WEATHER" data-label_2="IN JAMNÍK" data-days="3" data-theme="original" data-basecolor="rgba(255, 255, 255, 0)" >JAMNÍK WEATHER</a>
		<script>
			!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src='https://weatherwidget.io/js/widget.min.js';fjs.parentNode.insertBefore(js,fjs);}}(document,'script','weatherwidget-io-js');
		</script>
		</div>
	    <div class="footer-copyright text-white text-center py-4 col">
	    	
	    	© 2018 Copyright Jamnik Airport
	    </div>
	</div>
  </body>
</html>