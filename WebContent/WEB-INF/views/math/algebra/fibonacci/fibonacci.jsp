<p>
This page solves Fibonacci number.
</p>

<label for="number">Enter a length of Fibonacci:</label>
<input type="text" id="number" value="10"><br/>
<input type="button" value="Solve" onclick="solve();"><br/><br/>
<div id="result" class="well">
</div>

<p>
For more information, visit
<a href="http://en.wikipedia.org/wiki/Fibonacci_number" target="_blank">Fibonacci number on Wikepedia</a>.
</p>

<script type="text/javascript">
var solve = function () {
	$.getJSON('${API_PATH_FIBONACCI}', {
		number: $('#number').val()
	}).done(function (data) {
		$('#result').text(data);
	});
};
</script>