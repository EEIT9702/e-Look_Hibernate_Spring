<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<select name="city" id="select1"></select>
<select name="district" id="select2"></select>






							<div class=" col-md-2">
								<div class="form-group ">
									<label>地址</label> <select class="form-control"style="text-align: center;"name="city" id="select1"></select>
								</div>
							</div>
							<div class="col-md-2">
							<div class="form-group ">
								    <label style="margin:10px "></label><select  class="form-control"style="text-align: center;"name="district" id="select2"></select>
							</div>
							</div>

</body>
<script type="text/javascript">
$(function(){
	init();
	var data2;
	function init(){
		$.getJSON( "json/AllData.json", function(data) {
			data2=data;
			var fragment = $(document.createDocumentFragment());
			 $.each( data, function( key, val ) {
				 var cell1 = $('<option></option>').text(val.CityName).val(val.CityName)
				 fragment.append(cell1);
			 })
			 $('#select1').html(fragment); 
			 $.each( data, function( key, val1 ) {
					if("臺北市"===val1.CityName){
						var fragment = $(document.createDocumentFragment());
						 $.each( val1.AreaList, function( key, val2 ) {
							 var cell1 = $('<option></option>').text(val2.AreaName).val(val2.AreaName)
							 fragment.append(cell1);
		 				 })
		 				$('#select2').html(fragment);
					}

				 })
		})
		

	}
	$("#select1").change(function(){
		 var opt = $('#select1>:selected');
		 var val = opt.val();
		 $.each( data2, function( key, val1 ) {
			if(val===val1.CityName){
				var fragment = $(document.createDocumentFragment());
				 $.each( val1.AreaList, function( key, val2 ) {
					 var cell1 = $('<option></option>').text(val2.AreaName).val(val2.AreaName)
					 fragment.append(cell1);
 				 })
 				$('#select2').html(fragment);
			}

		 })
	})
})




</script>

</html>