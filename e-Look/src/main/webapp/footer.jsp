<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<%-- <script src="<%=request.getContextPath()%>/HeaderCssJs/jquery.js"></script>   --%>
<!-- <script -->
<%-- 	src="<%=request.getContextPath()%>/HeaderCssJs/bootstrap.min.js"></script> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">  
</head>
<style>
body{
}

footer{
	background-color:#222222;
    padding: 60px 0px;
    margin-top: 60px;
  font-family: 'Raleway', sans-serif;
}

footer ul{
    list-style:none;
    margin:0 auto;
    display:inline-block;
    padding-top:50px;
}

footer ul li{
    float:left;
}

footer ul li a{
	color:#b1aca1;
    padding:20px;
}

footer ul li a:hover{
	color:#7dabdb;
	text-decoration:none;
}

.footer-top2 a{
    display: block;
    color: #FFF;
    background: #333333;
     border-radius: 72px;
    height: 100px;
    width: 100px;
    padding: 43px 0px;
}


.footer-top2{
	padding-bottom:50px;
}

.footer-top2 .fa{
    font-size:18px;
    color: #FFF;
    padding-right:10px;
}

.footer-top a{
    color:#FFF;
    background:#333333; 
    padding: 10px;
}

.footer-top2 .col-lg-2:hover a{
    color:#FFF;
	text-decoration:none;
	background:#7dabdb;
    transition: all 1s ease-in-out;
}

/*  Footer 2 End */

</style>
<body>
<footer style="margin-top:100px;">
        
        <div class="search-text"> 
            <div class="container">
                <div class="row text-center">               
                </div>         
            </div>     
        </div>
        
        <div class="footer-top2"> 
           <div class="container">
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 text-center">
                   <a href="HOME.jsp"><i class="fa fa-home fa-2x"></i>home</a>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 text-center">
                   <a href="CreateCourse.jsp"><i class="fa fa-graduation-cap fa-2x"></i>我要開課</a>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 text-center">
                   <a href="#"><i class="fa fa-facebook fa-2x"></i>粉絲專頁</a>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 text-center">
                    <a href="#"><i class="fa fa-envelope-o fa-2x"></i>聯絡我們</a>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 text-center">
                    <a href="#"><i class="fa fa-users fa-2x"></i>關於我們</a>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6 text-center">
                    <a href="member/member.jsp"><i class="fa fa-child fa-2x"></i>會員中心</a>
                </div>
           </div> 
        </div>  
        
        
    </footer>
    
    
    <div class="copyright">
     <div class="container">
       
         <div class="row text-center">
         	<p>Copyright © 2017 All rights reserved</p>
         </div>
         
 	   </div>
    </div>
    <!-- Footer 2 End -->
    
    
    
</body>
</html>