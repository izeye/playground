package com.izeye.playground.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:applicationContext.xml",
		"file:WebContent/WEB-INF/spring/appServlet/servlet-context.xml" })
@ActiveProfiles("dev")
public class PlaygroundControllerTest {

	@Test
	public void test() {

	}

}
