<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="well sidebar-nav">
	<ul class="nav nav-list">
		<c:forEach var="subMenuItemGroup" items="${subMenu.getSubMenuItemGroups()}">
			<li class="nav-header">${subMenuItemGroup.getName()}</li>
			<c:forEach var="subMenuItem" items="${subMenuItemGroup.getSubMenuItems()}">
				<li><a href="${subMenuItem.getPath()}">${subMenuItem.getName()}</a></li>
			</c:forEach>
			<li class="divider"></li>
		</c:forEach>
	</ul>
</div>