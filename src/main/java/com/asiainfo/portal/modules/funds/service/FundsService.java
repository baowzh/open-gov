package com.asiainfo.portal.modules.funds.service;

import java.util.List;
import java.util.Map;

import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.portal.basic.model.FileContent;
import com.asiainfo.portal.form.FoundsPagingForm;
import com.asiainfo.portal.modules.funds.mdoel.Funds;
import com.asiainfo.portal.modules.news.model.News;

public interface FundsService {
	public List<Funds> list(Map<String, Object> params);

	public DBPageValue<Funds> paging(FoundsPagingForm pagingForm);

	public void save(Funds founds) throws Exception;

	public void del(String batchId)throws Exception;

	public News get(Integer id);

	public void upload(FileContent excelContent) throws Exception;

	public void townUpload(FileContent excelContent) throws Exception;

	public List<String> getBathIds() ;
}
