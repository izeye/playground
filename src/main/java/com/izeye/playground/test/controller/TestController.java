package com.izeye.playground.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.playground.test.groovy.GroovySample;

@Controller
public class TestController {

	@RequestMapping("/test/sample/groovy")
	@ResponseBody
	public String sampleGroovy() {
		GroovySample groovySample = new GroovySample();
		return groovySample.getSampleString();
	}

}
