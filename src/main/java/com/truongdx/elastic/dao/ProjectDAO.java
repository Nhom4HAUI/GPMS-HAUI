package com.truongdx.elastic.dao;

import com.truongdx.elastic.model.Project;
import com.truongdx.elastic.model.SearchForm;
import com.truongdx.elastic.model.Text;

import java.util.List;


public interface ProjectDAO {
	public List<Project> getProjectList();
	public Project getProjectByID(String id);
	public List<Project> searchProject(SearchForm sf);
	public void deleteProject(int id);
	public void insertProject(Project pj);
	public void updateProject(Project pj);
	public List<Text> getDetail(String query, String value);
}
