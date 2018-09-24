package com.asiainfo.portal.modules.category;

import java.util.List;

import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.Operation;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperationType;
import com.asiainfo.portal.modules.category.model.PageCateroty;

@DaoBean
public interface PageCategoryRepository {
	@Operation(operationType = OperationType.SELECT, namespaceClass = PageCateroty.class)
	public List<PageCateroty> getPageCategorys(String pageId );
	
}
