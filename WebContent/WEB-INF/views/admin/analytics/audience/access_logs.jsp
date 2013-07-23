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

<p>
	<b>Access Logs (Delayed. At most 1 minute.)</b>
</p>
<table class="table table-striped table-bordered table-condensed"
	style="font-size: 12px">
	<tr>
		<th style="width: 30px">ID</th>
		<th style="width: 120px">Time</th>
		<th style="width: 100px">IP</th>
		<th>URL</th>
		<th>User Agent</th>
		<th>Referrer</th>
	</tr>
	<c:forEach var="accessLog" items="${latestAccessLogs}">
		<c:set var="ip" value="${accessLog.getIp()}"></c:set>
		<c:set var="userAgent" value="${accessLog.getUserAgent()}"></c:set>
		<tr>
			<td>${accessLog.getId()}</td>
			<td><fmt:formatDate value="${accessLog.getAccessTime()}"
					pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td title="${ipAnalyzer.analyze(ip).getLocation()}">${ip}</td>
			<td>${accessLog.getUrl()}</td>
			<td title="${userAgentAnalyzer.analyze(userAgent).getDisplayName()}">${userAgent}</td>
			<td>${accessLog.getReferer()}</td>
		</tr>
	</c:forEach>
</table>
