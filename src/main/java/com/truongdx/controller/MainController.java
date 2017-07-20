package com.truongdx.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/admin") 
	public String admin() {
		return "admin";
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
	
	@GetMapping("/error")
	public String error() {
		return "404";
	}
	
	@GetMapping("/homepageDSGV")
	public String homepageDSGV() {
		return "hompage_DSGV";
	}
	
	@GetMapping("/ajax")
	public String ajax(@RequestParam(value="p") String param, Model model) {
		model.addAttribute("p", param);
		return "b";
	}
	
	@GetMapping("/layout")
	public String test2() {
		return "layouthompage";
	}
	
}
