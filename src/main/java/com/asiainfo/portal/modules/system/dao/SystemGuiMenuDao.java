package com.asiainfo.portal.modules.system.dao;

import java.util.List;
import java.util.Map;

import com.asiainfo.portal.modules.system.model.SystemGuiMenu;

public interface SystemGuiMenuDao {

	public void insertSystemGuiMenu(SystemGuiMenu systemGuiMenu);

	public void updateSystemGuiMenu(SystemGuiMenu systemGuiMenu);

	public void deleteSystemGuiMenu(SystemGuiMenu systemGuiMenu);

	public List<SystemGuiMenu> findSystemGuiMenu(Map<String, Object> params);
	
	public SystemGuiMenu findSystemGuiMenuByMenuId(String menuId);
	
	public String findMaxMenuIdBySubsysCode(String subsysCode);
		
	

}
