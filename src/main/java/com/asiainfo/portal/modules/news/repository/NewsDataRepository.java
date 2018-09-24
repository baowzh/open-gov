package com.asiainfo.portal.modules.news.repository;

import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.Operation;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperationType;
import com.asiainfo.portal.modules.news.model.NewsData;

@DaoBean
public interface NewsDataRepository {

	@Operation(operationType = OperationType.INSERT, namespaceClass = NewsData.class)
	public void insert(NewsData news) throws Exception;

	@Operation(operationType = OperationType.UPDATE, namespaceClass = NewsData.class)
	public void update(NewsData news) throws Exception;

	@Operation(operationType = OperationType.DELETE, namespaceClass = NewsData.class)
	public void del(Integer id);

	@Operation(operationType = OperationType.SELECT, namespaceClass = NewsData.class)
	public NewsData get(Integer id);


	

}
