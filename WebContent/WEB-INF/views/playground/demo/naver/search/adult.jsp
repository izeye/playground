<script type="text/javascript">
var checkForAdults = function () {
	$.get('${API_PATH_NAVER_SEARCH_ADULT}', {
		query: $('#query').val()
	}).done(function (data) {
		$('#result').text(data ? 'Yes' : 'No');
	});
};
</script>

<p>This is a page for checking whether a query is for adults or not.</p>

<label for="query">Query:</label>
<input id="query" type="text" value="test" />
<input type="button" value="Check for adults" onclick="checkForAdults();" />

<div id="result" class="well">
</div>
