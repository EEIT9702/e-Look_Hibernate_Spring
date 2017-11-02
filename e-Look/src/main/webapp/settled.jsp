<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.e_Look.member.model.MemberVO"%>
<%
	HttpSession sess = request.getSession();
	MemberVO memberVO = (MemberVO) sess.getAttribute("LoginOK");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Short Icon" type="image/x-icon" href="${initParam.icon}" />
<title>${initParam.systemName}</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/css/bootstrap-datetimepicker.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/settled.css"
	rel="stylesheet">
<style>
.thumbnails>li {
	float: left;
	margin-bottom: 20px;
	margin-left: 20px;
}

.thumbnail>img {
	display: block;
	max-width: 100%;
	margin-left: auto;
	margin-right: auto;
	max-height: 74px;
	min-height: 74px;
}

.span2 {
	width: 104px;
}

@media ( max-width : 979px) and (min-width: 768px) {
	.span2 {
		width: 104px;
	}
}

@media ( min-width : 1200px) {
}

@media ( min-width : 1200px) and ( max-width:1500px) {
	[class*="span"] {
		min-height: 1px;
		margin: 0px 7%;
	}
	.span5 {
		width: 380px;
	}
}

@media ( min-width : 1500px) {
	.span5 {
		width: 470px;
	}
	[class*="span"] {
		min-height: 1px;
		margin: 0px 8%;
	}
}

.span5 {
	min-width: 380px;
}

@media ( max-width : 979px) and (min-width: 768px) {
	.span5 {
		width: 290px;
	}
}

@media ( max-width : 979px) and (min-width: 768px) {
	[class*="span"] {
		float: left;
		min-height: 1px;
		margin-left: 20px;
	}
}

.thumbnail {
	box-shadow: 1px 1px 9px 0px black;
}

ul {
	list-style-type: none;
}

.btn {
	margin-bottom: 5px !important;
}

.credit-card-box .panel-title {
	display: inline;
	font-weight: bold;
}

.credit-card-box label {
	display: block;
}

.credit-card-box .display-tr {
	display: table-row;
}

.credit-card-box .display-td {
	display: table-cell;
	vertical-align: middle;
	width: 70%;
}

.credit-card-box .panel-heading img {
	min-width: 180px;
}

.panel-body {
	padding: 30px !important;
}

.input-group input {
	margin: 0px 2px
}

.price {
	float: right;
	font-weight: bold;
}
</style>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</head>
<body>
	<jsp:include page="${contextPath}/login.jsp" flush="true" />
	<input id="gbmemberID" type="hidden" value="${LoginOK.memberID}" />
	<div class="container" style="margin-top: 50px">
		<div class="row">
			<section>
			<div class="wizard">
				<div class="wizard-inner">
					<div class="connecting-line"></div>
					<ul type="" class="nav nav-tabs" role="tablist">

						<li role="presentation" class="active"><a href="#step1"
							data-toggle="tab" aria-controls="step1" role="tab" title="確認訂單內容">
								<span class="round-tab"> <i
									class="glyphicon glyphicon-list-alt"></i>
							</span>
						</a></li>

						<li role="presentation" class="disabled"><a href="#step2"
							data-toggle="tab" aria-controls="step2" role="tab"
							title="前往歐付寶付款"> <span class="round-tab"> <i
									class="glyphicon glyphicon-usd"></i>
							</span>
						</a></li>
						<li role="presentation" class="disabled"><a href="#step3"
							data-toggle="tab" aria-controls="step3" role="tab" title="購買完成">
								<span class="round-tab"> <i
									class="glyphicon glyphicon-ok"></i>
							</span>
						</a></li>

					</ul>
				</div>
				<div class="tab-content">
					<!-- step1start -->
					<div class="tab-pane active" role="tabpanel" id="step1">
						<div class="container">
							<div class="row">

								<div class="span12">
									<ul class="thumbnails" id="showdetails">
										<!--  
											<li class="span5 clearfix">
												<div class="thumbnail clearfix">
													<img src="<%=request.getContextPath()%>/img/02.jpg"
														alt="ALT NAME" class="pull-left span2 clearfix"
														style='margin-right: 10px'>
													<div class="caption" >
														<button 
															class="btn btn-danger icon  pull-right">刪除</button>
														<h4>
															<a href="<%=request.getContextPath()%>/onlineCourse-v2.jsp?courseID=200001">在這裡顯示課程名稱</a>
														</h4>
														<small><b>課程類別,課程類別</b></small>
													</div>
												</div>
											</li>
											-->
									</ul>
								</div>
							</div>
						</div>
						<h4 id="total" class="text-right">總金額:8700元</h4>
						<div class="col-md-4 pull-right" style="margin-top: 20px">
							<form action="<%=request.getContextPath()%>/OrderoPayController"
								method="post">
								<button type="submit"
									class="btn btn-primary pull-right next-step">前往歐付寶結帳</button>
							</form>
						</div>
					</div>

				</div>
			</section>
		</div>
	</div>
	<script>
		$(function() {
			//由於不需要用到 取消上方步驟按鈕功能
			$('a[data-toggle="tab"]').on('show.bs.tab', function(e) {
				return false;
			});
			
			loadMemberOrder();
			function loadMemberOrder(){
				$('#showdetails').html('');
				var fg = $(document.createDocumentFragment());
				$.post('<%=request.getContextPath()%>/OrderEdit',{'action':'loading'},function(datas){
				var total = 0;
				var hasdata=0;
					$.each(datas,function(index,orderVO){
						var courseClass = getCourseClass(orderVO.courseVO.courseID);
						var cell1 = $('<li>').addClass('span5 clearfix');
						var cell2 = $('<div>').addClass('thumbnail clearfix');
						var cell3 = $('<img>').addClass('pull-left span2 clearfix').css('margin-right','10px').attr({'alt':'','src':'<%=request.getContextPath()%>/CourseImage?CourseID='+orderVO.courseVO.courseID});
						var cell4 = $('<div>').addClass('caption');
						var cell5 = $('<button>').addClass('btn btn-danger icon  pull-right').text('刪除').val(orderVO.courseVO.courseID).attr('type','button');
						var cell6 = $('<h4>')
						var cell7 = $('<a>').attr('href','<%=request.getContextPath()%>/onlineCourse-v2.jsp?courseID='+orderVO.courseVO.courseID).text(orderVO.courseVO.courseName);
						var cell8 = $('<small>');
						var cell9 = $('<b>').text(courseClass);
						var cell10 = $('<div>').addClass('text-right price').text('$ '+orderVO.buyingPrice+' 元')
						cell1.append(cell2);
						cell2.append([cell3,cell4]);
						cell4.append([cell5,cell6,cell8,cell10]);
						cell6.append(cell7);
						cell8.append(cell9);
						fg.append(cell1);
						hasdata++;
						total+=orderVO.buyingPrice;
					})
					$('#showdetails').append(fg);
					$('#total').text('總金額: '+total+' 元');
					if(hasdata==0){
						alert('請先選購商品'); 
						location.href='<%=request.getContextPath()%>';
					}
				},"json")
			}//loadMemberOrder end
			
			$('#showdetails').on('click','button',function(){
				var courseID=$(this).val();
				$.post('<%=request.getContextPath()%>/OrderEdit',{'action':'delete','courseID':courseID},function(data){
					loadMemberOrder();
				})
				
			})
			function getCourseClass(courseID){
				var courseClass="";
				$.ajax({'url':'<%=request.getContextPath()%>/GetCourseClass',
					'async' : false,
					'data' : {
						'courseID' : courseID
					},
					'success' : function(result) {
						courseClass = result;
					}
				});//$.ajax end
				return courseClass;
			}

		})
	</script>
</body>
</html>