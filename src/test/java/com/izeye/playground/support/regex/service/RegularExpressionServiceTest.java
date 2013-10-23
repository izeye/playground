package com.izeye.playground.support.regex.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class RegularExpressionServiceTest {

	@Resource
	private RegularExpressionService regularExpressionService;

	@Test
	public void matches() {
		String regex = "[bcr]at";
		String input = "bat";
		assertThat(regularExpressionService.matches(regex, input), is(true));

		input = "hat";
		assertThat(regularExpressionService.matches(regex, input), is(false));
	}

}
