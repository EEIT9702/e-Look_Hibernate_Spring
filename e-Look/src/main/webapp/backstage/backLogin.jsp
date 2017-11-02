<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Short Icon" type="image/x-icon" href="${initParam.icon}" />
	<title>eLook後台管理系統</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<style>
li{color: #ffffff;}
input[type="text"],
	input[type="password"]{border:	#5b6ba6 2px solid;}
	input[type="submit"]{	-moz-appearance: none;
		-webkit-appearance: none;
		-ms-appearance: none;
		appearance: none;
		-moz-transition: background-color 0.2s ease-in-out;
		-webkit-transition: background-color 0.2s ease-in-out;
		-ms-transition: background-color 0.2s ease-in-out;
		transition: background-color 0.2s ease-in-out;
		background-color: transparent;
		border-radius: 5px;
		border: 0;
		box-shadow: inset 0 0 0 2px rgba(255, 255, 255, 0.125);
		color: #ffffff !important;
		cursor: pointer;
		display: inline-block;
		font-family: Raleway, Helvetica, sans-serif;
		font-size: 0.8em;
		font-weight: 700;
		height: 3.75em;
		letter-spacing: 0.1em;
		line-height: 3.75em;
		padding: 0 2.25em;
		text-align: center;
		text-decoration: none;
		text-transform: uppercase;
		white-space: nowrap;}
	
	</style>
	<body>

		<!-- Page Wrapper -->
			<div id="page-wrapper">

				<!-- Header -->
					<header id="header" class="alt">

						<nav>
							<a href="#menu">登入</a>
						</nav>
					</header>

				<!-- Menu -->
					<nav id="menu">
						<div class="inner">
						<FORM METHOD="post"ACTION="<%=request.getContextPath()%>/backstage/login" style="display: inline;">
							<h2>登入</h2>
							<ul class="links">
								<li>帳號:<input type="text" name="managerID"></li>
								<br>
								<li>密碼:<input type="password" name=mPassword></li>
							<li><li>
							</ul>
							<input type="submit" value="登入">
							<input type="hidden"name="action" value="login">
							<a href="#" class="close">Close</a>
						</FORM></div>
					</nav>

				<!-- Banner -->
					<section id="banner">
						<div class="inner">
							<div class="logo"><span class="icon fa fa-eye fa-5x"></span></div>
							<h2>e-LOOK後台管理系統</h2>
							<p>請先登入會員<a href="#menu">Login</a></p>
							<p>${ErrMsg.errID}${ErrMsg.errpw}<p>
						</div>
					</section>

				
			</div>

		<!-- Scripts -->
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
<script type="text/javascript">

</script>
	</body>
</html>