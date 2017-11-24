package com.truongdx.controller;

import com.truongdx.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    FacultyService facultyService;

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

        return model;
    }

    @GetMapping("/registerProject")
    public ModelAndView student_Register_Project(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Student/Student_Register_Project");

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
