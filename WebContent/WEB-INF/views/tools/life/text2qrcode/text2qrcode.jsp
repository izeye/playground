<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<p>You can generate QR code by Java or JavaScript.</p>

<ul class="nav nav-tabs">
	<li id="tab_java">
		<a href="/tools/life/text2qrcode_in_java">Java</a>
	</li>
	<li id="tab_javascript">
		<a href="/tools/life/text2qrcode_in_js">JavaScript</a>
	</li>
</ul>
<tiles:insertAttribute name="sub_body" />
<script type="text/javascript">
	$('#<tiles:insertAttribute name="selected_tab" />').addClass('active');
</script>