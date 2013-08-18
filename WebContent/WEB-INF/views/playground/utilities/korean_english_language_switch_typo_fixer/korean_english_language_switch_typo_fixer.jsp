<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
var korean2English = function () {
	$.get('/playground/utilities/korean_english_language_switch_typo_fixer/korean2english/api', {
		korean: $('#korean').val()
	}).done(function (data) {
		$('#fixedEnglish').text(data);
	});
};

var english2Korean = function () {
	$.get('/playground/utilities/korean_english_language_switch_typo_fixer/english2korean/api', {
		english: $('#english').val()
	}).done(function (data) {
		$('#fixedKorean').text(data);
	});
};
</script>

<p>
This page provides fixing typos by Korean/English language switching mistakes
(Only <a href="http://en.wikipedia.org/wiki/Keyboard_layout#Dubeolsik">Dubeolsik</a> supported).
</p>

<b>Enter Korean characters to have been intended to English:</b><br/>
<input id="korean" type="text" value="ㅗ디ㅣㅐ, 재깅!" /><br/>
<input type="button" value="Fix" onclick="korean2English();" /><br/><br/>

<b>Fixed English:</b>
<div id="fixedEnglish" class="well">
</div>

<b>Enter English characters to have been intended to Korean:</b><br/>
<input id="english" type="text" value="dkssudgktpdy" /><br/>
<input type="button" value="Fix" onclick="english2Korean();" /><br/><br/>

<b>Fixed Korean:</b>
<div id="fixedKorean" class="well">
</div>
