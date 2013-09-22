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
var KOREAN_LOTTO = {};

KOREAN_LOTTO.latestSequence = ${latestSequence};
KOREAN_LOTTO.sequence = KOREAN_LOTTO.latestSequence;

var generate = function () {
	$.getJSON('${API_PATH_KOREAN_LOTTO_GENERATION_GENERATE}', {
	}).done(function (data) {
		$('#result').text(data);
		
		$('.logRow').remove();
		more();
		
		// FIXME:
		// This latest sequence could be out of date.
		KOREAN_LOTTO.sequence = KOREAN_LOTTO.latestSequence;
	});
};

var more = function (sequence) {
	$.getJSON('${API_PATH_KOREAN_LOTTO_GENERATION_HISTORY}', {
		sequence: sequence
	}).done(function (data) {
		for (var i in data) {
			var log = data[i];
			var logRow =
					'<tr class="logRow">' +
						'<td>' + log.id + '</td>' +
						'<td>' + (log.sequence == null ? 'N/A' : log.sequence) + '</td>' +
						'<td>' + log.formattedGeneratedTime + '</td>' + 
						'<td>' + log.numbers + '</td>' + 
						'<td>' + (log.rank == null ? 'N/A' : log.rank) + '</td>' + 
						'<td>' + (log.formattedPrize) + '</td>' + 
						'<td>' + log.ip + '</td>' +
					'</tr>';
			$('#history').append(logRow);
		}
		
		if (sequence) {
			if (KOREAN_LOTTO.sequence == 1) {
				$('moreButton').remove();
			} else {
				KOREAN_LOTTO.sequence -= 1;
				$('#moreButton').val('Show the sequence ' + KOREAN_LOTTO.sequence);
			}
		}
	});
};
</script>

<p>
This page generates Korean Lotto numbers.
</p>

<input type="button" value="Get lucky numbers" onclick="generate();"><br/><br/>
<div id="result" class="well">
</div>

<table id="history" class="table table-striped table-bordered table-condensed"
	style="font-size: 12px">
	<tr>
		<th style="width: 75px">ID</th>
		<th style="width: 75px">Sequence</th>
		<th style="width: 120px">Time</th>
		<th style="width: 150px">Numbers</th>
		<th style="width: 30px">Rank</th>
		<th style="width: 75px">Prize</th>
		<th>IP Address</th>
	</tr>
	<c:forEach var="latestGenerationLog" items="${latestGenerationLogs}">
		<c:set var="sequence" value="${latestGenerationLog.getSequence()}" />
		<c:set var="rank" value="${latestGenerationLog.getRank()}" />
		<tr class="logRow">
			<td>${latestGenerationLog.getId()}</td>
			<td>${sequence == null ? "N/A" : sequence}</td>
			<td>${latestGenerationLog.getFormattedGeneratedTime()}</td>
			<td>${latestGenerationLog.getNumbers()}</td>
			<td>${rank == null ? "N/A" : rank}</td>
			<td>${latestGenerationLog.getFormattedPrize()}</td>
			<td>${latestGenerationLog.getIp()}</td>
		</tr>
	</c:forEach>
</table>

<input id="moreButton" type="button" value="Show the sequence ${latestSequence}" onclick="more(KOREAN_LOTTO.sequence);" />
