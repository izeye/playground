<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
var calculate = function () {
	$.getJSON('${API_PATH_MEAN}', {
		meanType: $('#meanType').val(),
		numbers: $('#numbers').val()
	}).done(function (data) {
		$('#result').text(data);
	});
};
</script>

<p>
This page calculates various means,
especially the Pythagorean means
- the arithmetic mean, the geometric mean, and the harmonic mean.
</p>

<label for="beanType">Select a mean type:</label>
<select id="meanType">
<c:forEach var="meanType" items="${meanTypes}">
	<option value="${meanType}">${meanType.getName()}</option>
</c:forEach>
</select>
<label for="numbers">Enter comma-separated numbers to calculate the selected mean:</label>
<input type="text" id="numbers" value="1,2,3,4,5"><br/>
<input type="button" value="Solve" onclick="calculate();"><br/><br/>
<div id="result" class="well">
</div>

<p>
For more information, visit
<a href="http://en.wikipedia.org/wiki/Average" target="_blank">Average on Wikepedia</a>.
</p>
