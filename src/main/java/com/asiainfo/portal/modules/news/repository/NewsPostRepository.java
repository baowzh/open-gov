package com.asiainfo.portal.modules.news.repository;

import java.util.List;

import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperParam;
import com.asiainfo.eframe.sqlsession.proxy.annotations.Operation;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperationType;
import com.asiainfo.portal.modules.news.model.News;
import com.asiainfo.portal.modules.news.model.NewsPost;

@DaoBean
public interface NewsPostRepository {
	@Operation(operationType = OperationType.INSERT, namespaceClass = NewsPost.class)
	public void insert(NewsPost newsPost);

	@Operation(operationType = OperationType.DELETE, namespaceClass = NewsPost.class)
	public void del(@OperParam(name = "departId") String departId, @OperParam(name = "id") Integer Id);

	@Operation(operationType = OperationType.SELECT, namespaceClass = NewsPost.class)
	public List<News> getPostedNews(@OperParam(name = "departId") String departId,
			@OperParam(name = "count") Integer count);
}
