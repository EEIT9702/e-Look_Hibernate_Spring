<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page import="com.e_Look.member.model.MemberVO" %>
<% 
HttpSession sess= request.getSession(); 
MemberVO memberVO=(MemberVO) sess.getAttribute("LoginOK");
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
		float: left;
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
		float: left;
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
	margin-bottom: 20px !important;
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
</style>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</head>
<body>
	<jsp:include page="${contextPath}/login.jsp" flush="true" />
	<div class="container" style="margin-top: 50px">
		<div class="row">
			<section>
			<div class="wizard">
				<div class="wizard-inner">
					<div class="connecting-line"></div>
					<ul type="" class="nav nav-tabs" role="tablist">

						<li role="presentation" class="active"><a href="#step1"
							data-toggle="tab" aria-controls="step1" role="tab" title="Step 1">
								<span class="round-tab"> <i
									class="glyphicon glyphicon-list-alt"></i>
							</span>
						</a></li>

						<li role="presentation" class="disabled"><a href="#step2"
							data-toggle="tab" aria-controls="step2" role="tab" title="Step 2">
								<span class="round-tab"> <i
									class="glyphicon glyphicon-usd"></i>
							</span>
						</a></li>
						<li role="presentation" class="disabled"><a href="#step3"
							data-toggle="tab" aria-controls="step3" role="tab" title="Step 3">
								<span class="round-tab"> <i
									class="glyphicon glyphicon-ok"></i>
							</span>
						</a></li>

					</ul>
				</div>
				<form class="form-horizontal">
					<div class="tab-content">
						<!-- step1start -->
						<div class="tab-pane active" role="tabpanel" id="step1">
							<div class="container">
								<div class="row">

									<div class="span12">
										<ul class="thumbnails">
											<li class="span5 clearfix">
												<div class="thumbnail clearfix">
													<img src="<%=request.getContextPath()%>/img/02.jpg"
														alt="ALT NAME" class="pull-left span2 clearfix"
														style='margin-right: 10px'>
													<div class="caption" class="pull-left">
														<button 
															class="btn btn-danger icon  pull-right">刪除</button>
														<h4>
															<a href="<%=request.getContextPath()%>/onlineCourse-v2.jsp?courseID=200001">在這裡顯示課程名稱</a>
														</h4>
														<small><b>課程類別,課程類別</b></small>
													</div>
												</div>
											</li>
											<li class="span5 clearfix">
												<div class="thumbnail clearfix">
													<img src="<%=request.getContextPath()%>/img/預覽課程展示畫面.png"
														alt="ALT NAME" class="pull-left span2 clearfix"
														style='margin-right: 10px'>
													<div class="caption" class="pull-left">
														<a href="onlineCourse-v2.jsp?courseID=200002"
															class="btn btn-danger icon  pull-right">刪除</a>
														<h4>
															<a href="<%=request.getContextPath()%>/onlineCourse-v2.jsp?courseID=200001">在這裡顯示課程名稱</a>
														</h4>
														<small><b>課程類別,課程類別</b></small>
													</div>
												</div>
											</li>
											<li class="span5 clearfix">
												<div class="thumbnail clearfix">
													<img src="http://placehold.it/320x200" alt="ALT NAME"
														class="pull-left span2 clearfix"
														style='margin-right: 10px'>
													<div class="caption" class="pull-left">
														<a href="onlineCourse-v2.jsp?courseID=200003"
															class="btn btn-danger icon  pull-right">刪除</a>
														<h4>
															<a href="<%=request.getContextPath()%>/onlineCourse-v2.jsp?courseID=200001">在這裡顯示課程名稱</a>
														</h4>
														<small><b>課程類別,課程類別</b></small>
													</div>
												</div>
											</li>
											<li class="span5 clearfix">
												<div class="thumbnail clearfix">
													<img src="http://placehold.it/320x200" alt="ALT NAME"
														class="pull-left span2 clearfix"
														style='margin-right: 10px'>
													<div class="caption" class="pull-left">
														<a href="onlineCourse-v2.jsp?courseID=200004"
															class="btn btn-danger icon  pull-right">刪除</a>
														<h4>
															<a href="<%=request.getContextPath()%>/onlineCourse-v2.jsp?courseID=200001">在這裡顯示課程名稱</a>
														</h4>
														<small><b>課程類別,課程類別</b></small>
													</div>
												</div>
											</li>
											<li class="span5 clearfix">
												<div class="thumbnail clearfix">
													<img src="http://placehold.it/320x200" alt="ALT NAME"
														class="pull-left span2 clearfix"
														style='margin-right: 10px'>
													<div class="caption" class="pull-left">
														<a href="onlineCourse-v2.jsp?courseID=200005"
															class="btn btn-danger icon  pull-right">刪除</a>
														<h4>
															<a href="<%=request.getContextPath()%>/onlineCourse-v2.jsp?courseID=200001">在這裡顯示課程名稱</a>
														</h4>
														<small><b>課程類別,課程類別</b></small>
													</div>
												</div>
											</li>
											<li class="span5 clearfix">
												<div class="thumbnail clearfix">
													<img src="onlineCourse-v2.jsp?courseID=200006"
														alt="ALT NAME" class="pull-left span2 clearfix"
														style='margin-right: 10px'>
													<div class="caption" class="pull-left">
														<a href="http://bootsnipp.com/"
															class="btn btn-danger icon  pull-right">刪除</a>
														<h4>
															<a href="<%=request.getContextPath()%>/onlineCourse-v2.jsp?courseID=200001">在這裡顯示課程名稱</a>
														</h4>
														<small><b>課程類別,課程類別</b></small>
													</div>
												</div>
											</li>
										</ul>



									</div>
								</div>
							</div>
							<div class="col-md-4 pull-right" style="margin-top: 20px">
								<button type="button"
									class="btn btn-primary pull-right next-step">前往填寫付款資訊</button>
							</div>
						</div>
						<!-- step1end -->
						<!-- step2start -->
						<!-- step2end -->
						<!-- step3start -->
						
						<div class="tab-pane" role="tabpanel" id="step3">
							<div class="container">
								<div class="row">
									<div
										class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
										<div class="row">
											<div class="col-xs-6 col-sm-6 col-md-6">
												<address>
													<strong>Elf Cafe</strong> <br> 2135 Sunset Blvd <br>
													Los Angeles, CA 90026 <br> <abbr title="Phone">P:</abbr>
													(213) 484-6829
												</address>
											</div>
											<div class="col-xs-6 col-sm-6 col-md-6 text-right">
												<p>
													<em>Date: 1st November, 2013</em>
												</p>
												<p>
													<em>Receipt #: 34522677W</em>
												</p>
											</div>
										</div>
										<div class="row">
											<div class="text-center">
												<h1>Receipt</h1>
											</div>

											<table class="table table-hover">
												<thead>
													<tr>
														<th>Product</th>
														<th>#</th>
														<th class="text-center">Price</th>
														<th class="text-center">Total</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td class="col-md-9"><em>Baked Rodopa Sheep Feta</em></td>
														<td class="col-md-1" style="text-align: center">2</td>
														<td class="col-md-1 text-center">$13</td>
														<td class="col-md-1 text-center">$26</td>
													</tr>
													<tr>
														<td class="col-md-9"><em>Lebanese Cabbage Salad</em></td>
														<td class="col-md-1" style="text-align: center">1</td>
														<td class="col-md-1 text-center">$8</td>
														<td class="col-md-1 text-center">$8</td>
													</tr>
													<tr>
														<td class="col-md-9"><em>Baked Tart with Thyme
																and Garlic</em></td>
														<td class="col-md-1" style="text-align: center">3</td>
														<td class="col-md-1 text-center">$16</td>
														<td class="col-md-1 text-center">$48</td>
													</tr>
													<tr>
														<td> </td>
														<td> </td>
														<td class="text-right">
															<p>
																<strong>Subtotal: </strong>
															</p>
															<p>
																<strong>Tax: </strong>
															</p>
														</td>
														<td class="text-center">
															<p>
																<strong>$6.94</strong>
															</p>
															<p>
																<strong>$6.94</strong>
															</p>
														</td>
													</tr>
													<tr>
														<td> </td>
														<td> </td>
														<td class="text-right"><h4>
																<strong>Total: </strong>
															</h4></td>
														<td class="text-center text-danger"><h4>
																<strong>$31.53</strong>
															</h4></td>
													</tr>
												</tbody>
											</table>
											<button type="button"
												class="btn btn-danger ">
												Pay Now   <span class="glyphicon glyphicon-chevron-right"></span>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
				</form>


			</div>
			</section>
		</div>
	</div>
<script>
//由於不需要用到 取消上方步驟按鈕功能
$('a[data-toggle="tab"]').on('show.bs.tab', function(e) {
		return false;
});

</script>
</body>
</html>