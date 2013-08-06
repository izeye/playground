<p>
This page solves Collatz conjecture.
Collatz conjecture hasn't been proved yet.
Try to find the number which can break his conjecture :-)
</p>

<label for="number">Enter a number:</label>
<input type="text" id="number" value="300"><br/>
<input type="button" value="Solve" onclick="solve();"><br/><br/>
<div id="result" class="well">
</div>

<p>
For more information, visit
<a href="https://en.wikipedia.org/wiki/Collatz_conjecture" target="_blank">Collatz conjecture on Wikepedia</a>.
</p>

<script type="text/javascript">
var solve = function () {
	$.getJSON('/playground/math/collatz/json', {
		number: $('#number').val()
	}).done(function (data) {
		$('#result').text('Length: ' + data.length + ', List: ' + data);
	});
};
</script>