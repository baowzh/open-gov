package com.asiainfo.portal.modules.news.repository;

import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.NameSpace;
import com.asiainfo.portal.modules.news.model.NewsData;

@DaoBean
public interface NewsDataRepository {

	@NameSpace( namespaceClass = NewsData.class)
	public void insert(NewsData news) throws Exception;

	@NameSpace( namespaceClass = NewsData.class)
	public void update(NewsData news) throws Exception;

	@NameSpace( namespaceClass = NewsData.class)
	public void del(Integer id);

	@NameSpace( namespaceClass = NewsData.class)
	public NewsData get(Integer id);


	

}
