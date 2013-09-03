<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
	table {
		table-layout: fixed
	}
	table th, table td {
		word-wrap: break-word
	}
</style>

<script type="text/javascript">
var bot = "<span class=\"label label-info\">Bot</span>";

var today = '${today}';
var nDaysBefore = 1;
var total = ${accessLogs.size()};
var more = function () {
	$.getJSON('${API_PATH_AUDIENCE_ACCESS_LOGS}', {
		today: today,
		nDaysBefore: nDaysBefore
	}).done(function (data) {
		for (var i in data) {
			var accessLog = data[i];
			var referer = accessLog.referer;
			var analyzedIp = accessLog.analyzedIp;
			var analyzedUserAgent = accessLog.analyzedUserAgent;
			
			var row = '<tr><td>' + accessLog.id;
			if (analyzedUserAgent.bot) {
				row += ' ' + bot;
			}
			row += '</td><td>' + accessLog.formattedAccessTime +
					'</td><td title=\"' + analyzedIp.location +
					'\">' + accessLog.ip +
					' <span class="label">' + analyzedIp.country.name +
					'</span></td><td>' + accessLog.url +
					'</td><td title=\"' + analyzedUserAgent.displayName +
					'\">' + accessLog.userAgent +
					'</td><td>';
			row += referer == null ? '&nbsp;' : referer;
			row += '</td></tr>';
			$('#result').append(row);
		}
		
		nDaysBefore += 1;
		$('#moreButton').val('Show ' + nDaysBefore + ' days before');
		
		total += data.length;
		$('#total').text('Total: ' + total);
	});
};
</script>

<p>
	<b>Access Logs (Delayed. At most 1 minute.)</b>
</p>

<p id="total">
Total: ${accessLogs.size()}
</p>

<table id="result" class="table table-striped table-bordered table-condensed"
	style="font-size: 12px">
	<tr>
		<th style="width: 30px">ID</th>
		<th style="width: 120px">Time</th>
		<th style="width: 100px">IP</th>
		<th>URL</th>
		<th>User Agent</th>
		<th>Referrer</th>
	</tr>
	<c:forEach var="accessLog" items="${accessLogs}">
		<c:set var="ip" value="${accessLog.getIp()}" />
		<c:set var="userAgent" value="${accessLog.getUserAgent()}" />
		<c:set var="analyzedUserAgent" value="${accessLog.getAnalyzedUserAgent()}" />
		<tr>
			<td>
				${accessLog.getId()}
				<c:if test="${analyzedUserAgent.isBot()}">
					<span class="label label-info">Bot</span>
				</c:if>
			</td>
			<td><fmt:formatDate value="${accessLog.getAccessTime()}"
					pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<c:set var="analyzedIp" value="${accessLog.getAnalyzedIp()}"></c:set>
			<td title="${analyzedIp.getLocation()}">
			${ip}
			<span class="label">${analyzedIp.getCountry().getName()}</span>
			</td>
			<td>${accessLog.getUrl()}</td>
			<td title="${analyzedUserAgent.getDisplayName()}">${accessLog.getEscapedUserAgent()}</td>
			<td>${accessLog.getReferer()}</td>
		</tr>
	</c:forEach>
</table>

<input id="moreButton" type="button" value="Show 1 day before" onclick="more()" />
