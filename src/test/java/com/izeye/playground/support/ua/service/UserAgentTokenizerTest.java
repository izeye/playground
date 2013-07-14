package com.izeye.playground.support.ua.service;

import static com.izeye.playground.support.ua.domain.UserAgentTokenType.COMMENT;
import static com.izeye.playground.support.ua.domain.UserAgentTokenType.PRODUCT;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.ua.domain.UserAgentToken;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("unittest")
public class UserAgentTokenizerTest {

	@Resource
	private UserAgentTokenizer userAgentTokenizer;

	@Test
	public void tokenize() {
		String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.71 Safari/537.36";
		UserAgentToken[] expectedUserAgentTokensAsArray = {
				new UserAgentToken(PRODUCT, "Mozilla/5.0"),
				new UserAgentToken(COMMENT, "Macintosh; Intel Mac OS X 10_8_4"),
				new UserAgentToken(PRODUCT, "AppleWebKit/537.36"),
				new UserAgentToken(COMMENT, "KHTML, like Gecko"),
				new UserAgentToken(PRODUCT, "Chrome/28.0.1500.71"),
				new UserAgentToken(PRODUCT, "Safari/537.36") };
		List<UserAgentToken> expectedUserAgentTokens = Arrays
				.asList(expectedUserAgentTokensAsArray);

		List<UserAgentToken> userAgentTokens = userAgentTokenizer
				.tokenize(userAgent);
		System.out.println(userAgentTokens);

		assertThat(userAgentTokens.size(), is(expectedUserAgentTokens.size()));
		for (int i = 0; i < userAgentTokens.size(); i++) {
			assertThat(userAgentTokens.get(i),
					is(expectedUserAgentTokens.get(i)));
		}
	}
}
