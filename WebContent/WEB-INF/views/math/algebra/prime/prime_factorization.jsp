<p>
This page provides prime factorization.
</p>

<label for="number">Enter a number to get prime factors:</label>
<input type="text" id="number" value="100"><br/>
<input type="button" value="Solve" onclick="solve();"><br/><br/>
<div id="result" class="well">
</div>

<p>
For more information, visit
<a href="http://en.wikipedia.org/wiki/Prime_factor" target="_blank">Prime Factor on Wikepedia</a>.
</p>

<script type="text/javascript">
var solve = function () {
	$.getJSON('${API_PATH_PRIME_FACTORIZATION}', {
		number: $('#number').val()
	}).done(function (data) {
		var result = '';
		for (var i = 0; i < data.length; i++) {
			result += data[i].prime;
			if (data[i].exponent > 1) { 
				result += '<sup>' + data[i].exponent + '</sup>';
			}
			result += ' * ';
		}
		result = result.substring(0, result.length - 3);
		$('#result').empty().append(result);
	});
};
</script>