<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p><b>Daily Count</b></p>
<table class="table table-striped table-bordered table-condensed" style="font-size: 12px">
<tr><th>Day</th><th>Pageviews</th><th>Unique Visitors</th></tr>
<c:forEach var="dailyCount" items="${dailyCounts}">
	<tr>
		<td>${dailyCount.getDay()}</td>
		<td>${dailyCount.getPageviews()}</td>
		<td>${dailyCount.getUniqueVistors()}</td>
	</tr>
</c:forEach>
</table>
