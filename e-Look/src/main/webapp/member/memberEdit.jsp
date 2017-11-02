<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="Shortcut Icon" type="image/x-icon" href="${SYSTEM.iconUri}" />
<meta name="login/viewport"
	content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/_PJC/js/autosize.js"></script>
<title>${SYSTEM.systemName}</title>
<style type="text/css">
.panel-heading {
	padding: 10px 15px;
	background-color: #353535;
	border-top: 1px solid #ddd;
	border-bottom-right-radius: 3px;
	border-bottom-left-radius: 3px;
	top: 0%;
	opacity: 0.8;
	color: white;
	border: none;
}

.panel-body {
	padding: 60px 4% 5% 7%;
}

.box {
	padding: 2%;
	border: 1px #ddd solid;
	cursor: pointer;
}

.remove-decoration {
	text-decoration: none !important;
	color: #333;
	font-size: 12px;
}

.clickable {
	cursor: pointer;
}

.clickable .glyphicon {
	background: rgba(0, 0, 0, 0.15);
	display: inline-block;
	padding: 6px 12px;
	border-radius: 4px
}

.panel-heading span {
	margin-top: -23px;
	font-size: 15px;
	margin-right: -9px;
}

a.clickable {
	color: inherit;
}

a.clickable:hover {
	text-decoration: none;
}

<!--
-->
.profile-header-container {
	margin: 0 auto;
	text-align: center;
}

.profile-header-img {
	padding: 30px 0;
}

.profile-header-img>img.img-circle {
	width: 120px;
	height: 120px;
	border: 2px solid #51D2B7;
}

.profile-header {
	margin-top: 43px;
}

/**
 * Ranking component
 */
.rank-label-container {
	margin-top: -19px;
	/* z-index: 1000; */
	text-align: center;
}

.label.label-default.rank-label {
	background-color: rgb(81, 210, 183);
	padding: 5px 10px 5px 10px;
	border-radius: 27px;
}

.image-preview-input {
	position: relative;
	overflow: hidden;
	margin: 0px;
	color: #333;
	background-color: #fff;
	border-color: #ccc;
}

.image-preview-input input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	margin: 0;
	padding: 0;
	font-size: 20px;
	cursor: pointer;
	opacity: 0;
	filter: alpha(opacity = 0);
}

.image-preview-input-title {
	margin-left: 2px;
}
</style>
</head>

<body>
<c:if test="${empty LoginOK}">
	<c:redirect url="/HOME.jsp"/>
	</c:if>
	<jsp:include page="/login.jsp" />
	<div  class="alert alert-success" role="alert" id="updatainfo" style="display: none ;position:fixed;z-index: 20;width: 100%; text-align: center;opacity: 0.8;font-size: 32px">
	更新成功
	</div>
	<div style="margin-top: 10px" class="container">
	

		<form action="" method="POST" name="formData" id="formData"
			enctype="multipart/form-data">
			<input type="hidden" name="memberID" value="${LoginOK.memberID}">
			<div class="row">
		
				<div class="col-md-4 "
					style="padding-top: 20px; background-image: linear-gradient(-225deg, #E3FDF5 0%, #FFE6FA 100%);">
					<h4 class="text-center">預覽樣式</h4>
					<div class=" panel-body"
						style="padding: 20px; background-image: linear-gradient(-225deg, #77FFD2 0%, #6297DB 48%, #1EECFF 100%);">

						<div class="col-md-6 no-pad ">
							<div class="profile-header-container">
								<div class="profile-header-img">
									<img class="img-circle" id="wizardPicturePreview"
										src="<%=request.getContextPath()%>/Image?MemberID=${LoginOK.memberID}" />
									<!-- badge -->
									<div class="btn btn-success btn-xl image-preview-input">
										<span class="glyphicon glyphicon-folder-open"></span> <span
											class="image-preview-input-title">編輯圖片</span> <input
											type="file" accept="image/png, image/jpeg, image/gif"
											id="wizard-picture" name="memberphoto">
										<!-- rename it -->
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6 no-pad text-center">
							<div class="user-pad" style="padding: 60px 0;">
								<h2 style="color: white;" id="readname" >${LoginOK.mName}</h2>
							</div>
						</div>
					</div>
					<div class="row overview panel-body">
						<div class="col-md-6 user-pad text-center">
							<div class="hero-widget well  well-lg">
								<h3>已參加</h3>
								<h4>堂課</h4>
							</div>
						</div>
						<div class="col-md-6 user-pad text-center">
							<div class="hero-widget well  well-lg">
								<h3>已開設</h3>
								<h4>堂課</h4>
							</div>
						</div>
					</div>
					<div class="col-md-12">
						<div class="panel panel-success">
							<div class="panel-heading">
								<h4 class="text-center">關於我</h4>
							</div>
							<div class="panel-body text-center">
								<p class="lead">
								<p id="keyupaboutme"
									style="word-break: break-all; word-wrap: break-word">${LoginOK.aboutme}
								<p></p>
							</div>
						</div>
					</div>
					<div class="col-md-12">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h4 class="text-center">專長</h4>
							</div>
							<div class="panel-body text-center">
								<p class="lead">
								<p style="word-break: break-all; word-wrap: break-word" id="keyupskill">${LoginOK.skill}</p>
								<p></p>
							</div>
						</div>
					</div>
					<div class="col-md-12">
						<div class="panel panel-warning">
							<div class="panel-heading">
								<h4 class="text-center">興趣</h4>
							</div>
							<div class="panel-body text-center">
								<p class="lead">
								<p style="word-break: break-all; word-wrap: break-word" id="keyuphobby">${LoginOK.hobby}
								<p></p>
							</div>
						</div>
					</div>
				</div>
				<!-- 會員左半邊-->
				<div class="col-md-8 ">
					<h3 class="text-center" style="font-weight: 800;">
						<span class="glyphicon glyphicon glyphicon-cog" aria-hidden="true"></span>帳號設定
					</h3>
					<div class="row" style="margin-top: 50px">
						<div class=" col-md-12 ">
						
							<div class=" col-md-4 " style="margin: 10px 0;">
								<div class="form-group">
									<label>名字</label> <input type="text" class="form-control" 
										id="keyupname" name="mName" value="${LoginOK.mName}">
								</div>
							</div>
							<div class="col-md-8"></div>
						</div>
						<div class=" col-md-12 ">
							<div class=" col-md-8 " style="margin: 10px 0;">
								<div class="form-group">
									<label>帳號(信箱)</label> <input type="text" class="form-control"
										id="" name="email" value="${LoginOK.email}"<c:if test="${LoginOK.mPassword==''}">readonly</c:if>  >
								</div>
							</div>
							<div class="col-md-4"></div>
						</div>
						<div class=" col-md-12 ">
							<div class=" col-md-4 " style="margin: 10px 0;">
								<div class="form-group input-group">
									<label>密碼</label> <input type="password" class="form-control"
										id="mPassword" name="mPassword" readonly value="${LoginOK.mPassword}">
										<span  class="input-group-btn" style="padding-top: 27px">
            <button data-toggle="modal" data-target="#ChangePassword" class="btn  btn-info reveal" type="button"  <c:if test="${LoginOK.mPassword==''}">disabled="disabled"</c:if>><i class="glyphicon glyphicon-pencil"></i></button>
        			 </span>      
								</div>
							</div>
							<div class="col-md-8"></div>
						</div>
						<div class=" col-md-12 ">
							<div class="col-md-8">
							<div class="form-group ">
								 <label>地址</label>    <label style="margin:10px "></label><input type="text" name="address" class="form-control"	id="" value="${LoginOK.address}">
							</div>
							</div>
						</div>
					</div>

					<div class=" col-ms-12 " style="margin: 30px 0 10px 0;">
						<div class="panel panel-success">
							<div class="panel-heading">關於我</div>
							<div class=" form-group  form-group-textarea ">
								<textarea id="customStyle" name="aboutme" form="formData"
									class="form-control" data-toggle="floatLabel"
									data-value="no-js" style="font-size: 18px">${LoginOK.aboutme}</textarea>
							</div>
						</div>
					</div>
					<div class=" col-ms-12 " style="margin: 20px 0;">
						<div class="panel panel-info">
							<div class="panel-heading">專長</div>
							<div class=" form-group  form-group-textarea ">
								<textarea id="customStyle1" name="skill" form="formData"
									class="form-control" data-toggle="floatLabel"
									data-value="no-js" style="font-size: 18px">${LoginOK.skill}</textarea>
							</div>
						</div>
					</div>

					<div class=" col-ms-12 " style="margin: 20px 0;">
						<div class="panel panel-warning">
							<div class="panel-heading">興趣</div>
							<div class=" form-group  form-group-textarea ">
								<textarea id="customStyle2" name="hobby" form="formData"
									class="form-control" data-toggle="floatLabel"
									data-value="no-js" style="font-size: 18px">${LoginOK.hobby}</textarea>
							</div>
						</div>
					</div>
							<div class="col-md-12 ">
<!-- 								<button type="button" class="btn btn-primary btn-product" style="margin: 0 auto;" id="send">確認修改</button> -->
								<a href="<%=request.getContextPath()%>/member/member.jsp"><button type="button" class="btn btn-primary btn-danger ">返回</button></a>
							</div>

				</div>
			</div>
			<!--密碼彈跳式窗 -->
		</form>
			<div class="modal fade" id="ChangePassword" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top:100px ">
	<div class="modal-dialog" style="width: 300px;">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close pull-right" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="">修改密碼</h4>
			</div> <!-- /.modal-header -->

			<div class="modal-body">
				
					<div class="form-group " >
					 <label id="oldpwd">舊密碼</label>
						<div class="input-group">
							<input type="password" maxlength="10" class="form-control" id="oldpwd1" >
							<label style=""  class="input-group-addon glyphicon glyphicon-question-sign"></label>
						</div>
					</div>
					<div class="form-group " >
					 <label id="newpwd">新密碼</label>
						<div class="input-group">
							<input type="password" maxlength="10" class="form-control" id="newpwd1" >
							<label style=""  class="input-group-addon glyphicon  glyphicon-question-sign"></label>
						</div>
					</div>
					<div class="form-group " >
					 <label id="angpwd">密碼確認</label>
						<div class="input-group">
							<input type="password"  maxlength="10"class="form-control" id="angpwd1" >
							<label style=""  class="input-group-addon glyphicon  glyphicon-question-sign"></label>
						</div>
					</div>
			<button  class=" btn btn-primary  btn-lg btn-block" disabled="disabled" id="ok">確認</button>

			</div> <!-- /.modal-body -->


		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
	
</div>
	<!-- 密碼彈跳式窗 -->
	
		<!-- 彈跳式窗 -->
<div class="modal fade" id="sendOK" tabindex="-1" role="dialog"aria-labelledby="myModalLabel" aria-hidden="true" >
		<div class="modal-dialog"  style="width:300px">
			<div class="modal-content text-center" >
<!-- 			右上角X -->
				<div class="modal-header">
					<button type="button" class="close pull-right" data-dismiss="modal"
						aria-hidden="true" style="font-size: 35px;">&times;</button>
				</div>
				
					<h3></h3>
				<div  id="butfooter">
				</div>
				</div>
				</div>
				</div>	
	</div>
	<jsp:include page="/footer.jsp" />
	<script >
$(function() {
//init();
// var data2;
// function init() {
// 	$.getJSON("json/AllData.json", function(data) {
// 		data2 = data;
// 		var fragment = $(document.createDocumentFragment());
// 		var cell2 = $('<option></option>').text("請選擇").val("")
// 		fragment.append(cell2);
// 		$.each(data, function(key, val) {
// 			var cell1 = $('<option></option>').text(val.CityName).val(val.CityName)
// 			fragment.append(cell1);
// 		})
// 		$('#select1').html(fragment);
// 		$.each(data, function(key, val1) {
// 			if ("臺北市" === val1.CityName) {
// 				var fragment = $(document.createDocumentFragment());
// 				var cell2 = $('<option></option>').text("請選擇").val("")
// 				fragment.append(cell2);
// 				$('#select2').html(fragment);
// 			}

// 		})
// 	})

// }
// $("#select1").change(
// 		function() {
// 			var opt = $('#select1>:selected');
// 			var val = opt.val();
// 			$.each(data2,
// 					function(key, val1) {
// 						if (val === val1.CityName) {
// 							var fragment = $(document.createDocumentFragment());
// 							var cell2 = $('<option></option>').text("請選擇").val("");
// 							fragment.append(cell2);
// 							$.each(val1.AreaList, function(key, val2) {
// 								var cell1 = $('<option></option>').text(val2.AreaName).val(val2.AreaName)
// 								fragment.append(cell1);
// 							})
// 							$('#select2').html(fragment);
// 						}else if(val === ""){
							
// 							init();
// 						}

// 					})
// 	})
})

	$('textarea').each(function() {
		autosize(this);
	}).on('autosize:resized');

	$('#customStyle').keyup(function() {
		var value = $(this).val();
		$("#keyupaboutme").text(value);
	});
	$('#customStyle1').keyup(function() {
		var value = $(this).val();
		$("#keyupskill").text(value);
	});
	$('#customStyle2').keyup(function() {
		var value = $(this).val();
		$("#keyuphobby").text(value);
	});
	
	$('#keyupname').keyup(function() {
		var value = $(this).val();
		$("#readname").text(value);
	});

	$("#wizard-picture").change(function() {
		readURL(this);
	});

	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#wizardPicturePreview').attr('src', e.target.result).fadeIn(
						'slow');
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	$("form input[type!='file'],textarea").keyup(function(){
		var formData = new FormData($('form')[3]);
		//console.log(formData);
		$.ajax({
			type : 'POST',
			url : 'MemberDataContrlloer',
			data :formData,
			processData : false,
			contentType : false,
			success: function(){
				delay_till_last('id', function() {
				$("#updatainfo").fadeIn(1200);
				$("#updatainfo").fadeOut(3500);
// 				$('#sendOK').modal()
// 				$('#sendOK h3').text("更新成功")
// 				setTimeout(function(){
// 			        $("#sendOK").modal('hide');
// 			        }, 1000);
				}, 500);
            }
		})
	})
	$("form input[type='file']").change(function(){
		var formData = new FormData($('form')[3]);
		$.ajax({
			type : 'POST',
			url : 'MemberDataContrlloer',
			data :formData,
			processData : false,
			contentType : false,
			success: function(){
				delay_till_last('id', function() {
				$("#updatainfo").fadeIn(1000);

				$("#updatainfo").fadeOut(3500);
// 				$('#sendOK').modal()
// 				$('#sendOK h3').text("更新成功")
// 				setTimeout(function(){
// 			        $("#sendOK").modal('hide');
// 			        }, 1000);
				}, 500);
            }
		})
		
	})
	
	var chkoldpwd;
	var chknewpwd;
	var chkangpwd;
	$("input[type=password]").keyup(function(){
		
		
		
	})
	$("#oldpwd1").keyup(function(){
		var mPassword=$("#mPassword").val();
		var oldpwd=$("#oldpwd1").val();
		if(mPassword===oldpwd){
			chkoldpwd=true;
			$("#oldpwd1+label").removeClass().addClass("input-group-addon glyphicon glyphicon-ok").css("color","green");
				
		}else{
			chkoldpwd=false;
			$("#oldpwd1+label").removeClass().addClass(" input-group-addon glyphicon glyphicon-remove").css("color","red");
			$("#ok").prop("disabled",true)
		}
		if(chkoldpwd&&chknewpwd&&chkangpwd){
			$("#ok").prop("disabled",false)
		}else{
			$("#ok").prop("disabled",true)
		}
		
	})
	
	$("#newpwd1").keyup(function(){
		var angpwd=$("#angpwd1").val();
		
		var newpwd=$("#newpwd1").val();
		if(angpwd===newpwd){
			chkangpwd=true;	
			$("#angpwd1+label").removeClass().addClass("input-group-addon glyphicon glyphicon-ok").css("color","green");
		}else{
			chkangpwd=false;
			$("#angpwd1+label").removeClass().addClass(" input-group-addon glyphicon glyphicon-remove").css("color","red");
			
		}
		
		if(chkoldpwd&&chknewpwd&&chkangpwd){
			$("#ok").prop("disabled",false)
		}else{
			$("#ok").prop("disabled",true)
		}
		var re = new RegExp("^.*(?=.{8,10})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$");

		var newpwd=$("#newpwd1").val();
		
		if(re.test(newpwd)){
			chknewpwd=true;	
			$("#newpwd1+label").removeClass().addClass("input-group-addon glyphicon glyphicon-ok").css("color","green");
			
		}else{
			chknewpwd=false;
			$("#newpwd1+label").removeClass().addClass(" input-group-addon glyphicon glyphicon-remove").css("color","red");
			
		}
		
		if(chkoldpwd&&chknewpwd&&chkangpwd){
			$("#ok").prop("disabled",false)
		}else{
			$("#ok").prop("disabled",true)
		}
		
	})
	
	$("#angpwd1").keyup(function(){
		var angpwd=$("#angpwd1").val();
		
		var newpwd=$("#newpwd1").val();
		if(angpwd===newpwd){
			chkangpwd=true;	
			$("#angpwd1+label").removeClass().addClass("input-group-addon glyphicon glyphicon-ok").css("color","green");
		}else{
			chkangpwd=false;
			$("#angpwd1+label").removeClass().addClass(" input-group-addon glyphicon glyphicon-remove").css("color","red");
			
		}
		if(chkoldpwd&&chknewpwd&&chkangpwd){
			$("#ok").prop("disabled",false)
		}else{
			$("#ok").prop("disabled",true)
		}
	})
	$("#ok").click(function(){
		var newpwd=$("#newpwd1").val();
		$("#mPassword").val(newpwd);
		 $("#ChangePassword").modal('hide');
		 $.post('MemberDataContrlloer',	{'change':'pwd','mPassword':newpwd},function(){
					$('#sendOK').modal()
					$('#sendOK h3').text("密碼更新成功")
					setTimeout(function(){
				        $("#sendOK").modal('hide');
				        }, 1000);
	            }
			)
		
		$('#ChangePassword').on('hidden.bs.modal', function(){
			$("#oldpwd1+label").removeClass().addClass("input-group-addon glyphicon  glyphicon-question-sign").css("color","black");
			$("#newpwd1+label").removeClass().addClass("input-group-addon glyphicon  glyphicon-question-sign").css("color","black");
			$("#angpwd1+label").removeClass().addClass("input-group-addon glyphicon  glyphicon-question-sign").css("color","black");
			$("#oldpwd1").val("")
			$("#newpwd1").val("")
			$("#angpwd1").val("")
			})
	})
	
	
	// 設定keyup事件在特定秒數內只會觸發1次
		var _timer = {};
		function delay_till_last(id, fn, wait) {
			if (_timer[id]) {
				window.clearTimeout(_timer[id]);
				delete _timer[id];
			}

			return _timer[id] = window.setTimeout(function() {
				fn();
				delete _timer[id];
			}, wait);
		}
		// =====================================
</script>
</body>


</html>