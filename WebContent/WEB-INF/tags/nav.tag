<%@tag description="Nav bar" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav nav-tabs|pills nav-stacked d-flex justify-content-center">
	<li class="nav-item">
		<a class="nav-link text-white" href="${pageContext.request.contextPath}/">Home</a>
	</li>
	<li class="nav-item">
		<a class="nav-link text-white" href="${pageContext.request.contextPath}/flight/findflight">Find flights</a>
	</li>
	<li class="nav-item">
		<a class="nav-link text-white" href="${pageContext.request.contextPath}/contact">Contact</a>
	</li>
</ul>
