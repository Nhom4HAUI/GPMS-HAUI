package com.truongdx.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lecturer")
public class LecturerController {

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/index");

        return model;
    }

    @GetMapping("/studentLeading")
    public ModelAndView lecturer_Student_Leading(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/Lecturer_List_Student_Leading");

        return model;
    }

    @GetMapping("/projectLeading")
    public ModelAndView lecturer_Project_Leading(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/Lecturer_List_Project_Leading");

        return model;
    }

    @GetMapping("/projectApprove")
    public ModelAndView Lecturer_Project_Approve(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/Lecturer_List_Student_Approve");

        return model;
    }

    @GetMapping("/editTask")
    public ModelAndView Lecturer_Edit_Task(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/Lecturer_Edit_Task");

        return model;
    }

    @GetMapping("/addTask")
    public ModelAndView Lecturer_Add_Task(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/Lecturer_Add_Task");

        return model;
    }

    @GetMapping("/allProject")
    public ModelAndView Lecturer_List_All_Project(){
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/Lecturer_List_All_Project");

        return model;
    }
}
