<p>
This page handles prime numbers.
</p>

<label for="numberForPrimality">Enter a number to test primality:</label>
<input type="text" id="numberForPrimality" value="13"><br/>
<input type="button" value="Solve" onclick="isPrime();"><br/><br/>
<div id="resultOfPrimality" class="well">
</div>

<label for="numberForAllPrimes">Enter an upper bound to generate primes:</label>
<input type="text" id="numberForAllPrimes" value="13"><br/>
<input type="button" value="Solve" onclick="getAllPrimes();"><br/><br/>
<div id="resultOfAllPrimes" class="well">
</div>

<p>
For more information, visit
<a href="https://en.wikipedia.org/wiki/Prime_number" target="_blank">Prime number on Wikepedia</a>.
</p>

<script type="text/javascript">
var isPrime = function () {
	$.getJSON('/playground/math/prime/is_prime', {
		number: $('#numberForPrimality').val()
	}).done(function (data) {
		var number = $('#numberForPrimality').val();
		$('#resultOfPrimality').text(number + (data ? ' is' :  ' is NOT') + ' a PRIME.');
	});
};

var getAllPrimes = function () {
	$.getJSON('/playground/math/prime/all_primes', {
		number: $('#numberForAllPrimes').val()
	}).done(function (data) {
		$('#resultOfAllPrimes').text(data);
	});
};
</script>