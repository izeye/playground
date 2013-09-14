<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<p>You can generate Korean Lotto numbers or check the previous winning numbers.</p>

<ul class="nav nav-tabs">
	<li id="tab_generation">
		<a href="/playground/entertainment/korean_lotto/generation">Generation</a>
	</li>
	<li id="tab_winning_history">
		<a href="/playground/entertainment/korean_lotto/winning_history">Winning History</a>
	</li>
</ul>
<tiles:insertAttribute name="sub_body" />

<script type="text/javascript">
	$('#<tiles:insertAttribute name="selected_tab" />').addClass('active');
</script>