package com.asiainfo.portal.view.modules.news;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.portal.form.NewsPagingForm;
import com.asiainfo.portal.modules.news.model.News;
import com.asiainfo.portal.modules.news.service.NewsService;

@Controller
@RequestMapping(value = "news")
public class NewsController {
	@Autowired
	private NewsService newsService;
	private static Logger logger = LoggerFactory.getLogger(NewsController.class);

	@RequestMapping("index")
	public ModelAndView index(ModelMap modelMap) {
		return new ModelAndView("gov/news/index", modelMap);
	}

	@RequestMapping("edit")
	public ModelAndView add(ModelMap modelMap, Integer id) {
		News news = this.newsService.get(id);
		modelMap.put("news", news);
		return new ModelAndView("gov/news/edit", modelMap);
	}

	@ResponseBody
	@RequestMapping("del")
	public Map<String, Object> del(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			this.newsService.del(id);
			map.put("success", true);
		} catch (Exception ex) {
			ex.printStackTrace();
			map.put("success", false);
			map.put("mess", ex.getMessage());
		}
		return map;
	}

	@RequestMapping(value = "paging")
	@ResponseBody
	public DBPageValue<News> paging(NewsPagingForm pagingForm) {
		return this.newsService.paging(pagingForm);
	}

	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> save(News news) {
		Map<String, Object> returnInfo = new HashMap<String, Object>();
		try {
			newsService.save(news);
			returnInfo.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("保存新闻数据出现异常:{}", e);
			returnInfo.put("success", false);
			returnInfo.put("mess", e.getMessage());
		}
		return returnInfo;
	}

}
