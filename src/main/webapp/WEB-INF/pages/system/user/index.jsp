<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../../public/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyUI/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyUI/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/easyUI/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/easyUI/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

	});


	function editUserRole() {
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			var top = 0;
			var left = 0
			if (screen.height > 500) {
				top = (screen.height - 500) / 2
			}
			if (screen.width > 850) {
				left = (screen.width - 850) / 2
			}

			//var row = $('#dg').datagrid('getSelected');
			var child = window.open("assignationRole.jhtml?staffid="
					+ row.staffid, "修改用户角色",
					"height=500,width=850,status=yes,toolbar=no,menubar=no,location=no,top="
							+ top + ",left=" + left);
		} else {
			alert("请选择需要修改的功能")
		}

	}

	function getRowIndex(target) {
		var tr = $(target).closest('tr.datagrid-row');
		return parseInt(tr.attr('datagrid-row-index'));
	}

	function formatOper(val, row, index) {
		return '<a href="#" class="easyui-linkbutton"  iconCls="icon-edit" text="修改" plain="true" onclick="editFunc(this)">修改</a>';
	}


	function sexformatOper(val, row, index) {
		if(val == '0'){
			return '男';
		}else if(val == '1'){
			return '女';
		}else{
			return val;
		}
	}
	
	function dismissionformatOper(val, row, index) {
		if(val == '0'){
			return '有效';
		}else if(val == '1'){
			return '失效';
		}else{
			return val;
		}
	}
	function custManagerformatOper(val, row, index) {
		if(val == '0'){
			return '客户经理';
		}else if(val == '1'){
			return '商家客户经理';
		}else if(val == '2'){
			return '集团客户经理';
		}else{
			return val;
		}
	}
	
	function doSearch(value, name) {
		$('#dg').datagrid('load', {
			'staffname': value
		});

	}
	
	
	function qq(value, name) {
		alert(value + ":" + name)
	}
</script>

</head'
<body>
	<div style="margin: 20px 0;">
	
	</div>
	
	<table id="dg" class="easyui-datagrid" title="员工列表"
		style="width: 100%; height: 450px" toolbar="#tb"
		data-options="rownumbers:true,method:'get',singleSelect:true,
			url:'infoList.jhtml',
				pagination:true,
				autoRowHeight:true,
				pageSize:10	">
			
		<thead>
			<tr id="dg-tr">
				<th field="staffid" width="100"  halign="center" align="left"  >员工编码</th>
				<th field="staffname" width="140"  halign="center" align="left"  >员工姓名</th>
				<th field="departName" width="100"   halign="center" align="left"  >部门名称</th>
				<th field="jobCode" width="60"   halign="center" align="left"  >岗位编码</th>
				<th field="managerInfo" width="140"  halign="center" align="left"  >职务说明</th>
				<th field="sex" width="80"  halign="center" align="left"  formatter=sexformatOper>性别</th>
				<th field="email" width="100"   halign="center" align="left" >电子邮件</th>
				<th field="userPid" width="140"  halign="center" align="left"  >身份证号码</th>
				<th field="serialNumber" width="100"   halign="center" align="left" >服务号码</th>
				<th field="dimissionTag" width="60"  halign="center" align="left"  formatter=dismissionformatOper>失效标志</th>
				<th field="birthday" width="80"   halign="center" align="left"  >生日</th>
				<th field="staffGroupId" width="80"  halign="center" align="left" >员工班组</th>
				<th field="managerStaffId" width="140"   halign="center" align="left" >员工管理者</th>
				<th field="receiveTypeCode" width="60"   halign="center" align="left" >收银类型</th>
				<th field="loginFlag" width="60"  halign="center" align="left"  >登陆标志</th>
				<th field="custManagerFlag" width="100"   halign="center" align="left"  formatter=custManagerformatOper >客户经理类型</th>
				<th field="cityName" width="80"   halign="center" align="left"  >城市</th>
				<th field="remark" width="140"   halign="center" align="left" >备注</th>
				<th field="updateTime" width="120"   halign="center" align="left"  >更新时间</th>
				<th field="updateStaffId" width="120" halign="center" align="left"  >更新员工</th>
				<th field="updateDepartName" width="120"  halign="center" align="left" >更新部门</th>
				<th field="linkPhone" width="60"   halign="center" align="left" >联系电话</th>
				<th field="oasystemAcct" width="80"  halign="center" align="left" >OA系统账号</th>
			</tr>

		</thead>
	</table>
	<div id="tb" style="height:auto">
	
	<input id="ss" class="easyui-searchbox" style="width:300px"
    data-options="searcher:doSearch, prompt:'请输入需要查找用户名',menu:'#mm'"></input>
	<div id="mm" style="width:120px">
    	<div data-options="name:'staffname'">员工名称</div>
	</div>
	
	<a href="javascript:void(0)" onclick="editUserRole()" class="easyui-linkbutton" style="float:right " iconCls="icon-more"  >分配用户角色</a>
	
	
	
	</div>
	
</body>





</html>