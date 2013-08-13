<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
var convert = function () {
	$.get('/playground/utilities/multi_word_notation_converter/api', {
		sourceNotation: $('#sourceNotation').val(),
		targetNotation: $('#targetNotation').val(),
		stringToConvert: $('#stringToConvert').val()
	}).done(function (data) {
		$('#convertedString').text(data);
	});
};
</script>

<p>
This page provides converting among multi-word notations of CamelCase and underscore.
</p>

<label for="sourceNotation">Source notation:</label>
<select id="sourceNotation">
<c:forEach var="notation" items="${notations}">
	<option value="${notation}">${notation.getName()}</option>
</c:forEach>
</select>

<label for="targetNotation">Target notation:</label>
<select id="targetNotation">
<c:forEach var="notation" items="${notations}">
	<option value="${notation}">${notation.getName()}</option>
</c:forEach>
</select>

<label for="stringToConvert">Enter a string to convert:</label>
<input id="stringToConvert" type="text" /><br/>
<input type="button" value="Convert" onclick="convert();" /><br/><br/>

<label for="convertedString">Converted string:</label>
<div id="convertedString" class="well">
</div>
