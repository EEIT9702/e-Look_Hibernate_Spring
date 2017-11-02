<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<link rel="Shortcut Icon" type="image/x-icon" href="${SYSTEM.iconUri}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="login/viewport"
	content="width=device-width, initial-scale=1">
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<title>${SYSTEM.systemName}</title>
<style type="text/css">

/*  bhoechie tab */
div.bhoechie-tab-container{
  z-index: 10;
  background-color: #ffffff;
  padding: 0 !important;
  border-radius: 4px;
  -moz-border-radius: 4px;
  border:1px solid #ddd;
  margin-top: 20px;
  margin-left: 50px;
  -webkit-box-shadow: 0 6px 12px rgba(0,0,0,.175);
  box-shadow: 0 6px 12px rgba(0,0,0,.175);
  -moz-box-shadow: 0 6px 12px rgba(0,0,0,.175);
  background-clip: padding-box;
  opacity: 0.97;
  filter: alpha(opacity=97);
}
div.bhoechie-tab-menu{
  padding-right: 0;
  padding-left: 0;
  padding-bottom: 0;
}
div.bhoechie-tab-menu div.list-group{
  margin-bottom: 0;
}
div.bhoechie-tab-menu div.list-group>a{
  margin-bottom: 0;
}
div.bhoechie-tab-menu div.list-group>a .glyphicon,
div.bhoechie-tab-menu div.list-group>a .fa {
  color: #478ecb;
}
div.bhoechie-tab-menu div.list-group>a:first-child{
  border-top-right-radius: 0;
  -moz-border-top-right-radius: 0;
}
div.bhoechie-tab-menu div.list-group>a:last-child{
  border-bottom-right-radius: 0;
  -moz-border-bottom-right-radius: 0;
}
div.bhoechie-tab-menu div.list-group>a.active,
div.bhoechie-tab-menu div.list-group>a.active .glyphicon,
div.bhoechie-tab-menu div.list-group>a.active .fa{
  background-color: #478ecb;
  background-image: #478ecb;
  color: #ffffff;
}

div.bhoechie-tab-menu div.list-group>a.active:after{
  content: '';
  position: absolute;
  left: 100%;
  top: 50%;
  margin-top: -13px;
  border-left: 0;
  border-bottom: 13px solid transparent;
  border-top: 13px solid transparent;
  border-left: 10px solid #478ecb;
}

div.bhoechie-tab-content{
  background-color: #ffffff;
  /* border: 1px solid #eeeeee; */
  padding-left: 20px;
  padding-top: 10px;
}

div.bhoechie-tab div.bhoechie-tab-content:not(.active){
  display: none;
}
.clickable {
	cursor: pointer;
}

.panel-heading div {
	margin-top: -18px;
	font-size: 15px;
}

.panel-heading div span {
	margin-left: 5px;
}

.panel-body {
	display: none;
}
/*     */




/*	--------------------------------------------------
	:: Table Filter
	-------------------------------------------------- */
.panel {
	border: 1px solid #ddd;
	background-color: #fcfcfc;
}
.panel .btn-group {
	margin: 15px 0 30px;
}
.panel .btn-group .btn {
	transition: background-color .3s ease;
}
.table-filter {
	background-color: #fff;
	border-bottom: 1px solid #eee;
}
.table-filter tbody tr:hover {
	cursor: pointer;
	background-color: #eee;
}
.table-filter tbody tr td {
	padding: 10px;
	vertical-align: middle;
	border-top-color: #eee;
}
.table-filter tbody tr.selected td {
	background-color: #eee;
}
.table-filter tr td:first-child {
	width: 20px;
}
.table-filter tr td:nth-child(2) {
	width: 20px;
}
.table-filter thead tr th {
	width: 20px;
}
tbody tr td {
	width: 20px;
}
tbody{
font-size: 22px

}
thead{
font-size: 20px

}


span {
	font-size: .8em;	
}
span.pagado {
	color: #5cb85c;
}
span.pendiente {
	color: #f0ad4e;
}
span.cancelado {
	color: #d9534f;
}

</style>
</head>
<body>
	<c:if test="${empty LoginOK}">
	<c:redirect url="/HOME.jsp"/>
	</c:if>
	<jsp:include page="/login.jsp" />
	<input id="memberID" value="${LoginOK.memberID}" type="hidden">
	<div class="container">
	<div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 bhoechie-tab-container">
            <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 bhoechie-tab-menu">
              <div class="list-group">
                <a href="#" class="list-group-item active text-center" style="font-size: 20px">
                  <h4 class="glyphicon glyphicon-shopping-cart" style="font-size: 20px"></h4><br/>消費記錄
                </a>
                <a href="#" class="list-group-item text-center" style="font-size: 20px">
                  <h4 class="glyphicon glyphicon-usd" style="font-size: 20px"></h4><br/>課程收益
                </a>
              </div>
            </div>
            <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 bhoechie-tab">
                <!-- flight section -->
                <div class="bhoechie-tab-content active">
                    <div>
                      <h1>消費紀錄</h1>
                    <div class="col-md-12">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">消費紀錄</h3>
						<div class="pull-right">
							<span class="clickable filter" data-toggle="tooltip"
								title="Toggle table filter" data-container="body"> <i
								class="glyphicon glyphicon-filter"></i>
							</span>
						</div>
					</div>
					<div class="panel-body">
						<input type="text" class="form-control" id="dev-table-filter"
							data-action="filter" data-filters="#dev-table"
							placeholder="Filter Developers" />
					</div>
					<table  class="table table-hover" id="dev-table">
						<thead>
							<tr>
								<th>訂單編號</th>
								<th>課程名稱</th>
								<th>購買日期</th>
								<th>價格</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
			</div>
           </div>
                </div>
                <!-- train section -->
                <div class="bhoechie-tab-content">
                    <div>
                    <h1>課程收益</h1>
					<div class="pull-right">
							<div class="btn-group" >
								<button style="font-size: 16px;" type="button" class="btn btn-default btn-filter" data-target="all">ALL</button>
								<button style="font-size: 16px" type="button" class="btn btn-success btn-filter" data-target="pagado">線上課程</button>
								<button style="font-size: 16px" type="button" class="btn btn-warning btn-filter" data-target="pendiente">免費課程</button>
								<button style="font-size: 16px" type="button" class="btn btn-danger btn-filter" data-target="cancelado">募資課程</button>
							</div>
						</div>
							<div class="table-container">
								<table  class="table table-hover table2" >
									<thead data-status="all">
										<tr>
											<th>課程種類</th>
											<th>課程收益</th>
										</tr>
									</thead>
									<thead data-status="pagado" style="display:none">
										<tr>
											<th>課程名稱</th>
											<th>定價</th>
											<th>購買人數</th>
											<th>課程收益</th>
										</tr>
									</thead>
									<thead data-status="pendiente" style="display:none">
										<tr>
											<th>課程名稱</th>
											<th>贊助人</th>
											<th>日期</th>
											<th>金額</th>
										</tr>
									</thead>
									<thead data-status="cancelado"style="display:none">
										<tr>
											<th>課程名稱</th>
											<th>定價</th>
											<th>人數</th>
											<th>募資金額</th>
										</tr>
									</thead>
									<tbody data-status="all" id="all">
									<tr>
											<td><span class="pagado">(Pagado)</span></td>
											<td>2</td>
									</tr>
									</tbody>
									<tbody data-status="pagado" id="pagado" style="display:none">
										<tr >
											<td><span class="pagado">(Pagado)</span></td>
											<td>1</td>
											<td>3</td>
											<td>4</td>
										</tr>
										</tbody>
										<tbody data-status="pendiente" id="pendiente" style="display:none">
										<tr >
										<td><span class="pagado">(Pagado)</span></td>
											<td>2</td>
											<td>3</td>
											<td>4</td>
										</tr>
										</tbody>
										<tbody data-status="cancelado" id="cancelado" style="display:none">
										<tr>
											<td><span class="pagado">(Pagado)</span></td>
											<td>3</td>
											<td>3</td>
											<td>4</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
                </div>
            </div>
        </div>
  </div>
</div>






	<jsp:include page="/footer.jsp" />
<script type="text/javascript">
$(document).ready(function() {
    $("div.bhoechie-tab-menu>div.list-group>a").click(function(e) {
        e.preventDefault();
        $(this).siblings('a.active').removeClass("active");
        $(this).addClass("active");
        var index = $(this).index();
        $("div.bhoechie-tab>div.bhoechie-tab-content").removeClass("active");
        $("div.bhoechie-tab>div.bhoechie-tab-content").eq(index).addClass("active");
    });
});
(function(){
    'use strict';
	var $ = jQuery;
	$.fn.extend({
		filterTable: function(){
			return this.each(function(){
				$(this).on('keyup', function(e){
					$('.filterTable_no_results').remove();
					var $this = $(this), 
                        search = $this.val().toLowerCase(), 
                        target = $this.attr('data-filters'), 
                        $target = $(target), 
                        $rows = $target.find('tbody tr');
                        
					if(search == '') {
						$rows.show(); 
					} else {
						$rows.each(function(){
							var $this = $(this);
							$this.text().toLowerCase().indexOf(search) === -1 ? $this.hide() : $this.show();
						})
						if($target.find('tbody tr:visible').size() === 0) {
							var col_count = $target.find('tr').first().find('td').size();
							var no_results = $('<tr class="filterTable_no_results"><td colspan="'+col_count+'">搜尋無結果</td></tr>')
							$target.find('tbody').append(no_results);
						}
					}
				});
			});
		}
	});
	$('[data-action="filter"]').filterTable();
})(jQuery);

$(function(){
    // attach table filter plugin to inputs
	$('[data-action="filter"]').filterTable();
	
	$('.container').on('click', '.panel-heading span.filter', function(e){
		var $this = $(this), 
			$panel = $this.parents('.panel');
		
		$panel.find('.panel-body').slideToggle();
		if($this.css('display') != 'none') {
			$panel.find('.panel-body input').focus();
		}
	});
	$('[data-toggle="tooltip"]').tooltip();
})

/*----消費明細---*/
 $(function(){
	 loadOrder($("#memberID").val())
	 loadCourse($("#memberID").val())
 })
 var OrderDetails;
 var Order;
 $("#dev-table").on("click","tbody>tr.parent",function(){
	  //console.log($(this).children("td").html())
	  //console.log( $(this).attr("data"))
	  var value=$(this).children("td").html()
	  if( $(this).attr("class")==="parent"){
	  $(this).attr("class","parent data")
		   var fragment = $(document.createDocumentFragment());
	   	  $.each(OrderDetails,function(idx,OrderDetail){
	   		 $.each(OrderDetail,function(idx,Order){
	   			//console.log(Order.courseVO.orderID);
	   			//console.log(value);
	   			//console.log(Order.courseVO);
	   			if(value==Order.orderVO.orderID){
	   			var cell1 = $('<td></td>').text("")
	  		  	var cell2 = $('<td></td>').text(Order.courseVO.courseName)
	  		  	var cell3 = $('<td></td>').text("")
	  		 	var cell4 = $('<td></td>').text(Order.buyingPrice)
	  		  	var row = $('<tr class="data1" style="background-color:#acecfb"></tr>').append([cell1,cell2,cell3,cell4]);   			
	  		  	fragment.append(row);	
	   		 }  
	      	  });
	   	  });
	   	  $(this).after(fragment);
	  }else{
		  	$(this).attr("class")
		  	//$(this).removeAttr("class")
			//console.log($(this).attr("class"));
		  	 $(this).nextAll("tr").remove(".data1");
		  	
		  $(this).removeAttr("class")
		  $(this).attr("class","parent")

	  	}
	  
})

 
 function loadOrder(memberID){
	$.getJSON('/e-Look/MemberConsumeController',{'MemberID':memberID},function(datas){
	   	 //console.log(datas);
	   	 if(datas.OrderDetails.length>0){
	   	//console.log(datas.OrderDetails);
	   	OrderDetails=datas.OrderDetails;
	   	Order=datas.order;
 	   	 var fragment = $(document.createDocumentFragment());
 		
	   	 $.each(datas.order,function(idx,order){
	   		 if(order.orderTime!=null){
	   		var count=0
   			var cell1 = $('<td></td>').text(order.orderID)
  		  	var cell2 = $('<td style="padding-left: 25px;"></td>').html("<img src='image/arrow-n.png'>")	  	
  		  	var cell3 = $('<td></td>').text(order.orderTime)	  
  		  	//console.log(datas.OrderDetails[idx]);
   			$.each(datas.OrderDetails[idx],function(idx,OrderDetails){
   				count=OrderDetails.buyingPrice+count
   			})
  		  	var cell4 = $('<td></td>').text(count)
  		  	var row = $('<tr class="parent" style="background-color:#f3ffc4"></tr>').append([cell1,cell2,cell3,cell4]);
					fragment.append(row);
   		 		//console.log(idx);
	   		 }
   	 		 }); 
   	  	$('#dev-table>tbody').html(fragment);
	   	 }else{
   	 		 $('#dev-table>tbody').html("沒有消費明細");
	   	 }
   	
  	  });
}
 /*收益課程*/
 
 
 $(document).ready(function () {
    $('.btn-filter').on('click', function () {
      var $target = $(this).data('target');
      
      if($target==="pagado"){
//     	  $('.table2 tbody tr').css('display', 'none');
 		$('.table2 tbody[data-status!="' + $target + '"]').css('display', 'none');
          $('.table2 tbody[data-status="' + $target + '"]').fadeIn('slow');
          $('.table2 thead[data-status="' + $target + '"]').fadeIn('slow');
          $('.table2 thead[data-status!="' + $target + '"]').css('display', 'none');
      }else if($target==="pendiente"){
    	 // $('.table2 tbody tr').css('display', 'none');
    	  $('.table2 tbody[data-status!="' + $target + '"]').css('display', 'none');
          $('.table2 tbody[data-status="' + $target + '"]').fadeIn('slow');
          $('.table2 thead[data-status="' + $target + '"]').fadeIn('slow');
          $('.table2 thead[data-status!="' + $target + '"]').css('display', 'none');
      }else if($target==="cancelado"){
//     	  $('.table2  tbody tr').css('display', 'none');
          $('.table2 tbody[data-status="' + $target + '"]').fadeIn('slow');
          $('.table2 tbody[data-status!="' + $target + '"]').css('display', 'none');
          $('.table2 thead[data-status="' + $target + '"]').fadeIn('slow');
          $('.table2 thead[data-status!="' + $target + '"]').css('display', 'none');
    }else if($target==="all"){
  	  //$('.table2 tbody').css('display', 'none');
  	   $('.table2 tbody[data-status!="' + $target + '"]').css('display', 'none');
        $('.table2 tbody[data-status="' + $target + '"]').fadeIn('slow');
        $('.table2 thead[data-status="' + $target + '"]').fadeIn('slow');
        $('.table2 thead[data-status!="' + $target + '"]').css('display', 'none');
    }
//       if ($target != 'all') {
//         $('.table tbody tr').css('display', 'none');
//         $('.table tr[data-status="' + $target + '"]').fadeIn('slow');
//       } else {
//         $('.table tbody tr').css('display', 'none').fadeIn('slow');
//       }
    });

 });
 var freeCourses;
 var fundraisingCourses;
 var onlineCourses;
 var CoursesNames;
 
 
 function loadCourse(memberID){
	 var fragment1 = $(document.createDocumentFragment());//all
	 var fragment2 = $(document.createDocumentFragment());//pagado
	 var fragment3 = $(document.createDocumentFragment());//pendiente
	 var fragment4 = $(document.createDocumentFragment());//cancelado
		$.getJSON('/e-Look/MemberIncomeController',{'MemberID':memberID},function(datas){
		   console.log(datas);
		   freeCourses=datas.freeCourse;
		   onlineCourses=datas.onlineCourse;
		   fundraisingCourses=datas.fundraisingCourse;
		   CoursesNames=datas.CourseName;
	 		if (freeCourses.length == 0 && fundraisingCourses.length==0&& onlineCourses.length==0) {
			$('#all').html("沒有課程收益");
			$('#pendiente').html("沒有免費課程收益");
			$('#cancelado').html("沒有募資課程收益");
			$('#pagado').html("沒有線上課程收益");
		} else {
				//免費課程
				if (freeCourses.length == 0) {
					$('#pendiente').html("沒有免費課程收益");
				} else {
					var count=0;
					$.each(freeCourses,function(idx,freeCourse){
						//console.log(freeCourse)
						
						$.each(freeCourse,function(idx,free){
							var cell1 = $('<td></td>').text(CoursesNames[idx])
							var cell2 = $('<td></td>').text(free.SponsorName)
				  		  	var cell3 = $('<td></td>').text(free.dateSponsor)
				  		  	count=free.money+count;
							var cell4 = $('<td></td>').text(free.money)
							var row =$('<tr></tr>').append([cell1,cell2,cell3,cell4]);
							fragment3.append(row);
							
						})						
					})
				$('#pendiente').html(fragment3);
					var cell1 = $('<td></td>').text("免費課程")
		  		  	var cell2 = $('<td></td>').text(count)
		  		 	var row1 =$('<tr></tr>').append([cell1,cell2]);
					fragment1.append(row1)
				}
				//募資課程
				if (fundraisingCourses.length == 0) {
					$('#cancelado').html("沒有募資課程收益");
				} else {
					var count=0;
					$.each(fundraisingCourses,function(idx,fundraisingCourse){
						//console.log(fundraisingCourse)
						//console.log(fundraisingCourse[0].buyingPrice)
							var cell1 = $('<td></td>').text(fundraisingCourse[0].courseVO.courseName)
							$.each(fundraisingCourse,function(idx,fund){
								count=fund.buyingPrice*0.56+count;
							})
							
							var cell2 = $('<td></td>').text(fundraisingCourse[0].buyingPrice)
				  		  	var cell3 = $('<td></td>').text(fundraisingCourse.length)
							var cell4 = $('<td></td>').text(Math.round(fundraisingCourse[0].buyingPrice*fundraisingCourse.length*0.56))
							var row =$('<tr></tr>').append([cell1,cell2,cell3,cell4]);
							fragment4.append(row);
					})
					$('#cancelado').html(fragment4);
					var cell1 = $('<td></td>').text("募資課程")
		  		  	var cell2 = $('<td></td>').text(Math.ceil(count))
		  		 	var row1 =$('<tr></tr>').append([cell1,cell2]);
					fragment1.append(row1)
				}
				
				
				//線上課程
				if (onlineCourses.length == 0) {
					$('#pagado').html("沒有線上課程收益");
				} else {
					var count=0;
					$.each(onlineCourses,function(idx,onlineCourse){
						//console.log(onlineCourse[0].buyingPrice)
						//console.log(fundraisingCourse[0].buyingPrice)
							var cell1 = $('<td></td>').text(onlineCourse[0].courseVO.courseName)
							$.each(onlineCourse,function(idx,online){
								count=online.originalPrice*0.8+count;
								
							})
							
							var cell2 = $('<td></td>').text(onlineCourse[0].buyingPrice)
				  		  	var cell3 = $('<td></td>').text(onlineCourse.length)
							var cell4 = $('<td></td>').text(Math.round(onlineCourse[0].buyingPrice*onlineCourse.length*0.8))
							var row =$('<tr></tr>').append([cell1,cell2,cell3,cell4]);
							fragment2.append(row);
					})
					console.log(count);
					$('#pagado').html(fragment2);
					var cell1 = $('<td></td>').text("線上課程")
		  		  	var cell2 = $('<td></td>').text(Math.ceil(count))
		  		 	var row1 =$('<tr></tr>').append([cell1,cell2]);
					fragment1.append(row1)
					
				}
				
				
				$('#all').html(fragment1);
			}
		});
		

		
		
}
		
		
		
		
	
		  
	
</script>

</body>
</html>