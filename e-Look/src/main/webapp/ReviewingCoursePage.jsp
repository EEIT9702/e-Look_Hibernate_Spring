<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,java.text.*,com.e_Look.Course.*,com.e_Look.member.model.*,com.e_Look.buyCourse.model.*,javax.servlet.http.HttpSession"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Short Icon" type="image/x-icon" href="${initParam.icon}" />
<title>課程內容審查頁面</title>
<link href="<%=request.getContextPath()%>/HeaderCssJs/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<link href="<%=request.getContextPath()%>/_PJC/css/step1.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/_PJC/css/ReviewingCoursePage.css"
	rel="stylesheet">

<!-- Sweet Alert -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/alan/sweet/sweetalert2.min.css">
<script
	src="<%=request.getContextPath()%>/alan/sweet/sweetalert2.min.js"></script>
<!-- 星星 -->
<script type="text/javascript"src="<%=request.getContextPath()%>/_Lyy/jquery.raty.min.js"></script>
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
	height: 520px;
	padding-left: 0;
}

#videoliststyle>li {
	height: 50px;
	font-size: 20px;
	list-style-type: none;
	border-bottom: 1px solid #8E8E8E;
	line-height: 50px;
}

#videoArea>div>div>ul {
	width: 100%;
	color: white;
	height: 85.2%;
	overflow-y: scroll;
	margin: 0;
	padding: 0;
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

#videoTitle {
	background-color: rgba(0%, 10%, 20%, 0.3);
	color: white;
}

#videoDivListStyle {
	border: 1px solid gray;
	height: 100%;
	background-color: rgba(0%, 10%, 20%, 0.3);;
}

#videoDivListStyle>div>h3 {
	color: white;
	text-align: center;
	font-weight: bold;
}
/* 下方功能 (簡介)*/
.tab .nav-tabs {
	position: relative;
	border-bottom: none;
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

/* 檢舉留言 */
#radioReporter {
	padding-left: 50px;
}

#radioReporter>span {
	font-size: 20px;
	padding-left: 5px;
}
/* <!--課程售價 --> */
#soldPrice {
	border-right: 1px solid #ADADAD;
	border-left: 1px solid #ADADAD;
}

a {
	text-decoration: none;
}

#videoArea::after {
	display: block;
	position: absolute;
	content: '';
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, .5);
	padding: 0;
	margin: 0;
}
</style>
</head>
<!-- 影片區 -->
<body oncontextmenu="window.event.returnValue=false">
	<div style="display: none;">
	<jsp:include page="/login.jsp" flush="true" />
	</div>
	<div class="container-fluid">
		<div class="container">
		<h1 class="text-center">管理員正在審查中...</h1>
		<br>
		<br>
	<div class="row">
        <div class="col-sm-6">
            <div id="tb-testimonial" class="testimonial testimonial-info">
                <div class="testimonial-section">
                    1. 確認影片是否完整無損壞
                    <br>
                    2. 課程標題與影片內容是否相符
                    <br>
                    3. 影片、課程簡介，都應避免色情、暴力、不雅言語及闡述政治立場之內容
                    <br>
                    4. 如有附講義，內容也須一併確認
                </div>
                
            </div>   
		</div>
	</div>
	
			<div class="row">
				<h1 align="center" id="videoTitle">${courseVO.courseName}</h1>
				<div class="col-md-12 " id="videoArea"
					style="background-image: url('<%=request.getContextPath() %>/CourseImage?CourseID=${courseVO.courseID}')">

					
					<div class="col-md-12" style="z-index: 10">
						<div class="col-md-8 col-xs-12"
							style="margin-right: -15px; z-index: 10">

									<video controls="controls"
										id="vidoeControl">
										<source
											src="<%=request.getContextPath()%>/${courseVO.courseVideopathway}"
											type="video/mp4">
									</video>


						</div>
						<div class="col-md-4 col-xs-12" id="videoDivListStyle">
							<div>
								<h3>推薦課程</h3>
							</div>
							<ul id="videoliststyle">
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 人數、時間 等等-->
	<div class="container" style="font-size: 18px">
		<div class="row">
			<div class="col-md-12" style="margin-top: 20px">
				<!--空-->
				<div class="col-md-1 "></div>
				<!--課程人數 -->
				<div class="col-md-1 col-xs-4">
					<img src="<%=request.getContextPath()%>/_Lyy/004-people.png"
						class="img-responsive center-block img-circle">
					<h5 class="text-center" style="font-size: 18px"id="buyStudentNumber"></h5>
				</div>
				<!--課程時間 -->
				<div class="col-md-1 col-xs-4">
					<img src="<%=request.getContextPath()%>/_Lyy/clock.png"
						class="img-responsive center-block img-circle ">
					<h5 class="text-center" style="font-size: 18px">${courseVO.courseLength}分鐘</h5>
				</div>
				<!--加到最愛 -->
					<div class="col-md-1 col-xs-4">
						<a href="#" > <img
							src="<%=request.getContextPath()%>/img/favorite.png"
							class="img-responsive center-block img-circle">
							<h5 class="text-center" style="font-size: 18px">加到最愛</h5>
						</a>
					</div>
				<input type="hidden" value="${courseVO.courseID}" id="mbcourseID">
				<!--分享連結 -->
				<div class="col-md-1 col-xs-4 ">
					<div class="dropdown text-center">
						<a data-toggle="dropdown"><img
							src="<%=request.getContextPath()%>/_Lyy/share.png"
							class="img-responsive center-block img-circle"
							style="margin-bottom: 6px; text-decoration: none"> 分享連結 </a>
						<ul class="dropdown-menu">
							<li><a href="#">FaceBook</a></li>
							<li><a href="#">Google</a></li>
							<li><a href="#">Line</a></li>
						</ul>
					</div>
				</div>
				<!--講義下載 -->
				<div class="col-md-1 col-xs-4 ">
					<c:if test="${!empty courseVO.paper}">
						<a
							href="<%=request.getContextPath()%>/Paper?CourseID=${courseVO.courseID}">
							<img src="<%=request.getContextPath()%>/_Lyy/001-download.png"
							class="img-responsive center-block img-circle">
							<h5 class="text-center" style="font-size: 18px">講義下載</h5>
						</a>
					</c:if>
					<c:if test="${empty courseVO.paper}">
						<img src="<%=request.getContextPath()%>/_Lyy/001-download.png"
							class="img-responsive center-block img-circle">
						<h5 class="text-center" style="font-size: 18px">講義下載</h5>
					</c:if>
				</div>
				<!--影片檢舉 -->
					<div class="col-md-1 col-xs-4">
						<a class="reportAction" href="#" data-toggle="modal" data-target="#myModalReportVideo">
							<img src="<%=request.getContextPath()%>/img/warning.png"
							class="img-responsive center-block img-circle">
							<h5 class="text-center" style="font-size: 18px">影片檢舉</h5>
						</a>
						<input type="hidden" id="reportMemberID"
									value="${LoginOK.memberID}" /> <input type="hidden"
									id="reportCourseID" value="${courseVO.courseID}" />
					</div>
				<!--課程售價 -->
				<div class="col-md-2 col-xs-6 " id="soldPrice">
					<h4>課程售價</h4>
					<h2 style="text-align: center; font-weight: bold;">NT ${courseVO.soldPrice}</h2>
				</div>
				<!--星星 -->
				<div class="col-md-2 col-xs-6"
					style="height: 89px; border-right: 1px solid #ADADAD">

					<div id="starTatol" style="margin: 0 auto; padding-top: 10px">
						<span id="starText" class="pull-right"></span>
					</div>
					<!-- 		加入購物車 -->
					
					<!-- 加入購物車結束 -->

				</div>

			</div>
		</div>
	</div>
	<!--內容 -->

	<div class="demo">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="tab" role="tabpanel">

						<ul class="nav nav-tabs" role="tablist"
							style="background-color: #eef9fc">
							<li role="presentation" class="active"><a href="#Section1"
								aria-controls="home" role="tab" data-toggle="tab">課程簡介</a></li>
							<li role="presentation"><a href="#Section2"
								aria-controls="home" role="tab" data-toggle="tab">講師簡介</a></li>
							<li role="presentation"><a href="#Section3"
								aria-controls="profile" role="tab" data-toggle="tab">課程討論</a></li>
							<li role="presentation"><a href="#Section4"
								aria-controls="messages" role="tab" data-toggle="tab">點評收藏</a></li>
						</ul>
						<!-- 課程簡介 -->
						<div class="tab-content tabs">
							<div role="tabpanel" class="tab-pane fade in active"
								id="Section1" style="font-size: 20px">
								<c:if test="${!empty courseVO.preTool}">
									<strong>需要用到的工具（含種類、版本細節）</strong>
									<p>${courseVO.preTool}</p>
									<hr style="border:0.5px solid black">   
								</c:if>
								<c:if test="${!empty courseVO.background}">
									<strong>需要具有哪些背景知識？</strong>
									<p>${courseVO.background}</p>
									<hr style="border:0.5px solid black">  
								</c:if>
								<c:if test="${!empty courseVO.ability}">
									<strong>上完課後，學生可以學到並做出的東西</strong>
									<p>${courseVO.ability}</p>
									<hr style="border:0.5px solid black">  
								</c:if>
								<c:if test="${!empty courseVO.targetgroup}">
									<strong>哪些人適合這堂課？</strong>
									<p>${courseVO.targetgroup}</p>
									<hr style="border:0.5px solid black">  
								</c:if>
								<c:if test="${!empty courseVO.courseContent}">
									<strong>課程簡介</strong>
									<p>${courseVO.courseContent}</p>
									 
								</c:if>
							</div>
							<!-- 講師簡介 -->
							<div role="tabpanel" class="tab-pane fade" id="Section2"
								style="font-size: 20px">
									<div class="col-md-2 col-xs-3">
										<figure>
											<img
												src="<%=request.getContextPath() %>/Image?MemberID=${memberVo.memberID}"
												class="img-thumbnail center-block img-circle" />
											<div style="text-align: center">${memberVo.mName}</div>
										</figure>
										<div>


										</div>
									</div>
								<div class="col-md-10 col-xs-9">
									<c:if test="${!empty memberVo.aboutme}">
										<strong>關於我</strong>
										<p>${memberVo.aboutme}</p>
										<hr style="border:0.5px solid black"> 
									</c:if>
									<c:if test="${!empty memberVo.skill}">
										<strong>專長</strong>
										<p>${memberVo.skill}</p>
										<hr style="border:0.5px solid black"> 
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
								<!-- 點評收藏 -->
							</div>
							<div role="tabpanel" class="tab-pane fade" id="Section4"
								style="font-size: 20px">
								<p>喜歡的話記得幫我們評分還有收藏唷</p>
								<span id="noLogin"></span>
								<div id="star"></div>
								<input type="hidden" value="${courseVO.memberID}"
									id="starMemberID">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div id="star"></div>
<%-- 	<c:remove var="err" scope="session" /> --%>
<%-- 	<c:remove var="loginerr" scope="session" /> --%>
	<jsp:include page="/footer.jsp" />


	
	
	
	

	
	
	</body>
</html>