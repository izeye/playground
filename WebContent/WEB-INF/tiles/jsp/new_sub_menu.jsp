<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="bs-sidebar hidden-print affix">
	<ul class="nav bs-sidenav">
		<c:forEach var="subMenuItemGroup" items="${subMenu.getSubMenuItemGroups()}">
			<li class="active">
			<a href="#">${subMenuItemGroup.getName()}</a>
			<ul class="nav">
				<c:forEach var="subMenuItem" items="${subMenuItemGroup.getSubMenuItems()}">
					<li><a href="${subMenuItem.getPath()}">${subMenuItem.getName()}</a></li>
				</c:forEach>
			</ul>
			</li>
		</c:forEach>
	</ul>
</div>