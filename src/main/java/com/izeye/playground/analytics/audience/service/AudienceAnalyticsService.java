package com.izeye.playground.analytics.audience.service;

import java.util.List;

import com.izeye.playground.analytics.audience.domain.VisitStat;
import com.izeye.playground.log.access.domain.DailyCount;

public interface AudienceAnalyticsService {

	VisitStat getVisitStatInSpecificDate(String date);

	VisitStat getTodayVisitStat();

	VisitStat getYesterdayVisitStat();

	List<DailyCount> getDailyCounts();

}
