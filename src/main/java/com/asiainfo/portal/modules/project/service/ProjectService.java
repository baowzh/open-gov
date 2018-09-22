package com.asiainfo.portal.modules.project.service;

import java.util.List;
import java.util.Map;

import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.portal.form.ProjectPagingForm;
import com.asiainfo.portal.modules.news.model.News;
import com.asiainfo.portal.modules.project.model.Project;

public interface ProjectService {
	public List<Project> list(Map<String, Object> params);

	public DBPageValue<Project> paging(ProjectPagingForm pagingForm);

	public void save(Project project) throws Exception;

	public void del(Integer id);

	public News get(Integer id);

	public void upload(byte[] excelContent) throws Exception;
}
