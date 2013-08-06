<p>
This page solves GCD (Greatest Common Divisor) and LCM (Least Common Multiple).
</p>

Enter two numbers for GCD and LCM:
<label for="number1">Number 1:</label>
<input type="text" id="number1" value="48"><br/>
<label for="number2">Number 2:</label>
<input type="text" id="number2" value="18"><br/>
<input type="button" value="Solve" onclick="solve();"><br/><br/>
<div id="result" class="well">
</div>

<p>
For more information, visit
<a href="https://en.wikipedia.org/wiki/Greatest_common_divisor" target="_blank">GCD</a> and
<a href="http://en.wikipedia.org/wiki/Least_common_multiple" target="_blank">LCM</a> on Wikepedia.
</p>

<script type="text/javascript">
var solve = function () {
	$.get('/playground/math/gcd_and_lcm/json', {
		number1: $('#number1').val(),
		number2: $('#number2').val()
	}).done(function (data) {
		$('#result').text("GCD: " + data.gcd + ", LCM: " + data.lcm);
	});
};
</script>