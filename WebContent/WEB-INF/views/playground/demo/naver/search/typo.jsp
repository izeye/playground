<script type="text/javascript">
var fixTypo = function () {
	$.get('${API_PATH_NAVER_SEARCH_TYPO}', {
		query: $('#query').val()
	}).done(function (data) {
		$('#result').text(data ? data : 'N/A');
	});
};
</script>

<p>This is a page for fixing typo made by invalid selection between Korean and English.</p>

<label for="query">Typo:</label>
<input id="query" type="text" value="spdlqj" />
<input type="button" value="Check for adults" onclick="fixTypo();" />

<div id="result" class="well">
</div>
