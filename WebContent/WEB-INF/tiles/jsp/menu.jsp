<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="brand" href="<c:url value="/" />">izeye's Playground</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<c:forEach var="menuItem" items="${menu.getMenuItems()}">
						<li><a href="<c:url value="${menuItem.getPath()}"/>">${menuItem.getName()}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>
