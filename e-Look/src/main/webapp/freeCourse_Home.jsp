<%@page import="com.e_Look.search.SearchDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Short Icon" type="image/x-icon" href="${initParam.icon}" />
<title>${initParam.systemName}</title>
<!-- <link href="HeaderCssJs/bootstrap.css" rel="stylesheet"> -->
<link href="css/bootstrap.css" rel="stylesheet">
<!-- <link href="HeaderCssJs/bootstrap.min.css" rel="stylesheet"> -->
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="css/modern-business.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<!-- 載入課程模板css -->
<!-- <link href="css/twmplate.css" rel="stylesheet" no> -->
<!-- <script src="HeaderCssJs/jquery.js"></script> -->
<script src="js/jquery.js"></script>
<!-- <script src="HeaderCssJs/bootstrap.min.js"></script> -->
<script src="js/bootstrap.min.js"></script>

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
	height:200px; 
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
/* 分類icon */
.formDiv{
	width:78%;
	height:12%;
	margin-bottom:1%;
	margin-left:auto;
	margin-right:auto;
}
.pstyle{
 	text-align:center;
	font-size: 20px;
  	font-family:微軟正黑體;
  	cursor: pointer;
  	color:#9F35FF;
}
.iconWidth{
	width:50px;
}
.svgIcon{
	width:50px;
	cursor:pointer;
}

.formicon a:hover{
	text-decoration: none;
	color:#9F35FF;
}
.formicon div:hover{
    top: 2px;
    left: 2px;
}
.formicon div:ACTIVE{
    top: 4px;
    left: 4px;
}

/* 熱門關鍵字 */
.outBorder{
/* 	margin-left:5%; */
	width:220px;
	height:40px;
	border:3px solid orange;
	border-radius:25px;
}
.middleborder{
	padding-left:14px;
	padding-top:3px;
	padding-bottom:3px;
}
.inputarea{
	border:none !important;
	width:160px !important;
}
.searchImg{
	float:right;
}
.searchImg div:hover{
/* 	top: 2px !important; */
/* 	left: 2px !important; */
}

.searchicon{
	width:30px;
	cursor: pointer;
}

.hotkeyword{
	width:220px;
 	margin-left:30px;
	padding-top:5px;"
}
.keyword{
 	clear:both;
	color:blue;
	width:190px;
}
.cclass div:hover{
	top: 2px;
	left: 2px;
}
.cclass div:ACTIVE{
	top: 4px;
	left: 4px;
}
.searchKey{
 	margin-left:20%;
	
}
.gray1{
-webkit-filter:grayscale(1);
}
 #body{background-color: #FAEBD7;}
</style>
<script type="text/javascript">
/*
//為文件的滑鼠按下事件定義回呼
document.onmousedown = function(event) {
	//滑鼠事件：0 > 沒按鍵, 1 > 按左鍵, 2 > 按右鍵, 3 > 按左鍵&右鍵
	//4 > 按中間鍵, 5 > 按左鍵&中間鍵, 6 > 按右鍵&中間鍵, 7 > 按所有鍵
	if (event.button == 2) {
		//提示使用者禁用滑鼠右鍵
		alert("禁用滑鼠右鍵!");
	}
}
*/
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

	/*瀑布流關鍵*/
var rowValueX = 0;
var keyWord="";
var courseClass="";
var lastClickClass;
var lastRow = true;
	//初載入 事件繫結
$(function() {
	loadKeyword();
	river();
	$('.keyword').on('click','.keywordlink',clickKeyword)
	$('#submit').click(newsubmit);
	$(window).scroll(river);
	$('.text-center').click(clickClass);
	$('#searchicon').click(clickSearch);
});
function clickKeyword(){
	keyWord1=$(this).text();
	keyWord=keyWord1.trim();
	refreshRiver();	
	loadKeyword();
}
function newsubmit(e){
	e.preventDefault();
	clickSearch();
}
	
function clickClass(){
	if(lastClickClass==$(this).children('p').attr('alt')){
		courseClass= "" ;
		$('.text-center').children('img').removeClass('gray1');
		lastClickClass="";		
	}else{
		courseClass=$(this).children('p').attr('alt');
		$('.text-center').children('img').addClass('gray1');
		$(this).children('img').removeClass('gray1');
		lastClickClass=$(this).children('p').attr('alt');
	}
	keyWord="";
	refreshRiver();
}
	
function loadKeyword(){
	$('.keyword').text('');
	$.get('<%=request.getContextPath() %>/SearchController.do',{'keyWord':keyWord},function(datas){
		var fg = $(document.createDocumentFragment());
		$.each(datas,function(index,value){
			if(index<3){
				var cell1 = $('<span>').addClass('keywordlink').text(value+' ')
				fg.append(cell1);					
			}
		})
		$('.keyword').append(fg);
	},'json');
}
	
function clickSearch(){
	keyWord1=$('#keyWord').val();
	keyWord=keyWord1.trim();
	loadKeyword();
	refreshRiver();		
}
function refreshRiver(){
	rowValueX=0;
	$('#river').html("");
	river();
	$('#keyWord').val("");
}
function river(){
	//卷軸初再入高度為0
	var	wst = $(window).scrollTop();
	//視窗高度
	var	wh = $(window).height();
	//整份文件
	var	dh =$(document).height();
	//console.log("捲軸高度:"+wst+" 視窗高度:"+wh+" 文件高度:"+dh+" 文件高度-視窗高度:"+(dh-wh));
	//判斷卷軸是否到底部
	//有時候卷軸會多0.5  改>=的寫法可以解決這個問題
	if( (wst+300>=(dh-wh) || rowValueX<=4) && lastRow ){
		lastRow=false;
		console.log(courseClass+"river()"+keyWord);
		$.get("<%= request.getContextPath() %>/body/free_data.jsp",{"rowValueY":rowValueX,"keyWord":keyWord,"courseClass":courseClass},function(data){
			$('#river').append(data)
			rowValueX+=4;
			lastRow=true;
			if(rowValueX<=4){
				river();
			}
		});
		
	}
}
</script>
</head>


<body style="margin-top:10px;" id="body" >


<jsp:include page="${contextPath}/login.jsp" />


<!-- form按鈕圖式star -->
<div class="formDiv container" >
	<div class="row">
	<div class="col-md-8 col-sm-10 col-xs-12 cclass">

		<div class="col-md-1 col-sm-2 col-xs-3 text-center">
			<img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/life.svg"><p alt="101" class="pstyle">生活</p>
		</div>
		<div class="col-md-1 col-sm-2 col-xs-3 text-center">
				<img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/arts.svg"><p alt="102" class="pstyle">藝術</p>
		</div>
		<div class="col-md-1 col-sm-2 col-xs-3 text-center">
			<img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/athletics.svg"><p alt="103" class="pstyle">運動</p>
		</div>
		<div class="col-md-1 col-sm-2 col-xs-3 text-center">
			<img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/video.svg"><p alt="104" class="pstyle">影音</p>
		</div>
		<div class="col-md-1 col-sm-2 col-xs-3 text-center">
			<img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/hand-made.svg"><p alt="105" class="pstyle">手作</p>
		</div>
		<div class="col-md-1 col-sm-2 col-xs-3 text-center">
			<img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/other.svg"><p alt="106" class="pstyle">其他</p>
		</div>
		<div class="col-md-1 col-sm-2 col-xs-3 text-center">
				<img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/design.svg"><p alt="107" class="pstyle">設計</p>
		</div>
		<div class="col-md-1 col-sm-2 col-xs-3 text-center">
				<img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/science.svg"><p alt="108" class="pstyle">科技</p>
		</div>
		<div class="col-md-1 col-sm-2 col-xs-3 text-center">
				<img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/business.svg"><p alt="109" class="pstyle">商業</p>
		</div>
		<div class="col-md-1 col-sm-2 col-xs-3 text-center">
				<img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/language.svg"><p alt="110" class="pstyle">語言</p>
		</div>
		<div class="col-md-1 col-sm-2 col-xs-3 text-center">
				<img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/cooking.svg"><p alt="111" class="pstyle">烹飪</p>
		</div>
		<div class="col-md-1 col-sm-2 col-xs-3 text-center">
				<img class="svgIcon" src="<%=request.getContextPath() %>/alan/img/program.svg"><p alt="112" class="pstyle">程式</p>
		</div>
	

	</div><!-- /col-md-10 -->
	<div class="col-md-2 col-sm-0 col-xs-0"></div>
	<div class="col-md-2 col-sm-2 col-xs-6">
	<form class="navbar-form navbar-left" id="searchKey" method="get" action="">
	
		<div class="input-group outBorder" style="">

			<div class="middleborder" style="">
			
				<input id="keyWord" name="keyWord" type="text" class="form-control inputarea" placeholder="Search" style="">
				
				<div class="input-group-btn searchImg" style="">
<%-- 				<input id="searchsubmit" class="searchicon" style="" type="image" src="<%=request.getContextPath()%>/alan/img/search.svg" /> --%>
				<div id="searchicon" style=""><img style="" class="searchicon" src="<%=request.getContextPath()%>/alan/img/search.svg" ></div>
				<input type="submit" id="submit" style="display:none" />
				</div>
			</div>
			
		</div>
	</form>
	<div class="col-md-12 col-sm-12 col-xs-12">
	<p class="hotkeyword text-left">熱門：
		<span class="keyword">

		</span>
	</p>
	</div>
	</div><!-- /col-md-2 -->
	<!-- 黑分隔線 -->
	<div class="col-md-12 col-sm-12 col-xs-12" style="border:1px solid black;margin-bottom:20px"></div>
	</div>
</div><!-- /width:78% -->

<!-- 3秒消失廣告star -->
<div style="text-align:center">
	<a href=""><span id="ads"></span></a>
</div>
<!-- 3秒消失廣告end -->

<div class="videobox container" style="">
	<div class="row" id="river" style="margin-left:40px;">
	
	</div>
</div>
<c:remove var="err" scope="session"/>
<c:remove var="loginerr" scope="session"/>
<jsp:include page="${contextPath}/footer.jsp" />
</body>
</html>