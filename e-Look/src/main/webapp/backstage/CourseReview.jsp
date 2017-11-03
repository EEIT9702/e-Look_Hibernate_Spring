<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="Short Icon" type="image/x-icon" href="${initParam.icon}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>eLook後台課程審核</title>
   	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-3.3.7-dist/css/bootstrap.css">
   	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/backstage/css/CourseReview.css">
<style>
a:hover{
color:black;
}

</style>
</head>

<body>
<jsp:include page="backheader.jsp"></jsp:include>	
		
<section id="wrapper">
	<header>
		<div align="center" class="inner">
		<h2>課程審查</h2>
		</div>
	</header>
</section>

<div class="container">
    <div class="row">
            <div class="container">
                <div class="navbar-header">
                    <span class="navbar-brand">e-Look管理員您好80：</span>
                </div>       
            </div>
            <div class="container-fluid">
                <p class="navbar-text">提醒您，應謹慎使用審查功能，避免影響網站會員的權益</p>
                </div>

    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default panel-table">
                
                
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title">待審程的課程清單</h3>
                        </div>
                        <div class="col col-xs-6 text-right">
                            <div class="pull-right">
                                <div class="btn-group" data-toggle="buttons">
                                    <label class="btn btn-success btn-filter active" data-target="free">
                                        <input type="radio" name="options" id="option1" autocomplete="off">免費課程
                                    </label>
                                    <label class="btn btn-warning btn-filter" data-target="online">
                                        <input type="radio" name="options" id="option2" autocomplete="off">線上付費
                                    </label>
                                    <label class="btn btn-info btn-filter" data-target="fund">
                                        <input type="radio" name="options" id="option3" autocomplete="off">募資課程
                                    </label>
                                    <label class="btn btn-default btn-filter" data-target="all" style="color:black;font-weight: 900">
                                        <input type="radio" name="options" id="option4" autocomplete="off" checked> All
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                
                
                <div class="panel-body">
                    <table id="ReviewAllCourse" class="table table-striped table-bordered table-list">
                        <thead>
                        <tr>                            
                            <th class="col-tools" style="color:black">審查結果</th>
                            <th class="hidden-xs" style="color:black">會員編號</th>
                            <th class="col-text" style="color:black">課程編號</th>
                            <th class="col-text" style="color:black">課程標題</th>
                            <th class="col-text" style="color:black">課程募資起始日</th>
                        </tr>
                        </thead>
                        <tbody id="tbody">
                        
                        
<!--                         <tr data-status="free">                             -->
<!--                             <td align="center"> -->
<!--                                 <a class="btn btn-success"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></a> -->
<!--                                 <a class="btn btn-danger"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a> -->
<!--                             </td> -->
<!--                             <td class="hidden-xs">1</td> -->
<!--                             <td>John Doe...</td> -->
<!--                             <td>johndoe@example.com</td> -->
<!--                             <td>2017-11-17</td> -->
<!--                         </tr> -->
                        
                        
<!--                         <tr data-status="online">                            -->
<!--                             <td align="center"> -->
<!--                                 <a class="btn btn-success"><span class="glyphicon glyphicon-ok" -->
<!--                                                                  aria-hidden="true"></span></a> -->
<!--                                 <a class="btn btn-danger"><span class="glyphicon glyphicon-remove" -->
<!--                                                                 aria-hidden="true"></span></a> -->
<!--                             </td> -->
<!--                             <td class="hidden-xs">2</td> -->
<!--                             <td>Jen Curtis</td> -->
<!--                             <td>jencurtis@example.com</td> -->
<!--                             <td>2017-11-11</td> -->
<!--                         </tr> -->
                        
                        
<!--                         <tr data-status="fund"> -->
                            
<!--                             <td align="center"> -->
<!--                                 <a class="btn btn-success"><span class="glyphicon glyphicon-ok" -->
<!--                                                                  aria-hidden="true"></span></a> -->
<!--                                 <a class="btn btn-danger"><span class="glyphicon glyphicon-remove" -->
<!--                                                                 aria-hidden="true"></span></a> -->
<!--                             </td> -->
<!--                             <td class="hidden-xs">3</td> -->
<!--                             <td>Jackson</td> -->
<!--                             <td>jackson04140923@example.com</td> -->
<!--                             <td>2017-11-1</td> -->
<!--                         </tr> -->
                        </tbody>
                    </table>
                </div>
                
                
                
                <div class="panel-footer">
                    <div class="row">
                        <div class="col col-xs-offset-3 col-xs-6">
                            <nav aria-label="Page navigation" class="text-center">
                                <ul class="pagination">
                                    <li>
                                        <a href="#" aria-label="Previous">
                                            <span aria-hidden="true" style="color:black">«</span>
                                        </a>
                                    </li>
                                    <li class="active"><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li>
                                        <a href="#" aria-label="Next">
                                            <span aria-hidden="true" style="color:black">»</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                
                
                
                
            </div>
        </div>
    </div>
    <div class="row">
        
            <div class="container-fluid">
                <p class="navbar-text">貼心提醒：審查募資課程時，應以"募資啟始日"來判斷優先順序</p>
            </div>
        
    </div>
</div>


<!-- script的集結地========================================================================================== -->
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<%-- <script src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>  --%>
<script src="<%=request.getContextPath()%>/backstage/assets/js/jquery.min.js"></script> 
<script src="<%=request.getContextPath()%>/backstage/assets/js/jquery.scrollex.min.js"></script>
<script src="<%=request.getContextPath()%>/backstage/assets/js/util.js"></script>
<script src="<%=request.getContextPath()%>/backstage/assets/js/main.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

<script>
$(document).ready(function () {
    $('.btn-filter').on('click', function () {
        var $target = $(this).data('target');
        if ($target != 'all') {
            $('.table tbody tr').css('display', 'none');
            $('.table tr[data-status="' + $target + '"]').fadeIn('fast');
        } else {
            $('.table tbody tr').css('display', 'none').fadeIn('fast');
        }
    });

});





var ReviewDatas;

$(function(){
	loadReviewData();
	//審核不過，退回變成草稿====================================================
		$('#ReviewAllCourse>tbody').on('click','td>button:nth-child(2)',function(){
	if(confirm("確定要退回為草稿狀態嗎?")){
			var id = $(this).parents('tr').find('td:nth-child(3)').text();
			console.log(id+"此課程已變更為草稿狀態");
			$.get('/e-Look/com.e_Look.Course.control/CourseEditControlloer',{'courseID':id,"rollbackEditorStatus":"xxxxxxxxxx"},function(){
				loadReviewData();
			})
	}		
		})
	//========================================================================	
	//審核通過=================================================================
		$('#ReviewAllCourse>tbody').on('click','td>button:nth-child(1)',function(){
	if(confirm("確定此課程審核通過嗎?")){
			var id = $(this).parents('tr').find('td:nth-child(3)').text();
			console.log(id+"此課程已審核通過");
			$.each(ReviewDatas,function(idx,Course){
				if(id==Course.courseID && Course.targetStudentNumber>0){
					$.get('/e-Look/com.e_Look.Course.control/CourseEditControlloer',{'courseID':id,"changeStatustoFundStatus":"xxxxxxxxxx"},function(){
						loadReviewData();
					})
				}else if(id==Course.courseID && Course.targetStudentNumber==0){
					$.get('/e-Look/com.e_Look.Course.control/CourseEditControlloer',{'courseID':id,"changeStatustoOnlineStatus":"xxxxxxxxxx"},function(){
						loadReviewData();
					})
				}
			})

			
			
	}
		})
	//========================================================================
	
})
function loadReviewData(){
	$.getJSON("/e-Look/ReviewCourseStatus",function(datas){
		ReviewDatas = datas;
		var fragment = $(document.createDocumentFragment());
		console.log(datas);	
		$.each(datas,function(idx,Course){
			var cell1 = $('<td align="center"></td>').html('<button class="btn btn-success"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button><button class="btn btn-danger"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>')
			var cell2 = $('<td></td>').text(Course.memberID)
			var cell3 = $('<td></td>').text(Course.courseID)
			var cell4 = $('<td></td>').html('<a href="/e-Look/ReviewingCoursePage.jsp?CourseID='+Course.courseID+'" style="color:black" target="_blank">'+Course.courseName+'</a>')
			var cell5 = $('<td></td>').text(Course.fundEndDate)
			
			if(Course.soldPrice==0){
				var cell5 = $('<td></td>').text("無需募資，審核通過立即上線")
				var row = $('<tr data-status="free"></tr>').append([cell1,cell2,cell3,cell4,cell5]);				
			}
			else if(Course.soldPrice>0 && Course.targetStudentNumber>0){
				var row = $('<tr data-status="fund"></tr>').append([cell1,cell2,cell3,cell4,cell5]);
			}
			else if(Course.soldPrice>0 && Course.targetStudentNumber==0){
				var cell5 = $('<td></td>').text("無需募資，審核通過立即上線")
				var row = $('<tr data-status="online"></tr>').append([cell1,cell2,cell3,cell4,cell5]);
			}
			else{
				console.log("有例外發生，推測是有不正確的資料進到資料庫")
			}
			fragment.append(row);
		});	
		$('#ReviewAllCourse>tbody').html(fragment);
	})
}
<!-- script的集結地========================================================================================== -->
</script>
</body>
</html>