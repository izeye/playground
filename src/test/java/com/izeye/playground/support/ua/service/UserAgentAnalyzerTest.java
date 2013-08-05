package com.izeye.playground.support.ua.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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
import com.izeye.playground.support.ua.domain.browser.BrowserInfo;
import com.izeye.playground.support.ua.domain.device.DeviceType;
import com.izeye.playground.support.ua.domain.os.OSType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class UserAgentAnalyzerTest {

	@Resource
	private UserAgentAnalyzer userAgentAnalyzer;

	@Test
	public void analyze() {
		String userAgentAsString = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.71 Safari/537.36	74";
		UserAgent userAgent = userAgentAnalyzer.analyze(userAgentAsString);
		System.out.println(userAgent);

		userAgentAsString = "Mozilla/5.0 (compatible; Firefox compatible; MS IE compatible; +http://search.daum.net/) Daumoa-feedfetcher/2.0";
		userAgent = userAgentAnalyzer.analyze(userAgentAsString);
		System.out.println(userAgent);

		userAgentAsString = "Mozilla/5.0 (compatible; YandexBot/3.0; +http://yandex.com/bots)";
		userAgent = userAgentAnalyzer.analyze(userAgentAsString);
		System.out.println(userAgent);
	}

	// NOTE:
	// Daum app doesn't provide any information in iPhone.
	private static final String USER_AGENT_DAUM_APP = "Mozilla/5.0 (iPhone; CPU iPhone OS 6_1_3 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Mobile/10B329";

	@Test
	public void analyzeAllFromFile() throws IOException {
		File file = ResourceUtils
				.getFile("classpath:data/user_agent/user_agent.lst");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {
			String userAgentAsString = line.split("\t")[1];
			System.out.println(userAgentAsString);

			UserAgent userAgent = userAgentAnalyzer.analyze(userAgentAsString);
			System.out.println(userAgent);

			if (userAgentAsString.isEmpty()
					|| userAgentAsString.equals(USER_AGENT_DAUM_APP)) {
				continue;
			}

			assertThat("Unexpected user agent: " + userAgentAsString,
					userAgent.toString(),
					is(not(UserAgent.NOT_AVAILABLE.toString())));

			BrowserInfo browserInfo = userAgent.getBrowserInfo();
			if (browserInfo == BrowserInfo.NOT_AVAILABLE) {
				fail("Need to update this browser information: "
						+ userAgentAsString);
			}
			System.out.println(browserInfo.getDisplayName());

			if (userAgent.getOsInfo().getType() == OSType.ANDROID
					&& userAgent.getDeviceType() == DeviceType.NOT_AVAILABLE) {
				fail("Need to update this device type: " + userAgentAsString);
			}
		}
		br.close();
	}
}
