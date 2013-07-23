<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

<h2>World Clock</h2>

<p>
This page provides all clocks in the world
and you can find any clock you want by typing its time zone name in the Search box.
</p>

<table id="data" class="table table-striped table-bordered table-condensed" style="font-size: 12px">
	<thead>
		<tr>
			<th>Time Zone ID</th>
			<th>Time</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="timeZoneId" items="${timeZoneIds}">
			<tr>
				<fmt:timeZone value="${timeZoneId}">
					<td>${timeZoneId}</td>
					<td><fmt:formatDate value="${now}" type="both"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</fmt:timeZone>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script type="text/javascript">
	$(document).ready(function () {
		$('#data').dataTable({
			"bPaginate": false
		});
	});
</script>