<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.e_Look.eLookEvent.*"%>
<%
	eLookEventService eLookEventSvc = new eLookEventService();
	List<eLookEventVO> list = eLookEventSvc.getAll();
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="css/button.css">
    <link rel="stylesheet" href="css/jdialog.min.css">
    <link rel="stylesheet" href="css/jquery-ui.min.css">
  <script src="js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
  <script src="js/jdialog.min.js" type="text/javascript"></script>
<link rel="Short Icon" type="image/x-icon" href="${initParam.icon}" />
<title>eLook後台管理系統</title>
<style type="text/css">
#delete{width: 200px;
height: 300px;
}
#div3{padding-left: 90px;
padding-bottom: 5px;}  
#div4{padding-left:1290px;
padding-bottom: 5px;}  
</style>
</head>
<body>
	<jsp:include page="backheader.jsp"></jsp:include>
				
<section id="wrapper">
						<header>
							<div class="inner">
								<h2>活動管理</h2>
								
							</div>
						</header>
						</section> 
	<table class="container">
	<thead>
		<tr>
			<th><h1>活動編號</h1></th>
			<th><h1>活動名稱</h1></th>
			<th><h1>開始日期</h1></th>
			<th><h1>結束日期</h1></th>
			<th><h1>折扣優惠</h1></th>
			<th><h1>優惠類別</h1></th>
			<th><h1>編輯</h1></th>
		</tr>
	</thead>
	<tbody>
<c:forEach var="eLookEventVO" items="${list}"> 
					<tr>
						<td>${eLookEventVO.eventID}</td>
						<td>${eLookEventVO.eventName}</td>
						<td>${eLookEventVO.eStartDate}</td>
						<td>${eLookEventVO.eEndDate}</td>
						<td>${eLookEventVO.discount}</td>
						<td>${eLookEventVO.courseClass1}&ensp;${eLookEventVO.courseClass2}&ensp;${eLookEventVO.courseClass3}</td>
						<td>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/backstage/elookeventinsert"
								style="display: inline;">
								<input type="button"   name="update" class="button cyan alt" data-toggle="JDialog" data-target="update" value="修改"> 
								<input type="hidden" name="eventID" value="${eLookEventVO.eventID}">
								<input type="button" name="delete"  class="button red alt" data-toggle="JDialog" data-target="delete"  value="刪除">  
							</FORM> 
						</td>
					</tr>
				</c:forEach>
	</tbody>
	
					<form METHOD="post"	ACTION="<%=request.getContextPath()%>/backstage/elookeventinsert"   >
				<tr>
					<td></td>
					<td><input type="text" name="eventName" value="${ErrMsg.errName}" class="inputtext"></td>
					<td><input type="text" name="eStartDate" id="thedate" value="${ErrMsg.errStartDate}" class="inputtext thedate" readonly="readonly"></td>
					<td><input type="text" name="eEndDate" id="thedate2" value="${ErrMsg.errEndDate}" class="inputtext thedate2" readonly="readonly"> </td>
					<td><input type="text" name="discount"value="${ErrMsg.errCount}" class="inputtext"></td>
					<td><select class="font courseclass"
						name="courseClass1">
							<option value="null">無</option>
							<option value="全部">全部</option>
							<option value="生活">生活</option>
							<option value="運動">運動</option>
							<option value="影音">影音</option>
							<option value="手作">手作</option>
							<option value="其他">其他</option>
							<option value="設計">設計</option>
							<option value="科技">科技</option>
							<option value="商業">商業</option>
							<option value="語言">語言</option>
							<option value="烹飪">烹飪</option>
							<option value="程式">程式</option>
							<option value="藝術">藝術</option>
					</select>&ensp;<select class="font courseclass" name="courseClass2">
							<option value="null">無</option>
							<option value="全部">全部</option>
							<option value="生活">生活</option>
							<option value="運動">運動</option>
							<option value="影音">影音</option>
							<option value="手作">手作</option>
							<option value="其他">其他</option>
							<option value="設計">設計</option>
							<option value="科技">科技</option>
							<option value="商業">商業</option>
							<option value="語言">語言</option>
							<option value="烹飪">烹飪</option>
							<option value="程式">程式</option>
							<option value="藝術">藝術</option>
					</select>&ensp;<select class="font courseclass" name="courseClass3">
							<option value="null">無</option>
							<option value="全部">全部</option>
							<option value="生活">生活</option>
							<option value="運動">運動</option>
							<option value="影音">影音</option>
							<option value="手作">手作</option>
							<option value="其他">其他</option>
							<option value="設計">設計</option>
							<option value="科技">科技</option>
							<option value="商業">商業</option>
							<option value="語言">語言</option>
							<option value="烹飪">烹飪</option>
							<option value="程式">程式</option>
							<option value="藝術">藝術</option>
					</select></td>
					<td><input type="submit" class="button green alt"   value="新增">
					<input type="hidden" name="action" value="insert">
					</td>	
				</tr>
			</form>
</table>		
			
			
			
			
			
			
						

<!-- 刪除訊息視窗 -->
<div  class="jDialog" id="delete">
    <div class="content">
        <header>
            <p>警告</p>
        </header>
        <div class="content">
            <p>是否刪除此活動?</p>
        </div>
        <footer><div id="div3">
        <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/backstage/elookeventinsert" style="display: inline;">
        <input type="submit"  value="刪除" > 
        <input	type="hidden" name="eventID" id="deleteEventID" value="">
		<input type="hidden" name="action" value="delete"></FORM>
            <button type="button" data-dismiss="JDialog" class="btn primary" >取消</button></div>
        </footer>
    </div>
</div>  








<!--  修改訊息視窗  -->
<div class="jDialog" id="update" >
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/backstage/elookeventinsert" >
    <div class="content">
        <header>
            <h3>修改活動</h3>
        </header>
        
        <div class="content" id="updateDiv">
         
          <table>
          <thead>
				<tr>
			    	<td>活動編號</td>
					<td>活動名稱</td>
					<td>開始日期</td>
					<td>結束日期</td>
					<td>折扣優惠</td>
					<td>優惠類別</td>
				</tr>
			</thead>
			
          
          
				<tr>
				    <td id="td1"></td>
					<td><input type="text" name="eventName"  class="inputtext"></td>
					<td><input type="text" name="eStartDate"  class="inputtext thedate" readonly="readonly"></td>
					<td><input type="text" name="eEndDate" class="inputtext thedate2" readonly="readonly"> </td>
					<td><input type="text" name="discount" class="inputtext"></td>
					<td><select class="font courseclass"
						name="courseClass1">
							<option value="null">無</option>
							<option value="全部">全部</option>
							<option value="生活">生活</option>
							<option value="運動">運動</option>
							<option value="影音">影音</option>
							<option value="手作">手作</option>
							<option value="其他">其他</option>
							<option value="設計">設計</option>
							<option value="科技">科技</option>
							<option value="商業">商業</option>
							<option value="語言">語言</option>
							<option value="烹飪">烹飪</option>
							<option value="程式">程式</option>
							<option value="藝術">藝術</option>
					</select>&ensp;<select class="font courseclass" name="courseClass2">
							<option value="null">無</option>
							<option value="全部">全部</option>
							<option value="生活">生活</option>
							<option value="運動">運動</option>
							<option value="影音">影音</option>
							<option value="手作">手作</option>
							<option value="其他">其他</option>
							<option value="設計">設計</option>
							<option value="科技">科技</option>
							<option value="商業">商業</option>
							<option value="語言">語言</option>
							<option value="烹飪">烹飪</option>
							<option value="程式">程式</option>
							<option value="藝術">藝術</option>
					</select>&ensp;<select class="font courseclass" name="courseClass3">
							<option value="null">無</option>
							<option value="全部">全部</option>
							<option value="生活">生活</option>
							<option value="運動">運動</option>
							<option value="影音">影音</option>
							<option value="手作">手作</option>
							<option value="其他">其他</option>
							<option value="設計">設計</option>
							<option value="科技">科技</option>
							<option value="商業">商業</option>
							<option value="語言">語言</option>
							<option value="烹飪">烹飪</option>
							<option value="程式">程式</option>
							<option value="藝術">藝術</option>
					</select></td>
				</tr>
			</table>
        </div>
        <footer><div id="div4">
        <input type="submit" class="button blue alt" value="儲存" > 
        <input type="hidden" name="eventID" id="updateEventID" value="">
		<input type="hidden" name="action" value="update1">
            &nbsp;<input type="button" data-dismiss="JDialog" class="btn primary button red alt" value="取消"></input>
            </div>
        </footer>
          
    </div>
     </FORM>
</div>  


<!-- 彈跳窗 -->

<script>		
$("#delete").jDialog({
    skinClassName: 'demo',
    allowOverlay: true,
    animationType: 'flip'
});     

$("#update").jDialog({
    skinClassName: 'demo',
    allowOverlay: true,
    animationType: 'flip'
});      
		
			
		//抓取delete該行id	
		$('tbody input[name="delete"]').on('click',function(){
		var event1=$(this).parent().children('input:eq(1)').val();
		$('#deleteEventID').val(event1);
		})			

		$('tbody input[name="update"]').on('click',function(){
			var event2=$(this).parent().children('input:eq(1)').val();
			$('#updateEventID').val(event2);
		$('#td1').text(event2);
		})	
	
		
	  var today = new Date();
	  var tomorrow = new Date(today.getTime() + 24 * 60 * 60 * 1000);

	  $('.thedate2').datepicker();
	  $('.thedate').datepicker({
	    //minDate: 0, //從今天後日期才可選
	    minDate: tomorrow, //從明天日期才可選
	    onSelect: function (dat, inst) {
	      $('.thedate2').datepicker('option', 'minDate', dat);
	    }
	  });


	$.datepicker.setDefaults({ dateFormat: 'yy-mm-dd' }); //全局設置日期格式

	
</script> 

			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
</body>
</html>