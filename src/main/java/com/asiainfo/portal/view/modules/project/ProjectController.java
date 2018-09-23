package com.asiainfo.portal.view.modules.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.portal.basic.model.FileContent;
import com.asiainfo.portal.form.ProjectPagingForm;
import com.asiainfo.portal.modules.project.model.Project;
import com.asiainfo.portal.modules.project.service.ProjectService;
import com.asiainfo.portal.view.modules.FileUploadControler;

@Controller
@RequestMapping(value = "project")
public class ProjectController extends FileUploadControler {
	@Autowired
	private ProjectService projectService;

	@RequestMapping("depart/index")
	public ModelAndView departIndex(ModelMap modelMap) {
		return new ModelAndView("gov/project/departIndex", modelMap);
	}

	@RequestMapping("town/index")
	public ModelAndView townIndex(ModelMap modelMap) {
		return new ModelAndView("gov/project/townIndex", modelMap);
	}

	@RequestMapping("add")
	public ModelAndView add(ModelMap modelMap) {
		return new ModelAndView("gov/project/add", modelMap);
	}

	@RequestMapping("del")
	public ModelAndView del(ModelMap modelMap, String departType) {
		List<String> bathIds = this.projectService.getBathIds();
		modelMap.put("bathIds", bathIds);
		modelMap.put("departType", departType);
		return new ModelAndView("gov/project/del", modelMap);
	}
	@ResponseBody
	@RequestMapping("delData")
	public Map<String, Object> delData(String bathId) {
		Map<String, Object> info = new HashMap<String, Object>();
		try {
			this.projectService.del(bathId);
			info.put("success", true);
		} catch (Exception ex) {
			ex.printStackTrace();
			info.put("success", false);
			info.put("mess", ex.getMessage());
		}
		return info;
	}

	@RequestMapping("depart/import")
	public ModelAndView departImport(ModelMap modelMap) {
		return new ModelAndView("gov/project/departimport", modelMap);
	}

	@RequestMapping("town/import")
	public ModelAndView importExcel(ModelMap modelMap) {
		return new ModelAndView("gov/project/townimport", modelMap);
	}

	@RequestMapping("depart/upload")
	public ModelAndView departUpload(HttpServletRequest request, ModelMap modelMap) {
		try {
			FileContent excelContent = this.getFileContent(request);
			projectService.upload(excelContent);
			modelMap.put("mess", "导入成功。");
			modelMap.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("mess", e.getMessage());
			modelMap.put("success", false);

		}
		return new ModelAndView("gov/project/departimport", modelMap);
	}

	@RequestMapping("town/upload")
	public ModelAndView townUpload(HttpServletRequest request, ModelMap modelMap) {
		try {
			FileContent excelContent = this.getFileContent(request);
			projectService.townUpload(excelContent);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ModelAndView("gov/project/townimport", modelMap);
	}

	@RequestMapping(value = "depart/paging")
	@ResponseBody
	public DBPageValue<Project> departPaging(ProjectPagingForm pagingForm) {
		return this.projectService.paging(pagingForm);
	}

}
