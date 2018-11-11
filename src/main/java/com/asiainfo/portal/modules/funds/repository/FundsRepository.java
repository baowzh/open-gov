package com.asiainfo.portal.modules.funds.repository;

import java.util.List;
import java.util.Map;

import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.NameSpace;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperParam;
import com.asiainfo.eframe.sqlsession.proxy.annotations.Paging;
import com.asiainfo.portal.form.FoundsPagingForm;
import com.asiainfo.portal.modules.funds.mdoel.Funds;

@DaoBean
public interface FundsRepository {
	@NameSpace(namespaceClass = Funds.class)
	public void insert(Funds founds) throws Exception;

	@NameSpace(namespaceClass = Funds.class)
	public void update(Funds Founds) throws Exception;

	@NameSpace(namespaceClass = Funds.class)
	public void del(Map<String, Object> params);

	@NameSpace(namespaceClass = Funds.class)
	public Funds get(String id);

	@NameSpace(namespaceClass = Funds.class)
	public Integer departFoundsCount(String departId);

	@Paging
	@NameSpace(namespaceClass = Funds.class)
	public DBPageValue<Funds> paging(FoundsPagingForm pagingForm);

	@NameSpace(namespaceClass = Funds.class)
	public List<String> getBatchIds(@OperParam(name = "departId") String departId,
			@OperParam(name = "year") String year);
}
