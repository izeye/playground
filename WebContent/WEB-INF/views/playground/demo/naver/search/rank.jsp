<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
var getRanks = function () {
	$.get('${API_PATH_NAVER_SEARCH_RANK}', {
		rankType: $('#rankType').val()
	}).done(function (data) {
		$('.rankRow').remove();
		for (var i in data) {
			var rank = data[i];
			var row =
					'<tr class="rankRow">' +
					'<td>' + rank.rank + '</td>' +
					'<td>' + rank.keyword + '</td>' +
					'<td><font color="';
			switch (rank.status) {
			case 'PLUS':
			case 'NEW':
				row += 'red';
				break;
				
			case 'MINUS':
				row += 'blue';
				break;
				
			default:
				row += 'black';
				break;
			}
			row +=
					'">';
			row += rank.formattedStatus;
			row +=
					'</font></td>' +
					'</tr>';
			$('#ranks').append(row);
		}
	});
};
</script>

<p>This is a page for Naver search rank.</p>

<label for="rankType">Rank type:</label>
<select id="rankType">
<c:forEach var="rankType" items="${rankTypes}">
	<option value="${rankType}">${rankType.getName()}</option>
</c:forEach>
</select>
<input type="button" value="Get Ranks" onclick="getRanks();" />

<table id="ranks" class="table table-striped table-bordered table-condensed"
		style="font-size: 12px">
	<tr>
		<th style="width: 50px">Rank</th>
		<th style="width: 200px">Keyword</th>
		<th style="width: 200px">Status</th>
	</tr>
</table>
