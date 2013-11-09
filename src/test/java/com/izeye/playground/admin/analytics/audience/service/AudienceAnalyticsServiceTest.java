package com.izeye.playground.admin.analytics.audience.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.log.access.domain.DailyCount;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class AudienceAnalyticsServiceTest {

	@Resource
	private AudienceAnalyticsService audienceAnalyticsService;

	@Test
	public void getDailyCountsInThisWeek() {
		List<DailyCount> dailyCountsInThisWeek = audienceAnalyticsService
				.getDailyCountsInThisWeek();
		System.out.println(dailyCountsInThisWeek);
	}

}
