package com.asiainfo.portal.modules.system.service;

import java.util.List;

import com.asiainfo.eframe.security.model.UserInfo;
import com.asiainfo.portal.modules.system.model.SystemGuiMenu;
import com.asiainfo.portal.view.modules.system.bean.SystemMenuBean;

public interface SystemGuiMenuService {

	public void saveInfo(SystemMenuBean systemGuiMenu,UserInfo userInfo);

	public void removeInfo(String menuId);

	public SystemGuiMenu getInfoByMenuId(String menuId);

	public SystemMenuBean getBeanByMenuId(String menuId);

	public List<SystemGuiMenu> getAllMenu();

	public List<SystemGuiMenu> getMenuByParentId(String parentMenuId);

}
