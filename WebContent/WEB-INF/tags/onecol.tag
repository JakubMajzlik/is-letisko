<%@tag description="Page with one column" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>

</head>
  <body>
  
    <div class="container fill">
   		<div class="row bg-info mb-5 ">
			<div class="col">
				<t:nav/>
			</div>
    	</div>
		<div class="row">
			<div class="col-10">
				<div id="body" class="col-9">
			
				<jsp:doBody/>
				
				</div>
			</div>

			
		</div>
	</div>
  </body>
</html>