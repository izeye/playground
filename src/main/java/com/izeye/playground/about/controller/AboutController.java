package com.izeye.playground.about.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {

	@RequestMapping("/about")
	public String home() {
		return "about/about";
	}

}
