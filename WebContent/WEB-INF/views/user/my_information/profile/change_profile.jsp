<script type="text/javascript">
var change = function () {
	$.getJSON('${API_PATH_CHANGE_PROFILE}', {
	}).done(function (data) {
		console.log(data);
	});
}
</script>

<input type="button" value="Change" onclick="change();" />