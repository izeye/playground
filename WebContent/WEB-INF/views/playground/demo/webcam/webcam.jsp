<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<h2>Webcam</h2>
<p>To run this demo, allow to use your camera above.</p>

<ul class="nav nav-tabs">
	<li id="tab_live">
		<a href="/playground/demo/webcam/live">Live</a>
	</li>
	<li id="tab_snapshots">
		<a href="/playground/demo/webcam/snapshots">Snapshots</a>
	</li>
</ul>
<tiles:insertAttribute name="sub_body" />
<script type="text/javascript">
	$('#<tiles:insertAttribute name="selected_tab" />').addClass('active');
</script>