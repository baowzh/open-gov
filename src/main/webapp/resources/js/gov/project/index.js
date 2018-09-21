$(document).ready(function() {

	dg111 = $('#dg').datagrid({
		title:'项目列表',
		url : '',
		toolbar : "#tb",
		loadMsg : '数据加载中...',
		sortOrder : 'asc',
		singleSelect : true,
		fit : false,
		width : '100%',
		height : grid_height(),
		showFooter : true,
		openAnimation : 'slide',
		columns : [  [

		{
			title : '填报时间',
			field : 'id',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '填报部门',
			field : 'title',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '项目名称',
			field : 'GPD201705',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '项目级别',
			field : 'GPD201704',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '项目金额',
			field : 'GPD201703',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '发放时间',
			field : 'GPD201702',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
		},

		{
			title : '备注',
			field : 'GPD201701',
			align : 'left',
			halign : 'center',
			width : '120',
			rowspan : 1,
			colspan : 1
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
		
		onLoadError : function(data) {
			//BDialog.alert(data.responseText)
		}
		
	});

});

var doSearch=function(value, name) {
	$('#dg').datagrid('load', {
		name : name,
		value : value
	});

}

var grid_height=function(){
    var realHeight=$( window ).height()-28;
    return realHeight;
 }
