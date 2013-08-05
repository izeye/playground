<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
var selectUnitType = function () {
console.log('test');
};
</script>

<select onchange="selectUnitType();">
<c:forEach var="unitType" items="${unitTypes}">
<option>${unitType.getName()}</option>
</c:forEach>
</select>