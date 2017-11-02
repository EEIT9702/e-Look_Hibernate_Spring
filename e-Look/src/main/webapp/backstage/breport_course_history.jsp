<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Short Icon" type="image/x-icon" href="${initParam.icon}" />
<title>下架影片記錄</title>
<script src="<%=request.getContextPath()%>/HeaderCssJs/jquery.js"></script>
<!-- <script type="text/javascript" src="css/jquery.mmenu.js"></script> -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/table2.css">

<style>
.rtitle{
	width:60%;
	height:100px;
	margin:0 auto;
/* 	border:3px solid red; */
}
.rh1{
	font-size:50px;
	text-align:center;
	font-weight:20px;
}
.bhr{
	width:60%;
	border:1px solid black;
	margin:0 auto;
/* 	margin-top:10px; */
	margin-bottom:35px;
}
.cbox{
	width:60%;
	margin:0 auto;
/* 	border:3px solid gold; */
}
.tstyle{
	background-color:#FAF4FF;
}
.row th, td{
	text-align:center;
}
.row td{
/* 	valign="center; */
/* 	valign="middle; */
}
#reportTable>tbody td{
	vertical-align:middle;
}
</style>
</head>
<body>
<jsp:include page="backheader.jsp"></jsp:include>
<section id="wrapper">
<header>
	<div class="inner">
		<h2>下架影片記錄</h2>
		
	</div>
</header>
</section> 
<div class="container cbox" style="">
		<div class="row">

		  <table id="reportTable" class="table table-bordered tstyle" style="">
                 <thead>
                    <tr>
                       <th style="width:18%">檢舉課程編號</th>
                       <th style="width:27%">課程編號</th>
                       <th style="width:27%">檢舉內容</th>
                       <th style="width:28%">檢舉時間</th>
                    </tr>
                 </thead>
                   <tbody>
                 </tbody>
<!--                   <tfoot style="border-top:none"> -->
<!--                  	<form> -->
<!-- 		                 <tr> -->
<!-- 			                  <td><input type="hidden" id="" name=""><span></span></td> -->
<!-- 			                  <td><input type="hidden" id="" name=""><span></span></td> -->
<!-- 			                  <td><input type="hidden" id="" name=""><span></span></td> -->
<!-- 			                  <td><button type="button" value="back_report" onclick="self.location.href='breport-course.jsp'" class="btn btn-success">檢舉課程管理</button></td> -->
<!-- 						</tr> -->
<!-- 	                 </form> -->
<!--                   </tfoot> -->
            </table>
   			<div class="col-md-3" style="float:right;margin-bottom:30px;">
				<button type="button" value="hideHistory" onclick="self.location.href='breport-course.jsp'" class="btn btn-success" style="margin-right:68px;">檢舉課程管理</button>
			</div>
		</div>

</div>
<script>
$(function(){
	
	//帶入0到loadReportCourse方法裡
    loadReportCourse(1);
	
    //讀取檢舉
    //讀取到剛剛觸發帶入的值,並放入id
   function loadReportCourse(id){
    $.getJSON('ReportCourseControl',{"status":id},function(datas){
    	//console.log(datas)

    	//datas = [] array
    	//建一個fragment容器,並加上$()轉成jQuery物件去裝迴圈裡產生的物件
    	var fragment = $(document.createDocumentFragment());
    	$.each(datas,function(idx,reportV){
    		//product = {}
    		var cell1 = $('<td></td>').text(reportV.reportID);
    		var cell2 = $('<td></td>').text(reportV.reportCourseID);
    		var cell3 = $('<td></td>').text(reportV.reportContent);
    		var cell4 = $('<td></td>').text(reportV.reportTime);
    		//<tr><td>
    		var row = $('<tr></tr>').append([cell1,cell2,cell3,cell4]);
    		//放到容器裡
    		fragment.append(row);
    	})
    	$('#reportTable>tbody').html(fragment);
     })
	}

	
//end of loadReportCoursefunction
})
		
</script>
<script src="assets/js/jquery.scrollex.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
</body>
</html>