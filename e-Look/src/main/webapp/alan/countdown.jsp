<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sales Countdown</title>
<script src="<%=request.getContextPath()%>/HeaderCssJs/jquery.js"></script>
<style>
#left{
	margin-top:60px;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$(document).mousemove(function(e1) {
		//開始取得滑鼠在螢幕中座標函數
		getScreenCoordinates(e1);
		//開始倒數計時函數
		startCount();
	});
	$(document).mousemove(function(e2) {
		//開始取得滑鼠在視窗客戶區中座標函數
 		getClientCoordinates(e2);
	});
	$(document).mousemove(function(e3) {
		//開始取得滑鼠在視窗頁面中座標函數
 		getPageCoordinates(e3);
	});
});
//取得滑鼠在螢幕中座標
function getScreenCoordinates(e1) {
	x1 = e1.screenX;
	y1 = e1.screenY;
	$("#screen1").text("X:" + x1 + ", Y:" + y1)
}

function getClientCoordinates(e2) {
	x2 = e2.clientX;
	y2 = e2.clientY;
	$("#screen2").text("X:" + x2 + ", Y:" + y2)
}

function getPageCoordinates(e3) {
	x3 = e3.pageX;
	y3 = e3.pageY;
	$("#screen3").text("X:" + x3 + ", Y:" + y3)
}
// document.addEventListener("DOMContentLoaded", function () {
// 	startCount();
// });
	/*開始倒數計時函數*/
	function startCount() {
		//開始一個timer,間隔為1秒
		setInterval(function(){
			//目前的時間
			var now = new Date();
			//設定活動截止日期
			var xmas = new Date("December 26, 2017")
			//獲得距離活動截止時間戳記的毫秒數
			var time = xmas.getTime() - now.getTime();
			//連接字元
			var str = getTimeTxt(time);
			//修改left內容區域的內容
			document.getElementById("left").innerHTML = "距離聖誕特賣活動結束還剩：" + str;
		});
	}
	//獲得時間表示行事的函數
	function getTimeTxt(time) {
		//除去毫秒的尾數
		time /= 1000;
		//獲得天數
		var days = time / (24*60*60);
		//獲得小時數
		var hour = time % (24*60*60) / (60*60)
		//獲得分鐘數
		var min = time % (24*60*60) % (60*60) / 60;
		//獲得秒數
		var sec = time % (24*60*60) % (60*60) % 60;
		//定義連接變數
		var str = "";
		//如果天數大於0
		if(days > 0){
			//取整數
			str += Math.floor(days) + " 天 ";
		}
		//如果小時大於0
		if(hour > 0){
			//取整數
			str += Math.floor(hour) + " 時 ";
		}
		//如果分鐘大於0
		if(min > 0){
			//取整數
			str += Math.floor(min) + " 分 ";
		}
		//連接秒數
		str += Math.floor(sec) + " 秒";
		//傳回值
		return str;
	}


</script>
</head>
<body style="text-align:center" bgcolor="#FFF7E8">

	<div style="margin-bottom:600px;">
		<h1 style="color:#9F35FF;text-shadow:5px -5px 5px #FFAF60;" id="left"></h1>
	</div>
	<div style="width:40%;height:600px;margin-left:auto;margin-right:auto;">
		<h2 style="width:100%;">滑鼠目前的(整個)螢幕座標：<span id="screen1"></span>.</h2>
		<h2 style="width:100%;">滑鼠目前的視窗(可視)客戶區座標：<span id="screen2"></span>.</h2>
		<h2 style="width:100%;">滑鼠目前的視窗(實際)頁面座標：<span id="screen3"></span>.</h2>
	</div>
</body>
</html>