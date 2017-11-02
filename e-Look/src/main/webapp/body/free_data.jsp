<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.e_Look.CourseClassDetails.*"%>
<%@ page import="java.util.List" %>
<%@ page import="com.e_Look.Course.*" %>
<%
//接收參數
String ccName = request.getParameter("courseClass");
CourseClassDetailsDAO ccddao = new CourseClassDetailsDAO();
CourseDAO cdao = new CourseDAO();
if(ccName.length() != 0){
	Integer ccID = Integer.parseInt(ccName);
	
	CourseClassDetailsService ccdServ = new CourseClassDetailsService();
	List<CourseClassDetailsVO> ccdVOs = ccdServ.getFreeCourse(ccID);
	request.setAttribute("ccdVOs", ccdVOs);
	
	
}else {
	List<CourseVO> courseVOs =cdao.getAllFreeCourse();
	request.setAttribute("courseVOs", courseVOs);
}
%>
<style>
.card-text a {
	text-decoration: none;
	color: black;
}

.card-text a:hover {
	text-decoration: none;
	color: black;
}

.card-text a:visted {
	text-decoration: none;
	color: black;
}
small, .small {
    font-size: 15px;
}
</style>

<jsp:useBean id="course" scope="page" class="com.e_Look.Course.CourseDAO"/>

<!--免費影片forEach Star -->
<c:choose>
<c:when test="${!empty ccdVOs}">
<c:forEach var='freeCourse' items='${ccdVOs}' begin="${param.rowValueY}" end="${param.rowValueY + 3}">
	<div class="col-md-6 col-sm-6 col-lg-4 col-xs-6" id="course" style="width:341px;margin-bottom:20px;">
		<div class="card card-inverse" style="background-color: white;">
			<a style="text-decoration: none; color: black"; href="<%=request.getContextPath() %>/freeCourse-v1.jsp?CourseID=${freeCourse.courseVO.courseID}">
				<img class="card-img-top img-rounded center-block" src="<%=request.getContextPath() %>/CourseImage?CourseID=${freeCourse.courseVO.courseID}" alt="course" id="wizardPicturePreview" title="" style="width:98%">
			</a>
			<div class="card-block">
				<figure class="profile">
					<img src="<%=request.getContextPath() %>/Image?MemberID=${freeCourse.courseVO.memberID}" class="profile-avatar" alt="">
				</figure>
				<div class="card-text">
					<a style="text-decoration: none; color: black"; href="<%=request.getContextPath() %>/freeCourse-v1.jsp?CourseID=${freeCourse.courseVO.courseID}">
						<p id="title" class="card-title mt-3 multi_ellipsis">${freeCourse.courseVO.courseName}</p>
					</a>
				</div>
				<div>
					<p style="margin-top: 40px; font-size: 18px">課程售價：<b style="color:red;">免費</b></p>
				</div>
			</div>
			<div class="card-footer">
				<small style="font-size: 18px;">課程時間:${freeCourse.courseVO.courseLength}分鐘</small>
				<br>
				<small style="font-size: 18px;" class="number" alt="${freeCourse.courseVO.courseID}">購買人數:xxx人</small>
			</div>
		</div>
	</div>
</c:forEach>
</c:when>
<c:otherwise>
<c:forEach var='courseVO' items='${courseVOs}' begin="${param.rowValueY}" end="${param.rowValueY + 3}">
	<div class="col-md-6 col-sm-6 col-lg-4 col-xs-6" id="course" style="width:341px;margin-bottom:20px;">
		<div class="card card-inverse" style="background-color: white;">
			<a style="text-decoration: none; color: black"; href="<%=request.getContextPath() %>/freeCourse-v1.jsp?CourseID=${courseVO.courseID}">
				<img class="card-img-top img-rounded center-block" src="<%=request.getContextPath() %>/CourseImage?CourseID=${courseVO.courseID}" alt="course" id="wizardPicturePreview" title="" style="width:98%">
			</a>
			<div class="card-block">
				<figure class="profile">
					<img src="<%=request.getContextPath() %>/Image?MemberID=${courseVO.memberID}" class="profile-avatar" alt="">
				</figure>
				<div class="card-text">
					<a style="text-decoration: none; color: black"; href="<%=request.getContextPath() %>/freeCourse-v1.jsp?CourseID=${courseVO.courseID}">
						<p id="title" class="card-title mt-3 multi_ellipsis">${courseVO.courseName}</p>
					</a>
				</div>
				<div>
					<p style="margin-top: 40px; font-size: 18px">課程售價：<b style="color:red;">免費</b></p>
				</div>
			</div>
			<div class="card-footer">
				<small style="font-size: 18px;">課程時間:${courseVO.courseLength}分鐘</small>
				<br>
				<small style="font-size: 18px;" class="number" alt="${courseVO.courseID}">購買人數:xxx人</small>
			</div>
		</div>
	</div>
</c:forEach>

</c:otherwise>
</c:choose>

<script>
$(function(){
	$('.number').each(function(){
	var i=$(this);
		
		$.getJSON('/e-Look/GetBuyCourseNumber',{'courseID':$(this).attr("alt")},function(datas){
			//console.log($(this).html())
			i.html("購買人數:"+datas.length+"人")
		})
	})
	
})

</script>
<!--免費影片forEach End -->


			