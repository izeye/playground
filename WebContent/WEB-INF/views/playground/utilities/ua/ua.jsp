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
		$('#os').text(data.osInfo.displayName);
		$('#browser').text(data.browserInfo.displayName);
		$('#device').text(data.deviceType.displayName);
	});
};
</script>

<h2>UA (User Agent) Analyzer</h2>

<p>
This page provides analysis of your UA or any UA string and the usage of its API version.
</p>

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
<input type="button" value="Analyze" onclick="analyzeUserAgent();" /><br/><br/>

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
{"osInfo":{"type":{"keyInUserAgent":"Intel Mac OS X","name":"Mac OS X"},"version":"10.8.4","displayName":"Mac OS X 10.8.4 (Mountain Lion)"},"browserInfo":{"type":{"keyInUserAgent":"Chrome","name":"Chrome"},"version":"28.0.1500.71","displayName":"Chrome 28.0.1500.71"},"deviceType":{"modelName":"Macintosh","productName":"Macintosh","callable":false,"displayName":"Macintosh (Macintosh), non-callable"}}
</div>

<div class="well">
<span class="label label-important">Note</span>
If the analyzed result is not good enough for you,
let me know what the user agent was by email (izeye@naver.com).
Then I'll fix it ASAP :-)
</div>
