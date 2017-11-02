<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.card-text a{
	text-decoration: none;
	color:black;
}
.card-text a:hover{
	text-decoration: none;
	color:black;
}
.card-text a:visted{
	text-decoration: none;
	color:black;
}
</style> 

<jsp:useBean id="course" scope="page" class="com.e_Look.Course.CourseDAO"/>
<!-- forEach Star-->
 <c:forEach var='freeCourse' items='${course.allonlineCourse}'>
	<c:if test="${freeCourse.soldPrice == 0}">
		<div class="col-md-3 col-sm-6 col-lg-3 col-xs-6 img-portfolio" id="course" style="width: 341px">
				<div class="card card-inverse" style="background-color:white">
					<a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/freeCourse-v1.jsp?CourseID=${freeCourse.courseID}">
					<img class="card-img-top" src="<%=request.getContextPath() %>/CourseImage?CourseID=${freeCourse.courseID}" alt="course"
						id="wizardPicturePreview" title="">
					</a>
					<div class="card-block">
						<figure class="profile">
							<img src="<%=request.getContextPath() %>/Image?MemberID=${freeCourse.memberID}" class="profile-avatar" alt="">
						</figure>
						<div class="card-text">
							<a style="text-decoration: none; color:black"; href="<%=request.getContextPath() %>/freeCourse-v1.jsp?CourseID=${freeCourse.courseID}">
							<p id="title" class="card-title mt-3 multi_ellipsis">${freeCourse.courseName}</p>
							</a>
						</div>
					<div>
						<p style="margin-top: 40px; font-size: 18px">課程售價：${freeCourse.soldPrice}</p>
					</div>
				</div>
				<div class="card-footer">
					<button class="btn-info btn-sm pull-right"
						style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
					<small>課程時間:${freeCourse.courseLength}分鐘</small> <br> <small>購買人數:xxx人</small>
				</div>
				</div>
		</div>
	</c:if>
</c:forEach>
<!--forEach End-->

