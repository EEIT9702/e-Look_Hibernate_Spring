<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>募資課程</title>
<link href="<%=request.getContextPath()%>/HeaderCssJs/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>


<link href="<%=request.getContextPath()%>/css/documentation.css" />

<script src="<%=request.getContextPath()%>/js/raphael.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.classyled.min.js"></script>
<link rel="Short Icon" type="image/x-icon" href="${initParam.icon}" />
<style>
/* 影片區塊 */
video {
	width: 100%;
	height: 100%;
}

#videoArea {
	background-size: cover;
	background-position: center;
	height: 560px;
}

video::-internal-media-controls-download-button {
	display: none;
}

video::-webkit-media-controls-enclosure {
	overflow: hidden;
}

video::-webkit-media-controls-panel {
	width: calc(100% + 30px); /* Adjust as needed */
}

#videoDivListStyle {
	border: 1px solid gray;
	height: 100%;
	background-color: rgba(0%, 10%, 20%, 0.9);
	overflow-y: auto;
}

#videoDivListStyle>div>h4 {
	color: white;
	text-align: center;
	font-weight: bold;
}

#peopleNumber>div>p {
	font-size: 18px;
	color: white
}

#priceGroup>div {
	border-right: 1px solid white;
	border-left: 1px solid white
}

#priceGroup>div>div {
	font-size: 18px;
	color: white;
}
/* 下方功能 (簡介)*/
.tab .nav-tabs {
	position: relative;
	border-bottom: none;
}

.tab .nav-tabs li {
	text-align: center;
	margin-right: 10px;
}

.tab .nav-tabs li a {
	display: block;
	font-size: 18px;
	font-weight: 600;
	color: #444;
	padding: 10px 15px;
	background: transparent;
	margin-right: 0;
	border: none;
	border-radius: 0;
	overflow: hidden;
	position: relative;
	z-index: 1;
	transition: all 0.5s ease 0s;
}

.tab .nav-tabs li a:before {
	content: "";
	width: 100%;
	height: 3px;
	background: #de7921;
	position: absolute;
	top: 92%;
	left: 0;
	transition: all 0.3s ease 0s;
}

.tab .nav-tabs li a:hover:before, .tab .nav-tabs li.active a:before,
	.tab .nav-tabs li.active a:hover:before {
	top: 0;
}

.tab .nav-tabs li a:after {
	content: "";
	width: 100%;
	height: 100%;
	background: #fff;
	position: absolute;
	top: 100%;
	left: 0;
	z-index: -1;
	transition: all 0.3s ease 0s;
}

.tab .nav-tabs li a:hover:after, .tab .nav-tabs li.active a:after, .tab .nav-tabs li.active a:hover:after
	{
	top: 0;
}

.nav-tabs li.active a, .nav-tabs li.active a:focus, .nav-tabs li.active a:hover,
	.nav-tabs li a:hover {
	border: none;
}

.tab .tab-content {
	padding: 30px 15px 20px;
	background: #fff;
	font-size: 14px;
	color: #555;
	line-height: 26px;
}

.tab .tab-content h3 {
	font-size: 24px;
	margin-top: 0;
}
/* 留言板 */
#messageHeader {
	border: 1px solid black;
	border-radius: 15px;
	font-size: 18px;
}

#messageHeader>img {
	width: 50px;
}

#videoTitle {
	background-color: rgba(0%, 10%, 20%, 0.3);
	color: white;
}
</style>
</head>
<!-- 影片區 -->
<body oncontextmenu="window.event.returnValue=false">
	<jsp:include page="/login.jsp" flush="true" />
	<div class="container-fluid">
		<div class="container">
			<div class="row">
				<h1 align="center" id="videoTitle">${courseVO.courseName}</h1>
				<div class="col-md-12 " id="videoArea">

					<div class="col-md-12" style="z-index: 10">
						<div class="col-md-8 col-xs-12"
							style="margin-right: -15px; z-index: 10">

							<video controls="controls" id="vidoeControl"
								poster="<%=request.getContextPath() %>/CourseImage?CourseID=${courseVO.courseID}">
								<source
									src="<%=request.getContextPath()%>/${courseVO.courseVideopathway}"
									type="video/mp4">
							</video>

						</div>
						<div class="col-md-4 col-xs-12" id="videoDivListStyle">
							<div>
								<h2 style="color: white; text-align: center">募資進行中</h2>
								<div style="margin: 15px 0" id="peopleNumber">
									<div class="pull-left">
										<p style="font-size: 22px">目標人數${courseVO.targetStudentNumber}人</p>
									</div>
									<div class="pull-right">
										<p style="font-size: 22px" id="targetPersent"></p>
									</div>
									<div class="clearfix"></div>
									<div class="progress ">
										<div class="progress-bar progress-bar-striped active"
											role="progressbar" aria-valuemin="0" aria-valuemax="100"
											id="targetBar"></div>
									</div>
								</div>
								<div style="margin: 15px 0">
									<div style="text-align: center; color: white">
										<p style="font-size: 22px; color: white">剩餘時間 ( 天:時:分:秒 )
										</p>
									</div>
									<div class="led3  text-center "></div>
								</div>

								<div style="margin: 15px 0" id="priceGroup">
									<div class="col-md-6 ">
										<div class="text-left" style="font-size: 22px">原始價格</div>
										<div class="text-right"
											style="text-decoration: line-through; font-size: 22px">${courseVO.soldPrice}</div>
									</div>
									<div class="col-md-6">
										<div class="text-left" style="font-size: 22px">募資價格</div>
										<div class="text-right" style="font-size: 22px"id="price"></div>
									</div>
								</div>
								<c:if test="${empty LoginOK}">
									<c:choose>
										<c:when test="${!empty loginerr}">
											<button type="button" class="btn-warning btn-lg"
												data-toggle="modal" data-target="#myModal" id="intoShoppingCart"
												style="width: 100%; font-size: 22px; margin: 20px 0">我要加入募資</button>
										</c:when>
										<c:when test="${empty err}">
											<button type="button" class="btn-warning btn-lg"
												data-toggle="modal" data-target="#myModal" id="intoShoppingCart"
												style="width: 100%; font-size: 22px; margin: 20px 0">我要加入募資</button>


										</c:when>
										<c:otherwise>
											<button type="button" class="btn-warning btn-lg"
												data-toggle="modal" data-target="#myModal" id="intoShoppingCart"
												style="width: 100%; font-size: 22px; margin: 20px 0">我要加入募資</button>
										</c:otherwise>
									</c:choose>
								</c:if>
							<c:if test="${!empty LoginOK}">
									<c:choose>
										<c:when test="${LoginOK.memberID==courseVO.memberID}">
											<button type="button" class="btn-warning btn-lg"
												style="width: 100%; font-size: 22px; margin: 20px 0"
												disabled="disabled">已募資</button>
										</c:when>
										<c:when test="${!empty LoginOK && !empty list2}">
											<c:forEach var="buycourse" items='${list2}'
												varStatus="varStatus">
												<c:choose>
													<c:when test="${courseVO.courseID==buycourse.courseID}">
														<button type="button" class="btn-warning btn-lg"
															style="width: 100%; font-size: 22px; margin: 20px 0"
															disabled="disabled">已募資</button>

														<c:set var="boo" value="true" />
													</c:when>
													<c:when test="${!empty boo}"></c:when>
													<c:when test="${varStatus.last && empty boo}">
														<button type="button" class="btn-warning btn-lg" id="intoShoppingCart"
															style="width: 100%; font-size: 22px; margin: 20px 0">我要加入募資</button>
													</c:when>
												</c:choose>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<button type="button" class="btn-warning btn-lg" id="intoShoppingCart"
												style="width: 100%; font-size: 22px; margin: 20px 0">我要加入募資</button>
										</c:otherwise>
									</c:choose>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--內容 -->

	<div class="demo" style="margin-top: 80px">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="tab" role="tabpanel">

						<ul class="nav nav-tabs" role="tablist"
							style="background-color: #efd391">
							<li role="presentation" class="active"><a href="#Section1"
								aria-controls="home" role="tab" data-toggle="tab">課程簡介</a></li>
							<li role="presentation"><a href="#Section2"
								aria-controls="home" role="tab" data-toggle="tab">講師簡介</a></li>
							<li role="presentation"><a href="#Section3"
								aria-controls="profile" role="tab" data-toggle="tab">課程討論</a></li>

						</ul>
				<!-- 課程簡介 -->
						<div class="tab-content tabs">
							<div role="tabpanel" class="tab-pane fade in active"
								id="Section1" style="font-size: 20px">

								<c:if test="${!empty courseVO.preTool}">
									<strong>需要用到的工具（含種類、版本細節）</strong>
									<p>${courseVO.preTool}</p>
								</c:if>
								<c:if test="${!empty courseVO.background}">
									<strong>需要具有哪些背景知識？</strong>
									<p>${courseVO.background}</p>
								</c:if>
								<c:if test="${!empty courseVO.ability}">
									<strong>上完課後，學生可以學到並做出的東西</strong>
									<p>${courseVO.ability}</p>
								</c:if>
								<c:if test="${!empty courseVO.targetgroup}">
									<strong>哪些人適合這堂課？</strong>
									<p>${courseVO.targetgroup}</p>
								</c:if>
								<c:if test="${!empty courseVO.courseContent}">
									<strong>課程簡介</strong>
									<p>${courseVO.courseContent}</p>
								</c:if>
							</div>
							<!-- 講師簡介 -->
							<div role="tabpanel" class="tab-pane fade" id="Section2"
								style="font-size: 20px">
						
										<c:if test="${!empty memberVo.memberID}">
									<div class="col-md-2 col-xs-3">
										<figure>
											<img
												src="<%=request.getContextPath() %>/Image?MemberID=${memberVo.memberID}"
												class="img-thumbnail center-block img-circle"  />
											<div style="text-align: center">${memberVo.mName}</div>
										</figure>
										<div>

											<c:if test="${empty LoginOK}">
												<c:choose>
													<c:when test="${!empty loginerr}">
														<a href="#" data-toggle="modal" data-target="#myModal">
															<button type="button" class="btn btn-info"
																style="width: 100%">追蹤講師</button>
														</a>
													</c:when>
													<c:when test="${empty err}">
														<a href="#" data-toggle="modal" data-target="#myModal">
															<button type="button" class="btn btn-info"
																style="width: 100%">追蹤講師</button>
														</a>
													</c:when>
													<c:otherwise>
														<a href="#" data-toggle="modal" data-target="#myModal">
															<button type="button" class="btn btn-info"
																style="width: 100%">追蹤講師</button>
														</a>
													</c:otherwise>
												</c:choose>
											</c:if>
											<c:if test="${!empty LoginOK}">
												<c:if test="${!empty memberSubscription}">													
													<c:forEach items="${memberSubscription}" var="memberSubscription">
														<c:choose>
															<c:when	test="${memberSubscription.memberTrackID==courseVO.memberID}">
																<c:set var="disabled" value="disabled" />
																<c:set var="subName" value="已追蹤講師" />
																<c:set var="sub1" value="ture" />
															</c:when>
															<c:when test="${!empty sub1}">
															</c:when>
															<c:otherwise>
																<c:set var="disabled" value="" />
																<c:set var="subName" value="追蹤講師" />
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</c:if>
												<c:if test="${empty memberSubscription}">
													<c:set var="disabled" value="" />
														<c:set var="subName" value="追蹤講師" />
												</c:if>
												<c:if test="${courseVO.memberID==LoginOK.memberID}">
													<c:set var="disabled" value="disabled" />
													<c:set var="subName" value="本人" />
												</c:if>
												<button type="button" class="btn btn-info" ${disabled} style="width: 100%" id="subAction">${subName}</button>
												<input type="hidden" id="coursevoMemeberID" value="${courseVO.memberID}">
											</c:if>
										
										</div>
									</div>
								</c:if>
								<div class="col-md-10 col-xs-9">
									<c:if test="${!empty memberVo.aboutme}">
										<strong>關於我</strong>
										<p>${memberVo.aboutme}</p>
										<hr>
									</c:if>
									<c:if test="${!empty memberVo.skill}">
										<strong>專長</strong>
										<p>${memberVo.skill}</p>
										<hr>
									</c:if>
									<c:if test="${!empty memberVo.hobby}">
										<strong>興趣</strong>
										<p>${memberVo.hobby}</p>
									</c:if>
								</div>
							</div>
						<!-- 留言板 -->
							<div role="tabpanel" class="tab-pane fade" id="Section3">
								<div class="col-md-12" id="messageHeader">
									<div class="col-md-1">
										<img src="<%=request.getContextPath()%>/img/imember_image.png"
											class="img-thumbnail pull-left">
									</div>
									<div class="col-md-11">
										<div>
											<!--測試用messageID -->
											<span id="testMessage1" value="1001" class="text-left">吳永志</span>

											<%
												Date dNow = new Date();
												SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
												out.print("<span align=\"center\">" + ft.format(dNow) + "</span>");
											%>
											<div class="dropdown pull-right">
												<button class="btn dropdown-toggle btn-default "
													type="button" data-toggle="dropdown" style="height: 30px">
													<span class="glyphicon glyphicon-option-horizontal"></span>
												</button>
												<ul class="dropdown-menu">
													<c:if test="${empty LoginOK}">
														<c:choose>
															<c:when test="${!empty loginerr}">
																<li><a href="#" href="#" data-toggle="modal"
																	data-target="#myModal2">檢舉</a></li>
															</c:when>
															<c:when test="${empty err}">
																<li><a href="#" href="#" data-toggle="modal"
																	data-target="#myModal">檢舉</a></li>
															</c:when>
															<c:otherwise>
																<li><a class="reportM" href="#" href="#"
																	data-toggle="modal" data-target="#myModal2">檢舉</a></li>
															</c:otherwise>
														</c:choose>
													</c:if>
													<c:if test="${!empty LoginOK}">
														<li><a class="reportM" href="#">檢舉</a></li>
													</c:if>
													<li><a href="#">修改</a></li>
													<li><a href="#">刪除</a></li>
												</ul>
											</div>

										</div>

										<div style="border-bottom: 1px solid black">

											<p>With Bootstrap 2, we added optional mobile friendly
												styles for key aspects of the framework. With Bootstrap 3,
												we've rewritten the project to be mobile friendly from the
												start. Instead of adding on optional mobile styles, they're
												baked right into the core. In fact, Bootstrap is mobile
												first. Mobile first styles can be found throughout the
												entire library instead of in separate files. To ensure
												proper rendering and touch zooming, add the viewport meta
												tag to your</p>
										</div>


										<div class="col-md-12">

											<div class="panel-group">
												<div class="panel">
													<div class="panel-heading">
														<h4 class="panel-title " style="padding-bottom: 10px">
															<a data-toggle="collapse" href="#collapse1">回應記錄</a>
														</h4>
													</div>
													<div id="collapse1" class="panel-collapse collapse ">
														<!--第一個回應 -->
														<div>
															<div class="col-md-1">
																<img
																	src="<%=request.getContextPath()%>/img/imember_image.png"
																	class="img-thumbnail pull-left">
															</div>
															<div class="col-md-11 "
																style="border-bottom: 1px solid black">
																<span>吳永志</span>
																<%
																	out.print("<span align=\"center\">" + ft.format(dNow) + "</span>");
																%>
																<div class="dropdown pull-right">
																	<button class="btn dropdown-toggle btn-default "
																		type="button" data-toggle="dropdown"
																		style="height: 30px">
																		<span class="glyphicon glyphicon-option-horizontal"></span>
																	</button>
																	<ul class="dropdown-menu">
																		<c:if test="${empty LoginOK}">
																			<c:choose>
																				<c:when test="${!empty loginerr}">
																					<li><a href="#" href="#" data-toggle="modal"
																						data-target="#myModal2">檢舉</a></li>
																				</c:when>
																				<c:when test="${empty err}">
																					<li><a href="#" href="#" data-toggle="modal"
																						data-target="#myModal">檢舉</a></li>
																				</c:when>
																				<c:otherwise>
																					<li><a class="reportM" href="#" href="#"
																						data-toggle="modal" data-target="#myModal2">檢舉</a></li>
																				</c:otherwise>
																			</c:choose>
																		</c:if>
																		<c:if test="${!empty LoginOK}">
																			<li><a class="reportM" href="#">檢舉</a></li>
																		</c:if>
																		<li><a href="#">修改</a></li>
																		<li><a href="#">刪除</a></li>
																	</ul>
																</div>
																<p>With Bootstrap 2, we added optional mobile
																	friendly styles for key aspects of the framework. With
																	Bootstrap 3, we've rewritten the project to be mobile
																	friendly from the start. Instead of adding on optional
																	mobile styles, they're baked right into the core. In
																	fact, Bootstrap is mobile first. Mobile first styles
																	can be found throughout the entire library instead of
																	in separate files. To ensure proper rendering and touch
																	zooming, add the viewport meta tag to your</p>
															</div>
														</div>
														<!--第二個回應 -->
														<div>
															<div class="col-md-1">
																<img
																	src="<%=request.getContextPath()%>/img/imember_image.png"
																	class="img-thumbnail pull-left">
															</div>
															<div class="col-md-11 "
																style="border-bottom: 1px solid black">
																<span>吳永志</span>
																<%
																	out.print("<span align=\"center\">" + ft.format(dNow) + "</span>");
																%>
																<div class="dropdown pull-right">
																	<button class="btn dropdown-toggle btn-default "
																		type="button" data-toggle="dropdown"
																		style="height: 30px">
																		<span class="glyphicon glyphicon-option-horizontal"></span>
																	</button>
																	<ul class="dropdown-menu">
																		<c:if test="${empty LoginOK}">
																			<c:choose>
																				<c:when test="${!empty loginerr}">
																					<li><a href="#" href="#" data-toggle="modal"
																						data-target="#myModal2">檢舉</a></li>
																				</c:when>
																				<c:when test="${empty err}">
																					<li><a href="#" href="#" data-toggle="modal"
																						data-target="#myModal">檢舉</a></li>
																				</c:when>
																				<c:otherwise>
																					<li><a class="reportM" href="#" href="#"
																						data-toggle="modal" data-target="#myModal2">檢舉</a></li>
																				</c:otherwise>
																			</c:choose>
																		</c:if>
																		<c:if test="${!empty LoginOK}">
																			<li><a class="reportM" href="#">檢舉</a></li>
																		</c:if>
																		<li><a href="#">修改</a></li>
																		<li><a href="#">刪除</a></li>
																	</ul>
																</div>
																<p>With Bootstrap 2, we added optional mobile
																	friendly styles for key aspects of the framework. With
																	Bootstrap 3, we've rewritten the project to be mobile
																	friendly from the start. Instead of adding on optional
																	mobile styles, they're baked right into the core. In
																	fact, Bootstrap is mobile first. Mobile first styles
																	can be found throughout the entire library instead of
																	in separate files. To ensure proper rendering and touch
																	zooming, add the viewport meta tag to your</p>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<!-- 			<!--回應輸入表格-->
										<div class="col-md-12">
											<div class="panel-group">
												<div class="panel">
													<div class="panel-heading">
														<h4 class="panel-title ">
															<a data-toggle="collapse" href="#collapse2">我要回應</a>
														</h4>
													</div>
													<div id="collapse2" class="panel-collapse collapse ">
														<div>
															<p>內容:</p>
															<form action="" method="post">
																<div class="form-group">
																	<textarea class="form-control" rows="5" id="comment"></textarea>
																</div>
																<div class="text-right">
																	<input type="submit">
																</div>
															</form>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" value="${courseVO.courseID}" id="mbcourseID">
	<input type="hidden" value="${courseVO.fundEndDate}" id="fundEndDate">
	<input type="hidden" value="${LoginOK.memberID}" id="mbmemberID">
	<input type="hidden" value="${courseVO.targetStudentNumber}"
		id="targetStudentNumber">
	<c:remove var="err" scope="session" />
	<c:remove var="loginerr" scope="session" />
	<jsp:include page="/footer.jsp" />
</body>

<script>
$(function(){
		$.getJSON("/e-Look/BuyCourseNumber", {
			'courseID' : $('#mbcourseID').val()
		}, function(data) {
			var buyStudentNumber = parseInt(data);
			var targetStudentNumber = parseInt($('#targetStudentNumber').val())
			var targetBar = buyStudentNumber / targetStudentNumber * 100;
			targetBarEx = parseInt(targetBar);
			$('#targetPersent').text("已達成" + targetBarEx + "%");
			$('#targetBar').attr('style', 'width:' + targetBarEx + '%');

		})

	})
</script>
<script>
	var fundEndDate = $('#fundEndDate').val().replace("-", ":");
	var fundEndDate1 = fundEndDate.replace("-", ":");
	$('.led3').ClassyLED({
		type : 'countdown',
		format : 'ddd:hh:mm:ss',
		countTo : fundEndDate1,
		color : '#af0',
		backgroundColor : '#272727',
		size : 4,
		fontType : 2,
	});
</script>
<script>
	$(document).ready(function() {
		$(".col-md-4 a").click(function() {
			$(this).tab('show');
		});
	});
</script>
<script>
$(function(){
	$.getJSON('/e-Look/GetBuyingPrice',{'courseID':$('#mbcourseID').val()},function(price){
		$('#price').text(price)
	})
})
</script>
	<script>
		var count = 0;
		$('#subAction').click(function() {
			if (count == 0) {
				$.post("MemberSubcriptionInsert_DeleteController", {
					'memberID' : $('#mbmemberID').val(),
					'memberTrackID' : $('#coursevoMemeberID').val()
				}, function() {
					alert('已加到您的追蹤講師囉');
					count++;
				});
				$('#subAction').attr('disabled', 'false')
				$('#subAction').text('已追蹤講師')
			} else {
				alert('已經追蹤過囉');
				$('#subAction').attr('disabled', 'false')
			}

		})
	</script>
</html>