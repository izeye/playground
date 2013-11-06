<script src='https://cdn.firebase.com/v0/firebase.js'></script>

<input type="text" id="nameInput" placeholder="Name">
<input type="text" id="messageInput" placeholder="Message">
<div id="messagesDiv"></div>

<script type="text/javascript">
	var myDataRef = new Firebase('https://k14lcllnc3c.firebaseio-demo.com/');
	$('#messageInput').keypress(function(e) {
		if (e.keyCode == 13) {
			var name = $('#nameInput').val();
			var text = $('#messageInput').val();
			//myDataRef.set('User ' + name + ' says ' + text);
			//myDataRef.set({name: name, text: text});
			myDataRef.push({
				name : name,
				text : text
			});
			$('#messageInput').val('');
		}
	});
	myDataRef.on('child_added', function(snapshot) {
		//console.log(snapshot);

		var message = snapshot.val();
		displayChatMessage(message.name, message.text);
	});
	function displayChatMessage(name, text) {
		$('<div/>').text(text).prepend($('<em/>').text(name + ': ')).prependTo(
				$('#messagesDiv'));
		$('#messagesDiv')[0].scrollTop = $('#messagesDiv')[0].scrollHeight;
	}
</script>
