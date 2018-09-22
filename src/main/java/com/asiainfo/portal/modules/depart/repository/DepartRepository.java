package com.asiainfo.portal.modules.depart.repository;

import java.util.List;

import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.Operation;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperationType;
import com.asiainfo.portal.modules.depart.model.Depart;

@DaoBean
public interface DepartRepository {
	@Operation(operationType = OperationType.INSERT, namespaceClass = Depart.class)
	public void insert(Depart depart) throws Exception;

	@Operation(operationType = OperationType.UPDATE, namespaceClass = Depart.class)
	public void update(Depart depart) throws Exception;

	@Operation(operationType = OperationType.DELETE, namespaceClass = Depart.class)
	public void del(String id);

	@Operation(operationType = OperationType.SELECT, namespaceClass = Depart.class)
	public Depart get(String id);

	@Operation(operationType = OperationType.SELECT, namespaceClass = Depart.class)
	public List<Depart> list(String parentId);

	@Operation(operationType = OperationType.SELECT, namespaceClass = Depart.class)
	public List<Depart> getDeparts(Integer type);

}
