<script type="text/javascript">
	var generateQRCode = function() {
		var text = $('#text').val();
		var size = $('#size').val();
		var qrCodeURL = "http://" + location.host
				+ "/playground/utilities/text2qrcode/api?text=" + text
				+ "&size=" + size;
		var img = $('<img />').attr({
			'src' : qrCodeURL
		});

		$('#result').empty().append(img);
	};
</script>

<p>This page provides a QR code of any text and the usage of its API
	version.</p>

<b>Enter a text which you want to generate a QR code:</b>
<br />
<label class="control-label" for="text">Text</label>
<input id="text" type="text" value="http://izeye.cafe24.com"
	class="input-xxlarge">
<label class="control-label" for="size">Size</label>
<input id="size" type="text" value="200" />
<br />
<input type="button" value="Generate" onclick="generateQRCode();" />
<br />
<br />

<b>Generated QR code:</b>
<div id="result" class="well">N/A</div>

<b>You can also use this by calling its API version like this:</b>
<div class="well">
http://izeye.cafe24.com/playground/utilities/text2qrcode/api?text=http://izeye.cafe24.com&amp;size=200
</div>

<b>And the result will be a QR code like this:</b>
<div class="well">
<img src="http://izeye.cafe24.com/playground/utilities/text2qrcode/api?text=http://izeye.cafe24.com&size=200">
</div>

<div class="well">
<span class="label label-info">Note</span>
This is powered by the ZXing (Zebra Crossing) library.
</div>