<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../../public/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>Basic Tree - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
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

</script>

</head>
<body>
	<div class="easyui-panel" style="width: 100%;" title="${systemMenuBean.systemGuiMenu.menuTitle}">
		<table style="width: 100%; font-size:12px;color:'#333'">
			<tr>
				<td  style="width: 15%;" align="right">部门编码：</td>
				<td style="width: 35%;" align="left">${systemMenuBean.systemGuiMenu.menuId}</td>
				
			</tr>

			<tr>
				<td align="right">部门名称：</td>
				<td align="left">${systemMenuBean.systemGuiMenu.menuText}</td>
				
			</tr>
			<tr>
				<td align="right">上级部门：</td>
				<td align="left">${systemMenuBean.systemGuiMenu.subsysCode}</td>
				
			</tr>
			<tr>
				<td align="right">主页图片：</td>
				<td align="left">${systemMenuBean.systemGuiMenu.showOrder}</td>
				
			</tr>
			
		</table>
		<form id="removeMenu"
			action="removeMenuInfo.jhtml?menuId=${systemMenuBean.systemGuiMenu.menuId}"
			method="post">
			<div align="center"
				style="padding: 4px; background: #fafafa; width: 99%; border: 0px solid #ccc">
				
				<a		href="javascript:void(0)"
					class="easyui-linkbutton"  onclick="addSubMenu()" iconCls="icon-add">新增子菜单</a>
				<a	href="javascript:void(0)" class="easyui-linkbutton"  onclick="updateMenu()"  iconCls="icon-edit">修改菜单</a>
				<a href="javascript:void(0)" onclick="removeMenu()"
					class="easyui-linkbutton" iconCls="icon-cancel">删除菜单</a>
			</div>
		</form>



	</div>

</body>
</html>