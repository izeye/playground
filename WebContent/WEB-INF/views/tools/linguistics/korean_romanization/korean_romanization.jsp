<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
var korean2Roman = function () {
	$.get('${API_PATH_KOREAN_ROMANIZATION_KOREAN_2_ROMAN}', {
		romanizationScheme: $('#romanizationScheme').val(),
		romanizationType: $('#romanizationType').val(),
		korean: $('#korean').val()
	}).done(function (data) {
		$('#romanizedKorean').text(data);
	});
};

var roman2Korean = function () {
	$.getJSON('${API_PATH_KOREAN_ROMANIZATION_ROMAN_2_KOREAN}', {
		romanizationScheme: $('#romanizationScheme').val(),
		romanizationType: $('#romanizationType').val(),
		roman: $('#roman').val()
	}).done(function (data) {
		$('#revertedRoman').text(data);
	});
};
</script>

<p>
This page provides Korean romanization with various schemes:
<a href="http://en.wikipedia.org/wiki/Revised_Romanization_of_Korean">Revised Romanization of Korean</a>,
<a href="http://en.wikipedia.org/wiki/Yale_Romanization#Korean">Yale</a>, and
<a href="http://en.wikipedia.org/wiki/McCune-Reischauer">McCune-Reischauer</a>.
</p>
<p>
Romanization has two types.
One is transliteration and the other is transcription.
Transliteration is for writing and transcription is for pronunciation.
Note that the Yale scheme doesn't support transcription.
</p>

<label for="romanizationScheme">Select a Korean romanization scheme:</label>
<select id="romanizationScheme">
<c:forEach var="romanizationScheme" items="${romanizationSchemes}">
	<option value="${romanizationScheme}">${romanizationScheme.getName()}</option>
</c:forEach>
</select>

<label for="romanizationType">Select a romanization type:</label>
<select id="romanizationType">
<c:forEach var="romanizationType" items="${romanizationTypes}">
	<option value="${romanizationType}">${romanizationType.getName()}</option>
</c:forEach>
</select>

<label for="korean">Enter Korean characters to romanize:</label>
<input id="korean" type="text" value="안녕하세요" /><br/>
<input type="button" value="Romanize" onclick="korean2Roman();" /><br/><br/>

<label for="romanizedKorean">Romanized Korean:</label>
<div id="romanizedKorean" class="well">
</div>

<label for="roman">Enter roman characters to revert to Korean:</label>
<input id="roman" type="text" value="annyeonghaseyo" /><br/>
<input type="button" value="Revert to Korean" onclick="roman2Korean();" /><br/><br/>

<label for="revertedRoman">Reverted Korean:</label>
<div id="revertedRoman" class="well">
</div>

<div class="well">
<span class="label label-important">Note</span>
I guess this might be quite buggy because of my ignorance on Korean romanization.
So let me know by email (izeye@naver.com) when any problem occurs.
Then I'll fix it ASAP :-)
</div>