<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
var toLowerCase = function () {
	$.get('${API_PATH_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_TO_LOWERCASE}', {
		textToBeLowerCase: $('#textToBeLowerCase').val()
	}).done(function (data) {
		$('#lowerCaseText').text(data);
	});
};

var toUpperCase = function () {
	$.get('${API_PATH_ENGLISH_LOWERCASE_UPPERCASE_CONVERTER_TO_UPPERCASE}', {
		textToBeUpperCase: $('#textToBeUpperCase').val()
	}).done(function (data) {
		$('#upperCaseText').text(data);
	});
};
</script>

<p>
This page provides converting English to lower-case or upper-case.
</p>

<b>Enter a text to be lower-case:</b><br/>
<textarea id="textToBeLowerCase" class="input-xxlarge" rows="10"></textarea><br/>
<input type="button" value="To Lower-case" onclick="toLowerCase();" /><br/><br/>

<b>Lower-case text:</b>
<div id="lowerCaseText" class="well">
</div>

<b>Enter a text to be upper-case:</b><br/>
<textarea id="textToBeUpperCase" class="input-xxlarge" rows="10"></textarea><br/>
<input type="button" value="To Upper-case" onclick="toUpperCase();" /><br/><br/>

<b>Upper-case text:</b>
<div id="upperCaseText" class="well">
</div>

