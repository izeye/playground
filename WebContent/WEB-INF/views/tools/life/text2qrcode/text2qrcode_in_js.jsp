<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" src="<c:url value="/resources/qrcode/qrcode.min.js" />">
</script>

<script type="text/javascript">
	var qrcode;
	
	var generateQRCode = function() {
		var text = $('#text').val();
		var size = $('#size').val();

		$('#result').empty();
		qrcode = new QRCode("result", {
			text: text,
			width: size,
			height: size,
			colorDark: "#000000",
			colorLight: "#ffffff",
			correctLevel: QRCode.CorrectLevel.H
		});
	};
</script>

<p>This page provides a QR code of any text by JavaScript.</p>

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

<div class="well">
<span class="label label-info">Note</span>
This is powered by the
<a href="http://davidshimjs.github.io/qrcodejs/" target="_blank">QRCOde.js</a>
library.
</div>