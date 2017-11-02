<%@page import="com.e_Look.shoppingCart.model.jdbc.ShoppingCartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="com.e_Look.Course.*" %>
    <%@ page import="java.util.List" %>
<%	/*List<CourseVO> shoppingCartList= (List<CourseVO>) session.getAttribute("shoppingCartList");
int courseCount=0;
if(shoppingCartList != null){
    courseCount = shoppingCartList.size();  }*/
    %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <title>Insert title here</title> -->
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-3.3.7-dist/css/bootstrap.css"> --%>
<link href="<%=request.getContextPath()%>/HeaderCssJs/bootstrap.css" rel="stylesheet">
<%-- <script src="<%=request.getContextPath()%>/HeaderCssJs/jquery.js"></script> --%>
<%-- <script src="<%=request.getContextPath()%>/HeaderCssJs/bootstrap.min.js"></script> --%>
<style>

*{
	text-decoration: none
}
.navbar {
	background: rgba(255, 255, 255, 0.25);
	border: none;
	background: #8999A8;
}

.nav>li>a {
	border-bottom: 3px solid transparent;
}

.nav>li>a:focus, .nav>li>a:hover, .nav .open>a, .nav .open>a:focus, .nav .open>a:hover
	 {
	border-bottom: 3px solid transparent;
	background: none;
}

.navbar a,  .navbar-toggle {
	color: #fff;
}

.dropdown-menu {
	-webkit-box-shadow: none;
	box-shadow: none;
}

#navbar .nav .tt:hover:nth-child(4n+1), #navbar .nav .tt.active:nth-child(4n+1) {
	border-bottom: #C4E17F 3px solid;
}

#navbar .nav .tt:hover:nth-child(4n+2),#navbar .nav .tt.active:nth-child(4n+2) {
	border-bottom: #F7FDCA 3px solid;
}

#navbar .nav .tt:hover:nth-child(4n+3),#navbar .nav .tt.active:nth-child(4n+3) {
	border-bottom: #FECF71 3px solid;
}

#navbar .nav .tt:hover:nth-child(4n+4),#navbar .nav .tt.active:nth-child(4n+4) {
	border-bottom: #F0776C 3px solid;
}


.navbar-toggle .icon-bar {
	color: #fff;
	background: #fff;
}
body{
padding-top:75px;
font-family:Microsoft JhengHei;
}
#headerTextStyle{
font-family: Microsoft JhengHei;
font-size: 18px;
}
/*******ShoppingCartStyleStart***********/
.courseTitle {
	font-size: 20px;
	color: #3e3d3e;
	width: 70%;
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
	float: right;
	font-weight: bold;
}

.courseSubtitle {
	font-size: 16px;
	float: left;
}

.courseDelete {
	float: right;
	padding-right: 10px;
}

.cartrows {
	overflow-x: hide;
	overflow: auto;
	max-height: 40vh;
}

.cartrow {
	width: 90%;
	padding: 20px;
	border-bottom: 1px solid #cccccc;
	margin: auto;
}

.cartrow img {
	width: 30%;
	height: 70px;
}

.close {
	float: none;
}

.cartcount {
	position: absolute;
	right: 5px;
	border: 1px solid #FFF;
	background: #F68867;
	color: #FFF;
	border-radius: 100px;
	font-size: 12px;
	font-weight: bold;
	text-align: center;
	z-index: 15;
	width: 20px;
	height: 20px;
}

/*******ShoppingCartStyleEnd***********/
</style>
</head>

	<div class="navbar-wrapper" id="headerTextStyle">
		<div class="container-fluid">
			<nav class="navbar navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed black-center"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							
							<span class="sr-only"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a href="<%=request.getContextPath()%>/HOME.jsp"><img
							src="<%=request.getContextPath()%>/HeaderCssJs/eLook_LOGO.png"
							height="77" alt="e-Look"></a>
					</div>
					<div id="navbar" class="navbar-collapse collapse" >
						<ul class="nav navbar-nav">
							<li style="padding-top:12px" class="tt"><a 
								href="<%=request.getContextPath()%>/fundraisingCourse.jsp"><img
									src="<%=request.getContextPath()%>/HeaderCssJs/003-coins.png"
									height="28">募資</a></li>
							<li style="padding-top:12px" class="tt"><a 
								href="<%=request.getContextPath()%>/onlineCourse_Home.jsp"><img
									src="<%=request.getContextPath()%>/HeaderCssJs/002-team.png"
									height="28">線上課程</a></li>
							<li style="padding-top:12px" class="tt"><a 
								href="<%=request.getContextPath()%>/freeCourse_Home.jsp"><img
									src="<%=request.getContextPath()%>/HeaderCssJs/004-gift.png"
									height="28">免費課程</a></li>

							<li style="padding-top:12px" class="tt"><a
								href="<%=request.getContextPath()%>/CreateCourseCotroller"><img
									src="<%=request.getContextPath()%>/HeaderCssJs/001-book.png"
									height="28">我要開課</a></li>
							<li style="padding-top:12px" class="tt"><a
								href="<%=request.getContextPath()%>/backstage/backHome1.jsp"><img
									src="<%=request.getContextPath()%>/_Lyy/175x175bb.jpg"
									height="28">暗黑破壞神</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<c:choose>
								<c:when test="${!empty LoginOK}">
								<input id="gbmemberID" type="hidden" value="${LoginOK.memberID}"/>
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="false"
										aria-expanded="false"><span class="cartcount"></span><img style="margin-top:15px"
											src="<%=request.getContextPath()%>/HeaderCssJs/002-shopping-cart.png"
											height="26" /></a> <!-- 				以下為購物車內容 -->
										<ul class="dropdown-menu" style="width: 465px;">
											<li class="dropdown-header"
												style="border-bottom: 1px solid #aaaaaa;"><h3></h3></li>
											<!-- 				課程1 -->
										
											<div class="cartrows">
											
											<!--<c:forEach var="courseVO" items="${shoppingCartList}">
												<div class="cartrow">
													<div style="text-align: right;">
														<div style="float: left; width: 80%; text-align: left;"></div>
														<button id="delete${courseVO.courseID}" class="close" style="color:red" type="button" aria-hidden="true">&times;</button>
													</div>
													<img src="<%=request.getContextPath() %>/CourseImage?CourseID=${courseVO.courseID}">
													<span class="courseTitle">${courseVO.courseName} <br>
														<span class="courseSubtitle">科技,語言,IT</span> <span
														class="courseDelete"></span><br> <span
														class="courseDelete">$ ${courseVO.soldPrice} 元</span>
													</span>
												</div>
												</c:forEach>-->
												<!-- 				課程2 -->
											</div>
											<div class="modal-body text-right">
												<div id="courseCount" style="float: left;">共 0 筆課程</div>
												<span id="totalPrice">總金額：0元</span>
											</div>
											<div class="modal-footer">
												<a href="<%= request.getContextPath() %>/settled.jsp">
												<button type="button" class="btn btn-primary btn-block">前往結帳</button>
												</a>
											</div>
										</ul> 
										<!-- 				以上為購物車內容 --></li>
								</c:when>
								<c:otherwise>
									<li style="padding-top:13px"><a href="#"><img
											src="<%=request.getContextPath()%>/HeaderCssJs/002-shopping-cart.png"
											height="24" /></a></li>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${!empty LoginOK}">
									<li class="dropdown "><a href="#" class=" dropdown-toggle"
										id="dropdownMenu1" data-toggle="dropdown"><img
											src="<%=request.getContextPath() %>/Image?MemberID=${LoginOK.memberID}"
											height="40" class="" /><span class="caret"></span></a>
										<ul class="nav dropdown-menu" aria-labelledby="dropdownMenu1" style="font-size: 18px;border-radius:5px">
											<li class="text-center"><a
												href="<%=request.getContextPath()%>/member/member.jsp"><img
													align="left"
													src="<%=request.getContextPath()%>/HeaderCssJs/member.png"
													height="26">會員中心</a></li>
											<li style="padding-top: 0px;" role="presentation"
												class="divider"></li>
											<li class="text-center"><a href="<%=request.getContextPath()%>/member/consume.jsp"><img align="left"
													src="<%=request.getContextPath()%>/HeaderCssJs/wallet.png"
													height="26">我的消費</a></li>
											<li style="padding-top: 0px;" role="presentation"
												class="divider"></li>
											<li class=" text-center"><a onclick="signOut()"
												href="<%=request.getContextPath()%>/logout.do"><img
													align="left"
													src="<%=request.getContextPath()%>/HeaderCssJs/exit.png"
													height="26">登出</a></li>
										</ul></li>
								</c:when>
								<c:when test="${!empty loginerr}">
									<li style="padding-top:12px"><a href="#" data-toggle="modal" data-target="#myModal2"><img
											src="<%=request.getContextPath()%>/HeaderCssJs/001-login.png"
											height="26" />登入</a></li>
								</c:when>
								<c:when test="${empty err}">
									<li style="padding-top:12px"><a href="#" data-toggle="modal" data-target="#myModal"><img
											src="<%=request.getContextPath()%>/HeaderCssJs/001-login.png"
											height="26" />登入</a></li>
								</c:when>
								<c:otherwise>
									<li style="padding-top:12px"><a href="#" data-toggle="modal"	data-target="#myModal2"><img
											src="<%=request.getContextPath()%>/HeaderCssJs/001-login.png"
											height="26" />登入</a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
	
<script>
$(function(){
	var memberID=$('#gbmemberID').val();
	
	
	if(memberID>1){
		loadShoppingCart();
	}
	
	function loadShoppingCart(){
		$.post('<%=request.getContextPath() %>/LoadShoppingCart',{"memberID":memberID},function(datas){
			var fg = $(document.createDocumentFragment());
			$('.cartrows').empty();
			var totalPrice = 0;
			var courseCount = 0;
			$.each(datas,function(idx,courseVO){
				var buyingPrice = getBuyingPrice(courseVO.courseID);
				var courseClass = getCourseClass(courseVO.courseID);
				var cell1 = $('<div></div>').addClass('cartrow').val(courseVO.courseID);
				var cell2 = $('<div></div>').css('text-align','right');
				var cell3 = $('<div></div>').css(['float','left','width','80%','text-align','left']);
				var cell4 = $('<button></button>').css('color','red').addClass('close glyphicon glyphicon-remove').attr({'type':'button','name':courseVO.courseID});
				var cell5 = $('<img>').attr({'src':'<%=request.getContextPath() %>/CourseImage?CourseID='+courseVO.courseID,'alt':'<%= request.getContextPath()%>/img/請上傳課程封面.png'});
				var cell6 = $('<span></span>').addClass('courseTitle').text(courseVO.courseName);
				var cell7 = $('<br>')
				var cell8 = $('<span></span>').addClass('courseSubtitle').text(courseClass);
				var cell9 = $('<span></span>').addClass('courseDelete')
				var cell10 = $('<br>');				var cell11 = $('<span></span>').addClass('courseDelete').text('$' + buyingPrice+'元');
				cell2.append([cell3,cell4])
				cell6.append([cell7,cell8,cell9,cell10,cell11])
				cell1.append([cell2,cell5,cell6])
				fg.append(cell1)
				totalPrice+=buyingPrice;
				courseCount++;
			})
			$('.cartrows').append(fg);
			$('#totalPrice').text('總金額：'+totalPrice+'元');
			$('#courseCount').text('共'+courseCount+'筆課程');
			$('.cartcount').text(courseCount);
			//$('#gbmemberID+li>a').attr('data-toggle','dropdown');
			$('.cartcount').css('display','block');
			if(courseCount==0){
				$('.cartcount').css('display','none');
				//$('#gbmemberID+li>a').attr('data-toggle','no');
			}
		},'json')
	$('.cartrows').on('click','button',deleteShoppingCart);
	}
	function deleteShoppingCart(){
		var courseID=$(this).attr('name');
		$.post('<%=request.getContextPath() %>/LoadShoppingCart',{"memberID":memberID,"courseID":courseID},function(datas){
			loadShoppingCart();
		})
	}
	function getBuyingPrice(courseID){
		var buyingPrice = 99999;
		$.ajax({'url':'<%=request.getContextPath() %>/GetBuyingPrice',
				'async':false,
				'data':{'courseID':courseID},
				'success':function(result){
					buyingPrice = parseInt(result);
				}
		});//$.ajax end
		return buyingPrice;
	};
	function getCourseClass(courseID){
		var courseClass="";
		$.ajax({'url':'<%=request.getContextPath() %>/GetCourseClass',
			'async':false,
			'data':{'courseID':courseID},
			'success':function(result){
				courseClass = result;
			}
	});//$.ajax end
	return courseClass;
		
	}
	$(function(){
		$('#intoShoppingCart').on('click',function(){
			if($("#mbcourseID").val()>1){
			console.log("cart!!!")
					$.post('<%= request.getContextPath()%>/InsertShoppingCart',{
						'memberID':$("#mbmemberID").val(),
						'courseID':$("#mbcourseID").val()
						},function(){
							alert("已經加入購物車囉!!");
							loadShoppingCart();
						})			
			}
		})
	});
	
	
})
</script>