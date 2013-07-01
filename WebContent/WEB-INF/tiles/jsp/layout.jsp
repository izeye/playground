<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="<c:url value="/resources/bootstrap/2.3.2/css/bootstrap.min.css" />"
	rel="stylesheet" media="screen">
<link
	href="<c:url value="/resources/bootstrap/2.3.2/css/bootstrap-responsive.min.css" />"
	rel="stylesheet" media="screen">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>
</head>
<body>
	<tiles:insertAttribute name="main_menu" />
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<tiles:insertAttribute name="sub_menu" />
			</div>
			<div class="span9">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<hr />
		<tiles:insertAttribute name="footer" />
	</div>
	<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/bootstrap/2.3.2/js/bootstrap.min.js" />"></script>
</body>
</html>