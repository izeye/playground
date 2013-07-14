<style type="text/css">
video {
	width: 307px;
	height: 250px;
	background: rgba(255, 255, 255, 0.5);
	border: 1px solid #ccc;
}
.grayscale {
	-webkit-filter: grayscale(1);
	-moz-filter: grayscale(1);
	-o-filter: grayscale(1);
	-ms-filter: grayscale(1);
	filter: grayscale(1);
}
.sepia {
	-webkit-filter: sepia(1);
	-moz-filter: sepia(1);
	-o-filter: sepia(1);
	-ms-filter: sepia(1);
	filter: sepia(1);
}
.blur {
	-webkit-filter: blur(3px);
	-moz-filter: blur(3px);
	-o-filter: blur(3px);
	-ms-filter: blur(3px);
	filter: blur(3px);
}
</style>

<h2>Webcam Live</h2>
<p>You can click to filter your image by gray scale, sepia, or blur.</p>

<video autoplay></video>
<script type="text/javascript">
window.URL = window.URL || window.webkitURL;
navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia ||
		navigator.mozGetUserMedia || navigator.msGetUserMedia;
		
var video = document.querySelector('video');

var idx = 0;
var filters = ['grayscale', 'sepia', 'blur', ''];

function changeFilter(e) {
	var el = e.target;
	el.className = '';
	var effect = filters[idx++ % filters.length];
	if (effect) {
		el.classList.add(effect);
	}
}

video.addEventListener('click', changeFilter, false);
		
function fallback(e) {
	console.log(e);
	console.log("Fallback here.");
}

function success(stream) {
	video.src = window.URL.createObjectURL(stream);
}

if (!navigator.getUserMedia) {
	fallback();
} else {
	navigator.getUserMedia({video: true}, success, fallback);
}
</script>