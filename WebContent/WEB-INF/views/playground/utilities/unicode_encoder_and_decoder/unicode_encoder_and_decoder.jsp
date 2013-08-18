<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
var encode = function () {
	$.get('/playground/utilities/unicode_encoder_and_decoder/encode/api', {
		textToEncode: $('#textToEncode').val()
	}).done(function (data) {
		$('#encodedText').text(data);
	});
};

var decode = function () {
	$.get('/playground/utilities/unicode_encoder_and_decoder/decode/api', {
		textToDecode: $('#textToDecode').val()
	}).done(function (data) {
		console.log(data);
		$('#decodedText').text(data);
	});
};
</script>

<p>
This page provides Unicode encoding and decoding.
</p>

<b>Enter a text to encode to a comma-separated Unicode list:</b><br/>
<input id="textToEncode" type="text" value="Hello, world!" /><br/>
<input type="button" value="Encode" onclick="encode();" /><br/><br/>

<b>Encoded text:</b>
<div id="encodedText" class="well">
</div>

<b>Enter a comma-separated Unicode list to decode:</b><br/>
<input id="textToDecode" type="text" value="48,65,6c,6c,6f,2c,20,77,6f,72,6c,64,21" /><br/>
<input type="button" value="Decode" onclick="decode();" /><br/><br/>

<b>Decoded text:</b>
<div id="decodedText" class="well">
</div>
