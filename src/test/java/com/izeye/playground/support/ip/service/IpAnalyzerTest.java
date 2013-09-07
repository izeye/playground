package com.izeye.playground.support.ip.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.ip.domain.IpInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class IpAnalyzerTest {

	@Resource
	private IpAnalyzer ipAnalyzer;

	@Test
	public void analyze() {
		// NOTE:
		// From KISA Whois or database.
		String ip = "125.186.211.36";
		IpInfo ipInfo = ipAnalyzer.analyze(ip);
		System.out.println(ipInfo);

		// NOTE:
		// From cache.
		ip = "125.186.211.36";
		ipInfo = ipAnalyzer.analyze(ip);
		System.out.println(ipInfo);
	}

}
