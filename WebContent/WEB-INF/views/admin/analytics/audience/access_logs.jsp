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
		<c:set var="ip" value="${accessLog.getIp()}" />
		<c:set var="userAgent" value="${accessLog.getUserAgent()}" />
		<c:set var="analyzedUserAgent" value="${userAgentAnalyzer.analyze(userAgent)}" />
		<tr>
			<td>${accessLog.getId()}</td>
			<td><fmt:formatDate value="${accessLog.getAccessTime()}"
					pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<c:set var="analyzedIp" value="${ipAnalyzer.analyze(ip)}"></c:set>
			<td title="${analyzedIp.getLocation()}">
			${ip}
			<c:if test="${analyzedUserAgent.isBot()}">
				<span class="label label-info">Bot</span>
			</c:if>
			<span class="label label-info">${analyzedIp.getCountry().getName()}</span>
			</td>
			<td>${accessLog.getUrl()}</td>
			<c:choose>
			<c:when test="${analyzedUserAgent.isSpam()}">
				<td><span class="label label-warning">Blocked spam</span></td>
				<td><span class="label label-warning">Blocked spam</span></td>
			</c:when>
			<c:otherwise>
				<td title="${analyzedUserAgent.getDisplayName()}">${accessLog.getEscapedUserAgent()}</td>
				<td>${accessLog.getReferer()}</td>
			</c:otherwise>
			</c:choose>
		</tr>
	</c:forEach>
</table>
