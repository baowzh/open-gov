$(document).ready(function() {

	dg111 = $('#dg').datagrid({
		title : '新闻列表',
		url : 'paging.jhtml',
		toolbar : "#tb",
		loadMsg : '数据加载中...',
		sortOrder : 'asc',
		singleSelect : true,
		fit : false,
		width : '100%',
		height : grid_height(),
		showFooter : true,
		openAnimation : 'slide',
		columns : [ [

		{
			title : 'id',
			field : 'id',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '标题',
			field : 'title',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '栏目',
			field : 'GPD201705',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '分类',
			field : 'GPD201704',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '关键字',
			field : 'GPD201703',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '摘要',
			field : 'GPD201702',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '发布时间',
			field : 'GPD201701',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '发布部门',
			field : 'GPD201612',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '发布人',
			field : 'GPD201611',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '【操作】',
			field : 'GPD201610',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1,
			formatter : function(value, row, index) {
				return '<a>修改</a>&nbsp;|&nbsp;<a>删除</a>';
			}

		}

		]

		],
		autoRowHeight : true,
		striped : true,
		rownumbers : true,
		pagination : true,
		pageSize : 10,
		pageList : [ 10, 30, 50, 70, 100 ],
		remoteFilter : false,
		loadFilter : function(data) {
			return {
				'rows' : data.models,
				'total' : data.totalrowcount
			};
		},
		onLoadError : function(data) {
			//BDialog.alert(data.responseText)
		}

	});

});

var doSearch = function(value, name) {
	$('#dg').datagrid('load', {
		name : name,
		value : value
	});

}

var grid_height = function() {
	var realHeight = $(window).height() - 28;
	return realHeight;
}
