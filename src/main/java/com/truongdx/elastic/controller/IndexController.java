package com.truongdx.elastic.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.truongdx.elastic.dao.ProjectDAO;
import com.truongdx.elastic.dao.ProjectDAOImpl;
import com.truongdx.elastic.model.Project;
import com.truongdx.elastic.model.SearchForm;
import com.truongdx.elastic.model.Text;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/elastic2")
public class IndexController {

	protected static Logger logger = Logger.getLogger(IndexController.class);
	private static ProjectDAO projectDAO = new ProjectDAOImpl();
	private static SearchForm cursf;
	@RequestMapping(value = "/")
	public ModelAndView listProject(ModelAndView model) throws IOException {
		List<Project> pjList = projectDAO.getProjectList();
		cursf = new SearchForm();
		List<String> field = new ArrayList<String>();
		field.add(Project.PROJECT_NAME);
		field.add(Project.PROJECT_CONTENT);
		model.addObject("filedList",field);
		model.addObject("projectList", pjList);
		model.addObject("sf",cursf);
		model.setViewName("Elastic/index");
		return model;
	}
	
	@RequestMapping(value = "/home")
	public ModelAndView index(ModelAndView model) throws IOException {
		return listProject(model);
	}
	@RequestMapping(value = "/newProject", method = RequestMethod.GET)
	public ModelAndView newProject(ModelAndView model) {
		Project newProject = new Project();
		model.addObject("project", newProject);
		model.setViewName("Elastic/ProjectForm");
		return model;
	}
	@RequestMapping(value = "/saveProject", method = RequestMethod.POST)
	public ModelAndView saveProject(@ModelAttribute Project project) throws IOException {
		projectDAO.insertProject(project);		
		return this.listProject(new ModelAndView());
	}
	@RequestMapping(value = "/searchProject", method = RequestMethod.GET)
	public ModelAndView searchProject(@ModelAttribute SearchForm sf, BindingResult bindingResult ) {
		cursf = sf;
		List<Project> searchResult = projectDAO.searchProject(sf);
		logger.info("From index:");
		logger.info(searchResult);
		ModelAndView model = new ModelAndView();
		logger.info("search result: name = " + sf.getName().getValue() + ", content = " + sf.getContent().getValue());
		model.addObject("searchList",searchResult);
		model.setViewName("Elastic/result");
		return model;
	}
	
	@RequestMapping(value = "/deleteProject", method = RequestMethod.GET)
	public ModelAndView deleteProject(HttpServletRequest request) {
		int ProjectId = Integer.parseInt(request.getParameter("id"));
		projectDAO.deleteProject(ProjectId);
		return new ModelAndView("redirect:/elastic/");
	}
	
	@RequestMapping(value = "/editProject", method = RequestMethod.GET)
	public ModelAndView editProject(HttpServletRequest request) {
		Project Project = projectDAO.getProjectByID(request.getParameter("id"));
		ModelAndView model = new ModelAndView("Elastic/ProjectForm");
		model.addObject("project", Project);
		return model;
	}
	
	@RequestMapping(value = "/viewProject", method = RequestMethod.GET)
	public ModelAndView viewProject(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("Elastic/viewProjectContent");
		Project Project = projectDAO.getProjectByID(request.getParameter("id"));
		model.addObject("project", Project);
		return model;
	}
	@RequestMapping(value = "/viewDetail", method = RequestMethod.GET)
	public ModelAndView viewDetail(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		logger.info("Viewing detail: " +  cursf.getName().getValue() + ", " + cursf.getContent().getValue());

		model.addObject("sf",cursf);
		Project Project = projectDAO.getProjectByID(request.getParameter("id"));
		logger.info("Project ID = " + request.getParameter("id") + ",content = " + Project.getContent());
		List<Text> name = projectDAO.getDetail(cursf.getName().getValue(),Project.getName());
		List<Text> content = projectDAO.getDetail(cursf.getContent().getValue(),Project.getContent());
		//model.addObject("project", Project);
		model.addObject("name",name);
		model.addObject("content",content);
		logger.info(content);
		model.setViewName("Elastic/detail");
		return model;
	}
}
