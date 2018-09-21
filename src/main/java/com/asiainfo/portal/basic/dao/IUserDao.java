package com.asiainfo.portal.basic.dao;

import java.util.Map;

import com.asiainfo.eframe.security.model.UserInfo;
import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperParam;
import com.asiainfo.eframe.sqlsession.proxy.annotations.Operation;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperationType;
import com.asiainfo.eframe.sqlsession.proxy.annotations.ParamType;

/**
 * 
 * @author baowzh
 *
 */
@DaoBean
public interface IUserDao {
	/**
	 * 获取用户名
	 * 
	 * @return
	 */
	@Operation(operationType = OperationType.SELECT, namespaceClass = String.class, namespace = "user")
	public String getUserName(@OperParam(type = ParamType.SQLPARAM) Map<String, Object> params);

	/**
	 * 
	 * @param userName
	 * @return
	 */
	@Operation(operationType = OperationType.SELECT, namespaceClass = String.class, namespace = "user")
	public UserInfo getUserByName(@OperParam(type = ParamType.SQLPARAM) String userName);
}
