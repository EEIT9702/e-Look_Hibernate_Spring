<%@page import="com.nimbusds.oauth2.sdk.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.e_Look.ad.*"%>
<%
	AdService svc = new AdService();
	List<AdVO> list = svc.getAll();
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/jquery-ui.min.css">
<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/button.css">
<link rel="stylesheet" href="css/jdialog.min.css">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery-ui.min.js" type="text/javascript" ></script>
<script src="js/jdialog.min.js" type="text/javascript"></script>
<script src="js/MODALit.min.js" type="text/javascript"></script>
<link rel="Short Icon" type="image/x-icon" href="${initParam.icon}" />
<title>eLook後台管理系統</title>
</head>
<style>
#div2 {
	margin: 0px auto;
}

img {
	width: 5em;
	height: 4em;
}

html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,
	blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,
	em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var,
	b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
	details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
	output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: middle;
}

#delete {
	width: 200px;
	height: 300px;
}

#div3 {
	padding-left: 90px;
	padding-bottom: 5px;
}

.div4 {
	padding-left: 1290px;
	padding-bottom: 5px;
}
</style>
<body>
	<jsp:include page="backheader.jsp"></jsp:include>

	<section id="wrapper">
		<header>
			<div class="inner">
				<h2>輪播管理</h2>

			</div>
		</header>
	</section>


	<div id="div1" style="margin-bottom: 100px;">

		<table class="container">
			<thead>
				<tr>
					<th>廣告編號</th>
					<th>廣告名稱</th>
					<th>顯示( 0：顯示 / 1：隱藏 )</th>
					<th>預覽</th>
					<th>管理</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="AdVO" items="${list}">
					<tr>
						<td align="center">${AdVO.adID}</td>
						<td align="center">${AdVO.fileName}</td>
						<td align="center">${AdVO.status}</td>
						<td align="center"><div id="div2"
								style="vertical-align: middle;">
								<img
									src="<%=request.getContextPath()%>/adImages?adID=${AdVO.adID}" />
							</div></td>
						<td align="center"><FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/backstage/elookeventinsert"
								style="display: inline;">
								<input type="button" name="update" class="button cyan alt"
									data-toggle="JDialog" data-target="update" value="修改">
								<input type="hidden" name="adID" value="${AdVO.adID}"> <input
									type="button" name="delete" class="button red alt"
									data-toggle="JDialog" data-target="delete" value="刪除">
							</FORM></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><input type="button" class="button green alt"
						data-toggle="JDialog" data-target="insert" value="新增"></td>
				</tr>
			</tfoot>
		</table>
	</div>

	<!-- 	新增彈跳窗 -->
	<div class="jDialog" id="insert">
		<FORM METHOD="post"
			ACTION="<%=request.getContextPath()%>/backstage/adControl"
			enctype="multipart/form-data" style="display: inline;">
			<div class="dialog">
				<header>
					<h3>新增</h3>
				</header>
				<div class="content">

					<table>
						<thead>
							<tr>

								<td>廣告名稱</td>
								<td>檔案上傳</td>
								<td>上架狀態</td>
							</tr>
						</thead>

						<tr>

							<td><input type="text" name="fileName"></td>
							<td><input type="file" name="adFile"></td>
							<td><select name="status">
									<option value="0">展示</option>
									<option value="1">隱藏</option>
							</select></td>
						</tr>
						<tfoot>
							<tr>

								<th>${errMsg.errName}</th>
								<th>${errMsg.adFile}</th>
								<th></th>
							</tr>
						</tfoot>

					</table>
				</div>
				<footer>
					<div class="div4">
						<input type="submit" value="新增"> <input type="hidden"
							name="action" value="insert"> <input type="button"
							data-dismiss="JDialog" class="btn primary close" value="取消">
					</div>
				</footer>
			</div>
		</FORM>
	</div>
	<!-- 修改訊息窗 -->
	<div class="jDialog" id="update">
		<FORM METHOD="post"
			ACTION="<%=request.getContextPath()%>/backstage/adControl"
			enctype="multipart/form-data" style="display: inline;">
			<div class="dialog">
				<header>
					<h3>修改</h3>
				</header>
				<div class="content">

					<table>
						<thead>
							<tr>
								<td>廣告編號</td>
								<td>廣告名稱</td>
								<td>檔案上傳</td>
								<td>上架狀態</td>

							</tr>
						</thead>

						<tr>
							<td id="td1"></td>
							<td><input type="text" name="fileName"></td>
							<td><input type="file" name="adFile"></td>
							<td><select name="status">
									<option value="0">展示</option>
									<option value="1">隱藏</option>
							</select></td>
						</tr>

						<tfoot>
							<tr>
								<th></th>
								<th>${errMsg.errName}</th>
								<th>${errMsg.adFile}</th>
								<th></th>
							</tr>
						</tfoot>

					</table>
				</div>
				<footer>
					<div class="div4">
						<input type="submit" value="修改"> <input type="hidden"
							name="adID" id="updateAdID" value=""> <input
							type="hidden" name="action" value="update"> <input
							type="button" data-dismiss="JDialog" class="btn primary "
							value="取消">
					</div>
				</footer>
			</div>
		</FORM>
	</div>

	<!-- 刪除訊息視窗 -->
	<div class="jDialog" id="delete">
		<div class="dialog">
			<header>
				<h3>警告</h3>
			</header>
			<div class="content">
				<p>是否刪除此廣告?</p>
			</div>
			<footer>
				<div id="div3">
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/backstage/adControl"
						enctype="multipart/form-data" style="display: inline;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="adID" id="deleteAdID" value=""> <input
							type="hidden" name="action" value="delete"> <input
							type="button" data-dismiss="JDialog" class="btn primary "
							value="取消"></input>
					</FORM>
				</div>
			</footer>
		</div>
	</div>

	<script>
		$("#delete").jDialog({
			skinClassName : 'demo',
			allowOverlay : true,
			animationType : 'flip'
		});

		$("#update").jDialog({
			skinClassName : 'demo',
			allowOverlay : true,
			animationType : 'flip'
		});
		$("#insert").jDialog({
			skinClassName : 'demo',
			allowOverlay : true,
			animationType : 'flip'
		});

		$('tbody input[name="update"]').on('click', function() {
			var event1 = $(this).parent().children('input:eq(1)').val();
			$('#updateAdID').val(event1);
			$('#td1').text(event1);

		})
		$('tbody input[name="delete"]').on('click', function() {
			var event2 = $(this).parent().children('input:eq(1)').val();
			$('#deleteAdID').val(event2);
		})
	</script>
	
	<script src="assets/js/jquery.scrollex.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
</body>
</html>