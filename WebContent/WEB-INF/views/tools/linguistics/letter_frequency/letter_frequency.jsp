<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.bar {
	fill: steelblue;
}

.bar:hover {
	fill: brown;
}

.axis {
	font: 10px sans-serif;
}

.axis path,
.axis line {
	fill: none;
	stroke: #000;
	shape-rendering: crispEdges;
}

.x.axis path {
	display: none;
}
</style>

<script type="text/javascript"
	src="<c:url value="/resources/d3/3/d3.v3.min.js" />"></script>

<script>
function draw(data) {
	data = d3.entries(data);
	
	// Normalize.
	var sum = 0;
	for (var i in data) {
		sum += data[i].value;
	}
	for (var i in data) {
		data[i].value = data[i].value / sum;
	}
	
	// Don't need any more.
	/*
	data.sort(function (a, b) {
		if (a.key > b.key) {
			return 1;
		} else if (a.key < b.key) {
			return -1;
		} else {
			return 0;
		}
	});
	*/
	
	var margin = {top: 20, right: 20, bottom: 30, left: 40},
		width = 960 - margin.left - margin.right,
		height = 500 - margin.top - margin.bottom;
	
	var x = d3.scale.ordinal()
		.rangeRoundBands([0, width], .1);
	
	var y = d3.scale.linear()
		.range([height, 0]);
	
	var xAxis = d3.svg.axis()
		.scale(x)
		.orient("bottom");
	
	var yAxis = d3.svg.axis()
		.scale(y)
		.orient("left")
		.ticks(10, "%");
	
	var svg = d3.select(".chart")
		.attr("width", width + margin.left + margin.right)
		.attr("height", height + margin.top + margin.bottom)
	  .append("g")
		.attr("transform", "translate(" + margin.left + ", " + margin.top + ")");
	
	x.domain(data.map(function (d) {
		return d.key;
	}));
	y.domain([0, d3.max(data, function (d) {
		return d.value;
	})]);
	
	svg.append("g")
		.attr("class", "x axis")
		.attr("transform", "translate(0, " + height + ")")
		.call(xAxis);
	
	svg.append("g")
		.attr("class", "y axis")
		.call(yAxis)
	  .append("text")
		.attr("transform", "rotate(-90)")
		.attr("y", 6)
		.attr("dy", ".71em")
		.style("text-anchor", "end")
		.text("Frequency");
	
	svg.selectAll(".bar")
		.data(data)
	  .enter().append("rect")
		.attr("class", "bar")
		.attr("x", function (d) {
			return x(d.key);
		}).attr("width", x.rangeBand())
		.attr("y", function (d) {
			return y(d.value);
		}).attr("height", function (d) {
			return height - y(d.value);
		});
}

function isLetter(c) {
	return c.length === 1 && c.match(/[a-z]/i);
}

function calculate() {
	var text = $('#text').val();
	console.log(text);
	
	var letterAndFrequencyMap = {};
	for (var i = 'a'.charCodeAt(0); i <= 'z'.charCodeAt(0); i++) {
		letterAndFrequencyMap[String.fromCharCode(i)] = 0;
	}
	
	for (var i in text) {
		var c = text[i].toLowerCase();
		console.log(c);
		
		if (isLetter(c)) {
			var frequency = letterAndFrequencyMap[c];
			if (!frequency) {
				frequency = 0;
			}
			letterAndFrequencyMap[c] = frequency + 1;
		}
	}
	console.log(letterAndFrequencyMap);
	
	draw(letterAndFrequencyMap);
}
</script>

<p>
This page calculates frequency of letters in a given text.
</p>

<textarea id="text" rows="10" cols="100">
</textarea>
<input type="button" value="Calculate" onclick="calculate();" />

<svg class="chart"></svg>
