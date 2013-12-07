<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>4 Circles Illusion</title>
		<script type="text/javascript" src="<c:url value="/resources/d3/3/d3.v3.min.js" />"></script>
	</head>
	<body>
		<p>This is from <a href="http://bl.ocks.org/enjalot/1379934">here</a>.</p>
		
		<svg></svg>
		
		<script type="text/javascript">
			var w = 500;
			var h = 500;
			
			var r1 = 90;
			var r2 = 150;
			var r3 = 220;
			var r4 = 290;
			
			var svg = d3.select("svg")
				.attr("width", w)
				.attr("height", h)
				.attr("id", "spiral");
			svg.append("svg:rect")
				.attr("class", "background_rect")
				.attr("width", "100%")
				.attr("height", "100%")
				.attr("stroke", "#000")
				.attr("stroke-width", 1)
				.attr("fill", "#888");
			
			var chart = svg.append("svg:g")
				.attr("class", "base_group")
				.attr("transform", "translate(" + [w/2, h/2] + ") scale(.5, .5)");
			
			var make_circle = function (r, n, offset) {
				data = [];
				for (var i = 0; i < n; i++) {
					theta = i * 2 * Math.PI / n;
					data.push({x: r * Math.cos(theta), y: r * Math.sin(theta), angle: theta, index: i});
				}
				return data;
			};
			
			var circle_factory = function (name, data, offset, step) {
				var boxes = chart.selectAll("g." + name)
					.data(data)
				  .enter().append("svg:g")
					.attr("class", name)
				  .append("svg:rect")
					.attr("width", 20)
					.attr("height", 20)
					.attr("stroke", function (d, i) {
						if (i % 2 == 1) {
							return "#fff"
						} else {
							return "#000"
						}
					}).attr("stroke-width", 2)
					.attr("fill", "none")
					.attr("transform", function (d, i) {
						a = offset + step * i;
						return "translate(" + [d.x, d.y] + ") rotate(" + a + ", 10, 10)";
					});
			}
			
			var n = 18,
				data1 = make_circle(r1, n),
				step = 20,
				offset = 15;
			circle_factory("one", data1, offset, step);
			
			var n = 30,
				data2 = make_circle(r2, n),
				step = 12,
				offset = -15;
			circle_factory("two", data2, offset, step);
			
			var n = 45,
				data3 = make_circle(r3, n),
				step = 8,
				offset = 15;
			circle_factory("three", data3, offset, step);
			
			var n = 60,
				data4 = make_circle(r4, n),
				step = 6,
				offset = -15;
			circle_factory("four", data4, offset, step);
		</script>
	</body>
</html>