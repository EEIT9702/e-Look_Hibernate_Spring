<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="javax.servlet.http.HttpServletRequest,java.util.*,java.text.*,com.e_Look.message.model.*,com.e_Look.Course.*,com.e_Look.member.model.*,com.e_Look.buyCourse.model.*,javax.servlet.http.HttpSession"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/HeaderCssJs/jquery.js"></script>
<style>
#messageHeader{
border:1px solid black;border-radius:15px
}
#messageHeader>img{
width:50px;
}
</style>
</head>
<body>
   
	<div class="container">
		<div class="row">
			<div class="col-md-12" id="messageHeader">
				<div class="col-md-1">
					<img src="<%=request.getContextPath() %>/Image?MemberID=${LoginOK.memberID}" class="img-thumbnail pull-left">
				</div>
				<div class="col-md-11">

					<div>
						<span class="text-left">${LoginOK.mName}</span>
						
						<%
							Date dNow = new Date();
							SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							out.print("<span align=\"center\">" + ft.format(dNow) + "</span>");
						%>
						<div class="dropdown pull-right">
												<button class="btn dropdown-toggle btn-default "
													type="button" data-toggle="dropdown" style="height: 30px">
													<span class="glyphicon glyphicon-option-horizontal"></span>
												</button>
												
												<ul class="dropdown-menu">
												<form method="post" action="<%=request.getContextPath()%>/MessageController" >
													<li><a class="" href="#">檢舉</a></li>
													<li><a class="" href="#">修改</a></li>
 												 	<li><a class="" href="#">刪除</a></li>
 												</form>
												</ul>
												
											</div>

					</div>

					<div id="messageTable" style="border-bottom: 1px solid black">

						<p class="messageContent1">
						
							
							
						</p>
					</div>


					<div class="col-md-12">

						<div class="panel-group">
							<div class="panel">
								<div class="panel-heading">
									<h4 class="panel-title " style="padding-bottom: 10px">
										<a data-toggle="collapse" href="#collapse1">回應記錄</a>
									</h4>
								</div>
								<div id="collapse1" class="panel-collapse collapse ">
					<!--第一個回應 -->
									<div id=messageTable1>
										<div class="col-md-1">
											<img src="<%=request.getContextPath() %>/Image?MemberID=" class="img-thumbnail pull-left"
												>

										</div>
										<div class="col-md-11 " style="border-bottom: 1px solid black">
											<span>${LoginOK.mName}</span>
											<%
												out.print("<span align=\"center\">" + ft.format(dNow) + "</span>");
											%>
											<span class="pull-right"><a>檢舉</a></span>
											<p id=respondcontent>
											
											
											
											
											</p>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>


					<!-- 			<!--回應輸入表格-->
					<div class="col-md-12">
						<div class="panel-group">
							<div class="panel">
								<div class="panel-heading">
									<h4 class="panel-title ">
										<a data-toggle="collapse" href="#collapse2">我要回應</a>
									</h4>
								</div>
								<div id="collapse2" class="panel-collapse collapse ">
									<div>
										<p>內容:</p>
										<form action="" method="post">
											<div class="form-group">
												<textarea class="form-control" rows="5" id="comment"></textarea>
											</div>
											<div class="text-right">
												<input type="submit">
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
     <div style="width:10px;height:60px "></div>
		<div class="container">
        <div class="row">
			<div class="col-md-12" id="messageHeader">
				<p>
				
				<div>
	<!-- 				<input type="text" class="col-md-10" name="mContent" placeholder="留言內容"> -->
					<font color='red'>${errorMsgs}</font>
                    <font color='red'>${MessageInsertOK}</font>
				</div>
				  <form name="myForm">
                       <tr>
                        <td><input type="hidden" id="ProductID" name="action" value="insert"><span></span></td>
                        <td><input type="text" class="form-control" id="mContent" name="mContent" placeholder="留言內容"></td>
                        <td><input type="text" style="width:100px" class="form-control" id="UnitPrice" name="memberID" value="${LoginOK.memberID}" placeholder="${LoginOK.memberID}"></td>
                        <td><input type="text" style="width:100px" class="form-control" id="UnitsInStock" name="courseID" value=200001 placeholder="courseID"></td>
                        <td><button id="buttonAdd" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span></button>
                        <button id="buttonUpdate" type="button" class="btn btn-success"><span class="glyphicon glyphicon-edit"></span></button>
                        <button id="buttonAddRe" type="button" ><span class="glyphicon glyphicon-ok"></span></td>
                       </tr>
                   </form>			 
				
				</p>
					</div>  
					</div>
					</div>
	
		    
					
 	<script src="<%=request.getContextPath() %>/js/jquery-1.12.3.min.js"></script> 
 	<script src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script> 
	<script>
	 /*  courseID=$('#pp').attr('alt'); */
	  
    
	   
   	$(function(){
   		loadMessage(200001);
   	
   	//新增
		$('#buttonAdd').click(function() {

			var frm = $('form[name="myForm"]');
			//	console.log(frm.serialize());

			//	console.log(frm.serializeArray());
			$.post('/e-Look/_Ccc/MessageController', frm.serialize(), function(data) {
				
				loadMessage(200001);
				$('#messageTable>tfoot input').val("");
			});

			
		});
	
	

		  //讀取
	//	   courseID=$('input[name="courseID"]').value();
		   
		   function loadMessage(courseID){
			   $.getJSON('/e-Look/_Ccc/MessageController',{'action':'getOne_For_Display','courseID':courseID},function(datas){
				      //alert(datas);
			    	  console.log(datas)
			    	  var fragment = $(document.createDocumentFragment());
			    	  var fragment1 = $(document.createDocumentFragment());
			    	  $.each(datas,function(idx,messageVO1){
			    		 
			    		  /* var cell1 = $('<td></td>').text(messageVO1.messageID)
			    		  var cell2 = $('<td></td>').text(messageVO1.mContent)
			    		  var cell3 = $('<td></td>').text(messageVO1.mTime)
			    		  var cell4 = $('<td></td>').text(messageVO1.memberID)
			    		  var messageID_re=messageVO1.messageID_response
			    		  var cell5 = $('<td></td>').text(messageID_re)
			    		  var cell6 = $('<td></td>').text(messageVO1.courseID)
			    		  var cell7 = $('<td></td>').html('<button id="buttonAddRe" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span></button><button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span></button> <button type="button" class="btn btn-info"><span class="glyphicon glyphicon-pencil"></span></button>'); */
			    		  console.log(messageVO1.memberID)
			    		  var img = $('<img>').attr("src","<%=request.getContextPath() %>/Image?MemberID="+messageVO1.memberID) 
			    		  var cell1 = $('<div></div>').html(img)
			    		  var cell2 = $('<li></li>').text(messageVO1.mTime)
			    		  var cell3 = $('<li></li>').text(messageVO1.mContent)
			    		  var messageID_re=messageVO1.messageID_response
			    		  var cell4 = $('<li></li>').text(messageID_re)
			    		  
			    		  if(messageID_re>0){
			    		  /* var row = $('<tr></tr>').append([cell1,cell2,cell3,cell4,cell5,cell6,cell7]);
			    		  fragment1.append(row); */
			    		  var ul = $('<ul></ul>').append([cell1,cell2,cell3,cell4]);
			    		  fragment1.append(ul);
			    		  
			    		  $('#messageTable1 p').append(fragment1);  
			    		  
			    		  }else{
			    			  var ul = $('<ul></ul>').append([cell1,cell2,cell3,cell4]);
				    		  fragment.append(ul);
			    		  }
			    		  
			    		  
			    	  });
			    	  
			    	  $('#messageTable>p').html(fragment);  
		      	}) 
		   }
		   
		 })
		
		 
	</script>	  
</body>
</html>