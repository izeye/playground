<script type="text/javascript">
var matches = function () {
	$.get('${API_PATH_REGULAR_EXPRESSION_TESTER}', {
		regex: $('#regex').val(),
		input: $('#input').val()
	}).done(function (data) {
		$('#result').text(data);
	});
};
</script>

<p>
This page provides testing a regular expression.
</p>

<label for="regex">
<input id="regex" type="text" value="[bcr]at"/>
</label>
<label for="input">
<input id="input" type="text" value="bat"/>
</label>
<input type="button" value="Matches" onclick="matches();" /><br/><br/>

<b>Result:</b>
<div id="result" class="well">
</div>
