<script type="text/javascript">
var parse = function () {
	$.get('${API_PATH_CSV_PARSER}', {
		csv: $('#csv').val()
	}).done(function (data) {
		$('#result').empty();
		for (var i in data) {
			$('#result').append('<tr><td style="width: 100px">Field ' + (parseInt(i) + 1) + '</td><td>' + data[i] + '</td></tr>');
		}
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
This page provides parsing CSV (Comma-separated values).
</p>

<label for="csv">CSV:</label>
<input id="csv" type="text" class="input-xxlarge" value="1,2,3,4" />
<input type="button" value="Parse" onclick="parse();" />

<label for="result">Result:</label>
<table id="result" class="table table-striped table-bordered table-condensed" style="font-size: 12px">
</table>

<div class="well">
<span class="label label-info">Note</span>
This is powered by the <a href="http://opencsv.sourceforge.net/">opencsv</a> library.
</div>