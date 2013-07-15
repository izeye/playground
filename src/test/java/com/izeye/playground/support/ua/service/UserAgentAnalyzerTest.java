package com.izeye.playground.support.ua.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;

import com.izeye.playground.support.ua.domain.UserAgent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("unittest")
public class UserAgentAnalyzerTest {

	@Resource
	private UserAgentAnalyzer userAgentAnalyzer;

	@Test
	public void analyze() {
		String userAgentAsString = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.71 Safari/537.36	74";
		UserAgent userAgent = userAgentAnalyzer.analyze(userAgentAsString);
		System.out.println(userAgent);
	}

	@Test
	public void analyzeAllFromFile() throws IOException {
		File file = ResourceUtils
				.getFile("classpath:data/user_agent/user_agent.lst");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {
			String userAgentAsString = line.split("\t")[0];
			UserAgent userAgent = userAgentAnalyzer.analyze(userAgentAsString);
			System.out.println(userAgentAsString);
			System.out.println(userAgent);
		}
		br.close();
	}

}
