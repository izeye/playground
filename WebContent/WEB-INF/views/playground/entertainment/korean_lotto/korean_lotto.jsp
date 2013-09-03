<p>
This page generates Korean Lotto numbers :-)
</p>

<input type="button" value="Get lucky numbers" onclick="getLuckyNumbers();"><br/><br/>
<div id="result" class="well">
</div>

<script type="text/javascript">
var getLuckyNumbers = function () {
	$.getJSON('${API_PATH_KOREAN_LOTTO}', {
	}).done(function (data) {
		$('#result').text(data);
	});
};
</script>
