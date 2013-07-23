<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="<c:url value="/resources/kakao/js/kakao.link.js" />"></script>

<script type="text/javascript">
var send = function () {
	var message = $('#message').val();
	var url = $('#url').val();
	kakao.link('talk').send({
		msg: message,
		url: url,
		appid: 'izeye.cafe24.com',
		appver: '1.0',
		appname: 'izeye\'s Playground',
		type: "link"
	});
};
</script>

<h2>KakaoLink Demo</h2>

<p>This page provides sending a KakaoTalk message via KakaoLink API.</p>

<label for="message">Message</label>
<input type="text" id="message" value="Come and play with me :-)">
<label for="url">URL</label>
<input type="text" id="url" value="http://izeye.cafe24.com"><br/>
<input type="button" value="Send" onclick="send();">