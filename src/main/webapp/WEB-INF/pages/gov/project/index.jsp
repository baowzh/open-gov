<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../../public/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyUI/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyUI/themes/icon.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/easyUI/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/easyUI/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/dateFormatter.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/gov/project/index.js"></script>
</head>
<body>
	<div style="margin: 20px 0;"></div>
	<table id="dg">

	</table>

	<div id="tb" style="height: auto">

		<input id="ss" class="easyui-searchbox" style="width: 300px"
			data-options="searcher:doSearch, prompt:'请输入需要查找关键字',menu:'#mm'"></input>
		<div id="mm" style="width: 120px">
			<div data-options="name:'rightCode'">项目名称</div>
			<div data-options="name:'rightName'">实施部门</div>
		</div>
		<a style="float:right;margin-right:20px;display:inline-block;height:30px;margin-top:10px;" href="add.jhtml">
		 导入
		</a>
		<a style="float:right;margin-right:20px;display:inline-block;height:30px;margin-top:10px;" href="add.jhtml">
		 添加
		</a>
		
	</div>
</body>
</html>