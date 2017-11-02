<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* body, td, div {font-size: 12px; font-familly: 宋体; } */
/* #progressBar {width: 400px; height: 20px;  border: 1px solid black; padding: 1px;font-size:20px} */
/* #progressBarItem {width: 30%; height: 100%; } */
</style>
</head>

<body>



<form action="toolkie/ProgressUploadServlet" method="post" enctype="multipart/form-data" target="upload_iframe" onsubmit="showStatus(); ">
<iframe name=upload_iframe width=0 height=0></iframe>
<input type="file" name="input-file-preview"> 
<input type="submit" value="開始上傳  " id="btnSubmit" >
</form>

<div id="status" style="display: none" >
	上傳進度條：
	<div id="progressBar" class="progress progress-striped">
		<div class="progress-bar progress-bar-success"  role="progressbar" id="progressBarItem" >
		</div>
		
 	</div> <span id="progressBarItem1"  style="font-size:20px" align="left"></span>
	<div id="statusInfo"></div>
</div>

<br/>
<br/>
<br/>
<br/>
<br/>
<script>
var _finished = true; //是否上傳結束
//fuction $() = document.getElementById()
function $(XXX){//XXX一定要給隨意的參數，且這個function有存在的必要，影響第52行的結果。
	return document.getElementById(XXX);//傳回指定id的html
}

function showStatus(){//顯示進度條
	_finished = false;
	$('status').style.display = 'block';//將隱藏進度條顯示 
	$('progressBarItem').style.width = '1%'; //設定進度條初始為1%
	$('btnSubmit').disabled = true;//將傳送按鈕鎖定 防止重覆傳送
	
	setTimeout("requestStatus()", 1000); //一秒後執行requestStatus()方法 更新上傳進度
}

function requestStatus(){//向伺服器請求上傳進度

	if(_finished)	return;//如果已結束 則傳回
	
	var req = createRequest(); //獲得ajax請求
	
	req.open("GET", "toolkie/ProgressUploadServlet");//設定請求路徑
	
	
	
	
		
	req.onreadystatechange=function(){callback(req);}//請求完畢執行callback(req)
	req.send(null);//發送請求
	
	setTimeout("requestStatus()", 1000);//一秒後重新請求 
}

function createRequest()//傳回ajax請求物件
{
	if(window.XMLHttpRequest)//Netscape瀏覽器
	{
		return new XMLHttpRequest();
	}else//IE
	{
		try{
	    	return new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	return null;
}
function callback(req){//更新進度條

	if(req.readyState == 4) {//請求結束後
		if(req.status != 200){//有錯誤 顯示錯誤訊息
			_debug("發生錯誤。 req.status: " + req.status + "");
			return;
		}
		
		_debug("status.jsp 傳回值：" + req.responseText);//debug資訊
		
		var ss = req.responseText.split("||");
			
		// 格式：百分比||已完成数(M)||文件总长度(M)||传输速率(K)||已用时间(s)||估计总时间(s)||估计剩余时间(s)||正在上传第几个文件
		$('progressBarItem').style.width = '' + ss[0] + '%'; 
		$('progressBarItem1').innerHTML=''+ss[0]+"%";
		$('statusInfo').innerHTML = '已完成百分比: ' + ss[0] +'<br/>已用時間(s): ' + ss[3] +'<br/>預估剩於時間(s): ' + ss[5];
		
		if(ss[0] >= 100){
			_finished = true;
			$('statusInfo').innerHTML += "<br/><br/><br/>上傳已完成。"; 	
			$('btnSubmit').disabled = false;
		}
	}
}
function _debug(bugInformation){//bugInformation跟進度百分比有關
	var div = document.createElement("DIV");
	div.innerHTML = "[debug]: "+bugInformation;
	document.body.appendChild(div); 
}


</script>
</body>
</html>