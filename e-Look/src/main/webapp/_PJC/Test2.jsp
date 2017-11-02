<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<button>  123456789</button>
<br><br>
<div id="div1" style="width:80px;height:80px;display:none;background-color:red;"></div>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">
var _timer = {};  
function delay_till_last(id, fn, wait) {  
    if (_timer[id]) {  
        window.clearTimeout(_timer[id]);  
        delete _timer[id];  
    }  
   
    return _timer[id] = window.setTimeout(function() {  
        fn();  
        delete _timer[id];  
    }, wait);  
}  
 

$(document).ready(function(){
	  $("button").click(function(){
		  
		  delay_till_last('id', function() {
			  //注意 id 是唯一的  
			  $("#div1").fadeIn(1000);
			  $("#div1").fadeOut(1500);			    			    
	     }, 500);  		  	    	    	    	    	    
	  });
	});
</script>
</body>
</html>