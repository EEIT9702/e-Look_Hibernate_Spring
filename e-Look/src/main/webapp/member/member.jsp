<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<link rel="Shortcut Icon" type="image/x-icon" href="${SYSTEM.iconUri}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="login/viewport"
	content="width=device-width, initial-scale=1">
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<title>${SYSTEM.systemName}</title>

<style type="text/css">
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
	width: 180px;
	height: 150px;
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
a:HOVER {
	color:black;
}
</style>

</head>

<body>
<c:if test="${empty LoginOK}">
	<c:redirect url="/HOME.jsp"/>
	</c:if>
	<jsp:include page="/login.jsp" />
	<% 

		
%>
	<div style="margin-top: 10px" class="container">
		<div class="row">
				<div class="col-md-4 " style="padding-top: 20px;background-image: linear-gradient(-225deg, #E3FDF5 0%, #FFE6FA 100%);">
            <div class=" panel-body" style="padding: 20px; background-image: linear-gradient(-225deg, #77FFD2 0%, #6297DB 48%, #1EECFF 100%);">

                	<div class="col-md-6 no-pad ">
                	<c:if test="${empty Submembervo}">
                  		<div class="profile-header-container">
							<div class="profile-header-img">
								<img class="img-circle"
									src="<%=request.getContextPath()%>/Image?MemberID=${LoginOK.memberID}" />
								<!-- badge -->	
								<div class="rank-label-container">
									<a href="<%=request.getContextPath()%>/member/memberEdit.jsp"><button type="button" class="btn btn-info  btn-xs">
										編輯 <span class="glyphicon glyphicon-edit"></span>
									</button></a>
								</div>
							</div>
						</div>
						</c:if>
<!--                      講師頁面                                 -->
						<c:if test="${!empty Submembervo}">
                  		<div class="profile-header-container">
							<div class="profile-header-img">
								<img class="img-circle"
									src="<%=request.getContextPath()%>/Image?MemberID=${Submembervo.memberID}" />
								<!-- badge -->
							</div>
						</div>
						</c:if>
                </div>
                 <div class="col-md-6 no-pad text-center">
                 <c:if test="${empty Submembervo}">
                    <div class="user-pad" style="padding: 60px 0;">
                        <h2 style="color: white;">${LoginOK.mName}</h2>
                    </div>
                    </c:if>
                     <c:if test="${!empty Submembervo}">
                    <div class="user-pad" style="padding: 60px 0;">
                        <h2 style="color: white;">${Submembervo.mName}</h2>
                    </div>
                    </c:if>
                </div>
            </div>
           <c:if test="${empty Submembervo}"> 
            <div class="row overview panel-body" >
                <div class="col-md-6 user-pad text-center">
                <div class="hero-widget well  well-lg">
                    <h3>已參加</h3>
                    <h4>${buycourseCount}堂課</h4>
                </div>
                </div>
                <div class="col-md-6 user-pad text-center">
                <div class="hero-widget well  well-lg">
                    <h3>已開設</h3>
                    <h4>${mycourseCount}堂課</h4>
                    </div>
                </div>
            </div>
            </c:if>
            <div class="col-md-12">
					<div class="panel panel-success">
						<div class="panel-heading">
							<h4 class="text-center">關於我</h4>
						</div>
						<div class="panel-body text-center">
							<p class="lead">
							<p style="word-break: break-all; word-wrap: break-word">${empty Submembervo?LoginOK.aboutme:Submembervo.aboutme}
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
							<p style="word-break: break-all; word-wrap: break-word">${empty Submembervo?LoginOK.skill:Submembervo.skill}</p>
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
							<p style="word-break: break-all; word-wrap: break-word">${empty Submembervo?LoginOK.hobby:Submembervo.hobby}
							<p></p>
						</div>
					</div>
				</div>
        </div>
			<!-- 會員左半邊-->
			<div class="col-md-8 breadcrumb" >
			<c:if test="${empty Submembervo}">
				<div class="col-md-12" style="margin: 25px 0;">
					<div class="panel panel-info">
						<div class="panel-heading clickable panel-collapsed">
							<h3 class="panel-title">我開的課</h3>
							<span class="pull-right "><i
								class="glyphicon glyphicon-plus"></i></span>
						</div>
						<div class="panel-body" style="display: none;">
							<!-- 1 -->
							<c:forEach var="mycouser" items="${list}">
							<c:if test="${mycouser.soldPrice>0}">
							<div class=" col-md-4  col-sm-4" style="width: 211px">
							 <a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/onlineCourse-v2.jsp?CourseID=${mycouser.courseID}">
								<div class="card card-inverse">
									<img class="card-img-top"
										src="<%=request.getContextPath()%>/CourseImage?CourseID=${mycouser.courseID}"
										alt="course" id="wizardPicturePreview" title="">
									<div class="card-block">
										<figure class="profile">
											<img
												src="<%=request.getContextPath()%>/Image?MemberID=${LoginOK.memberID}"
												class="profile-avatar" alt="">
										</figure>
										<div class="card-text">
											<p id="title" class="card-title mt-3 multi_ellipsis">${mycouser.courseName}</p>
										</div>
									</div>
									</a>
									<div class="card-footer">
									<a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/CreateCourse.jsp?CourseID=${mycouser.courseID}">
										<button class="btn-info btn-sm center-block"
											style="margin-bottom: 5px; margin-top: 10px">編輯</button></a>
									</div>
								</div>
							</div>
							</c:if>
							<c:if test="${mycouser.soldPrice==0}">
							<div class=" col-md-4  col-sm-4" style="width: 211px">
							<a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/freeCourse-v1.jsp?CourseID=${mycouser.courseID}">
								<div class="card card-inverse">
									<img class="card-img-top"
										src="<%=request.getContextPath()%>/CourseImage?CourseID=${mycouser.courseID}"
										alt="course" id="wizardPicturePreview" title="">
									<div class="card-block">
										<figure class="profile">
											<img
												src="<%=request.getContextPath()%>/Image?MemberID=${LoginOK.memberID}"
												class="profile-avatar" alt="">
										</figure>
										<div class="card-text">
											<p id="title" class="card-title mt-3 multi_ellipsis">${mycouser.courseName}</p>
										</div>
									</div>
									</a>
									<div class="card-footer">
									<a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/CreateCourse.jsp?CourseID=${mycouser.courseID}">
										 <button class="btn-info btn-sm center-block"
											style="margin-bottom: 5px; margin-top: 10px">編輯</button></a>
									</div>
								</div>
							</div>
							</c:if>
							</c:forEach>
							<!-- 1 -->
							
						</div>
					</div>
				</div>
				<div class="col-md-12" style="margin: 25px 0;">
					<div class="panel panel-primary">
						<div class="panel-heading clickable panel-collapsed">
							<h3 class="panel-title">我修的課</h3>
							<span class="pull-right "><i
								class="glyphicon glyphicon-plus"></i></span>
						</div>
						<div class="panel-body" style="display: none;">

							<c:forEach var="buycouser" items="${list2}">
							<c:if test="${buycouser.soldPrice>0&&buycouser.targetStudentNumber==0}">
							<a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/onlineCourse-v2.jsp?CourseID=${buycouser.courseID}">
							<div class=" col-md-4  col-sm-4" style="width: 211px">
								<div class="card card-inverse">
									<img class="card-img-top"
										src="<%=request.getContextPath()%>/CourseImage?CourseID=${buycouser.courseID}"
										alt="course" id="wizardPicturePreview" title="">
									<div class="card-block">
										<figure class="profile">
											<img
												src="<%=request.getContextPath()%>/Image?MemberID=${buycouser.memberID}"
												class="profile-avatar" alt="">
										</figure>
										<div class="card-text">
											<p id="title" class="card-title mt-3 multi_ellipsis">${buycouser.courseName}</p>
										</div>
									</div>
								</div>
							</div>
							</a>
							</c:if>
							<c:if test="${buycouser.targetStudentNumber>0}">
							<a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/proposalCourse-v1.jsp?CourseID=${buycouser.courseID}">
							<div class=" col-md-4  col-sm-4" style="width: 211px">
								<div class="card card-inverse">
									<img class="card-img-top"
										src="<%=request.getContextPath()%>/CourseImage?CourseID=${buycouser.courseID}"
										alt="course" id="wizardPicturePreview" title="">
									<div class="card-block">
										<figure class="profile">
											<img
												src="<%=request.getContextPath()%>/Image?MemberID=${buycouser.memberID}"
												class="profile-avatar" alt="">
										</figure>
										<div class="card-text">
											<p id="title" class="card-title mt-3 multi_ellipsis">${buycouser.courseName}</p>
										</div>
									</div>
								</div>
							</div>
							</a>
							</c:if>
							</c:forEach>
					
						</div>
					</div>
				</div>
				
				<div class="col-md-12" style="margin: 25px 0;">
					<div class="panel panel-info">
						<div class="panel-heading clickable panel-collapsed">
							<h3 class="panel-title">審核中的課程</h3>
							<span class="pull-right "><i
								class="glyphicon glyphicon-plus"></i></span>
						</div>
						<div class="panel-body" style="display: none;">

							<c:forEach var="couser" items="${list6}">
							
							<div class=" col-md-4  col-sm-4" style="width: 211px">
								<div class="card card-inverse">
									<img class="card-img-top"
										src="<%=request.getContextPath()%>/CourseImage?CourseID=${couser.courseID}"
										alt="course" id="wizardPicturePreview" title="">
									<div class="card-block">
										<figure class="profile">
											<img
												src="<%=request.getContextPath()%>/Image?MemberID=${couser.memberID}"
												class="profile-avatar" alt="">
										</figure>
										<div class="card-text">
											<p id="title" class="card-title mt-3 multi_ellipsis">${couser.courseName}</p>
										</div>
									</div>
								</div>
							</div>
						
							</c:forEach>
					
						</div>
					</div>
				</div>
				
				<div class="col-md-12" style="margin: 25px 0;">
					<div class="panel panel-primary">
						<div class="panel-heading clickable panel-collapsed">
							<h3 class="panel-title">我的收藏課程</h3>
							<span class="pull-right "><i
								class="glyphicon glyphicon-plus"></i></span>
						 </div>
						<div class="panel-body" style="display: none;">
						<c:forEach var="mBookmark" items="${list3}">
						<c:if test="${mBookmark.soldPrice>0}">
						 <div id="click" class=" col-md-4  col-sm-4" style="width: 211px">
						  <a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/onlineCourse-v2.jsp?CourseID=${mBookmark.courseID}">
                    <div class="card card-inverse">
                    <img class="card-img-top" src="<%=request.getContextPath()%>/CourseImage?CourseID=${mBookmark.courseID}" alt="course" id="wizardPicturePreview" title="">
                    <div class="card-block">
                        <figure class="profile">
                            <img src="<%=request.getContextPath()%>/Image?MemberID=${mBookmark.memberID}" class="profile-avatar" alt="">
                        </figure>
                        <div class="card-text">
                        <p id="title" class="card-title mt-3 multi_ellipsis">${mBookmark.courseName}</p>                        	
                        </div>
                       </div>
                       </a>
                    <div class="card-footer">
                    <button class="btn-danger btn-sm center-block" style="margin-bottom: 5px;margin-top: 10px">取消訂閱</button>   
                     <input type="hidden" value="${mBookmark.courseID}">
                   <input type="hidden" value="${LoginOK.memberID}">
                    </div>
                    
                </div>
                </div>
                </c:if>
                <c:if test="${mBookmark.soldPrice==0}">
                 <div id="click" class=" col-md-4  col-sm-4" style="width: 211px">
                 <a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/freeCourse-v1.jsp?CourseID=${mBookmark.courseID}">
                    <div class="card card-inverse">
                    <img class="card-img-top" src="<%=request.getContextPath()%>/CourseImage?CourseID=${mBookmark.courseID}" alt="course" id="wizardPicturePreview" title="">
                    <div class="card-block">
                        <figure class="profile">
                            <img src="<%=request.getContextPath()%>/Image?MemberID=${mBookmark.memberID}" class="profile-avatar" alt="">
                        </figure>
                        <div class="card-text">
                        <p id="title" class="card-title mt-3 multi_ellipsis">${mBookmark.courseName}</p>                        	
                        </div>
                       </div>
                       </a>
                    <div class="card-footer">
                    <button class="btn-danger btn-sm center-block" style="margin-bottom: 5px;margin-top: 10px">取消訂閱</button>   
                     <input type="hidden" value="${mBookmark.courseID}">
                     <input type="hidden" value="${LoginOK.memberID}">
                    </div>
                    
                </div>
                </div>
                </c:if>
                </c:forEach>
						</div>
					</div>
				</div>
				
				<div class="col-md-12" style="margin: 25px 0;">
					<div class="panel panel-info">
						<div class="panel-heading clickable panel-collapsed">
							<h3 class="panel-title">我的草稿</h3>
							<span class="pull-right "><i
								class="glyphicon glyphicon-plus"></i></span>
						</div>
						<div class="panel-body" style="display: none;">
						<c:forEach var="mydraftcouser" items="${list4}">
						<div  id="click2" class=" col-md-4  col-sm-4" style="width: 211px">
								<div class="card card-inverse">
									<img class="card-img-top"
										src="<%=request.getContextPath()%>/CourseImage?CourseID=${mydraftcouser.courseID}"
										alt="course" id="wizardPicturePreview" title="">
									<div class="card-block">
										<figure class="profile">
											<img
												src="<%=request.getContextPath()%>/Image?MemberID=${mydraftcouser.memberID}"
												class="profile-avatar" alt="">
										</figure>
										<div class="card-text">
											<p id="title" class="card-title mt-3 multi_ellipsis">${mydraftcouser.courseName}</p>
										</div>
									</div>
									
									<div class="card-footer">
									
										<a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/CreateCourse.jsp?CourseID=${mydraftcouser.courseID}"><button class="btn-info btn-sm "
											style="margin-bottom: 5px; margin-top: 10px">編輯</button></a>
											<button class="btn-danger btn-sm pull-right"
											style="margin-bottom: 5px; margin-top: 10px">刪除</button>
												<input type="hidden" value="${mydraftcouser.courseID}">
                     							
									</div>
								</div>						
						</div>
						</c:forEach>
					</div>
				</div>
				</div>
				<div class="col-md-12" style="margin: 25px 0;">
					<div class="panel panel-primary">
						<div class="panel-heading clickable panel-collapsed">
							<h3 class="panel-title">募資中的課程</h3>
							<span class="pull-right "><i
								class="glyphicon glyphicon-plus"></i></span>
						</div>
						<div class="panel-body" style="display: none;">

							<c:forEach var="fundcouser" items="${list7}">
							<a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/proposalCourse-v1.jsp?CourseID=${fundcouser.courseID}">
							<div class=" col-md-4  col-sm-4" style="width: 211px">
								<div class="card card-inverse">
									<img class="card-img-top"
										src="<%=request.getContextPath()%>/CourseImage?CourseID=${fundcouser.courseID}"
										alt="course" id="wizardPicturePreview" title="">
									<div class="card-block">
										<figure class="profile">
											<img
												src="<%=request.getContextPath()%>/Image?MemberID=${fundcouser.memberID}"
												class="profile-avatar" alt="">
										</figure>
										<div class="card-text">
											<p id="title" class="card-title mt-3 multi_ellipsis">${fundcouser.courseName}</p>
										</div>
									</div>
								</div>
							</div>
						
							</c:forEach>
					</a>
						</div>
					</div>
				</div>
				
				
				<div class="col-md-12" style="margin: 25px 0;">
					<div class="panel panel-info">
						<div class="panel-heading clickable panel-collapsed">
							<h3 class="panel-title">備課中的課程</h3>
							<span class="pull-right "><i
								class="glyphicon glyphicon-plus"></i></span>
						</div>
						<div class="panel-body" style="display: none;">
						<c:forEach var="readycouser" items="${list8}">
						<div   class=" col-md-4  col-sm-4" style="width: 211px">
								<div class="card card-inverse">
									<img class="card-img-top"
										src="<%=request.getContextPath()%>/CourseImage?CourseID=${readycouser.courseID}"
										alt="course" id="wizardPicturePreview" title="">
									<div class="card-block">
										<figure class="profile">
											<img
												src="<%=request.getContextPath()%>/Image?MemberID=${readycouser.memberID}"
												class="profile-avatar" alt="">
										</figure>
										<div class="card-text">
											<p id="title" class="card-title mt-3 multi_ellipsis">${readycouser.courseName}</p>
										</div>
									</div>
									
									<div class="card-footer">
									
										<a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/CreateCourse.jsp?CourseID=${readycouser.courseID}"><button class="btn-info btn-sm "
											style="margin-bottom: 5px; margin-top: 10px">編輯</button></a>
									</div>
								</div>						
						</div>
						</c:forEach>
					</div>
				</div>
				</div>
				
				
				
				
				
				
				
				<div class="col-md-12" style="margin: 25px 0;">
					<div class="panel panel-primary">
						<div class="panel-heading clickable panel-collapsed">
							<h3 class="panel-title">我的追蹤講師</h3>
							<span class="pull-right "><i
								class="glyphicon glyphicon-plus"></i></span>
						</div>
						<div class="panel-body" style="display: none;">
						<c:forEach var="mySubscription" items="${list5}">						 
						 <div  id="click3" class=" col-md-3  col-sm-3" style="border: 1px solid #d4d4d5;width: 222px;height: 255px; margin:0 10px ">
						 <a style="text-decoration: none; color:black;" href="<%=request.getContextPath() %>/member/member.jsp?memberID=${mySubscription.memberID}">
								<div class="cprofile-header-img" style="width:120px;margin: auto; padding: 30px 0;">
									<img class="img-circle" style="width: 120px; height: 120px; border: 2px solid #51D2B7;" src="<%=request.getContextPath()%>/Image?MemberID=${mySubscription.memberID}" >
									
									<div class="card-block">
										<div class="card-text"  style="height: 5px;">
											<h5 style="text-align: center;">${mySubscription.mName}</h5>
										</div>
									</div>
									 </a>
									<div class="card-footer">
									
										<button  class="btn-danger btn-sm center-block">取消訂閱</button>
                       			 <input type="hidden" value="${mySubscription.memberID}">
                    			 <input type="hidden" value="${LoginOK.memberID}">
                     							
									</div>
								</div>						
							</div>
						</c:forEach>
						</div>
					</div>
				</div>
				</c:if>
<!-- 講師資訊 -->
<c:if test="${!empty Submembervo}">
						<div class="col-md-12" style="margin: 25px 0;">
					<div class="panel panel-info">
						<div class="panel-heading clickable panel-collapsed">
							<h3 class="panel-title">講師的課</h3>
							<span class="pull-right "><i
								class="glyphicon glyphicon-plus"></i></span>
						</div>
						<div class="panel-body" style="display: none;">
							<!-- 1 -->
							<c:forEach var="TeacherCourse" items="${TeacherCourselist}">
							<c:if test="${TeacherCourse.soldPrice>0}">
							<div class=" col-md-4  col-sm-4" style="width: 211px">
							 <a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/onlineCourse-v2.jsp?CourseID=${TeacherCourse.courseID}">
								<div class="card card-inverse">
									<img class="card-img-top"
										src="<%=request.getContextPath()%>/CourseImage?CourseID=${TeacherCourse.courseID}"
										alt="course" id="wizardPicturePreview" title="">
									<div class="card-block">
										<figure class="profile">
											<img
												src="<%=request.getContextPath()%>/Image?MemberID=${TeacherCourse.memberID}"
												class="profile-avatar" alt="">
										</figure>
										<div class="card-text">
											<p id="title" class="card-title mt-3 multi_ellipsis">${TeacherCourse.courseName}</p>
										</div>
									</div>
									</a>
									<div class="card-footer">
									</div>
								</div>
							</div>
							</c:if>
							<c:if test="${TeacherCourse.soldPrice==0}">
							<div class=" col-md-4  col-sm-4" style="width: 211px">
							<a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/freeCourse-v1.jsp?CourseID=${TeacherCourse.courseID}">
								<div class="card card-inverse">
									<img class="card-img-top"
										src="<%=request.getContextPath()%>/CourseImage?CourseID=${TeacherCourse.courseID}"
										alt="course" id="wizardPicturePreview" title="">
									<div class="card-block">
										<figure class="profile">
											<img
												src="<%=request.getContextPath()%>/Image?MemberID=${TeacherCourse.memberID}"
												class="profile-avatar" alt="">
										</figure>
										<div class="card-text">
											<p id="title" class="card-title mt-3 multi_ellipsis">${TeacherCourse.courseName}</p>
										</div>
									</div>
									</a>
									<div class="card-footer">
									</div>
								</div>
							</div>
							</c:if>
							</c:forEach>
							<!-- 1 -->
							
						</div>
					</div>
				</div>	
				</c:if>			
<!-- 講師資訊 -->
				
			</div>
		</div>
	</div>



	<jsp:include page="/footer.jsp" />
</body>
<script type="text/javascript">
// $(document).ready(function(){
// 	  $(this).click(function(){
// 		   $("#div1").fadeIn(3000);
// 		   $("#div1").fadeOut(3000);
// 	  });
// 	});


	$(document).on('click','.panel-heading span.clickable',
			function(e) {
				var $this = $(this);
				if (!$this.hasClass('panel-collapsed')) {
					$this.parents('.panel').find('.panel-body').slideUp();
					$this.addClass('panel-collapsed');
					$this.find('i').removeClass('glyphicon-minus').addClass(
							'glyphicon-plus');
				} else {
					$this.parents('.panel').find('.panel-body').slideDown();
					$this.removeClass('panel-collapsed');
					$this.find('i').removeClass('glyphicon-plus').addClass(
							'glyphicon-minus');
				}
			});
	$(document).on('click','.panel div.clickable',
			function(e) {
				var $this = $(this);
				if (!$this.hasClass('panel-collapsed')) {
					$this.parents('.panel').find('.panel-body').slideUp();
					$this.addClass('panel-collapsed');
					$this.find('i').removeClass('glyphicon-minus').addClass(
							'glyphicon-plus');
				} else {
					$this.parents('.panel').find('.panel-body').slideDown();
					$this.removeClass('panel-collapsed');
					$this.find('i').removeClass('glyphicon-plus').addClass(
							'glyphicon-minus');
				}
			});
	$(document).ready(function() {
		$('.panel-heading span.clickable').click();

	});
	 $('#click2>div').on('click','.card-footer>button:nth-child(2)',function(){
		   if( confirm("確定刪除草稿嗎?")){
			   $(this).parents('#click2').css("display","none")
			    $.get('/e-Look/com.e_Look.Course.control/CourseEditControlloer', {
				'courseID' : $(this).parents('#click2').find("input").val(),'member':"member"
				//'memberID' : $(this).parents('#click2').find("input+input").val()
			}, function() {
			})
		   }else{
			   
		   }
	 });
		   $('#click>div').on('click','.card-footer>button:nth-child(1)',function(){
			   if( confirm("確定取消訂閱嗎?")){
				   $(this).parents('#click').css("display","none")
				    $.get('/e-Look/MemberBookmarksInsertController', {
					'courseID' : $(this).parents('#click').find("input").val(),
					'memberID' : $(this).parents('#click').find("input+input").val()
				}, function() {
				})
			   }else{
				   
			   }
			   

// 			$.get('ProductsDelete',{'ProductID':id},function(data){
// 				alert(data);
// 				 loadProduct(1);
// 			})
});
		   $('#click3 button:nth-child(1)').on('click',function(){
			   console.log("123")
			   if( confirm("確定取消訂閱嗎?")){
				   $(this).parents('#click3').css("display","none")
				    $.get('/e-Look/MemberSubcriptionInsert_DeleteController', {
					'memberTrackID' : $(this).parents('#click3').find("input").val(),
					'memberID' : $(this).parents('#click3').find("input+input").val()
				}, function() {
				})
			   }else{
				   
			   }	
		   });

</script>
</html>