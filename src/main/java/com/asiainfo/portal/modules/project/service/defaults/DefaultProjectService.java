package com.asiainfo.portal.modules.project.service.defaults;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.eframe.component.UserSessionHolderService;
import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.portal.form.ProjectPagingForm;
import com.asiainfo.portal.modules.news.model.News;
import com.asiainfo.portal.modules.project.model.Project;
import com.asiainfo.portal.modules.project.repository.ProjectRepository;
import com.asiainfo.portal.modules.project.service.ProjectService;

@Service("projectService")
public class DefaultProjectService implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private UserSessionHolderService userSessionHolderService;

	@Override
	public List<Project> list(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBPageValue<Project> paging(ProjectPagingForm pagingForm) {
		pagingForm.setDepartId(userSessionHolderService.getSessionUserInfo().getDepartid());
		DBPageValue<Project> page = projectRepository.paging(pagingForm);
		return page;
	}

	@Override
	public void save(Project project) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public News get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
