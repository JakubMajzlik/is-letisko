<%@tag description="Page with one column" pageEncoding="UTF-8"%>
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
		</div>
	</div>
  </body>
</html>