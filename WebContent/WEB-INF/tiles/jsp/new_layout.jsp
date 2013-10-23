<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="<c:url value="/resources/bootstrap/3.0.0/css/bootstrap.min.css" />"
	rel="stylesheet" media="screen">
<link
	href="<c:url value="/resources/bootstrap/3.0.0/css/docs.css" />"
	rel="stylesheet" media="screen">
<link rel="shortcut icon" href="<c:url value="/resources/icons/i_16x16.ico" />" />
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
	<tiles:insertAttribute name="menu" />
	<div class="container bs-docs-container">
		<div class="row">
			<div class="col-md-3">
				<tiles:insertAttribute name="sub_menu" />
			</div>
			<div class="col-md-9">
				<h2><tiles:insertAttribute name="body_title" /></h2>
				<tiles:insertAttribute name="facebook_like" />
				<tiles:insertAttribute name="facebook_share" /><br/>
				<tiles:insertAttribute name="body" /><br/>
				<tiles:insertAttribute name="facebook_comments" />
			</div>
		</div>
		<hr />
		<tiles:insertAttribute name="footer" />
	</div>
	<script type="text/javascript"
		src="<c:url value="/resources/bootstrap/3.0.0/js/bootstrap.js" />"></script>
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');

		ga('create', 'UA-42159511-1', 'cafe24.com');
		ga('send', 'pageview');
	</script>
</body>
</html>