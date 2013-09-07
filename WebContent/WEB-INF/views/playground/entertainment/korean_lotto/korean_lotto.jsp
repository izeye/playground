<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
	table {
		table-layout: fixed
	}
	table th, table td {
		word-wrap: break-word
	}
</style>

<script type="text/javascript">
var getLuckyNumbers = function () {
	$.getJSON('${API_PATH_KOREAN_LOTTO_GENERATE}', {
	}).done(function (data) {
		$('#result').text(data);
		
		getHistory();
	});
};

var getHistory = function () {
	$.getJSON('${API_PATH_KOREAN_LOTTO_HISTORY}', {
	}).done(function (data) {
		$('.logRow').remove();
		for (var i in data) {
			var log = data[i];
			var logRow =
					'<tr class="logRow">' +
						'<td>' + log.id + '</td>' +
						'<td>' + log.formattedGeneratedTime + '</td>' + 
						'<td>' + log.numbers + '</td>' + 
						'<td>' + log.ip + '</td>';
					'</tr>'
			$('#history').append(logRow);
		}
	});
};
</script>

<p>
This page generates Korean Lotto numbers.
</p>

<input type="button" value="Get lucky numbers" onclick="getLuckyNumbers();"><br/><br/>
<div id="result" class="well">
</div>

<table id="history" class="table table-striped table-bordered table-condensed"
	style="font-size: 12px">
	<tr>
		<th style="width: 30px">ID</th>
		<th style="width: 120px">Time</th>
		<th style="width: 150px">Numbers</th>
		<th>IP Address</th>
	</tr>
	<c:forEach var="allKoreanLottoLog" items="${allKoreanLottoLogs}">
		<tr class="logRow">
			<td>${allKoreanLottoLog.getId()}</td>
			<td>${allKoreanLottoLog.getFormattedGeneratedTime()}</td>
			<td>${allKoreanLottoLog.getNumbers()}</td>
			<td>${allKoreanLottoLog.getIp()}</td>
		</tr>
	</c:forEach>
</table>
