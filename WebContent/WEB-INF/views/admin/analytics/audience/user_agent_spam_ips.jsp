<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table table-striped table-bordered table-condensed"
	style="font-size: 12px">
	<tr>
		<th>#</th>
		<th>User Agent Spam IP</th>
		<th>Count</th>
	</tr>
	<c:forEach var="i" begin="1" end="${userAgentSpamIPCounts.size()}" step="1">
		<c:set var="userAgentSpamIPCount" value="${userAgentSpamIPCounts.get(i - 1)}" />
		<tr>
			<td>${i}</td>
			<td>${userAgentSpamIPCount.getIp()}</td>
			<td>${userAgentSpamIPCount.getCount()}</td>
		</tr>
	</c:forEach>
</table>
