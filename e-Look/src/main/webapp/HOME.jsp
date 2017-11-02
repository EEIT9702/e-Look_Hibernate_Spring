<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<link href="<%=request.getContextPath()%>/css/bootstrap-3.3.7-dist/css/bootstrap.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/HeaderCssJs/jquery.js"></script>
<script src="<%=request.getContextPath()%>/HeaderCssJs/bootstrap.min.js"></script>
<link rel="Shortcut Icon" type="image/x-icon" href="${SYSTEM.iconUri}" />
<html>
<style>
#title12 {
	border-bottom: solid 1px #FF8800;
	padding-top: 30px;
}
</style>
<style type="text/css">
#title1 {
	padding-top: 30px;
}

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
	width: 310px;
	height: 200px;
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

#course {
	margin-top: 20px
}

a:HOVER {
	color: black;
}

#div1 {
	width: 100%;
}
s
#body{background-color: #FAEBD7;}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>

<body id="body" style="margin-top: 50px">
	<jsp:include page="/login.jsp" />
	<jsp:useBean id="course" scope="page"
		class="com.e_Look.Course.CourseDAO" />

	<div class="container-fluid"
		style="background-color: black; margin: -50px">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<jsp:include page="advertising.jsp" />
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-12" id="title12">
				<div class="col-md-6 ">
					<div class="text-left" style="font-size: 28px">熱門課程</div>
				</div>
				<div class="col-md-6">
					<div class="text-right" style="margin-top: 10px">
						<a class="btu"
							href="<%=request.getContextPath()%>/onlineCourse_Home.jsp">>>更多課程</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row" style="padding-left: 40px">
			<!--for each  -->
			<c:forEach var='listcourse' items='${course.allonlineCourse}' begin="0" end="7">
				<c:if test="${listcourse.soldPrice>0}">
					<div class="col-md-6 col-sm-6 col-lg-4 col-xs-6" id="course"
						style="width: 341px">
						<a style="text-decoration: none; color: black"
							 href="<%=request.getContextPath() %>/onlineCourse-v2.jsp?CourseID=${listcourse.courseID}">
							<div class="card card-inverse" style="background-color: white;">
								<img class="card-img-top img-rounded center-block"
									src="<%=request.getContextPath() %>/CourseImage?CourseID=${listcourse.courseID}"
									alt="course" id="wizardPicturePreview" title="" style="width:98%">
								<div class="card-block">
									<figure class="profile">
										<img
											src="<%=request.getContextPath() %>/Image?MemberID=${listcourse.memberID}"
											class="profile-avatar" alt="">
									</figure>
									<div class="card-text">
										<p id="title" class="card-title mt-3 multi_ellipsis">${listcourse.courseName}</p>
									</div>
						</a>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：${listcourse.soldPrice}</p>
						</div>
					</div>
					<div class="card-footer">
						
						<small style="font-size: 18px;">課程時間:${listcourse.courseLength}分鐘</small> <br> <small style="font-size: 18px;"  class="number" alt="${listcourse.courseID}" >購買人數:zzz人</small>
					</div>

				</div>
			</div>
			</c:if>
			

	


	<c:if test="${listcourse.soldPrice==0}">
		<div class="col-md-6 col-sm-6 col-lg-4 col-xs-6" id="course"
			style="width: 341px">
			<a style="text-decoration: none; color: black"
				 href="<%=request.getContextPath() %>/freeCourse-v1.jsp?CourseID=${listcourse.courseID}">
				<div class="card card-inverse" style="background-color: white;">
					<img class="card-img-top img-rounded center-block"
									src="<%=request.getContextPath() %>/CourseImage?CourseID=${listcourse.courseID}"
									alt="course" id="wizardPicturePreview" title="" style="width:98%">
					<div class="card-block">
						<figure class="profile">
							<img
								src="<%=request.getContextPath() %>/Image?MemberID=${listcourse.memberID}"
								class="profile-avatar" alt="">
						</figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">${listcourse.courseName}</p>
						</div>
			</a>
			<div>
				<p style="margin-top: 40px; font-size: 18px">課程售價：${listcourse.soldPrice}</p>
			</div>
		</div>
		<div class="card-footer">
			
			<small style="font-size: 18px;" >課程時間:${listcourse.courseLength}分鐘</small> <br> <small style="font-size: 18px;" class="number" alt="${listcourse.courseID}">購買人數:zzz人</small>
		</div>
	</div>
	</div>
	</c:if>
	</c:forEach>
	<!--for each  -->

	</div>
	</div>
	
	
	<jsp:useBean id="fundcourse" scope="page" class="com.e_Look.Course.CourseDAO" />
	
	<div class="container">
		<div class="row">

			<div class="col-md-12" id="title12">
				<div class="col-md-6 " >
					<div class="text-left" style="font-size: 28px">募資課程</div>
				</div>
				<div class="col-md-6">
					<div class="text-right" style="margin-top: 10px">
						<a class="btu"
							href="<%=request.getContextPath()%>/fundraisingCourse.jsp">>>更多課程</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row" style="padding-left: 40px">
			<!-- 	1 -->
			<c:forEach var='fundCourse' items='${fundcourse.allFundRaiseCourse}' begin="0" end="7">
			<div class="col-md-6 col-sm-6 col-lg-4 col-xs-6" id="course"
				style="width: 341px">
				<div class="card card-inverse" style="background-color: white;">
								<a style="text-decoration: none; color: black"; href="<%=request.getContextPath() %>/proposalCourse-v1.jsp?CourseID=${fundCourse.courseID}">
				<img class="card-img-top img-rounded center-block" src="<%=request.getContextPath() %>/CourseImage?CourseID=${fundCourse.courseID}" alt="course" id="wizardPicturePreview" title="" style="width:98%">
			</a>
			<div class="card-block">
				<figure class="profile">
					<img src="<%=request.getContextPath() %>/Image?MemberID=${fundCourse.memberID}" class="profile-avatar" alt="">
				</figure>
				<div class="card-text">
					<a style="text-decoration: none; color: black"; href="<%=request.getContextPath() %>/proposalCourse-v1.jsp?CourseID=${fundCourse.courseID}">
						<p id="title" class="card-title mt-3 multi_ellipsis">${fundCourse.courseName}</p>
					</a>
				</div>
				<div style="margin-top:40px;">
					<p style="font-size:18px;float:left;">預購價：
						<fmt:setLocale value="zh-TW" />

						<fmt:formatNumber value="${fundCourse.soldPrice*0.7}" type="currency" maxFractionDigits="0"/>

					</p>
<%-- 					<p class="fundend" style="font-size:18px;float:right;">募資截止日：<fmt:formatDate value="${fundCourse.fundEndDate}" type="date"/></p> --%>
					<p class="fundend" style="font-size:18px;float:right;" alt="${fundCourse.fundEndDate}"></p>
				</div>
				<div class="progress" style="clear:both;">
					<div class="progress-bar progress-bar-warning progress-bar-striped active" 
					role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" 
					style="width:100%" alt="${fundCourse.targetStudentNumber}" data="${fundCourse.courseID}">
					<p style="display:none"></p>
					
					</div>
				</div>
				<div>
					<p style="font-size:18px;text-align:center;clear:both;padding-top:8px;" class="fund" alt="${fundCourse.targetStudentNumber}" data="${fundCourse.courseID}" >已募資1/${fundCourse.targetStudentNumber}人</p>
				</div>
			</div>
				</div>
			</div>
			</c:forEach>

		</div>
	</div>
	<c:remove var="err" scope="session" />
	<c:remove var="loginerr" scope="session" />
	<jsp:include page="/footer.jsp" />
	<script>
	$(function(){
		
		
		
		$('.progress-bar').each(function(){
			var i=$(this);
			$.getJSON('/e-Look/GetBuyCourseNumber',{'courseID':$(this).attr("data")},function(datas){
				//console.log($(this).html())
				count=(datas.length/i.attr("alt"))*100
				//console.log(i.children("p").html())
				//console.log(count)
 				i.children("p").html(parseInt(count)+"%")
 				//console.log(i.children("p").html())
 				
 				var pbVal = $('.progress-bar').text();
				//var endVal = $($('.fundend')[1]).val();
				$('.progress-bar').removeAttr('style');
				$('.progress-bar').each(function(){
					//console.log($(this).text());
					console.log($(this).val());
					$(this).attr('style','width:'+$(this).text());
				})	
			})
		})
		//console.log($('.progress-bar').text());
		
		//var endVal = $('.fundend').val();
		var endVal = $('.fundend').attr("alt");
		$('.fundend').each(function(){
			console.log($(this).attr("alt"));
			var ed = new Date($(this).attr("alt"));
			var now = new Date();
			var time = ed.getTime() - now.getTime();
			time /= 1000;
			var ntime = time / (24*60*60);
			ntime = Math.floor(ntime);
			console.log(ntime);
			$(this).text("倒數" + ntime + "天")
		})
		
		$('.number').each(function(){
		var i=$(this);
			
			$.getJSON('/e-Look/GetBuyCourseNumber',{'courseID':$(this).attr("alt")},function(datas){
				//console.log($(this).html())
				i.html("購買人數:"+datas.length+"人")
			})

		})
		
		$('.fund').each(function(){
			var i=$(this);
			$.getJSON('/e-Look/GetBuyCourseNumber',{'courseID':$(this).attr("data")},function(datas){
				//console.log($(this).html())
				i.html("已募資"+datas.length+"/"+i.attr("alt")+"人")
			})

		})
		
			

	
	})
</script>
</body>
</html>