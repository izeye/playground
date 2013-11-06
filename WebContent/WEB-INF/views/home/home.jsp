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
$(document).ready(function () {
	var line2 = [['2008-06-30 8:00AM', 4], ['2008-07-30 8:00AM', 6.5], ['2008-08-30 8:00AM', 5.7], ['2008-09-30 8:00AM', 9], ['2008-10-30 8:00AM', 8.2]];
	var plot2 = $.jqplot('chart', [line2], {
		title: 'Customized Date Axis',
		axes: {
			xaxis: {
				renderer: $.jqplot.DateAxisRenderer,
				tickOptions: {formatString: '%b %#d, %y'},
				min: 'May 30, 2008',
				tickInterval: '1 month'
			},
			yaxis: {
				min: 0
			}
		},
		series: [{lineWidth: 4, markerOptions: {style: 'sqaure'}}]
	});
});
</script>

<div id="chart" style="height:400px; width:600px; "></div>