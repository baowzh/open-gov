package com.asiainfo.portal.view.modules.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "project")
public class ProjectController {
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

}
