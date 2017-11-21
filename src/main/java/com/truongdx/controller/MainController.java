package com.truongdx.controller;

import com.truongdx.domain.Lecturer;
import com.truongdx.service.FacultyService;
import com.truongdx.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	private LecturerService lecturerService;

	@Autowired
	private FacultyService facultyService;

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
		model.addAttribute("lsFaculty", facultyService.findAll());
		model.addAttribute("lsLecturer", lecturerService.findAll());
		return "homepage_Lecturer_List";
	}


	@GetMapping("/hompageProjectList")
	public String hompageProjectList(Model model){
		model.addAttribute("lsFaculty", facultyService.findAll());
		return "homepage_Project_List";
	}
}
