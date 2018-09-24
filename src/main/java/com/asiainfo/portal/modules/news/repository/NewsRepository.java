package com.asiainfo.portal.modules.news.repository;

import java.util.List;
import java.util.Map;

import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperParam;
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

	@Operation(operationType = OperationType.SELECT, namespaceClass = News.class)
	public Integer getDepartNewsCount(String departId);

	/**
	 * 
	 * @param cannelId
	 * @param count
	 * @return
	 */
	@Operation(operationType = OperationType.SELECT, namespaceClass = News.class)
	public List<News> topNewsByChannel(@OperParam(name = "departId") String departId,
			@OperParam(name = "cannelId") Integer cannelId, @OperParam(name = "count") Integer count);

	@Operation(operationType = OperationType.SELECT, namespaceClass = News.class)
	public List<News> hotNewsByChannel(@OperParam(name = "departId") String departId,
			@OperParam(name = "count") Integer count);
	@Operation(operationType = OperationType.UPDATE, namespaceClass = News.class)
	public void updateTop(@OperParam(name = "top") Integer top,@OperParam(name = "id") Integer id);

}
