<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../../../../public/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<link href="${ctx}/resources/portal/mobile/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="${ctx}/resources/portal/mobile/css/style.css"
	rel="stylesheet" type="text/css">
<link href="${ctx}/resources/portal/mobile/css/extends-style.css"
	rel="stylesheet" />
<link href="${ctx}/resources/portal/mobile/PhotoSwipe/photoswipe.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${ctx}/resources/portal/mobile/PhotoSwipe/default-skin/default-skin.css">

<script src="${ctx}/resources/portal/mobile/PhotoSwipe/photoswipe.js"></script>
<script
	src="${ctx}/resources/portal/mobile/PhotoSwipe/photoswipe-ui-default.js"></script>
<link href="${ctx}/resources/portal/mobile/swiper/swiper.min.css"
	rel="stylesheet" />
<script src="${ctx}/resources/portal/mobile/swiper/swiper.min.js"></script>
<title>科尓沁左翼后期三务公开-首页</title>
<style>
body {
	background: url(${ctx}/resources/portal/mobile/images/bg.jpg) #f5f5f5
		no-repeat top;
	background-size: 100%;
}


</style>
</head>
<body>
	<%@include file="../head/head.jsp"%>
	<!-- 图片轮播效果 -->
	<div id="wrapper">
		<!-- 左边 -->

		<div id="slider-wrap" style="height: 320px;">
			<!--  -->
			<div
				class="swiper-container swiper-container-horizontal swiper-container-android">
				<div class="swiper-wrapper"
					style="transition-duration: 0ms; transform: translate3d(-2760px, 0px, 0px);">
					<c:forEach items="${hotNews}" var="newsItem">
					<div class="swiper-slide" style="width: 100%;">
					  <li data-color="#1abc9c" style="height:270px;">
							
							 <i class="fa fa-image"  > <a
								href="news/detail.jhtml?id=${newsItem.id}&departId=${depart.id}"><img
									src="${ctx}${newsItem.thumb}" width="100%" height="100%"></a>
						</i>
						<div style="width: 100%;text-align: center;text-overflow: ellipsis;white-space: nowrap;overflow: hidden;margin-top: 12px;">
								<span><a
									href="news/detail.jhtml?id=${newsItem.id}&departId=${depart.id}">${newsItem.title}</a></span>
							</div>
						</li>
					</div>
					</c:forEach>
					
				</div>
				<span class="swiper-notification" aria-live="assertive"
					aria-atomic="true"></span>
			</div>
			<!--  -->

		</div>
		<script>
			var swiper = new Swiper('.swiper-container');
		</script>


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
					<li><a href="projectGroup.jhtml"> <i><img
								src="${ctx}/resources/portal/images/02ico.png" /></i><b>民生项目：共<span
								style="color: red;">${projectCount}</span>项
						</b>
					</a></li>
					<li><a href="projectFundsGroup.jhtml"> <i><img
								src="${ctx}/resources/portal/images/02iddd.png" /></i><b>民生资金：共<span
								style="color: red;"> <c:if test="${projectSum!=null}">
										<fmt:formatNumber value="${projectSum}" type="CURRENCY">
										</fmt:formatNumber>
									</c:if> <c:if test="${projectSum==null}">
								 0
								</c:if>

							</span>万元
						</b>
					</a></li>
					<li><a href="fundsGroup.jhtml"> <i><img
								src="${ctx}/resources/portal/images/02iccc.png" /></i><b>到户资金：共<span
								style="color: red;"> <c:if test="${fundsSum!=null}">
										<fmt:formatNumber pattern="###,###.####" value="${fundsSum}"
											type="CURRENCY">
										</fmt:formatNumber>
									</c:if> <c:if test="${fundsSum==null}">
								0
								</c:if>

							</span>万元
						</b>
					</a></li>
				</ul>
			</div>
		</div>
		<!-- 图片轮播效果结束 -->
	</div>
	<script src="${ctx}/resources/portal/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/resources/portal/mobile/js/slide.js"></script>
	<!-- 内容栏目 -->
	<div class="center">
		<div class="newslist">
			<h2>
				<a href="news/list.jhtml?catId=${dwgk.category.id}&">${dwgk.category.name}</a>
			</h2>
			<ul>
				<c:forEach items="${dwgk.news}" var="newItem">
					<li><a href="news/detail.jhtml?id=${newItem.id}">${newItem.title}</a><span>
							<fmt:formatDate value="${newItem.inputtime}" pattern="yyyy-MM-dd" />
					</span></li>
				</c:forEach>

			</ul>
			<c:if test="${not empty  dwgk.news}">
				<div class="more">
					<a href="news/list.jhtml?catId=${dwgk.category.id}" title=""
						target="_self">更多</a>
				</div>
			</c:if>
		</div>
		<div class="newslist">
			<h2>
				<a href="news/list.jhtml?catId=${zwgk.category.id}&">${zwgk.category.name}</a>
			</h2>
			<ul>
				<c:forEach items="${zwgk.news}" var="newItem">
					<li><a href="news/detail.jhtml?id=${newItem.id}">${newItem.title}</a><span>
							<fmt:formatDate value="${newItem.inputtime}" pattern="yyyy-MM-dd" />
					</span></li>
				</c:forEach>

			</ul>
			<c:if test="${not empty  zwgk.news}">
				<div class="more">
					<a href="news/list.jhtml?catId=${zwgk.category.id}" title=""
						target="_self">更多</a>
				</div>
			</c:if>
		</div>
		<div class="newslist">
			<h2>
				<a href="news/list.jhtml?catId=${gzdt.category.id}&">${gzdt.category.name}</a>
			</h2>
			<ul>
				<c:forEach items="${gzdt.news}" var="newItem">
					<li><a href="news/detail.jhtml?id=${newItem.id}">${newItem.title}</a><span>
							<fmt:formatDate value="${newItem.inputtime}" pattern="yyyy-MM-dd" />
					</span></li>
				</c:forEach>

			</ul>
			<c:if test="${not empty  gzdt.news}">
				<div class="more">
					<a href="news/list.jhtml?catId=${gzdt.category.id}" title=""
						target="_self">更多</a>
				</div>
			</c:if>
		</div>
	</div>
	<div class="center">
		<div class="newslist">
			<h2>
				<a href="news/list.jhtml?catId=${zcwj.category.id}&">${zcwj.category.name}</a>
			</h2>
			<ul>
				<c:forEach items="${zcwj.news}" var="newItem">
					<li><a href="news/detail.jhtml?id=${newItem.id}">${newItem.title}</a><span>
							<fmt:formatDate value="${newItem.inputtime}" pattern="yyyy-MM-dd" />
					</span></li>
				</c:forEach>

			</ul>
			<c:if test="${not empty  zcwj.news}">
				<div class="more">
					<a href="news/list.jhtml?catId=${zcwj.category.id}" title=""
						target="_self">更多</a>
				</div>
			</c:if>
		</div>
		<div class="newslist">
			<h2>
				<a href="news/list.jhtml?catId=${jdjl.category.id}&">${jdjl.category.name}</a>
			</h2>
			<ul>
				<c:forEach items="${jdjl.news}" var="newItem">
					<li><a href="news/detail.jhtml?id=${newItem.id}">${newItem.title}</a><span>
							<fmt:formatDate value="${newItem.inputtime}" pattern="yyyy-MM-dd" />
					</span></li>
				</c:forEach>

			</ul>
			<c:if test="${not empty  jdjl.news}">
				<div class="more">
					<a href="news/list.jhtml?catId=${jdjl.category.id}" title=""
						target="_self">更多</a>
				</div>
			</c:if>
		</div>
		<div class="newslist">
			<h2>
				<a href="news/list.jhtml?catId=${gsgg.category.id}&">${gsgg.category.name}</a>
			</h2>
			<ul>
				<c:forEach items="${gsgg.news}" var="newItem">
					<li><a href="news/detail.jhtml?id=${newItem.id}">${newItem.title}</a><span>
							<fmt:formatDate value="${newItem.inputtime}" pattern="yyyy-MM-dd" />
					</span></li>
				</c:forEach>

			</ul>
			<c:if test="${not empty  gsgg.news}">
				<div class="more">
					<a href="news/list.jhtml?catId=${gsgg.category.id}" title=""
						target="_self">更多</a>
				</div>
			</c:if>
		</div>
	</div>
	<div class="center">
		<div class="newslist" style="min-height: 460px;">
			<h2>
				<a href="pagingDwgkStatistic.jhtml">党务信息排名</a>
			</h2>
			<ul>
				<c:forEach items="${dwgkStatistic}" var="statistic" varStatus="st">
					<li><span style="float: left; width: 5%;">${st.index+1}</span>
						<a href="${ctx}/portal/main.jhtml?departId=${statistic.id}"
						style="float: left; background: unset; width: 85%;">${statistic.name}&nbsp;[${statistic.num}
							]"</a></li>
				</c:forEach>
			</ul>
			<c:if test="${not empty  dwgkStatistic}">
				<div class="more">
					<a href="pagingDwgkStatistic.jhtml" title="" target="_self">更多</a>
				</div>
			</c:if>

		</div>
		<div class="newslist" style="min-height: 460px;">
			<h2>
				<a href="pagingZwgkStatistic.jhtml">政务信息排名</a>
			</h2>
			<ul>
				<c:forEach items="${zwgkStatistic}" var="statistic" varStatus="st">
					<li><span style="float: left; width: 5%;">${st.index+1}</span><a
						href="${ctx}/portal/main.jhtml?departId=${statistic.id}"
						style="float: left; background: unset; width: 85%;">${statistic.name}
							&nbsp;[${statistic.num} ]</a></li>
				</c:forEach>

			</ul>

			<c:if test="${not empty  zwgkStatistic}">
				<div class="more">
					<a href="pagingZwgkStatistic.jhtml" title="" target="_self">更多</a>
				</div>
			</c:if>

		</div>
		<div class="newslist" style="min-height: 460px;">
			<h2>
				<a href="pagingCunwgkStatistic.jhtml">村务排名</a><a
					href="pagingCunwgkStatistic.jhtml">财务排名</a>
			</h2>
			<ul>
				<c:forEach items="${cunwgkStatistic}" var="statistic" varStatus="st">
					<li><span style="float: left; width: 5%;">${st.index+1}</span><a
						href="${ctx}/portal/main.jhtml?departId=${statistic.id}"
						style="float: left; background: unset; width: 85%;">${statistic.name}
							&nbsp;[${statistic.num} ]</a></li>
				</c:forEach>
			</ul>
			<c:if test="${not empty  cunwgkStatistic}">
				<div class="more">
					<a href="pagingCunwgkStatistic.jhtml" title="" target="_self">更多</a>
				</div>
			</c:if>

		</div>
	</div>
	<%@include file="../footer/footer.jsp"%>
</body>
</html>