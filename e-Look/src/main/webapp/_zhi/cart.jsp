<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="<%=request.getContextPath() %>/HeaderCssJs/bootstrap.css" rel="stylesheet">
<script src="<%=request.getContextPath() %>/HeaderCssJs/jquery.js"></script>
<script src="<%=request.getContextPath() %>/HeaderCssJs/bootstrap.min.js"></script>
<style>
/*根據bootstrap.css內容加以覆寫的方式*/
#myNavbar li a:hover {
	color: #fc3a63;
	position: relative; /* 當滑鼠經過超連結時，超連結往右下位移2像素 */
	top: 2px;
	left: 2px;
}
#myNavbar li {
	padding-top:5px;
	
}
#myNavbar li>a:active { 
	color: #000000;
}
#headerdav {
	font-size: 18px;
	font-family: Microsoft JhengHei;
	font-weight: bold;
}
#padding img {
	margin-bottom: 5px; 
	padding-right: 10px;
}
#nopadding img {
	margin-bottom: 5px;
}
body{
	padding-top:100px;
}
.maincontainer {
             max-width: 500px;
             margin:0 auto;
 }
.courseTitle{
    font-size: 20px;
    color: #3e3d3e;
    width: 70%;
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
    float: right;
}
.courseSubtitle{
	font-size: 16px;
	float:left;
}
.courseDelete{
	float: right;
	padding-right: 10px;
}
.cartrows{
overflow-x:hide;
overflow:auto; 
max-height: 40vh;
}
.cartrow{
width:90%;
padding:20px;
border-bottom: 1px solid #cccccc;
margin: auto
}
.cartrow img{
  width: 30%;
  height: 70px;
  
}
.dropdown-menu{
width: 465px;
}
.close{
float:none;
}
 .cartcount{
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
 
 
</style>
</head>
<div class="maincontainer">
<nav class="nav navbar-default navbar-fixed-top " id="headerdav" >

	<div class="container"  >
		<div class="navbar-header " >
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a href="#"><img src="<%=request.getContextPath() %>/HeaderCssJs/eLook_LOGO.png" height="75"
				 alt="e-Look"></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar" >
			<!--底下放要縮放的內容-->

			<ul class="nav navbar-nav " id="padding" >
				<li><a href="#menu1"><img src="<%=request.getContextPath() %>/HeaderCssJs/003-coins.png"height="30">募資</a></li>
				<li><a href="#menu2"><img src="<%=request.getContextPath() %>/HeaderCssJs/002-team.png" height="30">線上課程</a></li>
				<li><a href="#menu2"><img src="<%=request.getContextPath() %>/HeaderCssJs/004-gift.png"height="30">免費課程</a></li>
				<li><a href="#menu2"><img src="<%=request.getContextPath() %>/HeaderCssJs/001-book.png" height="30">我要開課</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right" id="nopadding">
				<li class="dropdown" ><a class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="false" aria-expanded="false"><span class="cartcount">3</span><img src="<%=request.getContextPath() %>/HeaderCssJs/002-shopping-cart.png" height="30" /></a>
<!-- 				以下為購物車內容 -->
				<ul class="dropdown-menu">
				<li class="dropdown-header" style="border-bottom:1px solid #aaaaaa;" ><h3>購物車</h3></li>
<!-- 				課程1 -->
				<div class="cartrows">

				<div class="cartrow" ><div style="text-align: right;"><div style="float: left; width: 80%; text-align: left;" ></div><button class="close" type="button" aria-hidden="true">&times;</button></div><img src="<%=request.getContextPath()%>/Class Steps/imgs/請上傳課程封面.png">
				<span class="courseTitle">Java線上學習1xxxxxxxxxxxxxxxxxx<br>
				<span class="courseSubtitle" >科技,語言,IT</span>
				<span class="courseDelete" ></span><br>
				<span class="courseDelete" >$800</span>
				</span>
				</div>			
<!-- 				課程2 -->				
<div class="cartrow" ><div style="text-align: right;"><div style="float: left; width: 80%; text-align: left;" ></div><button class="close" type="button" aria-hidden="true">&times;</button></div><img src="<%=request.getContextPath()%>/Class Steps/imgs/請上傳課程封面.png">
				<span class="courseTitle">Java線上學習2xxxx<br>
				<span class="courseSubtitle" >科技,語言</span>
				<span class="courseDelete" ></span><br>
				<span class="courseDelete" >$70</span>
				</span>
				</div>	
				
				
				<div class="cartrow" ><div style="text-align: right;"><div style="float: left; width: 80%; text-align: left;" ></div><button class="close" type="button" aria-hidden="true">&times;</button></div><img src="<%=request.getContextPath()%>/Class Steps/imgs/請上傳課程封面.png">
				<span class="courseTitle">Java線上學習2xxxx<br>
				<span class="courseSubtitle" >科技,語言</span>
				<span class="courseDelete" ></span><br>
				<span class="courseDelete" >$70</span>
				</span>
				</div>	
				
				
				</div>
				<div class="modal-body text-right">
				<div style="float:left;">共 3 筆課程</div><span>總金額：940元</span>
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary btn-block">前往結帳</button>
				</div>
				</ul>
<!-- 				以上為購物車內容 -->
				</li>
				<c:choose>
				<c:when test="${!empty LoginOK}">
				<li><a href="#"><img src="<%=request.getContextPath() %>/Image?MemberID=${LoginOK.memberID}"height="30" /></a></li>
				</c:when>
				<c:when test="${empty err}">
				<li><a href="#"data-toggle="modal" data-target="#myModal"><img src="<%=request.getContextPath() %>/HeaderCssJs/001-login.png"height="30" />登入</a></li>
				</c:when>
				<c:otherwise>
				<li><a href="#"data-toggle="modal" data-target="#myModal2"><img src="<%=request.getContextPath() %>/HeaderCssJs/001-login.png"height="30" />登入<span class="cartet"></span></a></li>
				</c:otherwise>
				</c:choose>
				
				

			</ul>
		</div>
	   </div>
	
</nav>
</div>

