<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
	
	$.get('${API_PATH_NAVER_SEARCH_BOOK}', {
		query: $('#query').val(),
		display: APP.display,
		start: start
	}).done(function (data) {
		var result = '';
		for (var i in data.items) {
			var item = data.items[i];
			
			var discountPercent = Math.floor((item.price - item.discount) * 100 / item.price);
			
			result += 
					'<li>' +
					'<dl>' +
					'<dt><a href="' + item.redirectedLink + '">' + item.title + '</a></dt>' +
					'<dd>' + item.author + '|' + item.publisher + '|' + item.formattedPublishedDate + '</dd>' +
					'<dd><del>₩' + item.price + '</del>→₩' + item.discount + '(-' + discountPercent + '%)</dd>' +
					'<dd>' + item.description + '</dd>' +
					'</dl>' +
					'</li>';
		}
		$('#result').append(result);
		
		APP.start += 1;
	});
};
</script>

<p>This is a page for searching Naver book.</p>

<label for="query">Query:</label>
<input id="query" type="text" value="test" />
<input type="button" value="Search" onclick="search(1);" />

<div><ul id="result"></ul></div>

<input id="moreButton" type="button" value="Show more 10 results" onclick="search(APP.start);"
		style="display:none" />
