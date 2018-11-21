<%@tag description="Page with two columns" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>

</head>
  <body>
    <div class="container fill">
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
				<security:authorize access="hasRole('EMPLOYEE')">
					<a href="${pageContext.request.contextPath }/employee/addflight" >Add Flight</a> <br/>
					<a href="${pageContext.request.contextPath }/employee/updateflight" >Update Flight</a> <br/>
					<br/>
				</security:authorize>
				
				<security:authorize access="hasRole('ADMIN')">
					<a href="${pageContext.request.contextPath}/admin/manageusers">Manage users</a> <br/>
					<a href="${pageContext.request.contextPath}/admin/addplane">Add plane</a> <br/>
					<a href="${pageContext.request.contextPath}/admin/updateplane">Show planes</a> <br/>
					<a href="${pageContext.request.contextPath}/admin/adddestination">Add destination</a><br/>
					<br/>
				</security:authorize>
				
				<security:authorize access="isAuthenticated()">
					<br/>
					<form:form method="POST" action="${pageContext.request.contextPath }/logout">
						<input type="submit" value="Logout"/>
					</form:form>
				</security:authorize>
			</div>
		</div>
	</div>
	<div class="page-footer fixed-bottom bg-info" >
	    <div class="footer-copyright text-white text-center py-4">
	    	© 2018 Copyright Jamnik Airport
	    </div>
	</div>
  </body>
</html>