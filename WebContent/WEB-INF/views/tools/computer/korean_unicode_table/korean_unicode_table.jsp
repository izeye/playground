<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
	table {
		table-layout: fixed
	}
	table th, table td {
		word-wrap: break-word
	}
</style>

<p>
This page provides Korean character and Unicode mapping.
</p>

<c:set var="size" value="${allUnicodes.size()}" />

<table class="table table-striped table-bordered table-condensed" style="font-size: 12px">
	<c:forEach var="i" begin="0" end="${size}" step="16">
	<tr>
		<c:forEach var="j" begin="0" end="15">
			<td>
			<c:choose>
				<c:when test="${i + j < size}">
					<c:set var="unicode" value="${allUnicodes.get(i + j)}" />
					${unicode.getValue()} ${unicode.getHexCode()}
				</c:when>
				<c:otherwise>
					&nbsp;
				</c:otherwise>
			</c:choose>
			</td>
		</c:forEach>
	</tr>
	</c:forEach>
</table>