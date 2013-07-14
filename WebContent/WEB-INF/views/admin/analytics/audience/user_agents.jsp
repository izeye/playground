<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table table-striped table-bordered table-condensed"
	style="font-size: 12px">
	<tr>
		<th>User Agent</th>
		<th>Count</th>
	</tr>
	<c:forEach var="userAgentCount" items="${userAgentCounts}">
		<tr>
			<td>${userAgentCount.getUserAgent()}</td>
			<td>${userAgentCount.getCount()}</td>
		</tr>
	</c:forEach>
</table>
