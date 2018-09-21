package com.asiainfo.portal.view.modules.system.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asiainfo.eframe.component.UserSessionHolderService;
import com.asiainfo.eframe.security.model.UserInfo;
import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.portal.modules.system.model.Role;
import com.asiainfo.portal.modules.system.model.User;
import com.asiainfo.portal.modules.system.service.SystemService;
import com.asiainfo.portal.view.modules.system.bean.SubmitRest;
import com.asiainfo.portal.view.modules.system.bean.UserDBPagingPrams;
import com.asiainfo.portal.view.modules.system.bean.UserRoleBeen;
import com.google.common.base.Objects;

@Controller
@RequestMapping(value = "system/user")
public class UserController {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SystemService systemService;

	@Autowired
	private UserSessionHolderService contextHolderService;


	@RequestMapping("index")
	public ModelAndView systemUser(ModelMap modelMap) {
		return new ModelAndView("system/user/index", modelMap);
	}

	@RequestMapping("infoList")
	@ResponseBody
	public UserList4Page infoList(String staffname, Integer rows, Integer page, ModelMap modelMap) {

		UserList4Page userList4Page = new UserList4Page();

		UserDBPagingPrams dbPagingPrams = new UserDBPagingPrams();
		dbPagingPrams.setStaffname(staffname);

		dbPagingPrams.setRows(rows);
		dbPagingPrams.setPage(page);

		DBPageValue<User> pageUsers = systemService.findUser(dbPagingPrams, new User());

		userList4Page.setTotal(Long.valueOf(pageUsers.getTotalrowcount()));
		userList4Page.setRows(pageUsers.getModels());
		return userList4Page;
	}

	@RequestMapping("assignationRole")
	public ModelAndView assignationRole(String staffid, ModelMap modelMap) {

		User user = systemService.getUser(staffid);
		if (user == null) {
			throw new RuntimeException("用户信息查询失败");
		}
		modelMap.put("user", user);
		return new ModelAndView("system/user/assignationRole", modelMap);
	}

	@RequestMapping("userRoleList")
	@ResponseBody
	public List<Role> userRoleList(String staffid, ModelMap modelMap) {
		List<Role> allRoles = systemService.findAllRole();
		List<Role> assignedRoles = systemService.findRole(null, staffid);


		if (allRoles != null && assignedRoles != null) {
			for (Role roleInfo : allRoles) {
				for (Role assignedRole : assignedRoles) {
					if (Objects.equal(roleInfo.getRightcode(), assignedRole.getRightcode())) {
						roleInfo.setSelected(true);
					}
				}
			}
		}

		return allRoles;

	}

	@RequestMapping("saveUserRole")
	@ResponseBody
	public SubmitRest saveUserRole(UserRoleBeen userRoleBeen, ModelMap modelMap) {
		SubmitRest saveUserRest = new SubmitRest();
		UserInfo userInfo = contextHolderService.getSessionUserInfo();

		try {
			if (userRoleBeen != null) {
				systemService.saveUserRole(userRoleBeen,userInfo);

				saveUserRest.setSuccess(true);
				saveUserRest.setMessage("保存成功");
			} else {
				saveUserRest.setSuccess(false);
				saveUserRest.setMessage("保存失败：数据传输异常");
			}

		} catch (RuntimeException e) {
			logger.error("saveUserRole error:",e);			
			
			saveUserRest.setSuccess(false);
			saveUserRest.setMessage("保存失败:" + e.getMessage());
		}

		return saveUserRest;

	}

	public static class UserList4Page {
		private List<User> rows;
		private Long total = 0L;

		public List<User> getRows() {
			return rows;
		}

		public void setRows(List<User> rows) {
			this.rows = rows;
		}

		public Long getTotal() {
			return total;
		}

		public void setTotal(Long total) {
			this.total = total;
		}

	}

}
