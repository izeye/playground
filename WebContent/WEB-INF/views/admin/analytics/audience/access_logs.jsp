<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p><b>Access Logs</b></p>
<table class="table table-striped table-bordered table-condensed" style="font-size: 12px">
<tr><th>Time</th><th>IP</th><th>URL</th><th>User Agent</th><th>Referrer</th></tr>
<c:forEach var="accessLog" items="${allAccessLogs}">
	<tr>
		<td>${accessLog.getAccessTime()}</td>
		<td>${accessLog.getIp()}</td>
		<td>${accessLog.getUrl()}</td>
		<td>${accessLog.getUserAgent()}</td>
		<td>${accessLog.getReferer()}</td>
	</tr>
</c:forEach>
</table>
