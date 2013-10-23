<script type="text/javascript">
var convertToDate = function () {
	$.get('${API_PATH_TIMESTAMP_2_DATE_AND_TIME}', {
		timestampInSeconds: $('#timestampInSeconds').val()
	}).done(function (data) {
		$('#convertedDate').text(data);
	});
};

var convertToTimestamp = function () {
	$.get('${API_PATH_DATE_AND_TIME_2_TIMESTAMP}', {
		formattedDate: $('#formattedDate').val()
	}).done(function (data) {
		$('#convertedTimestamp').text(data);
	});
};
</script>

<p>
This page provides conversion of date to UNIX timestamp and vice versa.
</p>

<b>Enter UNIX timestamp (in seconds):</b><br/>
<input id="timestampInSeconds" type="text" value="${currentTimestampInSeconds}"/><br/>
<input type="button" value="Convert to date" onclick="convertToDate();" /><br/><br/>

<b>Converted date:</b>
<div id="convertedDate" class="well">
</div>

<b>Enter date (yyyy-MM-dd HH:mm:ss):</b><br/>
<input id="formattedDate" type="text" value="${currentFormattedDate}"/><br/>
<input type="button" value="Convert to timestamp" onclick="convertToTimestamp();" /><br/><br/>

<b>Converted UNIX timestamp (in seconds):</b>
<div id="convertedTimestamp" class="well">
</div>

