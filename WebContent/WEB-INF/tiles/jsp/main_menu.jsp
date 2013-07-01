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
					<li class="active"><a href="<c:url value="/" />">Home</a></li>
					<li><a href="<c:url value="/playground" />">Playground</a></li>
					<li><a href="<c:url value="/about" />">About</a></li>
					<li><a href="<c:url value="/links" />">Links</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>