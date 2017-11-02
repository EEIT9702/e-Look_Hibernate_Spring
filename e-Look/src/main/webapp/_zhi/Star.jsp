<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%= request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
<script src="<%= request.getContextPath() %>/js/jquery-3.2.1.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.js"></script>
<link rel="Shortcut Icon" type="image/x-icon" href="${SYSTEM.iconUri}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>

#box { 
    width: 999px; height: 192px ; 
    background: url(../img/star.jpg) no-repeat; 
    position: relative; 
    overflow: hidden;
   
}
#drag { 
width: 500px; height: 192px ;
background: url(../img/star.jpg) no-repeat;
-webkit-filter: grayscale(100%);
 
}


</style>
<link rel="Short Icon" type="image/x-icon" href="${initParam.icon}" />
<title>${initParam.systemName}</title>
<script>

$(document).ready(function(){    
  
  $('#box').mousemove(function(e){
    
	var x = e.pageX - $('#box').offset().left;  
	var y = e.pageY - $('#box').offset().top; 
	$('#drag').attr("style","width:"+x+"px");
	
      $("p").text(x);
    
    });  
});
</script>
</head>
<body>
<%-- xxx<img src="<%= request.getContextPath() %>/img/star.jpg"><br> --%>
<%-- xxxxx<img id="star" src="<%= request.getContextPath() %>/img/star.jpg"> --%>
<hr/>
<div id="box">
    <div id="drag" class="drag"></div>
</div>
<p></p>

</body>
</html>