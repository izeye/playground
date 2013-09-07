package com.izeye.playground.support.ip.service;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.common.util.JsonUtils;
import com.izeye.playground.support.ip.domain.Whois;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class WhoisServiceTest {

	@Resource
	private WhoisService whoisService;

	@Test
	public void whois() throws JsonGenerationException, JsonMappingException,
			IOException {
		String ip = "125.186.211.36";
		Whois whois = whoisService.whois(ip);
		System.out.println(whois);
		System.out.println(JsonUtils.toJson(whois).length());

		ip = "195.81.186.202";
		whois = whoisService.whois(ip);
		System.out.println(whois);
		System.out.println(JsonUtils.toJson(whois).length());

		ip = "0:0:0:0:0:0:0:1";
		whois = whoisService.whois(ip);
		System.out.println(whois);
		System.out.println(JsonUtils.toJson(whois).length());

		ip = "14.37.254.91";
		whois = whoisService.whois(ip);
		System.out.println(whois);
		System.out.println(JsonUtils.toJson(whois).length());

		// Test the cache.
		ip = "14.37.254.91";
		whois = whoisService.whois(ip);
		System.out.println(whois);
	}

}
