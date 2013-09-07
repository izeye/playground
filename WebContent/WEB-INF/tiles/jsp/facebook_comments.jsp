<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="fb-root"></div>

<script>
	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=552165018164741";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>

<div class="fb-comments"
	data-href="http://izeye.cafe24.com${requestScope['javax.servlet.forward.request_uri']}"
	data-width="470"></div>