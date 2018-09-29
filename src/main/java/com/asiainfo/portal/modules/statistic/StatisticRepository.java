package com.asiainfo.portal.modules.statistic;

import com.asiainfo.eframe.sqlsession.model.DBPageValue;
import com.asiainfo.eframe.sqlsession.model.DBPagingPrams;
import com.asiainfo.eframe.sqlsession.proxy.annotations.DaoBean;
import com.asiainfo.eframe.sqlsession.proxy.annotations.Operation;
import com.asiainfo.eframe.sqlsession.proxy.annotations.OperationType;

@DaoBean
public interface StatisticRepository {

	@Operation(operationType = OperationType.PAGING, namespace = "statistic")
	public DBPageValue<java.util.Map<String, Object>> pagingCunwgkStatistic(DBPagingPrams pagingParam);

	@Operation(operationType = OperationType.PAGING, namespace = "statistic")
	public DBPageValue<java.util.Map<String, Object>> pagingDwgkStatistic(DBPagingPrams pagingParam);

	@Operation(operationType = OperationType.PAGING, namespace = "statistic")
	public DBPageValue<java.util.Map<String, Object>> pagingZwgkStatistic(DBPagingPrams pagingParam);

}
