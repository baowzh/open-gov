package com.asiainfo.portal.view.modules.news;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "news")
public class NewsController {
	@RequestMapping("index")
	public ModelAndView index(ModelMap modelMap) {
		return new ModelAndView("gov/news/index", modelMap);
	}
	
	@RequestMapping("add")
	public ModelAndView add(ModelMap modelMap) {
		return new ModelAndView("gov/news/add", modelMap);
	}
	
}
