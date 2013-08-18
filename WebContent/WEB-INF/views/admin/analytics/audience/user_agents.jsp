<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table table-striped table-bordered table-condensed"
	style="font-size: 12px">
	<tr>
		<th>#</th>
		<th>User Agent</th>
		<th>Count</th>
	</tr>
	<c:forEach var="i" begin="0" end="${userAgentCounts.size() - 1}" step="1">
		<c:set var="userAgentCount" value="${userAgentCounts.get(i)}" />
		<tr>
			<td>${i + 1}</td>
			<td>${userAgentCount.getUserAgent()}</td>
			<td>${userAgentCount.getCount()}</td>
		</tr>
	</c:forEach>
</table>
