<%@tag description="Page with one column" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
<link rel="icon" type="image/png" href='<c:url value="/resources/img/favicon.png"/>'>
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
	<div class="page-footer fixed-bottom bg-info row" >
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