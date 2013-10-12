<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav" role="banner">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/" />">izeye's Playground</a>
		</div>
		<nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
			<ul class="nav navbar-nav">
				<c:forEach var="menuItem" items="${menu.getMenuItems()}">
					<li><a href="<c:url value="${menuItem.getPath()}"/>">${menuItem.getName()}</a></li>
				</c:forEach>
			</ul>
		</nav>
	</div>
</header>
