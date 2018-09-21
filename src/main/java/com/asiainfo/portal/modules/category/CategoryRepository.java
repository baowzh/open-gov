package com.asiainfo.portal.modules.category;

import java.util.List;

import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.Operation;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperationType;
import com.asiainfo.portal.modules.category.model.Category;

@DaoBean
public interface CategoryRepository {
	@Operation(operationType = OperationType.SELECT, namespaceClass = Category.class)
	public List<Category> getCategorys();
	@Operation(operationType = OperationType.SELECT, namespaceClass = Category.class)
	public List<Category> getSubCategorys(Integer id);
}
