<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p><b>Daily Count</b></p>
<table class="table">
<tr><th>Day</th><th>Pageviews</th><th>Unique Visitors</th></tr>
<c:forEach var="dailyCount" items="${dailyCounts}">
	<tr>
		<td>${dailyCount.getDay()}</td>
		<td>${dailyCount.getPageviews()}</td>
		<td>${dailyCount.getUniqueVistors()}</td>
	</tr>
</c:forEach>
</table>
