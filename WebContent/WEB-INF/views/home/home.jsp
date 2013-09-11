<p>Welcome to izeye's Playground!</p>

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
