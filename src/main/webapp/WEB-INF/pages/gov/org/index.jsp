<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../../public/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>菜单管理</title>
<asiainfo:resource needFallBack="false"
	type="Bootstrap,easyui,jquery,dynamicform,validate"></asiainfo:resource>
<script type="text/javascript">
	var index = 0;
	function removeTab(title) {
		$('#menuInfo').tabs('close', title);
	}

	function addTab() {

		var index = $('#tree').tree('getSelected');
		var title = index.text;
		var url = "menuInfo.jhtml?menuId=" + index.id;
		var content = '<iframe scrolling="auto" frameborder="0"  src="' + url
				+ '" style="width:100%;height:100%;"></iframe>';

		if ($('#menuInfo').tabs('exists', title)) {

			$('#menuInfo').tabs('select', title);

		} else {

			$('#menuInfo').tabs('add', {
				title : title,
				content : content,
				closable : true
			});
		}
	}

	function refreshMenuInfo() {
		// onclick="refreshMenuInfo()"
		var index = $('#tree').tree('getSelected');
		var title = index.text;
		var url = "menuInfo.jhtml?menuId=" + index.id;
		$('#pp').panel('open').panel('refresh', url);

	}

	function reloadMenuTree() {

		$('#tree').tree('reload');

	}

	function testButton2() {
		$('#tree').tree("reload");
	}

	function edit(id) {
		var url = 'edit.jhtml?id=' + id
		$('#pp').panel('open').panel('refresh', url);
		// 绑定插件
		$('#parentId').asiainfoSelect({
			id : '#parentId',
			url : '${ctx}/ui/getTowns.jhtml'
		});

	}

	function updateMenu() {

		var index = $('#tree').tree('getSelected');
		var top = 0;
		var left = 0

		if (screen.width > 900) {
			left = (screen.width - 900) / 2
		}
		if (screen.height > 450) {
			top = (screen.height - 450) / 2
		}

		//var row = $('#dg').datagrid('getSelected');
		var child = window.open("updateInfo.jhtml?menuId=" + index.id,
				"修改菜单信息",
				"height=450,width=900,status=yes,toolbar=no,menubar=no,location=no,top="
						+ top + ",left=" + left);

	}
	var submitForm = function() {
		$('#editOrg').submit();

	}
	var loadTowns = function() {

		$.ajax({
			type : "POST",
			url : '${ctx}/ui/getTowns.jhtml',
			dataType : "json",
			success : function(data) {
				$('#parentId').empty();
				var defaultOption = $('<option>').attr({
					value : ''
				}).text('请选择');
				$('#parentId').append(defaultOption);
				for (var i = 0; i < data.length; i++) {
					var option = $('<option>').attr({
						value : data[i].id
					}).text(data[i].text);
					$('#parentId').append(option);
				}
			},
			error : function(info) {
				console.log("连接异常，请检查！")
			}
		});

	}
	
 var del=function(id){
 
  $.ajax({
			type : "POST",
			url : '${ctx}/org/del.jhtml',
			data:{
			id:id
			},
			dataType : "json",
			success : function(data) {
				 if(data.success){
				   alert('删除成功。');		
				   window.location.href='${ctx}/org/index.jhtml';		   
				 }else{
				  alert(data.mess);
				 }
			},
			error : function(info) {
				console.log("连接异常，请检查！")
			}
		});
 
 
 }
	
 
</script>

</head>
<body style="background: #F7F7F7;" >
	<div style="margin: 20px 0;"></div>
	<div class="easyui-layout" style="width: 100%; height: 95%">
		<div region="west" split="true" style="width: 20%; height: 100%;">
			<div class="easyui-layout" style="width: 100%; height: 100%">
				<div data-options="region:'north'"
					style="padding: 4px; background: #fafafa; width: 100px; height: 40px; border: 1px solid #ccc">
					<a href="javascript:void(0)" target="_blank"
						class="btn btn-success" onclick="edit()">添加</a> <a
						href="javascript:void(0)" class="btn btn-success"
						iconCls="icon-reload" onclick="reloadMenuTree()">刷新</a>
				</div>
				<div data-options="region:'center',split:true" style="height: 100%;">
					<ul id="tree" class="easyui-tree"
						data-options="url:'treeInfo.jhtml',
				onSelect: function( node){
					var title = node.text;
					var url = 'info.jhtml?id=' + node.id;
					$('#pp').panel('open').panel('refresh', url);
				}"></ul>
				</div>


			</div>
		</div>

		<div id="pp" class="easyui-panel" region="center"
			style="width: 100%; height: 100%;"></div>
	</div>
</body>
</html>