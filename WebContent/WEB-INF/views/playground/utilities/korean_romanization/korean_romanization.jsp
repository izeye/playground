<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
var korean2Roman = function () {
	$.get('/playground/utilities/korean_romanization/korean2roman/api', {
		romanizationScheme: $('#romanizationScheme').val(),
		korean: $('#korean').val()
	}).done(function (data) {
		$('#romanizedKorean').text(data);
	});
};

var roman2Korean = function () {
	$.get('/playground/utilities/korean_romanization/roman2korean/api', {
		romanizationScheme: $('#romanizationScheme').val(),
		roman: $('#roman').val()
	}).done(function (data) {
		$('#transliteratedRoman').text(data);
	});
};
</script>

<p>
This page provides Korean romanization with various schemes:
<a href="http://en.wikipedia.org/wiki/Revised_Romanization_of_Korean">Revised Romanization of Korean</a>,
<a href="http://en.wikipedia.org/wiki/Yale_Romanization#Korean">Yale</a>, and
<a href="http://en.wikipedia.org/wiki/McCune-Reischauer">McCune-Reischauer</a>.
</p>

<label for="romanizationScheme">Select a Korean romanization shceme:</label>
<select id="romanizationScheme">
<c:forEach var="romanizationScheme" items="${romanizationSchemes}">
	<option value="${romanizationScheme}">${romanizationScheme.getName()}</option>
</c:forEach>
</select>

<label for="korean">Enter Korean characters to romanize:</label>
<input id="korean" type="text" value="안녕하세요" /><br/>
<input type="button" value="Romanize" onclick="korean2Roman();" /><br/><br/>

<label for="romanizedKorean">Romanized Korean:</label>
<div id="romanizedKorean" class="well">
</div>

<label for="roman">Enter roman characters to transliterate to Korean:</label>
<input id="roman" type="text" value="annyeonghaseyo" /><br/>
<input type="button" value="Transliterate to Korean" onclick="roman2Korean();" /><br/><br/>

<label for="transliteratedRoman">Transliterated Roman:</label>
<div id="transliteratedRoman" class="well">
</div>
