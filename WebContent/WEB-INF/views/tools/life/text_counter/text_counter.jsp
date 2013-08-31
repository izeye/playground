<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
var count = function () {
	$.get('${API_PATH_TEXT_COUNTER}', {
		text: $('#text').val()
	}).done(function (data) {
		$('#result').empty();
		$('#result').append('<tr><td>Byte #</td><td>' + data.byteCount + '</td></tr>');
		$('#result').append('<tr><td>Character #</td><td>' + data.charCount + '</td></tr>');
		$('#result').append('<tr><td>Word #</td><td>' + data.wordCount + '</td></tr>');
		$('#result').append('<tr><td>Line #</td><td>' + data.lineCount + '</td></tr>');
	});
};
</script>

<style>
	table {
		table-layout: fixed
	}
	table th, table td {
		word-wrap: break-word
	}
</style>

<p>
This page provides counting bytes, characters, words and lines of a text.
</p>

<label for="text">Text:</label>
<textarea id="text" class="input-xxlarge" rows="5">
</textarea><br/>
<input type="button" value="Count" onclick="count();" /><br/><br/>

<b>Result:</b><br/>
<table id="result" class="table table-striped table-bordered table-condensed" style="font-size: 12px">
</table>
