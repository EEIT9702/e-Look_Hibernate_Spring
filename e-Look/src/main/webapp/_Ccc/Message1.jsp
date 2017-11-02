<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row" >
			<div class="col-md-2">
				<img src="imember_image.png"class="img-thumbnail" >
			</div>
			<div class="col-md-10">	
				<div>
					<span>name</span><span>time</span>
				</div>
				<form method="post" action="<%=request.getContextPath()%>/MessageController" >
				<div>
					<input type="text" class="col-md-10" name="mContent">
					<font color='red'>${errorMsgs}</font>
                    <font color='red'>${MessageInsertOK}</font>
				</div>
				    <input type="hidden" name="action" value="insert">
					<input type="submit" value="留言"><br>
					<input type="radio" name="update" value="message">修改留言
					<input type="radio" name="update" value="messageesponse">修改回應
					<input type="submit" value="修改">
				</form>
				
				<div class="panel-group">
					<div class="panel">
						<div class="panel-heading">
							<h4 class="panel-title ">
								<a data-toggle="collapse" href="#collapse1">回應記錄</a>
							</h4>
						</div>
						<div id="collapse1" class="panel-collapse collapse ">
							<ul class="list-group col-md-8">
								<li class="list-group-item col-md-12">One</li>
								<li class="list-group-item col-md-12">Two</li>
								<li class="list-group-item col-md-12">Three</li>
							</ul>
						</div>

					</div>
				</div>
				
				
				<!--回應輸入表格-->
				<div class="panel-group">
					<div class="panel">
						<div class="panel-heading">
							<h4 class="panel-title ">
								<a data-toggle="collapse" href="#collapse2">我要回應</a>
							</h4>
						</div>
						<div id="collapse2" class="panel-collapse collapse ">
							<div class="col-md-8">
								<p>內容:123</p>
								<form action="<%=request.getContextPath()%>/MessageController" medthod="post">
									<div class="form-group">
										<textarea class="form-control" rows="5" id="comment"></textarea>
									</div>
									
									<input type="submit">
									
									
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>