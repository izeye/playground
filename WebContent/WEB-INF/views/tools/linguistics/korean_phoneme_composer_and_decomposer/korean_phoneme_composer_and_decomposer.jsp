<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
var compose = function () {
	$.get('${API_PATH_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_COMPOSE}', {
		commaSeparatedPhonemes: $('#commaSeparatedPhonemes').val()
	}).done(function (data) {
		$('#composedPhonemes').text(data);
	});
};

var decompose = function () {
	$.get('${API_PATH_KOREAN_PHONEME_COMPOSER_AND_DECOMPOSER_DECOMPOSE}', {
		wordToDecompose: $('#wordToDecompose').val()
	}).done(function (data) {
		$('#decomposedPhonemes').text(data);
	});
};
</script>

<p>
This page provides Korean phoneme composing and decomposing.
</p>

<b>Enter a comma-separated phoneme list to compose:</b><br/>
<input id="commaSeparatedPhonemes" type="text" value="ㅇ,ㅏ,ㄴ,ㄴ,ㅕ,ㅇ,ㅎ,ㅏ,ㅅ,ㅔ,ㅇ,ㅛ" /><br/>
<input type="button" value="Compose" onclick="compose();" /><br/><br/>

<b>Composed phonemes:</b>
<div id="composedPhonemes" class="well">
</div>

<b>Enter a word to decompose to phonemes:</b><br/>
<input id="wordToDecompose" type="text" value="안녕하세요" /><br/>
<input type="button" value="Decompose" onclick="decompose();" /><br/><br/>

<b>Decomposed phonemes:</b>
<div id="decomposedPhonemes" class="well">
</div>
