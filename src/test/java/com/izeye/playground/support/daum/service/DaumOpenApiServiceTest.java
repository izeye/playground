package com.izeye.playground.support.daum.service;

import org.junit.Test;
import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class DaumOpenApiServiceTest {

	@Resource
	private DaumOpenApiService daumOpenApiService;

	@Test
	public void test() {
	}

}
