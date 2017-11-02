<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Short Icon" type="image/x-icon" href="${initParam.icon}" />
<title>${initParam.systemName}</title>
<link href="<%= request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap Core CSS -->
<!-- Custom CSS -->
<link href="<%= request.getContextPath() %>/css/modern-business.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="<%= request.getContextPath() %>/body/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<!-- 載入課程模板css -->
<!-- <link href="css/twmplate.css" rel="stylesheet"> -->
<script src="<%= request.getContextPath() %>/js/jquery.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>

<style type="text/css">
/* 課程模板 */
h5 {
	font-size: 1.28571429em;
	font-weight: 700;
	line-height: 1.2857em;
	margin: 0;
}

.card {
	font-size: 1em;
	overflow: hidden;
	padding: 0;
	border: none;
	border-radius: .28571429rem;
	box-shadow: 0 1px 3px 0 #d4d4d5, 0 0 0 1px #d4d4d5;
}

.card-block {
	font-size: 1em;
	position: relative;
	margin: 0;
	padding: 1em;
	border: none;
	border-top: 1px solid rgba(34, 36, 38, .1);
	box-shadow: none;
}

.card-img-top {
	display: block;
	width: 340px;
/* 	height:200px; */
	margin-top: 4px;
	margin-bottom: 4px;
}

.card-title {
	font-size: 1.28571429em;
	font-weight: 700;
	line-height: 1.2857em;
}

.card-text {
	clear: both;
	margin-top: .5em;
	height: 70px;
}

.card-footer {
	font-size: 15px;
	position: static;
	top: 0;
	left: 0;
	max-width: 100%;
	padding: .75em 1em;
	color: gray;
	border-top: 1px solid rgba(0, 0, 0, .05) !important;
	background: #fff;
}

.card-inverse .btn {
	border: 1px solid rgba(0, 0, 0, .05);
}

.profile {
	position: absolute;
	top: -30px;
	display: inline-block;
	overflow: hidden;
	box-sizing: border-box;
	width: 50px;
	height: 50px;
	margin: 0;
	border: 1px solid #fff;
	border-radius: 50%;
}

.profile-avatar {
	display: block;
	width: 100%;
	height: auto;
	border-radius: 50%;
}

.profile-inline {
	position: relative;
	top: 0;
	display: inline-block;
}

.profile-inline ~ .card-title {
	display: inline-block;
	margin-left: 4px;
	vertical-align: top;
}

.text-bold {
	font-weight: 700;
}

.meta {
	font-size: 2em;
}

.meta a {
	text-decoration: none;
	color: rgba(0, 0, 0, .4);
}

.meta a:hover {
	color: rgba(0, 0, 0, .87);
}

.multi_ellipsis {
	overflow: hidden;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 2;
	line-height: 30px;
	height: 60px;
	font-size: 30px;
}

/* 分類按鈕 */
.ndiv {
	height: 100px;
	width: 1100px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	border-bottom: 1.5px solid black;
	margin-bottom:20px;
}

.ndiv li {
	list-style-type: none;
	float: left;
	margin: 8px;
}

.svgIcon {
	width: 48px;
}

.ndiv a {
	text-decoration: none;
	visited: none;
	active: none;
	font-size: 20px;
	font-family: 微軟正黑體;
}

.ndiv a:link {
	color: #9F35FF;
}

.ndiv a:visited {
	color: #9F35FF;
}
.li_searchArea{
/* 	margin-left:80px; */
/* 	margin-top:25px; */
}
.outsideBorder{
	border:3px solid orange;
	border-radius:25px;
	height: 44px;
	width:260px;
}
.betweenOutAndInner{
	padding-left:10px;
	padding-top:2px;
	padding-bottom:2px;
}
.searchInput{
	padding-left:25px;
	border:none;
	border-radius:25px;
	height:28px;
}
.searchSubmitIcon{
	width:30px;
	padding-right:2px;
}
/* 分類下課程 */
.row{
	width: 1100px;
	margin-left:200px;
}

</style>
<script type="text/javascript">
	//為文件的滑鼠按下事件定義回呼
	document.onmousedown = function(event) {
		//滑鼠事件：0 > 沒按鍵, 1 > 按左鍵, 2 > 按右鍵, 3 > 按左鍵&右鍵
		//4 > 按中間鍵, 5 > 按左鍵&中間鍵, 6 > 按右鍵&中間鍵, 7 > 按所有鍵
		if (event.button == 2) {
			//提示使用者禁用滑鼠右鍵
			alert("禁用滑鼠右鍵!");
		}
	}

	/*展示廣告圖片*/
	function showAdPic() {
		//獲得廣告的DOM
		var ads = document.getElementById("ads");
		//直接在DOM中增加HTML原始程式來增加一個圖片的DOM
		ads.innerHTML = "<img src='img/xmas video sale.jpg' width='650' />";
		//設定計時器,3秒以後關閉廣告圖片
		setTimeout(function() {
			var ads = document.getElementById("ads");
			//隱藏圖片
			ads.style.display = "none";
		}, 1500)
	}
	//window.onload = showAdPic;

		var rowValue = 0;
	$(function() {
		//showAdPic();
		//init();
		river();
		var	wst = $(window).scrollTop();
		var	wh = $(window).height();
		var	dh =$(document).height();
		console.log(wst+"---"+dh+"---"+wh);
		$(window).scroll(river);
			
		});
	function river(){
		var	wst = $(window).scrollTop();
		var	wh = $(window).height();
		var	dh =$(document).height();
		$('a[href="#menu1"]').text(wst+"---"+dh+"---"+wh)
		console.log(wst+"---"+dh+"---"+wh);
		//判斷卷軸是否到底部
		if(wst==(dh-wh) || dh==wd){
			rowValue++;
			$.get("coursedata.jsp",{"rowValue":rowValue},function(data){
				$('#river').append(data);
			});
		}
	}
	

	/*延遲載入圖片*/
	//初始化函數
	function init() {
		//開始計時器
		//setTimeout("checkHeight()", 1000);
	}
	//計時器函數
	function checkHeight() {
		//圖片的DOM
		var rows = document.querySelectorAll(".row");
		//console.log(pics)
		//var pic = document.getElementById("pic");
		//取得捲軸的位置
		var sTop = document.documentElement.scrollTop;
		console.log(sTop);
		//取得可見區域高度
		var cHeight = document.documentElement.clientHeight;

		for (i = 1; i < rows.length; i++) {
			//圖片距離最左上角的top值
			var top = rows[i].offsetTop;
			//如果捲軸還未來到可見區域
			if (sTop + cHeight < top) {
				//計時器繼續工作
				//setTimeout("checkHeight()", 1500);
			} else {

				var pics = rows[i].querySelectorAll("img");
				for (var j = 0; j < pics.length; j++) {
					pics[j].src = pics[j].getAttribute("src");
				}
				//把延遲的值指定給src
				//pics[i].src = pics[i].getAttribute("src");
				//console.log(top);
			}
		}

	}
</script>
</head>
<body>
	<jsp:include page="${contextPath}/login.jsp" />

		<!-- 分類按鈕和搜索star -->
	<div class="ndiv">
		<ul>
			<li><a href="?courseClassID=1"><img
					style="<c:choose><c:when test='${param.courseClassID == 1 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/life.svg"><br>生活</a></li>
			<li><a href="?courseClassID=2"><img
					style="<c:choose><c:when test='${param.courseClassID == 2 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/arts.svg"><br>藝術</a></li>
			<li><a href="?courseClassID=3"><img
					style="<c:choose><c:when test='${param.courseClassID == 3 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/athletics.svg"><br>運動</a></li>
			<li><a href="?courseClassID=4"><img
					style="<c:choose><c:when test='${param.courseClassID == 4 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/hand-made.svg"><br>手作</a></li>
			<li><a href="?courseClassID=5"><img
					style="<c:choose><c:when test='${param.courseClassID == 5 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/other.svg"><br>其他</a></li>
			<li><a href="?courseClassID=6"><img
					style="<c:choose><c:when test='${param.courseClassID == 6 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/design.svg"><br>設計</a></li>
			<li><a href="?courseClassID=7"><img
					style="<c:choose><c:when test='${param.courseClassID == 7 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/science.svg"><br>科技</a></li>
			<li><a href="?courseClassID=8"><img
					style="<c:choose><c:when test='${param.courseClassID == 8 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/business.svg"><br>商業</a></li>
			<li><a href="?courseClassID=9"><img
					style="<c:choose><c:when test='${param.courseClassID == 9 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/language.svg"><br>語言</a></li>
			<li><a href="?courseClassID=10"><img
					style="<c:choose><c:when test='${param.courseClassID == 10 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/cooking.svg"><br>烹飪</a></li>
			<li><a href="?courseClassID=11"><img
					style="<c:choose><c:when test='${param.courseClassID == 11 || empty param.courseClassID}'>-webkit-filter: grayscale(0)</c:when><c:otherwise>-webkit-filter: grayscale(1)</c:otherwise></c:choose>"
					class="svgIcon"
					src="<%=request.getContextPath() %>/alan/img/program.svg"><br>程式</a></li>
			<li class="li_searchArea" style="margin-left:56px;margin-top:15px;" >
				<form class="navbar-form navbar-left" id="searchKey" method="get"
					action="">
					<div class="input-group">
						<div class="outsideBorder">
							<div class="betweenOutAndInner">

								<input type="text" class="form-control" placeholder="Search"
									name="keyWord" class="searchInput">

								<div style="float:right" class="input-group-btn">
									<input type="image" id="search-submit" name="search-submit" img
										src="<%=request.getContextPath()%>/alan/img/search.svg"
										onclick="document.Search.submit()"
										class="searchSubmitIcon"/>
								</div>
							</div>
						</div>
					</div>
				</form>
			</li>
		</ul>

	</div>
	<!-- 分類按鈕和搜索end -->

	<!-- 3秒消失廣告star -->
	<div style="text-align:center">
		<a href=""><span id="ads"></span></a>
	</div>
	<!-- 3秒消失廣告end -->
	
	<div style="width:1000px;margin-left:206px">
	<div id="river" class="container">
	
	</div>
	</div>

</body>
</html>