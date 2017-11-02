<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:useBean id="SYSTEM" class="init.GlobalService" scope="application"/>
<link rel="Shortcut Icon" type="image/x-icon" href="${SYSTEM.iconUri}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="login/viewport"
	content="width=device-width, initial-scale=1">
<%-- <link href="<%=request.getContextPath()%>/login/css/bootstrap.css" --%>
<!-- 	rel="stylesheet" type="text/css"> -->
<link href="<%=request.getContextPath()%>/login/css/login.css"
	rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/login/js/facebook_login.js"
	type="text/javascript"></script>
<script src="https://apis.google.com/js/platform.js?onload=appStart"
	async defer>
	{
		lang: 'zh-TW'
	}
</script>
<script src="<%=request.getContextPath()%>/login/js/google_login.js"
	type="text/javascript"></script>
<%-- <script src="<%=request.getContextPath()%>/HeaderCssJs/jquery.js"></script> --%>
<%-- <script src="<%=request.getContextPath()%>/login/js/jquery-3.2.1.js" --%>
<!-- 	type="text/javascript"></script> -->
<%-- <script src="<%=request.getContextPath()%>/login/js/bootstrap.js" --%>
<!-- type="text/javascript"></script> -->
	<script>
 $(document).ready(function () {
		$(this).click(function() {
			$('font').text("");
			
		})
		
		
	
	$('#forget').click(function() {
		$('#myModal').modal('hide')

	})
	
		$('#fast-register1').click(function() {
		$('#myModal').modal('hide')

	})
		$('#forget').click(function() {
		$('#myModal2').modal('hide')

	})
		
	
		$('#fast-register1').click(function() {
		$('#myModal2').modal('hide')

	})
		$('#alogin').click(function() {
		$('#register2').modal('hide')

	})
		$('#alogin').click(function() {
		$('#register3').modal('hide')

	})
	$('#myModal2').modal({})
	$('#register3').modal({})
	$('#registerOK').modal({})
			/*會員規範*/
	$('#btn').click(function() {
		$('#register1').modal('hide')
	})
})
function refresh(){
	 document.location.href=location.href;
 }

	/*閱讀完協定以後才可以點擊的註冊按鈕*/
	//div的捲軸捲動事件
	function doScroll () {
		//取得會員規範和按鈕的DOM
		
		var d = document.getElementById("rule");
		var btn = document.getElementById("btn");
		//判斷是否捲動到最底部
		if(d.scrollTop + d.offsetHeight >= d.scrollHeight) {
			//恢復按鈕可用
			btn.disabled = false;
			//測試效果用,沒到底不可點擊
		} else {
			btn.disabled = true;
		}	
// 		alert(d.scrollTop);
// 		alert(d.offsetHeight);
// 		alert(d.scrollHeight);
	}
	//為文件的滑鼠按下事件定義回呼
// 	document.onmousedown = function(event) {
// 		//滑鼠事件：0 > 沒按鍵, 1 > 按左鍵, 2 > 按右鍵, 3 > 按左鍵&右鍵
// 		//4 > 按中間鍵, 5 > 按左鍵&中間鍵, 6 > 按右鍵&中間鍵, 7 > 按所有鍵
// 		if (event.button == 2) {
// 			//提示使用者禁用滑鼠右鍵
// 			alert("禁用滑鼠右鍵!");
// 		}	
// 	}
	
</script>
<style type="text/css">
#regulation{
	font-family: Microsoft JhengHei;
	font-weight: bold; 
	width:100%;
	height:400px;
	background-color:#F0F0F0;
}
#rule{
background-color:#FFFFFF;
width:100%;
height:100%;
overflow-y:scroll;
}
#btn 
{
border-radius:10px;
font-size:15px;
text-align:center;
} 
#btn2{
border-radius:10px;
font-size:15px;
text-align:center;

} 
#regulation b{
color:#0080FF;
}
#butfooter{
width:20%;
margin:2px auto;
}
</style>
<title>${SYSTEM.systemName}</title>
</head>
<body>
	<jsp:include page="/header-v2.jsp" />
	<!-- 以下是login畫面 -->
	<c:choose>
		<c:when test="${!empty loginerr}">
		<c:set var="id" value="myModal2"/>
		<c:set var="id2" value="#myModal2"/>
	</c:when>
	<c:when test="${empty err}">
		<c:set var="id" value="myModal"/>
		<c:set var="id2" value="#myModal"/>
		<c:set var="cla" value="fade"/>
	</c:when>
	<c:otherwise>
		<c:set var="id" value="myModal2"/>
		<c:set var="id2" value="#myModal2"/>
	</c:otherwise>
	</c:choose>
	<div class="modal ${cla}" id="${id}" tabindex="-1"  role="dialog"aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="container modal-dialog">
			<div class="row ">
				<form class="form-signin mg-btm modal-content" name="loginfrom" method="post" action="<%=request.getContextPath()%>/login.login">
					<div class="modal-header">
						<button type="button" class="close pull-right" data-dismiss="modal"
							aria-hidden="true" style="font-size: 35px;">&times;</button>
						<h3 class="heading-desc">
							<img style="margin: auto;"
								src="<%=request.getContextPath()%>/login/image/eLook_LOGO.png"
								width="100" class="img-rounded">
						</h3>
					</div>
					<div class="social-box">
						<div class="row mg-btm">
							<div class="col-md-12">
								<button type="button" class="btn btn-primary btn-block"
									onclick="myFacebookLogin()">
									<img src="<%=request.getContextPath()%>/login/image/fbicon.png"
										class="img-rounded"><span> Facebook 登入 / 註冊</span>
								</button>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<button id="google" type="button" onclick="myGoogleLogin()"
									class="btn btn-danger btn-block">
									<img src="<%=request.getContextPath()%>/login/image/sgicon.png"
										class="img-rounded"><span> GOOGLE 登入 / 註冊</span> 
								</button>
							</div>
						</div>
					</div>
					<div class="main">
						<font style="color: red" id="errf1" size="-1">${err.erremail}</font>
						<input type="text" class="form-control"  placeholder="Email" autofocus id="login-email" name="email" autocomplete="off" />
						<font style="color: red;" id="errf2" size="-1">${err.errepwd}</font>
						<input type="password" class="form-control"placeholder="Password" id="login-password" name="mPassword"/>
					</div>
					<div class="login-footer">
						<div class="row">
							<div class="col-xs-6 col-md-6">
								<div class="left-section">
									<a id="forget" data-toggle="modal" data-target="#forgetpwd"
										href="">忘記密碼?</a> <a  id="fast-register1" data-toggle="modal" data-target="#register1" href="">快速註冊</a>
								</div>
							</div>
							<div class="col-xs-6 col-md-6 pull-right">
								<button type="submit" id="login" class="btn btn-large btn-info pull-right">登入</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<!-- 以上是login畫面 -->


	<!-- 以下是忘記密碼畫面 -->
	<div  style="margin-top:100px "class="modal fade" id="forgetpwd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4 modal-content">
				<form id="register-form" role="form" autocomplete="off" class="form"
					method="post" action="<%=request.getContextPath()%>/login.html">
					<div class="modal-header text-center">
						<button type="button" class="close pull-right" data-dismiss="modal"
							aria-hidden="true" style="font-size: 35px;">&times;</button>
						<h2 class="text-center">忘記密碼</h2>
						<p>系統會寄送一組新密碼</p>
					</div>
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope color-blue"></i></span> <input
								id="email" name="email" placeholder="email address"
								class="form-control" type="text">
						</div>
					</div>
					<div class="form-group">
						<input name="recover-submit"
							class="btn btn-lg btn-primary btn-block" value="重設密碼"
							type="submit">
					</div>

					<input type="hidden" class="hide" name="reset" id="token" value="resetpwd">
				</form>
			</div>
		</div>
	</div>
</div>
	<!-- 以上是忘記密碼畫面  -->
	<!-- 以下是註冊畫面 -->
	<c:choose>
	<c:when test="${empty regerr}">
		<c:set var="regid" value="register2"/>
		<c:set var="regcla" value="fade"/>
		<c:set var="regid2" value="#register2"/>
	</c:when>
	<c:otherwise>
		<c:set var="regid" value="register3"/>
		<c:set var="regid2" value="#register3"/>
	</c:otherwise>
	</c:choose>
	<div style="margin-top:50px " class="modal ${regcla}" id="${regid}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	 <div class="container " style="max-width: 420px;">
	<div class="panel-body modal-content" >
					<form method="POST" action="<%=request.getContextPath()%>/login.html" role="form">
						<div class="modal-header text-center">
						<button type="button" class="close pull-right" data-dismiss="modal"
							aria-hidden="true" style="font-size: 35px;">&times;</button>
							<h2>Create account</h2>
					</div>
						<div class="form-group">
							<label class="control-label" for="signupName">Your name</label><br><font style="color: red;"  size="-1">${regerr.errname}</font>
							<input id="signupName" type="text" maxlength="50" name="mName" value="${Name}" class="form-control">
						</div>
						<div class="form-group">
							<label class="control-label" for="signupEmail">Email</label><br><font style="color: red;"  size="-1">${regerr.erremail}</font>
							<input id="signupEmail" type="text" maxlength="50" name="email" value="${mail}" class="form-control">
						</div>
						<div class="form-group">
							<label class="control-label" for="signupPassword">Password</label><br><font style="color: red;"size="-1">${regerr.errpwd}</font>
							<input id="signupPassword" type="password" maxlength="10" name="mPassword"  class="form-control" placeholder="至少要含一個有數字及大小寫字母，密碼長度到8~10" >
						</div>
						<div class="form-group">
							<label class="control-label" for="signupPasswordagain">Password again</label><br><font style="color: red;"  size="-1">${regerr.errpwd2}</font>
							<input id="signupPasswordagain" type="password" maxlength="10" name="mPassword2" class="form-control">
						</div>
						<div class="form-group">
							<label>verify code</label><br><font style="color: red;"  size="-1">${regerr.errcheck}</font><br>
							<input type="text" name="check"class="form-inline" />
							<img align="middle"  src="<%=request.getContextPath()%>/CheckCodeServlet.jpg" border="1" />
						</div>
						
						<div class="form-group">
							<button id="signupSubmit" type="submit" class="btn btn-info btn-block">Create your account</button>
						</div>
						
						<hr>
						<p>已經有帳號了 <a id="alogin"data-toggle="modal" data-target="${id2}"href="">Sign in</a></p>
					</form>
				</div>
				</div>
				</div>
				<c:remove var="regerr" scope="session"/>
				<c:remove var="Name" scope="session"/>
				<c:remove var="mail" scope="session"/>
	<!-- 以上是註冊畫面  -->
	
	<!-- 以下是會員規範  -->
<div class="modal fade" id="register1" tabindex="-1" role="dialog"aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog"  style="width:1000px">
			<div class="modal-content" >
<!-- 			右上角X -->
				<div class="modal-header">
					<button type="button" class="close pull-right" data-dismiss="modal"
						aria-hidden="true" style="font-size: 35px;">&times;</button>
				</div>
<!-- 				內容開始 -->
					<div id="regulation">
						<div onscroll="doScroll()" id="rule">
							<h4 style="text-align: center; font-size: 20px;">e-Look
								網站服務條款</h4>
							<p style="font-size: 15px; text-align: left;">
								以下文章詳述在&nbsp;e-Look&nbsp;提供您服務的同時，您必須瞭解的相關事項，請您在同意註冊成為會員前，詳細閱讀，
								尤其當您在線上點選「同意」鍵，表示：<br /> 1.您了解本網站為本公司所經營之網站； <br />
								2.當您於本網站註冊成為會員後，即可使用本網站提供之服務； <br />
								3.當您使用本網站服務時，即表示您同意並遵守本網站之會員規範及相關之法律規定。<br />
								<br /> <b>⊙遵守會員規範及法律規定</b> <br />
								您了解您於註冊後，即成為本網站會員，可使用本網站提供的服務。當會員使用本網站服務時，
								即表示同意接受會員規範及所有注意事項之拘束，並承諾遵守中華民國相關法規及一切國際網際網路規定與慣例。<br />
								會員應遵守之法律規定，請參考中華民國刑法各章規定、電腦處理個人資料保護法、專利法、著作權法、商標法、
								智慧財產權相關法規、消費者保護法、公平交易法、兒童及少年性交易防制條例、性侵害犯罪防治法、藥事法、
								野生動物保育法、毒品危害防治條例及槍砲彈藥刀械管制條例等相關法律規定。(相關法律條文)<br />
								<br /> <b>⊙會員資料 </b><br />
								基於本網站所提供之各項服務，您同意於註冊時提供完整詳實且符合真實之個人資料，您所登錄之資料事後有變更時，
								應隨時於線上更新之，如有任何虛假或冒用他人名義登錄，應自負法律責任。<br />
								您提供之個人資料若有填寫不實，或原所登錄之資料已不符合真實而未更新， 本公司有權隨時終止您會員資格及使用各項服務之權利。<br />
								如果您提供之個人資料經本公司判斷有違服務之宗旨，本公司有權隨時終止您會員資格及使用各項服務之權利。 <br />
								<br /> <b>⊙會員規範的增訂、修改與終止</b> <br />
								&nbsp;e-Look&nbsp;保留隨時修改本會員規範之權利，修改後的規範將於網站首頁最新消息區公告，將不另作會員個別通知。
								如果您不同意修正內容，應停止繼續使用本公司服務。倘若您繼續使用本網站提供之服務， 則表示您同意並接受本會員規範之任何修改。<br />
								<br /> <b>⊙服務之更改與停止</b><br />
								&nbsp;e-Look&nbsp;保留隨時更改或停止各項服務內容，或終止任一會員帳戶服務之權利，且無需事先通知會員。
								無論任何情形，就停止或更改服務或終止會員帳戶服務之決定，本網站對任何會員或第三人均不負任何責任。<br />
								<br /> 您瞭解&nbsp;e-Look&nbsp;提供網站上的服務與資訊供會員使用，但不對任何服務或資訊傳送的遲延、
								儲存的故障以及任何資訊的刪除負任何責任。<br />
							</p>
						</div>
				</div>
<!-- 				內容結束 -->
				<div  id="butfooter">
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="${regid2}" id="btn" disabled="disabled">同意</button>
					<button type="button" class="btn btn-primary"  data-dismiss="modal" id="btn2">不同意</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 以上是會員規範  -->
	<!--以下是註冊成功要收信的彈跳式窗-->
	<c:if test="${! empty registerOK}">
	<div class="modal fade" id="registerOK" tabindex="-1" role="dialog"aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog"  style="width:350px">
			<div class="modal-content text-center" >
<!-- 			右上角X -->
				<div class="modal-header">
					<button type="button" class="close pull-right" data-dismiss="modal"
						aria-hidden="true" style="font-size: 35px;">&times;</button>
				</div>
				
					<h3>${registerOK}</h3>
				<div  id="butfooter">
					<button type="button" class="btn btn-primary" onclick="refresh()" data-dismiss="modal">OK</button>
				
				</div>
				</div>
				</div>
				</div>	
	</c:if>
	<c:remove var="registerOK" scope="session"/>
	<!--以上是註冊成功要收信的彈跳式窗-->
</body>

</html>