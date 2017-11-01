<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="login/viewport"content="width=device-width, initial-scale=1">
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<script src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<title>Insert title here</title>
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
    width: 200px;
    height:150px;
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
    color:gray;
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
font-size:30px;
}
p{
font-size:20px
}
span.round-tab {
  width: 40px;
    height: 40px;
    line-height: 40px;
    display: block;
    border-radius: 100px;
    background: #fff;
    border: 2px solid #e0e0e0;
    z-index: 2;
    position: absolute;
    text-align: center;
    font-size: 20px;
  left: 46%; 
    top: 16.5%; 
    bottom: 46%; 
    right: 16.5%; 
    
}
</style>
</head>
<%-- <link href="<%=request.getContextPath()%>/member/css/bootstrap.css" --%>
<!-- 	rel="stylesheet" type="text/css"> -->
<%-- <script src="<%=request.getContextPath()%>/member/js/jquery-3.2.1.js" --%>
<!-- 	type="text/javascript"></script> -->
<%-- <script src="<%=request.getContextPath()%>/member/js/bootstrap.js" --%>
<!-- 	type="text/javascript"></script> -->
<body>
<jsp:include page="/login.jsp" />
    <div  style="margin-top: 10px" class="container">
        <h2 class="text-center" style=" margin-bottom: 30px;background-color: #929fba; color: white">會員中心</h2>
        <div class="row">
            <div class="col-md-4 text-center" >
                <div style="box-shadow: 6px 8px 6px 0 #c4bebe; background-color:#dff0d8;border: 2px solid #e0e0e0; border-radius: 25px;" class="thumbnail"> 
                    <img src="<%=request.getContextPath()%>/Image?MemberID=${LoginOK.memberID}" alt="" width="25%" class="img-circle" style="margin-top: 50px;">
                 
                    <span class="round-tab"> <i class="glyphicon glyphicon-pencil"></i>
					</span><div class="page-header">
                        <h3 >${LoginOK.mName}</h3> 
                    </div>
                </div>
                <div class="thumbnail col-md-6 " style="box-shadow: 5px 5px #b7b6b6; background-color:#fcf8e3;">
                    <h3>已參加</h3> 
                    <p>3堂課</p> 
                </div>
                <div class="thumbnail col-md-6 " style="box-shadow: 5px 5px #b7b6b6; background-color:#fcf8e3; ">
                    <h3>已開設</h3> 
                    <p>3堂課</p> 
                </div>
                <div class="col-md-12 bg-info" style="border: 1px solid #c1bebe;box-shadow: 2px 2px #c7c4c4; ">
                    <h3>關於我</h3> 
                    <hr style="border:solid 0.6px #BEBEBE;"/>
                    <p style="word-break:break-all; word-wrap:break-word">${LoginOK.aboutme}</p> 
                </div>
                <div style="border: 1px solid #c1bebe;box-shadow: 2px 2px #c7c4c4;" class="col-md-12 bg-info">
                    <h3>專長</h3> 
                    <hr style="border:solid 0.6px #BEBEBE;"/>
                    <p style="word-break:break-all; word-wrap:break-word">${LoginOK.skill}</p> 
                </div>
                <div style="border: 1px solid #c1bebe;box-shadow: 2px 2px #c7c4c4;" class="col-md-12 bg-info">
                    <h3>興趣</h3> 
                    <hr style="border:solid 0.6px #BEBEBE;"/>
                    <p style="word-break:break-all; word-wrap:break-word" >${LoginOK.hobby}</p> 
                </div>                 
            </div>
            <div class="col-md-8 breadcrumb " style="background-color: rgba(0, 150, 136, 0.1); padding-top: 40px;border: 2px solid #e0e0e0; border-radius: 25px;"">
                <div class="col-md-12"> 
                    <img  src="<%=request.getContextPath()%>/member/image/learnMode2.jpg"width="100%" > 
                </div>
                <div class="col-md-12">
              <h4> <a data-toggle="collapse" data-parent="#accordion" 
                href="#collapseOne">我開的課</a></h4>
                    <hr style="border:solid 0.3px #BEBEBE;" /> 
                    <div id="collapseOne" class="collapse">
                 <div  class=" col-md-4 " style="width: 231px">
                <div class="card card-inverse">
                    <img class="card-img-top" src="<%=request.getContextPath()%>/Class Steps/imgs/請上傳課程封面.png" alt="course" id="wizardPicturePreview" title="">
                    <div class="card-block">
                        <figure class="profile">
                            <img src="<%=request.getContextPath()%>/Class Steps/imgs/eLook_LOGO1.png" class="profile-avatar" alt="">
                        </figure>
                        <div class="card-text">
                        <p id="title" class="card-title mt-3 multi_ellipsis">這裡請輸入課程標題</p>                        	
                        </div>
                       </div>
                    <div class="card-footer">
                    <button class="btn-info btn-sm center-block" style="margin-bottom: 5px;margin-top: 10px">編輯</button>   
                    </div>
                    </div>
                </div>
                
                <div  class=" col-md-4 " style="width: 231px">
                <div class="card card-inverse">
                    <img class="card-img-top" src="<%=request.getContextPath()%>/Class Steps/imgs/請上傳課程封面.png" alt="course" id="wizardPicturePreview" title="">
                    <div class="card-block">
                        <figure class="profile">
                            <img src="<%=request.getContextPath()%>/Class Steps/imgs/eLook_LOGO1.png" class="profile-avatar" alt="">
                        </figure>
                        <div class="card-text">
                        <p id="title" class="card-title mt-3 multi_ellipsis">這裡請輸入課程標題</p>                        	
                        </div>
                       </div>
                    <div class="card-footer">
                    <button class="btn-info btn-sm center-block" style="margin-bottom: 5px;margin-top: 10px">編輯</button>   
                    </div>
                    </div>
                </div>
            </div> 
                </div>
                <div class="col-md-12">
                    <h4><a data-toggle="collapse" data-parent="#accordion" 
                href="#collapseTwo">我修的課</a></h4>
                    <hr style="border:solid 0.6px #BEBEBE;" />  
                    <div id="collapseTwo" class=" collapse">
                 <div  class=" col-md-4 " style="width: 231px">
                <div class="card card-inverse">
                    <img class="card-img-top" src="<%=request.getContextPath()%>/Class Steps/imgs/請上傳課程封面.png" alt="course" id="wizardPicturePreview" title="">
                    <div class="card-block">
                        <figure class="profile">
                            <img src="<%=request.getContextPath()%>/Class Steps/imgs/eLook_LOGO1.png" class="profile-avatar" alt="">
                        </figure>
                        <div class="card-text">
                        <p id="title" class="card-title mt-3 multi_ellipsis">這裡請輸入課程標題</p>                        	
                        </div>
                       </div>
                </div>
                </div>
                
                <div  class=" col-md-4 " style="width: 231px">
                <div class="card card-inverse">
                    <img class="card-img-top" src="<%=request.getContextPath()%>/Class Steps/imgs/請上傳課程封面.png" alt="course" id="wizardPicturePreview" title="">
                    <div class="card-block">
                        <figure class="profile">
                            <img src="<%=request.getContextPath()%>/Class Steps/imgs/eLook_LOGO1.png" class="profile-avatar" alt="">
                        </figure>
                        <div class="card-text">
                        <p id="title" class="card-title mt-3 multi_ellipsis">這裡請輸入課程標題</p>                        	
                        </div>
                       </div>
                </div>
                </div>
                
                <div  class=" col-md-4 " style="width:231px">
                <div class="card card-inverse">
                    <img class="card-img-top" src="<%=request.getContextPath()%>/Class Steps/imgs/請上傳課程封面.png" alt="course" id="wizardPicturePreview" title="">
                    <div class="card-block">
                        <figure class="profile">
                            <img src="<%=request.getContextPath()%>/Class Steps/imgs/eLook_LOGO1.png" class="profile-avatar" alt="">
                        </figure>
                        <div class="card-text">
                        <p id="title" class="card-title mt-3 multi_ellipsis">這裡請輸入課程標題</p>                        	
                        </div>
                       </div>
                </div>
                </div>
            </div> 
                </div>
                <div class="col-md-12">
                    <h4><a data-toggle="collapse" data-parent="#accordion"  href="#collapseThree">我的收藏課程</a></h4><hr style="border:solid 0.6px #BEBEBE;"/>  
                    <div id="collapseThree" class="  collapse">
                    <div  class=" col-md-4 " style="width: 231px">
                    <div class="card card-inverse">
                    <img class="card-img-top" src="<%=request.getContextPath()%>/Class Steps/imgs/請上傳課程封面.png" alt="course" id="wizardPicturePreview" title="">
                    <div class="card-block">
                        <figure class="profile">
                            <img src="<%=request.getContextPath()%>/Class Steps/imgs/eLook_LOGO1.png" class="profile-avatar" alt="">
                        </figure>
                        <div class="card-text">
                        <p id="title" class="card-title mt-3 multi_ellipsis">這裡請輸入課程標題</p>                        	
                        </div>
                       </div>
                    <div class="card-footer">
                    <button class="btn-info btn-sm pull-right" style="margin-bottom: 5px;margin-top: 10px">取消訂閱</button>   
                    </div>
                    
                </div>
                </div>
                </div>
                </div>
                <div class="col-md-12">
                    <h4> <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">我的追蹤講師</a></h4>
                    <hr style="border:solid 0.6px #BEBEBE;"  /> 
                    <div id="collapseFour" class=" collapse">
                    <p >Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p> 
                </div> 
                </div>                
            </div>
        </div>
    </div>
    <jsp:include page="/footer.jsp" />
</body>
<script type="text/javascript">

$(function () { $('#collapseOne').collapse('hide')});
$(function () { $('#collapseTwo').collapse('hide')});
	$(function () { $('#collapseThree').collapse('hide')});
	$(function () { $('#collapseFour').collapse('hide')});

</script>  
</html>