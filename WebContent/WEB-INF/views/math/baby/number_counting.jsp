<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript"
		src="<c:url value="/resources/holder/holder.min.js" />"></script>

<script type="text/javascript">
Holder.add_theme("social_with_large_font", {
	background: "#3a5a97",
	foreground: "#fff",
	size: 400
});
</script>
		
<div id="carousel-example-generic" class="carousel slide">
	<ol class="carousel-indicators">
		<li data-target="#carousel-example-generic" data-side-to="0" class="active"></li>
		<c:forEach var="i" begin="1" end="9" step="1">
		<li data-target="#carousel-example-generic" data-side-to="${i}"></li>
		</c:forEach>
	</ol>
	
	<div class="carousel-inner">
		<div class="item active">
			<img src="holder.js/900x500/social_with_large_font/text:${1}">
		</div>
		<c:forEach var="i" begin="2" end="10" step="1">
		<div class="item">
			<img src="holder.js/900x500/social_with_large_font/text:${i}">
		</div>
		</c:forEach>
	</div>
	
	<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
		<span class="icon-prev"></span>
	</a>
	<a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
		<span class="icon-next"></span>
	</a>
</div>