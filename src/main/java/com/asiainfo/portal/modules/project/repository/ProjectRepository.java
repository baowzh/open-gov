package com.asiainfo.portal.modules.project.repository;

import java.util.List;
import java.util.Map;

import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperParam;
import com.asiainfo.eframe.sqlsession.proxy.annotations.Operation;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperationType;
import com.asiainfo.portal.form.ProjectPagingForm;
import com.asiainfo.portal.modules.project.model.Project;

@DaoBean
public interface ProjectRepository {
	@Operation(operationType = OperationType.INSERT, namespaceClass = Project.class)
	public void insert(Project project) throws Exception;

	@Operation(operationType = OperationType.UPDATE, namespaceClass = Project.class)
	public void update(Project project) throws Exception;

	@Operation(operationType = OperationType.DELETE, namespaceClass = Project.class)
	public void del(Map<String, Object> params);

	@Operation(operationType = OperationType.SELECT, namespaceClass = Project.class)
	public Project get(String id);

	@Operation(operationType = OperationType.SELECT, namespaceClass = Project.class)
	public Integer departProjectCount(String departId);

	@Operation(operationType = OperationType.PAGING, namespaceClass = Project.class)
	public DBPageValue<Project> paging(ProjectPagingForm pagingForm);

	@Operation(operationType = OperationType.SELECT, namespaceClass = Project.class)
	public List<String> getBatchIds(@OperParam(name = "departId") String departId,
			@OperParam(name = "year") String year);
}
