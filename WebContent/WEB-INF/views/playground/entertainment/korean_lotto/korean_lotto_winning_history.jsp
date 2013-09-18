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
var lastWinningLogIncluded = false;

var thisYear = ${thisYear};
var nYearsBefore = 1;
var more = function () {
	$.getJSON('${API_PATH_KOREAN_LOTTO_WINNING_HISTORY}', {
		year: thisYear - nYearsBefore
	}).done(function (data) {
		for (var i in data) {
			var winningLog = data[i];
			var sequence = winningLog.sequence;
			if (sequence == 1) {
				lastWinningLogIncluded = true;
			}
			
			var row =
					'<tr>' +
					'<td>' + sequence + '</td>' +
					'<td>' + winningLog.day + '</td>' +
					'<td>' + winningLog.numbers + '</td>' +
					'<td>' + winningLog.formattedPrize1 + '</td>' +
					'<td>' + winningLog.formattedPrize2 + '</td>' +
					'<td>' + winningLog.formattedPrize3 + '</td>' +
					'<td>' + winningLog.formattedPrize4 + '</td>' +
					'<td>' + winningLog.formattedPrize5 + '</td>' +
					'</tr>';
			$('#winning_history').append(row);
		}
		
		if (lastWinningLogIncluded) {
			$('#moreButton').remove();
		} else {
			nYearsBefore += 1;
			$('#moreButton').val('Show ' + nYearsBefore + ' years before');
		}
	});
};
</script>

<p>
This page provides history of Korean Lotto winning numbers.
</p>

<table id="winning_history" class="table table-striped table-bordered table-condensed"
		style="font-size: 12px">
	<tr>
		<th style="width: 75px">Sequence</th>
		<th style="width: 100px">Day</th>
		<th style="width: 150px">Numbers</th>
		<th>Prize 1</th>
		<th>Prize 2</th>
		<th>Prize 3</th>
		<th>Prize 4</th>
		<th>Prize 5</th>
	</tr>
	<c:forEach var="winningLog" items="${winningLogs}">
		<tr class="logRow">
			<td>${winningLog.getSequence()}</td>
			<td>${winningLog.getDay()}</td>
			<td>${winningLog.getNumbers()}</td>
			<td>${winningLog.getFormattedPrize1()}</td>
			<td>${winningLog.getFormattedPrize2()}</td>
			<td>${winningLog.getFormattedPrize3()}</td>
			<td>${winningLog.getFormattedPrize4()}</td>
			<td>${winningLog.getFormattedPrize5()}</td>
		</tr>
	</c:forEach>
</table>

<input id="moreButton" type="button" value="Show 1 year before" onclick="more()" />
