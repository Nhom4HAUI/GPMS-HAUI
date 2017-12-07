package com.truongdx.controller;


import com.truongdx.domain.*;
import com.truongdx.elastic.controller.IndexController;
import com.truongdx.elastic.dao.ProjectDAO;
import com.truongdx.elastic.dao.ProjectDAOImpl;
import com.truongdx.elastic.model.SearchForm;
import com.truongdx.elastic.model.Text;
import com.truongdx.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lecturer")
public class LecturerController {

    @Autowired
    GraduationthesisService graduationthesisService;

    @Autowired
    StudentService studentService;

    @Autowired
    RegistionFormService registionFormService;

    @Autowired
    UserService userService;

    @Autowired
    LecturerService lecturerService;

    @Autowired
    ProjectService projectService;

    /*Elastic Controler*/
    protected static Logger logger = Logger.getLogger(IndexController.class);
    private static ProjectDAO projectDAO = new ProjectDAOImpl();
    private static SearchForm cursf;

    @RequestMapping(value = "elastic/")
    public ModelAndView listProject(ModelAndView model) throws IOException {
        List<com.truongdx.elastic.model.Project> pjList = projectDAO.getProjectList();
        cursf = new SearchForm();
        List<String> field = new ArrayList<String>();
        field.add(com.truongdx.elastic.model.Project.PROJECT_NAME);
        field.add(com.truongdx.elastic.model.Project.PROJECT_CONTENT);
        model.addObject("filedList", field);
        model.addObject("projectList", pjList);
        model.addObject("sf", cursf);
        model.setViewName("/NEW/Lecturer/Lecturer_elastic_index");
        return model;
    }

    @RequestMapping(value = "elastic/home")
    public ModelAndView index(ModelAndView model) throws IOException {
        return listProject(model);
    }

    @RequestMapping(value = "elastic/newProject", method = RequestMethod.GET)
    public ModelAndView newProject(ModelAndView model) {
        com.truongdx.elastic.model.Project newProject = new com.truongdx.elastic.model.Project();
        model.addObject("project", newProject);
        model.setViewName("/NEW/Lecturer/Lecturer_elastic_ProjectForm");
        return model;
    }

    @RequestMapping(value = "elastic/saveProject", method = RequestMethod.POST)
    public ModelAndView saveProject(@ModelAttribute com.truongdx.elastic.model.Project project) throws IOException {
        projectDAO.insertProject(project);
        return this.listProject(new ModelAndView());
    }

    @RequestMapping(value = "elastic/searchProject", method = RequestMethod.GET)
    public ModelAndView searchProject(@ModelAttribute SearchForm sf, BindingResult bindingResult) {
        cursf = sf;
        List<com.truongdx.elastic.model.Project> searchResult = projectDAO.searchProject(sf);
        logger.info("From index:");
        logger.info(searchResult);
        ModelAndView model = new ModelAndView();
        logger.info("search result: name = " + sf.getName().getValue() + ", content = " + sf.getContent().getValue());
        model.addObject("searchList", searchResult);
        model.setViewName("/NEW/Lecturer/Lecturer_elastic_result");
        return model;
    }

    @RequestMapping(value = "elastic/deleteProject", method = RequestMethod.GET)
    public ModelAndView deleteProject(HttpServletRequest request) {
        int ProjectId = Integer.parseInt(request.getParameter("id"));
        projectDAO.deleteProject(ProjectId);
        return new ModelAndView("redirect:/lecturer/elastic/");
    }

    @RequestMapping(value = "elastic/editProject", method = RequestMethod.GET)
    public ModelAndView editProject(HttpServletRequest request) {
        com.truongdx.elastic.model.Project Project = projectDAO.getProjectByID(request.getParameter("id"));
        ModelAndView model = new ModelAndView("/NEW/Lecturer/Lecturer_elastic_ProjectForm");
        model.addObject("project", Project);
        return model;
    }

    @RequestMapping(value = "elastic/viewProject", method = RequestMethod.GET)
    public ModelAndView viewProject(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.setViewName("/NEW/Lecturer/Lecturer_elastic_viewProjectContent");
        com.truongdx.elastic.model.Project Project = projectDAO.getProjectByID(request.getParameter("id"));
        model.addObject("project", Project);
        return model;
    }

    @RequestMapping(value = "elastic/viewDetail", method = RequestMethod.GET)
    public ModelAndView viewDetail(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        logger.info("Viewing detail: " + cursf.getName().getValue() + ", " + cursf.getContent().getValue());

        model.addObject("sf", cursf);
        com.truongdx.elastic.model.Project Project = projectDAO.getProjectByID(request.getParameter("id"));
        logger.info("Project ID = " + request.getParameter("id") + ",content = " + Project.getContent());
        List<Text> name = projectDAO.getDetail(cursf.getName().getValue(), Project.getName());
        List<Text> content = projectDAO.getDetail(cursf.getContent().getValue(), Project.getContent());
        List<String> part = new ArrayList<>();
        StringBuffer displayContent = new StringBuffer();
        for (Text word : content) {
            if (word.getValue().equals("<br/>")){
                part.add(displayContent.toString());
                displayContent = new StringBuffer();
            }
            else{
                if(word.getBold().equals("1"))
                    displayContent.append("<strong>"+word.getValue() + " </strong>");
                else
                    displayContent.append(word.getValue() + " ");
            }

        }
        //model.addObject("project", Project);
        model.addObject("name", name);
        model.addObject("content", content);
        model.addObject("displayContent", displayContent);
        model.addObject("lspart", part);
        logger.info(content);
        model.setViewName("/NEW/Lecturer/Lecturer_elastic_detail");
        return model;
    }
    /*End Elastic Controller*/

    @GetMapping("")
    public ModelAndView index_() {
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/index");

        return model;
    }

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/index");

        return model;
    }

    @GetMapping("/studentLeading")
    public ModelAndView lecturer_Student_Leading() {
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/Lecturer_List_Student_Leading");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User user = userService.findByUsername(name);
        Lecturer lecturer = lecturerService.findByUserId(user.getId());
        List<Graduationthesis> lsGP = graduationthesisService.getAllGPOfLecturer(lecturer.getId());
        List<Student> lsStudent = new ArrayList<>();
        List<Project> lsProject = new ArrayList<>();
        if (lsGP != null) {
            for (Graduationthesis i : lsGP) {
                Project project = projectService.findById(i.getProjectId());
                lsProject.add(project);
                Student student = studentService.findById(i.getTeamId());
                lsStudent.add(student);
            }
        }
        model.addObject("lsGP", lsGP);
        model.addObject("lsStudent", lsStudent);
        model.addObject("lsProject", lsProject);

        return model;
    }

    @GetMapping("/projectLeading")
    public ModelAndView lecturer_Project_Leading() {
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/Lecturer_List_Project_Leading");

        return model;
    }

    @GetMapping("/projectApprove")
    public ModelAndView Lecturer_Project_Approve() {
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/Lecturer_List_Student_Approve");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User user = userService.findByUsername(name);
        Lecturer lecturer = lecturerService.findByUserId(user.getId());
        List<RegistrationForm> lsRegistrationForms = registionFormService.getAllApproveProject(lecturer.getId());
        List<Student> lsStudent = new ArrayList<>();
        List<Project> lsProject = new ArrayList<>();
        if (lsRegistrationForms != null) {
            for (RegistrationForm i : lsRegistrationForms) {
                Project project = projectService.findById(i.getProjectId());
                lsProject.add(project);
                Student student = studentService.findById(i.getTeamId());
                lsStudent.add(student);
            }
        }
        model.addObject("lsRegistrationForms", lsRegistrationForms);
        model.addObject("lsLecturer", lsStudent);
        model.addObject("lsProject", lsProject);
        return model;
    }

    @GetMapping("/editTask")
    public ModelAndView Lecturer_Edit_Task() {
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/Lecturer_Edit_Task");

        return model;
    }

    @GetMapping("/addTask")
    public ModelAndView Lecturer_Add_Task() {
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/Lecturer_Add_Task");

        return model;
    }

    @GetMapping("/allProject")
    public ModelAndView Lecturer_List_All_Project() {
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/Lecturer_List_All_Project");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User user = userService.findByUsername(name);
        Lecturer lecturer = lecturerService.findByUserId(user.getId());
        List<Project> lsProject = projectService.findByLectureId(lecturer.getId());

        model.addObject("lsProject", lsProject);
        return model;
    }

    @GetMapping("/addLeadProject")
    public ModelAndView addLeadProject(@RequestParam(value = "id") int id) {
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/Lecturer_List_All_Project");
        Project modProject = projectService.findById(id);
        modProject.setStatus(1);
        projectService.save(modProject);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User user = userService.findByUsername(name);
        Lecturer lecturer = lecturerService.findByUserId(user.getId());
        List<Project> lsProject = projectService.findByLectureId(lecturer.getId());

        model.addObject("lsProject", lsProject);
        return model;
    }

    @GetMapping("/allProjectLeading")
    public ModelAndView Lecturer_List_All_Project_Leading() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/NEW/Lecturer/Lecturer_List_All_Project_Leading");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User user = userService.findByUsername(name);
        Lecturer lecturer = lecturerService.findByUserId(user.getId());
        List<Project> lsProject = projectService.getAllProjectLeading();

        model.addObject("lsProject", lsProject);
        return model;
    }

    @GetMapping("/addGP")
    public ModelAndView addGP(@ModelAttribute(value = "gp") Graduationthesis gp) {
        ModelAndView model = new ModelAndView();
        model.setViewName("NEW/Lecturer/Lecturer_List_Student_Approve");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User user = userService.findByUsername(name);
        Lecturer lecturer = lecturerService.findByUserId(user.getId());
        Project projectNew = projectService.findById(gp.getProjectId());
        projectNew.setStatus(3);
        projectService.save(projectNew);
        gp.setLectureId(lecturer.getId());
        graduationthesisService.save(gp);
        List<RegistrationForm> lsRegistrationForms = registionFormService.getAllApproveProject(lecturer.getId());
        List<Student> lsStudent = new ArrayList<>();
        List<Project> lsProject = new ArrayList<>();
        if (lsRegistrationForms != null) {
            for (RegistrationForm i : lsRegistrationForms) {
                Project project = projectService.findById(i.getProjectId());
                lsProject.add(project);
                Student student = studentService.findById(i.getTeamId());
                lsStudent.add(student);
            }
        }


        model.addObject("lsProject", lsProject);

        model.addObject("lsRegistrationForms", lsRegistrationForms);
        model.addObject("lsLecturer", lsStudent);
        model.addObject("lsProject", lsProject);
        return model;
    }

}
