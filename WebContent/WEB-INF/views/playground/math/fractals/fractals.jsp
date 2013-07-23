<h2>Fractals</h2>

<p>This page shows some fractals using HTML5 canvas.</p>

<h3>Sierpinski Triangle</h3>

<label for="size">Enter size of Sierpinski triangle:</label>
<input type="text" id="triangleSize" value="300"><br/>
<input type="button" value="Draw" onclick="drawSierpinskiTriangleAtCenter();"><br/><br/>

<canvas id="triangleCanvas" width="400" height="400" style="border: 1px solid #000000">
</canvas><br/><br/>

<p>
For more information, visit
<a href="https://en.wikipedia.org/wiki/Sierpinski_triangle" target="_blank">Sierpinski triangle on Wikepedia</a>.
</p>

<h3>Sierpinski Carpet</h3>

<label for="size">Enter size of Sierpinski carpet:</label>
<input type="text" id="carpetSize" value="300"><br/>
<input type="button" value="Draw" onclick="drawSierpinskiCarpetAtCenter();"><br/><br/>

<canvas id="carpetCanvas" width="400" height="400" style="border: 1px solid #000000">
</canvas><br/><br/>

<p>
For more information, visit
<a href="http://en.wikipedia.org/wiki/Sierpinski_carpet" target="_blank">Sierpinski carpet on Wikepedia</a>.
</p>

<script type="text/javascript">
var cutoff = 2;

var triangleCanvas = document.getElementById('triangleCanvas');
var triangleContext = triangleCanvas.getContext('2d');

var drawTriangle = function (x1, y1, x2, y2, x3, y3) {
	triangleContext.beginPath();
	triangleContext.moveTo(x1, y1);
	triangleContext.lineTo(x2, y2);
	triangleContext.lineTo(x3, y3);
	triangleContext.lineTo(x1, y1);
	triangleContext.stroke();
};

var drawSierpinskiTriangle = function (x1, y1, x2, y2, x3, y3) {
	var width = x2 - x1;
	var height = y1 - y3;
	if (width <= cutoff) {
		return;
	}
	
	drawTriangle(x1, y1, x2, y2, x3, y3);
	
	setTimeout(function () {
		drawSierpinskiTriangle(
				x1+width/4, y1-height/2,
				x2-width/4, y2-height/2,
				x3, y3);
		drawSierpinskiTriangle(
				x1, y1,
				x2-width/2, y2,
				x3-width/4, y3+height/2);
		drawSierpinskiTriangle(
				x1+width/2, y1,
				x2, y2,
				x3+width/4, y3+height/2);
		
	}, 300);
};

var drawSierpinskiTriangleAtCenter = function () {
	triangleContext.clearRect(0, 0, triangleCanvas.width, triangleCanvas.height);
	
	var width = $('#triangleSize').val();
	var height = width * Math.sqrt(3) / 2;

	var x1 = triangleCanvas.width / 2 - width / 2;
	var y1 = triangleCanvas.height / 2 + height / 2;
	var x2 = triangleCanvas.width / 2 + width / 2;
	var y2 = triangleCanvas.height / 2 + height / 2;
	var x3 = triangleCanvas.width / 2;
	var y3 = triangleCanvas.height / 2 - height / 2;

	drawSierpinskiTriangle(x1, y1, x2, y2, x3, y3);
};

var carpetCanvas = document.getElementById('carpetCanvas');
var carpetContext = carpetCanvas.getContext('2d');

var drawSquare = function (x1, y1, x2, y2, x3, y3, x4, y4) {
	carpetContext.beginPath();
	carpetContext.moveTo(x1, y1);
	carpetContext.lineTo(x2, y2);
	carpetContext.lineTo(x3, y3);
	carpetContext.lineTo(x4, y4);
	carpetContext.lineTo(x1, y1);
	carpetContext.stroke();
};

var drawSierpinskiCarpet = function (x1, y1, x2, y2, x3, y3, x4, y4) {
	var width = x2 - x1;
	if (width <= cutoff) {
		return;
	}
	
	drawSquare(x1, y1, x2, y2, x3, y3, x4, y4);
	
	setTimeout(function () {
		drawSierpinskiCarpet(
				x1, y1-width*2/3,
				x2-width*2/3, y2-width*2/3,
				x3-width*2/3, y3,
				x4, y4);
		drawSierpinskiCarpet(
				x1+width/3, y1-width*2/3,
				x2-width/3, y2-width*2/3,
				x3-width/3, y3,
				x4+width/3, y4);
		drawSierpinskiCarpet(
				x1+width*2/3, y1-width*2/3,
				x2, y2-width*2/3,
				x3, y3,
				x4+width*2/3, y4);
		
		drawSierpinskiCarpet(
				x1, y1-width/3,
				x2-width*2/3, y2-width/3,
				x3-width*2/3, y3+width/3,
				x4, y4+width/3);
	/* 	drawSierpinskiCarpet(
				x1+width/3, y1-width/3,
				x2-width/3, y2-width/3,
				x3-width/3, y3+width/3,
				x4+width/3, y4+width/3); */
		drawSierpinskiCarpet(
				x1+width*2/3, y1-width/3,
				x2, y2-width/3,
				x3, y3+width/3,
				x4+width*2/3, y4+width/3);
		
		drawSierpinskiCarpet(
				x1, y1,
				x2-width*2/3, y2,
				x3-width*2/3, y3+width*2/3,
				x4, y4+width*2/3);
		drawSierpinskiCarpet(
				x1+width/3, y1,
				x2-width/3, y2,
				x3-width/3, y3+width*2/3,
				x4+width/3, y4+width*2/3);
		drawSierpinskiCarpet(
				x1+width*2/3, y1,
				x2, y2,
				x3, y3+width*2/3,
				x4+width*2/3, y4+width*2/3);
		
	}, 300);
};

var drawSierpinskiCarpetAtCenter = function () {
	carpetContext.clearRect(0, 0, carpetCanvas.width, carpetCanvas.height);
	
	var width = $('#carpetSize').val();

	var x1 = carpetCanvas.width / 2 - width / 2;
	var y1 = carpetCanvas.height / 2 + width / 2;
	var x2 = carpetCanvas.width / 2 + width / 2;
	var y2 = carpetCanvas.height / 2 + width / 2;
	var x3 = carpetCanvas.width / 2 + width / 2;
	var y3 = carpetCanvas.height / 2 - width / 2;
	var x4 = carpetCanvas.width / 2 - width / 2;
	var y4 = carpetCanvas.height / 2 - width / 2;

	drawSierpinskiCarpet(x1, y1, x2, y2, x3, y3, x4, y4);
};
</script>