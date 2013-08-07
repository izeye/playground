<p>
This page solves Goldbach's conjecture.
Goldbach's conjecture hasn't been proved yet.
Try to find the number which can break his conjecture :-)
</p>

<label for="number">Enter an even number:</label>
<input type="text" id="number" value="100"><br/>
<input type="button" value="Solve" onclick="solve();"><br/><br/>
<div id="result" class="well">
</div>

<p>
For more information, visit
<a href="http://en.wikipedia.org/wiki/Goldbach's_conjecture" target="_blank">Goldbach's conjecture on Wikepedia</a>.
</p>

<script type="text/javascript">
var solve = function () {
	$.getJSON('/playground/math/goldbach/json', {
		number: $('#number').val()
	}).done(function (data) {
		var result = $('#number').val();
		for (var i = 0; i < data.length; i++) {
			result += ' = ' + data[i].firstPrime + ' + ' + data[i].secondPrime;
		}
		$('#result').text(result);
	});
};
</script>