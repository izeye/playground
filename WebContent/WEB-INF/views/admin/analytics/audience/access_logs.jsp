<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<p>
	<b>Access Logs (Delayed. At most 1 minute.)</b>
</p>
<style>
	table {
		table-layout: fixed
	}
	table th, table td {
		word-wrap: break-word
	}
</style>
<table class="table table-striped table-bordered table-condensed"
	style="font-size: 12px">
	<tr>
		<th style="width: 120px">Time</th>
		<th style="width: 100px">IP</th>
		<th>URL</th>
		<th>User Agent</th>
		<th>Referrer</th>
	</tr>
	<c:forEach var="accessLog" items="${allAccessLogs}">
		<tr>
			<td><fmt:formatDate value="${accessLog.getAccessTime()}"
					pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>${accessLog.getIp()}</td>
			<td>${accessLog.getUrl()}</td>
			<td>${accessLog.getUserAgent()}</td>
			<td>${accessLog.getReferer()}</td>
		</tr>
	</c:forEach>
</table>
