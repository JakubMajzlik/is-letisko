<%@tag description="Page with two columns" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <body>
    <div class="container fill">
		<div class="row">
			<div id="body" class="col-9">
			
				<jsp:doBody/>
				
			</div>
			<div class="col">
				<security:authorize access="!isAuthenticated()">
					<form action="${pageContext.request.contextPath}/user/login/process" method="POST">
						Email: <input type="text" name="username" />
						<c:if test="${param.error != null}">
								Invalid Username or password 
							</c:if><br/>
						Password: <input type="password" name="password"/><form:errors path="password"/> <br/>
						<button type="submit" >Login</button>
						<input type="hidden"
												   name="${_csrf.parameterName}"
												   value="${_csrf.token}" />
					</form>
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
  </body>
</html>