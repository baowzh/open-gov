package com.asiainfo.portal.basic.dao;

import java.util.List;
import java.util.Map;

import com.asiainfo.eframe.model.UserMenuValue;
import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.NameSpace;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperParam;
import com.asiainfo.eframe.sqlsession.proxy.annotations.ParamType;

@DaoBean
public interface IMenuDao {

	/**
	 * 获取有权限的菜单列表
	 * 
	 * @return
	 */
	@NameSpace( namespaceClass = UserMenuValue.class, namespace = "usermenuvalue")
	public List<UserMenuValue> getUserMenuValues(@OperParam(type = ParamType.SYSNAME) String sysName,
			@OperParam(type = ParamType.SQLPARAM) Map<String, Object> params);

	/**
	 * 获取有权限菜单的所有上级菜单
	 * 
	 * @param menuId
	 * @return
	 */
	@NameSpace( namespaceClass = UserMenuValue.class, namespace = "usermenuvalue")
	public UserMenuValue getParentMenus(@OperParam(type = ParamType.SYSNAME) String sysName,
			@OperParam(type = ParamType.SQLPARAM) String parentMenuId);
}
