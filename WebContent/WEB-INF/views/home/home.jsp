<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p>Welcome to izeye's Playground!</p>

<link
	href="<c:url value="/resources/jqplot/1.0.8r1250/jquery.jqplot.min.css" />"
	rel="stylesheet" media="screen" />
<script type="text/javascript" src="<c:url value="/resources/jqplot/1.0.8r1250/jquery.jqplot.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqplot/1.0.8r1250/plugins/jqplot.dateAxisRenderer.min.js" />"></script>

<script>
  (function() {
    var cx = '000729726960658754989:4i20xuoqmka';
    var gcse = document.createElement('script');
    gcse.type = 'text/javascript';
    gcse.async = true;
    gcse.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') +
        '//www.google.com/cse/cse.js?cx=' + cx;
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(gcse, s);
  })();
</script>

Search:
<gcse:search></gcse:search>

<p>
	<b>Today</b> (Delayed. At most 1 minute.)
</p>
<p>PV (Pageviews): ${todayVisitStat.getPageviews()}</p>
<p>UV (Unique Visitors): ${todayVisitStat.getUniqueVisitors()}</p>
<p>
	<b>Yesterday</b> (Delayed. At most 1 minute.)
</p>
<p>PV (Pageviews): ${yesterdayVisitStat.getPageviews()}</p>
<p>UV (Unique Visitors): ${yesterdayVisitStat.getUniqueVisitors()}</p>
<script type="text/javascript">
var lineForPageviews = [];
var lineForUniqueVisitors = [];

<c:forEach var="dailyCount" items="${dailyCountsInThisWeek}">
	lineForPageviews.push(['${dailyCount.getDay()}', ${dailyCount.getPageviews()}]);
	lineForUniqueVisitors.push(['${dailyCount.getDay()}', ${dailyCount.getUniqueVisitors()}]);
</c:forEach>
</script>

<script type="text/javascript">
$(document).ready(function () {
	var plot = $.jqplot('chart', [lineForPageviews, lineForUniqueVisitors], {
		title: 'PV & UV in this week',
		axes: {
			xaxis: {
				renderer: $.jqplot.DateAxisRenderer,
				tickOptions: {formatString: '%Y-%m-%d'},
				tickInterval: '1 day'
			},
			yaxis: {
				min: 0
			}
		},
		series: [
			{lineWidth: 4, markerOptions: {style: 'sqaure'}, label: 'PV'},
			{lineWidth: 4, markerOptions: {style: 'sqaure'}, label: 'UV'}
		],
		legend: {show: true}
	});
});
</script>

<div id="chart" style="height:400px; width:600px; "></div>