<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
var escape = function () {
	$.get('/playground/utilities/html_escape_and_unescape/escape/api', {
		textToEscape: $('#textToEscape').val()
	}).done(function (data) {
		$('#escapedText').text(data);
	});
};

var unescape = function () {
	$.get('/playground/utilities/html_escape_and_unescape/unescape/api', {
		textToUnescape: $('#textToUnescape').val()
	}).done(function (data) {
		$('#unescapedText').text(data);
	});
};
</script>

<p>
This page provides HTML escaping and unescaping.
</p>

<b>Enter a text to escape HTML:</b><br/>
<input id="textToEscape" type="text" /><br/>
<input type="button" value="Escape" onclick="escape();" /><br/><br/>

<b>Escaped text:</b>
<div id="escapedText" class="well">
</div>

<b>Enter an escaped text to unescape HTML:</b><br/>
<input id="textToUnescape" type="text" /><br/>
<input type="button" value="Unescape" onclick="unescape();" /><br/><br/>

<b>Unescaped text:</b>
<div id="unescapedText" class="well">
</div>

