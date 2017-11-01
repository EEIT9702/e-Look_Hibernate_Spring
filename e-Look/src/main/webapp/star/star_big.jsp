<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <style>
        .s {-webkit-filter: grayscale(1); }

        .n {-webkit-filter: grayscale(0); }
 </style>

</head>
<body>
 <div>
    <img id="idstar1" class="s" width="65" height="65" src="star.jpg" />
    <img id="idstar2" class="s" width="65" height="65" src="star.jpg" />
    <img id="idstar3" class="s" width="65" height="65" src="star.jpg" />
    <img id="idstar4" class="s" width="65" height="65" src="star.jpg" />
    <img id="idstar5" class="s" width="65" height="65" src="star.jpg" />
    </div>
    
    <div id="starnum" style="font-size:3em;color:red"></div>
    
	<script src="<%=request.getContextPath() %>/js/jquery-1.12.3.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jquery-ui-effects.min.js"></script>

	<script>
		$(function(){
			var flag1 = false;
			$('img').hover(over,out);
			
			function over(){
				 if (!flag1) {	
				var movein = this.id.substr(6);
	            for (i = 1; i <= movein; i++) {
	          document.getElementById("idstar"+i).className = "n";
			//	$('img:lt(i)').switchClass('s','n',1000);
	        }				
			}
			}
			
			function out(){
			  if (!flag1) {
		             var out = this.id.substr(6);
		              for (u = 1; u <= out; u++) {
		          document.getElementById("idstar" + u).className = "s";
		      
			//	$('div img:nth-child(u)').switchClass('n','s',1000);
			}
			}
			}
			
			$('img').click(function(){
				
				   if (!flag1) { flag1 = true};
	//			   document.getElementById("starnum").innerHTML = "你給" + this.id.substr(6) + "顆星";
				   
			//	   $.get("Buycourse",{"name":"score","score":this.id.substr(6)});
		           
			})
			
		})
	</script>

</body>
</html>