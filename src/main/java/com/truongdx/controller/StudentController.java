package com.truongdx.controller;

import com.truongdx.domain.*;
import com.truongdx.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    RegistionFormService registionFormService;

    @Autowired
    UserService userService;

    @Autowired
    FacultyService facultyService;

    @Autowired
    ProjectService projectService;

    @Autowired
    LecturerService lecturerService;

    @Autowired
    StudentService studentService;

    @GetMapping("")
    public ModelAndView student_index_(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Student/index");

        return model;
    }

    @GetMapping("/index")
    public ModelAndView student_index(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Student/index");

        return model;
    }

    @GetMapping("/task")
    public ModelAndView student_manage_project(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Student/Student_Manage_Project");

        return model;
    }

    @GetMapping("/listProject")
    public ModelAndView student_view_project(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Student/Student_View_List_Project");
        model.addObject("lsFaculty", facultyService.findAll());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User user = userService.findByUsername(name);
        Student student = studentService.findByUserId(user.getId());
        RegistrationForm registrationForm = registionFormService.findRegisttionFormApprove(student.getId(),false);
        if (registrationForm == null)
            model.addObject("susscess","");
        else {
            model.addObject("susscess", "Đăng kí đề tài thành công. Vui lòng đợi phê duyệt của giảng viên hướng dẫn!");
        }
        return model;
    }

    @GetMapping("/registerProject")
    public ModelAndView student_Register_Project(@RequestParam(value = "id") int id){
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

    @GetMapping("/cancelProject")
    public ModelAndView student_Cancel_Project(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Student/Student_Cancel_Project");

        return model;
    }

    @GetMapping("/addTask")
    public ModelAndView student_Add_Task(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Student/Student_Add_Task");

        return model;
    }

    @GetMapping("/editTask")
    public ModelAndView student_Edit_Task(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Student/Student_Edit_Task");

        return model;
    }

}
