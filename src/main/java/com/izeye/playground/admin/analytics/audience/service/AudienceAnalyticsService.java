package com.izeye.playground.admin.analytics.audience.service;

import java.util.List;
import java.util.Set;

import com.izeye.playground.admin.analytics.audience.domain.VisitStat;
import com.izeye.playground.log.access.domain.DailyCount;
import com.izeye.playground.log.access.domain.IpCount;
import com.izeye.playground.log.access.domain.UserAgentCount;

public interface AudienceAnalyticsService {

	VisitStat getVisitStatInSpecificDate(String date);

	VisitStat getTodayVisitStat();

	VisitStat getYesterdayVisitStat();

	List<DailyCount> getDailyCounts();

	List<DailyCount> getDailyCountsInThisWeek();

	List<UserAgentCount> getUserAgentCounts();

	List<IpCount> getUserAgentSpamIPCounts();

	Set<String> getUserAgentSpamIPSet();

}
