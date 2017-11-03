<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!-- 		<div class="row"> -->
			<!-- 1-4 Template row -->
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top"
						src="<%= request.getContextPath() %>/body/img/001.jpg" alt="course" id="wizardPicturePreview" title="">
					<div class="card-block">
						<figure class="profile"> <img
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png" class="profile-avatar"
							alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">${param.rowValueY}</p>
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
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top"
						src="<%= request.getContextPath() %>/body/img/002.jpg" alt="course" id="wizardPicturePreview" title="">
					<div class="card-block">
						<figure class="profile"> <img
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png" class="profile-avatar"
							alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題2</p>
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
					<img class="img-responsive img-hover card-img-top"
						src="<%= request.getContextPath() %>/body/img/003.jpg" alt="course" id="wizardPicturePreview" title="">
					<div class="card-block">
						<figure class="profile"> <img
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png" class="profile-avatar"
							alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題3</p>
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
					<img class="img-responsive img-hover card-img-top"
						src="<%= request.getContextPath() %>/body/img/004.jpg" alt="course" id="wizardPicturePreview" title="">
					<div class="card-block">
						<figure class="profile"> <img
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png" class="profile-avatar"
							alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題4</p>
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
			<!-- <br> -->
			<!-- 5-8 Template row -->
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/005.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題5</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:43分鐘</small> <br> <small>觀看人數:24人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/006.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題6</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:36分鐘</small> <br> <small>觀看人數:260人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/007.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題7</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:48分鐘</small> <br> <small>觀看人數:145人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/008.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題8</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:38分鐘</small> <br> <small>觀看人數:312人</small>
					</div>
				</div>
			</div>
			<!-- end 5-8 Template -->
			<!-- <br> -->
			<!-- 9-12 Template row -->
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/009.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題9</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:33分鐘</small> <br> <small>觀看人數:423人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/010.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題10</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:40分鐘</small> <br> <small>觀看人數:166人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/011.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題11</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:32分鐘</small> <br> <small>觀看人數:151人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/012.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題12</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:31分鐘</small> <br> <small>觀看人數:67人</small>
					</div>
				</div>
			</div>
			<!-- end 9-12 Template -->
			<!-- <br> -->
			<!-- 13-16 Template row -->
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/001.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題13</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:34分鐘</small> <br> <small>觀看人數:153人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/002.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題14</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:147分鐘</small> <br> <small>觀看人數:124人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/003.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題15</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:38分鐘</small> <br> <small>觀看人數:121人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/004.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題16</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:32分鐘</small> <br> <small>觀看人數:148人</small>
					</div>
				</div>
			</div>
			<!-- end 13-16 Template -->
			<!-- <br> -->
			<!-- 17-20 Template row -->
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/005.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題17</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:25分鐘</small> <br> <small>觀看人數:454人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/006.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題18</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:30分鐘</small> <br> <small>觀看人數:140人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/007.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題19</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:27分鐘</small> <br> <small>觀看人數:273人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/008.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題20</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:42分鐘</small> <br> <small>觀看人數:302人</small>
					</div>
				</div>
			</div>
			<!-- end 17-20 Template -->
			<!-- <br> -->
			<!-- 21-24 Template row -->
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/009.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題21</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:28分鐘</small> <br> <small>觀看人數:333人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/010.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題22</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:47分鐘</small> <br> <small>觀看人數:126人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/011.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題23</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:39分鐘</small> <br> <small>觀看人數:167人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/012.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題24</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:34分鐘</small> <br> <small>觀看人數:289人</small>
					</div>
				</div>
			</div>
			<!-- end 21-24 Template -->
			<!-- <br> -->
			<!-- 25-28 Template row -->
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/001.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題25</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:34分鐘</small> <br> <small>觀看人數:110人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/002.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題26</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:34分鐘</small> <br> <small>觀看人數:216人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/003.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題27</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:30分鐘</small> <br> <small>觀看人數:246人</small>
					</div>
				</div>
			</div>
			<div class="item col-md-3 col-sm-6 col-xs-6 img-portfolio">
				<div class="card card-inverse">
					<img class="img-responsive img-hover card-img-top" 
						src="<%= request.getContextPath() %>/body/img/004.jpg" alt="course" id="wizardPicturePreview"
						title="">
					<div class="card-block">
						<figure class="profile"> <img 
							src="<%= request.getContextPath() %>/Class Steps/imgs/eLook_LOGO1.png"
							class="profile-avatar" alt=""> </figure>
						<div class="card-text">
							<p id="title" class="card-title mt-3 multi_ellipsis">測試課程標題28</p>
						</div>
						<div>
							<p style="margin-top: 40px; font-size: 18px">課程售價：免費</p>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn-info btn-sm pull-right"
							style="margin-bottom: 5px; margin-top: 10px">加入書籤</button>
						<small>課程時間:37分鐘</small> <br> <small>觀看人數:161人</small>
					</div>
				</div>
			</div>
			<!-- end 25-28 Template -->
			
		<!-- end of row -->
<!-- 		</div> -->
