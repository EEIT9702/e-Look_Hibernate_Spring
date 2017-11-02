var _finished = true; //是否上傳結束
//fuction $() = document.getElementById()
//function $(XXX){//XXX一定要給隨意的參數，且這個function有存在的必要，影響第52行的結果。
//	return document.getElementById(XXX);//傳回指定id的html
//}


var selectId;
function fileSelect(){
	var obj1 = event.srcElement; 
	if(obj1.type=="file"){
		selectId = obj1.id;
		if(selectId==="inputfilename1"){
			$('#inputfilename2').val("");
			$('#inputfilename3').val("");
		}
		if(selectId==="inputfilename2"){
			$('#inputfilename1').val("");
			$('#inputfilename3').val("");
		}
	}
	console.log(selectId);
}

var clickId;

function bottonClick1(){	
	var obj = event.srcElement; 
	if(obj.type=="submit"){
		clickId = obj.id;
	}
	
	
	var formData = new FormData($('form')[3]);
	//console.log("5555555555");
	$.ajax({
		type : 'POST',
		url : '/e-Look/toolkie/ProgressUploadServlet1',
		data :formData,
		processData : false,
		contentType : false,
//		success: function(){
//			
//			$('#sendOK').modal()
//			$('#sendOK h3').text("更新成功")
//			setTimeout(function(){
//		        $("#sendOK").modal('hide');
//		        }, 1000);
//        }
	})
	
}

function bottonClick(){	
	var obj = event.srcElement; 
	if(obj.type=="submit"){
		clickId = obj.id;
	}
	
	
	var formData = new FormData($('form')[3]);
	//console.log("5555555555");
	$.ajax({
		type : 'POST',
		url : '/e-Look/toolkie/ProgressUploadServlet',
		data :formData,
		processData : false,
		contentType : false,
//		success: function(){
//			
//			$('#sendOK').modal()
//			$('#sendOK h3').text("更新成功")
//			setTimeout(function(){
//		        $("#sendOK").modal('hide');
//		        }, 1000);
//        }
	})
	
}



function showStatus(){//顯示進度條
	_finished = false;
//	$('#status').css("display" , 'block')//將隱藏進度條顯示 
			
	//console.log("1234567890");
	
	if(clickId==="btnSubmit1"){
		$('#progressBar1').attr('aria-valuenow', "0").css("width" , '1%').text("0%");; //設定進度條初始為1%
		$('#btnSubmit1').disabled = true;//將傳送按鈕鎖定 防止重覆傳送;
	}
	if(clickId==="btnSubmit2"){
		$('#progressBar2').attr('aria-valuenow', "0").css("width" , '1%').text("0%");; //設定進度條初始為1%
		$('#btnSubmit2').disabled = true;//將傳送按鈕鎖定 防止重覆傳送	
	}
	
	setTimeout("requestStatus()", 1000); //一秒後執行requestStatus()方法 更新上傳進度
}







function requestStatus(){//向伺服器請求上傳進度

	if(_finished)	return;//如果已結束 則傳回
	
	var req = new XMLHttpRequest(); //獲得ajax請求
	
	req.open("GET", "/e-Look/toolkie/ProgressUploadServlet");//設定請求路徑
	
	
	
	
		
	req.onreadystatechange=function(){callback(req);}//請求完畢執行callback(req)
	req.send(null);//發送請求
	
	setTimeout("requestStatus()", 1000);//一秒後重新請求 
}

//function createRequest()//傳回ajax請求物件
//{
//	if(window.XMLHttpRequest)//Netscape瀏覽器
//	{
//		return new XMLHttpRequest();
//	}else//IE
//	{
//		try{
//	    	return new ActiveXObject("Msxml2.XMLHTTP");
//		}catch(e){
//			return new ActiveXObject("Microsoft.XMLHTTP");
//		}
//	}
//	return null;
//}
function callback(req){//更新進度條

	if(req.readyState == 4) {//請求結束後
		if(req.status != 200){//有錯誤 顯示錯誤訊息
//			_debug("發生錯誤。 req.status: " + req.status + "");
//			return;
		
		}
		
//		_debug("status.jsp 傳回值：" + req.responseText);//debug資訊
		
		var ss = req.responseText.split("||");
			
		// 格式：百分比||已完成数(M)||文件总长度(M)||传输速率(K)||已用时间(s)||估计总时间(s)||估计剩余时间(s)||正在上传第几个文件
	//	$('#progressBarItem').css("width" ,ss[0] + '%');  
	//	$('#progressBarItem1').html(ss[0]+"%")
		if(clickId==="btnSubmit1"){
			$('#progressBar1').attr('aria-valuenow', ss[0]).css('width',ss[0] + '%').text(ss[0]+"%");
		}
		if(clickId==="btnSubmit2"){
			$('#progressBar2').attr('aria-valuenow', ss[0]).css('width',ss[0] + '%').text(ss[0]+"%");
		}
						
//		$('#statusInfo').innerHTML = '已完成百分比: ' + ss[0] +'<br/>已用時間(s): ' + ss[3] +'<br/>預估剩於時間(s): ' + ss[5];
		
		if(ss[0] >= 100){
			_finished = true;
//			$('statusInfo').innerHTML += "<br/><br/><br/>上傳已完成。"; 	
			$('#btnSubmit').disabled = false;
		}
	}
}
//function _debug(bugInformation){//bugInformation跟進度百分比有關
//	var div = document.createElement("DIV");
//	div.innerHTML = "[debug]: "+bugInformation;
//	document.body.appendChild(div); 
//}