<script type="text/javascript">
var APP = {};

APP.display = 10;
APP.start = 1;

var search = function (start) {
	if (start == 1) {
		APP.start = start;
		
		$('#result').empty();
		
		// NOTE:
		// Inappropriate but for simplicity.
		$('#moreButton').show();
	}
	
	$.get('${API_PATH_NAVER_SEARCH_NEWS}', {
		query: $('#query').val(),
		display: APP.display,
		start: start
	}).done(function (data) {
		var result = '';
		for (var i in data.items) {
			var item = data.items[i];
			
			result += 
					'<li>' +
					'<dl>' +
					'<dt><a href="' + item.originalLink + '">' + item.title + '</a></dt>' +
					'<dd>' + item.description + '</dd>';
			if (item.redirectedLink.match('^http://news.naver.com/')) {
				result += '<dd><span><a href="' + item.redirectedLink + '">Show in Naver</a></span></dd>';
			}
			result +=
					'</dl>' +
					'</li>';
		}
		$('#result').append(result);
		
		APP.start += 1;
	});
};
</script>

<p>This is a page for searching Naver news.</p>

<label for="query">Query:</label>
<input id="query" type="text" value="test" />
<input type="button" value="Search" onclick="search(1);" />

<div><ul id="result"></ul></div>

<input id="moreButton" type="button" value="Show more 10 results" onclick="search(APP.start);"
		style="display:none" />
