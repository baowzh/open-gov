package com.asiainfo.portal.view.basic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("userpass")
public class UserPasswordController {
	@ResponseBody
	@RequestMapping("update")
	public Map<String, Object> updpass(String oldPassWord, String newPassWord) {
		return new HashMap<String, Object>();
	}

}
