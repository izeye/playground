<style type="text/css">
#result { border: 1px solid #000; }
</style>

<script type="text/javascript">
var APP = {};

$(function() {
	var drawing = false;
	
	APP.canvas = $('#result');
	var context = APP.canvas.get(0).getContext('2d');
	
	APP.canvas.mousedown(function (event) {
		context.beginPath();
		context.moveTo(event.offsetX, event.offsetY);
		
		drawing = true;
	});
	APP.canvas.mouseup(function (event) {
		drawing = false;
	});
	APP.canvas.mousemove(function (event) {
		if (!drawing) {
			return;
		}

		context.lineTo(event.offsetX, event.offsetY);
		context.stroke();
	});
});

var save = function () {
	var dataURL = APP.canvas.get(0).toDataURL();
	window.location.href = dataURL.replace('image/png', 'image/octet-stream');
};
</script>

<p>
This page provides drawing image and you can save it as a file.
</p>

<canvas id="result" width="400" height="300"></canvas><br/><br/>

<input type="button" value="Save" onclick="save();" />
