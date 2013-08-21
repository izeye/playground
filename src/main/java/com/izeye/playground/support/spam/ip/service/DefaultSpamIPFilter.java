package com.izeye.playground.support.spam.ip.service;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.analytics.audience.service.AudienceAnalyticsService;

@Service("spamIPFilter")
public class DefaultSpamIPFilter implements SpamIPFilter {

	@Resource
	private AudienceAnalyticsService audienceAnalyticsService;

	@Override
	public boolean filter(String ip) {
		Set<String> userAgentSpamIPSet = audienceAnalyticsService
				.getUserAgentSpamIPSet();
		return userAgentSpamIPSet.contains(ip);
	}

}
