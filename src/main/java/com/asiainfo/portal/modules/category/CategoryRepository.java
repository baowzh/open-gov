package com.asiainfo.portal.modules.category;

import java.util.List;

import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.NameSpace;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperParam;
import com.asiainfo.portal.modules.category.model.Category;

@DaoBean
public interface CategoryRepository {
	@NameSpace( namespaceClass = Category.class)
	public List<Category> getCategorys(@OperParam(name="group") Integer group);
	@NameSpace( namespaceClass = Category.class)
	public List<Category> getSubCategorys(@OperParam(name="id") Integer id,@OperParam(name="group") Integer group);
	@NameSpace( namespaceClass = Category.class)
	public Category get(Integer id);
}
