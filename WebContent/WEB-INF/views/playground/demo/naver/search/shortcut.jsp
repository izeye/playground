<script type="text/javascript">
var search = function () {
	$.get('${API_PATH_NAVER_SEARCH_SHORTCUT}', {
		query: $('#query').val()
	}).done(function (data) {
		var result = 'Not found.';
		if (data.label) {
			var result =
					'<dt><a href="' + data.url + '" target="_blank">' + data.label + '</a></dt>' +
					'<dd><a href="' + data.url + '" + target="_blank">' + data.url + '</a></dd>';
		}
		$('#result').empty().append(result);
	});
};
</script>

<p>This is a page for searching Naver shortcut.</p>

<label for="query">Query:</label>
<input id="query" type="text" value="test" />
<input type="button" value="Search" onclick="search();" />

<div><dl id="result"></dl></div>
