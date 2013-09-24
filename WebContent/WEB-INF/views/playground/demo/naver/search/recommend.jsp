<script type="text/javascript">
var getSearchRecommendations = function () {
	$.get('${API_PATH_NAVER_SEARCH_RECOMMEND}', {
		query: $('#query').val()
	}).done(function (data) {
		console.log(data);
		$('#result').text(data);
	});
};
</script>

<p>This is a page for Naver search recommendation.</p>

<label for="query">Query:</label>
<input id="query" type="text" value="nhn" />
<input type="button" value="Get Search Recommendations" onclick="getSearchRecommendations();" />

<div id="result" class="well">
</div>
