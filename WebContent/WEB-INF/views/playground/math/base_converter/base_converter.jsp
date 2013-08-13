<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
var convert = function () {
	$.get('/playground/math/base_converter/api', {
		sourceBase: $('#sourceBase').val(),
		targetBase: $('#targetBase').val(),
		numberToConvert: $('#numberToConvert').val()
	}).done(function (data) {
		$('#convertedNumber').text(data);
	});
};
</script>

<p>
This page provides converting among bases of 2, 8, 10, and 16.
</p>

<label for="sourceBase">Source base:</label>
<select id="sourceBase">
<c:forEach var="base" items="${bases}">
	<option value="${base}">${base.getDisplayName()}</option>
</c:forEach>
</select>

<label for="targetBase">Target base:</label>
<select id="targetBase">
<c:forEach var="base" items="${bases}">
	<option value="${base}">${base.getDisplayName()}</option>
</c:forEach>
</select>

<label for="numberToConvert">Enter a number to convert:</label>
<input id="numberToConvert" type="text" /><br/>
<input type="button" value="Convert" onclick="convert();" /><br/><br/>

<label for="convertedNumber">Converted number:</label>
<div id="convertedNumber" class="well">
</div>
