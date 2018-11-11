package com.asiainfo.portal.modules.news.repository;

import java.util.List;
import java.util.Map;

import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperParam;
import com.asiainfo.eframe.sqlsession.proxy.annotations.Paging;
import com.asiainfo.portal.form.NewsPagingForm;
import com.asiainfo.portal.modules.news.model.News;

@DaoBean
public interface NewsRepository {

	public List<News> list(Map<String, Object> params);

	@Paging

	public DBPageValue<News> paging(NewsPagingForm pagingForm);

	public void insert(News news) throws Exception;

	public void update(News news) throws Exception;

	public void del(Integer id);

	public News get(Integer id);

	public Integer getDepartNewsCount(String departId);

	/**
	 * 
	 * @param cannelId
	 * @param count
	 * @return
	 */

	public List<News> topNewsByChannel(@OperParam(name = "departId") String departId,
			@OperParam(name = "cannelId") Integer cannelId, @OperParam(name = "count") Integer count);

	public List<News> hotNewsByChannel(@OperParam(name = "departId") String departId,
			@OperParam(name = "count") Integer count);

	public void updateTop(@OperParam(name = "top") Integer top, @OperParam(name = "id") Integer id);

}
