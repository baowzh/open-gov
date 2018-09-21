package com.asiainfo.portal.modules.news.service.defaults;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.portal.form.NewsPagingForm;
import com.asiainfo.portal.modules.news.model.News;
import com.asiainfo.portal.modules.news.model.NewsData;
import com.asiainfo.portal.modules.news.repository.NewsDataRepository;
import com.asiainfo.portal.modules.news.repository.NewsRepository;
import com.asiainfo.portal.modules.news.service.NewsService;

@Service("newsService")
public class DefaultNewsService implements NewsService {
	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private NewsDataRepository newsDataRepository;
	private static Logger logger = LoggerFactory.getLogger(DefaultNewsService.class);

	@Override
	public List<News> list(Map<String, Object> params) {

		return newsRepository.list(params);
	}

	@Override
	public DBPageValue<News> paging(NewsPagingForm pagingForm) {

		return newsRepository.paging(pagingForm);
	}

	@Override
	public void save(News news) throws Exception {
		// 校验正确性然后保存
		NewsData newsData = new NewsData();
		newsData.setContent(news.getContent());
		newsData.setId(news.getId());
		if (news.getId() == null) {
			this.newsRepository.insert(news);
			newsData.setId(news.getId());
			this.newsDataRepository.insert(newsData);
		} else {
			this.newsRepository.update(news);
			this.newsDataRepository.update(newsData);
		}
	}

	@Override
	public void del(Integer id) {
		this.newsRepository.del(id);
	}

	@Override
	public News get(Integer id) {

		return this.newsRepository.get(id);
	}

}
