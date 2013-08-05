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
import com.izeye.playground.support.ua.domain.UserAgentTokenType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
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

	@Test
	public void tokenizeFacebookApp() {
		String expectedLastTokenValue = "FBAN/FBIOS;FBAV/6.3;FBBV/257209;FBDV/iPhone3,1;FBMD/iPhone;FBSN/iPhone OS;FBSV/5.1.1;FBSS/2; FBCR/SKTelecom;FBID/phone;FBLC/ko_KR;FBOP/1";
		String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 5_1_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Mobile/9B206 ["
				+ expectedLastTokenValue + "]";

		List<UserAgentToken> userAgentTokens = userAgentTokenizer
				.tokenize(userAgent);
		System.out.println(userAgentTokens);

		UserAgentToken actualLastToken = userAgentTokens.get(userAgentTokens
				.size() - 1);
		assertThat(actualLastToken.getType(), is(UserAgentTokenType.PRODUCT));
		assertThat(actualLastToken.getValue(), is(expectedLastTokenValue));
	}

	@Test
	public void tokenizeNaverApp() {
		String expectedLastProductTokenValue = "NAVER";
		String expectedLastCommentTokenValue = "inapp; search; 310; 4.6.0; 4S";
		String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 6_1_3 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Mobile/10B329 "
				+ expectedLastProductTokenValue
				+ "("
				+ expectedLastCommentTokenValue + ")";

		List<UserAgentToken> userAgentTokens = userAgentTokenizer
				.tokenize(userAgent);
		System.out.println(userAgentTokens);

		UserAgentToken actualLastProductToken = userAgentTokens
				.get(userAgentTokens.size() - 2);
		UserAgentToken actualLastCommentToken = userAgentTokens
				.get(userAgentTokens.size() - 1);
		assertThat(actualLastProductToken.getType(),
				is(UserAgentTokenType.PRODUCT));
		assertThat(actualLastProductToken.getValue(),
				is(expectedLastProductTokenValue));
		assertThat(actualLastCommentToken.getType(),
				is(UserAgentTokenType.COMMENT));
		assertThat(actualLastCommentToken.getValue(),
				is(expectedLastCommentTokenValue));
	}

}
