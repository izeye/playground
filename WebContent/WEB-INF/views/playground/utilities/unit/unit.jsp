<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p>
This page provides converting among units of temperature, length, mass, speed, volume, area, fuel consumption, time, and digital storage.
</p>

<label for="unitType">Unit type:</label>
<select id="unitType" onchange="selectUnitType();">
<c:forEach var="unitType" items="${unitTypes}">
	<option value="${unitType.name()}">${unitType.getName()}</option>
</c:forEach>
</select>

<label for="sourceUnit">Source unit:</label>
<select id="sourceUnit">
</select>

<label for="targetUnit">Target unit:</label>
<select id="targetUnit">
</select>

<label for="valueToConvert">Enter a value to convert:</label>
<input id="valueToConvert" type="text" /><br/>
<input type="button" value="Convert" onclick="convert();" /><br/><br/>

<label for="convertedValue">Converted value:</label>
<div id="convertedValue" class="well">
</div>

<script type="text/javascript">
var unitTypeNames = [];
var unitTypes = [];

<c:forEach var="unitType" items="${unitTypes}">
	unitTypeNames.push("${unitType.name()}");
	unitTypes.${unitType.name()} = [];
	<c:forEach var="unit" items="${unitType.getUnits()}">
		unitTypes.${unitType.name()}.push({name: "${unit.getName()}", key: "${unit.getKey()}"});
	</c:forEach>
</c:forEach>

console.log(unitTypeNames);
console.log(unitTypes);

var setUnitType = function (unitType) {
	$("#sourceUnit").empty();
	$.each(unitTypes[unitType], function (index, value) {
		$("#sourceUnit").append("<option value='" + value.key + "'>" + value.name + "</option>");
	});
	
	$("#targetUnit").empty();
	$.each(unitTypes[unitType], function (index, value) {
		$("#targetUnit").append("<option value='" + value.key + "'>" + value.name + "</option>");
	});
};

var selectUnitType = function () {
	setUnitType($("#unitType").val());
};

var convert = function () {
	$.get("/playground/utilities/unit_conversion/json", {
		unitType: $("#unitType").val(),
		sourceUnit: $("#sourceUnit").val(),
		targetUnit: $("#targetUnit").val(),
		valueToConvert: $("#valueToConvert").val()
	}).done(function (data) {
		$("#convertedValue").text(data);
	});
};

$(function () {
	setUnitType(unitTypeNames[0]);
});
</script>
