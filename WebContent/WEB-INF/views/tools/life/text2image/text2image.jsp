<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript"
		src="<c:url value="/resources/holder/holder.min.js" />"></script>

<script type="text/javascript">
var draw = function () {
	var width = $('#width').val();
	var height = $('#height').val();
	var text = $('#text').val();
	var src = 'holder.js/' + width + 'x' + height + '/new/text:' + text;
	
	Holder.add_theme("new", {
		background: $('#backgroundColor').val(),
		foreground: $('#foregroundColor').val(),
		size: $('#fontSize').val()
	});
	
	$('#result').attr("data-src", src);
	Holder.run();
};

var save = function () {
	var result = $('#result');
	window.location.href = result.attr('src').replace('image/png', 'image/octet-stream');
};
</script>

<p>
This page provides converting text to image and you can save it as a file.
</p>

<label for="text">Text
<input id="text" type="text" value="Test" />
</label><br/>
<label for="width">Font size
<input id="fontSize" type="text" value="12" />
</label><br/>

<label for="width">Width
<input id="width" type="text" value="400" />
</label>
<label for="width">Height
<input id="height" type="text" value="300" />
</label><br/>

<label for="width">Background color
<input id="backgroundColor" type="text" value="#3a5a97" />
</label>
<label for="width">Foreground color
<input id="foregroundColor" type="text" value="#fff" />
</label><br/>

<input type="button" value="Draw" onclick="draw();" /><br/><br/>

<img id="result" src="holder.js/400x300/social/text:Ready"><br/><br/>

<input type="button" value="Save" onclick="save();" />
