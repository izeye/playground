<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p>
Total: ${userAgentSpamIpCounts.size()}
</p>

<table class="table table-striped table-bordered table-condensed"
	style="font-size: 12px">
	<tr>
		<th>#</th>
		<th>User Agent Spam IP</th>
		<th>Count</th>
	</tr>
	<c:forEach var="i" begin="1" end="${userAgentSpamIpCounts.size()}" step="1">
		<c:set var="userAgentSpamIpCount" value="${userAgentSpamIpCounts.get(i - 1)}" />
		<c:set var="analyzedIp" value="${userAgentSpamIpCount.getAnalyzedIp()}" />
		<tr>
			<td>${i}</td>
			<td>
				${userAgentSpamIpCount.getIp()}
				<span class="label">${analyzedIp.getCountry().getName()}</span>
			</td>
			<td>${userAgentSpamIpCount.getCount()}</td>
		</tr>
	</c:forEach>
</table>
