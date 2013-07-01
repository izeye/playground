package com.izeye.playground.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlaygroundController {

	@RequestMapping("/playground")
	public String home() {
		return "playground/playground";
	}

}
