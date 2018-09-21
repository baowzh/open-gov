package com.asiainfo.portal.basic.dao;

import java.util.List;
import java.util.Map;

import com.asiainfo.eframe.security.model.RoleInfo;
import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.Operation;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperationType;
@DaoBean
public interface IRoleDao {
	@Operation(operationType = OperationType.SELECT, namespaceClass = String.class, namespace = "role")
	public List<RoleInfo> getRoleInfosByUsername(Map<String, Object> params);
}
