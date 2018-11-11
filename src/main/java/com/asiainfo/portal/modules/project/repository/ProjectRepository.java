package com.asiainfo.portal.modules.project.repository;

import java.util.List;
import java.util.Map;

import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.NameSpace;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperParam;
import com.asiainfo.eframe.sqlsession.proxy.annotations.Paging;
import com.asiainfo.portal.form.ProjectPagingForm;
import com.asiainfo.portal.modules.project.model.Project;

@DaoBean
public interface ProjectRepository {
	@NameSpace( namespaceClass = Project.class)
	public void insert(Project project) throws Exception;

	@NameSpace( namespaceClass = Project.class)
	public void update(Project project) throws Exception;

	@NameSpace( namespaceClass = Project.class)
	public void del(Map<String, Object> params);

	@NameSpace( namespaceClass = Project.class)
	public Project get(String id);

	@NameSpace( namespaceClass = Project.class)
	public Integer departProjectCount(String departId);
    @Paging
	@NameSpace( namespaceClass = Project.class)
	public DBPageValue<Project> paging(ProjectPagingForm pagingForm);

    @NameSpace( namespaceClass = Project.class)
	public List<String> getBatchIds(@OperParam(name = "departId") String departId,
			@OperParam(name = "year") String year);
}
