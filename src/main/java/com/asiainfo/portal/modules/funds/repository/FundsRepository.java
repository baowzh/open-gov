package com.asiainfo.portal.modules.funds.repository;

import java.util.List;
import java.util.Map;

import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperParam;
import com.asiainfo.eframe.sqlsession.proxy.annotations.Operation;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperationType;
import com.asiainfo.portal.form.FoundsPagingForm;
import com.asiainfo.portal.modules.funds.mdoel.Funds;

@DaoBean
public interface FundsRepository {
	@Operation(operationType = OperationType.INSERT, namespaceClass = Funds.class)
	public void insert(Funds founds) throws Exception;

	@Operation(operationType = OperationType.UPDATE, namespaceClass = Funds.class)
	public void update(Funds Founds) throws Exception;

	@Operation(operationType = OperationType.DELETE, namespaceClass = Funds.class)
	public void del(Map<String, Object> params);

	@Operation(operationType = OperationType.SELECT, namespaceClass = Funds.class)
	public Funds get(String id);

	@Operation(operationType = OperationType.SELECT, namespaceClass = Funds.class)
	public Integer departFoundsCount(String departId);

	@Operation(operationType = OperationType.PAGING, namespaceClass = Funds.class)
	public DBPageValue<Funds> paging(FoundsPagingForm pagingForm);

	@Operation(operationType = OperationType.SELECT, namespaceClass = Funds.class)
	public List<String> getBatchIds(@OperParam(name = "departId") String departId,
			@OperParam(name = "year") String year);
}
