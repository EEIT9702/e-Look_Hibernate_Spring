<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">

    <title>Alert Group - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
    .alert-group>.alert:first-child:not(:last-child){
    -webkit-border-top-left-radius:5px;
    -webkit-border-top-right-radius:5px;
    -webkit-border-bottom-right-radius:0;
    -webkit-border-bottom-left-radius:0;
       -moz-border-radius-topleft:5px;
       -moz-border-radius-topright:5px;
       -moz-border-radius-bottomright:0;
       -moz-border-radius-bottomleft:0;
            border-top-left-radius:5px;
            border-top-right-radius:5px;
            border-bottom-right-radius:0;
            border-bottom-left-radius:0;
    margin-bottom:0
}
.alert-group>.alert:not(:first-child):not(:last-child){
    -webkit-border-radius:0;
       -moz-border-radius:0;
            border-radius:0;
    border-top:0;
    margin-bottom:0
}
.alert-group>.alert:last-child:not(:first-child){
    -webkit-border-top-left-radius:0;
    -webkit-border-top-right-radius:0;
    -webkit-border-bottom-right-radius:5px;
    -webkit-border-bottom-left-radius:5px;
       -moz-border-radius-topleft:0;
       -moz-border-radius-topright:0;
       -moz-border-radius-bottomright:5px;
       -moz-border-radius-bottomleft:5px;
            border-top-left-radius:0;
            border-top-right-radius:0;
            border-bottom-right-radius:5px;
            border-bottom-left-radius:5px;
    border-top:0
}
.close{
	float:right;
}
    </style>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.js"></script>


</head>
<body>
<jsp:include page="${contextPath}/login.jsp"/>
	<div class="container">
	<div class="row">
		<div class="alert-group">
            <div class="alert alert-success alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <strong>Well done!</strong> You successfully read this important alert message.
            </div>
            <div class="alert alert-info">
                <strong>Heads up!</strong> This alert needs your attention, but it's not super important.
            </div>
            <div class="alert alert-warning alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <strong>Warning!</strong> Better check yourself, you're not looking too good.
            </div>
            <div class="alert alert-danger alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <strong>Oh snap!</strong> Change a few things up and try submitting again.
            </div>
        </div>
	</div>
</div>
    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        $( document ).ready(function() {
          var iframe_height = parseInt($('html').height()); 
          window.parent.postMessage( iframe_height, 'https://bootsnipp.com');
        });
    </script>
</body>
</html>