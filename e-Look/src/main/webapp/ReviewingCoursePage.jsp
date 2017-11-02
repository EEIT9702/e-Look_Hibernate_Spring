f<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,java.text.*,com.e_Look.Course.*,com.e_Look.member.model.*,com.e_Look.buyCourse.model.*,javax.servlet.http.HttpSession"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<link href="/favicon.ico" rel="shortcut icon" type="image/x-icon">

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
	<jsp:include page="/login.jsp" flush="true" />
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

					<input type="hidden" value="${courseVO.courseID}">
					<div class="col-md-12" style="z-index: 10">
						<div class="col-md-8 col-xs-12"
							style="margin-right: -15px; z-index: 10">
							<c:choose>
								<c:when test="${LoginOK.memberID==courseVO.memberID}">
									<video controls="controls" id="vidoeControl">
										<source
											src="<%=request.getContextPath()%>/${courseVO.courseVideopathway}"
											type="video/mp4">
									</video>

								</c:when>
								<c:when test="${!empty LoginOK && !empty list2}">
									<video
										<c:forEach var="buycourse"  items='${list2}'>
							<c:choose>
								<c:when test="${courseVO.courseID==buycourse.courseID}">
										<c:set var="control" value="controls=controls" />
										<c:set var="poster" value="" />
										<c:set var="boo" value="true" />
								</c:when>
								<c:when test="${!empty boo}">
								</c:when>
								<c:otherwise> 
									<c:set var="poster" value="poster=_Lyy/poster.png" />
									<c:set var="control" value=""/>
								</c:otherwise>
							</c:choose>
						</c:forEach>
										<c:out value="${poster}"/> <c:out value="${control}"/>
										id="vidoeControl">
										<source
											src="<%=request.getContextPath()%>/${courseVO.courseVideopathway}"
											type="video/mp4">
									</video>
								</c:when>
								<c:otherwise>
									<video poster="<%=request.getContextPath()%>/_Lyy/poster.png"
										id="vidoeControl">
										<source
											src="<%=request.getContextPath()%>/${courseVO.courseVideopathway}"
											type="video/mp4">
									</video>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="col-md-4 col-xs-12" id="videoDivListStyle">
							<div>
								<h3>推薦課程</h3>
							</div>
							<ul id="videoliststyle">
								<c:forEach var="course" items='${list}'>
									<c:if test="${course.soldPrice>0}">
										<li><a style="color: white; text-decoration: none;"
											href="<%=request.getContextPath() %>/onlineCourse-v2.jsp?CourseID=${course.courseID}">${course.courseName}</a></li>
									</c:if>
									<c:if test="${course.soldPrice==0}">
										<li><a style="color: white; text-decoration: none;"
											href="<%=request.getContextPath() %>/freeCourse-v1.jsp?CourseID=${course.courseID}">${course.courseName}</a></li>
									</c:if>
								</c:forEach>
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
				<c:if test="${!empty mBookmarkList}">
					<c:forEach items="${mBookmarkList}" var="memberBookmsrks">
						<c:choose>
							<c:when test="${courseVO.courseID==memberBookmsrks.courseID}">
								<c:set var="favor" value="favoriteclick1" />
								<c:set var="favor1" value="ture" />
							</c:when>
							<c:when test="${!empty favor1}">
							</c:when>
							<c:otherwise>
								<c:set var="favor" value="favoriteclick2" />
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:if>
				<c:if test="${empty mBookmarkList}">
					<c:set var="favor" value="favoriteclick2" />
				</c:if>
				<c:if test="${empty LoginOK}">
					<c:choose>
						<c:when test="${!empty loginerr}">
							<div class="col-md-1 col-xs-4">
								<a href="#" data-toggle="modal" data-target="#myModal2"> <img
									src="<%=request.getContextPath()%>/img/favorite.png"
									class="img-responsive center-block img-circle">
									<h5 class="text-center" style="font-size: 18px">加到最愛</h5>
								</a>
							</div>
						</c:when>
						<c:when test="${empty err}">
							<div class="col-md-1 col-xs-4">
								<a href="#" data-toggle="modal" data-target="#myModal"> <img
									src="<%=request.getContextPath()%>/img/favorite.png"
									class="img-responsive center-block img-circle">
									<h5 class="text-center" style="font-size: 18px">加到最愛</h5>
								</a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-md-1 col-xs-4">
								<a href="#" data-toggle="modal" data-target="#myModal2"> <img
									src="<%=request.getContextPath()%>/img/favorite.png"
									class="img-responsive center-block img-circle">
									<h5 class="text-center" style="font-size: 18px">加到最愛</h5>
								</a>
							</div>
						</c:otherwise>
					</c:choose>
				</c:if>
				<c:if test="${!empty LoginOK}">
					<div class="col-md-1 col-xs-4">
						<a href="#" id="${favor}"> <img
							src="<%=request.getContextPath()%>/img/favorite.png"
							class="img-responsive center-block img-circle">
							<h5 class="text-center" style="font-size: 18px">加到最愛</h5>
						</a>
					</div>
				</c:if>
				<input type="hidden" value="${courseVO.courseID}" id="mbcourseID">
				<input type="hidden" value="${LoginOK.memberID}" id="mbmemberID">
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
				<c:if test="${empty LoginOK}">
					<c:choose>
						<c:when test="${!empty loginerr}">
							<div class="col-md-1 col-xs-4">
								<a href="#" href="#" data-toggle="modal" data-target="#myModal2">
									<img src="<%=request.getContextPath()%>/img/warning.png"
									class="img-responsive center-block img-circle">
									<h5 class="text-center" style="font-size: 18px">影片檢舉</h5>
								</a>
							</div>
						</c:when>
						<c:when test="${empty err}">
							<div class="col-md-1 col-xs-4">
								<a href="#" href="#" data-toggle="modal" data-target="#myModal">
									<img src="<%=request.getContextPath()%>/img/warning.png"
									class="img-responsive center-block img-circle">
									<h5 class="text-center" style="font-size: 18px">影片檢舉</h5>
								</a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-md-1 col-xs-4">
								<a href="#" href="#" data-toggle="modal" data-target="#myModal2">
									<img src="<%=request.getContextPath()%>/img/warning.png"
									class="img-responsive center-block img-circle">
									<h5 class="text-center" style="font-size: 18px">影片檢舉</h5>
								</a>
							</div>
						</c:otherwise>
					</c:choose>
				</c:if>
				<c:if test="${!empty LoginOK}">
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
				</c:if>
				<!--課程售價 -->
				<div class="col-md-2 col-xs-6 " id="soldPrice">
					<h4>課程售價</h4>
					<h2 style="text-align: center; font-weight: bold;">NT${courseVO.soldPrice}</h2>
				</div>
				<!--星星 -->
				<div class="col-md-2 col-xs-6"
					style="height: 89px; border-right: 1px solid #ADADAD">

					<div id="starTatol" style="margin: 0 auto; padding-top: 10px">
						<span id="starText" class="pull-right"></span>
					</div>
					<!-- 		加入購物車 -->
					<c:if test="${empty LoginOK}">
						<c:choose>
							<c:when test="${!empty loginerr}">

								<button id="intoShoppingCart" type="button" data-toggle="modal"
									data-target="#myModal2" class="btn btn-success center-block"
									style="width: 160px">加入購物車</button>

							</c:when>
							<c:when test="${empty err}">


<!-- 								<button id="intoShoppingCart" type="button" data-toggle="modal" -->
<!-- 									data-target="#myModal" class="btn btn-success center-block" -->
<!-- 									style="width: 160px">加入購物車</button> -->


							</c:when>
							<c:otherwise>

								<button id="intoShoppingCart" type="button" data-toggle="modal"
									data-target="#myModal" class="btn btn-success center-block"
									style="width: 160px">加入購物車</button>

							</c:otherwise>
						</c:choose>
					</c:if>
					<c:if test="${!empty LoginOK}">
						<c:choose>
							<c:when test="${LoginOK.memberID==courseVO.memberID}">
								<button type="button" class="btn btn-success center-block "
									style="width: 160px" disabled="disabled">已擁有</button>
							</c:when>
							<c:when test="${!empty LoginOK && !empty list2}">
								<c:forEach var="buycourse" items='${list2}'
									varStatus="varStatus">
									<c:choose>
										<c:when test="${courseVO.courseID==buycourse.courseID}">
											<button type="button" class="btn btn-success center-block "
												style="width: 160px" disabled="disabled">已擁有</button>
											<c:set var="boo" value="true" />
										</c:when>
										<c:when test="${!empty boo}"></c:when>
										<c:when test="${varStatus.last && empty boo}">
											<button id="intoShoppingCart" type="button"
												class="btn btn-success center-block " style="width: 160px">加入購物車</button>
										</c:when>
									</c:choose>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<button id="intoShoppingCart" type="button"
									class="btn btn-success center-block " style="width: 160px">加入購物車</button>
							</c:otherwise>
						</c:choose>

					</c:if>
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
								<c:if test="${!empty memberVo.memberID}">
									<div class="col-md-2 col-xs-3">
										<figure>
											<img
												src="<%=request.getContextPath() %>/Image?MemberID=${memberVo.memberID}"
												class="img-thumbnail center-block img-circle" />
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
													<c:forEach items="${memberSubscription}"
														var="memberSubscription">
														<c:choose>
															<c:when
																test="${memberSubscription.memberTrackID==courseVO.memberID}">
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
												<button type="button" class="btn btn-info" ${disabled}
													style="width: 100%" id="subAction">${subName}</button>
												<input type="hidden" id="coursevoMemeberID"
													value="${courseVO.memberID}">
											</c:if>


										</div>
									</div>
								</c:if>
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
	<c:remove var="err" scope="session" />
	<c:remove var="loginerr" scope="session" />
	<jsp:include page="/footer.jsp" />

	<script>
		$(document).ready(function() {
			$(".col-md-4 a").click(function() {
				$(this).tab('show');
			});
		});
	</script>
	<script>
		$(function() {
			//點擊檢舉留言
			$('.reportM').on('click', function() {
				warning();
			})
			//選取檢舉留言功能
			function warning() {
				swal({
					title : '檢舉留言',
					input : 'select',
					inputOptions : {
						'含有仇恨言論' : '含有仇恨言論',
						'不雅內容' : '不雅內容',
						'垃圾訊息' : '垃圾訊息'
					},
					inputPlaceholder : '請選擇檢舉事項',
					confirmButtonText : '確認',
					cancelButtonText : '取消',
					showCancelButton : true,
					inputValidator : function(value) {
						return new Promise(function(resolve) {
							resolve();
						});
					}
				}).then(
						function(result) {
							if (result) {
								console.log($('#testMessage1').attr('value'));
								console.log($('#reportMemberID').val());
								console.log(result);
								$.post('InsertReportMessageController', {
									'reportContent' : result,
									'reportMemberID' : $('#reportMemberID')
											.val(),
									'reportMessageID' : $('#testMessage1')
											.attr('value')
								})
								swal({

									confirmButtonText : '確認',
									type : 'success',
									html : '檢舉 ' + result + ' 成功，管理員會盡快審核 '

								});
							}
				});
			}
			
			
		})
	</script>
	<script>
		//判斷是否加入過最愛		
		var count1 = 0;
		$('#favoriteclick1').click(function() {
			alert('已經加入過囉');
		})

		$("#favoriteclick2").click(function() {

			console.log($("#mbcourseID").val())
			console.log($("#mbmemberID").val())
			if (count1 == 0) {
				$('#favoriteclick2').attr("id", "favoriteclick1")
				$.post('MemberBookmarksInsertController', {
					'courseID' : $("#mbcourseID").val(),
					'memberID' : $("#mbmemberID").val()
				}, function() {
					alert('已經加到你的最愛囉');
					count1++;
				})
			} else {
				alert('已經加入過囉');
			}

		})
	</script>
	<script>
	$(function() {
		$('.reportAction').click(function() {
				warningV();
			})

			function warningV() {
				swal({
					title : '檢舉影片',
					input : 'select',
					inputOptions : {
						'該影片侵犯著作權' : '該影片侵犯著作權',
						'該影片含有不雅內容' : '該影片含有不雅內容',
						'該影片無法播放' : '該影片無法播放'
					},
					inputPlaceholder : '請選擇檢舉事項',
					confirmButtonText : '確認',
					cancelButtonText : '取消',
					showCancelButton : true,
					inputValidator : function(value) {
						return new Promise(function(resolve) {
							resolve();
						});
					}
				}).then(function(result) {
						if (result) {
			 				$.post("ReportCourseInsertController", {
		 					'reportMemberID' : $('#reportMemberID').val(),
		 					'reportCourseID' : $('#reportCourseID').val(),
		 					'radioReporterCon' : result
							})
							swal({
								confirmButtonText : '確認',
								type : 'success',
								html : '檢舉 ' + result + ' 成功，管理員會盡快審核 '
							});
						}
					});
			}	
		});
	</script>
	<script>
		var count = 0;
		$('#subAction').click(function() {
			if (count == 0) {
				$.post("MemberSubcriptionInsert_DeleteController", {
					'memberID' : $('#reportMemberID').val(),
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
	<script>
	
		// 	星星點評
		
		$(function(){
			$('#star').raty(
				{
					path : 'img',
					width : 150,
					starOff : 'star-off-big.png',
					starOn : 'star-on-big.png',
					readOnly :function() {
						if ($('#reportMemberID').val() == ""|| $('#reportMemberID').val() == null) {//沒有登入
							$("#noLogin").text("(請先登入)")
							
							return true;
						}else{
						var memberID=$('#reportMemberID').val();
// 							console.log(getJson(memberID));
							return getJson(memberID);
					}
				},
					click : function(score, evt) {
						$.post('updateScoreController', {
							'score' : score,
							'memberID' : $('#reportMemberID').val(),
							'courseID' : $('#reportCourseID').val()
						})
						alert("感謝你的評分!" + "\nscore: " + score);
					}
				});
		});
		
		function getJson(memberID) {
			var bool;
			$.ajax({'url':'/e-Look/countScoreController',
						'async' : false,
						'method' : "GET",
						'data' : {
							'memberID' : memberID
						},
						'success' : function(datas) {
							var datasJson = JSON.parse(datas);
							console.log(datasJson.length)
							console.log(datas);
							console.log($('#reportMemberID').val());
							console.log($('#starMemberID').val());
							if ($('#starMemberID').val() == $('#reportMemberID')
									.val()) {
								$("#noLogin").text("")
								bool = false
								return bool;
							} else if ($('#starMemberID').val() != $(
									'#reportMemberID').val()) {
								for (var i = 0; i <= (datasJson.length - 1); i++) {
									if (datasJson[i].courseID == $(
											'#reportCourseID').val()) {
										$("#noLogin").text("")
										bool = false
										return bool;
									}
								}
								$("#noLogin").text("(請先購買該課程)")
								bool = true;
								return bool;
							}
						}
					});//$.ajax end
			return bool;
		}
	</script>
	<script>
		var scoreJSON;
		var value;
		$(function() {

			$.post('countScoreController', {
				'courseID' : $("#mbcourseID").val()
			}, function(data) {
				scoreJSON = JSON.parse(data);
				value = Math.ceil(parseFloat(scoreJSON));
				$('#starText').css({
					'font-size' : '12px',
					'padding-top' : '5px'
				}).text("(" + value + ")")
				$('#starTatol').raty({
					path : 'img',
					width : 160,
					starOff : 'star-off-big.png',
					starOn : 'star-on-big.png',
					readOnly : true,
					score : value,
				});
			});
		});
	</script>
	<script>
	$(function(){
		$.getJSON("/e-Look/BuyCourseNumber",{'courseID':$("#mbcourseID").val()},
				function(data){
					var buyStudentNumber=parseInt(data);
					$("#buyStudentNumber").text(buyStudentNumber+"人")
			})
	})
	</script>
	<script>
		var b=true;
 		$('video').click(function(){
 			if(b){
			this.play();
			b=false;
 			}else{
 				this.pause();
				b=true;
 			}
		})
		</script>
	</body>
</html>