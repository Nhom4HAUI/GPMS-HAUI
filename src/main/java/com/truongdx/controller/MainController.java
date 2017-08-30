package com.truongdx.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.truongdx.domain.User;
import com.truongdx.service.UserDetailsServiceImpl;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class MainController {
	@Autowired
	private UserDetailsServiceImpl userService;

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

	@GetMapping("/DSGV")
	public String DSGV(@RequestParam(value="faculty") String faculty, Model model) {
		List<User> lsLecture = userService.findByFaculty(faculty);
		model.addAttribute("lsLecture", lsLecture);
		return "DSGV";
	}

	@GetMapping("/layout")
	public String test2() {
		return "layouthompage";
	}

}
