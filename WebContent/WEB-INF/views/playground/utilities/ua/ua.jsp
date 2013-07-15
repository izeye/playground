<style>
	table {
		table-layout: fixed
	}
	table th, table td {
		word-wrap: break-word
	}
</style>
<script type="text/javascript">
var analyzeUserAgent = function () {
	$.getJSON('/playground/utilities/ua/json', {
		userAgent: $('#userAgent').val()
	}).done(function (data) {
		console.log(data);
		$('#os').text(data.osInfo.displayName);
		$('#browser').text(data.browserInfo.displayName);
		$('#device').text(data.deviceType);
	});
};
</script>
<h2>UA (User Agent) Analyzer</h2>

<b>Your user agent is:</b>
<div class="well">
	${userAgent}
</div>

<b>And the analyzed result is:</b>
<table class="table table-striped table-bordered table-condensed" style="font-size: 12px">
	<tr>
		<td style="width: 100px">OS</td><td>${analyzedUserAgent.getOsInfo().getDisplayName()}</td>
	</tr>
	<tr>
		<td>Browser</td><td>${analyzedUserAgent.getBrowserInfo().getDisplayName()}</td>
	</tr>
	<tr>
		<td>Device</td><td>${analyzedUserAgent.getDeviceType().getDisplayName()}</td>
	</tr>
</table>

<b>User agent to analyze:</b><br/>
<textarea id="userAgent" rows="3" style="width: 500">
</textarea><br>
<input type="button" value="Analyze" onclick="analyzeUserAgent();"/><br/><br/>

<b>Analyzed result:</b>
<table class="table table-striped table-bordered table-condensed" style="font-size: 12px">
	<tr>
		<td style="width: 100px">OS</td><td id="os">N/A</td>
	</tr>
	<tr>
		<td>Browser</td><td id="browser">N/A</td>
	</tr>
	<tr>
		<td>Device</td><td id="device">N/A</td>
	</tr>
</table>

<b>You can also use this by calling its API version like this:</b>
<div class="well">
http://izeye.cafe24.com/playground/utilities/ua/json?userAgent=Mozilla%2F5.0+(Macintosh%3B+Intel+Mac+OS+X+10_8_4)+AppleWebKit%2F537.36+(KHTML%2C+like+Gecko)+Chrome%2F28.0.1500.71+Safari%2F537.36
</div>

<b>And the result will be a JSON like this:</b>
<div class="well">
{"osInfo":{"type":"MAC_OS_X","version":"10.8.4","displayName":"Mac OS X 10.8.4 (Mountain Lion)"},"browserInfo":{"type":"CHROME","version":"28.0.1500.71","displayName":"Chrome 28.0.1500.71"},"deviceType":"Macintosh (Macintosh)"}
</div>
