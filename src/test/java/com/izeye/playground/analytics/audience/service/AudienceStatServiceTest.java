package com.izeye.playground.analytics.audience.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.analytics.audience.domain.VisitStat;
import com.izeye.playground.log.access.domain.DailyCount;
import com.izeye.playground.log.access.domain.UserAgentCount;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("unittest")
public class AudienceStatServiceTest {

	@Resource
	private AudienceAnalyticsService audienceAnalyticsService;

	@Test
	public void getVisitStatInSpecificDate() {
		String date = "2013-07-04";
		VisitStat visitStat = audienceAnalyticsService
				.getVisitStatInSpecificDate(date);
		System.out.println(visitStat);
	}

	@Test
	public void getDailyCounts() {
		List<DailyCount> dailyCounts = audienceAnalyticsService
				.getDailyCounts();
		System.out.println(dailyCounts);
	}

	@Test
	public void getUserAgentCounts() {
		List<UserAgentCount> userAgentCounts = audienceAnalyticsService
				.getUserAgentCounts();
		System.out.println(userAgentCounts);
	}

}
