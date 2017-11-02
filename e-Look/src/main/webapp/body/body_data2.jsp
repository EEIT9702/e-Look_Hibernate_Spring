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
	
<!-- 		<div class="row"> -->
			<!-- 1-4 Template row -->
<!-- 			No.1 -->
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<!-- 請在影片縮圖處加入連結位置 ,更改影片縮圖路徑,及抓取要更改的影片名稱 -->
					<!-- 輸入要連結的jsp?courseID=輸入課程ID -->
					<a href="?courseID=${LoginOK.memberID}"><img class="img-responsive img-hover card-img-top"
						src="<%= request.getContextPath() %>/body/img/001.jpg" alt="course" id="wizardPicturePreview" title=""></a>
					<div class="card-block">
						<figure class="profile"><img
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png" class="profile-avatar"
							alt=""> </figure>
						<div class="card-text">
						
							<!-- 請在下方影片標題處加入連結位置 ,及抓取要更改的影片名稱 -->
							<!-- 輸入要連結的jsp?courseID=輸入課程ID -->
							<a href="?courseID="><p id="title" class="card-title mt-3 multi_ellipsis">${param.rowValueY}</p></a>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:31分鐘</small> <br> <small>觀看人數:113人</small>
					</div>
				</div>
			</div>
<!-- 			No.2 -->	
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<!-- 請在影片縮圖處加入連結位置 ,更改影片縮圖路徑,及抓取要更改的影片名稱 -->
					<!-- 輸入要連結的jsp?courseID=輸入課程ID -->
					<a href="?courseID="><img class="img-responsive img-hover card-img-top"
						src="<%= request.getContextPath() %>/body/img/002.jpg" alt="course" id="wizardPicturePreview" title=""></a>
					<div class="card-block">
						<figure class="profile"> <img
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png" class="profile-avatar"
							alt=""> </figure>
						<div class="card-text">
						
							<!-- 請在下方影片標題處加入連結位置 ,及抓取要更改的影片名稱 -->
							<!-- 輸入要連結的jsp?courseID=輸入課程ID -->
							<a href="?courseID="><p id="title" class="card-title mt-3 multi_ellipsis">${param.courseClass}</p></a>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:42分鐘</small> <br> <small>觀看人數:94人</small>
					</div>
				</div>
			</div>
			
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<!-- 請在影片縮圖處加入連結位置 ,更改影片縮圖路徑,及抓取要更改的影片名稱 -->
					<!-- 輸入要連結的jsp?courseID=輸入課程ID -->
					<a href="?courseID="><img class="img-responsive img-hover card-img-top"
						src="<%= request.getContextPath() %>/body/img/003.jpg" alt="course" id="wizardPicturePreview" title=""></a>
					<div class="card-block">
						<figure class="profile"> <img
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png" class="profile-avatar"
							alt=""> </figure>
						<div class="card-text">
						
							<!-- 請在下方影片標題處加入連結位置 ,及抓取要更改的影片名稱 -->
							<!-- 輸入要連結的jsp?courseID=輸入課程ID -->
							<a href="?courseID="><p id="title" class="card-title mt-3 multi_ellipsis">${param.keyWord}</p></a>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:28分鐘</small> <br> <small>觀看人數:225人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<!-- 請在影片縮圖處加入連結位置 ,更改影片縮圖路徑,及抓取要更改的影片名稱 -->
					<!-- 輸入要連結的jsp?courseID=輸入課程ID -->
					<a href="?courseID="><img class="img-responsive img-hover card-img-top"
						src="<%= request.getContextPath() %>/body/img/004.jpg" alt="course" id="wizardPicturePreview" title=""></a>
					<div class="card-block">
						<figure class="profile"> <img
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png" class="profile-avatar"
							alt=""> </figure>
						<div class="card-text">
						
							<!-- 請在下方影片標題處加入連結位置 ,及抓取要更改的影片名稱 -->
							<!-- 輸入要連結的jsp?courseID=輸入課程ID -->
							<a href="?courseID="><p id="title" class="card-title mt-3 multi_ellipsis">影片名稱4</p></a>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:37分鐘</small> <br> <small>觀看人數:172人</small>
					</div>
				</div>
			</div>
			<!-- end 1-4 Template -->
			