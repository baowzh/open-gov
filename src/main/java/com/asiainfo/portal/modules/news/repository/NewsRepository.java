package com.asiainfo.portal.modules.news.repository;

import java.util.List;
import java.util.Map;

import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.Operation;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperationType;
import com.asiainfo.portal.form.NewsPagingForm;
import com.asiainfo.portal.modules.news.model.News;

@DaoBean
public interface NewsRepository {
	@Operation(operationType = OperationType.SELECT, namespaceClass = News.class)
	public List<News> list(Map<String, Object> params);

	@Operation(operationType = OperationType.PAGING, namespaceClass = News.class)
	public DBPageValue<News> paging(NewsPagingForm pagingForm);

	@Operation(operationType = OperationType.INSERT, namespaceClass = News.class)
	public void insert(News news) throws Exception;

	@Operation(operationType = OperationType.UPDATE, namespaceClass = News.class)
	public void update(News news) throws Exception;

	@Operation(operationType = OperationType.DELETE, namespaceClass = News.class)
	public void del(Integer id);

	@Operation(operationType = OperationType.SELECT, namespaceClass = News.class)
	public News get(Integer id);
}
