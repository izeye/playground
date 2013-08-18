<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
var encode = function () {
	$.get('/playground/utilities/url_encoder_and_decoder/encode/api', {
		textToEncode: $('#textToEncode').val()
	}).done(function (data) {
		$('#encodedText').text(data);
	});
};

var decode = function () {
	$.get('/playground/utilities/url_encoder_and_decoder/decode/api', {
		textToDecode: $('#textToDecode').val()
	}).done(function (data) {
		$('#decodedText').text(data);
	});
};
</script>

<p>
This page provides URL encoding and decoding.
</p>

<b>Enter a text to URL encode:</b><br/>
<input id="textToEncode" type="text" /><br/>
<input type="button" value="Encode" onclick="encode();" /><br/><br/>

<b>Encoded text:</b>
<div id="encodedText" class="well">
</div>

<b>Enter an encoded text to URL decode:</b><br/>
<input id="textToDecode" type="text" /><br/>
<input type="button" value="Decode" onclick="decode();" /><br/><br/>

<b>Decoded text:</b>
<div id="decodedText" class="well">
</div>

