package com.izeye.playground.analytics.audience.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.izeye.playground.analytics.audience.domain.VisitStat;
import com.izeye.playground.common.util.DateUtils;
import com.izeye.playground.log.access.dao.AccessLogDao;
import com.izeye.playground.log.access.domain.AccessLog;
import com.izeye.playground.log.access.domain.DailyCount;
import com.izeye.playground.log.access.domain.IPCount;
import com.izeye.playground.log.access.domain.UserAgentCount;
import com.izeye.playground.support.spam.ua.service.UserAgentSpamFilter;

@Service("audienceAnalyticsService")
public class DefaultAudienceAnalyticsService implements
		AudienceAnalyticsService {

	@Resource
	private AccessLogDao accessLogDao;

	@Resource
	private UserAgentSpamFilter userAgentSpamFilter;

	@Override
	public VisitStat getVisitStatInSpecificDate(String date) {
		List<AccessLog> accessLogs = accessLogDao
				.getAccessLogsInSpecificDate(date);
		Set<String> ipSet = new HashSet<String>();
		for (AccessLog accessLog : accessLogs) {
			ipSet.add(accessLog.getIp());
		}
		int pageviews = accessLogs.size();
		int uniqueVisitors = ipSet.size();
		return new VisitStat(pageviews, uniqueVisitors);
	}

	@Override
	public VisitStat getTodayVisitStat() {
		return getVisitStatInSpecificDate(DateUtils.getToday());
	}

	@Override
	public VisitStat getYesterdayVisitStat() {
		return getVisitStatInSpecificDate(DateUtils.getYesterday());
	}

	@Override
	public List<DailyCount> getDailyCounts() {
		return accessLogDao.getDailyCounts();
	}

	@Override
	public List<UserAgentCount> getUserAgentCounts() {
		List<UserAgentCount> userAgentCounts = accessLogDao
				.getUserAgentCounts();

		filterSpams(userAgentCounts);

		return userAgentCounts;
	}

	@Override
	public List<IPCount> getUserAgentSpamIPCounts() {
		return accessLogDao.getUserAgentSpamIPCounts();
	}

	@Override
	@Cacheable(value = "accessLogCache", key = "{#root.methodName}")
	public Set<String> getUserAgentSpamIPSet() {
		Set<String> userAgentSpamIPSet = new HashSet<String>();
		List<IPCount> ipCounts = getUserAgentSpamIPCounts();
		for (IPCount ipCount : ipCounts) {
			userAgentSpamIPSet.add(ipCount.getIp());
		}
		return userAgentSpamIPSet;
	}

	private void filterSpams(List<UserAgentCount> userAgentCounts) {
		List<UserAgentCount> filteredUserAgentCounts = new ArrayList<UserAgentCount>();
		for (UserAgentCount userAgentCount : userAgentCounts) {
			if (userAgentSpamFilter.filter(userAgentCount.getUserAgent())) {
				filteredUserAgentCounts.add(userAgentCount);
			}
		}
		userAgentCounts.removeAll(filteredUserAgentCounts);
	}

}
