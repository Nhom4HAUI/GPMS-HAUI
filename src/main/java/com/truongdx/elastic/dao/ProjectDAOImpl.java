package com.truongdx.elastic.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.truongdx.elastic.model.Project;
import com.truongdx.elastic.model.Query;
import com.truongdx.elastic.model.SearchForm;
import com.truongdx.elastic.model.Text;
import org.apache.log4j.Logger;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.action.admin.indices.refresh.RefreshRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.cluster.health.ClusterHealthStatus;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import static org.elasticsearch.index.query.QueryBuilders.*;
import org.elasticsearch.node.Node;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptService;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;
import org.elasticsearch.search.SearchHit;

public class ProjectDAOImpl implements ProjectDAO {
	Settings settings;
	Node node;
	Client client;
	protected static Logger logger = Logger.getLogger(ProjectDAOImpl.class);

	public ProjectDAOImpl() {
		settings = Settings.settingsBuilder().put("path.home", "E:\\elasticsearch-2.2.0").build();
		node = nodeBuilder().settings(settings).node();
		client = node.client();
	}

	public static Map<String, Object> putJsonDocument(Project pj) {

		Map<String, Object> jsonDocument = new HashMap<String, Object>();
		jsonDocument.put(Project.PROJECT_NAME, pj.getName());
		jsonDocument.put(Project.PROJECT_CONTENT, pj.getContent());

		return jsonDocument;
	}

	public List<Project> getProjectList() {
		ArrayList<Project> list = new ArrayList<Project>();
		SearchResponse response = client.prepareSearch(Project.PROJECT_INDEX).setTypes(Project.PROJECT_TYPE)
				.setSearchType(SearchType.DFS_QUERY_AND_FETCH).setQuery(QueryBuilders.matchAllQuery()).setFrom(0)
				.setSize(10).setExplain(true).execute().actionGet();

		SearchHit[] results = response.getHits().getHits();

		// logger.info("Current results: " + results.length);
		for (SearchHit hit : results) {
			// logger.info("------------------------------");
			// logger.info("Score: " + hit.getScore());
			Map<String, Object> result = hit.getSource();
			String name = result.get(Project.PROJECT_NAME).toString();
			String content = result.get(Project.PROJECT_CONTENT).toString();
			Project pj = new Project(hit.getId(), name, content);
			pj.setScore(hit.getScore());
			list.add(pj);
			// logger.info(result);
		}
		return list;
	}

	public List<Project> searchProject(SearchForm sf) {
		ArrayList<Project> list = new ArrayList<Project>();
		Query name = sf.getName();
		Query content = sf.getContent();
		QueryBuilder db;
		if (name.getValue().equals("")) {
			db = matchQuery(content.getField(), content.getValue());
		} else if (content.getValue().equals("")) {
			db = matchQuery(name.getField(), name.getValue());
		} else {
			db = boolQuery().should(matchQuery(name.getField(), name.getValue()))
					.should(matchQuery(content.getField(), content.getValue()));
		}
		SearchRequestBuilder requestBuilder = client.prepareSearch(Project.PROJECT_INDEX).setTypes(Project.PROJECT_TYPE)
				.setSearchType(SearchType.DFS_QUERY_AND_FETCH).setQuery(db);

		SearchHitIterator hitIterator = new SearchHitIterator(requestBuilder);
		while (hitIterator.hasNext()) {
			SearchHit hit = hitIterator.next();
			// logger.info("------------------------------");
			// logger.info("Score: " + hit.getScore());
			Map<String, Object> result = hit.getSource();
			String pjname = result.get(Project.PROJECT_NAME).toString();
			// String content = result.get(Project.PROJECT_CONTENT).toString();
			Project pj = new Project(hit.getId(), pjname, "");
			pj.setScore(hit.getScore());
			list.add(pj);
			logger.info(result);
			// process your hit
		}
		// SearchResponse response =
		// client.prepareSearch(Project.PROJECT_INDEX).setTypes(Project.PROJECT_TYPE)
		// .setSearchType(SearchType.DFS_QUERY_AND_FETCH).setQuery(QueryBuilders.matchQuery(field,
		// content))
		// .setFrom(0).setSize(10).setExplain(true).execute().actionGet();

		// SearchHit[] results = response.getHits().getHits();

		// logger.info("Current results: " + results.length);
		// for (SearchHit hit : results) {
		// logger.info("------------------------------");
		// logger.info("Score: " + hit.getScore());
		// Map<String, Object> result = hit.getSource();
		// String id = result.get(Project.PROJECT_ID).toString();
		// String name = result.get(Project.PROJECT_NAME).toString();
		// // String content = result.get(Project.PROJECT_CONTENT).toString();
		// Project pj = new Project(id, name, "");
		// pj.setScore(hit.getScore());
		// logger.info(result);
		// }
		return list;
	}

	public void deleteProject(int id) {
		DeleteResponse response = client.prepareDelete(Project.PROJECT_INDEX, Project.PROJECT_TYPE, id + "").get();
		logger.info("Information on the deleted document:");
		logger.info("Index: " + response.getIndex());
		logger.info("Type: " + response.getType());
		logger.info("Id: " + response.getId());
		logger.info("Version: " + response.getVersion());
	}

	public void insertProject(Project pj) {
		try {
			client.prepareIndex(Project.PROJECT_INDEX, Project.PROJECT_TYPE, pj.getId()).setSource(putJsonDocument(pj))
					.execute().actionGet();
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}

	public void updateProject(Project pj) {

	}

	public Project getProjectByID(String id) {
		logger.info("Showing search result with id " + id + ":");
		GetResponse getResponse = client.prepareGet(Project.PROJECT_INDEX, Project.PROJECT_TYPE, id).execute()
				.actionGet();
		Map<String, Object> source = getResponse.getSource();

		logger.info("------------------------------");
		logger.info("Index: " + getResponse.getIndex());
		logger.info("Type: " + getResponse.getType());
		logger.info("Id: " + getResponse.getId());
		logger.info("Version: " + getResponse.getVersion());
		logger.info(source);
		logger.info("------------------------------");
		Project pj = new Project(getResponse.getId(), source.get(Project.PROJECT_NAME).toString(),
				source.get(Project.PROJECT_CONTENT).toString());
		return pj;
	}

	public List<String> getSplit(String t) {
		List<String> ans = new ArrayList();
		char[] s = t.toCharArray();
		String temp = "";
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '\'') {
				temp += s[i];
			} else if (Character.isLetter(s[i]) || Character.isDigit(s[i])) {
				temp += s[i];
			} else if (s[i] == ' ') {
				if (i > 0 && s[i - 1] == ' ') {
					continue;
				} else {
					ans.add(temp);
					temp = " ";
					ans.add(temp);
					temp = "";
				}
			} else if (s[i] == '.' || s[i] == ',') {
				temp += s[i];
				ans.add(temp);
				temp = "";
			} else if (s[i] == '\n') {
				ans.add(temp);
				temp = "<br/>";
				ans.add(temp);
				temp = "";
			}
		}
		if (!temp.equals("")) {
			ans.add(temp);
		}
		return ans;
	}

	public List<Text> getDetail(String query, String value) {
		List<Text> list = new ArrayList<Text>();
		List<String> q = getSplit(query);
		List<String> v = getSplit(value);
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i).equals(" ")) {
				continue;
			}
			Text temp = new Text();
			temp.setValue(v.get(i));
			boolean have = false;
			for (int j = 0; j < q.size(); j++) {
				if (q.get(j).equals(" ")) {
					continue;
				}
				String l = new String(q.get(j).toLowerCase());
				String r = new String(v.get(i).toLowerCase());

				if (l.equals(r)) {
					have = true;
					break;
				}
			}
			if (have) {
				temp.setBold("1");
			} else {
				temp.setBold("0");
			}

			list.add(temp);
		}
		for (int i = 0; i < list.size(); i++) {
			logger.info((i + 1) + "." + list.get(i).getValue() + "," + list.get(i).getBold());
		}
		return list;
	}

}
