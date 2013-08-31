<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script type="text/javascript"
		src="<c:url value="/resources/syntaxhighlighter/3.0.83/js/shCore.js" />">
</script>
<script type="text/javascript"
		src="<c:url value="/resources/syntaxhighlighter/3.0.83/js/shBrushXml.js" />">
</script>

<link rel="stylesheet"
		href="<c:url value="/resources/syntaxhighlighter/3.0.83/css/shCore.css" />" />
<link rel="stylesheet"
		href="<c:url value="/resources/syntaxhighlighter/3.0.83/css/shThemeDefault.css" />" />

<script type="text/javascript">
var send = function () {
	$.get('${API_PATH_HTTP_CLIENT}', {
		method: $('#method').val(),
		url: $('#url').val(),
		headers: $('#headers').val(),
		parameters: $('#parameters').val()
	}).done(function (data) {
		var request = data.request;
		var response = data.response;
		
		$('#request').empty().append(request.rawRequest);
		
		$('#response').empty().append(response.htmlEscapedRawResponse);
		
		$('#version').text('HTTP ' + response.version);
		$('#status').text(response.status + ' (' + response.statusCode + ')');
		
		$('#responseHeaders').empty().append('<tr><th>Name</th><th>Value</th></tr>');
		for (var name in response.headers) {
			var value = response.headers[name];
			$('#responseHeaders').append('<tr><td>' + name + '</td><td>' + value + '</td></tr>');
		}
		
		$('#body').empty().append('<pre class="brush: html">' + response.htmlEscapedBody + '</pre>');
		SyntaxHighlighter.highlight();
	});
};
</script>

<style>
pre {
	font-size: 10px;
}
</style>

<p>
This page provides sending a HTTP request.
</p>

<label for="method">Method:</label>
<select id="method">
<c:forEach var="method" items="${methods}">
	<option value="${method}">${method}</option>
</c:forEach>
</select>
<label for="url">URL:</label>
<input id="url" type="text" class="input-xxlarge" value="http://izeye.cafe24.com/" /><br/>
<label for="headers">Headers:</label>
<textarea id="headers" class="input-xxlarge" rows="5">
Host:izeye.cafe24.com
Referer:http://izeye.cafe24.com/tools/computer/http_client
User-Agent:izeye-http-client/1.0
Connection:close</textarea>
<label for="parameters">Parameters:</label>
<textarea id="parameters" class="input-xxlarge" rows="5">
id=izeye
name=Johnny</textarea><br/>
<input type="button" value="Send" onclick="send();" /><br/><br/>

<b>Request:</b>
<pre id="request"></pre>

<b>Response:</b>
<pre id="response"></pre>

<b>Analyzed response:</b><br/>
<u>Version:</u>
<pre id="version"></pre>
<u>Status:</u>
<pre id="status"></pre>
<u>Headers:</u>
<table id="responseHeaders" class="table table-striped table-bordered table-condensed" style="font-size: 12px">
</table>
<u>Body:</u>
<div id="body"></div>
