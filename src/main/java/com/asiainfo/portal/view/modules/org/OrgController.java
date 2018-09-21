package com.asiainfo.portal.view.modules.org;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asiainfo.portal.view.modules.system.bean.BasicTree;

@Controller
@RequestMapping(value = "org")
public class OrgController {
	@RequestMapping("index")
	public ModelAndView index(ModelMap modelMap) {
		return new ModelAndView("gov/org/index", modelMap);
	}

	@RequestMapping("info")
	public ModelAndView info(ModelMap modelMap) {
		return new ModelAndView("gov/org/info", modelMap);
	}

	@RequestMapping("add")
	public ModelAndView add(ModelMap modelMap) {
		return new ModelAndView("gov/org/add", modelMap);
	}
	@RequestMapping("treeInfo")
	@ResponseBody
	public List<BasicTree> menuTree(String menuId, ModelMap modelMap) {
		
		List<BasicTree> basicTrees = new ArrayList<BasicTree>();
		return basicTrees;

	}


}
