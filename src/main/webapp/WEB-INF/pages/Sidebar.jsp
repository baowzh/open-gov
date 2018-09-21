<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../public/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Sidebar</title>
<script language="JavaScript" src="${ctx}/resources/js/public.js"></script>
<link href="${ctx}/resources/style/public.css" rel="stylesheet"
	type="text/css" media="screen">
<link href="${ctx}/resources/js/portal/style/frame_bss.css"
	rel="stylesheet" type="text/css" />
<script language="JavaScript"
	src="${ctx}/resources/js/portal/nav/frame.js"></script>
<script language="JavaScript"
	src="${ctx}/resources/js/portal/bootstrap/jquery.min.js"></script>
<link rel="stylesheet" href="${ctx}/resources/js/portal/jquery.ui/themes/base/jquery.ui.all.css"/>
<link rel="stylesheet" href="${ctx}/resources/js/portal/jquery.treeview/jquery.treeview.css"/>
<link rel="stylesheet" href="${ctx}/resources/js/portal/jquery.ui/themes/ailkext/ailk.ui.accordion.css"/>
<style>
	a.menu_link:hover {font-weight:bold;color:#d53830;}
</style>
<script language="JavaScript" src="${ctx}/resources/js/portal/jquery.cookie.js"></script>
<script language="JavaScript" src="${ctx}/resources/js/portal/jquery.ui/jquery.ui.core.min.js"></script>
<script language="JavaScript" src="${ctx}/resources/js/portal/jquery.ui/jquery.ui.widget.min.js"></script>
<script language="JavaScript" src="${ctx}/resources/js/portal/jquery.ui/jquery.ui.accordion.min.js"></script>
<script language="JavaScript" src="${ctx}/resources/js/portal/jquery.treeview/jquery.treeview.js"></script>
<script>
	function openHomeNode(homeNode) {
		var node = getElement(homeNode);
		if (node != null) {
			var menuframe = getFrame("contentframe").menuframe;
			if (menuframe != null && menuframe.HOLD_FIRST_PAGE != null) {
				menuframe.HOLD_FIRST_PAGE = true;
				//node.click();
			} else {
				//setTimeout("openHomeNode('" + homeNode + "')", 100);
			}
		}
	}

	delete(Object.prototype.toJSONString);//解决与wade框架JSON.js冲突
	
	function setTreeMenu(e){
		var $div = $(e).find('.treeDiv');
		//如果当前sidebar中的树形菜单与被点击需要初始化的导航分类一致时，不需要再初始化了。
		if($div.attr('flag') != $('#accordion').attr('flag')){
			$('#accordion').attr('flag',$div.attr('flag'));//记录导航分类的ID
			$("#accordion").accordion('destroy').html($div.html());
			$('.treeMenu').treeview({
				animated: true
			});
			$("#accordion").accordion({
				autoHeight:false,
				fillSpace: true,
				navigation: true
			});
		}
	}
	
	$(function(){
		$('a.text').on('click',function(){
			//左侧菜单栏响应动作队列操作：闭合左侧栏
			$(window.parent.document).find('#tipon').click();
		});
	});
	
	function openmenu(url,obj) {
		if(getFrame("contentframe").menuframe == null){
			url = "&url=" + url;
			var linkobj = getElementByTag(getElementBySrc(), "a");
			if (linkobj != null) {
				url = "&title=" + linkobj.innerHTML + url;
			}
			else{
				url = "&title=" + $j("#searchcontent").val() + url;
			}
			url = getSysAddr(url);
			getFrame("contentframe").location.href = '${ctx}/' + url;
		}else{
			addNavFrame("contentframe",url,$(obj).attr('title'));
		}
	}
	
	function openmenuNew(url) {
		if (!url) return false;
		if (url.lastIndexOf("&url=") != -1) {
			url = url.substr(url.lastIndexOf("&url=") + 5);
		}
		redirectToNavByUrl(url, "contentframe");
	}
</script>
</head>
<body >
<div id="accordion"></div>
<a id="homemenu" name="homemenu" jwcid="@wade:PageRedirect" value="欢迎" menuaddr="ognl:@com.linkage.component.util.Utility@getProperty('navmenu/home', '') + '&LOGIN_RANDOM_CODE=' + visit.getAttribute('LOGIN_RANDOM_CODE') + '&LOGIN_REMOTE_ADDR=' + visit.getAttribute('LOGIN_REMOTE_ADDR')+'&LOGIN_CHECK_CODE='+ visit.getAttribute('LOGIN_CHECK_CODE')+'&LOGIN_ROLE_ID='+ page.visit.loginRoleId " style="display:none" onclick="openmenu(getAttribute('menuaddr').replace(new RegExp('&amp;','gm'),'&'));"/>
<script>openHomeNode("homemenu");</script>
</body>
</html>