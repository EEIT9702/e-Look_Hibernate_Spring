<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:useBean id="SYSTEM" class="init.GlobalService" scope="application" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${SYSTEM.systemName}</title>
<LINK REL="SHORTCUT ICON" HREF="http://www.mydomain.com/myicon.ico">
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/_PJC/css/step1.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/_PJC/css/step2.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/_PJC/css/step3.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/_PJC/css/step4.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/_PJC/css/step6.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/_PJC/css/step7.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/css/bootstrap-datetimepicker.css"
	rel="stylesheet">

<!-- 顯示分頁上e-look的小圖示	 -->
<link rel="Short Icon" type="image/x-icon" href="${initParam.icon}" />

<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/_PJC/js/jquery-ui.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/_PJC/js/autosize.js"></script>
<script
	src="<%=request.getContextPath()%>/_PJC/js/bootstrap-datetimepicker.js"></script>
<script
	src="<%=request.getContextPath()%>/_PJC/js/bootstrap-datetimepicker.zh-TW.js"></script>
<script
	src="<%=request.getContextPath()%>/_PJC/tinymce/js/tinymce/jquery.tinymce.min.js"></script>
<script
	src="<%=request.getContextPath()%>/_PJC/tinymce/js/tinymce/tinymce.js"></script>
<script src="<%=request.getContextPath()%>/_PJC/js/upload1.js"></script>


</head>

<body>
	<jsp:include page="/login.jsp" flush="true" />
	<div class="container" style="margin-top: 50px">
		<div class="row">
			<section>
				<div class="wizard">
					<div class="wizard-inner">
						<div class="connecting-line"></div>
						<ul class="nav nav-tabs" role="tablist">

							<li role="presentation" class="active"><a href="#step1"
								data-toggle="tab" aria-controls="step1" role="tab"
								title="Step 1"> <span class="round-tab"> <i
										class="glyphicon glyphicon-list"></i>
								</span>
							</a></li>

							<li role="presentation" class="disabled"><a href="#step2"
								data-toggle="tab" aria-controls="step2" role="tab"
								title="Step 2"> <span class="round-tab"> <i
										class="glyphicon glyphicon-picture"></i>
								</span>
							</a></li>
							<li role="presentation" class="disabled"><a href="#step3"
								data-toggle="tab" aria-controls="step3" role="tab"
								title="Step 3"> <span class="round-tab"> <i
										class="glyphicon glyphicon-tags"></i>
								</span>
							</a></li>
							<li role="presentation" class="disabled"><a href="#step4"
								data-toggle="tab" aria-controls="step4" role="tab"
								title="Step 4"> <span class="round-tab"> <i
										class="glyphicon glyphicon-usd"></i>
								</span>
							</a></li>
							<li role="presentation" class="disabled"><a href="#step5"
								data-toggle="tab" aria-controls="step5" role="tab"
								title="Step 5"> <span class="round-tab"> <i
										class="glyphicon glyphicon-pencil"></i>
								</span>
							</a></li>
							<li role="presentation" class="disabled"><a href="#step6"
								data-toggle="tab" aria-controls="step6" role="tab"
								title="Step 6"> <span class="round-tab"> <i
										class="glyphicon glyphicon-open"></i>
								</span>
							</a></li>

							<li role="presentation" class="disabled" id="getProposalData2"><a href="#complete"
								data-toggle="tab" aria-controls="complete" role="tab"
								title="Complete"> <span class="round-tab"> <i
										class="glyphicon glyphicon-thumbs-up"></i>
								</span>
							</a></li>
						</ul>

					</div>
					<P class="great" id="updateConfirm" style="display: none;z-index:10;">
					</P>
					<form action="" method="POST" name="formData"
						target="upload_iframe" enctype="multipart/form-data" role="form"
						id="TotalContent" onsubmit="showStatus()">
						<iframe name=upload_iframe width=0 height=0 style="display: none;"></iframe>
						<input type="hidden" value="${CourseID}" name="CourseID"
							id="courseID"> <input type="hidden"
							value="${LoginOK.memberID}" name="memberID">
						<div class="tab-content">
							<!-- 整個step1頁面 -->
							<div class="tab-pane active" role="tabpanel" id="step1"
								style="margin-bottom: 50px">
								<div class="container">
									<div class="col-md-8 col-md-offset-3">
										<div class="col-md-12">
											<div class="update-nag element-animation1">
												<div class="update-split update-step1">
													<i class="glyphicon glyphicon-list"></i>
												</div>
												<div class="update-text">
													<strong>步驟一、</strong> 介紹建立課程有哪些流程?<a href="#"></a>
												</div>
											</div>
										</div>
										<div class="col-md-12">
											<div class="update-nag element-animation2">
												<div class="update-split update-step2">
													<i class="glyphicon glyphicon-picture"></i>
												</div>
												<div class="update-text">
													<strong>步驟二、</strong> 輸入課程標題、上傳課程封面、選擇課程種類<a href="#"></a>
												</div>
											</div>
										</div>

										<div class="col-md-12">
											<div class="update-nag element-animation3">
												<div class="update-split update-step3">
													<i class="glyphicon glyphicon-tags"></i>
												</div>
												<div class="update-text">
													<strong>步驟三、</strong> 設定課程學習目標<a href="#"></a>
												</div>
											</div>
										</div>


										<div class="col-md-12">
											<div class="update-nag element-animation4">
												<div class="update-split update-step4">
													<i class="glyphicon glyphicon-usd"></i>
												</div>
												<div class="update-text">
													<strong>步驟四、</strong> 設定課程銷售方式

												</div>
											</div>
										</div>

										<div class="col-md-12">
											<div class="update-nag element-animation5">
												<div class="update-split update-step5">
													<i class="glyphicon glyphicon-pencil"></i>
												</div>
												<div class="update-text">
													<strong>步驟五、</strong> 課程內容主要說明
												</div>
											</div>
										</div>

										<div class="col-md-12">
											<div class="update-nag element-animation6">
												<div class="update-split update-step6">
													<i class="glyphicon glyphicon-open"></i>
												</div>
												<div class="update-text">
													<strong>步驟六、</strong> 上傳影片
												</div>
											</div>
										</div>

										<div class="col-md-12">
											<div class="update-nag element-animation7">
												<div class="update-split update-step7">
													<i class="glyphicon glyphicon-thumbs-up"></i>
												</div>
												<div class="update-text">
													<strong>步驟七、</strong> 確認課程資料內容、送出審核
												</div>
											</div>
										</div>
									</div>
								</div>

								
								<!-- step1最終確認按鈕 -->
								<div class="col-md-offset-3" style="margin-top: 20px">
									<button type="button"
										class="btn btn-primary btn-lg btn3d col-md-offset-3 next-step">
										<span class="glyphicon glyphicon-hand-right"></span> 開始編輯課程
									</button>
								</div>
								<!-- 整個step1頁面 -->
							</div>

							<div class="tab-pane" role="tabpanel" id="step2">
								<!-- step2的填寫資料 -->
								<div>
									<!-- 預覽課程頁面圖 -->
									<div class="col-md-3 col-md-offset-2">
										<div class="row" style="margin-bottom: 25px">
											<label for="exampleInputEmail1" style="font-size: 20pt">課程標題</label>
											<input type="text" onfocus="this.select()"
												class="form-control" id="CourseInput"
												<c:if test="${!empty CoursedData}">value="${CoursedData.courseName}"</c:if>
												<c:if test="${empty CoursedData}">value="輸入課程標題"</c:if>
												style="font-size: 18px" name="courseName">
										</div>
										<div class="row" style="margin-bottom: 40px">
											<label for="exampleInputEmail1" style="font-size: 20pt">上傳課程封面</label>
											<input type="file" id="wizard-picture"
												style="font-size: 18px" name="picture"
												accept="image/png, image/jpeg, image/gif">
										</div>
										<div class="row" style="margin-bottom: 25px">
											<label for="exampleInputEmail1" style="font-size: 20pt">選擇課程類別(最多三項)</label>
											<div>
												<div style="font-size: 15pt" id="CourseClasscheckbox">

													<INPUT TYPE="checkbox" NAME="CourseClass" value="101">生活
													<INPUT TYPE="checkbox" NAME="CourseClass" value="102">藝術
													<INPUT TYPE="checkbox" NAME="CourseClass" value="103">運動
													<INPUT TYPE="checkbox" NAME="CourseClass" value="104">影音<br>
													<INPUT TYPE="checkbox" NAME="CourseClass" value="105">手作
													<INPUT TYPE="checkbox" NAME="CourseClass" value="106">其他
													<INPUT TYPE="checkbox" NAME="CourseClass" value="107">設計
													<INPUT TYPE="checkbox" NAME="CourseClass" value="108">科技<br>
													<INPUT TYPE="checkbox" NAME="CourseClass" value="109">商業
													<INPUT TYPE="checkbox" NAME="CourseClass" value="110">語言
													<INPUT TYPE="checkbox" NAME="CourseClass" value="111">烹飪
													<INPUT TYPE="checkbox" NAME="CourseClass" value="112">程式

												</div>
											</div>
										</div>
									</div>

									<div class="col-md-3 col-md-offset-2">
										<div style="width: 310px">
											<div class="card card-inverse">
												<img class="card-img-top"
													<c:if test="${!empty CoursedData}">src="<%=request.getContextPath()%>/CourseImage?CourseID=${CourseID}"</c:if>
													<c:if test="${empty CoursedData}">src="<%=request.getContextPath()%>/Class Steps/imgs/請上傳課程封面.png"</c:if>
													alt="您的圖片連結已失效" id="wizardPicturePreview" title="">
												<div class="card-block">
													<figure class="profile">
														<img
															src="<%=request.getContextPath()%>/Image?MemberID=${LoginOK.memberID}"
															class="profile-avatar" alt="">
													</figure>
													<div class="card-text">
														<p id="title" class="card-title multi_ellipsis">${CoursedData.courseName}</p>
													</div>
													<div>
														<p style="margin-top: 40px; font-size: 18px">課程售價：xxx元</p>
													</div>
												</div>
												<div class="card-footer">												
													<small>課程時間:yyy分鐘</small> <br> <small>購買人數:zzz人</small>

												</div>
											</div>
										</div>
									</div>

									<!-- 包住step2填寫資料 -->
								</div>

								<ul class="list-inline col-md-6 pull-right"
									style="margin-top: 50px; margin-bottom: 80px;">
									<li class="pull-right"><button type="button"
											class="btn btn-primary btn-lg btn3d next-step">儲存並前往下一步</button></li>
									<li class="pull-right"><button type="button"
											class="btn3d btn btn-default btn-lg prev-step">上一步</button></li>
								</ul>

							</div>



							<!-- 包住step3填寫資料 -->
							<div class="tab-pane" role="tabpanel" id="step3">
								<div class="[ container ]">
									<div class="[ row ]">
										<div class="col-xs-12 alert alert-info">
											<div style="font-size: 20px; font-weight: bold;">
												學生會需要用到的工具（含種類、版本細節）</div>
											<div class="[ form-group ][ form-group-textarea ]">
												<textarea name="preTool" placeholder="請輸入課程中，可能會使用到的工具"
													data-toggle="floatLabel" class="form-control"
													data-value="no-js" style="font-size: 18px"
													form="TotalContent">${CoursedData.preTool}</textarea>
												<label for="customStyle" style="">(例：Photoshop CC
													2015)</label>
											</div>
										</div>
									</div>
								</div>

								<div class="[ container ]">
									<div class="[ row ]">
										<div class="[ col-xs-12 ] alert alert-info">
											<div style="font-size: 20px; font-weight: bold;">
												學這堂課之前，學生需要具有哪些背景知識？</div>
											<div class="[ form-group ][ form-group-textarea ]">
												<textarea name="background"
													placeholder="如果是比較進階的課程，建議先跟學生說明必備的知識，幫助學生了解這堂課"
													class="form-control" data-toggle="floatLabel"
													data-value="no-js" style="font-size: 18px"
													form="TotalContent">${CoursedData.background}</textarea>
												<label for="customStyle" style="">(例：學過PS遮罩的概念)</label>
											</div>
										</div>
									</div>
								</div>

								<div class="[ container ]">
									<div class="[ row ]">
										<div class="[ col-xs-12 ] alert alert-info">
											<div style="font-size: 20px; font-weight: bold;">
												學完這堂課後，學生可以做出什麼東西？</div>
											<div class="[ form-group ][ form-group-textarea ]">
												<textarea name="ability"
													placeholder="最好是某種實質的東西：像是完成某種作品、達到哪種目標甚至是得到什麼結果"
													class="form-control" data-toggle="floatLabel"
													data-value="no-js" style="font-size: 18px"
													form="TotalContent">${CoursedData.ability}</textarea>
												<label for="customStyle" style="">(例：可習得合成影像的基本技術)</label>
											</div>
										</div>
									</div>
								</div>

								<div class="[ container ]">
									<div class="[ row ]">
										<div class="[ col-xs-12 ] alert alert-info">
											<div style="font-size: 20px; font-weight: bold;">
												哪些人適合這堂課？</div>
											<div class="[ form-group ][ form-group-textarea ]">
												<textarea name="targetgroup"
													placeholder="形容這堂課適合的學生族群，可以更讓學生了解課程內容的方向"
													class="form-control" data-toggle="floatLabel"
													data-value="no-js" style="font-size: 18px"
													form="TotalContent">${CoursedData.targetgroup}</textarea>
												<label for="customStyle" style="">(例：雜誌編輯、海報設計的美編人員等...)</label>
											</div>
										</div>
									</div>
								</div>

								<ul class="list-inline pull-right" style="margin-bottom: 80px">
									<li><button type="button"
											class="btn3d btn btn-default btn-lg prev-step">上一步</button></li>
									<li><button type="button"
											class="btn3d btn btn-default btn-lg next-step">跳過此步驟</button></li>
									<li><button type="button"
											class="btn btn-primary btn-lg btn3d next-step">儲存並前往下一步</button></li>
								</ul>
							</div>

							<div class="tab-pane" role="tabpanel" id="step4">
								<div class="[ container ]">
									<div class="col-md-6">
										<div class="col-md-6">
											<div class="funkyradio" id="CourseList" onchange="select()">
												<div class="radio-free" style="font-size: 20px;">
													<input type="radio" name="radio" id="radio1" value="radio1" />
													<label for="radio1">免費課程</label>
												</div>
												<div class="radio-online" style="font-size: 20px;">
													<input type="radio" name="radio" id="radio3" value="radio3" />
													<label for="radio3">線上課程</label>
												</div>
												<div class="radio-proposal" style="font-size: 20px;">
													<input type="radio" name="radio" id="radio2" value="radio2" />
													<label for="radio2">募資課程</label>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="container alert alert-info" style="margin-top: 2em;">
									<div class="col-md-12">
										<div class="form-group col-lg-4" style="font-size: 20px;">
											<label>定價(最低售價為$10元)</label> <input type="text"
												name="soldPrice" class="form-control" id="soldPrice"
												value="${CoursedData.soldPrice}" style="font-size: 18px;">
											<p id="soldPricewarning" style="color: red"></p>
										</div>

										<div class="form-group col-lg-4" style="font-size: 20px;">
											<label>預計課程長度(以分鐘為單位)</label> <input type="text"
												name="courseLength" class="form-control" id=""
												value="${CoursedData.courseLength}" style="font-size: 18px;">
										</div>
									</div>
								</div>
								<div class="container alert alert-info" style="margin-top: 2em; font-size: 18px;"
									id="ProposalCourse">
									<div class="col-md-12">
										<div class="form-group col-lg-4" style="font-size: 20px;">
											<label>開課門檻人數(最低為10人)</label> <input type="text"
												name="targetStudentNumber" class="form-control" id="targetStudentNumber"
												value="${CoursedData.targetStudentNumber}"
												style="font-size: 18px;">
											<p id="targetStudentNumberwarning" style="color: red"></p>
										</div>
									</div>
									<div class="form-group col-md-12 date" style="margin-top: 2em;" data-date=""
												data-date-format="yyyy-mm-dd" data-link-field="dtp_input1"
												data-link-format="yyyy-mm-dd">
										<div class="form-group col-lg-4" style="font-size: 20px;">
											<label>募資起始日期</label>											
												<input class="form-control" style="font-size: 18px;"
													type="text" value="${CoursedData.fundStartDate}" readonly
													size="20" id="starttime" name="fundStartDate">
										</div>
										<div class="form-group col-lg-4" style="font-size: 20px;">
											<label>募資結束日期</label>
												<input class="form-control" style="font-size: 18px;"
													type="text" value="${CoursedData.fundEndDate}" readonly
													size="20" id="endtime" name="fundEndDate">
										</div>
									</div>
									<div class="col-md-12" style="margin-top: 2em;">
										<div class="form-group col-lg-4" style="font-size: 20px;">
											<label>備課天數</label><input
												type="text" name="" class="form-control" id="prepareDate"
												value="" style="font-size: 18px">
										</div>
									</div>
									<div class="col-md-12" style="margin-top: 0.5em;">
										<div class="form-group col-lg-4" style="font-size: 20px;">
											<label>課程預計上線日期：</label><input type="hidden"
												id="endofproposal" name="courseStartDate"
												value="${CoursedData.courseStartDate}"><span></span>
										</div>
									</div>
								</div>
								<ul class="list-inline pull-right" style="margin-bottom: 80px">
									<li><button type="button"
											class="btn3d btn btn-default btn-lg prev-step">上一步</button></li>
									<li><button type="button"
											class="btn btn-primary btn-lg btn3d next-step">儲存並前往下一步</button></li>
								</ul>

							</div>

							<div class="tab-pane" role="tabpanel" id="step5">
								<div class="[ container ]">
									<div class="[ row ]">
										<div class="[ col-xs-12 ]">
											<div class="alert alert-info"
												style="font-size: 20px; font-weight: bold;">
												課程內容說明
												<div style="color: black; font-size: 18px">趕緊來為你精心設計的課程做個介紹吧!請務必在文案中加上開課緣由、自我介紹、課程單元說明、教學方式、課程難易度、相關作品圖片、作品集網站…等資料，越詳細的內容將會提升學生對課程的信任感；而善用編輯排版功能，讓提案更加吸引人！
												</div>
											</div>
											<div class="[ form-group ][ form-group-textarea ]"
												id="get-data-form">
												<textarea class="tinymce" id="texteditor"	
													data-toggle="floatLabel" data-value="no-js"
													style="font-size: 18px" form="TotalContent">${CoursedData.courseContent}</textarea>
												<input name="image" type="file" id="upload" class="hidden" onchange="">
												<input name="courseContent" type="hidden" value="" id="courseContent">
											</div>
										</div>
									</div>
								</div>



								<ul class="list-inline pull-right" style="margin-bottom: 80px">
									<li><button type="button"
											class="btn3d btn btn-default btn-lg prev-step">上一步</button></li>
									<li><button type="button"
											class="btn btn-primary btn-lg btn3d next-step">儲存並前往下一步</button></li>
								</ul>
							</div>

							<div class="tab-pane" role="tabpanel" id="step6">
								<div class="container alert alert-info">
									<div class="row">
										<div class="col-md-12">
											<div class="panel panel-default">
												<div class="panel-heading">
													<strong>影片上傳</strong> <small> </small>
												</div>
												<div class="panel-body">
													<div class="input-group image-preview">
														<!-- don't give a name === doesn't send on POST/GET -->
														<span> <!-- image-preview-clear button --> <input
															type="hidden" id="filename1" value=""> <span></span>
															<div class="btn btn-default image-preview-input">
																<span class="glyphicon glyphicon-folder-open"></span> <span
																	class="image-preview-input-title">選擇檔案</span> <input
																	type="file" name="video" id="inputfilename1"
																	onclick="fileSelect()" />
																<!-- rename it -->
															</div>
															<button id="btnSubmit1" type="submit"
																class="btn btn-labeled btn-primary"
																onclick="bottonClick()">
																<span class="btn-label"><i
																	class="glyphicon glyphicon-upload"></i></span>上傳
															</button>
														</span>
													</div>
													<!-- /input-group image-preview [TO HERE]-->
													<br />
													<!-- Drop Zone -->
													<!-- Progress Bar -->
													<div class="progress">
														<div id="progressBar1" class="progress-bar"
															role="progressbar1" aria-valuenow="0" aria-valuemin="0"
															aria-valuemax="100" style="width: 0%;">
															<!-- 															60% <span class="sr-only">60% Complete</span> -->
														</div>
													</div>
													<br />
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- /container -->
								<div class="container alert alert-info">
									<div class="row">
										<div class="col-md-12">
											<div class="panel panel-default">
												<div class="panel-heading">
													<strong>課程講義上傳</strong> <small> </small>
												</div>
												<div class="panel-body">
													<div class="input-group image-preview">
														<!-- don't give a name === doesn't send on POST/GET -->
														<span> <!-- image-preview-clear button --> <input
															type="hidden" id="filename2" value=""> <span></span>
															<div class="btn btn-default image-preview-input">
																<span class="glyphicon glyphicon-folder-open"></span> <span
																	class="image-preview-input-title">選擇檔案</span> <input
																	type="file" name="paper" id="inputfilename2"
																	onclick="fileSelect()" />
																<!-- rename it -->
															</div>
															<button id="btnSubmit2" type="submit"
																class="btn btn-labeled btn-primary"
																onclick="bottonClick1()">
																<span class="btn-label"><i
																	class="glyphicon glyphicon-upload"></i></span>上傳
															</button>
														</span>
													</div>
													<!-- /input-group image-preview [TO HERE]-->
													<br />
													<!-- Drop Zone -->
													<!-- Progress Bar -->
													<div class="progress">
														<div id="progressBar2" class="progress-bar"
															role="progressbar2" aria-valuenow="0" aria-valuemin="0"
															aria-valuemax="100" style="width: 0%;">
															<!-- 															60% <span class="sr-only">60% Complete</span> -->
														</div>
													</div>
													<br />
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- /container -->

								<ul class="list-inline pull-right" style="margin-bottom: 80px">
									<li><button type="button"
											class="btn3d btn btn-default btn-lg prev-step">上一步</button></li>
									<li><button type="button" id="getProposalData"
											class="btn btn-primary btn-lg btn3d next-step">儲存並前往下一步</button></li>
								</ul>
							</div>

							<div class="tab-pane" role="tabpanel" id="complete">
								<div class="container">
									<div class="row col-list">
										<div class="col-md-4 t1">
											<div class="col-head text-center">
												
												<span class="glyphicon glyphicon-paperclip"
													aria-hidden="true"></span>
												<h2>課程簡介</h2>
											</div>
											<ul class="list-unstyled">
												<li>
													<p class="option" id="courseNameJSON">課程名稱：</p>
												</li>
												<li>
													<p class="option" id="courseClassJSON">課程類別：</p>
												</li>
												<li>
													<p class="option" id="preToolJSON">所需工具：</p>
												</li>
												<li>
													<p class="option" id="targetgroupJSON">適合族群：</p>
												</li>
												<li><p></p></li>

											</ul>
										</div>
										<div class="col-md-4 t2">
											<div class="col-head text-center">
												<span class="glyphicon glyphicon-eye-open"
													aria-hidden="true"></span>
												<h2>銷售方式</h2>
											</div>
											<ul class="list-unstyled">
												<li>
													<p class="option" id="soldPriceJSON">銷售金額：</p>
												</li>
												<li>
													<p class="option" id="fundDateDurationJSON">募資起迄時間：</p>
												</li>
												<li>
													<p class="option" id="courseStartDateJSON">開課日期：</p>
												</li>
												<li><p></p></li>
											</ul>
										</div>
										<div class="col-md-4 t3">
											<div class="col-head text-center">
												<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
												<h2>檔案內容</h2>
											</div>
											<ul class="list-unstyled">
												<li>
													<p class="option" id="courseVideoNameJSON">影片檔名：</p>
												</li>
												<li>
													<p class="option" id="courseLengthJSON">課程長度：</p>
												</li>
												<li><p></p></li>
											</ul>
										</div>
									</div>
								</div>



								<div class="col-md-offset-4" style="margin-top: 80px">
									<ul class="list-inline" style="margin-bottom: 80px">
										<li><button type="button"
												class="btn3d btn btn-default btn-lg prev-step">上一步</button></li>
										<li>
										<button type="button" class="btn btn-primary btn-lg btn3d next-step" data-toggle="modal" data-target="#ConfirmBotton">
										<span class="glyphicon glyphicon-ok"></span>  完成課程編輯並送出審核
										</button></li>
									</ul>
								</div>
								<div class="clearfix"></div>
							</div>
					</form>
				</div>
			</section>
		</div>
	</div>


<!-- 模態框========================================================================================================================== -->
<div class="modal fade" id="ConfirmBotton" tabindex="-1" role="dialog" aria-labelledby="ConfirmTitleLabel" aria-hidden="true" style="left: 50%;top: 50%;transform: translate(-50%,-50%);">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close pull-right" data-dismiss="modal" 
						aria-hidden="true">×
				</button>
				<h4 class="modal-title" id="ConfirmTitleLabel" style="text-align: center;">
					恭喜您!  即將完成課程編輯流程!
				</h4>
			</div>
			<div class="modal-body" style="text-align: center;">
				再次請您確認內容是否無誤? 若內容確認完畢，可點選"提交"，我們會盡快通知您審核結果
			</div>
			<div class="modal-footer" style="text-align: center;">
				<button type="button" class="btn btn-danger" 
						data-dismiss="modal"><i class="glyphicon glyphicon-remove"></i>&nbsp;&nbsp;取消
				</button>
				<a href="<%=request.getContextPath()%>/HOME.jsp"><button type="button" class="btn btn-success" id="FinalConfirm"><i class="glyphicon glyphicon-ok"></i>
				&nbsp;&nbsp;提交
				</button></a>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- ====================================================================================================================================== -->

	<script>
		$(document).ready(function() {
			//Initialize tooltips
			$('.nav-tabs > li a[title]').tooltip();

			//Wizard
			$('a[data-toggle="tab"]').on('show.bs.tab', function(e) {

				var $target = $(e.target);

				if ($target.parent().hasClass('disabled')) {
					return false;
				}
			});

			$(".next-step").click(function(e) {

				var $active = $('.wizard .nav-tabs li.active');
				$active.next().removeClass('disabled');
				nextTab($active);

			});
			$(".prev-step").click(function(e) {

				var $active = $('.wizard .nav-tabs li.active');
				prevTab($active);

			});
		});

		function nextTab(elem) {
			$(elem).next().find('a[data-toggle="tab"]').click();
		}
		function prevTab(elem) {
			$(elem).prev().find('a[data-toggle="tab"]').click();
		}

		//according menu

		$(document).ready(
				function() {
					//Add Inactive Class To All Accordion Headers
					$('.accordion-header').toggleClass('inactive-header');

					//Set The Accordion Content Width
					var contentwidth = $('.accordion-header').width();
					$('.accordion-content').css({});

					//Open The First Accordion Section When Page Loads
					$('.accordion-header').first().toggleClass('active-header')
							.toggleClass('inactive-header');
					$('.accordion-content').first().slideDown().toggleClass(
							'open-content');

					// The Accordion Effect
					$('.accordion-header').click(
							function() {
								if ($(this).is('.inactive-header')) {
									$('.active-header').toggleClass(
											'active-header').toggleClass(
											'inactive-header').next()
											.slideToggle().toggleClass(
													'open-content');
									$(this).toggleClass('active-header')
											.toggleClass('inactive-header');
									$(this).next().slideToggle().toggleClass(
											'open-content');
								}

								else {
									$(this).toggleClass('active-header')
											.toggleClass('inactive-header');
									$(this).next().slideToggle().toggleClass(
											'open-content');
								}
							});

					return false;
				});

		$("#wizard-picture").change(function() {
			readURL(this);
		});

		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$('#wizardPicturePreview').attr('src', e.target.result)
							.fadeIn('slow');
				}
				reader.readAsDataURL(input.files[0]);
			}
		}

		$(document)
				.ready(
						function() {
							$('input[type=checkbox]')
									.click(
											function() {
												$("input[name='CourseClass']")
														.attr('disabled', true);
												if ($("input[name='CourseClass']:checked").length >= 3) {
													$(
															"input[name='CourseClass']:checked")
															.attr('disabled',
																	false);
												} else {
													$(
															"input[name='CourseClass']")
															.attr('disabled',
																	false);
												}
											});

						})

		$("#CourseInput").keyup(function() {
			var value = $(this).val();
			$("#title").text(value);
		});

		$(document).ready(
				function() {
					// Floating Labels
					//==============================================================
					$('[data-toggle="floatLabel"]').attr('data-value',
							$(this).val()).on('keyup change', function() {
						$(this).attr('data-value', $(this).val());
					});
				});

		$('textarea').each(function() {
			autosize(this);
		}).on('autosize:resized');
//募資選擇日期，避免起始日期大於結束日期=====================================================================
		function checkEndTime(starttime, endtime) {
			var starttime = $("#starttime").val();
			var endtime = $("#endtime").val();
			if (endtime < starttime && starttime+30 < endtime) {
				return false;
			} else {
				return true;
			}
		};
//========================================================================================================
//日曆選擇器(起始日期、結束日期)=============================================================================		
	$(function() {
			$('#starttime').datetimepicker({
				language : 'zh-TW',
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				startView : 2,
				minView : 2,
				forceParse : 0,
				defaultDate:new Date() ,
				format : 'yyyy-mm-dd'
			}).on('changeDate', function(ev) {
				var starttime = $('#starttime').val();
				$('#endtime').datetimepicker('setStartDate', starttime);
				$('#starttime').datetimepicker('hide');
			});

			$('#endtime').datetimepicker({
				language : 'zh-TW',
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				startView : 2,
				minView : 2,
				forceParse : 0,
				format : 'yyyy-mm-dd'
			}).on('changeDate', function(ev) {
				var starttime = $('#starttime').val();
				var endtime = $('#endtime').val();

				if (starttime != "" && endtime != "") {
					if (!checkEndTime(starttime, endtime)) {
						$('#endtime').val('');
						alert("請輸入正確的日期範圍");
						return;
					}
				}
				$('#starttime').datetimepicker('setEndDate', endtime);
				$('#starttime').datetimepicker('hide');
			});

		});
//=============================================================================================================
//自動計算出備課天數加上結束日期後，換算日期是幾號==================================================================
	$("#prepareDate").keyup(
				function() {
					var endtime = $('#endtime').val();
					var Dates = new Date(endtime);
					var prepareDate = $(this).val();
					Dates = Dates.valueOf();
					Dates = Dates + (prepareDate * 24 * 60 * 60 * 1000); // 一天幾豪秒
					Dates = new Date(Dates);
					$("#endofproposal").val(
							Dates.getFullYear() + "-" + (Dates.getMonth() + 1)
									+ "-" + Dates.getDate());
					$("#endofproposal+span").text(
							Dates.getFullYear() + "-" + (Dates.getMonth() + 1)
									+ "-" + Dates.getDate());
				});
//==============================================================================================================
		function select() {
			var selectr = document.querySelector("#CourseList input:checked").value;
			if (selectr === "radio1") {
				$("#soldPrice").val("0");
				document.querySelector("#soldPrice").setAttribute("readonly",
						"readonly");
				document.querySelector("#ProposalCourse").style = "opacity: 0.4;font-size: 18px;margin-top: 2em;";
				document.querySelectorAll("#ProposalCourse input").forEach(
						function(el) {
							el.setAttribute("disabled", "disabled");
							el.style = "opacity: 0;font-size: 18px;";
						})
				var formData = new FormData($('form')[3]);
				console.log("課程銷售方式(免費)送到資料庫囉!");
				$
						.ajax({
							type : 'POST',
							url : '/e-Look/com.e_Look.Course.control/CourseEditControlloer',
							data : formData,
							processData : false,
							contentType : false,
							success : function() {
								delay_till_last('id', function() {
									$('#updateConfirm').text("變更已儲存至草稿");
									$("#updateConfirm").fadeIn(1200);

									$("#updateConfirm").fadeOut(1500);

								}, 1000);
							}
						})

			}
			if (selectr === "radio3") {
				$("#soldPrice").val("10");
				$('#targetStudentNumber').val("0");
				$('#targetStudentNumberwarning').empty();
				document.querySelector("#soldPrice")
						.removeAttribute("readonly");
				document.querySelector("#ProposalCourse").style = "opacity: 0.4;font-size: 18px;margin-top: 2em;";
				document.querySelectorAll("#ProposalCourse input").forEach(
						function(el) {
							el.setAttribute("disabled", "disabled");
							el.style = "opacity: 0;font-size: 18px;";
						})
						var formData = new FormData($('form')[3]);
				console.log("課程銷售方式(線上)送到資料庫囉!");
				$
						.ajax({
							type : 'POST',
							url : '/e-Look/com.e_Look.Course.control/CourseEditControlloer',
							data : formData,
							processData : false,
							contentType : false,
							success : function() {
								delay_till_last('id', function() {
									$('#updateConfirm').text("變更已儲存至草稿");
									$("#updateConfirm").fadeIn(1200);

									$("#updateConfirm").fadeOut(1500);

								}, 1000);
							}
						})
			}
			if (selectr === "radio2") {
				$("#soldPrice").val("10");
				$("#targetStudentNumber").val("10");
				document.querySelector("#soldPrice")
						.removeAttribute("readonly");
				document.querySelector("#ProposalCourse").style = "opacity: 1;font-size: 18px;margin-top: 2em;";
				document.querySelectorAll("#ProposalCourse input").forEach(
						function(el) {
							el.removeAttribute("disabled");
							el.style = "opacity: 1;font-size: 18px;";
						})
						var formData = new FormData($('form')[3]);
				console.log("課程銷售方式(募資)送到資料庫囉!");
				$
						.ajax({
							type : 'POST',
							url : '/e-Look/com.e_Look.Course.control/CourseEditControlloer',
							data : formData,
							processData : false,
							contentType : false,
							success : function() {
								delay_till_last('id', function() {
									$('#updateConfirm').text("變更已儲存至草稿");
									$("#updateConfirm").fadeIn(1200);

									$("#updateConfirm").fadeOut(1500);

								}, 1000);
							}
						})
			}
		};

		$('#inputfilename1').change(
				function() {
					$('#filename1').attr("class",
							"btn btn-default image-preview-input");
					var value = $('#inputfilename1').val();
					console.log(value);
					$('#filename1').val(value);
					$('#filename1+span').text(value);
				})
		$('#inputfilename2').change(
				function() {
					$('#filename2').attr("class",
							"btn btn-default image-preview-input");
					var value = $('#inputfilename2').val();
					console.log(value);
					$('#filename2').val(value);
					$('#filename2+span').text(value);
				})

		$('input[type!="file"],input[type!="radio"]')
				.keyup(
						function(e) {

							var formData = new FormData($('form')[3]);
							console.log("從input欄位送資料到資料庫囉!");
							$
									.ajax({
										type : 'POST',
										url : '/e-Look/com.e_Look.Course.control/CourseEditControlloer',
										data : formData,
										processData : false,
										contentType : false,
										success : function() {
											delay_till_last('id', function() {
												$('#updateConfirm').text(
														"變更已儲存至草稿");
												$("#updateConfirm")
														.fadeIn(1200);

												$("#updateConfirm").fadeOut(
														1500);

											}, 1000);
										},
										error : function() {
											alert("請輸入正確的格式!");
										}
									})
						})

		$('textarea')
				.keyup(
						function(e) {

							var formData = new FormData($('form')[3]);
							console.log("從textarea欄位送資料到資料庫囉!");
							$
									.ajax({
										type : 'POST',
										url : '/e-Look/com.e_Look.Course.control/CourseEditControlloer',
										data : formData,
										processData : false,
										contentType : false,
										success : function() {
											delay_till_last('id', function() {
												$('#updateConfirm').text(
														"變更已儲存至草稿");
												$("#updateConfirm")
														.fadeIn(1200);

												$("#updateConfirm").fadeOut(
														1500);

											}, 1000);
										}
									})
						})

		$('#wizard-picture')
				.change(
						function(e) {

							var formData = new FormData($('form')[3]);
							console.log("圖片送到資料庫囉!");
							$
									.ajax({
										type : 'POST',
										url : '/e-Look/com.e_Look.Course.control/CourseEditControlloer',
										data : formData,
										processData : false,
										contentType : false,
										success : function() {
											delay_till_last('id', function() {
												$('#updateConfirm').text(
														"變更已儲存至草稿");
												$("#updateConfirm")
														.fadeIn(1200);

												$("#updateConfirm").fadeOut(
														1500);

											}, 1000);
										}
									})
						})
$(document).ready(function(){
$('#starttime,#endtime').change(function(e) {

			var formData = new FormData($('form')[3]);
			console.log("送到資料庫囉!");
			$
					.ajax({
						type : 'POST',
						url : '/e-Look/com.e_Look.Course.control/CourseEditControlloer',
						data : formData,
						processData : false,
						contentType : false,
						success : function() {
							delay_till_last('id', function() {
								$('#updateConfirm').text(
										"日期變更已儲存至草稿");
								$("#updateConfirm")
										.fadeIn(1200);

								$("#updateConfirm").fadeOut(
										1500);

							}, 1000);
						}
					})
		})
})


		$('#inputfilename2')
				.change(
						function(e) {

							var formData = new FormData($('form')[3]);
							console.log("講義送到資料庫囉!");
							$
									.ajax({
										type : 'POST',
										url : '/e-Look/com.e_Look.Course.control/CourseEditControlloer',
										data : formData,
										processData : false,
										contentType : false,
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

			
		//用goGet方法送到CourseEditControlloer，取得目前資料庫存入的課程內容	
		$('#getProposalData,#getProposalData2').click(function() {
			$.getJSON('/e-Look/com.e_Look.Course.control/CourseEditControlloer', {
				'courseID' : $('#courseID').val(),"getProposalData":"XXXXXXXX"
			}, function(datas) {
				console.log(datas);
				if(datas.targetgroup !=null){
					$('#targetgroupJSON').text("適合族群："+datas.targetgroup);
 					$('#targetgroupJSON').css( "color", "black" );
				}else{					
 					$('#targetgroupJSON').text("適合族群：尚未填寫相關資訊");
 					$('#targetgroupJSON').css( "color", "red" );
				}
				if(datas.courseName !=null){
					$('#courseNameJSON').text("課程名稱："+datas.courseName);
 					$('#courseNameJSON').css( "color", "black" );
				}else{				
 					$('#courseNameJSON').text("課程名稱：尚未填寫相關資訊");
 					$('#courseNameJSON').css( "color", "red" );
				}
				if(datas.preTool !=null){
					$('#preToolJSON').text("所需工具："+datas.preTool);
 					$('#preToolJSON').css( "color", "black" );
				}else{					
 					$('#preToolJSON').text("所需工具：尚未填寫相關資訊");
 					$('#preToolJSON').css( "color", "red" );
				}
				if(datas.soldPrice !=null){
					$('#soldPriceJSON').text("銷售金額："+datas.soldPrice+"元");
 					$('#soldPriceJSON').css( "color", "black" );
				}else{					
 					$('#soldPriceJSON').text("銷售金額：尚未填寫相關資訊");
 					$('#soldPriceJSON').css( "color", "red" );
				}
				if(datas.fundStartDate !=null){
					$('#fundDateDurationJSON').text("募資起迄時間："+datas.fundStartDate+" ~ "+datas.fundEndDate);
 					$('#fundDateDurationJSON').css( "color", "black" );
				}else{					
 					$('#fundDateDurationJSON').text("募資起迄時間：填寫資訊不完整");
 					$('#fundDateDurationJSON').css( "color", "red" );
				}
				if(datas.fundEndDate !=null){
					if(datas.targetStudentNumber ==0){
						$('#fundDateDurationJSON').text("募資起迄時間：無須填寫");
	 					$('#fundDateDurationJSON').css( "color", "black" );
					}else{
					$('#fundDateDurationJSON').text("募資起迄時間："+datas.fundStartDate+" ~ "+datas.fundEndDate);
 					$('#fundDateDurationJSON').css( "color", "black" );}
				}else{
					if(datas.targetStudentNumber ==0){
						$('#fundDateDurationJSON').text("募資起迄時間：無須填寫");
	 					$('#fundDateDurationJSON').css( "color", "black" );
					}else{
 					$('#fundDateDurationJSON').text("募資起迄時間：填寫資訊不完整");
 					$('#fundDateDurationJSON').css( "color", "red" );
					}
				}

				
				if(datas.courseStartDate !=null){
					if(datas.targetStudentNumber ==0){
						$('#courseStartDateJSON').text("開課日期：待審核通過立即開課");
	 					$('#courseStartDateJSON').css( "color", "black" );
					}else{
					$('#courseStartDateJSON').text("開課日期："+datas.courseStartDate);
 					$('#courseStartDateJSON').css( "color", "black" );
					}
				}else{
					if(datas.targetStudentNumber ==0){
						$('#courseStartDateJSON').text("開課日期：待審核通過立即開課");
	 					$('#courseStartDateJSON').css( "color", "black" );
					}else{
 					$('#courseStartDateJSON').text("開課日期：尚未填寫相關資訊");
 					$('#courseStartDateJSON').css( "color", "red" );
					}
				}
				if(datas.courseVideopathway !=null){
					$('#courseVideoNameJSON').text("上傳影片檔名："+datas.courseVideopathway);
 					$('#courseVideoNameJSON').css( "color", "black" );
				}else{					
 					$('#courseVideoNameJSON').text("上傳影片檔名：尚未上傳相關檔案");
 					$('#courseVideoNameJSON').css( "color", "red" );
				}
				if(datas.courseLength ==""){
					$('#courseLengthJSON').text("影片長度：尚未填寫相關資訊");
 					$('#courseLengthJSON').css( "color", "red" );
				}else{
					$('#courseLengthJSON').text("影片長度："+datas.courseLength+"分鐘");
 					$('#courseLengthJSON').css( "color", "black" );
				}									
			})
		})
		//======================================================
			
			
			
			
		//用goGet方法送到GetCourseClass，取得目前資料庫課程所屬的類別
		$('#getProposalData,#getProposalData2').click(function(){
			var courseClass="";
			$.ajax({'url':'<%=request.getContextPath() %>/GetCourseClass',
				'async':false,
				'data':{'courseID':$('#courseID').val()},
				'success':function(result){
					courseClass = result;
					if(courseClass !=""){
						$('#courseClassJSON').text("課程所屬類別："+courseClass);
						$('#courseClassJSON').css( "color", "black" );
					}else{
						$('#courseClassJSON').text("課程所屬類別：尚未勾選相關資訊");
						$('#courseClassJSON').css( "color", "red" );
					}
										
				}
		});//$.ajax end
	
		})		
						
		
		//===============================================================
			
			//當checkbox改變傳送表單
			$(':checkbox')
				.change(
						function(e) {

							var formData = new FormData($('form')[3]);
							console.log("從checkbox送課程類別送到資料庫囉!");
							$
									.ajax({
										type : 'POST',
										url : '/e-Look/com.e_Look.Course.control/CourseEditControlloer',
										data : formData,
										processData : false,
										contentType : false,
										success : function() {
											delay_till_last('id', function() {
												$('#updateConfirm').text(
														"變更已儲存至草稿");
												$("#updateConfirm")
														.fadeIn(1200);

												$("#updateConfirm").fadeOut(
														1500);

											}, 1000);
										}
									})
						})
//===============================================================
	
$('#soldPrice').keyup(function(){
		if($('#soldPrice').val()<10){
			$('#soldPricewarning').text("請輸入大於10的數字")
		}else{
			$('#soldPricewarning').text("")
		}
	})
$('#targetStudentNumber,#soldPrice').keyup(function(){
	if($('#targetStudentNumber').val()!=0){
		if($('#targetStudentNumber').val()<10){
			$('#targetStudentNumberwarning').text("請輸入大於10的數字");
			$('#targetStudentNumberwarning').css(  "color", "red" );
		}
		else{
			$('#targetStudentNumberwarning').css( "color", "black" );
			$('#targetStudentNumberwarning').text(("當達到開課門檻人數，講師可獲得："+parseInt($('#targetStudentNumber').val()*0.56*($('#soldPrice').val()))+"元，    作為開課的資金成本"));
		}
	}else {
		$('#targetStudentNumberwarning').text("");
		$('#targetStudentNumberwarning').empty();
	}
		
	})
	//課程送出前警告視窗=================================					
	$('#FinalConfirm').click(function(){
		$.get('/e-Look/com.e_Look.Course.control/CourseEditControlloer', {
			'courseID' : $('#courseID').val()
		}, function() {
		})
	})
	//===============================================
		
	$(document).ready(function() {
			  tinymce.init({
			    selector: "#texteditor",
			    language_url:'<%=request.getContextPath()%>/_PJC/tinymce/js/tinymce/langs/zh_TW.js',
			    height : "500px",
			    theme: "modern",
			    paste_data_images: true,
			    plugins: [
			      "advlist autolink lists link image charmap print preview hr anchor pagebreak",
			      "searchreplace wordcount visualblocks visualchars code fullscreen",
			      "insertdatetime media nonbreaking save table contextmenu directionality",
			      "emoticons template paste textcolor colorpicker textpattern"
			    ],
			    toolbar1: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
			    toolbar2: "print preview media | forecolor backcolor emoticons",
			    image_advtab: true,
			    file_picker_callback: function(callback, value, meta) {
			      if (meta.filetype == 'image') {
			        $('#upload').trigger('click');
			        $('#upload').on('change', function() {
			          var file = this.files[0];			         
			          var reader = new FileReader();
			          reader.onload = function(e) {
			            callback(e.target.result, {
			              alt: ''
			            });
			          };
			          reader.readAsDataURL(file);
			        });
			      }
			    },
			    templates: [{
			      title: 'Test template 1',
			      content: 'Test 1'
			    }, {
			      title: 'Test template 2',
			      content: 'Test 2'
			    }],
			    toolbar_items_size:'large',
			    setup : function(ed) {
					ed.on('keyup',function(e) {
										//console.log(ed.getContent());
										$("#courseContent").val(ed.getContent());
										var formData = new FormData($('form')[3]);
										console.log("從文字編輯器欄位送資料到資料庫囉!");
										$.ajax({
												type : 'POST',
												url : '/e-Look/com.e_Look.Course.control/CourseEditControlloer',
												data : formData,
												processData : false,
												contentType : false,
												success : function() {delay_till_last('id',
																function() {
																	$('#updateConfirm').text("變更已儲存至草稿");
																	$("#updateConfirm").fadeIn(1200);
																	$("#updateConfirm").fadeOut(1500);
																}, 1000);
													}

												});
									});
				}
			  });
		
		
		});
	</script>



</body>

</html>