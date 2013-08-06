<p>
This page solves factorial.
</p>

<label for="number">Enter a number for factorial:</label>
<input type="text" id="number" value="10"><br/>
<input type="button" value="Solve" onclick="solve();"><br/><br/>
<div id="result" class="well">
</div>

<p>
For more information, visit
<a href="http://en.wikipedia.org/wiki/Factorial" target="_blank">Factorial on Wikepedia</a>.
</p>

<script type="text/javascript">
var solve = function () {
	$.get('/playground/math/factorial/json', {
		number: $('#number').val()
	}).done(function (data) {
		$('#result').text(data);
	});
};
</script>