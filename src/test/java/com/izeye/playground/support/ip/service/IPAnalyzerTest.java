package com.izeye.playground.support.ip.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.ip.domain.IPInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class IPAnalyzerTest {

	@Resource
	private IPAnalyzer ipAnalyzer;

	@Test
	public void analyze() {
		String ip = "125.186.211.36";
		IPInfo ipInfo = ipAnalyzer.analyze(ip);
		System.out.println(ipInfo);
	}

}
