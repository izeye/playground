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
	<b>QR Code Generation Logs</b>
</p>
<table class="table table-striped table-bordered table-condensed"
	style="font-size: 12px">
	<tr>
		<th style="width: 30px">ID</th>
		<th style="width: 120px">Time</th>
		<th style="width: 500px">Text</th>
		<th style="width: 30px">Size</th>
		<th>IP Address</th>
	</tr>
	<c:forEach var="qrCodeGenerationLog" items="${allQRCodeGenerationLogs}">
		<tr>
			<td>${qrCodeGenerationLog.getId()}</td>
			<td><fmt:formatDate value="${qrCodeGenerationLog.getGeneratedTime()}"
					pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>${qrCodeGenerationLog.getText()}</td>
			<td>${qrCodeGenerationLog.getSize()}</td>
			<td>${qrCodeGenerationLog.getIp()}</td>
		</tr>
	</c:forEach>
</table>
