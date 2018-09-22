package com.asiainfo.portal.view.modules.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.portal.form.ProjectPagingForm;
import com.asiainfo.portal.modules.project.model.Project;
import com.asiainfo.portal.modules.project.service.ProjectService;
import com.asiainfo.portal.view.modules.FileUploadControler;

@Controller
@RequestMapping(value = "project")
public class ProjectController extends FileUploadControler {
	@Autowired
	private ProjectService projectService;

	@RequestMapping("index")
	public ModelAndView index(ModelMap modelMap) {
		return new ModelAndView("gov/project/index", modelMap);
	}

	@RequestMapping("add")
	public ModelAndView add(ModelMap modelMap) {
		return new ModelAndView("gov/project/add", modelMap);
	}

	@RequestMapping("import")
	public ModelAndView importExcel(ModelMap modelMap) {
		return new ModelAndView("gov/project/import", modelMap);
	}

	@RequestMapping("upload")
	public ModelAndView upload(HttpServletRequest request, ModelMap modelMap) {
		try {
			byte[] excelContent = this.getFileContent(request);
			projectService.upload(excelContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("gov/project/import", modelMap);
	}

	@RequestMapping(value = "paging")
	@ResponseBody
	public DBPageValue<Project> paging(ProjectPagingForm pagingForm) {
		return this.projectService.paging(pagingForm);
	}

}
