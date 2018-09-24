<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../../../public/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<link rel="icon" type="image/png" sizes="16x16"
	href="/ui2017/logo-16.png" />
<link rel="icon" type="image/png" sizes="32x32"
	href="/ui2017/logo-32.png" />
<link rel="icon" type="image/png" sizes="48x48"
	href="/ui2017/logo-48.png" />
<link href="${ctx}/resources/portal/css/style.css" rel="stylesheet" />


<title>科尓沁左翼后期三务公开-首页</title>
<style>
body {
	background: url(${ctx}/resources/portal/images/bg.jpg) #f5f5f5 no-repeat
		top;
	background-size: 100%;
}
</style>
</head>
<body>

	<%@include file="../head/head-hamlet.jsp"%>

	<!-- 图片轮播效果 -->
	<div id="wrapper">
		<!-- 左边 -->

		<div id="slider-wrap">
			<ul id="slider">
				<c:if test="${empty hotNews}">

					<li data-color="#1abc9c">
						<div>
							<span><a href="#"></a></span>
						</div> <i class="fa fa-image"> <img
							src="${ctx}/resources/portal/images/fy.jpg" width="100%"
							height="100%">
					</i>
					</li>


				</c:if>
				<c:if test="${not empty hotNews}">
					<c:forEach items="${hotNews}" var="newsItem">
						<li data-color="#1abc9c">
							<div>
								<span><a href="news/detail.jhtml?id=${newsItem.id}&departId=${depart.id}">${newsItem.title}</a></span>
							</div> <i class="fa fa-image"> <img src="${ctx}/${newsItem.thumb}"
								width="100%" height="100%">
						</i>
						</li>
					</c:forEach>
				</c:if>
			</ul>

			<div class="btns" id="next">
				<i class="fa fa-arrow-right"></i>
			</div>
			<div class="btns" id="previous">
				<i class="fa fa-arrow-left"></i>
			</div>
			<div id="counter"></div>
			<div id="pagination-wrap">
				<ul>
				</ul>
			</div>

		</div>


		<!-- 右侧新闻 -->
		<div class="rightnews">
			<div class="met-index-imgnews">
				<ul class="right-news news-ul">
					<a href="#">
						<h3>
							<i><img src="${ctx}/resources/portal/images/02home.png" /></i><b>民生资金</b>
						</h3>
					</a>
					<div class="right-img" style="padding-top: 0px;">
						<img style="width: 100%; height: 130px"
							src="${ctx}/resources/portal/images/peit.jpg" />
					</div>
					<li><a href="projectGroup.jhtml?departId=${depart.id}"> <i><img
								src="${ctx}/resources/portal/images/02ico.png" /></i><b>民生项目：共<span
								style="color: red;">${projectCount}</span>项
						</b>
					</a></li>
					<li><a href="projectFundsGroup.jhtml?departId=${depart.id}"> <i><img
								src="${ctx}/resources/portal/images/02iddd.png" /></i><b>民生资金：共<span
								style="color: red;"> <fmt:formatNumber
										value="${projectSum}" type="CURRENCY">
									</fmt:formatNumber>
							</span>亿元
						</b>
					</a></li>
					<li><a href="fundsGroup.jhtml?departId=${depart.id}"> <i><img
								src="${ctx}/resources/portal/images/02iccc.png" /></i><b>到户资金：共<span
								style="color: red;"> <fmt:formatNumber
										value="${fundsSum}" type="CURRENCY">
									</fmt:formatNumber>


							</span>亿元
						</b>
					</a></li>
				</ul>
			</div>
		</div>
		<!-- 图片轮播效果结束 -->
	</div>
	<script src="${ctx}/resources/portal/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/resources/portal/js/slide.js"></script>
	<!-- 内容栏目 -->
	<div class="center">
		<div class="newslist">
			<h2>
				<a href="news/list.jhtml?catId=${dwgk.category.id}&departId=${depart.id}">${dwgk.category.name}</a>
			</h2>
			<ul>
				<c:forEach items="${dwgk.news}" var="newItem">
					<li><a href="news/detail.jhtml?id=${newItem.id}&departId=${depart.id}">${newItem.title}</a><span>
							<fmt:formatDate value="${newItem.inputtime}" pattern="yyyy-MM-dd" />
					</span></li>
				</c:forEach>

			</ul>
		</div>
		<div class="newslist">
			<h2>
				<a href="news/list.jhtml?catId=${cunwgk.category.id}&departId=${depart.id}">${cunwgk.category.name}</a>
			</h2>
			<ul>
				<c:forEach items="${cunwgk.news}" var="newItem">
					<li><a href="news/detail.jhtml?id=${newItem.id}&departId=${depart.id}">${newItem.title}</a><span>
							<fmt:formatDate value="${newItem.inputtime}" pattern="yyyy-MM-dd" />
					</span></li>
				</c:forEach>

			</ul>
		</div>
		<div class="newslist">
			<h2>
				<a href="news/list.jhtml?catId=${caiwgk.category.id}&departId=${depart.id}">${caiwgk.category.name}</a>
			</h2>
			<ul>
				<c:forEach items="${caiwgk.news}" var="newItem">
					<li><a href="news/detail.jhtml?id=${newItem.id}&departId=${depart.id}">${newItem.title}</a><span>
							<fmt:formatDate value="${newItem.inputtime}" pattern="yyyy-MM-dd" />
					</span></li>
				</c:forEach>

			</ul>
		</div>
	</div>


	<!-- 底部版权信息 -->
	<%@include file="../footer/footer.jsp"%>
</body>
</html>