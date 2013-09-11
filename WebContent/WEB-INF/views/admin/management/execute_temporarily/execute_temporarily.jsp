<script type="text/javascript">
var migrate = function () {
	$.get('${API_PATH_EXECUTE_TEMPORARILY}', {
	}).done(function (data) {
		alert(data);
	});
};
</script>

Migrate Korean Lotto winning logs from CSV to DB:
<input type="button" value="Migrate" onclick="migrate();" />