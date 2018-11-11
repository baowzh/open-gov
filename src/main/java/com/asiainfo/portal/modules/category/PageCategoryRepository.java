package com.asiainfo.portal.modules.category;

import java.util.List;

import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.NameSpace;
import com.asiainfo.portal.modules.category.model.PageCateroty;

@DaoBean
public interface PageCategoryRepository {
	@NameSpace( namespaceClass = PageCateroty.class)
	public List<PageCateroty> getPageCategorys(String pageId );
	
}
