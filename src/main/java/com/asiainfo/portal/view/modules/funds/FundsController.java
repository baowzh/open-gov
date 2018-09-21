package com.asiainfo.portal.view.modules.funds;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "funds")
public class FundsController {
	@RequestMapping("index")
	public ModelAndView index(ModelMap modelMap) {
		return new ModelAndView("gov/funds/index", modelMap);
	}

	@RequestMapping("add")
	public ModelAndView add(ModelMap modelMap) {
		return new ModelAndView("gov/funds/add", modelMap);
	}

	@RequestMapping("import")
	public ModelAndView importExcel(ModelMap modelMap) {
		return new ModelAndView("gov/funds/import", modelMap);
	}

}
