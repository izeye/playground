<h3>Webcam Snapshots</h3>

<p>You can click to get snapshots of your image.</p>

<video width="400" height="300" autoplay></video>
<div id="snapshots"></div>
<canvas width="400" height="300" style="display:none;"></canvas>

<script type="text/javascript">
window.URL = window.URL || window.webkitURL;
navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia ||
		navigator.mozGetUserMedia || navigator.msGetUserMedia;
		
var video = document.querySelector('video');
var canvas = document.querySelector('canvas');
var ctx = canvas.getContext('2d');
var localMediaStream = null;

function snapshot() {
	if (localMediaStream) {
		ctx.drawImage(video, 0, 0, 400, 300);
		//var img = document.querySelector('img');
		var snapshots = document.querySelector('#snapshots');
		var img = document.createElement('img');
		img.src = canvas.toDataURL('image/webp');
		img.width = 400 / 4;
		img.height = 300 / 4;
		//snapshots.appendChild(img);
		snapshots.insertBefore(img, snapshots.firstChild);
	}
}

video.addEventListener('click', snapshot, false);

var onFailSoHard = function (e) {
	console.log("Rejected!", e);
};

navigator.getUserMedia({video: true}, function (stream) {
	video.src = window.URL.createObjectURL(stream);
	localMediaStream = stream;
}, onFailSoHard);
</script>