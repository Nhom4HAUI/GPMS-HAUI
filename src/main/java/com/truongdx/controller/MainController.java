package com.truongdx.controller;

import com.truongdx.domain.*;
import com.truongdx.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private RegistionFormService registionFormService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private ProjectService projectService;

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

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
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
    public String getDSGV(Model model, @RequestParam(value = "facultyId") String facultyId) {
        List<Lecturer> lsLecturer = lecturerService.findByFaculty(facultyId);
        model.addAttribute("lsLecturer", lsLecturer);
        return "DSGV";
    }

    @GetMapping("/hompageProjectList")
    public String hompageProjectList(Model model) {
        model.addAttribute("lsFaculty", facultyService.findAll());
        return "homepage_Project_List";
    }


    @GetMapping("/listProject")
    public ModelAndView listProject(@RequestParam(value = "faculty") String facultyId) {
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Common/List_Project");
        /*lsProject*/
        Iterable<Project> lsProject = projectService.getAllProjectNotLeadingByFacultyId(facultyId);
        List<Lecturer> lsLecturers = lecturerService.getLectureByListProject(lsProject);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User user = userService.findByUsername(name);
        Student student = studentService.findByUserId(user.getId());
        RegistrationForm registrationForm = registionFormService.findRegisttionFormApprove(student.getId(),false);
        String susscess = "";
        if (registrationForm != null)
            susscess = "Đăng kí đề tài thành công. Vui lòng đợi phê duyệt của giảng viên hướng dẫn!";
        model.addObject("length",susscess.length());
        model.addObject("lsProject", lsProject);
        model.addObject("lsLecturer", lsLecturers);
        return model;
    }


    @GetMapping("/registerProject")
    public ModelAndView registerFormProject() {
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Common/RegistProjectForm");


        return model;
    }


    @GetMapping("/cancelProject")
    public ModelAndView cancelFormProject() {
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Common/CancelProjectForm");


        return model;
    }

    @GetMapping("/demo")
    public ModelAndView DSDT() {
        ModelAndView model = new ModelAndView();
        model.setViewName("DSDT");
        Iterable<Project> lsProject = projectService.getAllProjectNotLeading();
        List<Lecturer> lsLecturers = lecturerService.getLectureByListProject(lsProject);

        model.addObject("lsProject", lsProject);
        model.addObject("lsLecturer", lsLecturers);

        return model;
    }

    @GetMapping("/getDSDT")
    public ModelAndView getDSDTbyFacultyId(@RequestParam(value = "faculty") String facultyId){
        ModelAndView model = new ModelAndView();
        model.setViewName("DSDT");
        Iterable<Project> lsProject = projectService.getAllProjectNotLeadingByFacultyId(facultyId);
        List<Lecturer> lsLecturers = lecturerService.getLectureByListProject(lsProject);

        model.addObject("lsProject", lsProject);
        model.addObject("lsLecturer", lsLecturers);

        return model;
    }

    @GetMapping("/createRegistionForm")
    public ModelAndView createRegistionForm(@RequestParam(value = "id") int id){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Student/Student_Register_Project");
        Project project = projectService.findById(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User user = userService.findByUsername(name);
        Student student = studentService.findByUserId(user.getId());
        Lecturer lecturer = lecturerService.findById(project.getLectureId());

        model.addObject("registionForm", new RegistrationForm());
        model.addObject("student", student);
        model.addObject("lecturer", lecturer);
        model.addObject("project", project);

        return model;
    }

    @GetMapping("/addRegistionForm")
    public ModelAndView addRegistionForm(@ModelAttribute(value = "registionForm") RegistrationForm registrationForm){
        ModelAndView model = new ModelAndView();
        registrationForm.setRegistrationDate(new Date());
        registionFormService.save(registrationForm);
        model.setViewName("NEW/Student/Student_View_List_Project");
        model.addObject("lsFaculty", facultyService.findAll());
        model.addObject("susscess", "Đăng kí đề tài thành công. Vui lòng đợi phê duyệt của giảng viên hướng dẫn!");
        return model;
    }
}
