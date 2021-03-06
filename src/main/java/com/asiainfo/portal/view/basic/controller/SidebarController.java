package com.asiainfo.portal.view.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asiainfo.eframe.component.UserSessionHolderService;
import com.asiainfo.eframe.security.model.UserInfo;

@Controller
@RequestMapping("sidebar")
public class SidebarController {
	@Autowired
	private UserSessionHolderService contextHolderService;
	@RequestMapping("index")
	public ModelAndView index(ModelMap modelMap) {
		UserInfo userInfo = contextHolderService.getSessionUserInfo();
		modelMap.put("userInfo", userInfo);
		return new ModelAndView("Sidebar", modelMap);
	}

}
