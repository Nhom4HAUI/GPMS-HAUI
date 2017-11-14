package com.truongdx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@GetMapping("/homepageDSGV")
	public String homepageDSGV(Model model) {
	
		return "hompage_DSGV";
	}

}
