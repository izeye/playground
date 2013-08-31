<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
var korean2English = function () {
	$.get('${API_PATH_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_KOREAN_2_ENGLISH}', {
		keyboardLayoutType: $('#keyboardLayoutType').val(),
		korean: $('#korean').val()
	}).done(function (data) {
		$('#fixedEnglish').text(data);
	});
};

var english2Korean = function () {
	$.get('${API_PATH_KOREAN_ENGLISH_LANGUAGE_SWITCH_TYPE_FIXER_ENGLISH_2_KOREAN}', {
		keyboardLayoutType: $('#keyboardLayoutType').val(),
		english: $('#english').val()
	}).done(function (data) {
		$('#fixedKorean').text(data);
	});
};
</script>

<p>
This page provides fixing typos by Korean/English language switching mistakes.
</p>

<label for="keyboardLayoutType">Select a keyboard layout:</label>
<select id="keyboardLayoutType">
<c:forEach var="keyboardLayoutType" items="${keyboardLayoutTypes}">
	<option value="${keyboardLayoutType}">${keyboardLayoutType.getName()}</option>
</c:forEach>
</select>

<label for="korean">Enter Korean characters to have been intended to English:</label>
<input id="korean" type="text" value="ㅗ디ㅣㅐ, 재깅!" /><br/>
<input type="button" value="Fix" onclick="korean2English();" /><br/><br/>

<label for="fixedKorean">Fixed English:</label>
<div id="fixedEnglish" class="well">
</div>

<label for="english">Enter English characters to have been intended to Korean:</label>
<input id="english" type="text" value="dkssudgktpdy" /><br/>
<input type="button" value="Fix" onclick="english2Korean();" /><br/><br/>

<label for="fixedKorean">Fixed Korean:</label>
<div id="fixedKorean" class="well">
</div>
