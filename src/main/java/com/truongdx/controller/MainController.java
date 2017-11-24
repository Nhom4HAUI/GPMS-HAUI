package com.truongdx.controller;

import com.truongdx.domain.Lecturer;
import com.truongdx.service.FacultyService;
import com.truongdx.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
		return "NEW/Masterpage/masterpage";
	}

	@GetMapping("/homepageDSGV")
	public String homepageDSGV(Model model) {
		model.addAttribute("lsFaculty", facultyService.findAll());
		model.addAttribute("lsLecturer", lecturerService.findAll());
		return "homepage_Lecturer_List";
	}

	@GetMapping("/DSGV")
	public String getDSGV(Model model, @RequestParam(value = "facultyId") String facultyId){
		List<Lecturer> lsLecturer = lecturerService.findByFaculty(facultyId);
		model.addAttribute("lsLecturer", lsLecturer);
		return "DSGV";
	}

	@GetMapping("/hompageProjectList")
	public String hompageProjectList(Model model){
		model.addAttribute("lsFaculty", facultyService.findAll());
		return "homepage_Project_List";
	}


    @GetMapping("/listProject")
    public ModelAndView listProject(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Common/List_Project");


        return model;
    }


    @GetMapping("/registerProject")
    public ModelAndView registerFormProject(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Common/RegistProjectForm");


        return model;
    }


	@GetMapping("/cancelProject")
	public ModelAndView cancelFormProject(){
		ModelAndView model = new ModelAndView();
		model.setViewName("NEW/Common/CancelProjectForm");


		return model;
	}

}
