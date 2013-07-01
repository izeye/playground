package com.izeye.playground.links.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LinksController {

	@RequestMapping("/links")
	public String home() {
		return "links/links";
	}

}
