package com.asiainfo.portal.modules.news.repository;

import java.util.List;

import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.NameSpace;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperParam;
import com.asiainfo.portal.modules.news.model.News;
import com.asiainfo.portal.modules.news.model.NewsPost;

@DaoBean
public interface NewsPostRepository {
	@NameSpace(namespaceClass = NewsPost.class)
	public void insert(NewsPost newsPost);

	@NameSpace( namespaceClass = NewsPost.class)
	public void del(@OperParam(name = "departId") String departId, @OperParam(name = "id") Integer Id);

	@NameSpace( namespaceClass = NewsPost.class)
	public List<News> getPostedNews(@OperParam(name = "departId") String departId,
			@OperParam(name = "count") Integer count);
}
